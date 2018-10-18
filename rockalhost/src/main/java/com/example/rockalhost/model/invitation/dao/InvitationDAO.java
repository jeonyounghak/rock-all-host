package com.example.rockalhost.model.invitation.dao;

import java.util.List;

import com.example.rockalhost.model.invitation.dto.InvitationDTO;

public interface InvitationDAO {

	public void insert(InvitationDTO dto);
	public List<InvitationDTO> list(String id);
	public int doubleCheckCount(InvitationDTO dto);
	public void delete(int iv_idx);
	public InvitationDTO view(String id);
	public void issued(int iv_idx);
	public List<InvitationDTO> getIv_idxList(int pf_idx);
	public void deleteAll(InvitationDTO dto);

}
