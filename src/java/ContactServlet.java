import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // Assuming you have SMTP server setup
        String host = "your_smtp_host";
        String port = "your_smtp_port";
        String username = "your_email_username";
        String password = "your_email_password";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Get the Session object
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(email));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("recipient@example.com"));
            mimeMessage.setSubject("New Message from Portfolio Contact Form");
            mimeMessage.setText("Name: " + name + "\nEmail: " + email + "\n\nMessage:\n" + message);

            // Send the message
            Transport.send(mimeMessage);

            // Redirect back to contact.jsp with success message
            response.sendRedirect("contact.jsp?status=success");
        } catch (MessagingException e) {
            // Redirect back to contact.jsp with error message
            response.sendRedirect("contact.jsp?status=error");
            throw new RuntimeException(e);
        }
    }
}
