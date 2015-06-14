/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3.intranet;

import gr.hua.UserExists.Request;
import gr.hua.team3.DAL_Requests;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
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

    @WebMethod(operationName = "GetNewRequests")
    public List<Request> GetNewRequests() {
        ArrayList<Request> listReq = new ArrayList<Request>();
        listReq = dal.SelectRequests();

        for (int k = listReq.size() - 1; k >= 0; k--) {
            if (listReq.get(k).getStatus() != 0) {
                listReq.remove(k);
            }
        }

        return listReq;
    }

    @WebMethod(operationName = "SalesGetReviewManagerApproval")
    public List<Request> SalesGetReviewManagerApproval() {
        ArrayList<Request> listReq = new ArrayList<Request>();
        listReq = dal.SelectRequests();

        for (int k = listReq.size() - 1; k >= 0; k--) {
            if (listReq.get(k).getStatus() != 21) {
                listReq.remove(k);
            }
        }

        return listReq;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "salesGetReviewRequest")
    public List<Request> salesGetReviewRequest() {  // Throws out requests that are rejected,paid or completed
  /*
         status 10, 22 , για τις οποίες θα πρέπει να πατήσει ένα κουμπί που να λέει “προώθηση προς τον πελάτη”.
         status 25 (δεν έχει να κάνει κάτι)
         status 30,για τις οποίες θα πρέπει να πατήσει ένα κουμπί που να λέει “πληρώθηκαν”.
         status 31 δεν έχει να κανει κατι
         */
        ArrayList<Request> listReq = new ArrayList<Request>();
        listReq = dal.SelectRequests();

        for (int k = listReq.size() - 1; k >= 0; k--) {
            if (listReq.get(k).getStatus() != 10 && listReq.get(k).getStatus() != 22 && listReq.get(k).getStatus() != 25 && listReq.get(k).getStatus() != 30 && listReq.get(k).getStatus() != 31) {
                listReq.remove(k);
            }
        }

        return listReq;
    }

    @WebMethod(operationName = "salesGetCompletedRequest")
    public List<Request> salesGetCompletedRequest() {  // Throws out requests that are rejected,paid or completed

        ArrayList<Request> listReq = new ArrayList<Request>();
        listReq = dal.SelectRequests();

        for (int k = listReq.size() - 1; k >= 0; k--) {
            if (listReq.get(k).getStatus() != 32 && listReq.get(k).getStatus() != 98 && listReq.get(k).getStatus() != 99 && listReq.get(k).getStatus() != 100) {
                listReq.remove(k);
            }
        }

        return listReq;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SetRequestPrices")
    public boolean SetRequestPrices(@WebParam(name = "totalCost") Float totalCost, @WebParam(name = "discount") Float discount, @WebParam(name = "request_id") Integer request_id, @WebParam(name = "status") Integer status) {
        //TODO write your implementation code here:

        return dal.SetRequestPrices(totalCost, discount, request_id, status);
    }

    @WebMethod(operationName = "GetUserHistory")
    public List<Request> GetUserHistory(@WebParam(name = "user_id") Integer user_id) {  // Throws out requests that are rejected,paid or completed

        ArrayList<Request> listReq = new ArrayList<Request>();
        listReq = dal.SelectRequests();

        for (int k = listReq.size() - 1; k >= 0; k--) {
            if (listReq.get(k).getFk_user_id() != user_id) {
                listReq.remove(k);
            }
        }

        return listReq;
    }

    @WebMethod(operationName = "GetAcceptedRequest")
    public List<Request> GetAcceptedRequest() {  // Throws out requests that are rejected,paid or completed

        ArrayList<Request> listReq = new ArrayList<Request>();
        listReq = dal.SelectRequests();

        for (int k = listReq.size() - 1; k >= 0; k--) {
            if (listReq.get(k).getStatus() != 30) {
                listReq.remove(k);
            }
        }

        return listReq;
    }

    @WebMethod(operationName = "RejectRequest")
    public boolean RejectRequest(@WebParam(name = "request_id") Integer request_id, @WebParam(name = "emp_no") Integer emp_no) {
        //TODO write your implementation code here:

        return dal.RejectRequest(request_id, emp_no);
    }

    @WebMethod(operationName = "PaidRequest")
    public boolean PaidRequest(@WebParam(name = "request_id") Integer request_id, @WebParam(name = "emp_no") Integer emp_no) {
        //TODO write your implementation code here:

        return dal.PaidRequest(request_id, emp_no);
    }

    @WebMethod(operationName = "SalesSetReviewRequest")
    public Boolean SalesSetReviewRequest(@WebParam(name = "request_id") Request request_ap) {
        return dal.insertSalesApproval(request_ap);
    }
    
    
    @WebMethod(operationName = "SalesSetReviewRequestFinal")
    public Boolean SalesSetReviewRequestFinal(@WebParam(name = "request_id") Request request_ap) {
        return dal.insertSalesApprovalFinal(request_ap);
    }
}
