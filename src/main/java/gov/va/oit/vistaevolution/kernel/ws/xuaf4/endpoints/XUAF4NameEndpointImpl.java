/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4NameEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NameRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NameResponse;
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
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "XUAF4NameService", portName = "XUAF4NameServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4NameEndpoint")
public class XUAF4NameEndpointImpl extends SpringBeanAutowiringSupport
	implements XUAF4NameEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XUAF4NameEndpointImpl.class);

    @Autowired
    private XUAF4ResponseFactory xuaf4ResponseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    /**
     * Default no arg constructor.
     */
    public XUAF4NameEndpointImpl() {
    }

    /**
     * @param xuaf4ResponseFactory
     * @param vistaLinkContext
     */
    public XUAF4NameEndpointImpl(XUAF4ResponseFactory xuaf4ResponseFactory,
	    IVistaLinkContext vistaLinkContext) {
	this.setXuaf4ResponseFactory(xuaf4ResponseFactory);
	this.setVistaLinkContext(vistaLinkContext);
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.
     * NameXUAF4Endpoint
     * #Name(gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.NameXUAF4Request)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public XUAF4NameResponse name(XUAF4NameRequest request)
	    throws VistaWebServiceFault {
	try {
	    LOGGER.debug(request);

	    LinkedList params = new LinkedList();
	    // HashMap<String, String> parameterMap = new
	    // HashMap<String,String>();
	    // parameterMap.put("IEN", request.getIEN());
	    params.add(request.getIEN());
	    // params.add(parameterMap);

	    XUAF4NameResponse response = xuaf4ResponseFactory
		    .createNameXUAF4Response(getVistaLinkContext().makeRPCCall(
			    new RPCIdentifier("EVOLUTION", "XU SOA NAME"),
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
