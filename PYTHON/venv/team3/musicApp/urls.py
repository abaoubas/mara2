__author__ = 'abaoubas'

from django.conf.urls import patterns, url
from musicApp import views

urlpatterns = patterns('',
        url(r'^$', views.index, name='index'),
        url(r'^showusers', views.showusers,),
#url(r'^userExists', views.userExists,),
        url(r'^selectRecordings', views.musicServices_selectRecordings,),

    )

