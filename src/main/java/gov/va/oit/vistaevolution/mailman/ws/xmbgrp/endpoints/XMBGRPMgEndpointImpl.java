package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.XMBGRPResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces.XMBGRPMgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPMgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPMgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMYEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.util.XMBGRPConstants;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
@WebService(serviceName = "XMBGRPMgService", portName = "XMBGRPMgServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces.XMBGRPMgEndpoint")
public class XMBGRPMgEndpointImpl extends SpringBeanAutowiringSupport implements
		XMBGRPMgEndpoint {

	private static Logger LOGGER = Logger.getLogger(XMBGRPMgEndpointImpl.class);

	@Autowired
	private XMBGRPResponseFactory xmbgrpResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public XMBGRPMgEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmbgrpResponseFactory
	 * @param vistaLinkContext
	 */
	public XMBGRPMgEndpointImpl(XMBGRPResponseFactory xmbgrpResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xmbgrpResponseFactory = xmbgrpResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XMBGRPMgResponse mg(XMBGRPMgRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			List<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XMBGRPConstants.MG_RPC), params);

			XMBGRPMgResponse response = xmbgrpResponseFactory
					.createXMBGRPMgResponseFromString(rawResponse);

			return response;

		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					VistaConstants.ERR_MSG_ABNORMAL + " : [ " + e.getMessage()
							+ " ]");
			if (LOGGER.isEnabledFor(Level.ERROR)) {
				LOGGER.error(fault);
			}
			throw new VistaWebServiceFault(e);
		}

	}

	private List<Object> getParameters(XMBGRPMgRequest request) {

		LinkedList<Object> params = new LinkedList<Object>();

		if (request.getXmgroup() != null) {
			params.add(request.getXmgroup());
		}

		if (request.getXmtype() != null) {
			params.add(request.getXmtype());
		}

		if (request.getXmorg() != null) {
			params.add(request.getXmorg());
		}

		if (request.getXmself() != null) {
			params.add(request.getXmself());
		}

		if (request.getXmy() != null) {
			HashMap<String, String> xmy = new HashMap<String, String>();
			for (XMYEntry entry : request.getXmy()) {
				xmy.put(entry.getKey(), entry.getValue());
			}
			params.add(xmy);
		}

		if (request.getXmdesc() != null) {
			int index = 1;
			HashMap<String, String> xmdesc = new HashMap<String, String>();
			for (String line : request.getXmdesc()) {
				xmdesc.put(Integer.toString(index), line);
				index++;
			}
			params.add(xmdesc);
		}

		return params;
	}

	/**
	 * @return the xmbgrpResponseFactory
	 */
	public XMBGRPResponseFactory getXmbgrpResponseFactory() {
		return xmbgrpResponseFactory;
	}

	/**
	 * @param xmbgrpResponseFactory
	 *            the xmbgrpResponseFactory to set
	 */
	public void setXmbgrpResponseFactory(
			XMBGRPResponseFactory xmbgrpResponseFactory) {
		this.xmbgrpResponseFactory = xmbgrpResponseFactory;
	}

	/**
	 * @return the vistaLinkContext
	 */
	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	/**
	 * @param vistaLinkContext
	 *            the vistaLinkContext to set
	 */
	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	/**
	 * returns the raw response from the RPC call
	 * 
	 * @return raw string from successful RPC call
	 */
	public String getRawResponse() {
		return rawResponse;
	}

	@Override
	public String toString() {
		return "XMBGRPMgEndpointImpl [xmbgrpResponseFactory="
				+ xmbgrpResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
