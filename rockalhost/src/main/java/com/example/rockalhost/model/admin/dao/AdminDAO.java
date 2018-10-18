package com.example.rockalhost.model.admin.dao;

import com.example.rockalhost.model.admin.dto.AdminDTO;

public interface AdminDAO {

	public boolean loginCheck(AdminDTO dto);
	public AdminDTO view(String id);

}
