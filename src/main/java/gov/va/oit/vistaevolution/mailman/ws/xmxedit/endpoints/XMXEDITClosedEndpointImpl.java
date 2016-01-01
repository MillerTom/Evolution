
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITClosedEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITClosedRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITClosedResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITClosedEndpoint
 * @author rcollins
 *
 */
 @Component
 @WebService(serviceName="XMXEDITClosedService",
  portName="XMXEDITClosedServicePort",
  endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITClosedEndpoint")
public class XMXEDITClosedEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXEDITClosedEndpoint{


    private static final String RPCCALL = "XMWSOA CLOSED TOGGLE";

    private static final Logger LOG = Logger
            .getLogger(XMXEDITClosedEndpointImpl.class);

    @Autowired
    private XMXEDITResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    /**
     * Default Bean Constructor
     */
    public XMXEDITClosedEndpointImpl() {
        super();
    }

    /**
     * Constructor initilizes object
     * @param context
     * @param factory
     */
    public XMXEDITClosedEndpointImpl(final IVistaLinkContext context,
            final XMXEDITResponseFactory factory) {

        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }

    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITClosedEndpoint#closed(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITClosedRequest)
     */
    @Override
    public XMXEDITClosedResponse closed(XMXEDITClosedRequest request)
            throws VistaWebServiceFault {

    	if (request == null ) {
    		throw new VistaWebServiceFault("NULL REQUEST!!!");
    	}
    	
        try {
            List<Object> params = new ArrayList<Object>(2);
            Map<String, String> flags = new HashMap<String, String>(1);

            flags.put("FLAGS", request.getXminstr());

            params.add(0, request.getXmz());
            params.add(1, flags);
            
            String rawResponse = this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params);

            return this.responseFactory
                    .createClosedFromString(rawResponse);
        } catch (VistaWebServiceFault e) {
			LOG.error(e);
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			LOG.error(e);
			throw new VistaWebServiceFault(e);
		}
    }

}
