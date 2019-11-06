package com.nutritech.nu34life.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.nutritech.nu34life.model.entity.Account;


@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface uSERrEPOSITORY2 extends PagingAndSortingRepository<Account,Long>{

	@Query("SELECT u FROM Account u WHERE u.username=?1")
	Account getByUsername(String _username);

    @RestResource(path="getUsername")
	Account findByUsername(@Param("_username") String username);
	
}
