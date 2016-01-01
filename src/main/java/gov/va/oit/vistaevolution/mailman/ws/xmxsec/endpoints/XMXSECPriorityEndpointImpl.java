/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec.XMXSECResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECPriorityEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECPriorityRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECPriorityResponse;
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

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
@WebService(serviceName = "XMXSECPriorityService", portName = "XMXSECPriorityServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECPriorityEndpoint")
public class XMXSECPriorityEndpointImpl implements XMXSECPriorityEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXSECPriorityEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXSECResponseFactory xmxsecResponseFactory;

	private int errCount = 0;
	private List<String> errMsgs;

	/**
	 * Default Empty Constructor
	 */
	public XMXSECPriorityEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmxsecResponseFactory
	 */
	public XMXSECPriorityEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMXSECResponseFactory xmxsecResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xmxsecResponseFactory = xmxsecResponseFactory;
	}

	@Override
	public XMXSECPriorityResponse priority(XMXSECPriorityRequest request)
			throws VistaWebServiceFault {

		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();

		LinkedList<Object> params = getParameters(request);

		if (this.errCount > 0) {
			return new XMXSECPriorityResponse(null, errMsgs);
		} else {
			return xmxsecResponseFactory
					.createPriorityResponseFromString(getVistaLinkContext()
							.makeRPCCall(
									new RPCIdentifier(XMXSECConstants.CONTEXT,
											XMXSECConstants.PRIORITY_RPC),
									params));
		}
	}

	private LinkedList<Object> getParameters(XMXSECPriorityRequest request) {
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
						+ XMXSECConstants.ERR_MSG_REQD_INPUT
								.replace(XMXSECConstants.SRVNM,
										XMXSECConstants.PRIORITY));
				this.errMsgs
						.add(XMXSECConstants.ERR_MSG_START
								+ " XMZ - required.  Missing Message Internal Entry Number (IEN) , "
								+ XMXSECConstants.ERR_MSG_REQD_INPUT.replace(
										XMXSECConstants.SRVNM,
										XMXSECConstants.PRIORITY));
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
