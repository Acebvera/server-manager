package es.Acebera.server.connection;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectionAdress {
	
	public ConnectionAdress() {
		
	}
	
	/**
	 * 
	 * @param addr IP address of the other machine.
	 * @param openPort Any open port of the other machine: 22 - ssh, 80 or 443 - webserver, 25 - mailserver, etc.
	 * @param timeOutMillis Time in milliseconds to try to connect before timeout.
	 * @return
	 */
	public boolean isReachable(String addr, int openPort, int timeOutMillis) {
	  
	    try (Socket soc = new Socket()) {
	        soc.connect(new InetSocketAddress(addr, openPort), timeOutMillis);
	        return true;
	    } catch (IOException ex) {
	        return false;
	    }
	}
}
