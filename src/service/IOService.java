package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOService extends Remote {

	public boolean writeFile(String file, String userId, String fileName)throws RemoteException;

	public String readFile(String userId, String fileName)throws RemoteException;

	public String readFileList(String userId)throws RemoteException;

	public boolean writeFilelist(String userId,String filename,boolean if_newfile,String code)throws RemoteException;
}

