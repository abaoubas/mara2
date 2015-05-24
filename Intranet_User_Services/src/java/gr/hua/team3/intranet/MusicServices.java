/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3.intranet;

import gr.hua.team3.DAL;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author abaoubas
 */
@WebService(serviceName = "MusicServices")
public class MusicServices {

    //the Data Access Layer object
    DAL dal = new DAL();
 
    
    @WebMethod(operationName = "SelectRecordings")
    public List<Recordings> SelectRecordings() {        
        return dal.SelectRecordings();
    }
    
      @WebMethod(operationName = "test")
    public List<Recordings> test() {        
        return new ArrayList<Recordings>();
    }
}
