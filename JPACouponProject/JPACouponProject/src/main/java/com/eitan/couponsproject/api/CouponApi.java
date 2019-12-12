package com.eitan.couponsproject.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eitan.couponsproject.entities.Coupon;
import com.eitan.couponsproject.exceptions.ApplicationException;
import com.eitan.couponsproject.logic.CouponController;

@RestController
@RequestMapping("/coupons")
public class CouponApi {

	@Autowired
	private CouponController couponController;

	@PostMapping
	public void createCoupon(@RequestBody Coupon coupon) throws ApplicationException{
		couponController.createCoupon(coupon);
	}

	@PutMapping
	public void updateCoupon(@RequestBody Coupon coupon) throws ApplicationException{
		couponController.updateCoupon(coupon);
	}

	@GetMapping
	@RequestMapping("/getCoupon/{couponId}")
	public Coupon getCouponById(@PathVariable("couponId") long couponId) throws ApplicationException{
		return couponController.getCouponById(couponId);
	}

	@DeleteMapping
	@RequestMapping("/{couponId}")
	public void deleteCoupon(@PathVariable("couponId") long couponId) throws ApplicationException{
		couponController.deleteCoupon(couponId);
	}

	@GetMapping
	@RequestMapping
	public List<Coupon> getAllCoupons() throws ApplicationException{
		return couponController.getAllCoupons();

	}

	@GetMapping
	@RequestMapping("/byStartDate")
	public List<Coupon> getCouponByStartDate(@RequestParam("startDate") Date startDate) throws ApplicationException{
		return couponController.getCouponByStartDate(startDate);
	}

	@GetMapping
	@RequestMapping("/byEndDate")
	public List<Coupon> getCouponByEndDate(@RequestParam("endDate") Date endDate) throws ApplicationException{
		return couponController.getCouponByEndDate(endDate);
	}

	@GetMapping
	@RequestMapping("/upToPrice")
	public List<Coupon> getCouponsUpToPrice(@RequestParam("couponPrice") int couponPrice) throws ApplicationException{
		return couponController.getCouponsUpToPrice(couponPrice);
	}
}
