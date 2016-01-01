/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJSignoffRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJSignoffResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * Called by XUS KAAJEE LOGOUT rpc to kill entry in sign-on log..
 * </pre>
 * @author Christopher Schuck
 *
 */
@WebService(name = "XUSKAAJSignoff", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSKAAJSignoffEndpoint {


    /**
     * <pre>
     * This RPC calls the LOUT^XUSCLEAN tag to mark a KAAJEE-signed-on 
     * user's entry in the sign-on log as signed off.  
     * </pre>      
     * @param request
     * 
     *         Domain Object that contains All Signoff^XUSKAAJ input
     *         Parameters
     * 
     * @return XUSKAAJSignoffResponse
     * 
     *         Domain Object that contains Signoff^XUSKAAJ output data
     * 
     * @throws VistaWebServiceFault
     */
	@WebMethod(action = "XUSKAAJSignoffAction", operationName = "XUSKAAJSignoff")
	public XUSKAAJSignoffResponse signoff(@WebParam(name = "XUSKAAJSignoffRequest") XUSKAAJSignoffRequest request) 
	        throws VistaWebServiceFault;

}
