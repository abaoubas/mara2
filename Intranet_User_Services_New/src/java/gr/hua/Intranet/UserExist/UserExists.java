/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.Intranet.UserExist;

import gr.hua.Intranet.Employee;
import gr.hua.Intranet.Employee_Manager;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author palia_000
 */
@WebService(serviceName = "UserExists")
public class UserExists {

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
    @WebMethod(operationName = "userexist")
    public String userexist(@WebParam(name = "username") String username) {
        //TODO write your implementation code here:
        Employee employee = new Employee();
        Employee_Manager em= new Employee_Manager();
        employee.setUsername(username);
        return em.checkUser(employee);
    }
}
