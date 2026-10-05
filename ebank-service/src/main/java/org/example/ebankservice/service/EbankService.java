package org.example.ebankservice.service;

import lombok.AllArgsConstructor;
import org.example.ebankservice.entities.BankAccount;
import org.example.ebankservice.repositories.EBankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EbankService {
    private EBankRepository eBankRepository;
    public List<BankAccount> getAllBankAccounts(){
        return eBankRepository.findAll() ;   }


    public BankAccount getAllBankAccountByID(Long id ){
        return eBankRepository.findById(id).orElseThrow(()->new RuntimeException("BankAccount Not Found"));

    }

    public BankAccount save(BankAccount bankAccount){
        return eBankRepository.save(bankAccount);

    }
}
