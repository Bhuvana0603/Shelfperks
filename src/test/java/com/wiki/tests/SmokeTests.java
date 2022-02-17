package com.wiki.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wiki.base.GlobalConstants;
import com.wiki.base.HelperMethods;
import com.wiki.base.WebBase;
import com.wiki.pages.HomePage;



public class SmokeTests extends WebBase {

  
  private HomePage homepage;
  private HelperMethods mHelp;

  public SmokeTests() {
    super();
    mHelp = new HelperMethods();
  }

  @BeforeMethod
  public void setUp() {
    initialize();
    homepage = new HomePage();
  }

  @Test(priority = 1)
  public void verifyLandingPage() {

    Assert.assertTrue(homepage.getPageTitle().trim().equals(GlobalConstants.WELCOME_PAGETITLE.trim()));
    Assert.assertTrue(homepage.mainPageIsSelected());
   
  }
  
  @Test(priority = 2)
  public void verifyLocalization() {
	  homepage.languageCheck();
  }
  
  @Test(priority = 3)
  public void verifyTalk() {
	  homepage.verifyTalkPage();;
  }

  @Test(priority = 4)
  public void verifyCreateAccountLink() {
	  homepage.veriyCreateAccount();
  }
  
  @Test(priority = 5)
  public void verifyContributionLink() {
	  homepage.verifyContributionLink();
  }


  @AfterMethod
  public void tearDown() {
    mDriver.quit();
  }

}