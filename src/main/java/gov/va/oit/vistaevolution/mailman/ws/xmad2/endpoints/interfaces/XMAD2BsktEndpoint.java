package gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMAD2Bskt", targetNamespace = "http://vistaevolution.va.gov")
public interface XMAD2BsktEndpoint {

	/**
	 * 
	 * This extrinsic function, given a basket name and a user's DUZ, looks up
	 * the basket. If it does not exist, creates it and returns its Internal
	 * Entry Number (IEN). If it does exist, it returns its IEN. If there's an
	 * error, it returns an error message.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XMAD2^BSKT input Parameters
	 * 
	 * @return XMAD2BsktResponse
	 * 
	 *         Domain Object that contains XMAD2^BSKT output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMAD2BsktAction", operationName = "XMAD2Bskt")
	public XMAD2BsktResponse bskt(
			@WebParam(name = "XMAD2BsktRequest") XMAD2BsktRequest request)
			throws VistaWebServiceFault;
}
