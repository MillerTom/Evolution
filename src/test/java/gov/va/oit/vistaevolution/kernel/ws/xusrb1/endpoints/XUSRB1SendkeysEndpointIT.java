/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1SendkeysEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1SendkeysRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1SendkeysResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 *
 */
public class XUSRB1SendkeysEndpointIT extends VistaLinkContextITParent {
    
    @Autowired
    private XUSRB1SendkeysEndpoint endpoint;
    

    /**
     * <pre>
     * Test Case 1 – Get list of encryption keys in array KEYS.
     * 
     * >D SENDKEYS^XUSRB1(.KEYS)
     *
     * >ZW KEYS
     * 
     * KEYS(1)="wkEo-ZJt!dG)49K{nX1BS$vH<&:Myf*>Ae0jQW=;|#PsO`'%+rmb[gpqN,l6/hFC@DcUa ] z~R}""V\iIxu?872.(TYL5_3"
     * KEYS(2)="rKv`R;M/9BqAF%&tSs#Vh)dO1DZP> *fX'u[.4lY=-mg_ci802N7LTG<]!CWo:3?{+,5Q}(@jaExn$~p\IyHwzU""|k6Jeb"
     * KEYS(3)="\pV(ZJk""WQmCn!Y,y@1d+~8s?[lNMxgHEt=uw|X:qSLjAI*}6zoF{T3#;ca)/h5%`P4$r]G'9e2if_>UDKb7<v0&- RBO."
     * KEYS(4)="depjt3g4W)qD0V~NJar\B ""?OYhcu[<Ms%Z`RIL_6:]AX-zG.#}$@vk7/5x&*m;(yb2Fn+l'PwUof1K{9,|EQi>H=CT8S!"
     * KEYS(5)="NZW:1}K$byP;jk)7'`x90B|cq@iSsEnu,(l-hf.&Y_?J#R]+voQXU8mrV[!p4tg~OMez CAaGFD6H53%L/dT2<*>""{\wI="
     * KEYS(6)="vCiJ<oZ9|phXVNn)m K`t/SI%]A5qOWe\&?;jT~M!fz1l>[D_0xR32c*4.P""G{r7}E8wUgyudF+6-:B=$(sY,LkbHa#'@Q"
     * KEYS(7)="hvMX,'4Ty;[a8/{6l~F_V""}qLI\!@x(D7bRmUH]W15J%N0BYPkrs&9:$)Zj>u|zwQ=ieC-oGA.#?tfdcO3gp`S+En K2*<"
     * KEYS(8)="jd!W5[];4'<C$/&x|rZ(k{>?ghBzIFN}fAK""#`p_TqtD*1E37XGVs@0nmSe+Y6Qyo-aUu%i8c=H2vJ\) R:MLb.9,wlO~P"
     * KEYS(9)="2ThtjEM+!=xXb)7,ZV{*ci3""8@_l-HS69L>]\AUF/Q%:qD?1~m(yvO0e'<#o$p4dnIzKP|`NrkaGg.ufCRB[; sJYwW}5&"
     * KEYS(10)="vB\5/zl-9y:Pj|=(R'7QJI *&CTX""p0]_3.idcuOefVU#omwNZ`$Fs?L+1Sk<,b)hM4A6[Y%aDrg@~KqEW8t>H};n!2xG{"
     * KEYS(11)="sFz0Bo@_HfnK>LR}qWXV+D6`Y28=4Cm~G/7-5A\b9!a#rP.l&M$hc3ijQk;),TvUd<[:I""u1'NZSOw]*gxtE{eJp|y (?%"
     * KEYS(12)="M@,D}|LJyGO8`$*ZqH .j>c~h<d=fimszv[#-53F!+a;NC'6T91IV?(0x&/{B)w""]Q\YUWprk4:ol%g2nE7teRKbAPuS_X"
     * KEYS(13)=".mjY#_0*H<B=Q+FML6]s;r2:e8R}[ic&KA 1w{)vV5d,$u""~xD/Pg?IyfthO@CzWp%!`N4Z'3-(o|J9XUE7k\TlqSb>anG"
     * KEYS(14)="xVa1']_GU<X`|\NgM?LS9{""jT%s$}y[nvtlefB2RKJW~(/cIDCPow4,>#zm+:5b@06O3Ap8=*7ZFY!H-uEQk; .q)i&rhd"
     * KEYS(15)="I]Jz7AG@QX.""%3Lq>METUo{Pp_ |a6<0dYVSv8:b)~W9NK`(r'4fs&wim\kReC2hg=HOj$1B* /nxt,;c#y+![?lFuZ-5D}"
     * KEYS(16)="Rr(Ge6F Hx>q$m&C%M~Tn,:""o'tX/*yP.{lZ!YkiVhuw_<KE5a[;}W0gjsz3]@7cI2\QN?f#4p|vb1OUBD9)=-LJA+d`S8"
     * KEYS(17)="I~k>y|m};d)-7DZ""Fe/Y<B:xwojR,Vh]O0Sc[`$sg8GXE!1&Qrzp._W%TNK(=J 3i*2abuHA4C'?Mv\Pq{n#56LftUl@9+"
     * KEYS(18)="~A*>9 WidFN,1KsmwQ)GJM{I4:C%}#Ep(?HB/r;t.&U8o|l['Lg""2hRDyZ5`nbf]qjc0!zS-TkYO<_=76a\X@$Pe3+xVvu"
     * KEYS(19)="yYgjf""5VdHc#uA,W1i+v'6|@pr{n;DJ!8(btPGaQM.LT3oe?NB/&9>Z`-}02*%x<7lsqz4OS ~E$\R]KI[:UwC_=h)kXmF"
     * KEYS(20)="5:iar.{YU7mBZR@-K|2 ""+~`M%8sq4JhPo<_X\Sg3WC;Tuxz,fvEQ1p9=w}FAI&j/keD0c?)LN6OHV]lGy'$*>nd[(tb!#"
     * 
     * </pre>
     * @throws VistaWebServiceFault 
     */
    @Ignore
    @Test
    public void testSendKeys001() throws VistaWebServiceFault {
        
        XUSRB1SendkeysRequest request = new XUSRB1SendkeysRequest();
        request.setRoot(".5");
        
        XUSRB1SendkeysResponse response = this.endpoint.sendkeys(request);
        assertNotNull(response);
        
    }
    
}
