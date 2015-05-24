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





    )

