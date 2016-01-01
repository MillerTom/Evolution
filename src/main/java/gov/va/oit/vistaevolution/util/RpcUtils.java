/**
 * 
 */
package gov.va.oit.vistaevolution.util;

import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.oit.vistaevolution.ws.model.VistaM1KeyArrayEntry;
import gov.va.oit.vistaevolution.ws.model.VistaM2KeyArrayEntry;

import java.util.HashMap;
import java.util.List;

/**
 * @author sorleski
 *
 */
public class RpcUtils {

	/**
	 * Add any methods which are related to rpc calls/responses
	 * 
	 */
	
	/* 
	 * this method will take a mixed List of VistaM1KeyArrayEntry objects 
	 * and VistaM2KeyArrayEntry objects, determine which it is dealing with and 
	 * add it to a hashmap. 
	 * 
	 *  This was first used in XMXAPIBListMsgsEndpointImpl as a result of tests in 
	 *  XMXABPIBListMsgsIT.  
	 *  
	 *   The mixed array is a result of call to the rpc in the following example: 
	 *   
	 *   Input Data:
		>K RETURN,XMSTART,XMCRIT
		>S DUZ=.5,XMDUZ=.5,XMK=”*”,XMFLDS=””,XMFLAGS=””,XMAMT=””,XMCRIT=””,XMCRIT(“TEXT”)=”API“,XMCRIT(“TEXT”,”C”)=0,XMCRIT(“TEXT”,”L”)=3
		
		Procedure Call:
		>D LISTMSGS^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK,XMFLDS,XMFLAGS,XMAMT,.XMSTART,.XMCRIT)
		
	 *	We are specifically targeting the XMCRIT list that was used in the input. 
	 *
	 * Here is the java call in the IT test.. 
	 *  
	 *  request.setXmCrit(new ArrayList<Object>());
    	request.getXmCrit().add(""); // XMCRIT=””
    	request.getXmCrit().add(new VistaM1KeyArrayEntry("TEXT","API")); // XMCRIT(“TEXT”)=”API“
    	request.getXmCrit().add(new VistaM2KeyArrayEntry("TEXT","C","0")); // XMCRIT(“TEXT”,”C”)=0
    	request.getXmCrit().add(new VistaM2KeyArrayEntry("TEXT","L","3")); // XMCRIT(“TEXT”,”L”)=3
	 * 
	 */
	public static HashMap<Object, Object> getMapFromVistaKeyArrayEntryList(List<Object> entryList) { 
		
		HashMap<Object, Object> hm = new HashMap<Object, Object>();
		for(Object o : entryList) { 
			
			if(o instanceof VistaM1KeyArrayEntry) { 
				VistaM1KeyArrayEntry ve = (VistaM1KeyArrayEntry)o;
				hm.put( ve.getKey(), ve.getValue());
			}else if(o instanceof VistaM2KeyArrayEntry) { 
				VistaM2KeyArrayEntry ve2 = (VistaM2KeyArrayEntry)o;
				hm.put(RpcRequest.buildMultipleMSubscriptKey("\"" + ve2.getKey1() + "\",\"" + ve2.getKey2() + "\"") , ve2.getValue());
			}
		}
		return hm;
	}

}
