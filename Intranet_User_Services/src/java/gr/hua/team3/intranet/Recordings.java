/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3.intranet;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abaoubas
 */
@XmlRootElement
public class Recordings implements Serializable {

    private int pk_recording_id;
    private String title;
    private String album;
    private String creator_name;
    private String singer_name;
    private int genre_id;
    private int file_type;
    private Date creation_date;
    private Float price;
    private String foto_location;

    /**
     * Get the value of pk_recording_id
     *
     * @return the value of pk_recording_id
     */
    public int getPk_recording_id() {
        return pk_recording_id;
    }

    /**
     * Set the value of pk_recording_id
     *
     * @param pk_recording_id new value of pk_recording_id
     */
    public void setPk_recording_id(int pk_recording_id) {
        this.pk_recording_id = pk_recording_id;
    }

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the value of album
     *
     * @return the value of album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Set the value of album
     *
     * @param album new value of album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * Get the value of creator_name
     *
     * @return the value of creator_name
     */
    public String getCreator_name() {
        return creator_name;
    }

    /**
     * Set the value of creator_name
     *
     * @param creator_name new value of creator_name
     */
    public void setCreator_name(String creator_name) {
        this.creator_name = creator_name;
    }

    /**
     * Get the value of singer_name
     *
     * @return the value of singer_name
     */
    public String getSinger_name() {
        return singer_name;
    }

    /**
     * Set the value of singer_name
     *
     * @param singer_name new value of singer_name
     */
    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    /**
     * Get the value of genre_id
     *
     * @return the value of genre_id
     */
    public int getGenre_id() {
        return genre_id;
    }

    /**
     * Set the value of genre_id
     *
     * @param genre_id new value of genre_id
     */
    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    /**
     * Get the value of file_type
     *
     * @return the value of file_type
     */
    public int getFile_type() {
        return file_type;
    }

    /**
     * Set the value of file_type
     *
     * @param file_type new value of file_type
     */
    public void setFile_type(int file_type) {
        this.file_type = file_type;
    }

    /**
     * Get the value of creation_date
     *
     * @return the value of creation_date
     */
    public Date getCreation_date() {
        return creation_date;
    }

    /**
     * Set the value of creation_date
     *
     * @param creation_date new value of creation_date
     */
    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Get the value of foto_location
     *
     * @return the value of foto_location
     */
    public String getFoto_location() {
        return foto_location;
    }

    /**
     * Set the value of foto_location
     *
     * @param foto_location new value of foto_location
     */
    public void setFoto_location(String foto_location) {
        this.foto_location = foto_location;
    }

}
