package com.example.Crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Crm.bean.UserDetail;
@Repository
public interface UserRepo extends JpaRepository<UserDetail, Integer> {
	/*
	@Query(value = "SELECT * FROM USER_DETAILS WHERE USER_NAME = :userName AND PASSWORD = :password", nativeQuery = true)
	List<UserDetail> validateUser(@Param("userName") String userName, @Param("password") String password);
	*/
	@Query(value = "SELECT * FROM USER_DETAILS WHERE USER_NAME = ?1 AND PASSWORD = ?2", nativeQuery = true)
	List<UserDetail> validateUser(String userName, String password);

}
