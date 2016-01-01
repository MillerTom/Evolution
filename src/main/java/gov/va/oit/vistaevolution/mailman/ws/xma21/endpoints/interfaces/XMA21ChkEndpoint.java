package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * This API checks to see if a user is a member of a mail group. If the user 
 * is a member, $T is set to "true"; otherwise, it's set to "false". 
 * </pre>
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMA21Chk", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA21ChkEndpoint {
	
    
    /**
     * <pre>
     * This RPC Call checks to see if a user is a member of a mail group. 
     * If the user is a member, a 1 is returned ; otherwise, it's set to 0. 
     * </pre>
     * 
     * @param request -
     * 
     *         Domain Object that contains All Chk^XMA21 input
     *         Parameters
     * 
     * @return XMA21ChkResponse -
     * 
     *         Domain Object that contains Chk^XMA21 output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMA21ChkAction", operationName = "XMA21Chk")
	public XMA21ChkResponse chk(@WebParam(name = "XMA21ChkRequest") XMA21ChkRequest request) 
	        throws VistaWebServiceFault;

}
