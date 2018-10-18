package com.example.rockalhost.service.invitation;

import java.util.List;
import java.util.Map;

import com.example.rockalhost.model.email.dto.EmailDTO;
import com.example.rockalhost.model.invitation.dto.InvitationDTO;

public interface InvitationService {

	public void insert(Map<String, Object> map);
	public List<InvitationDTO> list(String id);
	public int doubleCheckCount(InvitationDTO dto);
	public void delete(Map<String, Object> map);
	public void sendMail(EmailDTO dto);
	public InvitationDTO view(String id);
	public void issued(int iv_idx);

}
