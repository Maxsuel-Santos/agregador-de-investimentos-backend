package github.maxsuel.agregadordeinvestimentos.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountStockId {
    
    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @Column(name = "stock_id", nullable = false)
    private String stockId;

}
