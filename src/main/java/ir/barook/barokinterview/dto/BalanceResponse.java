package ir.barook.barokinterview.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BalanceResponse {
    private Long balance;
}
