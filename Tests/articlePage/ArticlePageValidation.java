/**
 * Validate Author info & image
 * Article Ads
 * Social sharing

 */
package articlePage;


import java.util.ArrayList;
import java.util.List;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * class names are written in mixed case with the first letter of each internal
 * word capitalized.
 */
public class ArticlePageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Article Page Validation
	// Created by :Shakira
	// Created on :9 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new article page validation.
	 *
	 * @param obj
	 *            the obj
	 */
	public ArticlePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	/**
	 * Verify ads in article page. methods are written in mixed case with the
	 */
	public void validateArticlePage() {

		String articleText = null;

		try {

			if (currentExecutionMachineName.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {

				// clickOn(OR.txt_Home_User_Zone_US);
				testStepInfo("***************Article Page**************");
				
				waitTime(5);
				boolean topStory=elementPresent(OR.txt_Home_Page_Top_Stories1);
				if(topStory==true)
				{
					
				int pageViewCounts=openArticleLinksInWindow(OR.txt_Home_Page_Top_Stories1,OR.txt_Article_Page_View_Count);
				driver.manage().deleteAllCookies();
				driver.get("http://www.forbes.com/home_usa/?nowelcome");
				boolean topStories=elementPresent(OR.txt_Home_Page_Top_Stories1);
				if(topStories==true)
				{
					
					waitTime(5);
					String getUrl=getAttributeValue(OR.txt_Home_Page_Top_Stories1, "href");
					testStepPassed("Article Page Url is "+getUrl);
					
					/*String articlePageUrl=getUrl.concat("?view=prod");
					String articlePageUrl1=articlePageUrl.concat("?nowelcome");*/
					//clickOnMainArticle();
					
					validatePageLoadTime(getUrl, 23,"Article Page");
					/*driver.get(articlePageUrl1);
					waitTime(8);
					driver.get(articlePageUrl1);*/
					
					//refreshPage();
					driver.get(getUrl);
					waitTime(5);
					checkViewsDisplayIcon();
					validateAuthorName(OR.txt_Article_Page_Author_Name);
					validateAuthorDetailsForDesktop();
					validateSocialnetworks(OR.img_Reg_Article_Page_Social_Shares);
					//validateLeftStreamArticle(OR.txt_Reg_Article_Page_LeftRailArticle);
					//validateLeftStreamArticle();
					
					int viewCounts=0;
					boolean pageView=elementPresent(OR.txt_Article_Page_View_Count);
					if(pageView==true)
					{
						
						
					String pageViewCount=getText(OR.txt_Article_Page_View_Count);
					String replaceComma=pageViewCount.replace(",", "");
					//testStepPassed(replaceComma);
					  viewCounts=Integer.parseInt(replaceComma);
					
					
					testStepPassed("Second Time View Count is "+viewCounts);
					}
					else
					{
						testStepFailed("Page View Count is not Displayed");
					}
					
					if(viewCounts>pageViewCounts)
					{
						testStepPassed("Page View Count is Increased");
					}
					else
					{
						getCurrentPageURL();
						testStepFailed("Page View Count is not Increased");
					}		
					validateLeftRailSearch();
					validateNativeLeftrailAds();
					validateLeftRailArticleNavigation(
							OR.txt_Reg_Home_Page_HeadLine_Article,
							OR.txt_Reg_Article_Page_LeftRail_Article_Heading);
					validateHashTag(OR.txt_Reg_Article_Page_HashTag);
					validateAdOnLeftRail();
					validateFeaturedImage(OR.img_Reg_Article_Page_Featured_Image);;
					validateTopImage();
				//	validatePhotoCredit();
				//	validateCaption();
					validateFullBio();
					boolean closeButton=elementPresent(OR.btn_Reg_Article_Page_Close);
					if(closeButton==true)
					{
					// clickOn(OR.btn_Reg_Article_Page_Close);
					clickOn(OR.btn_Reg_Article_Page_Close);
					}
					else
					{
						testStepFailed("Close button is not present");
					}
					
					validateGallery(OR.txt_Reg_Article_Page_Gallery,OR.txt_Reg_Article_Page_Gallery_Name);
					validateMidOfArticleVideo();
					validateTopAds(OR.ads_Article_Page_Top_Ads);
					verifyAdsInArticle();
					
				//	validateRecommended();
					validatePrintBar();

					validateComments();
					validateSeeAlso();
					validateRevContent(OR.txt_Article_Page_RevContent_Desk);
					validateFromTheWeb();
					//validateLoadMoreNextArticle();
					validateArticleByScroll();
				}
				else
				{
					testStepFailed("Promo block Article is not displayed");
				}
				}
				else
				{
					testStepFailed("Promo block Article is not displayed");
				}
			 
			}
			else if (currentExecutionMachineName.equalsIgnoreCase("AndroidMobile")) 
			{
				testStepInfo("***************Article Page For Mobile**************");
				waitTime(5);
				
				boolean promoSection=elementPresent(OR.txt_Home_Page_Top_Stories1);
				if(promoSection==true)
				{
				String getUrl=getAttributeValue(OR.txt_Home_Page_Top_Stories1, "href");
				testStepPassed("Article Page Url is "+getUrl);
				
				validatePageLoadTime(getUrl, 23, "Article Page");
				//clickOnMainArticle();
				ValidateHashTagInMobile();
				validateSocialShare();
				validateAuthorDetailsForMobile();
				
				//verifyeFullBioInArticlePage();
				validateAuthorName(OR.txt_Article_Page_Author_Name);
				validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
				validateFullBio();
				scrollBy(0, 400);
				this.scrollToElement(OR.btn_Mob_Article_Page_Full_Bio);
				this.scrollBy(0, -60);
				boolean closeButton=elementPresent(OR.btn_Mob_Article_Page_Full_Bio);
				if(closeButton==true)
				{
				// clickOn(OR.btn_Reg_Article_Page_Close);
				clickOn(OR.btn_Mob_Article_Page_Full_Bio);
				}
				else
				{
					testStepFailed("Close button is not present");
				}
				
				//validateCaption();
				verifyAdsInMobileArticle();
				validateRecommendedLabel();
				scrollBy(0, 2000);
				waitTime(3);
				scrollBy(0, 700);
				validateCommentsInMobile();
				validateFluidAds();
				validatePrintBar();
				validateFromWebInMobile();
				validateAdStream();
				validateRelatedTopics(OR.txt_Article_Page_Related_Topics);
				
				
				validateRevContent(OR.txt_Article_Page_RevContent);
				//validateRevContentInMobile();
				this.scrollToElement(OR.txt_Article_Page_Next_Article);
				this.scrollBy(0, -60);
				articleText = getText(OR.txt_Article_Page_Next_Article);
				clickOn(OR.txt_Article_Page_Next_Article);
				testStepPassed("Article Text: "
						+ getText(OR.txt_Article_Page_Article_Header));
				verifyPageShouldContainText(articleText);
				}
				else
				{
					testStepFailed("Promo Section is not Displayed");
				}
				
				
			}
			else
			{
				testStepInfo("***************Article Page For Mobile**************");
				waitTime(5);
				waitForText("Top Stories");
				
				boolean promoSection=elementPresent(OR.txt_Mob_Home_Page_Top_Stories);
				if(promoSection==true)
				{
				String getUrl=getAttributeValue(OR.txt_Mob_Home_Page_Top_Stories, "href");
				testStepPassed("Article Page Url is "+getUrl);
				
				validatePageLoadTime(getUrl, 23, "Article Page");
				
				//clickOnMainArticle();
				ValidateHashTagInMobile();
				validateSocialShare();
				
				validateAuthorDetailsForMobile();
				//verifyeFullBioInArticlePage();
				validateAuthorName(OR.txt_Mob_Article_Page_Author_Name);
				validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
				validateFullBio();
				scrollBy(0, 400);
				
				boolean closeButton=elementPresent(OR.btn_Mob_Article_Page_Full_Bio);
				if(closeButton==true)
				{
				// clickOn(OR.btn_Reg_Article_Page_Close);
				clickOn(OR.btn_Mob_Article_Page_Full_Bio);
				}
				else
				{
					testStepFailed("Close button is not present");
				}
				//clickOn(OR.btn_Mob_Article_Page_Full_Bio);
				verifyAdsInMobileArticle();
				validateRecommendedLabel();
				scrollBy(0, 2000);
				waitTime(3);
				scrollBy(0, 700);
				validateCommentsInMobile();
				validatePrintBar();
				validateFromWebInMobile();
				validateAdStream();
				validateRelatedTopics(OR.txt_Article_Page_Related_Topics);
				
				
				validateRevContent(OR.txt_Article_Page_RevContent);
				//validateRevContentInMobile();
				//validateNextArticleInMobile();
				/*this.scrollToElement(OR.txt_Article_Page_Next_Article);
				this.scrollBy(0, -60);
				articleText = getText(OR.txt_Article_Page_Next_Article);
				clickOn(OR.txt_Article_Page_Next_Article);
				testStepPassed("Article Text: "
						+ getText(OR.txt_Article_Page_Article_Header));
				verifyPageShouldContainText(articleText);*/
				}
				else
				{
					testStepFailed("Promo Section is not Displayed");
				}
				
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	
	public void validateFluidAds()
	{
		testStepInfo("***************Fluid ad*****************");
		waitTime(5);
		boolean checkFluidAds=elementPresent(OR.ad_Article_Page_FluidAds);
		if(checkFluidAds==true)
		{
			testStepPassed("Fluid ad is present in the article page");
			boolean checkCloseButton=elementPresent(OR.ad_Article_Page_CloseButton);
			if(checkCloseButton==true)
			{
				takeAdScreenshot(OR.ad_Article_Page_FluidAds, "Fluid Ad");
				clickOn(OR.ad_Article_Page_CloseButton);
				testStepPassed("Article Page:Fluid ad is closed");
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Fluid ads close button is not present");
			}
		}
		else
		{
			testStepFailed("Fluid ad is not present");
		}
	}
	
	public void validatePhotoCredit()
	{
		testStepInfo("*******************Photo Credit********************");
		try {
			boolean checkPhotoCredit=elementPresent(OR.txt_ArticlePage_PhotoCredit);
			if(checkPhotoCredit==true)
			{
				String getPhotoCredit=getText(OR.txt_ArticlePage_PhotoCredit);
				testStepPassed("Image credit is present--"+getPhotoCredit);
				
			}
			else
			{
				testStepInfo("Image credit is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	public void validateLeftRailSearch()
	{
		testStepInfo("***********************Left rail Search************************");
		try {
			boolean checkSearchIcon=elementPresent(OR.icon_Article_Page_Search);
			if(checkSearchIcon==true)
			{
				testStepPassed("Search Icon is present");
				clickOn(OR.icon_Article_Page_Search);
				boolean checkSearchField=elementPresent(OR.txt_Home_Page_Search);
				if(checkSearchField==true)
				{
					typeIn(OR.txt_Home_Page_Search, "Bill");
					waitTime(5);
					boolean checkSearchElement=elementPresent("Result#xpath=//ul[@class='results scroll']//li");
					if(checkSearchElement==true)
					{
						int countSearchElements=getElementCount("Result#xpath=//ul[@class='results scroll']//li");
						for (int i = 1; i <=countSearchElements; i++) {
							String getSearchElement=getText("Result#xpath=//ul[@class='results scroll']//li["+i+"]");
							testStepPassed("Search is automatically engaged when user enter query-"+getSearchElement);
						}
						boolean checkclose=elementPresent(OR.icon_Article_Page_Search_Close);
						if(checkclose==true)
						{
							testStepPassed("Close icon is present in leftrail");
							clickOn(OR.icon_Article_Page_Search_Close);
						}
						else
						{
							testStepFailed("Close icon is not present");
						}
						
					}
					else
					{
						testStepFailed("Search Element is not displayed");
					}
					
				}
				else
				{
					testStepFailed("Search Field is not present");
				}
			}
			else
			{
				testStepFailed("Search Icon is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		
	}
	
	public void validateCaption()
	{
		testStepInfo("**********************Validate Image Caption************************");
		boolean checkImage=elementPresent(OR.img_Article_Page_CaptionImages);
		if(checkImage==true)
		{
			int getCountImage=getElementCount(OR.img_Article_Page_CaptionImages);
			
			testStepPassed("Article Page:Total Number of Images present--"+getCountImage);
			int getCountCaption=getElementCount(OR.img_Article_Page_CaptionLabel);
			testStepPassed("Total Number of Image Caption--- "+getCountCaption);
			int getCountExpand=getElementCount(OR.img_Article_Page_CaptionExpand);
			
			testStepPassed("Total Number of Image Caption Expand---"+getCountExpand);
			for (int i = 1; i <=getCountImage; i++) {
				
			boolean checkCaption=elementPresent("Image Caption#xpath=//div[@class='article-rail']//div[@class='wp-caption alignnone']["+i+"]//p");
			
			if(checkCaption==true)
			{
				String getCaptionLabel=getText("Image Caption#xpath=//div[@class='article-rail']//div[@class='wp-caption alignnone']["+i+"]//p");
				testStepPassed("Image caption is present "+i+"---"+getCaptionLabel);
				boolean checkCaptionExpand=elementPresent("Caption Expand#xpath=//div[@class='article-rail']//div[@class='wp-caption alignnone']["+i+"]//span[@class='article-expand-caption']");
				if(checkCaptionExpand==true)
				{
					/*this.scrollToElement("Caption Expand#xpath=//div[@class='article-rail']//div[@class='wp-caption alignnone']["+i+"]//span[@class='article-expand-caption']");
					this.scrollBy(0,-60);
					clickOn("Caption Expand#xpath=//div[@class='article-rail']//div[@class='wp-caption alignnone']["+i+"]//span[@class='article-expand-caption']");
				*/
					testStepPassed("Article Page:Image expand caption is present--"+i);
				
				}
				else
				{
					testStepFailed("Image expand caption is not present "+i);
				}
			}
			else
			{
				testStepFailed("Image caption label is not present-"+i);
			}
			}
			

		}
		else
		{
			testStepFailed("Image is not present");
		}
	}
	public void validateNativeLeftrailAds()
	{
		try {
			boolean check2ndLeftrailAd=elementPresent(OR.txt_Article_Page_Leftrail_2ndNtvAds);
			
			
			if(check2ndLeftrailAd==true)
			{
				String get2ndntvAd=getText(OR.txt_Article_Page_Leftrail_2ndNtvAds);
				if(get2ndntvAd.contains("Voice:"))
				{
				testStepPassed("Leftrail Native ad is present in 2nd position--->"+get2ndntvAd);
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Leftrail native ad is not present in 2nd position"+get2ndntvAd);
				}
			}
			else
			{
				testStepFailed("Leftrail native ad is not present in 2nd position");
			}
			
			/*boolean check6thLeftrailAd=elementPresent(OR.txt_Article_Page_Leftrail_6thNtvAds);
			if(check6thLeftrailAd==true)
			{
				String get6thntvAd=getText(OR.txt_Article_Page_Leftrail_6thNtvAds);
				if(get6thntvAd.contains("Voice:"))
				{
					testStepPassed("Leftrail Native ad is present in 6th position--->"+get6thntvAd);
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Leftrail Native ad is not present in 6th position"+get6thntvAd);	
				}
				
			}
			else{
				testStepFailed("Leftrail Native ad is not present in 6th position");	
			}*/
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	

	public void validateNextArticleInMobile()

	{
		
		try {
			String articleText = null;
			boolean checkNextArticle=elementPresent(OR.txt_Article_Page_Next_Article);
			if(checkNextArticle==true)
			{
				this.scrollToElement(OR.txt_Article_Page_Next_Article);
				this.scrollBy(0, -60);
				articleText = getText(OR.txt_Article_Page_Next_Article);
				waitTime(4);
				clickOn(OR.txt_Article_Page_Next_Article);
				testStepPassed("Article Text: "
						+ getText(OR.txt_Article_Page_Article_Header));
				verifyPageShouldContainText(articleText);
			}
			else
			{
				testStepFailed("Next Article is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateLeftStreamArticle()
	{
		testStepInfo("*************** Left Rail Stream Article ********************");
		try {
			//int count=getElementCount(OR.txt_Reg_Article_Page_LeftRailArticle);
			
			List<WebElement> allArticle=driver.findElements(By.cssSelector("li .headline.ng-isolate-scope .ng-binding.ng-scope"));
			int sizeArticles=allArticle.size();
			
			testStepPassed("Total Number of Left Rail Article-----"+sizeArticles);
			for (int i = 1; i <=sizeArticles; i++) {
				String getArticle=allArticle.get(i).getText();
				testStepPassed("Leftrail Article---"+getArticle);
				/*String getLeftRailArticles=getText("LeftRail Articles#cssselector=li:nth-of-type("+i+") .headline.ng-isolate-scope .ng-binding.ng-scope");
				testStepPassed("Leftrail article --- "+i+"-"+getLeftRailArticles);*/
				scrollBy(0, 80);
			}
			
			/*int count=getElementCount(OR.txt_Reg_Article_Page_LeftRailArticle);
			testStepPassed("Total----"+count);
			for (int i = 1; i <=count; i++) {
				String getLeftRailArticles=getText("LeftRail Articles#cssselector=li:nth-of-type("+i+") .headline.ng-isolate-scope .ng-binding.ng-scope");
				testStepPassed("Leftrail article --- "+i+"-"+getLeftRailArticles);	
			}*/
			/*if(sizeArticles>=10)
			{
				testStepPassed("Left Rail Article Stream is Present");
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Left Rail Article Stream is not Present");
			}*/
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	


	
	/**
	 * Validate from the web.
	 */
	public void validateFromTheWeb() {
		testStepInfo("*************** Article Speed Bump Wrapper **************");
		try {
			boolean fromTheWeb = elementPresent(OR.txt_Reg_Article_Page_From_Web);
			if (fromTheWeb == true) {
				int countSpeedBump = getElementCount(OR.txt_Reg_Article_Page_From_Web);
				for (int i = 1; i <= countSpeedBump; i++) {
					String speedBump = "Speed Bump#xpath=//article[@id='article-container-0']//div[@id='rc-row-container']//div[@class='rc-item']["
							+ i + "]//div[@class='rc-content']";
					String getSpeedBump = getText(speedBump);
					testStepPassed(getSpeedBump);
				}
				testStepPassed("Article Speed Bump Wrapper is Displayed -"
						+ countSpeedBump);
			} else {
				getCurrentPageURL();
				testStepFailed("Article Speed Bump Wrapper is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}


/*
	

	*//**
	 * Validate full bio filter.
	 *//*
	public void validateFullBioFilter() {
		testStepInfo("******************************* Full Bio Filter****************************************");
		boolean fullBioFilter = elementPresent(OR.tab_Reg_Article_Page_FullBio_Filter);
		if (fullBioFilter == true) {
			int count = getElementCount(OR.tab_Reg_Article_Page_FullBio_Filter);
			for (int i = 1; i <= count; i++) {
				String getFullBioTab = "Full Bio Filter#xpath=//div[@class='masked-content']//nav//li["
						+ i + "]";
				if (i == 2) {
					clickOn(getFullBioTab);
					int countRecent = getElementCount(OR.txt_Reg_Article_Page_Recent_Posts);
					for (int j = 1; j <= countRecent; j++) {
						String recentPosts = "Recent Posts#xpath=//ul[@id='authorMostRecent']//li["
								+ j + "]//a";
						String getRecent = getText(recentPosts);
						testStepPassed(getRecent);
					}

				} else if (i == 3) {
					clickOn(getFullBioTab);
					int countRecent = getElementCount(OR.txt_Reg_Article_Page_Popular_Posts);
					for (int j = 1; j <= countRecent; j++) {
						String popularPosts = "Popular Posts#xpath=//ul[@id='authorMostPopular']//li["
								+ j + "]//a";
						String getPopular = getText(popularPosts);
						testStepPassed(getPopular);
					}
					String getPopularPost = getText(getFullBioTab);
					testStepPassed(getPopularPost);
				}

			}
		}
	}


	*//**
	 * Verify ads in desktop article.
	 *//*
	public void verifyAdsInDesktopArticle() {
		int topAdArticleNo = 0;
		int adRailArticleNo = 0;
		for (int i = 0; i <= 15; i++) {

			if (driver.getPageSource().contains(
					"top-ad-article-" + topAdArticleNo)
					|| driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
				if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)
						&& driver.getPageSource().contains(
								"ad-rail-article-" + adRailArticleNo)) {
					testStepPassed("Top Ad");
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1) + ","
									+ "SideAds" + (adRailArticleNo + 1));
					if (driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
						int railAdCount = driver
								.findElements(
										By.xpath("//*[@id='ad-rail-article-"
												+ adRailArticleNo
												+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
								.size();
						testStepPassed("Rail Ad Count: " + railAdCount);
						for (int j = 0; j < railAdCount; j++) {
							takeAdScreenshot(
									driver.findElements(
											By.xpath("//*[@id='ad-rail-article-"
													+ adRailArticleNo
													+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
											.get(j), "SideAds"
											+ (adRailArticleNo + 1));
						}
					}
					topAdArticleNo++;
					adRailArticleNo++;
				} else if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)) {
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1));
					topAdArticleNo++;

				}

			} else {
				((JavascriptExecutor) driver)
						.executeScript("window.scrollBy(0,100)");
			}
		}

	}

	// Start Date : 21 June 2016

	*//**
	 * Verifye full bio in article page.
	 *//*
	public void verifyeFullBioInArticlePage() {
		testStepInfo("************************************************** Full Bio  ****************************************************");
		try {
			boolean fullBio = elementPresent(OR.btn_Mob_Article_Page_Full_Bio);
			if (fullBio == true) {
				clickOn(OR.btn_Mob_Article_Page_Full_Bio);
				String fullBioDetails = getText(OR.txt_Mob_Article_Page_Full_Bio_Details);
				testStepPassed(fullBioDetails);
				scrollBy(0, 250);
				// scrollToElement(OR.btn_Mob_Article_Page_Full_Bio);
				validateFollowOnForbes(OR.txt_Reg_Article_Page_Follow_OnForbes);
				clickOn(OR.btn_Mob_Article_Page_Full_Bio);
			} else {
				testStepFailed("Full Bio is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	*/
	

	
	
	
	
}
