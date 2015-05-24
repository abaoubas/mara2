/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3.intranet;

import gr.hua.team3.DAL_Requests;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author palia_000
 */
@WebService(serviceName = "SalesEmployeeServices")
public class SalesEmployeeServices {

    DAL_Requests dal = new DAL_Requests();
 
    
    @WebMethod(operationName = "SelectRecordings")
    public List<Request> SelectRequests() {        
        return dal.SelectRequests();
    }
}
