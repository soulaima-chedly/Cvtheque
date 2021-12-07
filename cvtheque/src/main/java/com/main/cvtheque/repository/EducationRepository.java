package com.main.cvtheque.repository;

import com.main.cvtheque.model.Education;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    Page<Education> findByCvId(Long cvId, Pageable pageable);
}
