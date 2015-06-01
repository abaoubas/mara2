/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3.intranet;

import gr.hua.UserExists.Consumer_Manager;
import gr.hua.UserExists.InitialRequests;
import gr.hua.UserExists.Request;
import gr.hua.UserExists.UserAcceptanceArgs;
import gr.hua.UserExists.User_id_Request;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Helen
 */
@WebService(serviceName = "SalesRequests")
public class SalesRequests {

    /**
     * This is a sample web service operation
     */
    /*@WebMethod(operationName = "newRequest")
    public String newRequest(@WebParam(name = "request") Request req) {
        
    }*/
    
    @WebMethod(operationName = "newRequest")
    public boolean newRequest(@WebParam(name = "request") InitialRequests initReqs) {
                
        Consumer_Manager cm = new Consumer_Manager();
        return cm.insertNewRequest(initReqs);
    }
    
    @WebMethod(operationName = "UserAcceptanceRequest")
    public boolean UserAcceptance(@WebParam(name = "user_id") UserAcceptanceArgs user_acc_args) {
                
        Consumer_Manager cm = new Consumer_Manager();
        return cm.acceptRequest(user_acc_args);
    }
    
    @WebMethod(operationName = "GetUserRequests")
    public ArrayList<Request> getUserRequests(@WebParam(name = "user_id") User_id_Request user_id_req) {
                
        Consumer_Manager cm = new Consumer_Manager();
        return cm.pullUserRequests(user_id_req);
    }
}
