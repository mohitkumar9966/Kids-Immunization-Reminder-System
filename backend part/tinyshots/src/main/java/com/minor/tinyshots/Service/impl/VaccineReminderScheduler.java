package com.minor.tinyshots.Service.impl;

import com.minor.tinyshots.model.User;
import com.minor.tinyshots.model.Vaccinestatus;
import com.minor.tinyshots.repo.Vaccrepo;
import com.minor.tinyshots.repo.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.List;

@Component
public class VaccineReminderScheduler {
    private static final Logger logger = LoggerFactory.getLogger(VaccineReminderScheduler.class);

    @Autowired
    private userrepo userRepository;

    @Autowired
    private Vaccrepo vaccinestatusRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void sendVaccineReminders() {
        logger.info("Scheduled task started.");
        processReminders();
        logger.info("Scheduled task completed.");    }

    public void processReminders() {
        logger.info("Fetching all users...");
        List<User> users = userRepository.findAll();
        logger.info("Total users found: {}", users.size());


        for (User user : users) {
            logger.info("Processing user: {}", user.getEmail());

            Vaccinestatus status = vaccinestatusRepository.findByUser_Id(user.getId()).orElse(null);
            if (status != null) {
                logger.info("Vaccinestatus found for user: {}", user.getEmail());

                checkAndSendReminder(user, status);
            }  else {
                logger.warn("No Vaccinestatus found for user: {}", user.getEmail());
            }
        }
    }

    private void checkAndSendReminder(User user, Vaccinestatus status) {
        LocalDate today = LocalDate.now();
        logger.info("Checking vaccine due dates for user: {}", user.getEmail());


        if (isDueInThreeDays(status.getVaccine1Status(), user.getVaccine1DueDate(), today)) {
            logger.info("Vaccine 1 is due in three days for user: {}", user.getEmail());

            sendReminderEmail(user, "Vaccine 1", user.getVaccine1DueDate());
            logger.info("returned1.....");

        }
        if (isDueInThreeDays(status.getVaccine2Status(), user.getVaccine2DueDate(), today)) {
            logger.info("Vaccine 2 is due in three days for user: {}", user.getEmail());
            sendReminderEmail(user, "Vaccine 2", user.getVaccine2DueDate());
            logger.info("returned2.....");

        }
        if (isDueInThreeDays(status.getVaccine3Status(), user.getVaccine3DueDate(), today)) {
            logger.info("Vaccine 3 is due in three days for user: {}", user.getEmail());
            sendReminderEmail(user, "Vaccine 3", user.getVaccine3DueDate());
            logger.info("returned3.....");
        }
        if (isDueInThreeDays(status.getVaccine4Status(), user.getVaccine4DueDate(), today)) {
            logger.info("Vaccine 4 is due in three days for user: {}", user.getEmail());
            sendReminderEmail(user, "Vaccine 4", user.getVaccine4DueDate());
            logger.info("returned4.....");
        }
        // Repeat for other vaccines
    }

    private boolean isDueInThreeDays(Boolean status, LocalDate dueDate, LocalDate today) {
        return (status == null || !status) && dueDate != null && today.plusDays(15).isEqual(dueDate);
    }

    private void sendReminderEmail(User user, String vaccineName, LocalDate dueDate) {
        String subject = "Vaccine Reminder: " + vaccineName;
        String text = "Dear " + user.getName() + ",\n\n"
                + "This is a reminder that " + vaccineName + " is due on " + dueDate + ".\n"
                + "Please make sure to take it on time. Also thankyou for choosing our servicees \n\n"
                + "Best regards,\n"
                + "TinyShots";
        emailService.sendSimpleMessage(user.getEmail(), subject, text);
        logger.info("Reminder email sent to: {} for {}", user.getEmail(), vaccineName);

    }
}
