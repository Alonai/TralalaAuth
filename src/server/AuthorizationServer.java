package server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import service.interfaces.IAuthService;
import service.interfaces.register.IRegisterService;
import service.interfaces.sign.ISignInService;

public class AuthorizationServer extends UnicastRemoteObject implements ISignInService, IRegisterService{


	private static final long serialVersionUID = -4242651654787838644L;
	
	private HashMap<String, String> hmUsers;
	
	public AuthorizationServer() throws RemoteException{
		super();
		hmUsers= new HashMap<String, String>();
	}
	
	/** Checks if the user 'userName' exists*/
	public boolean doesUserExist(String userName) {
		
		return (hmUsers.containsKey(userName)) ? true : false;
	}

	/** Checks if the combination of username + pass is correct */
	public boolean checkPass(String userName, String pass) {
		
		return (hmUsers.get(userName).equals(pass)) ? true : false;
	}
	/** Creates a new user, false if the user is already taken, true if everything goes OK */
	public boolean createUser(String name, String pass) {
		boolean ret= true;
		
		if(!doesUserExist(name))
			hmUsers.put(name, pass);
		else ret= false;
		
		return ret;
	}

	/** Signs a user*/
	public boolean signIn(String user, String pass) {
		
		return checkPass(user, pass);
	}
	
	public static void main (String [] args){
		if(args.length !=3){
			System.out.println("$ ERR incorrect args");
			System.exit(0);
		}
		
		if(System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		
		String name= "//" + args[0] +  ":" + args[1] + "/" +args[2];
		
		try{
			IAuthService server= new AuthorizationServer();
			Naming.rebind(name, server);
			System.out.println("$ Server '" + name + "'active and waiting");
		}catch(Exception e){
			System.err.print("$ Exception running server: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
