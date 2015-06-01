from django.http import HttpResponse
from django.shortcuts import render
from suds.client import Client
from musicApp.forms import CreateRequestForm
from datetime import date
from django import forms
import urllib2, base64, json

def index(request):
    return HttpResponse("Rango says Rango")


#soap_client = Client('http://10.100.51.100:8080/lab3/UsersWS?WSDL')
#def showusers(request):
#   results = soap_client.service.showUsers()
#   context = { 'results':results, }
#   return render(request, 'musicApp/allusers.html', context)

def showusers(request):
    request = urllib2.Request("http://62.217.127.56/phprest/index.php/users/users")
    username = 'admin'
    password = '1234'
    base64string = base64.encodestring('%s:%s' % (username, password)).replace('\n', '')
    request.add_header("Authorization", "Basic %s" % base64string)
    result = urllib2.urlopen(request)
    # print result.read()
    data = json.load(result)
    return HttpResponse(data)



soap_client_musicServices = Client('http://localhost:8080/Intranet_User_Services/MusicServices?WSDL')
def musicServices_selectRecordings (request):
   results = soap_client_musicServices.service.SelectRecordings()
   context = { 'results':results, }
   return render(request, 'musicApp/allrecordings.html', context)
def musicServices_selectEvents (request):
   results = soap_client_musicServices.service.selectEvents()
   context = { 'results':results, }
   return render(request, 'musicApp/allevents.html', context)
def musicServices_SelectMusicInfo (request):
   results = soap_client_musicServices.service.SelectMusicInfo()
   context = { 'results':results, }
   return render(request, 'musicApp/allmusicinfo.html', context)
def musicServices_selectFileTypes (request):
   results = soap_client_musicServices.service.selectFileTypes()
   context = { 'results':results, }
   return render(request, 'musicApp/allfiletypes.html', context)
def musicServices_selectGenre (request):
   results = soap_client_musicServices.service.selectGenre()
   context = { 'results':results, }
   return render(request, 'musicApp/allGenre.html', context)
def musicServices_selectArtist (request):
   results = soap_client_musicServices.service.selectArtist()
   context = { 'results':results, }
   return render(request, 'musicApp/allartist.html', context)


soap_client_salesManagerServices = Client('http://localhost:8080/Intranet_User_Services/SalesManagerServices?WSDL')
def SalesManagerGetReviewRequest(request):
   results = soap_client_salesManagerServices.service.SalesManagerGetReviewRequest()
   context = { 'results':results, }
   return render(request, 'musicApp/requests_for_approval.html', context)

soap_client_salesEmployeeServices = Client('http://localhost:8080/Intranet_User_Services/SalesEmployeeServices?WSDL')
def GetNewRequests(request):
   results = soap_client_salesEmployeeServices.service.GetNewRequests()
   context = { 'results':results, }
   return render(request, 'musicApp/new_requests.html', context)

def SalesGetReviewRequest(request):
   results = soap_client_salesEmployeeServices.service.salesGetReviewRequest()
   context = { 'results':results, }
   return render(request, 'musicApp/requests_for_approval.html', context)

def GetAcceptedRequest(request):
   results = soap_client_salesEmployeeServices.service.GetAcceptedRequest()
   context = { 'results':results, }
   return render(request, 'musicApp/requests_for_payment.html', context)


soap_client_UserServices = Client('http://localhost:8080/Intranet_User_Services/SalesRequests?WSDL')
def NewRequest(request):
   if request.method == 'GET':
         form = CreateRequestForm()
   else:
         requeststaff = soap_client_UserServices.factory.create('initialRequests')
         form = CreateRequestForm(request.POST)
         if form.is_valid():
            requeststaff.fk_user_id = form.cleaned_data['fk_user_id']
            #dateInserted = form.cleaned_data['dateInserted']
            #dateModified = form.cleaned_data['dateModified']
            requeststaff.title = form.cleaned_data['title']
            requeststaff.album = form.cleaned_data['album']
            requeststaff.creator_name = form.cleaned_data['creator_name']
            requeststaff.singer_name = form.cleaned_data['singer_name']
            requeststaff.fk_file_type_id = form.cleaned_data['fk_file_type_id']
            requeststaff.fk_genre_id = form.cleaned_data['fk_genre_id']
            requeststaff.strCreation_date = form.cleaned_data['strcreation_date']
            result = soap_client_UserServices.service.newRequest(requeststaff)
            if result:
               return HttpResponse("Request Created")
            else:
               return HttpResponse("Request Not Created")
   return render(request, 'musicApp/Request_form.html', {'form': form,})

#register = template.Library()

#@register.inclusion_tag('musicApp/User_Home_Page.html')
#def User_Home_Page(request):


#def get_category_list():
#    return {'cats': Category.objects.all()}
