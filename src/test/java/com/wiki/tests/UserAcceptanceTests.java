

package com.wiki.tests;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wiki.base.GlobalConstants;
import com.wiki.base.HelperMethods;
import com.wiki.base.WebBase;
import com.wiki.pages.HomePage;



public class UserAcceptanceTests extends WebBase {

  
  private HomePage homepage;
  private HelperMethods mHelp;

  public UserAcceptanceTests() {
    super();
    mHelp = new HelperMethods();
  }

  @BeforeMethod
  public void setUp() {
    initialize();
    homepage = new HomePage();
  }

  @Test(priority = 1)
  public void validLogin() {
	  homepage.login(mProperty.getProperty("username"),mProperty.getProperty("password"));
	  
  }
  
  @Test(priority = 2)
  public void verifyFooterLinks() {
	  List<String> footer=new ArrayList<String>();
	  footer.add(GlobalConstants.PRIVACYPOLICY);
	  footer.add(GlobalConstants.ABOUTWIKI);
	  footer.add(GlobalConstants.DISCLAIMERS);
	  footer.add(GlobalConstants.CONTACTWIKI);
	  footer.add(GlobalConstants.MOBILEVIEW);
	  footer.add(GlobalConstants.DEVELOPERS);
	  footer.add(GlobalConstants.STATISTICS);
	  footer.add(GlobalConstants.COOKIESTATEMENT);
	  
	  homepage.footerLinks(footer);
	  
	  
  }
  
  @Test(priority = 3)
  public void verifyLogout() {
	  homepage.login(mProperty.getProperty("username"),mProperty.getProperty("password"));
	  homepage.logout();
  }

  @Test(priority = 4)
  public void verifyWikipediaLogo() {
	  Assert.assertTrue(homepage.isWikipediaLogoPresent());
  }
  
  @Test(priority = 5)
  public void verifyUsernameDisplayed() {
	  homepage.login(mProperty.getProperty("username"),mProperty.getProperty("password"));
	  Assert.assertTrue( homepage.isUsernameDisplayed());
	  
  }


  @AfterMethod
  public void tearDown() {
    mDriver.quit();
  }

}