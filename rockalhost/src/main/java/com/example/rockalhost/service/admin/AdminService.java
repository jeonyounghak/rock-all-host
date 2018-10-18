package com.example.rockalhost.service.admin;

import javax.servlet.http.HttpSession;

import com.example.rockalhost.model.admin.dto.AdminDTO;

public interface AdminService {

	public boolean loginCheck(AdminDTO dto, HttpSession session);
	public void logout(HttpSession session);
	public AdminDTO view(String id);

}
