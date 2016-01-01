package gov.va.oit.vistaevolution.util;
/**
 * Class for StrUtils
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 * 
 * */

public class StrUtilsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1744405096150967211L;

	/**
	 * Default no-arg constructor
	 * */
	public StrUtilsException() {
		super();
	}
	
	/**
	 * Default string message constructor
	 * @param message error message that will be passed on to the StrUtilsException object
	 * */
	public StrUtilsException(String message) {
		super(message);
	}
	
	/**
	 * Throwable constructor
	 * @param throwType type of object thrown
	 * */
	public StrUtilsException(Throwable throwType) {
		super(throwType);
	}

	/**
	 * String and Throwable constructor
	 * @param message error message that will be passed on to the StrUtilsException object
	 * @param throwType type of object thrown
	 * */
	public StrUtilsException(String message, Throwable throwType) {
		super(message, throwType);
	}

}
