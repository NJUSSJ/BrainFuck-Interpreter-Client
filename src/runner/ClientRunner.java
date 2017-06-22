package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.RemoteHelper;

public class ClientRunner {

    public static RemoteHelper remoteHelper;
	
	public ClientRunner(){
		
		linkToServer();
		
	}
	
	public void linkToServer(){
		try {
			remoteHelper=RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8889/IDE"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (NotBoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (RemoteException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	
	
	
}
