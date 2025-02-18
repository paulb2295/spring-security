package com.bpx.spring_security.repositories;

import com.bpx.spring_security.models.entities.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);
}
