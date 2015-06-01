package gr.hua.UserExists;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class InitialRequests {
    
    private int fk_user_id;
    private String kuku;
    private String album;
    private String creator_name;
    private String singer_name;
    private int fk_genre_id;
    private int fk_file_type_id;
    private String strcreation_date;
    private Date creation_date;

 /*   public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }*/

    public int getFk_user_id() {
        return fk_user_id;
    }

    public void setFk_user_id(int fk_user_id) {
        this.fk_user_id = fk_user_id;
    }

    public String getTitle() {
        return kuku;
    }

    public void setTitle(String kuku) {
        this.kuku = kuku;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCreator_name() {
        return creator_name;
    }

    public void setCreator_name(String creator_name) {
        this.creator_name = creator_name;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public int getFk_genre_id() {
        return fk_genre_id;
    }

    public void setFk_genre_id(int fk_genre_id) {
        this.fk_genre_id = fk_genre_id;
    }

    public int getFk_file_type_id() {
        return fk_file_type_id;
    }

    public void setFk_file_type_id(int fk_file_type_id) {
        this.fk_file_type_id = fk_file_type_id;
    }

        
    public String getstrCreation_date() {
        return strcreation_date;
    }

    public void setstrCreation_date(String strcreation_date) {
        this.strcreation_date = strcreation_date;
    }
    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public Date getCreation_date() throws ParseException {

        return df.parse(strcreation_date);
    }

    public void setCreation_date(int day, int month, int year) {
        this.creation_date = new Date(year, month, day);
        this.strcreation_date = df.format(this.creation_date);
        //java.sql.Date javaSqlDate = java.sql.Date.valueOf(year+"-"+month+"-"+day);
        //this.birthdate = javaSqlDate;
    }
}
