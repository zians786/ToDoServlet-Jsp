package com.bridgeit.service;

import com.bridgeit.model.User;

public interface Service {
	boolean serviceEmailValidate(User user);
	boolean seviceRegistrationValidate(User user);
	boolean serviceLoginValidate(User user);
}
