package ir.barook.barokinterview.services;

import ir.barook.barokinterview.dto.BalanceResponse;
import ir.barook.barokinterview.model.Account;
import ir.barook.barokinterview.model.Action;
import ir.barook.barokinterview.model.UserLog;
import ir.barook.barokinterview.repository.AccountRepository;
import ir.barook.barokinterview.repository.UserLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserLogRepository userLogRepository;

    public ResponseEntity<BalanceResponse> getBalance(Integer userId) {

        Account accountInfo = accountRepository.findByUserId(userId);
        if (accountInfo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userLogRepository.save(UserLog.builder().userId(userId).action(Action.GET_BALANCE)
                .creationDate(ZonedDateTime.now()).build());
        BalanceResponse balance = BalanceResponse.builder().balance(accountInfo.getBalance()).build();
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }
}
