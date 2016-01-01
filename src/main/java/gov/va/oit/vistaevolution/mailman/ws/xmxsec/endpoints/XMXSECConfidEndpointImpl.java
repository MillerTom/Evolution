package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec.XMXSECResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECConfidEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECConfidRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECConfidResponse;
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
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
@WebService(serviceName = "XMXSECConfidService", portName = "XMXSECConfidServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECConfidEndpoint")
public class XMXSECConfidEndpointImpl implements XMXSECConfidEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXSECConfidEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXSECResponseFactory xmxsecResponseFactory;

	private int errCount = 0;
	private List<String> errMsgs;

	/**
	 * Default Empty Constructor
	 */
	public XMXSECConfidEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmxsecResponseFactory
	 */
	public XMXSECConfidEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMXSECResponseFactory xmxsecResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xmxsecResponseFactory = xmxsecResponseFactory;
	}

	@Override
	public XMXSECConfidResponse confid(XMXSECConfidRequest request)
			throws VistaWebServiceFault {

		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();

		LinkedList<Object> params = getParameters(request);

		if (this.errCount > 0) {
			return new XMXSECConfidResponse(null, errMsgs);
		} else {
			return xmxsecResponseFactory
					.createConfidResponseFromString(getVistaLinkContext()
							.makeRPCCall(
									new RPCIdentifier(XMXSECConstants.CONTEXT,
											XMXSECConstants.CONFID_RPC), params));
		}
	}

	private LinkedList<Object> getParameters(XMXSECConfidRequest request) {
		LinkedList<Object> parameters = new LinkedList<Object>();

		if (request == null) {
			LOGGER.error(XMXSECConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(XMXSECConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		} else {

			if (request.getXmzrec() != null) {
				parameters.add(request.getXmzrec());
			} else {
				LOGGER.error(XMXSECConstants.ERR_MSG_START
						+ " XMZ - required.  Missing Message Internal Entry Number (IEN) , "
						+ XMXSECConstants.ERR_MSG_REQD_INPUT.replace(
								XMXSECConstants.SRVNM, XMXSECConstants.CONFID));
				this.errMsgs
						.add(XMXSECConstants.ERR_MSG_START
								+ " XMZ - required.  Missing Message Internal Entry Number (IEN) , "
								+ XMXSECConstants.ERR_MSG_REQD_INPUT.replace(
										XMXSECConstants.SRVNM,
										XMXSECConstants.CONFID));
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
