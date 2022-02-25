package com.nanoom.nanoom.domain.user.service;


import com.nanoom.nanoom.domain.user.dao.UserRepository;
import com.nanoom.nanoom.domain.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Autowired
    UserRepository userRepository;

    //유저 등록
    public User register(String uid, String nickname) {
        User registeredUser = User.builder()
                .nickname(nickname)
                .build();

        userRepository.save(registeredUser);

        return registeredUser;
    }


}
