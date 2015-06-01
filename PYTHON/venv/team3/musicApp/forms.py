from django import forms



class CreateRequestForm(forms.Form):
    #request_id = forms.IntegerField(label='request_id', max_length=100,required = True)
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

    """def save(self):
        self.fk_user_id=views.
            self.created = datetime.date.today()
        self.updated = datetime.datetime.today()
        super(TodoList, self).save()"""