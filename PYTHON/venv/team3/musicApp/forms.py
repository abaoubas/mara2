from django import forms



class CreateRequestForm(forms.Form):
    fk_user_id = forms.IntegerField(label='User',required = True)
    #fk_emp_no = forms.IntegerField(label='fk_emp_no', max_length=100,required = True)
    #dateInserted = forms.DateField(label='dateInserted',widget=forms.HiddenInput(),)
    #dateModified = forms.DateField(label='dateModified',widget=forms.HiddenInput())
    #totalCost = forms.FloatField(label='totalCost', max_length=100,required = True)
    #discount = forms.FloatField(label='discount', max_length=100,required = True)
    #finalCost = forms.FloatField(label='finalCost',required = True)
    #status = forms.IntField(label='status', max_length=100,required = True)
    title = forms.CharField(label='Title', max_length=100,required = True)
    album = forms.CharField(label='Album',required = True)
    creator_name = forms.CharField(label='Creator Name', max_length=100,required = True)
    singer_name = forms.CharField(label='Singer Name', max_length=100,required = True)
    fk_file_type_id = forms.IntegerField(label='File Type',required = True)
    fk_genre_id = forms.IntegerField(label='Genre',required = True)
    strcreation_date = forms.CharField(label='Creation Date',max_length=100,required = True)


class ManagerRequestForm(forms.Form):
    request_id = forms.IntegerField(label='request_id',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    fk_user_id = forms.IntegerField(label='User',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    fk_emp_no = forms.IntegerField(label='fk_emp_no',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    dateInserted = forms.CharField(label='dateInserted', widget=forms.TextInput(attrs={'readonly':'readonly'}))
    dateModified = forms.CharField(label='dateModified', widget=forms.TextInput(attrs={'readonly':'readonly'}))
    totalCost = forms.FloatField(label='totalCost',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    discount = forms.FloatField(label='discount',required = True)
    finalCost = forms.FloatField(label='finalCost',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    status = forms.IntegerField(label='status',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    title = forms.CharField(label='Title',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    album = forms.CharField(label='Album',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    creator_name = forms.CharField(label='Creator Name',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    singer_name = forms.CharField(label='Singer Name',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    fk_file_type_id = forms.IntegerField(label='File Type',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    fk_genre_id = forms.IntegerField(label='Genre',required = True, widget=forms.TextInput(attrs={'readonly':'readonly'}))
    creation_date = forms.CharField(label='Creation Date', widget=forms.TextInput(attrs={'readonly':'readonly'}))