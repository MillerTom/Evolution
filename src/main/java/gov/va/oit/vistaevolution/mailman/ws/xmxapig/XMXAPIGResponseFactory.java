package gov.va.oit.vistaevolution.mailman.ws.xmxapig;

import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGAddMbrsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGGotLocalResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class XMXAPIGResponseFactory extends AbstractResponseFactory {

	private static final Logger LOG = Logger.getLogger(XMXAPIGResponseFactory.class);

	public XMXAPIGResponseFactory() {
	}

	public XMXAPIGGotLocalResponse createGotLocalResponse(String rawResponse) {
		XMXAPIGGotLocalResponse response;
		if (rawResponse.equals("0") || rawResponse.equals("1")) {
			response = new XMXAPIGGotLocalResponse(rawResponse);
		} else if (rawResponse.startsWith("-1")) {
			String[] responseArray = rawResponse.split("\\^");
			response = new XMXAPIGGotLocalResponse(responseArray[0], Arrays.asList(responseArray[1]));
		} else {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					"There an abnormality detected in the response from the source system.");
			LOG.error(fault);
			throw fault;
		}
		return response;
	}

	/**
	 * @param rawResponse
	 * @return
	 */
	public XMXAPIGAddMbrsResponse createXMXAPIGAddMbrsResponse(String rawResponse) {
		try {

			if (!rawResponse.startsWith("-1")) {
				String[] responseArray = rawResponse.split("\\^");
				XMXAPIGAddMbrsResponse response;
				if (responseArray.length > 1) {
					response = new XMXAPIGAddMbrsResponse(responseArray[1]);
					response.setStatus(responseArray[0]);
				} else {
					response = new XMXAPIGAddMbrsResponse(rawResponse);
				}
				LOG.debug(response);
				return response;
			} else {
				String status = rawResponse.split("\\^")[0];
				String result = rawResponse.split("\\^")[1];
				XMXAPIGAddMbrsResponse response = new XMXAPIGAddMbrsResponse(status, Arrays.asList(result));
				LOG.error(response);
				return response;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					"There an abnormality detected in the response from the source system.");
			LOG.error(fault);
			throw fault;
		}
	}

	public XMXAPIGJoinResponse createJoinFromString(String rawResponse) {
		String method = this.getClass() + ".createJoinFromString";
		LOG.info(method + ": Preparing XMXAPIGJoinResponse to be Returned!");
		List<String> rawLines = processLines(rawResponse);
		if (rawLines != null && rawLines.size() > 0) {
			return new XMXAPIGJoinResponse(rawLines.get(0));
		} else {
			return new XMXAPIGJoinResponse();
		}
	}

} // end class
