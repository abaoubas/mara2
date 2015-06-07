__author__ = 'abaoubas'

from django.conf.urls import patterns, url
from musicApp import views

urlpatterns = patterns('',
        url(r'^$', views.index, name='index'),
        url(r'^showusers', views.showusers,),
        url(r'^selectRecordings', views.musicServices_selectRecordings,),
        url(r'^selectEvents', views.musicServices_selectEvents,),
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
        url(r'^Accept/(?P<request_id>[0-9]+)', views.AcceptPrice,),
        url(r'^Manager_Home_Page', views.Manager_Home_Page,),
        url(r'^Mng_approve/(?P<requestId>[0-9]+)', views.Manager_approvement,),
        url(r'^GetAcceptedRequest', views.GetAcceptedRequest,),
        url(r'^GetUserHistory/(?P<userId>[0-9]+)', views.GetUserHistory,),

    )

