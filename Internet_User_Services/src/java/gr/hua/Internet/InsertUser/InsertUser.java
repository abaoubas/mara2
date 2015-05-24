/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.Internet.InsertUser;

import gr.hua.Internet.Users;
import gr.hua.Internet.Users_Manager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author palia_000
 */
@WebService(serviceName = "InsertUser")
public class InsertUser {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertUser")
    public Integer InsertUser(@WebParam(name = "firstname") String firstname, @WebParam(name = "lastname") String lastname, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "birthdate") String birthdate, @WebParam(name = "gender") String gender, @WebParam(name = "email") String email, @WebParam(name = "IBAN") String IBAN) throws ParseException {
        //TODO write your implementation code here:
        Users user = new Users();
        Users_Manager um= new Users_Manager();
        
        user.setUsername(username);
        user.setFirst_name(firstname);
        user.setLast_name(lastname);
        user.setPassword(password);
        
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
        Date date = format.parse(birthdate);
        user.setBirthdate(date);
        
        user.setGender(gender);
        user.setEmail(email);
        user.setIBAN(IBAN);
        
        return um.insertUser(user);
        
    }

}
