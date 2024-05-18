package ir.barook.barokinterview.services;

import ir.barook.barokinterview.dto.ChargeWalletRequest;
import ir.barook.barokinterview.dto.WalletChargeResponse;
import ir.barook.barokinterview.model.Action;
import ir.barook.barokinterview.model.Transaction;
import ir.barook.barokinterview.model.UserLog;
import ir.barook.barokinterview.model.Wallet;
import ir.barook.barokinterview.repository.TransactionRepository;
import ir.barook.barokinterview.repository.UserLogRepository;
import ir.barook.barokinterview.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;
    private final UserLogRepository userLogRepository;

    public ResponseEntity<WalletChargeResponse> addToWallet(ChargeWalletRequest request) {
        Wallet userWallet = walletRepository.findByUserId(request.getUserId());
        userWallet.setBalance(userWallet.getBalance() + request.getAmount());
        Transaction transaction = Transaction.builder().wallet(userWallet)
                .transactionDate(LocalDateTime.now()).amount(request.getAmount())
                .referenceId(generateRefNumber()).build();
        transactionRepository.save(transaction);
        walletRepository.save(userWallet);
        userLogRepository.save(UserLog.builder().userId(request.getUserId()).
                action(request.getAmount() > 0 ? Action.WALLET_DEPOSIT : Action.WALLET_WITHDRAWAL)
                .creationDate(ZonedDateTime.now()).build());
        return new ResponseEntity<>(WalletChargeResponse.builder()
                .referenceNumber(transaction.getReferenceId()).build(), HttpStatus.OK);
    }


    public long generateRefNumber() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextLong(10_000_000_000L, 100_000_000_000L);
    }
}
