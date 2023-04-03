package com.github.collab.service;

import com.github.collab.domain.Account;
import com.github.collab.dto.DeleteRequestAccountDto;
import com.github.collab.dto.SignUpRequestAccountDto;
import com.github.collab.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void signUp(SignUpRequestAccountDto accountDto) {
        Account savedAccount = accountDto.toEntity(accountDto);
        accountRepository.save(savedAccount);
    }

    public void deleteAccount(DeleteRequestAccountDto accountDto) {
        Account foundAccount = accountRepository.findByEmail(accountDto.getEmail())
                        .orElseThrow(
                                () -> new EntityNotFoundException("해당 이메일 계정 없음"));

        if (!foundAccount.getPassword().equals(accountDto.getPassword())) {
            throw new IllegalArgumentException("패스워드 잘못됨");
        }

        accountRepository.delete(foundAccount);
    }
}
