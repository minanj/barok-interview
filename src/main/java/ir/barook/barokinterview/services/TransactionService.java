package ir.barook.barokinterview.services;

import ir.barook.barokinterview.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Component
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;


    @Scheduled(cron = "0 0 0 * * *")
    public void calculateTotalAmountOfTransaction() {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);
        System.out.println("Total amount of Day is:" + transactionRepository.totalAmountOfDay(startOfDay, endOfDay));
    }
}
