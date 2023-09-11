
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Util.SHA256" %>
<%@ page import="Util.Gmail" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Properties" %>
<%@page import="javax.mail.Transport" %>
<%@page import="javax.mail.Message" %>
<%@page import="javax.mail.Address" %>
<%@page import="javax.mail.internet.InternetAddress" %>
<%@page import="javax.mail.internet.MimeMessage" %>
<%@page import="javax.mail.Session" %>
<%@page import="javax.mail.Authenticator" %>

<%
	request.setCharacterEncoding("UTF-8");
	/*String id = null;
	String pw = null;
	String email=null;
	if(request.getParameter("id")!=null){
		id = request.getParameter("id");
	}
	if(request.getParameter("pw")!=null){
		pw = request.getParameter("pw");
	}
	if(request.getParameter("email")!=null){
		email = request.getParameter("email");
	}*/
	String e_mail = request.getParameter("email");
	
	
	String host = "http://localhost:8080/travel/";
	String from = "queen727319@gmail.com";
	String to = e_mail;
	String subject = "강의평가를 위한 이메일 인증입니다.";
	String content = "다음 링크에 접속하여 이메일 인증을 진행하세요"+
		"<a href='"+host+"emailcheckaction.jsp?code="+new SHA256().getSHA256(to)+"'>이메일 인증하기</a>";
	Properties p = new Properties();
	   p.put("mail.smtp.user", from);
	   p.put("mail.smtp.host", "smtp.googlemail.com");
	   p.put("mail.smtp.port", "456");
	   p.put("mail.smtp.starttls.enable", "true");
	   p.put("mail.smtp.auth", "true");
	   p.put("mail.smtp.debug", "true");
	   p.put("mail.smtp.socketFactory.port", "465");
	   p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	   p.put("mail.smtp.socketFactory.fallback", "false");
	
	try{
		Authenticator auth = new Gmail();
		Session ses = Session.getInstance(p, auth);
		ses.setDebug(true);
		MimeMessage msg = new MimeMessage(ses);
		msg.setSubject(subject);
		Address fromAddr = new InternetAddress(from);
		msg.setFrom(fromAddr);
		Address toAddr = new InternetAddress(to);
		msg.addRecipient(Message.RecipientType.TO, toAddr);
		msg.setContent(content, "text/html;charset=UTF8");
		Transport.send(msg);
	}catch(Exception e){
		e.printStackTrace();
	}
	
%>
