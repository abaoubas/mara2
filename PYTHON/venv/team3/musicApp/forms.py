from django import forms
from datetime import datetime

class CreateRequestForm(forms.Form):
    #request_id = forms.IntegerField(label='request_id', max_length=100,required = True)
    fk_user_id = forms.IntegerField(label='fk_user_id',required = True)
    #fk_emp_no = forms.IntegerField(label='fk_emp_no', max_length=100,required = True)
    #dateInserted = forms.DateField(label='dateInserted',widget=forms.HiddenInput(),)
    #dateModified = forms.DateField(label='dateModified',widget=forms.HiddenInput())
    #totalCost = forms.FloatField(label='totalCost', max_length=100,required = True)
    #discount = forms.FloatField(label='discount', max_length=100,required = True)
    #finalCost = forms.FloatField(label='finalCost',required = True)
    #status = forms.IntField(label='status', max_length=100,required = True)
    title = forms.CharField(label='title', max_length=100,required = True)
    album = forms.CharField(label='album',required = True)
    creator_name = forms.CharField(label='creator_name', max_length=100,required = True)
    singer_name = forms.CharField(label='singer_name', max_length=100,required = True)
    fk_file_type_id = forms.IntegerField(label='fk_file_type_id',required = True)
    fk_genre_id = forms.IntegerField(label='fk_genre_id',required = True)
    creation_date = forms.DateField(label='creation_date',required = True)
