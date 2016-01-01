package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBCre8BsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8BsktResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.utils.XMXAPIBConstants;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
public class XMXAPIBCre8BsktEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPIBCre8BsktEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIBCre8BsktEndpointImpl.class);

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    @Autowired
    private XMXAPIBResponseFactory responseFactory;

    public XMXAPIBCre8BsktEndpointImpl() {
	super();
    }

    public XMXAPIBCre8BsktEndpointImpl(IVistaLinkContext vistaLinkContext,
	    XMXAPIBResponseFactory responseFactory) {
	this.vistaLinkContext = vistaLinkContext;
	this.responseFactory = responseFactory;
    }

    @Override
    public XMXAPIBCre8BsktResponse cre8Bskt(XMXAPIBCre8BsktRequest request)
	    throws VistaWebServiceFault {
	LOGGER.debug(request);
	List<Object> params = getParameterArray(request);
	XMXAPIBCre8BsktResponse response = responseFactory
		.createCre8BsktResponse(vistaLinkContext.makeRPCCall(
			new RPCIdentifier(VistaConstants.CONTEXT,
				XMXAPIBConstants.CREBSKT_RPC), params));
	LOGGER.debug(response);
	return response;
    }

    private List<Object> getParameterArray(XMXAPIBCre8BsktRequest request) {
	LinkedList<Object> params = new LinkedList<Object>();
	params.add(request.getDuz());
	params.add(request.getXmDuz());
	params.add(request.getXmkn());
	return params;
    }
}
