package co.vinod.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendEmail(String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("vinod@vinod.co");
        mailMessage.setSubject("New Notification");
        mailMessage.setText(message);
        mailMessage.setFrom(fromEmail);

        mailSender.send(mailMessage);
    }
}