package tools;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServeurSMTP {

   
    public static MimeMessage newEmail(String name, String to,
            String subject) throws MessagingException {
        MimeMessage result;
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        final String username = "btssiomassy@gmail.com";
        final String password = "siomassy";
        System.out.println("le system de mail a bien été configuré ");
        String[] toutesAdressesStr = to.split(";");
        InternetAddress[] toutesAdresses = new InternetAddress[toutesAdressesStr.length];

        javax.mail.Session sessionMail = javax.mail.Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        result = new MimeMessage(sessionMail);
        try {
            result.setFrom(new InternetAddress(username, name));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ServeurSMTP.class.getName()).log(Level.SEVERE, null, ex);
        }

        int i = 0;
        for (String uneAdresse : toutesAdressesStr) {
            toutesAdresses[i] = new InternetAddress(uneAdresse.trim());
            i++;
        }

        result.addRecipients(Message.RecipientType.TO, toutesAdresses);

        result.setSubject(subject);
        return result;
    }

}