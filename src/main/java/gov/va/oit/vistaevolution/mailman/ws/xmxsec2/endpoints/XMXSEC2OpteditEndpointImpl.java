/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.XMXSEC2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.interfaces.XMXSEC2OpteditEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OpteditRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OpteditResponse;
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
@WebService(serviceName = "XMXSEC2OpteditService", portName = "XMXSEC2OpteditServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.interfaces.XMXSEC2OpteditEndpoint")
public class XMXSEC2OpteditEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXSEC2OpteditEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXSEC2OpteditEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXSEC2ResponseFactory xmxsec2ResponseFactory;

	private int errCount = 0;
	private List<String> errMsgs;

	/**
	 * No Arguments Constructor
	 */
	public XMXSEC2OpteditEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmxsec2ResponseFactory
	 */
	public XMXSEC2OpteditEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMXSEC2ResponseFactory xmxsec2ResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xmxsec2ResponseFactory = xmxsec2ResponseFactory;
	}

	@Override
	public XMXSEC2OpteditResponse optedit(XMXSEC2OpteditRequest request)
			throws VistaWebServiceFault {

		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();

		LinkedList<Object> params = getParameters(request);

		if (this.errCount > 0) {
			return new XMXSEC2OpteditResponse(null, errMsgs);
		} else {
			return xmxsec2ResponseFactory
					.createOpteditResponseFromString(getVistaLinkContext()
							.makeRPCCall(
									new RPCIdentifier(XMXSEC2Constants.CONTEXT,
											XMXSEC2Constants.OPTEDIT_RPC),
									params));
		}
	}

	private LinkedList<Object> getParameters(XMXSEC2OpteditRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		String msg = VistaConstants.ERR_MSG_INPUT_MISS.replace(
				VistaConstants.SRVNM, XMXSEC2Constants.OPTEDIT);

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
