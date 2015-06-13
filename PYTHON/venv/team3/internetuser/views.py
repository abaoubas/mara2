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
from django.utils.dateformat import DateFormat
from datetime import datetime

from django.contrib.auth.decorators import login_required
from django.template import RequestContext

user_root = 'u'


base_service_url = 'http://localhost:8080/Internet_User_Services/'
javaClient_CustomerServices = Client(base_service_url + 'InsertUser?WSDL')
javaClient_GetUserServices = Client(base_service_url + 'GetUser?WSDL')

def login(request):
    c = {'user_root': user_root}
    c.update(csrf(request))

    return render(request, 'users/login.html', c)


def auth_view(request):
    username = request.POST.get('username', '')
    password = request.POST.get('password', '')
    user = auth.authenticate(username=username, password=password)

    if user is not None:
        auth.login(request, user)
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
         if userExists(form.cleaned_data['username']):
            # if the user does not exist
            return HttpResponseRedirect('/' + user_root + '/register_failed')

        # else save him
        java_result = java_insertUser(form)

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

def profile(request):
    return render(request,'users/profile.html',{'full_name': request.user.username, 'auth': request.user.is_authenticated, 'user_root': user_root})

def java_insertUser(form):

    temp = javaClient_CustomerServices.factory.create('users')
    temp.username = form.cleaned_data['username']
    temp.password = form.cleaned_data['password1']
    temp.first_name = form.cleaned_data['first_name']
    temp.last_name = form.cleaned_data['last_name']
    temp.strBirthdate = DateFormat(datetime.combine(form.cleaned_data['strBirthdate'], datetime.min.time())).format(
        'Y-m-d')
    temp.gender = form.cleaned_data['gender']
    temp.email = form.cleaned_data['email']
    temp.IBAN = form.cleaned_data['IBAN']

    return javaClient_CustomerServices.service.InsertUser(temp)


def register_success(request):
    return render(request, 'users/register_success.html', {'user_root': user_root})


def register_failed(request):
    return render(request, 'users/register_failed.html', {'user_root': user_root})



def userExists(username):
    return javaClient_GetUserServices.service.getUser(username) is not None


