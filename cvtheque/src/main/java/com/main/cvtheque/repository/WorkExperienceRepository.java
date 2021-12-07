package com.main.cvtheque.repository;

import com.main.cvtheque.model.WorkExperience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {
    Page<WorkExperience> findByCvId(Long cvId, Pageable pageable);
}
