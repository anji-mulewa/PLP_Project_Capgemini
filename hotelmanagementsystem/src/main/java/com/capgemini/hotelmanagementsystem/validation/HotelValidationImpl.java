package com.capgemini.hotelmanagementsystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelValidationImpl implements HotelValidation {
	Pattern pattern = null;
	Matcher matcher = null;

	@Override
	public boolean nameValidation(String name) {
		pattern = Pattern.compile("^[A-Za-z0-9]*[A-Za-z0-9].{6,50}$");
		matcher = pattern.matcher(name);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean licenseValidation(String licenseNumber) {
		pattern = Pattern.compile("^[H][0-9]{8}$");
		matcher = pattern.matcher(licenseNumber);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contactNumberValidation(String contactNumber) {
		pattern = Pattern.compile("[7-9]{1}[0-9]{9}");
		matcher = pattern.matcher(contactNumber);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

}
