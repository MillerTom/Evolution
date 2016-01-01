/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusbse1.endpoints.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import gov.va.oit.vistaevolution.kernel.ws.xusbse1.model.XUSBSE1GetVisitRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusbse1.model.XUSBSE1GetVisitResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *
 */
@WebService(name = "XUSBSE1GetVisit", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSBSE1GetVisitEndpoint {
	
	@WebMethod(action = "XUSBSE1GetVisitAction", operationName = "XUSBSE1GetVisit")
	public XUSBSE1GetVisitResponse getVisit( 
			@WebParam(name ="XUSBSE1GetVisitRequest") XUSBSE1GetVisitRequest xusbse1GetVisitRequest) 
			throws VistaWebServiceFault;

}
