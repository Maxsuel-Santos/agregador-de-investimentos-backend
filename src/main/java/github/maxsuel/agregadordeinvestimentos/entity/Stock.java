package github.maxsuel.agregadordeinvestimentos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stocks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Stock {
    
    @Id
    @Column(name = "stock_id", nullable = false, unique = true)
    private String stockId;

    @Column(name = "description", nullable = false)
    private String description;

}
