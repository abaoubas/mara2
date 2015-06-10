__author__ = 'abaoubas'

from django.conf.urls import patterns, url
from musicApp import views

urlpatterns = patterns('',
        url(r'^$', views.index, name='index'),
        url(r'^showusers', views.showusers,),
        url(r'^selectRecordings', views.musicServices_selectRecordings,),
        url(r'^selectEvents', views.musicServices_selectEvents,),
        url(r'^SelectRecordingsByGenre(?P<genre_id>[0-9]+)',views.SelectRecordingsByGenre,),
        url(r'^SelectMusicInfo', views.musicServices_SelectMusicInfo,),
        url(r'^selectFileTypes', views.musicServices_selectFileTypes,),
        url(r'^selectGenre', views.musicServices_selectGenre,),
        url(r'^selectArtist', views.musicServices_selectArtist,),
        url(r'^SalesManagerGetReviewRequest', views.SalesManagerGetReviewRequest,),
        url(r'^SalesGetReviewRequest', views.SalesGetReviewRequest,),
        url(r'^GetNewRequests', views.GetNewRequests,),
        url(r'^GetAcceptedRequest', views.GetAcceptedRequest,),
        url(r'^NewRequest', views.NewRequest,),
        url(r'^record/(?P<pk_recording_id>[0-9]+)', views.NewRequest,),
        url(r'^User_Home_Page', views.User_Home_Page,),
        url(r'^UserAcceptance/(?P<request_id>[0-9]+)', views.UserAcceptance,),
        url(r'^UserReject/(?P<request_id>[0-9]+)', views.UserReject,),
        url(r'^Manager_Home_Page', views.Manager_Home_Page,),
        url(r'^Mng_approve/(?P<requestId>[0-9]+)', views.Manager_approvement,),
        url(r'^GetUserHistory/(?P<userId>[0-9]+)', views.GetUserHistory,),
        url(r'^RejectRequest/(?P<request_id>[0-9]+)/(?P<emp_no>[0-9]+)', views.RejectRequest,),
        url(r'^PaidRequest/(?P<request_id>[0-9]+)/(?P<emp_no>[0-9]+)', views.PaidRequest,),
        url(r'^SetRequestPrices/(?P<totalCost>([0-9]*\.[0-9]+|[0-9]+))/(?P<discount>([0-9]*\.[0-9]+|[0-9]+))/(?P<request_id>[0-9]+)/(?P<status>[0-9]+)', views.SetRequestPrices,),
        url(r'^SalesGetReviewManagerApprovals', views.SalesGetReviewManagerApprovals,),
        url(r'^Sales_approval/(?P<requestId>[0-9]+)', views.Sales_approval,),
    )

