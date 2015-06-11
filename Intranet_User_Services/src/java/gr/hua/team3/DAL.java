/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3;

import gr.hua.team3.intranet.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abaoubas this is the Data Access Layer it contains all database
 * related code
 */
public class DAL {

    private Connection connection;

    public DAL() {
        connection = gr.hua.UserExists.Database.getConnection();
    }

    public ArrayList<Recordings> SelectRecordings() {

        try {
            PreparedStatement ps = connection.prepareStatement("select * from Recordings");
            ResultSet rs = ps.executeQuery();
            ArrayList<Recordings> results = new ArrayList<Recordings>();

            while (rs.next()) // found
            {
                Recordings r = ReadRecording(rs);
                results.add(r);
            }

            return results;
        } catch (Exception ex) {
            PrintError(ex);
        }
        return new ArrayList<Recordings>();
    }
    
    public ArrayList<Recordings> GetRequestRecordings(Integer requestId) {

        try {
            PreparedStatement ps = connection.prepareStatement("select * from Recordings INNER JOIN Request_Recordings ON Request_Recordings.fk_requestrequest_id = ? and Request_Recordings.fk_recordingspk_recording_id = Recordings.pk_recording_id");
            ps.setFloat(1, requestId);
            ResultSet rs = ps.executeQuery();
             
            ArrayList<Recordings> results = new ArrayList<Recordings>();

            while (rs.next()) // found
            {
                Recordings r = ReadRecording(rs);
                results.add(r);
            }

            return results;
        } catch (Exception ex) {
            PrintError(ex);
        }
        return new ArrayList<Recordings>();
    }

    private Recordings ReadRecording(ResultSet rs) throws SQLException {
        Recordings r = new Recordings();
        r.setPk_recording_id(rs.getInt("pk_recording_id"));
        r.setTitle(rs.getString("title"));
        r.setCreation_date(rs.getDate("creation_date"));
        r.setAlbum(rs.getString("album"));
        r.setSinger_name(rs.getString("singer_name"));
        r.setCreator_name(rs.getString("creator_name"));
        r.setFile_type(rs.getInt("fk_file_type_id"));
        r.setItem_location(rs.getString("item_location"));
        r.setFoto_location(rs.getString("foto_location"));
        r.setGenre_id(rs.getInt("fk_genre_id"));
        r.setPrice(rs.getFloat("price"));
        return r;
    }

    public ArrayList<Events> selectEvents() {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from Events");
            ResultSet rs = ps.executeQuery();
            ArrayList<Events> results = new ArrayList<Events>();

            while (rs.next()) // found
            {
                Events r = new Events();

                r.setEvent_id(rs.getInt("event_id"));
                r.setEvent_location(rs.getString("event_location"));
                r.setEvent_producer(rs.getString("event_producer"));
                r.setEvent_from_date(rs.getDate("event_from_date"));
                r.setEvent_to_date(rs.getDate("event_to_date"));
                r.setArtists(selectArtists(r.getEvent_id()));

                results.add(r);
            }

            return results;
        } catch (Exception ex) {
            PrintError(ex);
        }
        return new ArrayList<Events>();
    }

    public ArrayList<Artist> selectArtists(int event_id) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from HasArtist "
                    + "LEFT JOIN Artists ON Artists.artist_id = HasArtist.Artistartist_id"
                    + "WHERE HasArtist.Eventsevent_id = ?");
            ps.setInt(1, event_id);

            ResultSet rs = ps.executeQuery();
            ArrayList<Artist> results = new ArrayList<Artist>();

            while (rs.next()) // found
            {
                Artist r = new Artist();

                r.setArtist_id(rs.getInt("artist_id"));
                r.setName(rs.getString("name"));

                results.add(r);
            }

            return results;
        } catch (Exception ex) {
            PrintError(ex);
        }
        return new ArrayList<Artist>();
    }

    public ArrayList<Recordings> SelectRecordingsByGenre(GenreInput genreInput) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from Recordings "
                    + "WHERE fk_genre_id = ?");
            ps.setInt(1, genreInput.getGenre_id());

            ResultSet rs = ps.executeQuery();
            ArrayList<Recordings> results = new ArrayList<Recordings>();

            while (rs.next()) // found
            {
                Recordings r = ReadRecording(rs);

                results.add(r);
            }

            return results;
        } catch (Exception ex) {
            PrintError(ex);
        }
        return new ArrayList<Recordings>();
    }

    public ArrayList<MusicInfo> SelectMusicInfo() {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from MusicInfo ");

            ResultSet rs = ps.executeQuery();
            ArrayList<MusicInfo> results = new ArrayList<MusicInfo>();

            while (rs.next()) // found
            {
                MusicInfo r = ReadMusicInfo(rs);
                results.add(r);
            }

            return results;
        } catch (Exception ex) {
            PrintError(ex);
        }
        return new ArrayList<MusicInfo>();
    }

    private MusicInfo ReadMusicInfo(ResultSet rs) throws SQLException {
        MusicInfo r = new MusicInfo();
        r.setMusic_info_id(rs.getInt("music_id"));
        r.setTitle(rs.getString("title"));
        r.setBodytext(rs.getString("bodytext"));
        r.setGenre_id(rs.getInt("Genrepk_genre_id"));
        return r;
    }

    public ArrayList<MusicInfo> SelectMusicInfoByGenre(GenreInput genreInput) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from MusicInfo "
                    + "WHERE Genrepk_genre_id = ?");
            ps.setInt(1, genreInput.getGenre_id());

            ResultSet rs = ps.executeQuery();
            ArrayList<MusicInfo> results = new ArrayList<MusicInfo>();

            while (rs.next()) // found
            {
                MusicInfo r = ReadMusicInfo(rs);
                results.add(r);
            }

            return results;
        } catch (Exception ex) {
            PrintError(ex);
        }
        return new ArrayList<MusicInfo>();
    }

    public ArrayList<FileType> selectFileTypes() {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from FileType ");
            ResultSet rs = ps.executeQuery();
            ArrayList<FileType> results = new ArrayList<FileType>();
            while (rs.next()) // found
            {
                FileType r = new FileType();
                r.setFile_type_id(rs.getInt("pk_file_type_id"));
                r.setDescription(rs.getString("description"));
                results.add(r);
            }

            return results;
        } catch (Exception ex) {
            PrintError(ex);
        }
        return new ArrayList<FileType>();
    }

    public Boolean subscribeInNewsletter(NewsLetter newsLetter) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO NewsLetter "
                    + "(user_id, Eventsevent_id) "
                    + "VALUES(?, ?)"
            );
            ps.setInt(1, newsLetter.getUser_id());
            ps.setInt(2, newsLetter.getEvent_id());

            ResultSet rs = ps.executeQuery();
            return true;
        } catch (Exception ex) {
            PrintError(ex);
            return false;
        }

    }

    public ArrayList<Genre> selectGenre() {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from Genre ");
            ResultSet rs = ps.executeQuery();
            ArrayList<Genre> results = new ArrayList<Genre>();
            while (rs.next()) // found
            {
                Genre r = new Genre();
                r.setGenre_id(rs.getInt("pk_genre_id"));
                r.setDescription(rs.getString("description"));
                results.add(r);
            }

            return results;
        } catch (Exception ex) {
            PrintError(ex);
        }
        return new ArrayList<Genre>();
    }

    public ArrayList<Artist> selectArtist() {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from Artist ");
            ResultSet rs = ps.executeQuery();
            ArrayList<Artist> results = new ArrayList<Artist>();
            while (rs.next()) // found
            {
                Artist r = new Artist();
                r.setArtist_id(rs.getInt("artist_id"));
                r.setName(rs.getString("name"));
                results.add(r);
            }

            return results;
        } catch (Exception ex) {
            PrintError(ex);
        }
        return new ArrayList<Artist>();
    }

    private void PrintError(Exception ex) {
        StringWriter errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        System.out.println(errors.toString());
    }

}
