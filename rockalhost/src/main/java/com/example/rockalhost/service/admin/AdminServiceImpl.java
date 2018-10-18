package com.example.rockalhost.service.admin;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.rockalhost.model.admin.dao.AdminDAO;
import com.example.rockalhost.model.admin.dto.AdminDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	AdminDAO adminDao;

	@Override
	public boolean loginCheck(AdminDTO dto, HttpSession session) {
		boolean result = adminDao.loginCheck(dto);
		
		if(result) {
			AdminDTO dto2 = view(dto.getId());
			session.setAttribute("admin_id", dto.getId());
			session.setAttribute("admin_nickName", dto2.getNickName());
			session.setAttribute("admin_name", dto2.getName());
			session.setAttribute("admin_email", dto2.getEmail());
		}
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@Override
	public AdminDTO view(String id) {
		return adminDao.view(id);
	}

}
