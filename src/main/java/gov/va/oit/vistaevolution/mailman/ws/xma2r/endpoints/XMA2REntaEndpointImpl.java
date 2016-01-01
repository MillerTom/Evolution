package gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xma2r.XMA2RResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.XMA2REntaEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaResponse;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.util.XMA2RConstants;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
@WebService(serviceName = "XMA2REntaService", portName = "XMA2REntaServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.XMA2REntaEndpoint")
public class XMA2REntaEndpointImpl extends SpringBeanAutowiringSupport 
		implements XMA2REntaEndpoint {

	private static Logger LOGGER = Logger.getLogger(XMA2REntaEndpointImpl.class);

	@Autowired
	private XMA2RResponseFactory xma2rResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	private int errCount = 0;
	private List<String> errMsgs;

	/**
	 * Default Empty Constructor
	 * 
	 */
	public XMA2REntaEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xma2rResponseFactory
	 * @param vistaLinkContext
	 */
	public XMA2REntaEndpointImpl(XMA2RResponseFactory xma2rResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xma2rResponseFactory = xma2rResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XMA2REntaResponse enta(XMA2REntaRequest request)
			throws VistaWebServiceFault {

		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();

		LinkedList<Object> params = getParameters(request);

		if (this.errCount > 0) {
			return new XMA2REntaResponse(null, errMsgs);
		} else {
			return xma2rResponseFactory
					.createXMA2REntaResponseFromString(getVistaLinkContext()
							.makeRPCCall(
									new RPCIdentifier(XMA2RConstants.CONTEXT,
											XMA2RConstants.ENTA_RPC), params));
		}

	}

	private LinkedList<Object> getParameters(XMA2REntaRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();
		
		if (request == null) {
			LOGGER.error(XMA2RConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(XMA2RConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		} else {

			if (request.getXmz() != null) {
				parameters.add(request.getXmz());
			} else {
				LOGGER.error(XMA2RConstants.ERR_MSG_START
						+ " XMZ - required.  Missing Message IEN, "
						+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
								XMA2RConstants.SRVNM, XMA2RConstants.ENTA));
				this.errMsgs.add(XMA2RConstants.ERR_MSG_START
						+ " XMZ - required.  Missing Message IEN, "
						+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
								XMA2RConstants.SRVNM, XMA2RConstants.ENTA));
				errCount++;
			}

			if (request.getXmsub() != null) {
				parameters.add(request.getXmsub());
			} else {
				LOGGER.error(XMA2RConstants.ERR_MSG_START
						+ " XMSUBJ - required.  Missing Subject of the message, "
						+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
								XMA2RConstants.SRVNM, XMA2RConstants.ENTA));
				this.errMsgs
						.add(XMA2RConstants.ERR_MSG_START
								+ " XMSUBJ - required.  Missing Subject of the message, "
								+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
										XMA2RConstants.SRVNM,
										XMA2RConstants.ENTA));
				errCount++;
			}

			if (request.getXmtext() != null) {
				if (request.getXmtext().size() > 1) {
					int index = 1;
					HashMap<String, String> xmtext = new HashMap<String, String>();
					for (String value : request.getXmtext()) {
						xmtext.put(Integer.toString(index), value);
						index++;
					}
					parameters.add(xmtext);
				} else if (request.getXmtext().size() == 1) {
					parameters.add(request.getXmtext().get(0));
				}
			} else {
				LOGGER.error(XMA2RConstants.ERR_MSG_START
						+ " XMTEXT - required.  Missing the array containing the text of the message, "
						+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
								XMA2RConstants.SRVNM, XMA2RConstants.ENTA));
				this.errMsgs
						.add(XMA2RConstants.ERR_MSG_START
								+ " XMTEXT - required.  Missing the array containing the text of the message, "
								+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
										XMA2RConstants.SRVNM,
										XMA2RConstants.ENTA));
				errCount++;
			}

			if (request.getXmstrip() != null) {
				parameters.add(request.getXmstrip());
			} else {
				parameters.add("");
			}

			if (request.getXmduz() != null) {
				parameters.add(request.getXmduz());
				
			} else {
				LOGGER.error(XMA2RConstants.ERR_MSG_START
						+ " XMDUZ - required.  Missing User's DUZ or FREE TEXT, "
						+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
								XMA2RConstants.SRVNM, XMA2RConstants.ENTA));
				this.errMsgs
						.add(XMA2RConstants.ERR_MSG_START
								+ " XMDUZ - required.  Missing User's DUZ or FREE TEXT, "
								+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
										XMA2RConstants.SRVNM,
										XMA2RConstants.ENTA));
				errCount++;
			}

		}

		
		return parameters;
	}

	/**
	 * @return the xma2rResponseFactory
	 */
	public XMA2RResponseFactory getXma2rResponseFactory() {
		return xma2rResponseFactory;
	}

	/**
	 * @param xma2rResponseFactory
	 *            the xma2rResponseFactory to set
	 */
	public void setXma2rResponseFactory(
			XMA2RResponseFactory xma2rResponseFactory) {
		this.xma2rResponseFactory = xma2rResponseFactory;
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
	 * @return the errCount
	 */
	public int getErrCount() {
		return errCount;
	}

	/**
	 * @param errCount
	 *            the errCount to set
	 */
	public void setErrCount(int errCount) {
		this.errCount = errCount;
	}

	/**
	 * @return the errMsgs
	 */
	public List<String> getErrMsgs() {
		return errMsgs;
	}

	/**
	 * @param errMsgs
	 *            the errMsgs to set
	 */
	public void setErrMsgs(List<String> errMsgs) {
		this.errMsgs = errMsgs;
	}

}
