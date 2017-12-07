package com.auto.util;//¼àÌıÆ÷

import javax.mail.MessagingException;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import com.auto.util.Mail;

public class Listener extends TestListenerAdapter{

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
		Log.info("·¢ËÍÓÊ¼şÁË");
		Mail mail = new Mail();		
		try {
			mail.sendMail();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
