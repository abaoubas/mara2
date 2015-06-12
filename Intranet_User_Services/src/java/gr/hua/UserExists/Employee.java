/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.UserExists;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
    private String strBirthdate;
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

    public String getStrBirthdate() {
        return strBirthdate;
    }

    public void setStrBirthdate(String strBirthdate) {
        this.strBirthdate = strBirthdate;
    }
    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public Date getBirthdate() throws ParseException {

        return df.parse(strBirthdate);
    }

    public void setBirthdate(int day, int month, int year) {
        this.birthdate = new Date(year, month, day);
        this.strBirthdate = df.format(this.birthdate);
        
    }
    
    public void setBirthdate(java.sql.Date date) {
        this.birthdate = new Date(date.getTime());
        this.strBirthdate = df.format(this.birthdate);
        
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
