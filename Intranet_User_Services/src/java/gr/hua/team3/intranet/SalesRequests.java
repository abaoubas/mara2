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
 * @author Helen
 */
@WebService(serviceName = "SalesRequests")
public class SalesRequests {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "newRequest")
    public String newRequest(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
