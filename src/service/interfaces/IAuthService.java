package service.interfaces;

import java.rmi.Remote;

public interface IAuthService extends Remote{

	public boolean doesUserExist(String userName);
	public boolean checkPass(String userName, String pass);
	
}
