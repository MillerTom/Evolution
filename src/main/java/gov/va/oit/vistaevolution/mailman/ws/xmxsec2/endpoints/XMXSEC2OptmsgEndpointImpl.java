/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.XMXSEC2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.interfaces.XMXSEC2OptmsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OptmsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OptmsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.utils.XMXSEC2Constants;
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
@WebService(serviceName = "XMXSEC2OptmsgService", portName = "XMXSEC2OptmsgServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.interfaces.XMXSEC2OptmsgEndpoint")
public class XMXSEC2OptmsgEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXSEC2OptmsgEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXSEC2OptmsgEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXSEC2ResponseFactory xmxsec2ResponseFactory;

	private int errCount = 0;
	private List<String> errMsgs;

	/**
	 * No Arguments Constructor
	 */
	public XMXSEC2OptmsgEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmxsec2ResponseFactory
	 */
	public XMXSEC2OptmsgEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMXSEC2ResponseFactory xmxsec2ResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xmxsec2ResponseFactory = xmxsec2ResponseFactory;
	}

	@Override
	public XMXSEC2OptmsgResponse optmsg(XMXSEC2OptmsgRequest request)
			throws VistaWebServiceFault {

		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();

		LinkedList<Object> params = getParameters(request);

		if (this.errCount > 0) {
			return new XMXSEC2OptmsgResponse(null, errMsgs);
		} else {
			return xmxsec2ResponseFactory
					.createOptmsgResponseFromString(getVistaLinkContext()
							.makeRPCCall(
									new RPCIdentifier(XMXSEC2Constants.CONTEXT,
											XMXSEC2Constants.OPTMSG_RPC),
									params));
		}
	}

	private LinkedList<Object> getParameters(XMXSEC2OptmsgRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		String msg = VistaConstants.ERR_MSG_INPUT_MISS.replace(
				VistaConstants.SRVNM, XMXSEC2Constants.OPTMSG);

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

			if (request.getXmk() != null) {
				parameters.add(request.getXmk());
			} else {
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMK"));
				this.errMsgs.add(msg.replace(VistaConstants.PARAM, "XMK"));
				errCount++;
			}

			if (request.getXmz() != null) {
				parameters.add(request.getXmz());
			} else {
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMZ"));
				this.errMsgs.add(msg.replace(VistaConstants.PARAM, "XMZ"));
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
	 * @return the xmxsec2ResponseFactory
	 */
	public XMXSEC2ResponseFactory getXmxsec2ResponseFactory() {
		return xmxsec2ResponseFactory;
	}

	/**
	 * @param xmxsec2ResponseFactory
	 *            the xmxsec2ResponseFactory to set
	 */
	protected void setXmxsec2ResponseFactory(
			XMXSEC2ResponseFactory xmxsec2ResponseFactory) {
		this.xmxsec2ResponseFactory = xmxsec2ResponseFactory;
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
