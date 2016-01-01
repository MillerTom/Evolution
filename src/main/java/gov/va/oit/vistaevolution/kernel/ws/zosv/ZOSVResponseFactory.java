/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.zosv;

import gov.va.oit.vistaevolution.kernel.ws.zosv.model.ZOSVGetPeerResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *
 */
@Component
public class ZOSVResponseFactory extends AbstractResponseFactory {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(ZOSVResponseFactory.class);
	
	public ZOSVGetPeerResponse createZOSVGetPeerResponseFromString(String rawResponse) {

		return new ZOSVGetPeerResponse(rawResponse);
	}
	
	
}
