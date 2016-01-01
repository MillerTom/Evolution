/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmcu1;

import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1DecodeupResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1EncodeupResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1RtranResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1StranResponse;
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
public class XMCU1ResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XMCU1ResponseFactory.class);

	/**
	 * creating XMCU1EncodeupResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XMCU1EncodeupResponse
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XMCU1EncodeupResponse createXMCU1EncodeupResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMCU1EncodeupResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XMCU1EncodeupResponse(rawResponse);
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

	/**
	 * creating XMCU1DecodeupResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XMCU1DecodeupResponse
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XMCU1DecodeupResponse createXMCU1DecodeupResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMCU1DecodeupResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XMCU1DecodeupResponse(rawResponse);
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

	/**
	 * creating XMCU1StranResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XMCU1StranResponse
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XMCU1StranResponse createXMCU1StranResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMCU1StranResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XMCU1StranResponse(rawResponse);
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

	/**
	 * creating XMCU1RtranResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XMCU1RtranResponse
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XMCU1RtranResponse createXMCU1RtranResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			StringBuilder expectedResult = new StringBuilder();
			XMCU1RtranResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				if (Character.getType(rawResponse.charAt(0)) == Character.CONTROL) {
					for(int i=0; i<rawResponse.length(); i++){
						expectedResult.append(Integer.toString(rawResponse.charAt(i)));
					}
				} else{
					expectedResult.append(rawResponse);
			    }
				response = new XMCU1RtranResponse(expectedResult.toString());
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(" expectedResult  = " + expectedResult);
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
