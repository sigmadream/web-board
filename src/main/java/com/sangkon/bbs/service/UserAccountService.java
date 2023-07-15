package com.sangkon.bbs.service;

import com.sangkon.bbs.domain.UserAccount;
import com.sangkon.bbs.dto.UserAccountDto;
import com.sangkon.bbs.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    @Transactional(readOnly = true)
    public Optional<UserAccountDto> searchUser(String username) {
        return userAccountRepository.findById(username).map(UserAccountDto::from);
    }

    public UserAccountDto saveUser(String username, String password, String email, String nickname, String memo) {
        return UserAccountDto.from(userAccountRepository.save(UserAccount.of(username, password, email, nickname, memo, username)));
    }

}