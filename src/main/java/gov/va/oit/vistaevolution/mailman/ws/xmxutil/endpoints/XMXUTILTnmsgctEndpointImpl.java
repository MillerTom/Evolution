/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILTnmsgctEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTnmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTnmsgctResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.util.XMXUTILConstants;
import gov.va.oit.vistaevolution.util.VistaConstants;
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
@WebService(serviceName = "XMXUTILTnmsgctService", portName = "XMXUTILTnmsgctServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILTnmsgctEndpoint")
public class XMXUTILTnmsgctEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTILTnmsgctEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXUTILTnmsgctEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXUTILResponseFactory xmxutilResponseFactory;

	private int errCount = 0;
	private List<String> errMsgs;

	/**
	 * Default Empty Constructor
	 */
	public XMXUTILTnmsgctEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmxutilResponseFactory
	 */
	public XMXUTILTnmsgctEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMXUTILResponseFactory xmxutilResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xmxutilResponseFactory = xmxutilResponseFactory;
	}

	@Override
	public XMXUTILTnmsgctResponse tnmsgct(XMXUTILTnmsgctRequest request)
			throws VistaWebServiceFault {

		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();

		LinkedList<Object> params = getParameters(request);

		if (this.errCount > 0) {
			return new XMXUTILTnmsgctResponse(null, errMsgs);
		} else {
			return xmxutilResponseFactory
					.createTnmsgctResponseFromString(getVistaLinkContext()
							.makeRPCCall(
									new RPCIdentifier(XMXUTILConstants.CONTEXT,
											XMXUTILConstants.TNMSGCT_RPC),
									params));
		}
	}

	private LinkedList<Object> getParameters(XMXUTILTnmsgctRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		String msg = VistaConstants.ERR_MSG_INPUT_MISS.replace(
				VistaConstants.SRVNM, XMXUTILConstants.TNMSGCT);

		if (request == null) {
			LOGGER.error(VistaConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(VistaConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		} else {
			if (request.getXmduz() != null) {
				parameters.add(request.getXmduz());
			} else {
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMDUZ"));
				this.errMsgs.add(msg.replace(VistaConstants.PARAM, "XMDUZ"));
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
	 * @return the xmxutilResponseFactory
	 */
	public XMXUTILResponseFactory getXmxutilResponseFactory() {
		return xmxutilResponseFactory;
	}

	/**
	 * @param xmxutilResponseFactory
	 *            the xmxutilResponseFactory to set
	 */
	protected void setXmxutilResponseFactory(
			XMXUTILResponseFactory xmxutilResponseFactory) {
		this.xmxutilResponseFactory = xmxutilResponseFactory;
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
