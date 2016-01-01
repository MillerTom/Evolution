/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.utils;

import gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.XMA2REntaEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAnsrMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAnsrMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAnsrMsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Christopher Schuck
 * 
 */
public class MailmanUtils {

    private static final Logger LOGGER = Logger.getLogger(MailmanUtils.class);

    private MailmanUtils() {
    }

    /*
     * public static XMXAPIAddrNSndResponse addrNSndMsg(XMXAPIAddrNSndEndpoint
     * service, String duz, String xmDuz, String xmSubj, List<String> msg,
     * String xmStrip, List<String> xmto, List<XMInstr> xmInstr) throws
     * VistaWebServiceFault {
     * 
     * XMXAPIAddrNSndRequest msgRequest = new XMXAPIAddrNSndRequest();
     * 
     * msgRequest.setDuz(duz); msgRequest.setXmDuz(xmDuz);
     * msgRequest.setXmSubj(xmSubj); msgRequest.setMsg(msg);
     * msgRequest.setXmStrip(xmStrip); msgRequest.setXmTo(xmto);
     * msgRequest.setXmInstr(xmInstr);
     * 
     * XMXAPIAddrNSndResponse msgResponse = service.addrNSnd(msgRequest);
     * 
     * return msgResponse; }
     */

    public static XMXAPIAnsrMsgResponse ansrMsgM(XMXAPIAnsrMsgEndpoint service,
	    String duz, String xmduz, String xmkz, String xmsubj,
	    List<String> msg, List<XMXAPIArrayEntry> xmto)
	    throws VistaWebServiceFault {
	XMXAPIAnsrMsgRequest request = new XMXAPIAnsrMsgRequest();

	request.setDuz(duz);
	request.setXmDuz(xmduz);
	request.setXmkz(xmkz);
	request.setXmSubj(xmsubj);
	request.setMsg(msg);
	request.setXmTo(xmto);

	return service.ansrMsg(request);
    }

    public static XMA2REntaResponse respondToMsg(XMA2REntaEndpoint service,
	    String xmz, String subj, List<String> msgTxt, String xmStrip,
	    String duz) throws VistaWebServiceFault {

	LOGGER.debug("msg ien: " + xmz);
	LOGGER.debug("subject: " + subj);
	for (String msgLine : msgTxt) {
	    LOGGER.debug(msgLine);
	}
	LOGGER.debug("xmstrip: " + xmStrip);
	LOGGER.debug("duz: " + duz);

	XMA2REntaRequest request = new XMA2REntaRequest(xmz, subj, msgTxt,
		xmStrip, duz);

	try {
	    XMA2REntaResponse response = service.enta(request);
	    return response;
	} catch (Exception e) {
	    LOGGER.debug(e);
	    throw new VistaWebServiceFault(e);
	}
    }
}
