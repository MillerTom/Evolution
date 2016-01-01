/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivSetXUSRB2Request;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivSetXUSRB2Response;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Stephen Combs <Stephen.Combs@synaptekcorp.com>
 *
 */
@WebService(name = "DivSetXUSRB2", targetNamespace = "http://vistaevolution.va.gov")
public interface DivSetXUSRB2Endpoint {

	
	@WebMethod(action = "DivSetXUSRB2Action", operationName = "DivSetXUSRB2")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public DivSetXUSRB2Response divset(@WebParam(name = "DivSetXUSRB2Request") DivSetXUSRB2Request request) throws VistaWebServiceFault;
	

}
