package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4NNTEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTResponse;
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
@WebService(serviceName = "XUAF4NNTService", portName = "XUAF4NNTServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4NNTEndpoint")
public class XUAF4NNTEndpointImpl extends SpringBeanAutowiringSupport implements
	XUAF4NNTEndpoint {

    private static Logger LOGGER = Logger.getLogger(XUAF4NNTEndpointImpl.class);

    @Autowired
    private XUAF4ResponseFactory xuaf4ResponseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    /**
     * Default no arg constructor.
     */
    public XUAF4NNTEndpointImpl() {
	super();
    }

    /**
     * 
     * @param xuaf4ResponseFactory
     * @param vistaLinkContext
     */
    public XUAF4NNTEndpointImpl(XUAF4ResponseFactory xuaf4ResponseFactory,
	    IVistaLinkContext vistaLinkContext) {
	super();
	this.setXuaf4ResponseFactory(xuaf4ResponseFactory);
	this.setVistaLinkContext(vistaLinkContext);
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.
     * NNTXUAF4Endpoint
     * #NNT(gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.NNTXUAF4Request)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public XUAF4NNTResponse NNT(XUAF4NNTRequest request)
	    throws VistaWebServiceFault {

	LOGGER.debug(request);

	LinkedList params = new LinkedList();
	params.add(request.getIen());
	String rawRpcResponse = getVistaLinkContext().makeRPCCall(
		new RPCIdentifier("EVOLUTION", "XU SOA NNT"), params);

	XUAF4NNTResponse response = xuaf4ResponseFactory
		.createNNTXUAF4Response(rawRpcResponse);

	LOGGER.debug(response);
	return response;
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
