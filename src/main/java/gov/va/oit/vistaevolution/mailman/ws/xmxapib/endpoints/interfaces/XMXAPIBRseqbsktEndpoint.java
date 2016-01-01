/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXAPIBRseqbskt", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIBRseqbsktEndpoint {

	@WebMethod(action = "XMXAPIBRseqbsktAction", operationName = "XMXAPIBRseqbskt")
	public XMXAPIBRseqbsktResponse rseqbskt(
			@WebParam(name = "XMXAPIBRseqbsktRequest") XMXAPIBRseqbsktRequest request)
			throws VistaWebServiceFault;
}
