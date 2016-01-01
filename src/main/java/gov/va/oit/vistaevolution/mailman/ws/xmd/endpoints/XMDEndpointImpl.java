/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints;

import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmd.XMDResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMYEntry;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
@WebService(serviceName = "XMDService", portName = "XMDServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint")
public class XMDEndpointImpl extends SpringBeanAutowiringSupport implements
	XMDEndpoint {

    public static final Logger LOGGER = Logger
	    .getLogger(XMDEN1EndpointImpl.class);

    @Autowired
    private XMDResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    /**
     * Default no-arg constructor
     */
    public XMDEndpointImpl() {
	super();
    }

    /**
     * @param vistaLinkContext
     * @param responseFactory
     */
    public XMDEndpointImpl(IVistaLinkContext vistaLinkContext,
	    XMDResponseFactory responseFactory) {
	this.setVistaLinkContext(vistaLinkContext);
	this.setResponseFactory(responseFactory);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEnt1Endpoint
     * #ent1(gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEnt1Request)
     */
    @Override
    public XMDResponse xmd(XMDRequest request) throws VistaWebServiceFault {
	List<Object> params = getParameterArray(request);

	LOGGER.debug(request);

	String rawResponse = getVistaLinkContext().makeRPCCall(
		new RPCIdentifier("XMWSOA XMD"), params);

	XMDResponse response = responseFactory.createXMDResponse(rawResponse);

	LOGGER.debug(response);

	return response;
    }

    /**
     * @param request
     *            request to be broken down into a {@link RpcRequest} parameter
     *            array
     * @return
     * @throws VistaWebServiceFault
     */
    private List<Object> getParameterArray(XMDRequest request)
	    throws VistaWebServiceFault {
	LinkedList<Object> params = new LinkedList<Object>();

	// Add Duz
	params.add(request.getDuz());

	// xmDuz
	if (request.getXmDuz() != null)
	    params.add(request.getXmDuz());
	else
	    params.add(request.getXmDuz());

	// xmSub
	params.add(request.getXmSub());

	// Build hashmap with keys of line numbers for each line of the message.
	HashMap<String, String> MSG = new HashMap<String, String>(0);
	if (request.getMessage() != null) {
	    int index = 1;
	    for (String line : request.getMessage()) {
		MSG.put(Integer.toString(index), line);
		index++;
	    }
	}
	params.add(MSG);

	// put each entry key and value from the XMY Entry list to a map, then
	// add in parameter array.
	HashMap<String, String> xmy = new HashMap<String, String>(0);
	if (request.getxMY() != null) {
	    for (XMYEntry entry : request.getxMY()) {
		xmy.put(entry.getKey(), entry.getValue());
	    }
	}
	params.add(xmy);

	// xmStrip
	if (request.getXmStrip() != null)
	    params.add(request.getXmStrip());

	return params;
    }

    public IVistaLinkContext getVistaLinkContext() {
	return vistaLinkContext;
    }

    protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
	this.vistaLinkContext = vistaLinkContext;
    }

    public XMDResponseFactory getResponseFactory() {
	return responseFactory;
    }

    protected void setResponseFactory(XMDResponseFactory xmdResponseFactory) {
	this.responseFactory = xmdResponseFactory;
    }

}
