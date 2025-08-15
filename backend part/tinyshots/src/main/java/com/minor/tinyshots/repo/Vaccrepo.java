package com.minor.tinyshots.repo;

import com.minor.tinyshots.model.Vaccinestatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface Vaccrepo extends JpaRepository<Vaccinestatus,Long> {
    Optional<Vaccinestatus> findByUser_Id(Long userId);

}
