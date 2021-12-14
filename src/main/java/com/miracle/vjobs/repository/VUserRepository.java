package com.miracle.vjobs.repository;

import com.miracle.vjobs.model.VUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VUserRepository extends JpaRepository<VUser, Long> {
}
