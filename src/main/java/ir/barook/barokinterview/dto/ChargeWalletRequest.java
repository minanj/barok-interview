package ir.barook.barokinterview.dto;

import jakarta.annotation.Nonnull;
import lombok.Data;

@Data
public class ChargeWalletRequest {
    @Nonnull
    private Integer userId;
    @Nonnull
    private Integer amount;
}
