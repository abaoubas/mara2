/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3.intranet;

import gr.hua.team3.DAL;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author abaoubas
 */
@WebService(serviceName = "MusicServices")
public class MusicServices {

    //the Data Access Layer object
    DAL dal = new DAL();

    @WebMethod(operationName = "SelectRecordings")
    public List<Recordings> SelectRecordings() {
        return dal.SelectRecordings();
    }
    
    @WebMethod(operationName = "SetRequestRecordings")
    public boolean SetRequestRecordings(@WebParam(name = "request") Integer req_id,@WebParam(name = "recording") Integer rec_id) {
        return dal.SetRequestRecordings(req_id,rec_id);
    }
    
    @WebMethod(operationName = "ReturnIitialReqByRecId")
    public Recordings ReturnIitialReqByRecId(@WebParam(name = "rec_id") Integer rec_id) {
        return dal.ReturnIitialReqByRecId(rec_id);
    }
    
    @WebMethod(operationName = "GetRequestRecordings")
    public List<Recordings> GetRequestRecordings(@WebParam(name = "request") Integer requestId) {
        return dal.GetRequestRecordings(requestId);
    }

    @WebMethod(operationName = "selectEvents")
    public ArrayList<Events> selectEvents() {
        return dal.selectEvents();
    }

    @WebMethod(operationName = "SelectRecordingsByGenre")
    public ArrayList<Recordings> SelectRecordingsByGenre(Integer genreInput) {
        return dal.SelectRecordingsByGenre(genreInput);
    }

    @WebMethod(operationName = "SelectMusicInfo")
    public ArrayList<MusicInfo> SelectMusicInfo() {
        return dal.SelectMusicInfo();
    }

    @WebMethod(operationName = "SelectMusicInfoByGenre")
    public ArrayList<MusicInfo> SelectMusicInfoByGenre(GenreInput genreInput) {
        return dal.SelectMusicInfoByGenre(genreInput);
    }

    @WebMethod(operationName = "selectFileTypes")
    public ArrayList<FileType> selectFileTypes(){
        return dal.selectFileTypes();
    }

    @WebMethod(operationName = "subscribeInNewsletter")
    public Boolean subscribeInNewsletter(NewsLetter newsLetter) {
        return dal.subscribeInNewsletter(newsLetter);
    }

    @WebMethod(operationName = "selectGenre")
    public ArrayList<Genre>  selectGenre(){
        return dal.selectGenre();
    }

    @WebMethod(operationName = "selectArtist")
    public ArrayList<Artist>  selectArtist() {
        return dal.selectArtist();
    }

    @WebMethod(operationName = "selectListArtist")
    public ArrayList<Artist>  selectListArtist() {
        return dal.selectListArtist();
    }
    
}
