/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec.util;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
public class XMXSECConstants {

	public static final String SRVNM = "#SRVCNAME#";
	public static final String ERR_MSG_REQ_IS_NULL = "Request Object is NULL";
	public static final String ERR_MSG_START = "invalid input";
	public static final String ERR_MSG_REQD_INPUT = " call to " + SRVNM
			+ " Service will fail for lack of neccessary input.";
	public static final String ERR_MSG_ABNORMAL = "ABNORMAL ERROR OCCURRED";
	public static final String ERR_MSG_INPUT = "ERROR OCCURRED, CHECK ERROR MESSAGE";
	public static final String NO_DATA_FOUND = "NO DATA RETURNED";
	public static final String CONTEXT = "EVOLUTION";

	public static final String INFO = "INFO^XMXSEC";
	public static final String NOT_INFO_ONLY = "the message is not Information Only.";
	public static final String INFO_ONLY = "the message is Information Only.";
	public static final String INFO_RPC = "XMWSOA MSG INFO ONLY";

	public static final String CONFID = "CONFID^XMXSEC";
	public static final String NOT_CONFID_MSG = "the message is not Confidential.";
	public static final String CONFID_MSG = "the message is Confidential.";
	public static final String CONFID_RPC = "XMWSOA MSG CONFIDENTIAL";

	public static final String CLOSED = "CLOSED^XMXSEC";
	public static final String NOT_CLOSED_MSG = "the message is not Closed.";
	public static final String CLOSED_MSG = "the message is Closed.";
	public static final String CLOSED_RPC = "XMWSOA MSG CLOSED";
	
	public static final String PRIORITY = "PRIORITY^XMXSEC";
	public static final String NOT_PRIORITY_MSG = "the message is not Priority.";
	public static final String PRIORITY_MSG = "the message is Priority.";
	public static final String PRIORITY_RPC = "XMWSOA MSG PRIORITY";
}
