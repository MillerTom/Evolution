package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFHtmlRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFHtmlResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 
 * @author bill.blackmon <bill.blackmon@medsphere.com>
 * 
 * 
 * 
 **/

@WebService(name = "DILFHtml", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFHtmlEndpoint {

	@WebMethod(action = "HTMLEncodeDecodeAction", operationName = "HTMLEncodeDecode")
	public DILFHtmlResponse html(@WebParam(name = "DILFHtmlRequest") DILFHtmlRequest request) throws VistaWebServiceFault;

}
