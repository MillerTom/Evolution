package gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xma2r.XMA2RResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.XMA2REntEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntResponse;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.util.XMA2RConstants;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
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
@WebService(serviceName = "XMA2REntService", portName = "XMA2REntServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.XMA2REntEndpoint")
public class XMA2REntEndpointImpl extends SpringBeanAutowiringSupport 
		implements XMA2REntEndpoint {

	private static Logger LOGGER = Logger.getLogger(XMA2REntEndpointImpl.class);

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
	public XMA2REntEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xma2rResponseFactory
	 * @param vistaLinkContext
	 */
	public XMA2REntEndpointImpl(XMA2RResponseFactory xma2rResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xma2rResponseFactory = xma2rResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XMA2REntResponse ent(XMA2REntRequest request)
			throws VistaWebServiceFault {

		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();

		LinkedList<Object> params = getParameters(request);

		if (this.errCount > 0) {
			return new XMA2REntResponse(null, errMsgs);
		} else {
			return xma2rResponseFactory
					.createXMA2REntResponseFromString(getVistaLinkContext()
							.makeRPCCall(
									new RPCIdentifier(XMA2RConstants.CONTEXT,
											XMA2RConstants.ENT_RPC), params));
		}
	}

	private LinkedList<Object> getParameters(XMA2REntRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();
	
		if (request == null) {
			LOGGER.error(XMA2RConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(XMA2RConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		} else {

			if (StrUtils.hasAValue(request.getXmz())) {
				parameters.add(request.getXmz());
			} else {
				LOGGER.error(XMA2RConstants.ERR_MSG_START
						+ " XMZ - required.  Missing Message IEN, "
						+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
								XMA2RConstants.SRVNM, XMA2RConstants.ENT));
				this.errMsgs.add(XMA2RConstants.ERR_MSG_START
						+ " XMZ - required.  Missing Message IEN, "
						+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
								XMA2RConstants.SRVNM, XMA2RConstants.ENT));
				errCount++;
			}

			if (StrUtils.hasAValue(request.getXmsub())) {
				parameters.add(request.getXmsub());
			} else {
				LOGGER.error(XMA2RConstants.ERR_MSG_START
						+ " XMSUBJ - required.  Missing Subject of the message, "
						+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
								XMA2RConstants.SRVNM, XMA2RConstants.ENT));
				this.errMsgs
						.add(XMA2RConstants.ERR_MSG_START
								+ " XMSUBJ - required.  Missing Subject of the message, "
								+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
										XMA2RConstants.SRVNM,
										XMA2RConstants.ENT));
				errCount++;
			}

			if (request.getXmtext() != null && !request.getXmtext().isEmpty()) {
//				if (request.getXmtext().size() > 1) {
//					int index = 1;
//					HashMap<String, String> xmtext = new HashMap<String, String>();
//					for (String value : request.getXmtext()) {
//						xmtext.put(Integer.toString(index), value);
//						index++;
//					}
//					parameters.add(xmtext);
//				} else if (request.getXmtext().size() == 1) {
					parameters.add(request.getXmtext());
//				}
			} else {
				LOGGER.error(XMA2RConstants.ERR_MSG_START
						+ " XMTEXT - required.  Missing the array containing the text of the message, "
						+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
								XMA2RConstants.SRVNM, XMA2RConstants.ENT));
				this.errMsgs
						.add(XMA2RConstants.ERR_MSG_START
								+ " XMTEXT - required.  Missing the array containing the text of the message, "
								+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
										XMA2RConstants.SRVNM,
										XMA2RConstants.ENT));
				errCount++;
			}

			if (request.getXmstrip() != null) {
				parameters.add(request.getXmstrip());
			} else {
				parameters.add("");
			}

			if (StrUtils.hasAValue(request.getXmduz())) {
				parameters.add(request.getXmduz());
			} else {
				LOGGER.error(XMA2RConstants.ERR_MSG_START
						+ " XMDUZ - required.  Missing User's DUZ or Name of Sender(LastName,FirstName), "
						+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
								XMA2RConstants.SRVNM, XMA2RConstants.ENT));
				this.errMsgs
						.add(XMA2RConstants.ERR_MSG_START
								+ " XMDUZ - required.  Missing User's DUZ or Name of Sender(LastName,FirstName), "
								+ XMA2RConstants.ERR_MSG_REQD_INPUT.replace(
										XMA2RConstants.SRVNM,
										XMA2RConstants.ENT));
				errCount++;
			}

			if (request.getXmnet() != null) {
				parameters.add(request.getXmnet());
				
			} else {
				parameters.add("");
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
