/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3.intranet;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author palia_000
 */
@WebService(serviceName = "SalesEmployeeServices")
public class SalesEmployeeServices {

    DAL dal = new DAL();
 
    
    @WebMethod(operationName = "SelectRecordings")
    public List<Recordings> SelectRecordings() {        
        return dal.SelectRecordings();
    }
}
