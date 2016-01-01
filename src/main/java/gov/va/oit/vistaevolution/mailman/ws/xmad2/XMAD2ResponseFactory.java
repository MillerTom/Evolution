/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmad2;

import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
public class XMAD2ResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XMAD2ResponseFactory.class);

	/**
	 * creating XMAD2BsktResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XMAD2BsktResponse
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XMAD2BsktResponse createXMAD2BsktResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMAD2BsktResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XMAD2BsktResponse(rawResponse);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("response=" + response);
				}
				return response;
			} else {
				VistaWebServiceFault fault = new VistaWebServiceFault(
						VistaConstants.ERR_MSG_ABNORMAL
								+ " : [ RPC returned NULL rawResponse ]");
				if (LOGGER.isEnabledFor(Level.ERROR)) {
					LOGGER.error(fault);
				}
				throw fault;
			}
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					VistaConstants.ERR_MSG_ABNORMAL + " : [ " + e.getMessage()
							+ " ]");
			if (LOGGER.isEnabledFor(Level.ERROR)) {
				LOGGER.error(fault);
			}
			throw fault;
		}
	}
}
