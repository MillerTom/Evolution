
package gov.va.oit.vistaevolution.kernel.ws.xusrb.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * VistALink - Set up User's Partition in M
 * Output Parameters Class:
 *
 * ret:     Returns a subscripted output array:
 *
 *          RET(0)—Server option name
 *          RET(1)—Volume
 *          RET(2)—UCI
 *          RET(3)—Device
 *          RET(4)—# Attempts
 *          RET(5)—Skip signon-screen
 *          RET(6)—Domain name
 *
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement(name = "XUSRBSetupResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XUSRBSetupResponse extends AbstractVistaResponse {


	@XmlElement(name="server_option_name", required = true)
	private String serverOptionName;

	@XmlElement(name="volume", required = true)
	private String volume;

	@XmlElement(name="uci", required = true)
	private String uci;

	@XmlElement(name="device", required = true)
	private String device;

	@XmlElement(name="attempts", required = true)
	private String attempts;

	@XmlElement(name="skip_signon", required = true)
	private String skip;

	@XmlElement(name="domain_name", required = true)
	private String domain;

	@XmlElement(name="value", required = true)
	private String value;


    /**
     * @return the serverOptionName
     */
    public String getServerOptionName() {
        return this.serverOptionName;
    }


    /**
     * @param serverOptionName the serverOptionName to set
     */
    protected void setServerOptionName(final String serverOptionName) {
        this.serverOptionName = serverOptionName;
    }


    /**
     * @return the volume
     */
    public String getVolume() {
        return this.volume;
    }


    /**
     * @param volume the volume to set
     */
    protected void setVolume(final String volume) {
        this.volume = volume;
    }


    /**
     * @return the uci
     */
    public String getUci() {
        return this.uci;
    }


    /**
     * @param uci the uci to set
     */
    protected void setUci(final String uci) {
        this.uci = uci;
    }


    /**
     * @return the device
     */
    public String getDevice() {
        return this.device;
    }


    /**
     * @param device the device to set
     */
    protected void setDevice(final String device) {
        this.device = device;
    }


    /**
     * @return the attempts
     */
    public String getAttempts() {
        return this.attempts;
    }


    /**
     * @param attempts the attempts to set
     */
    protected void setAttempts(final String attempts) {
        this.attempts = attempts;
    }


    /**
     * @return the skip
     */
    public String getSkip() {
        return this.skip;
    }


    /**
     * @param skip the skip to set
     */
    protected void setSkip(final String skip) {
        this.skip = skip;
    }


    /**
     * @return the domain
     */
    public String getDomain() {
        return this.domain;
    }


    /**
     * @param domain the domain to set
     */
    protected void setDomain(final String domain) {
        this.domain = domain;
    }


    /**
     * @return the value
     */
    public String getValue() {
        return this.value;
    }


    /**
     * @param value the value to set
     */
    protected void setValue(final String value) {
        this.value = value;
    }


    /**
     * Default Bean Constructor
     */
    public XUSRBSetupResponse() {
        super();
    }


    /**
     * Constructor intializes the response object
     * @param server
     * @param vol
     * @param uci
     * @param dev
     * @param att
     * @param skip
     * @param domain
     * @param val
     * @param rawResponse
     */
    public XUSRBSetupResponse(final String server, final String vol, final String uci,
            final String dev, final String att, final String skip, final String domain, 
            final String val, final String rawResponse) {

        super();
        this.serverOptionName = server;
        this.volume = vol;
        this.uci = uci;
        this.device = dev;
        this.attempts = att;
        this.domain = domain;
        this.value = val;
        this.setRawResponse(rawResponse);

    }

}
