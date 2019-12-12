package com.eitan.couponsproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eitan.couponsproject.entities.Coupon;
import com.eitan.couponsproject.entities.Customer;
import com.eitan.couponsproject.entities.Purchase;

public interface IPurchaseDao extends CrudRepository<Purchase, Long> {

//	@Query("SELECT c FROM Purchase p JOIN Customer c ON c.id = p.customerId WHERE p.couponId= :couponId")
//	@Query("FROM Purchase p JOIN Customer c ON c.id = p.customerId WHERE Coupon.id=? :couponId")
//	List<Customer> findByCouponId(@Param("couponId") long couponId);

//	@Query("SELECT c FROM Purchase p JOIN Coupon c ON c.id = p.couponId WHERE p.customerId= :customerId")
//	@Query("FROM Purchase p JOIN Coupon c ON c.id = p.couponId WHERE Customer.id=? :customerId")
//	List<Coupon> findByCustomerId(@Param("customerId") long customerId);

	
}
