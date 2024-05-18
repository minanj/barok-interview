package ir.barook.barokinterview.controller;

import ir.barook.barokinterview.dto.ChargeWalletRequest;
import ir.barook.barokinterview.dto.WalletChargeResponse;
import ir.barook.barokinterview.services.WalletService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/wallet/")
@AllArgsConstructor
public class WalletController {

    private WalletService walletService;

    @PostMapping("/charge-wallet")
    public ResponseEntity<WalletChargeResponse> chargeWallet(@Valid @RequestBody ChargeWalletRequest request) {
        return walletService.addToWallet(request);
    }
}
