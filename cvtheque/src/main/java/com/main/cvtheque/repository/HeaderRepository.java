package com.main.cvtheque.repository;

import com.main.cvtheque.model.Header;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepository extends JpaRepository<Header, Long> {
    Page<Header> findByCvId(Long cvId, Pageable pageable);
}
