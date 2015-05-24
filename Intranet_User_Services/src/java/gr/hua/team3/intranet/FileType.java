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
public class FileType {
    private int file_type_id;

    public int getFile_type_id() {
        return file_type_id;
    }

    public void setFile_type_id(int file_type_id) {
        this.file_type_id = file_type_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private String description;
}
