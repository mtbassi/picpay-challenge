package dev.bassi.picpay.picpaychallenge.service;

import dev.bassi.picpay.picpaychallenge.client.NotificationClient;
import dev.bassi.picpay.picpaychallenge.entity.TransactionEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final NotificationClient notificationClient;

    public void sendNotification(TransactionEntity transactionEntity) {
        try {
            log.info("Transaction notification sent: {}", transactionEntity.getId());
            var response = this.notificationClient.sendNotification(transactionEntity);
            if (response.getStatusCode().isError()) {
                log.warn("Error while sending notification. Notification not sent.");
            }
        } catch (Exception e) {
            log.error("Error while sending notification.");
        }
    }
}
