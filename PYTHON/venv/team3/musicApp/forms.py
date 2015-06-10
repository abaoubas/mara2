#!/usr/bin/env python
# -*- coding: utf-8 -*-
from django import forms
from suds.client import Client

soap_client_musicServices = Client('http://localhost:8080/Intranet_User_Services/MusicServices?WSDL')


class CreateRequestForm(forms.Form):
    # prepare File types
    file_types = soap_client_musicServices.service.selectFileTypes()
    file_types = [(i.file_type_id, i.description) for i in file_types]
    # prepare Genres
    genres = soap_client_musicServices.service.selectGenre()
    genres = [(i.genre_id, i.description) for i in genres]

    title = forms.CharField(label='Τίτλος', max_length=100, required=False)
    album = forms.CharField(label='Συλλογή', max_length=100, required=False)
    creator_name = forms.CharField(label='Δημιουργός', max_length=100, required=False)
    singer_name = forms.CharField(label='Τραγουδιστής', max_length=100, required=False)
    fk_file_type_id = forms.ChoiceField(label='Τύπος Αρχείου', required=False, choices=[[0, '----------']] + file_types)
    fk_genre_id = forms.ChoiceField(label='Είδος', required=False, choices=[[0, '----------']] + genres)
    strcreation_date = forms.DateField(label='Ημ/νία Δημιουργίας', required=False, input_formats=['%d/%m/%Y'], )


class ManagerRequestForm(forms.Form):
    request_id = forms.IntegerField(label='request_id', required=True,
                                    widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_user_id = forms.IntegerField(label='User', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_emp_no = forms.IntegerField(label='fk_emp_no', required=True,
                                   widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    dateInserted = forms.CharField(label='dateInserted', widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    dateModified = forms.CharField(label='dateModified', widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    totalCost = forms.FloatField(label='totalCost', required=True,
                                 widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    discount = forms.FloatField(label='discount', required=True)
    finalCost = forms.FloatField(label='finalCost', required=True,
                                 widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    status = forms.IntegerField(label='status', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    title = forms.CharField(label='Title', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    album = forms.CharField(label='Album', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    creator_name = forms.CharField(label='Creator Name', required=True,
                                   widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    singer_name = forms.CharField(label='Singer Name', required=True,
                                  widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_file_type_id = forms.IntegerField(label='File Type', required=True,
                                         widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_genre_id = forms.IntegerField(label='Genre', required=True,
                                     widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    creation_date = forms.CharField(label='Creation Date', widget=forms.TextInput(attrs={'readonly': 'readonly'}))


class SalesRequestForm(forms.Form):
    request_id = forms.IntegerField(label='request_id', required=True,
                                    widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_user_id = forms.IntegerField(label='User', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_emp_no = forms.IntegerField(label='fk_emp_no', required=True,
                                   widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    dateInserted = forms.CharField(label='dateInserted', widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    dateModified = forms.CharField(label='dateModified', widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    totalCost = forms.FloatField(label='totalCost', required=True,
                                 widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    discount = forms.FloatField(label='discount', required=True,
                                 widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    finalCost = forms.FloatField(label='finalCost', required=True)
    status = forms.IntegerField(label='status', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    title = forms.CharField(label='Title', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    album = forms.CharField(label='Album', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    creator_name = forms.CharField(label='Creator Name', required=True,
                                   widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    singer_name = forms.CharField(label='Singer Name', required=True,
                                  widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_file_type_id = forms.IntegerField(label='File Type', required=True,
                                         widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_genre_id = forms.IntegerField(label='Genre', required=True,
                                     widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    creation_date = forms.CharField(label='Creation Date', widget=forms.TextInput(attrs={'readonly': 'readonly'}))
