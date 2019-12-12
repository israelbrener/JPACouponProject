package com.eitan.couponsproject.logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.eitan.couponsproject.entities.Coupon;
import com.eitan.couponsproject.entities.Customer;
//import com.eitan.couponsproject.entities.MostPurchasedCoupon;
import com.eitan.couponsproject.entities.Purchase;
import com.eitan.couponsproject.entities.User;
import com.eitan.couponsproject.consts.Constants;
import com.eitan.couponsproject.dao.IPurchaseDao;
import com.eitan.couponsproject.data.LoggedInUserData;
import com.eitan.couponsproject.data.PurchaseData;
import com.eitan.couponsproject.enums.ErrorType;
import com.eitan.couponsproject.exceptions.ApplicationException;
//import com.eitan.couponsproject.trackingTable.CouponsTrackingTable;
import com.eitan.couponsproject.utils.DateUtils;

@Controller
public class PurchaseController {

	@Autowired
	private IPurchaseDao purcahseDao; 

	@Autowired
	private CouponController couponController;
//		להוריד את הREQUEST
	public void createPurchase(PurchaseData purchaseData, LoggedInUserData userData) throws ApplicationException {
		
		validatePurchase(purchaseData);

		Coupon coupon = couponController.getCouponById(purchaseData.getCouponId());
		long couponId = coupon.getId();

		int updatedCouponAmount = (coupon.getAmount()) - (purchaseData.getAmount());		
		couponController.reduceCouponAmountByPurchaseAmont(couponId, updatedCouponAmount);

		Customer customer = new Customer();
		User user = new User();
		user.setId(userData.getUserId());
		customer.setUser(user);
//		CHECK IF NEW WITH ID GETS ALL DATA
		Purchase userPurchase = new Purchase(purchaseData.getAmount(), coupon, customer);
		purcahseDao.save(userPurchase);
	}


//	public List<Customer> getPurchasesByCouponId (long couponId) throws ApplicationException {
//
//		List<Customer> purchasesByCouponId = (List<Customer>) purcahseDao.findByCouponId(couponId); 
//		return purchasesByCouponId;
//	}

//	public List<Coupon> getPurchasesByCustomerId(long customerId) throws ApplicationException {
//
//		List<Coupon> purchasesByCustomerId = (List<Coupon>) purcahseDao.findByCustomerId(customerId);
//		return purchasesByCustomerId;
//	}

	public void deletePurchase (long purchaseId) throws ApplicationException {
		
		Purchase purchase = purcahseDao.findById(purchaseId).get();
		purcahseDao.delete(purchase);
	}

	public List<Purchase> getAllPurchases() throws ApplicationException {
		
		List<Purchase> purchases =  (List<Purchase>) purcahseDao.findAll();
		return purchases;
	}

	private void validatePurchase(PurchaseData purchase) throws ApplicationException {

		if (purchase == null) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR, DateUtils.getCurrentDateAndTime() 
					+ "Error in purchaseController.validatePurchase(), You must insert details.");	
		}

//		if (couponController.getCouponById(purchase.getCouponId()) == null) {
//			throw new ApplicationException(ErrorType.ID_DOES_NOT_EXIST, DateUtils.getCurrentDateAndTime()			
//					+ "Error in purchaseController.validatePurchase(),  The coupon you are tempting to buy does'nt exist.");
//		}
//
//		Coupon coupon =  couponController.getCouponById(purchase.getCouponId());
//		int couponAmount = coupon.getAmount();

		if (couponController.getCouponById(purchase.getCouponId()) == null) {
			throw new ApplicationException(ErrorType.ID_DOES_NOT_EXIST, DateUtils.getCurrentDateAndTime()			
					+ "Error in purchaseController.validatePurchase(),  The coupon you are tempting to buy does'nt exist.");
		}

		Coupon coupon =  couponController.getCouponById(purchase.getCouponId());
		int couponAmount = coupon.getAmount(); 
		
		
		if (purchase.getAmount() > couponAmount) {
			throw new ApplicationException(ErrorType.NOT_ENOUGH_COUPONS_LEFT, DateUtils.getCurrentDateAndTime()			
					+ "Error in purchaseController.validatePurchase(), Not enough coupons left to purchase the amount requested.");
		}
	}
	
}

