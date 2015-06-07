from django.conf.urls import patterns, include, url
from django.contrib import admin
from employees import views

urlpatterns = patterns('',
    (r'^login/$', views.login),
    (r'^auth/$', views.auth_view),
    (r'^logout/$', views.logout),
    (r'^loggedin/$', views.loggedin),
    (r'^invalid', views.invalid_login),
    (r'^register/$', views.register_user),
    (r'^register_success/$', views.register_success),
    (r'^register_failed/$', views.register_failed),
    (r'^employ_not_found/$', views.employ_not_found),




)
