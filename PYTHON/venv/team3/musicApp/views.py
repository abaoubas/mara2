import urllib2
import base64
import json

from django.http import HttpResponseRedirect, HttpResponse
from django.shortcuts import render
from suds.client import Client
from forms import CreateRequestForm, ManagerRequestForm, SalesRequestForm
from django.contrib.auth.decorators import login_required, user_passes_test
from django import template
register = template.Library()

javaClient_GetUserServices = Client('http://localhost:8080/Internet_User_Services/GetUser?WSDL')
javaClient_EmployeeServices = Client('http://localhost:8080/Intranet_User_Services/EmployeeServices?WSDL')

def index(request):
    return render(request, 'musicApp/index.html')

def isCustomer(user):
    return user and user.groups.filter(name='customer').count() != 0

def isSalesRep(user):
    return user and user.groups.filter(name='sales rep').count() != 0

def isSalesManager(user):
    return user and user.groups.filter(name='sales manager').count() != 0

def isStaff(user):
    return isSalesRep(user) or isSalesManager(user)

def currentCustomer(user):
    if not(isCustomer(user)):
        return None;
    return javaClient_GetUserServices.service.getUser(user.username)

def currentStaff(user):
    if not(isStaff(user)):
        return None;
    return javaClient_EmployeeServices.service.getEmp(user.username, user.password)



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


def musicServices_selectRecordings(request):
    results = soap_client_musicServices.service.SelectRecordings()
    context = {'results': results,}
    return render(request, 'musicApp/allrecordings.html', context)

def musicServices_selectEvents(request):
    result_events = soap_client_musicServices.service.selectEvents()
    context = {'results': result_events, }
    return render(request, 'musicApp/allevents.html', context)


def SelectRecordingsByGenre(request,genre_id):
    results = soap_client_musicServices.service.SelectRecordingsByGenre(genre_id)
    context = {'results': results,}
    return render(request, 'musicApp/allrecordings.html', context)

def musicServices_SelectMusicInfo(request):
    results = soap_client_musicServices.service.SelectMusicInfo()
    context = {'results': results, }
    return render(request, 'musicApp/allmusicinfo.html', context)

def musicServices_selectFileTypes(request):
    result_fileTypes = soap_client_musicServices.service.selectFileTypes()
    context = {'results': result_fileTypes, }
    return render(request, 'musicApp/allfiletypes.html', context)



def musicServices_selectGenre(request):
    results = soap_client_musicServices.service.selectGenre()
    context = {'results': results, }
    return render(request, 'musicApp/allGenre.html', context)


def musicServices_selectArtist(request):
    results = soap_client_musicServices.service.selectArtist()
    context = {'results': results, }
    return render(request, 'musicApp/allartist.html', context)


soap_client_salesManagerServices = Client('http://localhost:8080/Intranet_User_Services/SalesManagerServices?WSDL')


def SalesManagerGetReviewRequest(request):
    results = soap_client_salesManagerServices.service.SalesManagerGetReviewRequest()
    context = {'results': results, }
    return render(request, 'musicApp/requests_for_approval.html', context)


soap_client_salesEmployeeServices = Client('http://localhost:8080/Intranet_User_Services/SalesEmployeeServices?WSDL')

@login_required(login_url='/emp/login/')
@user_passes_test(isSalesRep, login_url='/emp/login/')
def GetNewRequests(request):
    results = soap_client_salesEmployeeServices.service.GetNewRequests()
    context = {'results': results, }
    return render(request, 'musicApp/new_requests.html', context)

@login_required(login_url='/emp/login/')
@user_passes_test(isSalesRep, login_url='/emp/login/')
def SalesGetReviewRequest(request):
    results = soap_client_salesEmployeeServices.service.salesGetReviewRequest()
    context = {'results': results, 'currentStaff': currentStaff(request.user) }
    return render(request, 'musicApp/requests_pending.html', context)

@login_required(login_url='/emp/login/')
@user_passes_test(isSalesRep, login_url='/emp/login/')
def salesGetCompletedRequest(request):
    results = soap_client_salesEmployeeServices.service.salesGetCompletedRequest()
    context = {'results': results, }
    return render(request, 'musicApp/requests_completed.html', context)

@login_required(login_url='/emp/login/')
@user_passes_test(isSalesRep, login_url='/emp/login/')
def GetAcceptedRequest(request):
    results = soap_client_salesEmployeeServices.service.GetAcceptedRequest()
    context = {'results': results, }
    return render(request, 'musicApp/requests_for_payment.html', context)

@login_required(login_url='/emp/login/')
@user_passes_test(isSalesRep, login_url='/emp/login/')
def SetRequestPrices(request, totalCost, discount, request_id, status ):
    results = soap_client_salesEmployeeServices.service.SetRequestPrices(totalCost, discount, request_id, status)
    context = {'results': results, }
    return render(request, 'musicApp/reject_request_success.html', context)

@login_required(login_url='/emp/login/')
@user_passes_test(isSalesRep, login_url='/emp/login/')
def GetUserHistory(request, userId):

    results =  soap_client_salesEmployeeServices.service.GetUserHistory(userId)
    context = {'results': results, }
    return render(request, 'musicApp/getUserHistory.html', context)

@login_required(login_url='/emp/login/')
@user_passes_test(isSalesRep, login_url='/emp/login/')
def RejectRequest(request,request_id,emp_no):

    results = soap_client_salesEmployeeServices.service.RejectRequest(request_id, emp_no)
    context = {'results': results, }
    return render(request, 'musicApp/reject_request_success.html', context)

@login_required(login_url='/emp/login/')
@user_passes_test(isSalesRep, login_url='/emp/login/')
def PaidRequest(request,request_id,emp_no):

    results = soap_client_salesEmployeeServices.service.PaidRequest(request_id, emp_no)
    context = {'results': results, }
    return render(request, 'musicApp/reject_request_success.html', context)

soap_client_UserServices = Client('http://localhost:8080/Intranet_User_Services/SalesRequests?WSDL')

@login_required(login_url='/u/login/')
@user_passes_test(isCustomer, login_url='/u/login/')
def NewRequest2(request):
    return NewRequest(request,None)


@login_required(login_url='/u/login/')
@user_passes_test(isCustomer, login_url='/u/login/')
def NewRequest(request,pk_recording_id):

    currentSong = soap_client_musicServices.service.ReturnIitialReqByRecId(pk_recording_id)


    """
    if pk_recording_id:
        if request.method == 'GET':
            form = CreateRequestForm(recording=currentSong)
    else:
    """
    if request.method == 'GET':
        form = CreateRequestForm(recording=currentSong)
    else:
        requeststaff = soap_client_UserServices.factory.create('initialRequests')
        form = CreateRequestForm(request.POST, recording=currentSong)
        if form.is_valid():
            requeststaff.fk_user_id = currentCustomer(request.user).user_id
            # dateInserted = form.cleaned_data['dateInserted']
            # dateModified = form.cleaned_data['dateModified']
            requeststaff.title = form.cleaned_data['title']
            requeststaff.album = form.cleaned_data['album']
            requeststaff.creator_name = form.cleaned_data['creator_name']
            requeststaff.singer_name = form.cleaned_data['singer_name']
            requeststaff.fk_file_type_id = form.cleaned_data['fk_file_type_id']
            requeststaff.fk_genre_id = form.cleaned_data['fk_genre_id']
            requeststaff.strCreation_date = form.cleaned_data['strcreation_date']
            result = soap_client_UserServices.service.newRequest(requeststaff)
            if result:
                return HttpResponseRedirect('/music/User_Home_Page')
            else:
                return HttpResponse("Request Not Created")
    return render(request, 'musicApp/Request_form.html', {'form': form, 'pk_recording_id' :pk_recording_id})


@login_required(login_url='/u/login/')
@user_passes_test(isCustomer, login_url='/u/login/')
def User_Home_Page(request):
    # print soap_client_UserServices
    user_id_Request = soap_client_UserServices.factory.create('userIdRequest')
    user_id_Request.user_id = currentCustomer(request.user).user_id;
    results = soap_client_UserServices.service.GetUserRequests(user_id_Request)
    context = {'results': results, }
    return render(request, 'musicApp/User_Home_Page.html', context)


@login_required(login_url='/u/login/')
@user_passes_test(isCustomer, login_url='/u/login/')
def UserAcceptance(request, request_id):
    UserAcceptanceRequest(request, request_id, True)


def UserReject(request, request_id):
    UserAcceptanceRequest(request, request_id, False)


def UserAcceptanceRequest(request, request_id, action):
    userAcceptanceArgs = soap_client_UserServices.factory.create('userAcceptanceArgs')
    userAcceptanceArgs.user_id =  currentCustomer(request.user).user_id
    userAcceptanceArgs.request_id = request_id
    userAcceptanceArgs.accept = action
    result = soap_client_UserServices.service.UserAcceptanceRequest(userAcceptanceArgs)
    if result:
        return HttpResponseRedirect('/music/User_Home_Page/')
    else:
        return HttpResponse("The acceptance request didn't commit")


@login_required(login_url='/emp/login/')
@user_passes_test(isSalesManager, login_url='/emp/login/')
def Manager_Home_Page(request):
    results = soap_client_salesManagerServices.service.SalesManagerGetReviewRequest()
    context = {'results': results, }
    return render(request, 'musicApp/Manager_Home_Page.html', context)

@login_required(login_url='/emp/login/')
@user_passes_test(isSalesManager, login_url='/emp/login/')
def Manager_approvement(request, requestId):
    if request.method == 'GET':
        results = soap_client_salesManagerServices.service.SalesManagerGetRequest(requestId)
        for result in results:
            form = ManagerRequestForm(
                initial={'request_id': result.request_id,

                         'fk_user_id': result.fk_user_id,

                         'fk_emp_no': result.fk_emp_no,

                         'dateInserted': result.dateInserted,

                         'dateModified': result.dateModified,

                         'totalCost': result.totalCost,

                         'discount': result.discount,

                         'finalCost': result.finalCost,

                         'status': result.status,

                         'title': result.title,

                         'album': result.album,

                         'creator_name': result.creator_name,

                         'singer_name': result.singer_name,

                         'fk_file_type_id': result.fk_file_type_id,

                         'fk_genre_id': result.fk_genre_id,

                         'creation_date': result.creation_date

                         }
            )
        return render(request, 'musicApp/Mng_req_approval.html', {'form': form, })
    else:
        form = ManagerRequestForm(request.POST)
        if form.is_valid():
            requeststaff = soap_client_salesManagerServices.factory.create('request')
            requeststaff.request_id = form.cleaned_data['request_id']
            requeststaff.fk_user_id = form.cleaned_data['fk_user_id']
            requeststaff.fk_emp_no = form.cleaned_data['fk_emp_no']
            requeststaff.dateInserted = form.cleaned_data['dateInserted']
            requeststaff.dateModified = form.cleaned_data['dateModified']
            requeststaff.totalCost = form.cleaned_data['totalCost']
            requeststaff.discount = form.cleaned_data['discount']
            requeststaff.finalCost = form.cleaned_data['finalCost']
            requeststaff.status = 21
            requeststaff.title = form.cleaned_data['title']
            requeststaff.album = form.cleaned_data['album']
            requeststaff.creator_name = form.cleaned_data['creator_name']
            requeststaff.singer_name = form.cleaned_data['singer_name']
            requeststaff.fk_file_type_id = form.cleaned_data['fk_file_type_id']
            requeststaff.fk_genre_id = form.cleaned_data['fk_genre_id']
            requeststaff.creation_date = form.cleaned_data['creation_date']
            result = soap_client_salesManagerServices.service.SalesManagerSetReviewRequest(requeststaff)
            return HttpResponseRedirect('/music/Manager_Home_Page/')


@login_required(login_url='/emp/login/')
@user_passes_test(isSalesRep, login_url='/emp/login/')
def SalesGetReviewManagerApprovals(request):
    results = soap_client_salesEmployeeServices.service.SalesGetReviewManagerApproval()
    context = {'results': results, }
    return render(request, 'musicApp/SalesReviewManagerApproval.html', context)

@login_required(login_url='/emp/login/')
@user_passes_test(isSalesRep, login_url='/emp/login/')
def Sales_approval(request, requestId):
    if request.method == 'GET':
        results = soap_client_salesManagerServices.service.SalesManagerGetRequest(requestId)
        for result in results:
            form = SalesRequestForm(
                initial={'request_id': result.request_id,

                         'fk_user_id': result.fk_user_id,

                         'fk_emp_no': result.fk_emp_no,

                         'dateInserted': result.dateInserted,

                         'dateModified': result.dateModified,

                         'totalCost': result.totalCost,

                         'discount': result.discount,

                         'finalCost': result.finalCost,

                         'status': result.status,

                         'title': result.title,

                         'album': result.album,

                         'creator_name': result.creator_name,

                         'singer_name': result.singer_name,

                         'fk_file_type_id': result.fk_file_type_id,

                         'fk_genre_id': result.fk_genre_id,

                         'creation_date': result.creation_date

                         }
            )
        return render(request, 'musicApp/Sales_req_approval.html', {'form': form, })
    else:
        form = SalesRequestForm(request.POST)
        if form.is_valid():
            requeststaff = soap_client_salesManagerServices.factory.create('request')
            requeststaff.request_id = form.cleaned_data['request_id']
            requeststaff.fk_user_id = form.cleaned_data['fk_user_id']
            requeststaff.fk_emp_no = form.cleaned_data['fk_emp_no']
            requeststaff.dateInserted = form.cleaned_data['dateInserted']
            requeststaff.dateModified = form.cleaned_data['dateModified']
            requeststaff.totalCost = form.cleaned_data['totalCost']
            requeststaff.discount = form.cleaned_data['discount']
            requeststaff.finalCost = form.cleaned_data['finalCost']
            requeststaff.status = 22
            requeststaff.title = form.cleaned_data['title']
            requeststaff.album = form.cleaned_data['album']
            requeststaff.creator_name = form.cleaned_data['creator_name']
            requeststaff.singer_name = form.cleaned_data['singer_name']
            requeststaff.fk_file_type_id = form.cleaned_data['fk_file_type_id']
            requeststaff.fk_genre_id = form.cleaned_data['fk_genre_id']
            requeststaff.creation_date = form.cleaned_data['creation_date']
            result = soap_client_salesEmployeeServices.service.SalesSetReviewRequest(requeststaff)
            return HttpResponseRedirect('/music/SalesGetReviewManagerApprovals/')

@login_required(login_url='/u/login/')
@user_passes_test(isCustomer, login_url='/u/login/')
def UserDownloads(request,requestId):
    # print soap_client_UserServices

    results = soap_client_musicServices.service.GetRequestRecordings(requestId)
    context = {'results': results,}
    return render(request, 'musicApp/UserDownloadReq.html', context)