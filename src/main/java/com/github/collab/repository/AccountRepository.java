package com.github.collab.repository;

import com.github.collab.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);

    Optional<Account>findByNickName(String nickName);

    boolean existsByEmail(String email);

    Optional<Account> findByRefreshToken(String refreshToken);
}
