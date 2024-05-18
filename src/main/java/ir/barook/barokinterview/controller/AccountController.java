package ir.barook.barokinterview.controller;

import ir.barook.barokinterview.dto.BalanceResponse;
import ir.barook.barokinterview.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/get-account-balance/{user-id}")
    public ResponseEntity<BalanceResponse> getBalance(@PathVariable("user-id") Integer userId) {
        return accountService.getBalance(userId);
    }
}
