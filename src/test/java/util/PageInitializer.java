package util;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.MyAccountLinkPage;
import pageObjects.UserPage;

public class PageInitializer extends BaseClass{
	
	public static HomePage hp;
	public static MyAccountLinkPage map;
	public static UserPage up;
	public static CheckoutPage cp;
	
	
	public static void initializer() {
		hp = new HomePage();
		map = new MyAccountLinkPage();
		up = new UserPage();
		cp = new CheckoutPage();
	}

}
