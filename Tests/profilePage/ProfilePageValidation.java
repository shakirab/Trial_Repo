/**
 * Verify the list is displayed - Check for Billionaire as reference
 * Verify the user can view the complete list by clicking 'View Complete List' button
 * Verify the user is able to scroll down to the list and check for all Ads 
 * Verify the Ad is displayed for every 10 profiles
 * Verify each and every tab is clickable and details are displayed
 * Verify the images are displayed in all pages
 * Verify the profile page is displayed with the following options:NEXT, PREV, PROFILE GALLERY, LOAD MORE" 

 * 
 */

package profilePage;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ListsPageValidation. class names are written in mixed case with the
 * first letter of each internal word capitalized
 */
public class ProfilePageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Profile Page Validation
	// Created by :Shakira
	// Created on :14 June 2016
	//Redesign : 20 March 2017

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new lists page validation.
	 *
	 * @param obj
	 *            the obj
	 */
	public ProfilePageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}


	public ProfilePageValidation() {

	}

	/**
	 * Verify profile page.
	 */
	public void verifyProfilePage() {
		
		
		if (currentExecutionMachineName.equalsIgnoreCase("CSF_CSR_List_Editors")) {
			
		
			testStepInfo("*************** Lists Page***************");
			validatePageLoadTime("https://www.forbes.com/billionaires/list/", 20, "Lists Page");
			validateTopAds(OR.adsHomePageTopAds);	
			validateSpreadsheetAndReprintLinks();
			validateSeeRealTimeRanking();
			validateSocialnetworks(OR.img_Reg_Lists_Page_SocialShare_Options);
			verifyAdsInLsits();
			
			testStepInfo("*************** Profile Page***************");
			
			validatePageLoadTime("https://www.forbes.com/profile/bill-gates/?list=billionaires", 20, "Profile Page");
			//driver.get("https://www.forbes.com/profile/bill-gates/?list=billionaires");
			validateProfileRank();
			validateProfileName_Logo();
			validateNetWorth(OR.txt_Lists_Page_InProfile_PrimaryRealTimeNetWorth, OR.txt_Lists_Page_PrimaryAmount, " RT ");
			validateNetWorth(OR.txt_Lists_Page_InProfile_SecondaryRealTimeNetWorth, OR.txt_Lists_Page_SecondaryAmount, " Billionaires ");
			validateBioGraphy();
			validateNetWorthOverTime();
			validateQuoteInProfilePage();
			validateDidyouKnow();
			validateConnection();
			validateStatsLists();
			
			validateNewsWorthy();
			
			testStepInfo("****************Validate Ads**************");
			validateTopAds(OR.adsHomePageTopAds);	
			validateRecAds(OR.adsHomePageRecAds);
			validateRailRecAds(OR.ads_New_Posts_RailRec_Ads);
			validateTextAds();
			validateLogeAds();
			validateUpdatedFooterNavigation();
			validateListsNavigation();
			//validateProfileRank();
			//validateDoNotMiss();
			
		/*	validateTitleOfPage();
			validateTopPromoBlock();
			validateStickySocialShare();
			validateTopAds(OR.adsHomePageTopAds);
			validateCountryDropdown();
			validateBilionairesLists();
			validateProfilePage();
			//validateProfile();
			verifyFullList();
			verifyAdsInLsits();
*/
		} 
		else if (currentExecutionMachineName.equalsIgnoreCase("AndroidMobile")) {
			testStepInfo("*************** LISTS Page For Mobile***************");
			
			
			validatePageLoadTime("https://www.forbes.com/profile/bill-gates/?list=billionaires", 13, "Profile Page");
			driver.get("https://www.forbes.com/profile/bill-gates/?list=billionaires");
			
			validateProfileName_Logo();
			
			validateNetWorth(OR.txt_Lists_Page_InProfile_PrimaryRealTimeNetWorth, OR.txt_Lists_Page_PrimaryAmount, "Real Time ");
			validateNetWorth(OR.txt_Lists_Page_InProfile_SecondaryRealTimeNetWorth, OR.txt_Lists_Page_SecondaryAmount, "Billionaires ");
			validateBioGraphy();
			validateDidyouKnow();
			validateNetWorthOverTime();
			validateTopAds(OR.ads_Lists_Page_TopAd);
			validateQuoteInProfilePage();
			validateConnectionsInMobile();
			validateForbesOnListsInMobile();
			newsWorthyArticlesInMobile();
			verifyRelatedTopicsInMob();
			validateStatsInMobile();
			validateListsNavigation();
			
			
			/*validatePageLoadTime("http://www.forbes.com/billionaires/",13,"Lists Page");
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);

			verifyNextPrevoiusNavigationInMobile();
			validateSocialnetworks(OR.img_Mob_Lists_Page_Share);

			verifyRichListsInMobile();
			verifyProfileInMobile();*/
		}
		else {
			testStepInfo("*************** LISTS Page For Mobile***************");
			validatePageLoadTime("http://www.forbes.com/billionaires/",13,"Lists Page");
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);

			verifyNextPrevoiusNavigationInMobile();
			validateSocialnetworks(OR.img_Mob_Lists_Page_Share);

			verifyRichListsInMobile();
			verifyProfileInMobile();

		}
	}

	
	
	//Mobile 22/03/2017
	
	public void newsWorthyArticlesInMobile()
	{
		testStepInfo("*******************News Worthy Articles********************");
		try {
			boolean checkNewsWorthyArticles=elementPresent(OR.txt_Lists_Page_NewsWorthyArticles);
			if(checkNewsWorthyArticles==true)
			{
				int getCount=getElementCount(OR.txt_Lists_Page_NewsWorthyArticles);
				testStepPassed("Total NewsWorthy Articles --"+getCount);
				boolean checkMoreButton=elementPresent(OR.btn_Lists_Page_NewsWorthyMoreLess);
				if(getCount==4 || getCount>4)
				{
				if(checkMoreButton==true)
				{
					testStepPassed("News Worthy More Button is present");
					this.scrollToElement(OR.btn_Lists_Page_NewsWorthyMoreLess);
					this.scrollBy(0, -60);
					clickOn(OR.btn_Lists_Page_NewsWorthyMoreLess);
					
					boolean checkHiddenArticles=elementPresent(OR.txt_Lists_Page_NewsWorthyHidden);
					if(checkHiddenArticles==true)
					{
						int getHiddenArticlesCount=getElementCount(OR.txt_Lists_Page_NewsWorthyHidden);
						testStepPassed("News Worthy Articles are present after clicking on the More button--"+getHiddenArticlesCount);
					}
					else
					{
						testStepFailed("News Worthy Articles are not present after clicking on the More Button");
					}
					
				}
				else
				{
					testStepFailed("News Worthy More Button is not present");
				}
				}
				
			}
			else
			{
				testStepFailed("News Worthy Articles are not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	public void validateForbesOnListsInMobile()
	{
		testStepInfo("*******************Forbes On Lists*********************");
		try {
			boolean checkOnForbesLists=elementPresent(OR.txt_Lists_Page_OnForbesLists);
			if(checkOnForbesLists==true)
			{
				testStepPassed("On Forbes Lists Container Label is present");
			}
			else
			{
				testStepFailed("On Forbes Lists Container Label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateStatsInMobile()
	{
		testStepInfo("*******************Validate Stats*******************");
		boolean checkStats=elementPresent(OR.txt_Lists_Page_Stats);
		if(checkStats==true)
		{
			testStepPassed("Stats Container Label is present");
		}
		else
		{
			testStepFailed("Stats Container Label is not present");
		}
		
	}
	public void validateConnectionsInMobile()
	{
		testStepInfo("*********************Validate Connection*******************");
		try {
			boolean checkConncetionImage=elementPresent(OR.img_Lists_Page_Connection_Image);
			
			
			if(checkConncetionImage==true)
			{
				int getCount=getElementCount(OR.img_Lists_Page_Connection_Image);
				testStepPassed("Total number of slides in the connections--"+getCount);
				
				int getNameCount=getElementCount(OR.txt_Lists_Page_Connections_Name1);
				testStepPassed("Total number of slides Name in the connections--"+getNameCount);
				
				int getRelationshipCount=getElementCount(OR.txt_Lists_Page_Connections_Relationship1);
				testStepPassed("Total number of slides Relationship in the connections--"+getRelationshipCount);
				
				if(getCount==getNameCount && getCount==getRelationshipCount)
				{
					testStepPassed("Slides are displayed with Name and Relationship");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Slides sre not displayed with name and relationship");
				}
				
				boolean checkNavControlButton=elementPresent(OR.button_Lists_Page_Connection_Nav_Control);
				if(checkNavControlButton==true)
				{
					testStepPassed("Connection control nav paging button is present");
					this.scrollToElement(OR.button_Lists_Page_Connection_Nav_Control);
					this.scrollBy(0, -60);
					clickOn(OR.button_Lists_Page_Connection_Nav_Control);
					boolean checkImage=elementPresent(OR.img_Lists_Page_Connection_Image2);
					if(checkImage==true)
					{
						String getName=getText(OR.txt_Lists_Page_Connections_Name1);
						
						testStepPassed("Connection image is present after clicking on control nav paging button--"+getName);
					}
					else
					{
						testStepFailed("Connection image is not present");
					}
					
				}
				else
				{
					testStepPassed("Connection control nav paging button is not present");
				}
				
			}
			else
			{
				testStepFailed("Connection image is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		
	}
	public void validateNewsWorthy()
	{
		testStepInfo("************ Validate NewsWorthy*************");
		try {
			boolean checkNewsWorthy=elementPresent(OR.txt_Lists_Page_NewsWorthy);
			if(checkNewsWorthy==true)
			{
				int getCount=getElementCount(OR.txt_Lists_Page_NewsWorthy);
				testStepPassed("Total Number of Newworthy Articles--->"+getCount);
				for (int i =1; i <=getCount; i++) {
				
					String getTitle=getText("NewsWorthy articles#xpath=//ul[@class='stream_content']//li["+i+"]//article//h2");
					testStepPassed("NewsWorthy Articles---"+i+"-"+getTitle);
				}
				
			}
			else
			{
				testStepFailed("NewsWorthy articles are not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	
	public void validateListsNavigation()
	{
		testStepInfo("*******************LISTS Link*******************");
		try {
			boolean checkListsChannel=elementPresent(OR.txt_Lists_Page_ProfileLists);
			if(checkListsChannel==true)
			{
				testStepPassed("Lists Link is present");
				clickOn(OR.txt_Lists_Page_ProfileLists);
				waitTime(3);
				boolean checkListsPageTitle=elementPresent(OR.txt_Lists_Page_ListsTitle);
				if(checkListsPageTitle==true)
				{
					testStepPassed("Navigated to Lists Page after clicking on the Lists Link from profile page");
				}
				else
				{
					testStepFailed("Failed to navigate Lists Page");
				}
			}
			else
			{
				testStepFailed("Lists Channel Link is not present in the profile page");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	
	}
	
	
	public void validateDoNotMiss()
	{
		testStepInfo("************Validate Do Not Miss*************");
		try {
			waitTime(6);
			this.scrollBy(0, 2000);
			this.scrollToElement(OR.img_Lists_Page_DoNotMiss);
			this.scrollBy(0, -60);
			boolean checkDoNotMiss=elementPresent(OR.img_Lists_Page_DoNotMiss);
			if(checkDoNotMiss==true)
			{
				/*int getCount=getElementCount(OR.img_Lists_Page_DoNotMiss);
				testStepPassed("Total Number of Do not miss Ads--"+getCount);*/
				testStepPassed("Do Not Miss Ads is present");
							
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Do not Miss Ads are not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateStatsLists()
	{
		testStepInfo("**************Stats Lists*************");
		try {
			boolean checkStats=elementPresent(OR.txt_Lists_Page_Stats);
			if(checkStats==true)
			{
				testStepPassed("Stats Container Label is present");
			}
			else
			{
				testStepFailed("Stats Container Label is not present");
			}
			
			boolean checkOnForbesLists=elementPresent(OR.txt_Lists_Page_OnForbesLists);
			if(checkOnForbesLists==true)
			{
				testStepPassed("On Forbes Lists Container Label is present");
			}
			else
			{
				testStepFailed("On Forbes Lists Container Label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		
	}
	
	public void validateDidyouKnow()
	{
		testStepInfo("**************Did You Know...*************");
		try {
			boolean checkDidYouKnow=elementPresent(OR.txt_Lists_DidYouknow);
			if(checkDidYouKnow==true)
			{
				testStepPassed("Did You Know section is present");
				int getCount=getElementCount(OR.txt_Lists_DidYouknow);
				testStepPassed("Did You know Carousel cards are-"+getCount);
				for (int i =1; i <=getCount; i++) {
					boolean checkCarouselCards=elementPresent("Carousel cards#xpath=//div[@class='did-you-know-slider']//ul[@class='slides']//li["+i+"]//div[@class='centered-div']");
					if(checkCarouselCards==true)
					{
						String getCardDetails=getText("Carousel cards#xpath=//div[@class='did-you-know-slider']//ul[@class='slides']//li["+i+"]//div[@class='centered-div']");
						testStepPassed("Carousel Card Information--"+getCardDetails);
					}
					else
					{
						testStepFailed("Carousel Card Information is not present"+i);
					}
					
				}
				
			}
			else
			{
				testStepInfo("Did You Know section is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	public void validateNetWorth(String rtDate,String amount, String name)
	{
		testStepInfo("************** Net Worth -"+name+"*************");
		try {
			boolean checkNetWorthDate=elementPresent(rtDate);
			if(checkNetWorthDate==true)
			{
				String getProfileNetWorth=getText(rtDate);
				
				testStepPassed( name+"Net Worth Date on Profile---"+getProfileNetWorth);
				
			}
			else
			{
				testStepFailed(name+"Net Worth date is not present in the profile page");
			}
			
			
			boolean checkAmount=elementPresent(amount);
			if(checkAmount==true)
			{
				String getProfileAmount=getText(amount);
				
				testStepPassed( name+"Amount on Profile---"+getProfileAmount);
				
			}
			else
			{
				testStepFailed(name+"Amount is not present in the profile page");
			}
			
			/*boolean checkAmountIcon=elementPresent(icon);
			if(checkAmountIcon==true)
			{
				
				
				testStepPassed( name+"Amount Icon is present on Profile");
				
			}
			else
			{
				testStepFailed(name+"Amount Icon is not present in the profile page");
			}*/
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	
	
	public void validateConnection()
	{
		testStepInfo("**************************Connection***************************");
		try {
			boolean checkConnection=elementPresent(OR.img_Lists_Page_Connection_Image);
			if(checkConnection==true)
			{
				int getCount=getElementCount(OR.img_Lists_Page_Connection_Image);
				
				testStepPassed("Total number of Connections ---"+getCount);
				if(getCount>5)
				{
					boolean checkNextArrow=elementPresent(OR.btn_Mob_Video_Page_Next);
					if(checkNextArrow==true)
					{
						this.scrollToElement(OR.btn_Mob_Video_Page_Next);
						this.scrollBy(0,-60);
						clickOn(OR.btn_Mob_Video_Page_Next);
						boolean checkNextConnection=elementPresent(OR.img_Lists_Page_Connection_NextImage);
						if(checkNextConnection==true)
						{
							testStepPassed("Connection is present after clicking on the next arrow button ");
						}
						else
						{
							testStepFailed("Connection is not present after clicking on the next arrow button ");
						}
					}
					else
					{
						testStepFailed("Next Arrow Button is not present");
					}
				}
				else
				{
					testStepInfo("Connection list is less than or equal to five ");
				}
			}
			else
			{
				testStepFailed("Connection List is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateStickySocialShare()
	{
		try {
			boolean checkStickyShares=elementPresent(OR.icon_Lists_Page_StickySocialShares);
			
			if(checkStickyShares==true)
			{
				 int  countSocialShares=getElementCount(OR.icon_Lists_Page_StickySocialShares);
				 testStepPassed("Total number of social Shares are --"+countSocialShares);
				 if(countSocialShares==6)
				 {
					 testStepPassed("Sticky Social shares are present");
				 }
				 else
				 {
					 testStepFailed("Sticky Social shares are not present");
				 }
			}
			else
			{
				getCurrentPageURL();
				 testStepFailed("Sticky Social shares are not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateTopPromoBlock()
	{
		testStepInfo("******************* Validate Top Promoblock***********************");
		try {
			boolean checkPromoblock=elementPresent(OR.img_Lists_Page_PromoBlock);
			if(checkPromoblock==true)
			{
				testStepPassed("Top Promo block is present");
			}
			else
			{
				testStepFailed("Top Promo block is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validateTitleOfPage()
	{
		testStepInfo("******************* Validate Title***********************");
		try {
			boolean checkTitleOfPage=elementPresent(OR.txt_Lists_Page_Title);
			if(checkTitleOfPage==true)
			{
				testStepPassed("The World's billionaire page is displayed");
			}
			else
			{
				testStepFailed("The World's billionaire page is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	
	public void verifyTopAdsInLists() {
		boolean topAds = elementPresent(OR.ads_Lsits_Page_Topa_Ads);
		if (topAds == true) {

			// manualScreenshot(OR.ads_Lsits_Page_Topa_Ads);
			testStepPassed("Top Ads is present---" + topAds);

		} else {
			testStepFailed("Top Ads is not present");
		}
	}

	
	

	

	/** The actions. */
	Actions actions = new Actions(driver);

	/**
	 * Verify rich lists.
	 */
	public void verifyRichLists() {
		testStepInfo("**************** Rich Lists ***************");

		try {
			WebElement menu = driver.findElement(By.xpath("//div[@class='col--3-1 lists--block lists--rich']"));
			actions.moveToElement(menu).perform();
			waitTime(2);

			driver.findElement(By.linkText("World's Billionaires")).click();

			validateTopAds();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}


	public void validateTopAds()
	{
		
		try {
			boolean topAds=elementPresent(OR.adsHomePageTopAds);
			if(topAds==true)
			{
			//manualScreenshot(OR.adsHomePageTopAds);
				testStepPassed("Top Ads is present");
			}
			else {
				testStepFailed("Top Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}


	/**
	 * Author : Shakira Created on : 27 June 2016
	 */

	/**
	 * Verifying Social Share are displayed
	 */

	public void verifySocialShareInMobile() {
		testStepInfo("************** Social Share  ***************");
		try {
			boolean share = elementPresent(OR.img_Mob_Lists_Page_Share);
			if (share == true) {

				testStepPassed("Social Share are displayed");
			} else {
				testStepFailed("Social Share are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify Worlds Billionaires are present
	 */
	public void verifyRichListsInMobile() {
		testStepInfo("************** Rich Lists  ******************");
		try {
			waitTime(2);
			boolean billionaires = elementPresent(OR.img_Mob_Lists_Page_Profile);
			if (billionaires == true) {
				clickOn(OR.img_Mob_Lists_Page_Profile);
				String profileName = getText(OR.txt_Mob_Lists_Page_Profile_Body);
				testStepPassed("Worlds Billionaire is --" + profileName);
			} else {
				testStepFailed("Worlds Billionaires is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify worlds Billionaires Profile by getting details and by names
	 */
	public void verifyProfileInMobile() {
		testStepInfo("******************************** Profile **********************************");
		try {
			scrollBy(0, 150);
			boolean profileDetails = elementPresent(OR.txt_Mob_Lists_Page_Profile_Details);
			if (profileDetails == true) {

				String profile = getText(OR.txt_Mob_Lists_Page_Profile_Details);
				testStepPassed(profile);
			} else {
				testStepFailed("Profile Details not displayed");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * verify View complete lists is displayed
	 */

	public void verifyViewCompleteLists() {
		testStepInfo("************** View complete List ***************");
		try {
			waitTime(3);
			boolean completeList = elementPresent(OR.btn_Mob_Lists_Page_View_Complete_List);
			if (completeList == true) {
				clickOn(OR.btn_Mob_Lists_Page_View_Complete_List);

				scrollBy(0, 100);
				String profileName = getText(OR.txt_Mob_Lists_Page_Profile_Name);
				testStepPassed("Worlds Billionaires is ---" + profileName);
			} else {
				testStepFailed("Worlds Billionaires is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * verify Next and Previous Navigations
	 */

	public void verifyNextPrevoiusNavigationInMobile() {
		testStepInfo(
				"**************** Next and Previous Navigations ***********");

		try {
			waitTime(3);
			boolean nextNav = elementPresent(OR.btn_Mob_Lists_Page_Next);
			if (nextNav == true) {

				clickOn(OR.btn_Mob_Lists_Page_Next);
				testStepPassed("Next Navigation is working");
			} else {
				testStepFailed("Next Navigation is not working");
			}
			boolean previousNav = elementPresent(OR.btn_Mob_Lists_Page_Previous);
			if (previousNav == true) {

				clickOn(OR.btn_Mob_Lists_Page_Previous);
				testStepPassed("Previous Navigation is working");
			} else {
				testStepFailed("Previous Navigation is not working");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

}
