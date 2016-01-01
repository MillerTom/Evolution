/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.AbstractXMXUTILResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBnmsgctResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBpmsgctResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILMakenewResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNameResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNetNameResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNewsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNonewResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTmsgctResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTnmsgctResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTpmsgctResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.util.XMXUTILConstants;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Christopher Schuck
 * 
 */
@Component
public class XMXUTILResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XMXUTILResponseFactory.class);

	public XMXUTILResponseFactory() {
		super();
	}

	public XMXUTILBmsgctResponse createBmsgctFromString(String rawResponse) {
		String method = this.getClass() + ".createBmsgctFromString";
		LOGGER.info(method
				+ ": Preparing XMXUTILBmsgctResponse to be Returned!");
		XMXUTILBmsgctResponse response = new XMXUTILBmsgctResponse();

		return (XMXUTILBmsgctResponse) createXMXUTILResponseFromString(
				response, rawResponse, method);
	}

	public XMXUTILBnmsgctResponse createBnmsgctFromString(String rawResponse) {
		String method = this.getClass() + ".createBnmsgctResponseFromString";
		LOGGER.info(method
				+ ": Preparing XMXUTILBnmsgctResponse to be Returned!");
		XMXUTILBnmsgctResponse response = new XMXUTILBnmsgctResponse();

		return (XMXUTILBnmsgctResponse) createXMXUTILResponseFromString(
				response, rawResponse, method);
	}

	/**
	 * This method returns a structured XMXUTILBsktnameResponse object based on
	 * the raw string response that is passed in.
	 * 
	 * @param rawResponse
	 * @return XMXUTILBsktnameResponse
	 */
	public XMXUTILBsktnameResponse createBsktnameFromString(String rawResponse) {
		String method = this.getClass() + ".createBsktnameFromString";
		LOGGER.info(method
				+ ": Preparing XMXUTILBsktnameResponse to be Returned!");
		LOGGER.debug("Returned Data : " + rawResponse);
		try {
			List<String> rawLines = processLines(rawResponse);
			String response = rawLines.get(0);
			if (!response.contains("^")) {
				return new XMXUTILBsktnameResponse(response);
			} else {
				LOGGER.debug("response: " + response);
				List<String> bsktList = StrUtils.stringtoList(response, "\\^");
				/*
				 * String[] strgs = response.split("\\^");
				 * LOGGER.debug("size of strgs: " + strgs.length); List<String>
				 * bsktList = Arrays.asList(strgs);
				 */
				LOGGER.debug("size of basket list: " + bsktList.size());
				return new XMXUTILBsktnameResponse(bsktList.get(0),
						bsktList.get(1));
			}
		} catch (Exception ex) {
			LOGGER.error("ABNORMAL RESPONSE FOR BASKET NAME QUERY: " + ex);
			return new XMXUTILBsktnameResponse("0");
		}
	}

	/**
	 * This method returns a structured XMXUTILBpmsgctResponse object based on
	 * the raw string response that is passed in.
	 * 
	 * @param rawResponse
	 * @return XMXUTILBpmsgctResponse
	 */
	public XMXUTILBpmsgctResponse createBpmsgctFromString(
			final String rawResponse) {

		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Returned Data : " + rawResponse);

		return new XMXUTILBpmsgctResponse(rawResponse);
	}

	public XMXUTILNameResponse createXMXUTILNameResponseFromString(
			String rawResponse) {
		LOGGER.debug("Returned Data : " + rawResponse);
		return new XMXUTILNameResponse(rawResponse);
	}

	public XMXUTILNetNameResponse createXMXUTILNetNameResponseFromString(
			String rawResponse) {
		LOGGER.debug("Returned Data : " + rawResponse);
		return new XMXUTILNetNameResponse(rawResponse);
	}

	public XMXUTILNewsResponse createXMXUTILNewsResponseFromString(
			String rawResponse) {
		LOGGER.debug("Returned Data : " + rawResponse);
		return new XMXUTILNewsResponse(rawResponse);
	}

	private AbstractXMXUTILResponse createXMXUTILResponseFromString(
			AbstractXMXUTILResponse response, String rawResponse, String method) {

		if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines.size() != 0) {
				response.setReturns(rawLines.get(0));
			} else {
				LOGGER.info(method + ": No Data Found!");
			}
		} else {
			LOGGER.info(method + ": No Data Found!");
		}

		return response;
	}

	public XMXUTILKvaporResponse createKvaporFromString(String rawResponse) {
		String method = this.getClass() + ".createKvaporFromString";
		LOGGER.info(method
				+ ": Preparing XMXUTILKvaporResponse to be Returned!");
		LOGGER.debug("Returned Data : " + rawResponse);
		if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines != null && rawLines.size() != 0) {
				return new XMXUTILKvaporResponse(rawLines.get(0));
			} else {
				LOGGER.info(method + ": No Data Found!");
				return new XMXUTILKvaporResponse();
			}
		} else {
			LOGGER.info(method + ": No Data Found!");
			return new XMXUTILKvaporResponse();
		}

	}

	/**
	 * creating XMXUTILTmsgctResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXUTILTmsgctResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXUTILTmsgctResponse createTmsgctResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMXUTILTmsgctResponse response;
			String method = this.getClass() + ".createTmsgctResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMXUTILTmsgctResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null) {
				if (rawResponse.contains("-1")) {
					LOGGER.warn(XMXUTILConstants.ERR_MSG_INPUT);
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> lines = new ArrayList<String>();
					for (String entry : errorMessages) {
						lines.add(entry);
					}
					response = new XMXUTILTmsgctResponse(null, lines);
				} else if (rawResponse.isEmpty()) {
					LOGGER.info(XMXUTILConstants.NO_DATA_FOUND);
					response = new XMXUTILTmsgctResponse("", null);
				} else {
					LOGGER.info(XMXUTILConstants.DATA_FOUND);
					response = new XMXUTILTmsgctResponse(rawResponse, null);
				}
			} else {
				LOGGER.error(XMXUTILConstants.ERR_MSG_ABNORMAL);
				response = new XMXUTILTmsgctResponse(null, null);
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMXUTILConstants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

	/**
	 * creating XMXUTILTnmsgctResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXUTILTnmsgctResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXUTILTnmsgctResponse createTnmsgctResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMXUTILTnmsgctResponse response;
			String method = this.getClass()
					+ ".createTnmsgctResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMXUTILTnmsgctResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null) {
				if (rawResponse.contains("-1")) {
					LOGGER.warn(XMXUTILConstants.ERR_MSG_INPUT);
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> lines = new ArrayList<String>();
					for (String entry : errorMessages) {
						lines.add(entry);
					}
					response = new XMXUTILTnmsgctResponse(null, lines);
				} else if (rawResponse.isEmpty()) {
					LOGGER.info(XMXUTILConstants.NO_DATA_FOUND);
					response = new XMXUTILTnmsgctResponse("", null);
				} else {
					LOGGER.info(XMXUTILConstants.DATA_FOUND);
					response = new XMXUTILTnmsgctResponse(rawResponse, null);
				}
			} else {
				LOGGER.error(XMXUTILConstants.ERR_MSG_ABNORMAL);
				response = new XMXUTILTnmsgctResponse(null, null);
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMXUTILConstants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

	/**
	 * creating XMXUTILTpmsgctResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXUTILTpmsgctResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXUTILTpmsgctResponse createTpmsgctResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMXUTILTpmsgctResponse response;
			String method = this.getClass()
					+ ".createTpmsgctResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMXUTILTpmsgctResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null) {
				if (rawResponse.contains("-1")) {
					LOGGER.warn(XMXUTILConstants.ERR_MSG_INPUT);
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> lines = new ArrayList<String>();
					for (String entry : errorMessages) {
						lines.add(entry);
					}
					response = new XMXUTILTpmsgctResponse(null, lines);
				} else if (rawResponse.isEmpty()) {
					LOGGER.info(XMXUTILConstants.NO_DATA_FOUND);
					response = new XMXUTILTpmsgctResponse("", null);
				} else {
					LOGGER.info(XMXUTILConstants.DATA_FOUND);
					response = new XMXUTILTpmsgctResponse(rawResponse, null);
				}
			} else {
				LOGGER.error(XMXUTILConstants.ERR_MSG_ABNORMAL);
				response = new XMXUTILTpmsgctResponse(null, null);
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMXUTILConstants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

	/**
	 * creating XMXUTILNonewResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXUTILNonewResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXUTILNonewResponse createNonewResponseFromString(String rawResponse) {
		try {
			XMXUTILNonewResponse response;
			String method = this.getClass() + ".createNonewResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMXUTILNonewResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null) {
				if (rawResponse.contains("^Successful")) {
					LOGGER.info(VistaConstants.DATA_FOUND);
					String[] data = rawResponse.split("\\^");
					ArrayList<String> lines = new ArrayList<String>();
					for (String entry : data) {
						lines.add(entry);
					}
					response = new XMXUTILNonewResponse(lines, null);
				} else {
					LOGGER.warn(VistaConstants.ERR_MSG_INPUT);
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> lines = new ArrayList<String>();
					for (String entry : errorMessages) {
						lines.add(entry);
					}
					response = new XMXUTILNonewResponse(null, lines);
				}
			} else {
				VistaWebServiceFault fault = new VistaWebServiceFault(
						VistaConstants.ERR_MSG_ABNORMAL);
				LOGGER.error(fault);
				throw fault;
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					VistaConstants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

	/**
	 * creating XMXUTILMakenewResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXUTILMakenewResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXUTILMakenewResponse createXMXUTILMakenewResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMXUTILMakenewResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
				response = new XMXUTILMakenewResponse(rawResponse);
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
