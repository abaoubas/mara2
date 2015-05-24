<<<<<<< HEAD:Intranet_User_Services/src/java/gr/hua/UserExists/Request.java

package gr.hua.UserExists;

import java.util.Date;
import javax.validation.constraints.NotNull;

public class Request {
    @NotNull 
    private int request_id;
    private int fk_user_id;
    private int fk_emp_no;
    private Date dateInserted;
    private Date dateModified;
    private float totalCost;
    private float discount;
    private float finalCost;
    private int status;
    private String title;
    private String album;
    private String creator_name;
    private String singer_name;
    private int fk_genre_id;
    private int fk_file_type_id;
    private Date creation_date;

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getFk_user_id() {
        return fk_user_id;
    }

    public void setFk_user_id(int fk_user_id) {
        this.fk_user_id = fk_user_id;
    }

    public int getFk_emp_no() {
        return fk_emp_no;
    }

    public void setFk_emp_no(int fk_emp_no) {
        this.fk_emp_no = fk_emp_no;
    }

    public Date getDateInserted() {
        return dateInserted;
    }

    public void setDateInserted(Date dateInserted) {
        this.dateInserted = dateInserted;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(float finalCost) {
        this.finalCost = finalCost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    
    
    
}
=======

package gr.hua.team3.intranet;

import java.util.Date;
import javax.validation.constraints.NotNull;

public class Request {
    @NotNull 
    private int request_id;
    private int fk_user_id;
    private int fk_emp_no;
    private Date dateInserted;
    private Date dateModified;
    private float totalCost;
    private float discount;
    private float finalCost;
    private int status;
    private String title;
    private String album;
    private String creator_name;
    private String singer_name;
    private int fk_genre_id;
    private int fk_file_type_id;
    private Date creation_date;

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getFk_user_id() {
        return fk_user_id;
    }

    public void setFk_user_id(int fk_user_id) {
        this.fk_user_id = fk_user_id;
    }

    public int getFk_emp_no() {
        return fk_emp_no;
    }

    public void setFk_emp_no(int fk_emp_no) {
        this.fk_emp_no = fk_emp_no;
    }

    public Date getDateInserted() {
        return dateInserted;
    }

    public void setDateInserted(Date dateInserted) {
        this.dateInserted = dateInserted;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(float finalCost) {
        this.finalCost = finalCost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    
    
    
}
>>>>>>> origin/master:Intranet_User_Services/src/java/gr/hua/team3/intranet/Request.java
