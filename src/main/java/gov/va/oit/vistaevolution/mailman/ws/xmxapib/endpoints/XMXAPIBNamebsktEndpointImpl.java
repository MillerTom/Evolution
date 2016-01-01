/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBNamebsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBNamebsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBNamebsktResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.utils.XMXAPIBConstants;
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
@WebService(serviceName = "XMXAPIBNamebsktService", portName = "XMXAPIBNamebsktServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBNamebsktEndpoint")
public class XMXAPIBNamebsktEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXAPIBNamebsktEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXAPIBNamebsktEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXAPIBResponseFactory xmxapibResponseFactory;

	private int errCount = 0;
	private List<String> errMsgs;

	/**
	 * No Arguments Constructor
	 */
	public XMXAPIBNamebsktEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmxapibResponseFactory
	 */
	public XMXAPIBNamebsktEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMXAPIBResponseFactory xmxapibResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xmxapibResponseFactory = xmxapibResponseFactory;
	}

	@Override
	public XMXAPIBNamebsktResponse namebskt(XMXAPIBNamebsktRequest request)
			throws VistaWebServiceFault {

		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();

		LinkedList<Object> params = getParameters(request);

		if (this.errCount > 0) {
			return new XMXAPIBNamebsktResponse(null, errMsgs);
		} else {
			return xmxapibResponseFactory
					.createNamebsktResponseFromString(getVistaLinkContext()
							.makeRPCCall(
									new RPCIdentifier(VistaConstants.CONTEXT,
											XMXAPIBConstants.NAMEBSKT_RPC),
									params));
		}
	}

	private LinkedList<Object> getParameters(XMXAPIBNamebsktRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		String msg = VistaConstants.ERR_MSG_INPUT_MISS.replace(
				VistaConstants.SRVNM, XMXAPIBConstants.NAMEBSKT);

		if (request == null) {
			LOGGER.error(VistaConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(VistaConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		} else {
			if (request.getDuz() != null) {
				parameters.add(request.getDuz());
			} else {
				LOGGER.error(msg.replace(VistaConstants.PARAM, "DUZ"));
				this.errMsgs.add(msg.replace(VistaConstants.PARAM, "DUZ"));
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
	 * @return the xmxapibResponseFactory
	 */
	public XMXAPIBResponseFactory getXmxapibResponseFactory() {
		return xmxapibResponseFactory;
	}

	/**
	 * @param xmxapibResponseFactory
	 *            the xmxapibResponseFactory to set
	 */
	protected void setXmxapibResponseFactory(
			XMXAPIBResponseFactory xmxapibResponseFactory) {
		this.xmxapibResponseFactory = xmxapibResponseFactory;
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
