/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0;

import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkValue;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubGetResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
public class XMGAPI0ResponseFactory {
	private static final Logger LOGGER = Logger
			.getLogger(XMGAPI0ResponseFactory.class);

	/**
	 * 
	 * @param rawResponse
	 *            The raw response returned from the RPC.
	 * @return New {@link XMGAPI0SubGetResponse} containing subject requested
	 * @throws VistaWebServiceFault
	 *             If there is an error detected in the rawResponse
	 */
	public XMGAPI0SubGetResponse createXMGAPI0SubGetResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			if (!rawResponse.startsWith("-1^")) {
				String[] responseArray = rawResponse.split("\\^");
				XMGAPI0SubGetResponse response;
				if (responseArray.length > 1) {
					response = new XMGAPI0SubGetResponse(responseArray[0],
							responseArray[1]);
				} else {
					response = new XMGAPI0SubGetResponse(rawResponse);
				}
				LOGGER.debug(response);
				return response;
			} else {
				String[] result = rawResponse.split("\\^");
				XMGAPI0SubGetResponse response = new XMGAPI0SubGetResponse(
						result[0], Arrays.asList(result[1]));
				LOGGER.error(response);
				return response;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					"There an abnormality detected in the response from the source system.");
			LOGGER.error(fault);
			throw fault;
		}

	}

	/**
	 * @param makeRPCCall
	 * @return
	 * @throws VistaWebServiceFault
	 */
	public XMGAPI0SubChkResponse createXMGAPI0SubChkResponseFromString(
			String rawResponse) throws VistaWebServiceFault {

		String[] result;
		if (rawResponse.startsWith("0")) {
			result = rawResponse.split("\\^");
			return new XMGAPI0SubChkResponse(result[0], new XMGAPI0SubChkValue(
					result[1]));
		} else if (rawResponse.startsWith("^")) {
			result = rawResponse.split("\\^");
			LOGGER.debug("SubChkXMGAPI0 resulted in corrected subject: "
					+ result);
			return new XMGAPI0SubChkResponse(new XMGAPI0SubChkValue(result[1],
					true));
		} else {
			String[] responseArray = rawResponse.split("\\^");
			XMGAPI0SubChkResponse response = new XMGAPI0SubChkResponse(
					responseArray[0], Arrays.asList(responseArray[1]));
			LOGGER.error(response);
			return response;
		}
	}

}
