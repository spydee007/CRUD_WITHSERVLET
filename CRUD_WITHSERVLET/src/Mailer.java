import javax.mail.*;
import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
@SuppressWarnings("unused")
public class Mailer {
	String mailUser ,mailPass;
	
	public static int sendMail(String toAddr , String email , String Message){
		

		
		return 1;
		
	}
	
	public void getMailConfig() throws IOException{
		
		try{
			Properties pr = new Properties();
			String propFile = "config.properties";
		InputStream is = getClass().getClassLoader().getResourceAsStream(propFile);
		if (is != null){
			pr.load(is);
		}
		else {
			throw new FileNotFoundException("Property file not found ");
		}
		
		Date dt = new Date(System.currentTimeMillis());
		mailUser = pr.getProperty("mail_user");
		mailPass = pr.getProperty("mail_pass");
		pr.put("mail.smtp.host", "pune811.egain.in");
		pr.put("mail.smtp.auth", "true");
//		new javax.mail.Authenticator().
//		PasswordAuthentication
//		Session session = Session.getDefaultInstance(pr , )
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
