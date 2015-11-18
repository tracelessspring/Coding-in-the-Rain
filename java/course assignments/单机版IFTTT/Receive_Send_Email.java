package tracelessspring;
import javax.mail.*;
//import com.sun.mail.*;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
import java.util.Properties;
import javax.mail.internet.AddressException;  //
import javax.mail.internet.MimeMessage;   //
import javax.mail.internet.InternetAddress;  //
import java.util.Date;


public class Receive_Send_Email {
	public void Send_email(String weiboemailcontent,String destination_emailaddress) throws AddressException, MessagingException{
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");//发送邮件协议
		properties.setProperty("mail.smtp.auth", "true");//需要验证
		Session session = Session.getInstance(properties);
		session.setDebug(true);//debug模式
		Message messgae = new MimeMessage(session);
		messgae.setFrom(new InternetAddress("xxxx@qq.com"));//设置负责发送的qq邮箱
		messgae.setText(weiboemailcontent);//设置邮件内容
		messgae.setSubject("Java测试邮件");//设置邮件主题
		Transport tran = session.getTransport();
		tran.connect("smtp.qq.com", 25, "xxxx@qq.com", "xxxx");//连接到QQ邮箱服务器,第三个参数是负责发送邮件的邮箱，第4个参数是该邮箱的密码
		tran.sendMessage(messgae, new Address[]{ new InternetAddress(destination_emailaddress)});//设置邮件接收人
		tran.close();
	}
	
	public boolean Receive_email(String receiveemail,String emailkey,Date time){
		boolean is_receive=false;
		
		String imapserver="imap.qq.com";
		
		Properties prop=System.getProperties();
		prop.put("mail.imap.host", imapserver);
		prop.put("mail.imap.auth.plain.disable","true");
		Session mailsession=Session.getInstance(prop,null);
        mailsession.setDebug(false); //是否启用debug模式
        IMAPFolder folder= null;
        IMAPStore store=null;
        
        try {
			store=(IMAPStore)mailsession.getStore("imaps");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  // 使用imap会话机制，连接服务器
        try {
			store.connect(imapserver,receiveemail,emailkey);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			folder=(IMAPFolder)store.getFolder("INBOX");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //收件箱 
        // 使用只读方式打开收件箱 
        try {
			folder.open(Folder.READ_WRITE);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Message[] msgs=null;
		try {
			msgs = folder.getMessages();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        for(int i=msgs.length-1; i>msgs.length-11;i--){
            Message a = msgs[i];
            try {
				if(a.getReceivedDate().compareTo(time)>0){
					//return true;
					System.out.println("receivedate="+a.getReceivedDate()+"       "+"settime="+time);
					is_receive=true;
					break;
				}
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        if(folder!=null){
    		try {
				folder.close(false);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(store!=null){
    		try {
				store.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	//return false;
        return is_receive;
	}
	
}
