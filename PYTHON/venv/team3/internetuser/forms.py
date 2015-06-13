#!/usr/bin/env python
# -*- coding: utf-8 -*-
from django import forms
from django.contrib.auth.models import User, Group
from django.contrib.auth.forms import UserCreationForm

GENDER_CHOICES = (
    ('', '----'),
    ('M', "Άνδρας"),
    ('F', "Γυναίκα"),
)




class MyRegistrationForm(UserCreationForm):
    email = forms.EmailField(required=True)
    first_name = forms.CharField(label='Όνομα', max_length=100, required=True)
    last_name = forms.CharField(label='Επώνυμο', max_length=100, required=True)
    strBirthdate = forms.DateField(label="Ημερομηνία Γέννησης", required=True, input_formats=['%d/%m/%Y'])
    gender = forms.ChoiceField(required=True, choices=GENDER_CHOICES)
    IBAN = forms.CharField(required=True)


    class Meta:
        model = User
        fields = ('username', 'email', 'password1', 'password2')
        
    def save(self, commit=True):
        user = super(MyRegistrationForm, self).save(commit=False)
        user.email = self.cleaned_data['email']
        user.first_name = self.cleaned_data['first_name']
        user.last_name = self.cleaned_data['last_name']

        if commit:
            user.save()
            # add this user to customer group
            g = Group.objects.get(name='customer')
            g.user_set.add(user)
        return user
    
    

class ContactForm1(forms.Form):
    subject = forms.CharField(max_length=100)
    
class ContactForm2(forms.Form):
    sender = forms.EmailField()

class ContactForm3(forms.Form):
    message = forms.CharField(widget=forms.Textarea)
    
class profileForm(forms.Form):
    first_name = forms.CharField(label='Όνομα', required=True,widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    last_name = forms.CharField(label='Επώνυμο', required=True,widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    username = forms.CharField(label='Username', required=True,widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    email = forms.CharField(label='Email', required=True,widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    #strBirthdate = forms.DateField(label='Ημερομηνία Γέννησης', required=True,widget=forms.TextInput(attrs={'readonly': 'readonly'}))
    #gender = forms.CharField(label='Gender', required=True,widget=forms.TextInput(attrs={'readonly': 'readonly'}))
