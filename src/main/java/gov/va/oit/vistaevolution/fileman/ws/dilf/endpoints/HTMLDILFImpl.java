package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.HTMLDILFEndPoint;

import javax.jws.WebService;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * 
 * 
 * @author bill.blackmon <bill.blackmon@medsphere.com>
 * 
 * 
 */

@Component
@WebService(serviceName = "HTMLDILFService", portName = "HTMLDILFServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.HTMLDILFEndPoint")
public class HTMLDILFImpl extends SpringBeanAutowiringSupport implements
	HTMLDILFEndPoint {

    // add method sigs
    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.
     * EncodeToHtmlDILFEndpoint#encodeToHTML(java.lang.String)
     */
    @Override
    public String encodeToHTML(String input) {
	return StringEscapeUtils.escapeHtml4(input);
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.
     * DecodeFromHtmlDILFEndpoint#decodeFromHTML(java.lang.String)
     */
    @Override
    public String decodeFromHTML(String input) {
	return StringEscapeUtils.unescapeHtml4(input);
    }

} // end class
