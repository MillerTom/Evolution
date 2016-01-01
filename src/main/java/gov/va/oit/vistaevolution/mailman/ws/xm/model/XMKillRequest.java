/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Stephen Combs (stephen.combs@synaptekcorp.com)
 *
 */
/**
 * 
 * 	 This RPC KILLs any MailMan variables that may be left over from previous calls.
 * 	 It always returns 0^Successful.
 * 
 *  XMWSOA KILL
 *  
 *  The variables killed by this RPC are listed below:
 *  XMV,XMDISPI,XMDUN,XMDUZ,XMPRIV,XMNOSEND,XMERR
 *  A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,V,W,X,Z,%,%0,%1,%2,%3,%4
 *  XM,XMA,XMA0,XMAPBLOB,XMB,XMB0
 *  XMC,XMC0,XMCH,XMCI,XMCL,XMCNT,XMCT
 *  XMD,XMD0,XMDATE,XMDI,XMDT,XME,XME0,XMF,XMF0,XMG,XMG0
 *  XMK,XMKM,XMKN,XMI,XMJ
 *  XML,XMLOAD,XMLOC,XMLOCK,XMM,XMMG,XMN,XMOUT,XM
 *  XMR,XMRES,XMS,XMSEN,XMSUB
 *  XMT,XMTYPE,XMU,XMY,XMZ,XMZ1,XMZ2
 * 
 * Inputs:
 *     None
 *     
 * Returns:
 *    0^Successful
 *  
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMKillRequest {

	public XMKillRequest() {
		super();
	}

}
