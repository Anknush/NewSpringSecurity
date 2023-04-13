package com.example.testingSecurtiy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.testingSecurtiy.model.ReturnUserDetails;
import com.example.testingSecurtiy.model.UserModel;
import com.example.testingSecurtiy.repo.SecurityRepo;

@Service
public class MySecurityService implements UserDetailsService {
	@Autowired
	SecurityRepo servicerepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserModel> user = servicerepo.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Username is not found: " + username));
//		return new ReturnUserDetails(user.get());
		return user.map(ReturnUserDetails::new).get();
	}

	public UserModel addUser(UserModel model) {
		servicerepo.save(model);
		return model;
	}
}
