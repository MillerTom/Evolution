package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4PADDEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PADDRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PADDResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "XUAF4PADDService", portName = "XUAF4PADDServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4PADDEndpoint")
public class XUAF4PADDEndpointImpl extends SpringBeanAutowiringSupport
	implements XUAF4PADDEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XUAF4PADDEndpointImpl.class);

    @Autowired
    private XUAF4ResponseFactory xuaf4ResponseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    /**
     * Default no arg constructor.
     */
    public XUAF4PADDEndpointImpl() {
    }

    /**
     * 
     * @param xuaf4ResponseFactory
     * @param vistaLinkContext
     */
    public XUAF4PADDEndpointImpl(XUAF4ResponseFactory xuaf4ResponseFactory,
	    IVistaLinkContext vistaLinkContext) {
	this.setXuaf4ResponseFactory(xuaf4ResponseFactory);
	this.setVistaLinkContext(vistaLinkContext);
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.
     * PADDXUAF4Endpoint
     * #PADD(gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.PADDXUAF4Request)
     */
    @Override
    public XUAF4PADDResponse PADD(XUAF4PADDRequest request)
	    throws VistaWebServiceFault {
	try {
	    LOGGER.debug(request);

	    LinkedList<Object> params = new LinkedList<Object>();
	    params.add(request.getIen());

	    XUAF4PADDResponse response = xuaf4ResponseFactory
		    .createPADDXUAF4Response(getVistaLinkContext().makeRPCCall(
			    new RPCIdentifier("EVOLUTION", "XU SOA PADD"),
			    params));

	    LOGGER.debug(response);
	    return response;
	} catch (NullPointerException e) {
	    LOGGER.error(e);
	    throw new VistaWebServiceFault(e);
	}
    }

    public XUAF4ResponseFactory getXuaf4ResponseFactory() {
	return xuaf4ResponseFactory;
    }

    protected void setXuaf4ResponseFactory(
	    XUAF4ResponseFactory xuaf4ResponseFactory) {
	this.xuaf4ResponseFactory = xuaf4ResponseFactory;
    }

    public IVistaLinkContext getVistaLinkContext() {
	return vistaLinkContext;
    }

    protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
	this.vistaLinkContext = vistaLinkContext;
    }

}
