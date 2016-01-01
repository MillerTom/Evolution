package gov.va.oit.vistaevolution.util.vistalink;

import gov.va.med.exception.FoundationsException;
import gov.va.med.vistalink.adapter.cci.VistaLinkConnection;
import gov.va.med.vistalink.adapter.spi.VistaLinkServerInfo;
import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.med.vistalink.rpc.RpcRequestFactory;
import gov.va.med.vistalink.security.CallbackHandlerUnitTest;
import gov.va.med.vistalink.security.VistaKernelPrincipalImpl;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.apache.log4j.Logger;

/**
 * This class is a default execution of the RPC for J2SE connector.
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class J2SEVistaLinkStrategy implements IVistaLinkStrategy {
	private static final Logger logger = Logger.getLogger(J2SEVistaLinkStrategy.class);

	private String cfgName;
	private String accessCode;
	private String verifyCode;
	private String division;

	VistaKernelPrincipalImpl vistaKernelPrincipalImpl;
	LoginContext loginContext;
	VistaLinkConnection vistaLinkConnection;

	/**
	 * @param cfgName
	 * @param accessCode
	 * @param verifyCode
	 * @param division
	 */
	public J2SEVistaLinkStrategy(String cfgName, String accessCode,
			String verifyCode, String division) {
		this.cfgName = cfgName;
		this.accessCode = accessCode;
		this.verifyCode = verifyCode;
		this.division = division;
	}

	/** {@inheritDoc}
	 */
	@Override
	public String execute(IVistaLinkContext vistaLinkContext)
			throws VistaWebServiceFault {
		RpcRequest rpcRequest;
		try {
			if (vistaLinkConnection == null) {
				// first time, myConnection is null, do login for first time
				doLogin();
			} else {
				try {
					// already logged in at least once, examine the connection
					// will throw exception if connection has timed out
					vistaLinkConnection.getConnectionInfo();
				} catch (Exception e) {
					// try re-logging
					doLogin();
				}
			}

			rpcRequest = RpcRequestFactory.getRpcRequest();

			rpcRequest.setRpcContext(vistaLinkContext.getRpcId().getContext());
			rpcRequest.setRpcName(vistaLinkContext.getRpcId().getName());

			if (vistaLinkContext.getParameters() != null) {
				rpcRequest.setParams(vistaLinkContext.getParameters());
			}
			
			if (logger.isDebugEnabled()) {
				logger.debug("Executing RpcId=" + vistaLinkContext.getRpcId().toString()); 
			}

			String response = vistaLinkConnection.executeRPC(rpcRequest).getResults();
			
			if (logger.isDebugEnabled()) {
				logger.debug("RPC Response=" + response);
			}
			
			return response;

		} catch (FoundationsException e) {
			logger.error("Error while executing RPC Request", e);
			throw new VistaWebServiceFault(e);
		} catch (LoginException e) {
			logger.error(
					"Error while executing RPC Request, could not Authenticate",
					e);
			throw new VistaWebServiceFault(e);
		} catch (Exception e) {
			logger.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	/**
	 * Performs login and establishes vista link connection
	 * @throws LoginException
	 * @throws FoundationsException
	 */
	protected void doLogin() throws LoginException, FoundationsException  {
		logger.debug("Initialize CallBackHandlerUnitTest instance for JAAS login");
		
		CallbackHandlerUnitTest cbhSilentSimple = new CallbackHandlerUnitTest(
				getAccessCode(), getVerifyCode(), getDivision());

		if (logger.isDebugEnabled()) {
			logger.debug("Before login=" + this);
		}
		
		loginContext = new LoginContext(getCfgName(), cbhSilentSimple);
		loginContext.login();

		vistaKernelPrincipalImpl = VistaKernelPrincipalImpl.getKernelPrincipal(loginContext.getSubject());
		
		// get connection from JAAS principal
		vistaLinkConnection = vistaKernelPrincipalImpl.getAuthenticatedConnection();
		
		if (logger.isDebugEnabled()) {
			logger.debug("After login=" + this);
			
			VistaLinkServerInfo serverInfo = vistaLinkConnection.getConnectionInfo();
			
			logger.debug("Server Connection [timeout=" + vistaLinkConnection.getTimeOut() +
					", address=" + serverInfo.getAddress() + ", port=" + serverInfo.getPort() + "]");
		}
	}
	
	public String getCfgName() {
		return cfgName;
	}

	protected void setCfgName(String cfgName) {
		this.cfgName = cfgName;
	}

	public String getAccessCode() {
		return accessCode;
	}

	protected void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	protected void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getDivision() {
		return division;
	}

	protected void setDivision(String division) {
		this.division = division;
	}

	@Override
	public String toString() {
		return "J2SEVistaLinkStrategy [cfgName=" + cfgName + ", accessCode="
				+ accessCode + ", verifyCode=" + verifyCode + ", division="
				+ division + ", vistaKernelPrincipalImpl="
				+ vistaKernelPrincipalImpl + ", loginContext=" + loginContext
				+ ", vistaLinkConnection=" + vistaLinkConnection + "]";
	}
	
}
