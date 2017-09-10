from django.shortcuts import render
from django.http import HttpResponse
import socket as menchu2
import os
import sys
def index(request):
    return render(request,'DBMS/index.html')
# Create your views here.

def socket(request):
	HOST = "localhost"
	PORT = 5000
	#alazar = randint(0,5001)
	sacar = '[ "validar": mencgu, "login": ["comando" : "comando","comando" : "comando"]] \n'
	sock = menchu2.socket(menchu2.AF_INET, menchu2.SOCK_STREAM)
	sock.connect((HOST, PORT))
	sock.sendall(sacar)
	data = sock.recv(1024)
	print(data)   
	sock.close()
	return render(request,'DBMS/index.html')
#    return render(request,'DBMS/index.html')