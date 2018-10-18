package com.example.rockalhost.service.invitation;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.rockalhost.model.email.dto.EmailDTO;
import com.example.rockalhost.model.invitation.dao.InvitationDAO;
import com.example.rockalhost.model.invitation.dto.InvitationDTO;
import com.example.rockalhost.model.performance.dao.PerformanceDAO;

@Service
public class InvitationServiceImpl implements InvitationService {
	
	@Inject
	JavaMailSender mailSender;
	
	@Inject
	InvitationDAO invitationDao;
	
	@Inject
	PerformanceDAO performanceDao;
	
	@Override
	public void insert(Map<String, Object> map) {
		InvitationDTO dto = new InvitationDTO();
		
		int count = (int)map.get("count");
		int pf_idx = (int)map.get("pf_idx");
		
		dto.setUser_id((String)map.get("id"));
		dto.setPf_idx(pf_idx);
		dto.setCount(count);
		invitationDao.insert(dto);
		performanceDao.downCountRemainder(pf_idx, count);
	}

	@Override
	public List<InvitationDTO> list(String id) {
		List<InvitationDTO> list = invitationDao.list(id);
		return list;
	}

	@Override
	public int doubleCheckCount(InvitationDTO dto) {
		return invitationDao.doubleCheckCount(dto);
	}

	@Override
	public void delete(Map<String, Object> map) {
		int count = (int)map.get("count");
		int iv_idx = (int)map.get("iv_idx");
		int pf_idx = (int)map.get("pf_idx");
		
		invitationDao.delete(iv_idx);
		performanceDao.upCountRemainder(pf_idx, count);
	}

	@Override
	public void sendMail(EmailDTO dto) {
		
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			
			msg.addRecipient(RecipientType.TO, 
					new InternetAddress(dto.getReceiveMail()));
			
			msg.addFrom(new InternetAddress[] {
					new InternetAddress(dto.getSenderMail(),dto.getSenderName()) 
			});
			
			msg.setSubject(dto.getSubject(),"utf-8");
			msg.setText(dto.getMessage(),"utf-8", "html");
	
			mailSender.send(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public InvitationDTO view(String id) {
		InvitationDTO dto = invitationDao.view(id);
		String inviCode = "";
		
		dto.setInviCode(inviCode);
		
		return dto;
	}

	@Override
	public void issued(int iv_idx) {
		invitationDao.issued(iv_idx);
	}

}
