package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PADDRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PADDResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <em>$$PADD^XUAF4( ): Institution Physical Address:</em> This function returns
 * the official intuition physical address for the entered IEN.
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XUAF4PADD", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4PADDEndpoint {

    /**
     * 
     * @param request
     * @return
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XUAF4PADDAction", operationName = "XUAF4PADD")
    public XUAF4PADDResponse PADD(
	    @WebParam(name = "XUAF4PADDRequest") XUAF4PADDRequest request)
	    throws VistaWebServiceFault;

}
