/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldListResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "DIDFieldList", targetNamespace = "http://vistaevolution.va.gov")
public interface DIDFieldListEndpoint {

	/**
	 * DD Field List Retriever: This procedure returns a list of field-level
	 * attributes that are supported by VA FileMan. It shows specifically which
	 * attributes the Data Dictionary retriever call can return.
	 * 
	 * @return
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "DIDFieldListAction", operationName = "DIDFieldList")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public DIDFieldListResponse fieldList() throws VistaWebServiceFault;

}
