package homePageRedesign;

import com.sun.jna.platform.win32.OaIdl.ELEMDESC;

import objectsRepository.OR;
import iSAFE.ApplicationKeywords;
import baseClass.BaseClass;

public class HomePageRedesignValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Home Page Redesign Validation
	// Created by :Shakira & Sindhu
	// Created on :09 Mar 2017

	// ///////////////////////////////////////////////////////////////////////////////

	
	public HomePageRedesignValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	public HomePageRedesignValidation() {

		// TODO Auto-generated constructor st ub
	}

	
	public void validateHomePage() {

		if (currentExecutionMachineName.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {
			validatePageLoadTime("https://www.forbes.com/home_usa/", 16, "Home Page");
			validateHamburgerMenu();
			validateCountryLabels();
			validateHomepageHeaderTabs();
			validateLoginIcon();
			validateSocialSharesInMobile();
			validateSearchIcon();
			validatePromoBlock();
			validateRelatedArticles();
			validateForbesListsDesktop();
			validateRecommendedSection();
			validateForbesVideo(-200);
			validateVideoItems();
			validateBottomRelatedArticles();
			validateTopAds(OR.txt_CSRPageCheck_topAd);
			validateTopAds(OR.ads_Reg_Contributor_Page_TopxAds);
			validateRecAds(OR.ads_HomePage_RecAd);
			validateRecAds(OR.ads_HomePage_CSFAd);
			validateTopAds(OR.ads_Most_Popular_HashTag_Ads);
			
		}
		else if(currentExecutionMachineName.equalsIgnoreCase("AndroidMobile"))
		{
			testStepInfo("********************Home Page For Mobile******************");
			
			validatePageLoadTime("https://www.forbes.com/home_usa/", 17, "Home Page");
			validateCountryLabels();
			
			
			validateLoginIcon();
			validateSocialSharesInMobile();
			validateSearchIcon();
			validatePromoBlock();
			validateRelatedArticles();
			validateForbesLists();
			validateRecommendedSection();
			validateForbesVideo(-60);
			validateVideoItems();
			
			validateBottomRelatedArticles();
			scrollBy(0, 200);
			validateTopAds(OR.ads_Reg_Contributor_Page_TopxAds);
			scrollBy(0, 500);
			validateRecAds(OR.ads_HomePage_RecAd);
			validateTopAds(OR.ads_Most_Popular_HashTag_Ads);
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			validateFooterCopy();
			validateUpdatedFooterNavigation();
			validateHamburgerMenu();
		}
		else {
			testStepInfo("********************Home Page For Mobile******************");
			validateCountryLabels();
			
			
			validateLoginIcon();
			validateSocialSharesInMobile();
			validateSearchIcon();
			validatePromoBlock();
			validateRelatedArticles();
			validateForbesLists();
			validateRecommendedSection();
			validateForbesVideo(-60);
			validateVideoItems();
			
			validateBottomRelatedArticles();
			scrollBy(0, 200);
			validateTopAds(OR.ads_Reg_Contributor_Page_TopxAds);
			scrollBy(0, 500);
			validateRecAds(OR.ads_HomePage_RecAd);
			validateTopAds(OR.ads_Most_Popular_HashTag_Ads);
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			validateFooterCopy();
			validateHamburgerMenu();
		}
	}
	
	
	public void validateHamburgerMenu()
	{
		testStepInfo("*************Validate Hamburger Menu***********");
		try {
			boolean checkHamburger=elementPresent(OR.icon_Home_Page_Hamburger);
			if(checkHamburger==true)
			{
				testStepPassed("Hamburger icon is present");
				clickOn(OR.icon_Home_Page_Hamburger);
				boolean checkHamburgerMenu=elementPresent(OR.txt_HomePage_HamburgerMenu);
				if(checkHamburgerMenu==true)
				{
					int getCount=getElementCount(OR.txt_HomePage_HamburgerMenu);
					testStepPassed("Total number of channels --"+getCount);
					for (int i =1; i <=getCount; i++) {
						String getHamburgerMenuChannels=getText("Ham burger menu#xpath=//div[@class='list-wrapper ng-scope']//ul//li[@class='gallery-list-item ng-scope']["+i+"]");
					testStepPassed("Hamburger Channel is present- "+getHamburgerMenuChannels);
					}
					clickOn(OR.icon_Home_Page_Hamburger);
				}
				else
				{
					testStepFailed("Hamburger Menu is not present");
				}
			}
			else
			{
				testStepFailed("Hamburger Icon is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void validateBottomRelatedArticles()
	{
		testStepInfo("*************Validate Related Articles***********");
		try {
			boolean  checkRelatedArticles=elementPresent(OR.txt_Home_Page_CSFRelatedArticles);
			if(checkRelatedArticles==true)
			{
				int getCount=getElementCount(OR.txt_Home_Page_CSFRelatedArticles);
				testStepPassed("Total Number of Related Articles at the bottom--"+getCount);
				for (int i = 1; i <=getCount; i++) {
					
					boolean checkRelatedArticleImage=elementPresent("Related Article Image#xpath=//ul[@class='related-articles clearfix']//li["+i+"]//a[@class='related-article-image-container']");
					boolean checkRelatedArticleTitle=elementPresent("Related Article Titel#xpath=//ul[@class='related-articles clearfix']//li["+i+"]//h3");
					if(checkRelatedArticleImage==true && checkRelatedArticleTitle==true)
					{
						String getArticleTitle=getText("Related Article Titel#xpath=//ul[@class='related-articles clearfix']//li["+i+"]//h3");
						testStepPassed("Related Article Title is --"+getArticleTitle);
					}
					else
					{
						testStepFailed("Related Article is not present with image");
					}
					
				}
			}
			else
			{
				testStepFailed("Related Articles are not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validateVideoItems()
	{
		testStepInfo("*************Validate Video Items***********");
		try {
			boolean checkVideoItems=elementPresent(OR.txt_HomePage_VideoItems);
			if(checkVideoItems==true)
			{
				int getCount=getElementCount(OR.txt_HomePage_VideoItems);
				testStepPassed("Total Number of Videos --"+getCount);
				for (int i = 1; i <=getCount; i++) {
					
					boolean checkVideoItemImage=elementPresent("Video Item#xpath=//ul[@class='video-items']//li["+i+"]//div");
					boolean checkVideoItemTitle=elementPresent("Video Item Title#xpath=//ul[@class='video-items']//li["+i+"]//h3");
					if(checkVideoItemImage==true && checkVideoItemTitle==true)
					{
						this.scrollToElement("Video Item Title#xpath=//ul[@class='video-items']//li["+i+"]//h3");
						this.scrollBy(0, -60);
						clickOn("Video Item Title#xpath=//ul[@class='video-items']//li["+i+"]//h3");
						
						
						boolean checkVideoBlock=elementPresent(OR.img_Home_Page_ForbesVideoBlock);
						boolean checkVideoTitle=elementPresent(OR.txt_HomePage_ForbesVideoTitle);
						if(checkVideoBlock==true && checkVideoTitle==true)
						{
							testStepPassed("Forbes Video Block is present");
							String getVideoTitle=getText(OR.txt_HomePage_ForbesVideoTitle);
							testStepPassed("Forbes Video Title --"+getVideoTitle);
							
						}
						else
						{
							testStepFailed("Forbes Video block is not present with title");
						}
						
						
					}
				}
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateForbesVideo(int x)
	{
		testStepInfo("*************Validate Forbes Video***********");
		try {
			boolean checkForbesVideoLabel=elementPresent(OR.txt_HomePage_ForbesVideo_Label);
			if(checkForbesVideoLabel==true)
			{
				testStepPassed("Forbes Video Label is present");
				
				boolean checkVideoBlock=elementPresent(OR.img_Home_Page_ForbesVideoBlock);
				boolean checkVideoTitle=elementPresent(OR.txt_HomePage_ForbesVideoTitle);
				if(checkVideoBlock==true && checkVideoTitle==true)
				{
					testStepPassed("Forbes Video Block is present");
					String getVideoTitle=getText(OR.txt_HomePage_ForbesVideoTitle);
					testStepPassed("Forbes Video Title --"+getVideoTitle);
					boolean checkPlayButton=elementPresent(OR.btn_Home_Page_Video_Play_button);
					if(checkPlayButton==true)
					{
					
						this.scrollToElement(OR.btn_Home_Page_Video_Play_button);
						this.scrollBy(0, x);
						clickOn(OR.btn_Home_Page_Video_Play_button);
						
					}
					else
					{
						testStepFailed("Forbes Video Play button is not present");
					}
					
				}
				else
				{
					testStepFailed("Forbes Video block is not present with title");
				}
				
				
				
			}
			else
			{
				testStepFailed("Forbes Video Label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void validateRecommendedSection()
	{
		testStepInfo("*************Validate Recommended***********");
		try {
			this.scrollToElement(OR.txt_HomePage_Recommended);
			this.scrollBy(0, -60);
			boolean checkRecommendedLabel=elementPresent(OR.txt_HomePage_Recommended);
			if(checkRecommendedLabel==true)
			{
				testStepPassed("Recommended Label is present");
				
				boolean checkRecommendedArticleImage=elementPresent(OR.img_HomePage_Recommeded);
				boolean checkRecommendedArticleTitle=elementPresent(OR.txt_HomePage_RecommendedArticles);
				if(checkRecommendedArticleImage==true && checkRecommendedArticleTitle==true)
				{
					int countImage=getElementCount(OR.img_HomePage_Recommeded);
					int countArticle=getElementCount(OR.txt_HomePage_RecommendedArticles);
					testStepPassed("Total number of Images in Recommended Section--->"+countImage);
					testStepPassed("Total number of Articles in Recommended Section--->"+countArticle);
					
					for (int i =1; i <=countArticle; i++) {
						boolean checkArticles=elementPresent("Recommended Articles#xpath=//div[@class='csf-block clearfix ng-scope']//div[@class='article-block ng-scope']["+i+"]//h3[@class='hed ng-binding']");
						boolean checkAarticleImages=elementPresent("Recommended Articles#xpath=//div[@class='csf-block clearfix ng-scope']//div[@class='article-block ng-scope']["+i+"]//div[@class='article-image']");
						if(checkArticles==true && checkAarticleImages==true)
						{
							String getArticle=getText("Recommended Articles#xpath=//div[@class='csf-block clearfix ng-scope']//div[@class='article-block ng-scope']["+i+"]//h3[@class='hed ng-binding']");
							testStepPassed("Recommended Article--->"+i+"-"+getArticle);
						
						}
						else
						{
							String getArticle=getText("Recommended Articles#xpath=//div[@class='csf-block clearfix ng-scope']//div[@class='article-block ng-scope']["+i+"]//h3[@class='hed ng-binding']");
							testStepPassed("Recommended Article--->"+i+"-"+getArticle);
							testStepFailed("Recommended Article is not having Image"+i);
						}
						
					}
					
				}
				else
				{
					testStepFailed("Recommended Articles are not present");
				}
			}
			else{
			testStepFailed("Recommended Label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateForbesLists()
	{
		testStepInfo("*************Validate Forbes Lists***********");
		try {
			this.scrollToElement(OR.txt_HomePage_ForbesLists);
			this.scrollBy(0, -60);
			boolean checkForbesListsLabel=elementPresent(OR.txt_HomePage_ForbesLists);
			if(checkForbesListsLabel==true)
			{
				testStepPassed("Forbes Lists Label is present");
				boolean checkForbesListsArticles=elementPresent(OR.txt_HomePage_ForbesListsArticles);
				if(checkForbesListsArticles==true)
				{
					int getCount=getElementCount(OR.txt_HomePage_ForbesListsArticles);
					testStepPassed("Total Number of Forbes Lists Articles-- "+getCount);
					if(getCount>=3)
					{
						for (int i = 1; i <=3; i++) {
						String getForbesListsArticles=getText("#xpath=//div[@class='slick-track']/div[@class='list-carousel-slide clearfix ng-scope slick-slide slick-current slick-active']//h3");
						testStepPassed("Articles--"+getForbesListsArticles);
						boolean checkNextArrowButton=elementPresent(OR.btn_Contributor_Page_Next);
						if(checkNextArrowButton==true)
						{
							this.scrollBy(0, 500);
							this.scrollToElement(OR.btn_Contributor_Page_Next);
							this.scrollBy(0, -60);
							clickOn(OR.btn_Contributor_Page_Next);
							
						}
						else
						{
							testStepFailed("Next Arrow Button is not present");
						}
					}
					}
					
				}
			}
			else
			{
				testStepFailed("Forbes Lists Label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		//btn_Contributor_Page_Next
	}
	
	public void validateForbesListsDesktop()
	{
		testStepInfo("*************Validate Forbes Lists***********");
		try {
			this.scrollToElement(OR.txt_HomePage_ForbesLists);
			this.scrollBy(0, -60);
			boolean checkForbesListsLabel=elementPresent(OR.txt_HomePage_ForbesLists);
			if(checkForbesListsLabel==true)
			{
				testStepPassed("Forbes Lists Label is present");
				boolean checkForbesListsArticles=elementPresent(OR.txt_HomePage_ForbesListsArticles);
				if(checkForbesListsArticles==true)
				{
					int getCount=getElementCount(OR.txt_HomePage_ForbesListsArticles);
					testStepPassed("Total Number of Forbes Lists Articles-- "+getCount);
					if(getCount==6)
					{
						
						String getForbesListsArticles=getText("#xpath=//div[@class='slick-track']/div[@class='list-carousel-slide clearfix ng-scope slick-slide slick-current slick-active']//h3");
						testStepPassed("Articles--"+getForbesListsArticles);
						boolean checkNextArrowButton=elementPresent(OR.btn_Contributor_Page_Next);
						if(checkNextArrowButton==true)
						{
							this.scrollBy(0, 500);
							this.scrollToElement(OR.btn_Contributor_Page_Next);
							this.scrollBy(0, -60);
							clickOn(OR.btn_Contributor_Page_Next);
							
						}
						else
						{
							testStepFailed("Next Arrow Button is not present");
						}
					
					}
					
				}
			}
			else
			{
				testStepFailed("Forbes Lists Label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		//btn_Contributor_Page_Next
	}
	
	public void validateHomepageHeaderTabs(){
		testStepInfo("***************************Validate header tabs*************************");
		try {
		boolean checkHeaderTabs=elementPresent(OR.txt_HomePage_HeaderTabs);
		if(checkHeaderTabs==true)
		{
			testStepPassed("Header Tabs are present");
			int getTabsCount=getElementCount(OR.txt_HomePage_HeaderTabs);
			testStepPassed("Total Number of header and sub tabs on homepage are --"+getTabsCount);
		}
		else
		{
			testStepFailed("Header Tabs are not present");
		}
		}
		catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateLoginIcon()
	{
		testStepInfo("*************Validate Login Icon***********");
		try {
			boolean checkLoginIcon=elementPresent(OR.icon_HomePage_Login);
			if(checkLoginIcon==true)
			{
				testStepPassed("Login Icon is present");
				clickOn(OR.icon_HomePage_Login);
				boolean checkLoginText=elementPresent(OR.txt_HomePage_LoginSignIn);
				if(checkLoginText==true)
				{
					testStepPassed("Login/Sign Up Text is present");
				}
				else
				{
					testStepFailed("Login/Sign Up Text is not present");
				}
			}
			else
			{
				testStepFailed("Login Icon is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	
	
	public void validateCountryLabels()
	{
		testStepInfo("***************************Validate Country Labels*************************");
		try {
			boolean checkCountryUSLabel=elementPresent(OR.txt_HomePage_Us);
			if(checkCountryUSLabel==true)
			{
				testStepPassed("US Country Label is present");
			}
			else
			{
				testStepFailed("US country Label is not present");
			}
			
			boolean checkCountryAsiaLabel=elementPresent(OR.txt_HomePage_Asia);
			if(checkCountryAsiaLabel==true)
			{
				testStepPassed("Asia Country Label is present");
			}
			else
			{
				testStepFailed("Asia country Label is not present");
			}
			
			boolean checkCountryEuropeLabel=elementPresent(OR.txt_HomePage_Europe);
			if(checkCountryEuropeLabel==true)
			{
				testStepPassed("Europe Country Label is present");
			}
			else
			{
				testStepFailed("Europe country Label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
}		