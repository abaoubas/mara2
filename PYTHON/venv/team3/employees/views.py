from django.http import HttpResponse
from django.shortcuts import render
from suds.client import Client
from django.shortcuts import render_to_response
from django.http import HttpResponseRedirect
from django.contrib import auth
from django.core.context_processors import csrf
from django.contrib.auth.forms import UserCreationForm
import urllib2, base64, json
from forms import MyRegistrationForm
from forms import UserProfileForm
from django.contrib.auth.decorators import login_required
from django.template import RequestContext

def login(request):
    c = {}
    c.update(csrf(request))
    return render(request,'users/login.html', c)

def auth_view(request):
    username = request.POST.get('username', '')
    password = request.POST.get('password', '')
    user = auth.authenticate(username=username, password=password)

    if user is not None:
        auth.login(request, user)
        return HttpResponseRedirect('/emp/loggedin')
    else:
        return HttpResponseRedirect('/emp/invalid')


def loggedin(request):
    return render(request,
                  'users/loggedin.html',
                  {'full_name': request.user.username, 'auth': request.user.is_authenticated})


def invalid_login(request):
    return render(request,'users/invalid_login.html')


def logout(request):
    auth.logout(request)
    return render(request,'users/logout.html')


def register_user(request):
    if request.method == 'POST':
        form = UserCreationForm(request.POST)
        if form.is_valid():
            if not (userExists(form.cleaned_data['username'])):
                # if the user does not exist
                return HttpResponseRedirect('/emp/register_failed')

            # else save him
            java_result = java_insertEmp(form.cleaned_data['username'])

            if(java_result != None) :
                form.save()
                return HttpResponseRedirect('/emp/register_success')
            return HttpResponseRedirect('/emp/register_failed')
    else:
        form = UserCreationForm()
    args = {}
    args.update(csrf(request))

    args['form'] = form

    return render(request,'users/register.html', args)




base_service_url = 'http://localhost:8080/Intranet_User_Services/'

javaClient_EmployeeServices = Client(base_service_url + 'EmployeeServices?WSDL')
def java_insertEmp(username):
    print javaClient_EmployeeServices
    temp = javaClient_EmployeeServices.factory.create('employee')
    temp.username = username
    temp.password = 'pass'
    temp.first_name = 'first'
    temp.last_name = 'last_name'
    temp.strBirthdate = '2015-01-01'
    temp.gender = 'male'
    return javaClient_EmployeeServices.service.insertEmp(temp)



def register_success(request):
    return render(request,'users/register_success.html')


def register_failed(request):
    return render(request,'users/register_failed.html')

def userExists(emp_no):
    # Get the data from the endpoint
    request = urllib2.Request("http://62.217.127.56/phprest/index.php/users/users")
    username = 'admin'
    password = '1234'
    base64string = base64.encodestring('%s:%s' % (username, password)).replace('\n', '')
    request.add_header("Authorization", "Basic %s" % base64string)
    result = urllib2.urlopen(request)
    data = json.load(result)
    # check in the list it there is any dictionary with the appropriate username
    return next((x for x in data if x['emp_no'] == emp_no), None) is not None



@login_required
def user_profile(request):
    if request.method == 'POST':
        form = UserProfileForm(request.POST, instance=request.user.profile)
        if form.is_valid():
            form.save()
            return HttpResponseRedirect('/emp/loggedin')
    else:
        user = request.user
      #  profile = user.profile
     #   form = UserProfileForm(instance=profile)

    args = {}
    args.update(csrf(request))

    args['form'] = form

    return render(request,'emp/profile.html', args)
