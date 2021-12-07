package com.main.cvtheque.repository;

import com.main.cvtheque.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    Page<Skill> findByCvId(Long cvId, Pageable pageable);
}
