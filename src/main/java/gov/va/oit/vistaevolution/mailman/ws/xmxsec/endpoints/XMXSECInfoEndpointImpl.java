package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec.XMXSECResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECInfoEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECInfoRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECInfoResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.util.XMXSECConstants;
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
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
@WebService(serviceName = "XMXSECInfoService", portName = "XMXSECInfoServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECInfoEndpoint")
public class XMXSECInfoEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXSECInfoEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXSECInfoEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXSECResponseFactory xmxsecResponseFactory;

	private int errCount = 0;
	private List<String> errMsgs;

	/**
	 * Default Empty Constructor
	 */
	public XMXSECInfoEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmxsecResponseFactory
	 * @param vistaLinkContext
	 */
	public XMXSECInfoEndpointImpl(XMXSECResponseFactory xmxsecResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		this.xmxsecResponseFactory = xmxsecResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XMXSECInfoResponse info(XMXSECInfoRequest request)
			throws VistaWebServiceFault {

		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();

		LinkedList<Object> params = getParameters(request);

		if (this.errCount > 0) {
			return new XMXSECInfoResponse(null, errMsgs);
		} else {
			return xmxsecResponseFactory
					.createInfoResponseFromString(getVistaLinkContext()
							.makeRPCCall(
									new RPCIdentifier(XMXSECConstants.CONTEXT,
											XMXSECConstants.INFO_RPC), params));
		}
	}

	private LinkedList<Object> getParameters(XMXSECInfoRequest request) {
		LinkedList<Object> parameters = new LinkedList<Object>();
		if (request == null) {
			LOGGER.error(XMXSECConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(XMXSECConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		} else {
			if (request.getXmz() != null) {
				parameters.add(request.getXmz());
			} else {
				LOGGER.error(XMXSECConstants.ERR_MSG_START
						+ " XMZ - required.  Missing Message Internal Entry Number (IEN) , "
						+ XMXSECConstants.ERR_MSG_REQD_INPUT.replace(
								XMXSECConstants.SRVNM, XMXSECConstants.INFO));
				this.errMsgs
						.add(XMXSECConstants.ERR_MSG_START
								+ " XMZ - required.  Missing Message Internal Entry Number (IEN) , "
								+ XMXSECConstants.ERR_MSG_REQD_INPUT.replace(
										XMXSECConstants.SRVNM,
										XMXSECConstants.INFO));
				errCount++;
			}
		}
		return parameters;
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
	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	/**
	 * @return the xmxsecResponseFactory
	 */
	public XMXSECResponseFactory getXmxsecResponseFactory() {
		return xmxsecResponseFactory;
	}

	/**
	 * @param xmxsecResponseFactory
	 *            the xmxsecResponseFactory to set
	 */
	protected void setXmxsecResponseFactory(
			XMXSECResponseFactory xmxsecResponseFactory) {
		this.xmxsecResponseFactory = xmxsecResponseFactory;
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
	protected void setErrCount(int errCount) {
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
	protected void setErrMsgs(List<String> errMsgs) {
		this.errMsgs = errMsgs;
	}

	/**
	 * 
	 * @return the LOGGER
	 */
	public static Logger getLogger() {
		return LOGGER;
	}

}
