/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.UserExists;

import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 *
 * @author palia_000
 */
public class Employee {
    @NotNull 
    private int emp_id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private Date birthdate;
    private String gender;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String day, String month, String year) {
        //this.birthdate = birthdate;
        java.sql.Date javaSqlDate = java.sql.Date.valueOf(year+"-"+month+"-"+day);
        this.birthdate = javaSqlDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
