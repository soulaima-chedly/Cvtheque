package com.main.cvtheque.repository;

import com.main.cvtheque.model.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends JpaRepository<CV, Long> {
}
