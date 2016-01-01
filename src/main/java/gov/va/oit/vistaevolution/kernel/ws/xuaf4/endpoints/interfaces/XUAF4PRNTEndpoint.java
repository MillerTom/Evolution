package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;


import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PRNTRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PRNTResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;



/**
 * 
 * @author Bill Blackmon <bill.blackmon@medsphere.com>
 * 
 */



@WebService(name = "XUAF4PRNT", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4PRNTEndpoint {
	
	/**
	 * @param request
	 * @return
	 */
	
	@WebMethod(action = "XUAF4PRNTAction", operationName = "XUAF4PRNT")
	public XUAF4PRNTResponse prnt(@WebParam(name = "XUAF4PRNTRequest") XUAF4PRNTRequest request)
			throws VistaWebServiceFault;


}
