/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3.intranet;

import gr.hua.UserExists.Employee;
import gr.hua.UserExists.Employee_Manager;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Helen
 */
@WebService(serviceName = "EmployeeServices")
public class EmployeeServices {

    @WebMethod(operationName = "getEmp")
    public String getEmp(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        Employee employee = new Employee();
        Employee_Manager em = new Employee_Manager();
        employee.setUsername(username);
        employee.setPassword(password);
        return em.getEmp(employee);
    }
    
    @WebMethod(operationName = "insertEmp")
    public Employee insertEmp(
            @WebParam(name = "first_name") String fname, 
            @WebParam(name = "last_name") String lname, 
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password,
            @WebParam(name = "day") String day,
            @WebParam(name = "month") String month,
            @WebParam(name = "year") String year,
            @WebParam(name = "gender") String gender) {
        
        Employee employee = new Employee();
        Employee_Manager em= new Employee_Manager();
        
        employee.setFirst_name(fname);
        employee.setLast_name(lname);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setBirthdate(day,month,year);
        employee.setGender(gender);
        return em.insertEmp(employee);
    }
    
    @WebMethod(operationName = "userexist")
    public String userexist(@WebParam(name = "username") String username) {
        //TODO write your implementation code here:
        Employee employee = new Employee();
        Employee_Manager em= new Employee_Manager();
        employee.setUsername(username);
        return em.checkUser(employee);
    }
}
