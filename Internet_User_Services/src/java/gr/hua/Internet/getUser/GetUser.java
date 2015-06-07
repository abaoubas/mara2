/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.Internet.getUser;

import gr.hua.Internet.Users;
import gr.hua.Internet.Users_Manager;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author palia_000
 */
@WebService(serviceName = "GetUser")
public class GetUser {

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
    @WebMethod(operationName = "getUser")
    public Integer getUser(@WebParam(name = "username") String username) throws Exception {
        
        Users user = new Users();
        Users_Manager um= new Users_Manager();
        user.setUsername(username);
        return um.checkUser(user);
    }
}
