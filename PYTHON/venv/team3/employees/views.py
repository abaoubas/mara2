from django.http import HttpResponse
from django.shortcuts import render
from suds.client import Client
from django.shortcuts import render_to_response
from django.http import HttpResponseRedirect
from django.contrib import auth
from django.core.context_processors import csrf
from django.contrib.auth.forms import UserCreationForm
import urllib2
import base64
import json
from forms import MyRegistrationForm
from django.contrib.auth.decorators import login_required
from django.template import RequestContext
from django.utils.dateformat import DateFormat
from datetime import datetime

user_root = 'emp'


def login(request):
    c = {'user_root': user_root,
         'next': request.GET.get('next')}
    c.update(csrf(request))
    return render(request, 'users/login.html', c)


def auth_view(request):
    username = request.POST.get('username', '')
    password = request.POST.get('password', '')
    user = auth.authenticate(username=username, password=password)

    if user is not None:
        auth.login(request, user)
        if request.POST.get('next') is not None and request.POST.get('next') != 'None':
            return HttpResponseRedirect(request.POST.get('next'))
        else:
            return HttpResponseRedirect('/' + user_root + '/loggedin')
    else:
        return HttpResponseRedirect('/' + user_root + '/invalid')


def loggedin(request):
    return render(request,
                  'users/loggedin.html',
                  {'full_name': request.user.username, 'auth': request.user.is_authenticated, 'user_root': user_root})


def invalid_login(request):
    return render(request, 'users/invalid_login.html', {'user_root': user_root})


def logout(request):
    auth.logout(request)
    return render(request, 'users/logout.html', {'user_root': user_root})


def register_user(request):
    if request.method == 'POST':
        form = MyRegistrationForm(request.POST)
        if form.is_valid():
            if not (userExists(form.cleaned_data['username'])):
                # if the user does not exist
                return HttpResponseRedirect('/' + user_root + '/employ_not_found')

            # else save him
            java_result = java_insertEmp(form)

            if (java_result != None):
                form.save()
                return HttpResponseRedirect('/' + user_root + '/register_success')
            return HttpResponseRedirect('/' + user_root + '/register_failed')
    else:
        form = MyRegistrationForm()
    args = {}
    args.update(csrf(request))

    args['form'] = form
    args['user_root'] = user_root

    return render(request, 'users/register.html', args)


base_service_url = 'http://localhost:8080/Intranet_User_Services/'

javaClient_EmployeeServices = Client(base_service_url + 'EmployeeServices?WSDL')


def java_insertEmp(form):
    temp = javaClient_EmployeeServices.factory.create('employee')
    temp.username = form.cleaned_data['username']
    temp.password = form.cleaned_data['password1']
    temp.first_name = form.cleaned_data['first_name']
    temp.last_name = form.cleaned_data['last_name']
    temp.strBirthdate = DateFormat(datetime.combine(form.cleaned_data['strBirthdate'], datetime.min.time())).format(
        'Y-m-d')
    temp.gender = form.cleaned_data['gender']
    return javaClient_EmployeeServices.service.insertEmp(temp)


def register_success(request):
    return render(request, 'users/register_success.html', {'user_root': user_root})


def register_failed(request):
    return render(request, 'users/register_failed.html', {'user_root': user_root})


def employ_not_found(request):
    return render(request, 'users/employ_not_found.html', {'user_root': user_root})


def userExists(emp_no):
    # Get the data from the endpoint
    request = urllib2.Request("http://62.217.127.56/phprest/users/employees")
    username = 'admin'
    password = '1234'
    base64string = base64.encodestring('%s:%s' % (username, password)).replace('\n', '')
    request.add_header("Authorization", "Basic %s" % base64string)
    result = urllib2.urlopen(request)
    data = json.load(result)
    # check in the list it there is any dictionary with the appropriate username
    return next((x for x in data if x['emp_no'] == emp_no), None) is not None
