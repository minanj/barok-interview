package ir.barook.barokinterview.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer userId;
    private Long balance;
    //other fields...
}
