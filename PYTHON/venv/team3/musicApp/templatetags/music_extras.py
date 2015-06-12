#!/usr/bin/env python
# -*- coding: utf-8 -*-
from django import template
from suds.client import Client

register = template.Library()

base_service_url = 'http://localhost:8080/Intranet_User_Services/'
soap_client_musicServices = Client(base_service_url + 'MusicServices?WSDL')
javaClient_EmployeeServices = Client(base_service_url + 'EmployeeServices?WSDL')
javaClient_GetUserServices = Client('http://localhost:8080/Internet_User_Services/GetUser?WSDL')


result_filetypes = soap_client_musicServices.service.selectFileTypes()
result_genre = soap_client_musicServices.service.selectGenre()
result_artist = soap_client_musicServices.service.selectArtist()

result_customers = javaClient_GetUserServices.service.getAllUsers()
result_employees = javaClient_EmployeeServices.service.getAllEmp()

"""
status { 0 = new request, 10 = fixed price, 20 = with discount, 21 = reviewed by sales manager,
22 = reviewed by sales, 25 = waiting for acceptance by requestor, 30 accepted by requestor,
31 = paid, 32 = received,
99=rejected by requestor, 98=rejected by sales, 100 = completed }
"""

result_statuses = (

(0, "Νέα αίτηση"),
(10, "Δώθηκε τιμή"),
(20, "Απαιτείται έγκριση απο τον διευθυντή"),
(21, "Εγκρίθηκε απο τον διευθυντή"),
(22, "Προωθήθηκε στον πελάτη"),
(25, "Αναμονή απο πελάτη"),
(30, "Ο πελάτης αποδέχθηκε"),
(31, "Πληρώθηκε"),
(99, "Απορρίφθηκε απο τον πελάτη"),
(98, "Απορρίφθηκε απο τον πωλητή"),
(100, "Ολοκληρώθηκε")
)




@register.filter
def lookup_filetypes(value):
    r = next((x for x in result_filetypes if x['file_type_id'] == value), None)
    if r is None:
        return ""
    return r.description

@register.filter
def lookup_genre(value):
    r = next((x for x in result_genre if x['genre_id'] == value), None)
    if r is None:
        return ""
    return r.description

@register.filter
def lookup_artist(value):
    r = next((x for x in result_artist if x['artist_id'] == value), None)
    if r is None:
        return ""
    return r.description


@register.filter
def lookup_customer(value):
    r = next((x for x in result_customers if x['user_id'] == value), None)
    if r is None:
        return ""
    return r.first_name + " " + r.last_name

@register.filter
def lookup_customer_email(value):
    r = next((x for x in result_customers if x['user_id'] == value), None)
    if r is None:
        return ""
    return r.email


@register.filter
def lookup_customer_iban(value):
    r = next((x for x in result_customers if x['user_id'] == value), None)
    if r is None:
        return ""
    return r.IBAN


@register.filter
def lookup_staff(value):
    r = next((x for x in result_employees if x['emp_id'] == value), None)
    if r is None:
        return ""
    return r.first_name + " " + r.last_name

@register.filter
def lookup_statuses(value):
    r = next((x for x in result_statuses if x[0] == value), None)
    if r is None:
        return ""
    return r[1]
