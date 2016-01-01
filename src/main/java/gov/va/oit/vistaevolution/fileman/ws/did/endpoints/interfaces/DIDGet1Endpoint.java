/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDGet1Request;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDGet1Response;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "DIDGet1", targetNamespace = "http://vistaevolution.va.gov")
public interface DIDGet1Endpoint {

	/**
	 * This extrinsic function retrieves a single attribute from a single file
	 * or field. Data may be retrieved from any field, including computed or
	 * word-processing fields, and fields specified using relational syntax. A
	 * basic call does not require that any local variables be present and the
	 * symbol table is not changed by this utility. However, computed
	 * expressions may require certain variables to be present and can change
	 * the symbol table because the data retriever does execute Data Dictionary
	 * nodes. The text for word-processing fields is returned in a target array.
	 * If data exists for word-processing fields, this function returns the
	 * resolved TARGET_ROOT. Otherwise null is returned. Format
	 * $$GET1^DID(file,field,flags,attribute,target_root,msg_root) Input
	 * Parameters File (Required) A file number. Field (Required) Field number,
	 * or field name, or field identified in another file by simple extended
	 * pointer (i.e., POINTER:FIELD) relational syntax.
	 * 
	 * NOTE: You cannot use a variable pointer as part of relational syntax in
	 * this parameter (i.e., varpointer:field).
	 * 
	 * @param request
	 *            Request Object for DID service.
	 * 
	 * @return Response Object containing RPC
	 * @throws VistaWebServiceFault
	 */
	@WebMethod
	public DIDGet1Response get1(
			@WebParam(name = "DIDGet1Request") DIDGet1Request request) throws VistaWebServiceFault;

}
