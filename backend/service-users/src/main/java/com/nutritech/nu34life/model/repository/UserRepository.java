package com.nutritech.nu34life.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nutritech.nu34life.model.entity.Account;


@Repository
public interface UserRepository extends JpaRepository<Account,Long>{

	@Query("SELECT u FROM Account u WHERE u.username=?1")
	Account getByUsername(String _username);
	
	Account findByUsername(@Param("_username") String username);
}
