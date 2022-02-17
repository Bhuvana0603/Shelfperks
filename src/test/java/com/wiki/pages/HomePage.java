package com.wiki.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.wiki.base.HelperMethods;
import com.wiki.base.WebBase;

public class HomePage extends WebBase {
	private HelperMethods mHelp;

	public HomePage() {
		PageFactory.initElements(mDriver, this);

		mHelp = new HelperMethods();

	}

	@FindBy(id = "ca-nstab-main")
	WebElement mMainPageTxt;

	@FindBy(id = "pt-login")
	WebElement mLoginLink;

	@FindBy(linkText = "Careers")
	WebElement mCareersLink;

	@FindBy(id = "wpName1")
	WebElement mUserName;

	@FindBy(id = "wpPassword1")
	WebElement mPassword;

	@FindBy(id = "wpLoginAttempt")
	WebElement mLoginBtn;

	@FindBy(xpath = ".//form/div[@class='errorbox']")
	WebElement mLoginError;

	@FindBy(id = "footer-places-privacy")
	WebElement mPrivacyPolicy;

	@FindBy(id = "footer-places-about")
	WebElement mAboutWiki;

	@FindBy(id = "footer-places-disclaimer")
	WebElement mDisclaimer;

	@FindBy(id = "footer-places-contact")
	WebElement mContactWikipedia;

	@FindBy(id = "footer-places-developers")
	WebElement mDevelopers;

	@FindBy(id = "footer-places-statslink")
	WebElement mStatistics;

	@FindBy(id = "footer-places-cookiestatement")
	WebElement mCookie;

	@FindBy(xpath = ".//footer[@id='footer']/ul[@id='footer-places']/li[@id]")
	List<WebElement> mFooterLinks;
	
	@FindBy(id = "searchInput")
	WebElement mSearch;
	
	@FindBy(id = "searchButton")
	WebElement mSearchBtn;
	
	@FindBy(xpath = ".//a/span[@lang='de']")
	WebElement mGerman;
	
	
	@FindBy(id = "ca-talk")
	WebElement mTalkBtn;
	
	@FindBy(id = "firstHeading")
	WebElement mTalkHeading;
	
	
	@FindBy(id = "pt-createaccount")
	WebElement mCreateAccount;
	
	@FindBy(id = "pt-anoncontribs")
	WebElement mContribution;
	
	@FindBy(id = "pt-logout")
	WebElement mLogout;
	
	@FindBy(id = "p-logo")
	WebElement mLogo;
	
	@FindBy(id = "pt-userpage")
	WebElement mUsername;
	
	
	
	
	
	
	public boolean isUsernameDisplayed() {
		return mUsername.isDisplayed();
	}
	
	public boolean isWikipediaLogoPresent() {
		return mLogo.isDisplayed();
	}
	
	
	public void logout() {
		mLogout.click();
	}
	

	public String getPageTitle() {
		System.out.println("title: " + mDriver.getTitle());
		return mDriver.getTitle();
	}

	public boolean mainPageIsSelected() {
		System.out.println("title: " + mMainPageTxt.getText());
		System.out.println("is Selected: " + mMainPageTxt.getAttribute("class").contains("selected"));
		return mMainPageTxt.getAttribute("class").contains("selected");
	}

	public void clickLogin() {
		mLoginLink.click();
	}

	public void login(String username, String password) {
		mUserName.sendKeys(username);
		mPassword.sendKeys(password);
		mLoginBtn.click();
	}
	
	
	public void loginErrorValidation(String username, String password) {
		mUserName.sendKeys(username);
		mPassword.sendKeys(password);
		clickLogin();
	}
	
	
	
	
	

	public String invalidLogin(String username, String password) {
		mUserName.sendKeys(username);
		mPassword.sendKeys(password);
		mLoginBtn.click();

		return mLoginError.getText();
	}

	public void footerLinks(List<String> footers) {

		for (int i = 0; i < mFooterLinks.size(); i++) {

			Assert.assertTrue(mFooterLinks.get(i).getText().trim().equalsIgnoreCase(footers.get(i).toString().trim()));

		}
	}	
		
	public void search(String url,String searchKeyword) {
		mSearch.sendKeys(searchKeyword);
		mSearchBtn.click();
		String keyword=searchKeyword.substring(0,1).toUpperCase()+searchKeyword.substring(1);
		
		Assert.assertTrue(mDriver.getCurrentUrl().equals(url+keyword));
		
	
	}

	
	public void verifyTalkPage() {
		mTalkBtn.click();
		Assert.assertTrue(mTalkHeading.getText().equals("Talk:Main Page"));
	}
	
	
	public void veriyCreateAccount() {
		Assert.assertTrue(mCreateAccount.getText().equals("Create account"));
		
	}
	
	public void languageCheck() {
		mGerman.click();
		
	}
	
	public void verifyContributionLink() {
		
		Assert.assertTrue(mContribution.getText().equals("Contributions"));
		
	}
	

}