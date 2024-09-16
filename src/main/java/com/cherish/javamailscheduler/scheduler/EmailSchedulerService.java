package com.cherish.javamailscheduler.scheduler;

import com.cherish.javamailscheduler.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmailSchedulerService {
    private final EmailService emailService;

    @Autowired
    public EmailSchedulerService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 0 13 * * *")
    // sends mail every day at 1 pm
    public void sendMail() {
        String from = "cherryvuppala@gmail.com";
        String to = from;
        String subject = "Daily Mail Update";
        String content = "Hi, Please find today's file content attached for your review. Let me know if you need any updates or changes.";
        emailService.sendEmail(from, to, subject, content);
    }

}
