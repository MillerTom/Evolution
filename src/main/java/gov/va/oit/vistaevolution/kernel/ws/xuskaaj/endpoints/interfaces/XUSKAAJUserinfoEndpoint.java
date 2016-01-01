/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJUserinfoRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJUserinfoResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XUSKAAJUserinfo", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSKAAJUserinfoEndpoint {

	@WebMethod(action = "XUSKAAJUserinfoAction", operationName = "XUSKAAJUserinfo")
	public XUSKAAJUserinfoResponse userinfo(@WebParam(name = "XUSKAAJUserinfoRequest") XUSKAAJUserinfoRequest request) throws VistaWebServiceFault;

}
