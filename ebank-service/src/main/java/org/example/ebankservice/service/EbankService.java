package org.example.ebankservice.service;

import lombok.AllArgsConstructor;
import org.example.ebankservice.entities.BankAccount;
import org.example.ebankservice.feign.CustomerRestClient;
import org.example.ebankservice.model.Customer;
import org.example.ebankservice.repositories.EBankRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EbankService {

    private EBankRepository eBankRepository;
    private CustomerRestClient customerRestClient;

    public List<BankAccount> getAllBankAccounts(){
        List<BankAccount> bankAccounts = new ArrayList<>();
        eBankRepository.findAll().forEach(bankAccount -> {
            Customer customer = customerRestClient.getCustomerById(bankAccount.getIdclient());
            bankAccount.setCustomer(customer);
            bankAccounts.add(bankAccount);
        });

        return bankAccounts ;   }


    public BankAccount getAllBankAccountByID(Long id ){
        BankAccount bankAccount = eBankRepository.findById(id).orElseThrow(()->new RuntimeException("BankAccount Not Found"));
        Customer customer = customerRestClient.getCustomerById(bankAccount.getIdclient());
        bankAccount.setCustomer(customer);

        return bankAccount;

    }

    public BankAccount save(BankAccount bankAccount){
        try{
        Customer customer = customerRestClient.getCustomerById(bankAccount.getIdclient());
        bankAccount.setCreatedAt(new Date());
        }catch (Exception e){
           throw new RuntimeException(e.getMessage());
        }
        return eBankRepository.save(bankAccount);

    }
}
