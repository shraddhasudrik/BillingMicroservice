package com.hms.billingms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.billingms.model.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
	
	public Optional<UserEntity> findById(String id);

}
