package service.interfaces.sign;

import service.interfaces.IAuthService;

public interface ISignInService extends IAuthService {

	public boolean signIn(String user, String pass);
}
