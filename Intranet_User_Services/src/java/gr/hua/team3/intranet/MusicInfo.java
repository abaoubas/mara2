/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3.intranet;

/**
 *
 * @author abaoubas
 */
public class MusicInfo {
 private int music_info_id;

    public int getMusic_info_id() {
        return music_info_id;
    }

    public void setMusic_info_id(int music_info_id) {
        this.music_info_id = music_info_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodytext() {
        return bodytext;
    }

    public void setBodytext(String bodytext) {
        this.bodytext = bodytext;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
 private String title;
 private String bodytext;
 private int genre_id;
}
