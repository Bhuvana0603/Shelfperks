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



public class FunctionalTests extends WebBase {

  
  private HomePage homepage;
  private HelperMethods mHelp;

  public FunctionalTests() {
    super();
    mHelp = new HelperMethods();
  }

  @BeforeMethod
  public void setUp() {
    initialize();
    homepage = new HomePage();
  }

  @Test(priority = 0)
  public void verifyPageTitle() {

    Assert.assertTrue(homepage.getPageTitle().trim().equals(GlobalConstants.WELCOME_PAGETITLE.trim()));
    
  }
  @Test(priority = 1)
  public void loginWithInvalidCredentials(){
	  homepage.clickLogin();
	  Assert.assertTrue(homepage.invalidLogin(mHelp.generateRandomString(5),mHelp.generateRandomString(6)).trim().equalsIgnoreCase(GlobalConstants.LOGINERROR.trim()));
  }
  
  @Test(priority = 2)
  public void validLogin() {
	  homepage.clickLogin();
	  
  }
  
  @Test(priority = 3)
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
  
  @Test(priority = 4)
  public void verifySearch() {
	  homepage.search(GlobalConstants.HOSTURL, "history");
  }
  
  
  @Test(priority = 5)
  public void invalidSearch() {
	  homepage.search(GlobalConstants.HOSTURL,mHelp.generateRandomString(5));
  }
  
 

  @AfterMethod
  public void tearDown() {
    mDriver.quit();
  }

}