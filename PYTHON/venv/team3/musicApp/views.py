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

soap_client_musicServices = Client('http://localhost:8080/Intranet_User_Services/MusicServices?WSDL')
def musicServices_selectRecordings (request):
   results = soap_client_musicServices.service.SelectRecordings()
   context = { 'results':results, }
   return render(request, 'allrecordings.html', context)
def musicServices_selectEvents (request):
   results = soap_client_musicServices.service.selectEvents()
   context = { 'results':results, }
   return render(request, 'allevents.html', context)
def musicServices_SelectMusicInfo (request):
   results = soap_client_musicServices.service.SelectMusicInfo()
   context = { 'results':results, }
   return render(request, 'allmusicinfo.html', context)
def musicServices_selectFileTypes (request):
   results = soap_client_musicServices.service.selectFileTypes()
   context = { 'results':results, }
   return render(request, 'allfiletypes.html', context)
def musicServices_selectGenre (request):
   results = soap_client_musicServices.service.selectGenre()
   context = { 'results':results, }
   return render(request, 'allGenre.html', context)
def musicServices_selectArtist (request):
   results = soap_client_musicServices.service.selectArtist()
   context = { 'results':results, }
   return render(request, 'allartist.html', context)


soap_client_salesManagerServices = Client('http://localhost:8080/Intranet_User_Services/SalesManagerServices?WSDL')
def SalesManagerGetReviewRequest(request):
   results = soap_client_salesManagerServices.service.SalesManagerGetReviewRequest()
   context = { 'results':results, }
   return render(request, 'requests_for_approval.html', context)

soap_client_salesEmployeeServices = Client('http://localhost:8080/Intranet_User_Services/SalesEmployeeServices?WSDL')
def GetNewRequests(request):
   results = soap_client_salesEmployeeServices.service.GetNewRequests()
   context = { 'results':results, }
   return render(request, 'new_requests.html', context)

def SalesGetReviewRequest(request):
   results = soap_client_salesEmployeeServices.service.salesGetReviewRequest()
   context = { 'results':results, }
   return render(request, 'requests_for_approval.html', context)