/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqcs;

import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSChkResponse;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSOptlkResponse;
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
public class XQCSResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XQCSResponseFactory.class);

	/**
	 * creating XQCSOptlkResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XQCSOptlkResponse
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XQCSOptlkResponse createXQCSOptlkResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XQCSOptlkResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XQCSOptlkResponse(rawResponse);
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
	 * creating XQCSChkResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XQCSChkResponse
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XQCSChkResponse createXQCSChkResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			XQCSChkResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XQCSChkResponse(rawResponse);
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
