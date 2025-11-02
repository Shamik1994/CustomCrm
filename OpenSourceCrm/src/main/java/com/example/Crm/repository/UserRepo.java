package com.example.Crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Crm.bean.UserDetail;

public interface UserRepo extends JpaRepository<UserDetail, Integer> {
	@Query(value = "SELECT * FROM USER_DETAILS WHERE USER_NAME = :userName AND PASS_WORD = :password", nativeQuery = true)
	List<UserDetail> validateUser(@Param("userName") String userName, @Param("password") String password);
}
