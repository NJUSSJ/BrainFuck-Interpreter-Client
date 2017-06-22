package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {

	public Boolean Log_in(String username,String password) throws RemoteException;
	
	public void Log_out() throws RemoteException;
	
	public Boolean new_Account(String username,String password) throws RemoteException;
}
