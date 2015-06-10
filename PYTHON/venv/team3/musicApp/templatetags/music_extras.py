from django import template
from suds.client import Client

register = template.Library()


soap_client_musicServices = Client('http://localhost:8080/Intranet_User_Services/MusicServices?WSDL')
result_filetypes = soap_client_musicServices.service.selectFileTypes()
result_genre = soap_client_musicServices.service.selectGenre()
result_artist = soap_client_musicServices.service.selectArtist()


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
