/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2SubjEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName = "XMXUTIL2SubjService", portName = "XMXUTIL2SubjServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2SubjEndpoint")
public class XMXUTIL2SubjEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTIL2SubjEndpoint {
	
	private static final String RPCCALL = "XMWSOA GET MSG SUBJECT";
	
	private static final Logger LOGGER = Logger
			.getLogger(XMXUTIL2SubjEndpointImpl.class);

	@Autowired
	private XMXUtil2ResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;

	public XMXUTIL2SubjEndpointImpl() {
		super();
	}

	public XMXUTIL2SubjEndpointImpl(IVistaLinkContext vistaLinkContext, XMXUtil2ResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2SubjEndpoint#subj(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjRequest)
	 */
	@Override
	public XMXUTIL2SubjResponse subj(XMXUTIL2SubjRequest request)
			throws VistaWebServiceFault {

        try {
            
            List<String> params = new ArrayList<String>();
            
            params.add(request.getXmzrec());
            
            return this.responseFactory
                    .createSubjFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        } catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

}
