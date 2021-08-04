package org.prats.springboot.app.service;

import org.prats.springboot.app.dto.User;
import org.prats.springboot.app.entities.CredentialEntity;
import org.prats.springboot.app.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<CredentialEntity> userEntityOptional = authRepository.findByUserName(userName);

        if (!userEntityOptional.isPresent()) { throw  new UsernameNotFoundException("User not found"); }

        CredentialEntity credentialEntity = userEntityOptional.get();

        List<String> roles = credentialEntity.getAuthorizations()
                .stream()
                .map(p -> p.getAuthorization())
                .collect(Collectors.toList());

        User user = new User(credentialEntity.getUserName(),
                credentialEntity.getPassword(),
                credentialEntity.isEnabled(),
                roles);

        return user;
    }

}
