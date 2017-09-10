from django.conf.urls import include, url
from app.DBMS.views import index
from app.DBMS.views import socket
urlpatterns = [
    url(r'^$', index),
    url(r'^socket',socket,name='menchu')
]
