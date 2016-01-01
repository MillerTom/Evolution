package gov.va.oit.vistaevolution.util;

public class VistaConstants {
	
	public VistaConstants() {
		
	}
	// replacables
	public static final String SRVNM = "#SRVCNAME#";
	public static final String PARAM = "#PARAM#";
	public static final String NR = "#NUMRTN#";
	public static final String NEXP = "#NUMEXP#";
	
	public static final String ERR_MSG_REQ_IS_NULL = "Request Object is NULL";
	public static final String ERR_MSG_START = "invalid input, ";
	public static final String ERR_MSG_REQD = " - required. ";
	public static final String ERR_MSG_REQD_INPUT = " call to " + SRVNM
			+ " Service will fail for lack of necessary input.";

	public static final String ERR_MSG_INPUT_MISS = ERR_MSG_START + PARAM
			+ ERR_MSG_REQD + ERR_MSG_REQD_INPUT;

	public static final String ERR_MSG_GEN = "ERROR OCCURRED";

	public static final String ERR_MSG_NOT_FOUND = "-1^Message not found";
	public static final String ERR_MSG_IN_REQD_INPUT2 = "-1^Error in required input";
	public static final String ERR_MSG_ONLY_ORGIN_EDIT = "0^Only the originator may Edit a message.";
	public static final String ERR_MSG_CNNT_EDIT_SNT_MSG = "0^You may not Edit a message you have already sent to someone else.";
	public static final String ERR_MSG_NOT_POP = "Failed to populate a new mail message in VistA";

	public static final String ERR_MSG_ABNORMAL = "ABNORMAL ERROR OCCURRED";
	public static final String ERR_MSG_INPUT = "ERROR OCCURRED, CHECK ERROR MESSAGES";
	public static final String NO_DATA_FOUND = "NO DATA RETURNED";
	public static final String DATA_FOUND = "DATA RETURNED SUCCESSFULLY";
	public static final String CONTEXT = "EVOLUTION";
	
	
	public static final String UNEXPECTED_INDEX_COUNT = "The number of returned fields "+ NR + " is not the number that was expected: " +NEXP; 
	public static final String UNEXPECTED_LINE_COUNT = "The number of returned lines "+ NR + " is not the number that was expected: " +NEXP;
	public static final String UNEXPECTED_NULL_RETURN = "Return from the RPC was NULL"; 
	public static final String MIN_LINES_EXPECTED = "1 or more";
	public static final String RPC_ERR_START = "-1^" ;
}
