package org.example.ebankservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ebankservice.model.Customer;

import java.util.Date;

@Entity
@Data
 @AllArgsConstructor
@NoArgsConstructor

public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private double balance;
    private Date CreatedAt;
    private String type;
    private Long idclient;//clé etrangère
    @Transient // cette attribut exsiste dans la classe mais il n'est pas representé dans la base de donnes (cad une entité )
    private Customer customer;
}


