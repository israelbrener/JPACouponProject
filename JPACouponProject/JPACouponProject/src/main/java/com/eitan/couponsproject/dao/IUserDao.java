package com.eitan.couponsproject.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eitan.couponsproject.entities.User;

public interface IUserDao extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.userName= :userName AND u.password= :password")
//	@Query("FROM User u WHERE u.userName=?:userName && u.password=? :password")
	User findUserByUserNameAndPassword(@Param("userName") String userName, @Param("password")  String password);

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.userName = :userName")
//	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.userName=? :userName")
	//	@Query("SELECT * FROM User u WHERE u.userName=?:userName")
	boolean existsByName(@Param("userName") String userName);

}
