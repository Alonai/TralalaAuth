package service.interfaces.sign;

import java.rmi.Remote;
import java.rmi.RemoteException;

import service.interfaces.IAuthService;

public interface ISignInService extends Remote {

	public boolean signIn(String user, String pass) throws RemoteException;
}
