/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import junit.framework.TestCase;
import tools.ServeurSMTP;
import tools.ServeurSMTP;

/**
 *
 * @author admin
 */
public class ServeurSMTPTest extends TestCase {

  public void testNewEmail() throws MessagingException {
    System.out.println("newEmail");
    try {
      String from = "btssiomassy@gmail.com";
      String to = "mohamedennoun@gmail.com";
      String subject = "Test unitaire";
      MimeMessage result = ServeurSMTP.newEmail(from, to, subject);
      String body = "Du texte avec des � et autres caract�res accentu�s.";
      MimeMessage mail = ServeurSMTP.newEmail(from, to, subject);
      mail.setContent(body, "text/plain; charset=utf-8");
      javax.mail.Transport.send(mail);
    }
    catch (MessagingException exc ) {
      exc.printStackTrace();
      throw exc;
    }
  }

}