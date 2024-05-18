package ir.barook.barokinterview.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WalletChargeResponse {
    @JsonProperty("reference_id")
    private Long referenceNumber;

}
