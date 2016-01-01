/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileListResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "DIDFileList", targetNamespace = "http://vistaevolution.va.gov")
public interface DIDFileListEndpoint {

	/**
	 * DD File List Retriever: This procedure returns a list of file-level
	 * attributes that are supported by VA FileMan. It shows specifically which
	 * attributes the Data Dictionary retriever calls can return.
	 * 
	 * @param request
	 * @return
	 * @throws VistaWebServiceFault 
	 */
	@WebMethod
	public DIDFileListResponse fileList() throws VistaWebServiceFault;

}
