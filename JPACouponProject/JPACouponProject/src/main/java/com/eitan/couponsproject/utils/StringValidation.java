package com.eitan.couponsproject.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.eitan.couponsproject.enums.ErrorType;
import com.eitan.couponsproject.exceptions.ApplicationException;

public class StringValidation {

	//	Regular expression
	public static boolean isEmailAddressValid(String email) throws ApplicationException {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		Pattern p = java.util.regex.Pattern.compile(ePattern);
		Matcher m = p.matcher(email);

		return m.matches();
	}


	//  Only UpperCase and Numbers => at least 8 characters
	public static boolean isPasswordValid(String password) throws ApplicationException {
		if (password.equals(password.toUpperCase()) && password.length() >= 8) {
			return true;
		}

		System.out.println("The password you have entered is InValid");
		throw new ApplicationException(ErrorType.INVALID_PASSWORD, "DateUtils.getCurrentDateAndTime() +"
				+ "Error in StringValidation.ispasswordValid() - InValid password");
	}


}
