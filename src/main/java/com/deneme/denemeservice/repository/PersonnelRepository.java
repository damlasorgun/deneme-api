package com.deneme.denemeservice.repository;

import com.deneme.denemeservice.entity.PersonnelEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<PersonnelEntity, Long> {

     Optional<PersonnelEntity> findByTcIdentity(Long tcIdentity);
    }
