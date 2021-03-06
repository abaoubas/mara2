__author__ = 'abaoubas'

from django.conf.urls import patterns, url
from musicApp import views

urlpatterns = patterns('',
        url(r'^$', views.index, name='index'),
        url(r'^showusers', views.showusers,),
        url(r'^selectRecordings', views.musicServices_selectRecordings,),
        url(r'^selectEvents', views.musicServices_selectEvents,),
        url(r'^SelectRecordingsByGenre/(?P<genre_id>[0-9]+)',views.SelectRecordingsByGenre,),
        url(r'^SelectMusicInfo', views.musicServices_SelectMusicInfo,),
        url(r'^selectFileTypes', views.musicServices_selectFileTypes,),
        url(r'^selectGenre', views.musicServices_selectGenre,),
        url(r'^selectArtist', views.musicServices_selectArtist,),
        url(r'^SalesGetReviewRequest', views.SalesGetReviewRequest,),
        url(r'^salesGetCompletedRequest', views.salesGetCompletedRequest,),
        url(r'^GetNewRequests', views.GetNewRequests,),
        url(r'^NewRequest', views.NewRequest2,),
        url(r'^record/(?P<pk_recording_id>[0-9]+)', views.NewRequest,),
        url(r'^User_Home_Page', views.User_Home_Page,),
        url(r'^UserAcceptance/(?P<request_id>[0-9]+)', views.UserAcceptance,),
        url(r'^UserReject/(?P<request_id>[0-9]+)', views.UserReject,),
        url(r'^Manager_Home_Page', views.Manager_Home_Page,),
        url(r'^Mng_approve/(?P<requestId>[0-9]+)', views.Manager_approvement,),
        url(r'^GetUserHistory/(?P<userId>[0-9]+)', views.GetUserHistory,),
        url(r'^RejectRequest/(?P<request_id>[0-9]+)/(?P<emp_no>[0-9]+)', views.RejectRequest,),
        url(r'^PaidRequest/(?P<request_id>[0-9]+)/(?P<emp_no>[0-9]+)', views.PaidRequest,),
        url(r'^SetRequestPrices/(?P<request_id>[0-9]+)', views.SetRequestPrices,),
        url(r'^SalesGetReviewManagerApprovals', views.SalesGetReviewManagerApprovals,),
        url(r'^Sales_approval/(?P<requestId>[0-9]+)', views.Sales_approval,),
        url(r'^UserDownloads/(?P<requestId>[0-9]+)', views.UserDownloads,),
        url(r'^EditReq/(?P<requestId>[0-9]+)', views.EditReq,),
        url(r'^aboutCompany', views.aboutCompany),
        url(r'^info', views.info),
    )

