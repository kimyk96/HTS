package com.hts.market.global.app;

import com.hts.market.global.entity.MailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailApp {
	@Autowired
	private JavaMailSender javaMailSender;

	private void sendMail(MailEntity mail) {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, false, "utf-8");
			helper.setFrom(mail.getFrom());
			helper.setTo(mail.getTo());
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getBody(), true);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
//	public void sendFindIdMail(String from, String to, String username) {
//
//		// 자바에서 String 은 값을 변경할 수 없는 불변 객체 이다
//		// String str = "HELLO" + " " + "JAVA";
//		// 위 코드는 String 객체를 3개 만든다.
//		// 먼저 str 은 "HELLO" 가 됬다가.
//		// 그 다음에 "HELLO " 가 됬다가
//		// 마지막으로 "HELLO JAVA" 가 된다. 이래서 앞에 두개 객체는 쓰레기가 된다.
//		// 그래서 문자열 편집 작업은 StringBuffer나 StringBuilder를 사용한다.
//		// StringBuffer 는 스레드 안전, StringBuilder 는 동기작업 가능
////		String str = new StringBuffer("Hello").append(" ").append("JAVA").toString();
//
//		MailEntity mail = MailEntity.builder().from(from).to(to).subject("아이디 확인 메일").build();
//		String message = new StringBuffer("<p>아이디를 찾았습니다</p>").append("<p>당신의 아이디 : ").append(username).toString();
//		sendMail(mail.setText(message));
//	}

//	public void sendResetPasswordMail(String from, String to, String password) {
//		MailEntity mail = MailEntity.builder().from(from).to(to).subject("임시비밀번호").build();
//		String message = new StringBuffer("<p>임시비밀번호를 발급했습니다</p>").append("<p>임시비밀번호 :").append(password).append("</p>").toString();
//		sendMail(mail.setText(message));
//
//	}
//}