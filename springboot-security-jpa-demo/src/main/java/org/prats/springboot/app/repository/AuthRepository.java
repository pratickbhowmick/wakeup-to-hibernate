package org.prats.springboot.app.repository;

import org.prats.springboot.app.entities.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<CredentialEntity, Integer> {

    Optional<CredentialEntity> findByUserName(String userName);

}
