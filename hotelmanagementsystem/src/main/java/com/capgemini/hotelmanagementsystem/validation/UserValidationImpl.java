package com.capgemini.hotelmanagementsystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidationImpl implements UserValidation {

	Pattern pattern = null;
	Matcher matcher = null;

	@Override
	public boolean emailValidation(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\." + "[a-zA-Z0-9_+&-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		pattern = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		}
		return pattern.matcher(email).matches();
	}

	@Override
	public boolean passwordValidation(String password) {
		// pattern = Pattern.compile("\\w+");
		pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,10}$");
		matcher = pattern.matcher(password);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean idValidation(String id) {
		pattern = Pattern.compile("\\d{1,10}");
		matcher = pattern.matcher(id);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean nameValidation(String name) {
		pattern = Pattern.compile("\\w+\\s\\w+");
		matcher = pattern.matcher(name);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean optionValidation(String option) {
		pattern = Pattern.compile("\\d{1}");
		matcher = pattern.matcher(option);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean cardNumberValidation(String cardno) {
		pattern = Pattern.compile("\\d{16}");
		matcher = pattern.matcher(cardno);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean cvvValidation(String cvv) {
		pattern = Pattern.compile("\\d{3}");
		matcher = pattern.matcher(cvv);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
}
