package com.example.testingSecurtiy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.testingSecurtiy.model.ReturnUserDetails;
import com.example.testingSecurtiy.model.UserModel;
import com.example.testingSecurtiy.repo.SecurityRepo;

@Service
public class MySecurityService implements UserDetailsService {
	@Autowired
	SecurityRepo servicerepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserModel> user = servicerepo.findByUsername(username);
		System.out.println(user);
		user.orElseThrow(() -> new UsernameNotFoundException("Username is not found: " + username));
		return user.map(ReturnUserDetails::new).get();
	}

	public UserModel addUser(UserModel model) {
		model.setPassword(passwordEncoder.encode(model.getPassword()));
		servicerepo.save(model);
		return model;
	}

	public List<UserModel> getUser() {
		return servicerepo.findAll();
	}
}
