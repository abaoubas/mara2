from django.http import HttpResponse
from django.shortcuts import render
from suds.client import Client


def index(request):
    return HttpResponse("Rango says Rango")


soap_client = Client('http://10.100.51.100:8080/lab3/UsersWS?WSDL')
def showusers(request):
   results = soap_client.service.showUsers()
   context = { 'results':results, }
   return render(request, 'allusers.html', context)


#soap_client_intranet = Client('http://localhost:8080/Intranet_User_Services/UserExists?WSDL')
#def userExists(request):
#   results = soap_client_intranet.service.userexist("Georgi")
#   return HttpResponse(results)


soap_client_musicServices = Client('http://localhost:8080/Intranet_User_Services/MusicServices?WSDL')
def musicServices_selectRecordings (request):
   results = soap_client_musicServices.service.SelectRecordings()
   context = { 'results':results, }
   return render(request, 'allrecordings.html', context)

