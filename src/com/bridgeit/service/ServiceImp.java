package com.bridgeit.service;


import com.bridgeit.dao.LoginDao;
import com.bridgeit.dao.RegistrationDao;
import com.bridgeit.model.User;

public class ServiceImp implements Service {
	
	RegistrationDao registration=new RegistrationDao();
	LoginDao login=new LoginDao();

	@Override
	public boolean serviceEmailValidate(User user) {
	
		return registration.emailValidate(user);
	}

	@Override
	public boolean seviceRegistrationValidate(User user) {
	
		return registration.registrationValidate(user);
	}

	@Override
	public boolean serviceLoginValidate(User user) {
		return login.validate(user);
	}

	

}
