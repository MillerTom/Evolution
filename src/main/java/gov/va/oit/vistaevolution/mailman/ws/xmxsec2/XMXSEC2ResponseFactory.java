package gov.va.oit.vistaevolution.mailman.ws.xmxsec2;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2EditResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OpteditResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OptmsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.utils.XMXSEC2Constants;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class XMXSEC2ResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XMXSEC2ResponseFactory.class);

	public XMXSEC2ResponseFactory() {
		super();
	}

	public XMXSEC2EditResponse createEditResponseFromString(String rawResponse) {
		String method = this.getClass() + ".createEditResponseFromString";
		LOGGER.info(method + ": Preparing XMXSEC2EditResponse to be Returned!");
		XMXSEC2EditResponse response = new XMXSEC2EditResponse();

		if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines.size() != 0) {
				if (rawLines.get(0).startsWith("-1^")) {
					response.getMsgRoot().add(rawLines.get(0));
				} else {
					response.setUserMayEdit(rawLines.get(0));
				}
			} else {
				LOGGER.info(method + ": No Data Found!");
			}
		} else {
			LOGGER.info(method + ": No Data Found!");
		}
		System.out.println(response.toString());
		return response;
	}

	/**
	 * creating XMXSEC2OpteditResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXSEC2OpteditResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXSEC2OpteditResponse createOpteditResponseFromString(
			String rawResponse) {
		try {
			XMXSEC2OpteditResponse response;
			List<String> msgRoot;
			List<String> optionsList;
			String method = this.getClass()
					+ ".createOpteditResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMXSEC2OpteditResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
				List<String> rawLines = processLines(rawResponse);
				if (rawLines.size() != 0) {
					if (rawLines.get(0).startsWith("-1^")) {
						LOGGER.warn(XMXSEC2Constants.ERR_MSG_INPUT);
						msgRoot = new ArrayList<String>();
						for (String line : rawLines) {
							String[] errorMessages = line.split("\\^");
							for (String entry : errorMessages) {
								msgRoot.add(entry);
							}
						}
						response = new XMXSEC2OpteditResponse(null, msgRoot);
					} else {
						LOGGER.info(XMXSEC2Constants.DATA_FOUND);
						optionsList = new ArrayList<String>();
						for (String entry : rawLines) {
							optionsList.add(entry);
						}
						response = new XMXSEC2OpteditResponse(optionsList, null);
					}
				} else {
					LOGGER.info(XMXSEC2Constants.NO_DATA_FOUND);
					msgRoot = new ArrayList<String>();
					msgRoot.add("");
					response = new XMXSEC2OpteditResponse(null, msgRoot);
				}
			} else {
				VistaWebServiceFault fault = new VistaWebServiceFault(
						XMXSEC2Constants.ERR_MSG_ABNORMAL);
				LOGGER.error(fault);
				throw fault;
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMXSEC2Constants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

	/**
	 * creating XMXSEC2OptmsgResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXSEC2OptmsgResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXSEC2OptmsgResponse createOptmsgResponseFromString(
			String rawResponse) {
		try {
			XMXSEC2OptmsgResponse response;
			List<String> msgRoot;
			List<String> optionsList;
			String method = this.getClass() + ".createOptmsgResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMXSEC2OptmsgResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
				List<String> rawLines = processLines(rawResponse);
				if (rawLines.size() != 0) {
					if (rawLines.get(0).startsWith("-1^")) {
						LOGGER.warn(XMXSEC2Constants.ERR_MSG_INPUT);
						msgRoot = new ArrayList<String>();
						for (String line : rawLines) {
							String[] errorMessages = line.split("\\^");
							for (String entry : errorMessages) {
								msgRoot.add(entry);
							}
						}
						response = new XMXSEC2OptmsgResponse(null, msgRoot);
					} else {
						LOGGER.info(XMXSEC2Constants.DATA_FOUND);
						optionsList = new ArrayList<String>();
						for (String entry : rawLines) {
							optionsList.add(entry);
						}
						response = new XMXSEC2OptmsgResponse(optionsList, null);
					}
				} else {
					LOGGER.info(XMXSEC2Constants.NO_DATA_FOUND);
					msgRoot = new ArrayList<String>();
					msgRoot.add("");
					response = new XMXSEC2OptmsgResponse(null, msgRoot);
				}
			} else {
				VistaWebServiceFault fault = new VistaWebServiceFault(
						XMXSEC2Constants.ERR_MSG_ABNORMAL);
				LOGGER.error(fault);
				throw fault;
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMXSEC2Constants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

}
