package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NameRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NameResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <em>$$NAME^XUAF4( ):  Institution Official Name: </em>This function returns
 * the official intuition name for the entered IEN.
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XUAF4Name", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4NameEndpoint {

    /**
     * 
     * @param request
     * @return
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XUAF4NameAction", operationName = "XUAF4Name")
    public XUAF4NameResponse name(
	    @WebParam(name = "XUAF4NameRequest") XUAF4NameRequest request)
	    throws VistaWebServiceFault;

}
