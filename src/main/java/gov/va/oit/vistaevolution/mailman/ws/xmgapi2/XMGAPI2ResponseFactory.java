/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi2;

import java.util.Arrays;

import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.model.XMGAPI2HdrResponse;

import org.springframework.stereotype.Component;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
public class XMGAPI2ResponseFactory {

	public XMGAPI2HdrResponse createXMGAPI2HdrResponseFromString(String rawResponse) {
		XMGAPI2HdrResponse response = new XMGAPI2HdrResponse();
		if (!rawResponse.startsWith("ERROR^")) {
			response.setData(rawResponse);
		} else {
			response.setStatus("ERROR");
			response.setErrors(Arrays.asList(rawResponse.split("\\^")[1]));
		}
		return response;
	}

}
