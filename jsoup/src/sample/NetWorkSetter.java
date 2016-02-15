package sample;

import java.net.Authenticator;

public class NetWorkSetter {
	public static void setNetwork() {
		// set the ip of proxy server
		System.setProperty("http.proxyHost", "10.167.196.133");
		System.setProperty("https.proxyHost", "10.167.196.133");
		// set the port of proxy server
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyPort", "8080");
		System.setProperty("sun.net.client.defaultConnectTimeout", String.valueOf(50000));
		// set the nodes that need not proxy
		System.setProperty("http.nonProxyHosts", "localhost|192.168.0.*");
		// set the username and password for Authentication     
		Authenticator.setDefault(new MyAuthenticator("sundl.fnst", "Fnst=1234")); 
	}
}
