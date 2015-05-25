/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3.intranet;

import gr.hua.UserExists.Request;
import gr.hua.team3.DAL_Requests;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author palia_000
 */
@WebService(serviceName = "SalesManagerServices")
public class SalesManagerServices {

    DAL_Requests dal = new DAL_Requests();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "SalesManagerSetReviewRequest")
    public Boolean SalesManagerSetReviewRequest(@WebParam(name = "request_id") Integer request_id, @WebParam(name = "discount") Float discount) {
        return dal.SalesManagerSetReviewRequest(request_id, discount);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SalesManagerGetReviewRequest")
    public List<Request> SalesManagerGetReviewRequest() {  // Throws out requests that are rejected,paid or completed
        
        ArrayList<Request> listReq=new ArrayList<Request>();
        listReq=dal.SelectRequests();
        
        for(int k=listReq.size()-1;k>=0;k--)
        {
            if (listReq.get(k).getStatus()!=22)
            {
                listReq.remove(k);
            }
        }
        
        return listReq;
    }
}
