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

USERTYPE_CHOICES = (
    ('', '----'),
    ('sales rep', "Πωλητής"),
    ('sales manager', "Διευθυντής Πωλήσεων"),
)



class MyRegistrationForm(UserCreationForm):
    user_type = forms.ChoiceField(required=True, choices=USERTYPE_CHOICES)
    email = forms.EmailField(required=True)
    first_name = forms.CharField(label='Όνομα', max_length=100, required=True)
    last_name = forms.CharField(label='Επώνυμο', max_length=100, required=True)
    strBirthdate = forms.DateField(label="Ημερομηνία Γέννησης", required=True, input_formats=['%d/%m/%Y'])
    gender = forms.ChoiceField(required=True, choices=GENDER_CHOICES)

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
            # add this user to appropriate group
            g = Group.objects.get(name=user.user_type)
            g.user_set.add(user)
        return user
