package com.auto.util;//�����ʼ�

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	public void sendMail() throws AddressException, MessagingException{
	    Properties prop = new Properties();
	    prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.transport.protocol", "smtp");
	    prop.setProperty("mail.smtp.auth", "true");	
	    
	  //ʹ��JavaMail�����ʼ�
	  //1.����session
        Session session = Session.getInstance(prop);
      //����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
	    session.setDebug(true);
	  //2.ͨ��session�õ�transport����
	    Transport ts = session.getTransport("smtp");
	  //3.ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����� ��smtp������
		ts.connect("smtp.163.com", "15732165618@163.com", "Yr96042724");
      //4.�����ʼ�
		Message message = setMessage(session);//����setMessage����
      //5.�����ʼ�
	    ts.sendMessage(message, message.getAllRecipients());
	     
		ts.close();
		Log.info("E-mail send");
	}

	private Message setMessage(Session session) throws AddressException, MessagingException {
	  //1.�����ʼ�����
        MimeMessage message = new MimeMessage(session);
      //2.�ʼ��ķ�����
        message.setFrom(new InternetAddress("15732165618@163.com"));
      //3.�ʼ����ռ���
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("2649967423@qq.com"));
      //4.�ʼ��ı���
        message.setSubject("Listener");
      //5.�ʼ����ı�����
        message.setContent("TestFailure��", "text/html;charset=UTF-8");
      //6.���ش����õ��ʼ�����
        return message;
    }
	
	public static void main(String[] args) throws AddressException, MessagingException {
		Mail mail = new Mail();
		mail.sendMail();
	}
}
