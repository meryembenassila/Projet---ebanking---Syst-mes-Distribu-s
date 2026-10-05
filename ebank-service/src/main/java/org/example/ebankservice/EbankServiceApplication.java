package org.example.ebankservice;

import org.example.ebankservice.entities.BankAccount;
import org.example.ebankservice.repositories.EBankRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EBankRepository eBankRepository) {
        return args -> {
            List<Long> ids = List.of(1L, 2L, 3L);

            ids.forEach(id -> {
                for (int i = 0; i < 5; i++) {

                    BankAccount bankAccount = new BankAccount();
                    bankAccount.setCreatedAt(new Date());

                    bankAccount.setBalance(Math.random() + 1000);
                    bankAccount.setType(
                            Math.random() < 0.5
                                    ? "CURRENT_ACCOUNT"
                                    : "SAVING_ACCOUNT"
                    );

                    bankAccount.setIdclient(id);

                    eBankRepository.save(bankAccount);
                }
            });
        };
    }
}
