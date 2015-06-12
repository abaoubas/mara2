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

    def __init__(self, *args, **kwargs):

        song = kwargs.pop('recording')
        super(CreateRequestForm, self).__init__(*args, **kwargs)
        if song is not None:
            self.fields['title'].initial=song.title
            self.fields['album'].initial=song.album
            self.fields['creator_name'].initial=song.creator_name
            self.fields['singer_name'].initial=song.singer_name
            self.fields['fk_file_type_id'].initial=song.file_type
            self.fields['fk_genre_id'].initial=song.genre_id
            self.fields['strcreation_date'].initial=song.creation_date



class ManagerRequestForm(forms.Form):
    request_id = forms.IntegerField(label='Request ID', required=True,
                                    widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_user_id = forms.IntegerField(label='Πελάτης', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_emp_no = forms.IntegerField(label='Πωλητής', required=True,
                                   widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    dateInserted = forms.CharField(label='Ημερομηνία Καταχώρησης', widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    dateModified = forms.CharField(label='Ημερομηνία Μεταβολής', widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    totalCost = forms.FloatField(label='Συνολικό κόστος', required=True,
                                 widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    discount = forms.FloatField(label='Έκπτωση', required=True)
    finalCost = forms.FloatField(label='Τελικό κόστος', required=True,
                                 widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    status = forms.IntegerField(label='Κατάσταση Αίτησης', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    title = forms.CharField(label='Τίτλος κομματιού', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    album = forms.CharField(label='Συλλογή', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    creator_name = forms.CharField(label='Όνομα Δημιουργού', required=True,
                                   widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    singer_name = forms.CharField(label='Όνομα Τραγουδιστή', required=True,
                                  widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_file_type_id = forms.IntegerField(label='Τύπος Αρχείου', required=True,
                                         widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_genre_id = forms.IntegerField(label='Είδος', required=True,
                                     widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    creation_date = forms.CharField(label='Ημερομηνία Δημιουργίας', widget=forms.TextInput(attrs={'readonly': 'readonly'}))


class SalesRequestForm(forms.Form):
    request_id = forms.IntegerField(label='Request ID', required=True,
                                    widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_user_id = forms.IntegerField(label='Πελάτης', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_emp_no = forms.IntegerField(label='Πωλητής', required=True,
                                   widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    dateInserted = forms.CharField(label='Ημερομηνία Καταχώρησης', widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    dateModified = forms.CharField(label='Ημερομηνία Μεταβολής', widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    totalCost = forms.FloatField(label='Συνολικό κόστος', required=True,
                                 widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    discount = forms.FloatField(label='Έκπτωση', required=True,
                                 widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    finalCost = forms.FloatField(label='Τελικό κόστος', required=True)
    status = forms.IntegerField(label='Κατάσταση Αίτησης', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    title = forms.CharField(label='Τίτλος κομματιού', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    album = forms.CharField(label='Συλλογή', required=True, widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    creator_name = forms.CharField(label='Όνομα Δημιουργού', required=True,
                                   widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    singer_name = forms.CharField(label='Όνομα Τραγουδιστή', required=True,
                                  widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_file_type_id = forms.IntegerField(label='Τύπος Αρχείου', required=True,
                                         widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    fk_genre_id = forms.IntegerField(label='Είδος', required=True,
                                     widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    creation_date = forms.CharField(label='Ημερομηνία Δημιουργίας', widget=forms.TextInput(attrs={'readonly': 'readonly'}))
