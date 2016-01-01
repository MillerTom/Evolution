package gov.va.oit.vistaevolution.mailman.ws.xmrent;

import gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
@Component
public class XMRENTResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XMRENTResponseFactory.class);
	public XMRENTResponseFactory() {
		super();
	}
	
	public XMRENTNetResponse createXMRENTNetResponseFromString(String rawResponse) {
	    LOGGER.debug("Returned Data : " + rawResponse);
	    return new XMRENTNetResponse(rawResponse);
	}

}
