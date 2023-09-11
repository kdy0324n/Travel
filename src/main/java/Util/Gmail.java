package Util;

import javax.mail.*;


public class Gmail extends Authenticator{
	
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("queen727319@gmail.com", "ksm20030604");
	}
}
