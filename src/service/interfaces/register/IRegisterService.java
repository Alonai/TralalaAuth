package service.interfaces.register;

import java.rmi.Remote;
import java.rmi.RemoteException;

import service.interfaces.IAuthService;

public interface IRegisterService extends Remote{
	
	public boolean createUser(String name, String pass) throws RemoteException;
}
