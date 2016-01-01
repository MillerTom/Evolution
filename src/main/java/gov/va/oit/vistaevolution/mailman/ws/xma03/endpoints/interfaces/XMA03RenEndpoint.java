/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "XMA03Ren", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA03RenEndpoint {

    @WebMethod(action = "XMA03RenAction", operationName = "XMA03Ren")
    public XMA03RenResponse ren(
	    @WebParam(name = "XMA03RenRequest") XMA03RenRequest request)
	    throws VistaWebServiceFault;
}
