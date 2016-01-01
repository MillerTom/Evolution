package gov.va.oit.vistaevolution.mailman.ws.xmd;

import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author rcollins
 * 
 */
@Component
public class XMDResponseFactory extends AbstractResponseFactory {

    public static final Logger LOGGER = Logger
	    .getLogger(XMDResponseFactory.class);

    /**
     * Default Constructor
     */
    public XMDResponseFactory() {
	super();
    }

    /**
     * @param makeRPCCall
     * @return
     * @throws VistaWebServiceFault
     */
    public XMDResponse createXMDResponse(String rawResponse) {
	try {
	    String[] responseArray = rawResponse.split("\\^");
	    XMDResponse response;
	    if (!rawResponse.startsWith("-1^") && !rawResponse.startsWith("1^")) {
		if (responseArray.length > 1) {
		    response = new XMDResponse(responseArray[0],
			    responseArray[1]);
		} else {
		    response = new XMDResponse(rawResponse);
		}

	    } else {
		response = new XMDResponse(responseArray[0],
			generateErrorsArray(rawResponse));
	    }
	    return response;
	} catch (ArrayIndexOutOfBoundsException e) {
	    VistaWebServiceFault fault = new VistaWebServiceFault(
		    "There an abnormality detected in the response from the source system.");
	    LOGGER.error(fault);
	    throw fault;
	}
    }
}
