package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.GeneratedComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratedComponentRepository extends JpaRepository<GeneratedComponent, Long> {
}
