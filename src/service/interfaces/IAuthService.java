package service.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAuthService extends Remote{

	public boolean doesUserExist(String userName) throws RemoteException;
	public boolean checkPass(String userName, String pass) throws RemoteException;
	public boolean signIn(String user, String pass) throws RemoteException;
	public boolean createUser(String name, String pass) throws RemoteException;
}
