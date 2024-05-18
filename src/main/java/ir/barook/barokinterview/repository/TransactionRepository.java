package ir.barook.barokinterview.repository;

import ir.barook.barokinterview.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("SELECT SUM(t.amount) FROM Transaction t where t.transactionDate between :startDate and :endDate")
    long totalAmountOfDay(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
