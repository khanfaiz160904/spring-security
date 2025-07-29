package com.secured.service;

import org.springframework.stereotype.Service;

@Service
public class ClientService {
	public String admin() {
		return "Admin Login";
	}

	public String user() {
		return "User Login";
	}
}
