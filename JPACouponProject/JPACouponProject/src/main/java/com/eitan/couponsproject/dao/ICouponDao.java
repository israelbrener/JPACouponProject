package com.eitan.couponsproject.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eitan.couponsproject.entities.Coupon;

public interface ICouponDao extends CrudRepository<Coupon, Long> {

	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Coupon c WHERE c.title= :couponName")
//	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Coupon c WHERE c.title=? :couponName")
	//	@Query("SELECT * FROM Coupon c WHERE c.title=:couponName")
	boolean existsByName(@Param("couponName") String couponName);

	@Query("DELETE FROM Coupon c WHERE c.endDate<= :date")
//	@Query("DELETE FROM Coupon c WHERE c.endDate<? :date")
	void deleteAllExpiredCoupons(@Param("date") Date date);

	@Query("UPDATE Coupon c SET c.amount= :amount WHERE ID= :couponId")
//	@Query("UPDATE Coupon c SET c.amount=? :couponId WHERE ID=? :amount")
	void updateCouponAmountByPurchaseAmount(@Param("couponId") long couponId, @Param("amount") int amount);

	@Query("FROM Coupon c WHERE c.price <= :couponPrice")
//	@Query("FROM Coupon c WHERE c.price <=? :couponPrice")
	List<Coupon> findByPriceLessThan (@Param("couponPrice") int couponPrice);

	@Query("FROM Coupon c WHERE c.startDate >= startDate")
//	@Query("FROM Coupon c WHERE c.startDate >=? :startDate")
	List<Coupon> findByStartDateGreaterThan(@Param("startDate") Date startDate);

	@Query("FROM Coupon c WHERE c.endDate <= :endDate")
//	@Query("FROM Coupon c WHERE c.endDate <=? :endDate")
	List<Coupon> findByEndDateLessThan(@Param("endDate") Date endDate); 	

}
