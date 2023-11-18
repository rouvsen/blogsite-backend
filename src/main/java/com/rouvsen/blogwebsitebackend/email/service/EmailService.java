package com.rouvsen.blogwebsitebackend.email.service;

import com.rouvsen.blogwebsitebackend.domain.Consultation;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(Consultation info) {
        try {
            MimeMessage mimeMessage1 = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper1 = new MimeMessageHelper(mimeMessage1, true);

            mimeMessageHelper1.setFrom(username);
            mimeMessageHelper1.setTo(info.getEmail());
            mimeMessageHelper1.setSubject("Consultation registration");
            mimeMessageHelper1.setText("Dear " + info.getFullName() + ", your consultation registration has been completed successfully.");
            javaMailSender.send(mimeMessage1);

            MimeMessage mimeMessage2 = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper2 = new MimeMessageHelper(mimeMessage2, true);

            mimeMessageHelper2.setFrom(username);
            mimeMessageHelper2.setTo(info.getEmail());
            mimeMessageHelper2.setSubject("New Consultation registration!");
            mimeMessageHelper2.setText(
                    String.format("""
                        New Consultation Notification!
                        Email: %s,
                        FullName: %s,
                        Phone: %s,
                        Subject: %s,
                        Message: %s,
                        Date: %s,
                        Time: %s
                    """,
                            info.getEmail(),
                            info.getFullName(),
                            info.getPhone(),
                            info.getSubject(),
                            info.getMessage(),
                            info.getDate(),
                            info.getTime()
                    )
            );

            javaMailSender.send(mimeMessage2);

        } catch (Exception e) {
            throw new RuntimeException("Failed to send mail: " + e.getMessage(), e);
        }
    }
}
