package service.interfaces.register;

import service.interfaces.IAuthService;

public interface IRegisterService extends IAuthService{
	
	public boolean createUser(String name, String pass);
}
