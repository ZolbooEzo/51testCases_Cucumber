package util;

import com.github.javafaker.Faker;

public class FakerClass {
	

	public static Faker faker;
	
	 public static String randomFirstName() {

	        faker = new Faker();

	        return faker.name().firstName();
	    }

	    public static String randomLastName() {
	        faker = new Faker();

	        return faker.name().lastName();
	    }

	    public static String randomFullName() {
	        faker = new Faker();

	        return faker.name().fullName();
	    }

	    public static String randomStreet() {
	        faker = new Faker();

	        return faker.address().streetAddress();
	    }

	    public static String randomCity() {
	        faker = new Faker();

	        return faker.address().city();
	    }

	    public static String randomState() {
	        faker = new Faker();

	        return faker.address().state();
	    }


	    public static String randomZip() {
	        faker = new Faker();

	        return faker.address().zipCode().substring(0, 5);
	    }

	    public static String randomCardNumber() {
	        faker = new Faker();

	        return faker.finance().creditCard().replaceAll("-", "");
	    }

	    public static String randomNumber() {

	        faker = new Faker();

	        return faker.number().digit();

	    }

}
