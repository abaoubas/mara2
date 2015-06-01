from django.conf.urls import patterns, include, url
from django.contrib import admin
from django.conf import settings
from django.conf.urls.static import static

urlpatterns = patterns('',
    url(r'^admin/', include(admin.site.urls)),
    url(r'^music/', include('musicApp.urls')),
    url(r'^emp/', include('employees.urls')),
    url(r'^$', include('musicApp.urls')),

)
#+ static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)