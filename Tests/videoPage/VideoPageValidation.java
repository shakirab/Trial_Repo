/**
 * Check the page with ads
 * Check for the video played default.
 * Pause the video
 * Check all the social web icons
 * Check Recommended label with the video stream horizontal.
 * Check next and previous icons
 * Click on the previous and next buttons to check the videos
 * Click on any video from recommended section
 * Check for the featured section
 * Check Most popular section
 * Check Search Forbes Video with search tab and icon
 * Check for the latest videos label

 */

package videoPage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;
import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoPageValidation. class names are written in mixed case with the
 * first letter of each internal word capitalized
 */
public class VideoPageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Video Page Validation
	// Created by :Shakira
	// Created on :14 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new video page validation.
	 *
	 * @param obj
	 *            the obj
	 */
	public VideoPageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates a new video page validation.
	 */
	public VideoPageValidation() {

	}

	/**
	 * Verify video page. 
	 */
	public void verifyVideoPage() {
		
		if (currentExecutionMachineName.equalsIgnoreCase("Search_Video")) {
			testStepInfo("**************** Video Page *************************");
			validatePageLoadTime("http://www.forbes.com/video", 10,"Video Page");

			validateTopVideo();
			validateTopAds(OR.adsHomePageTopAds);
			validateTopxAds(OR.adsHomePageTopxAds);
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
			validateSocialnetworks(OR.img_Reg_Most_Popular_SocialNetwork);
			verifyRecommended();
			
			validateFeaturedVideoBlock();
			validateFeaturedVideoFourFeatures();
			validateMostPopularVideos();
			
			scrollBy(0, 2000);
			validateLatestVideos();
			
			validateSearch(OR.txt_Reg_Videos_Search);
			validateFeaturedPlaylist();
			validatePlayListsPage();
			validateTopAds(OR.adsHomePageTopAds);
			validateBottomAds(OR.ads_Reg_Lists_Page_BottomAds);
		} 
		
		else if (currentExecutionMachineName.equalsIgnoreCase("AndroidMobile"))
		{
			testStepInfo("**************** Video Page For Mobile*************************");
			validatePageLoadTime("http://www.forbes.com/video", 16,"Video Page");
			verifyVideoOnHomePage();
			verifyRecommendedInMobile();
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
			scrollBy(0, 100);
			scrollBy(0, -100);
			validateFeaturedInMobile();
			validateMostPopularVideos();
			
			scrollBy(0, 2000);
			validateLatestVideos();
			
			
			
			verifyRelatedTopicsInMob();
			verifyMostReadOnForbesInMobile();
			validateFooterFeedback();
			
			validateSearch(OR.txt_Reg_Videos_Search);
			validateFeaturedPlaylist();
			validatePlayListsPage();
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);

		}
		else 
		{
			testStepInfo("**************** Video Page For Mobile*************************");
			validatePageLoadTime("http://www.forbes.com/video", 16,"Video Page");
			verifyVideoOnHomePage();
			verifyRecommendedInMobile();
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
			scrollBy(0, 100);
			scrollBy(0, -100);
			validateFeaturedInMobile();
			verifyRelatedTopicsInMob();
			verifyMostReadOnForbesInMobile();

		}
	}
	
	
	public void validateLatestVideos()
	{
		testStepInfo("***************Latest Videos****************");
		
		try {
			scrollBy(0, 1500);
			boolean mostPopularImg=elementPresent(OR.txt_Reg_Videos_Latest_Videos_Image);
			boolean mostPopularText=elementPresent(OR.txt_Reg_Videos_Latest_Videos_Title);
			if(mostPopularImg==true && mostPopularText==true)
			{
				int countMostPopular=getElementCount(OR.txt_Reg_Videos_Latest_Videos_Title);
				testStepPassed("Total Number of Latest Videos "+countMostPopular);
				if(countMostPopular>=5)
				{
					verifyLoadMoreInDesktop(OR.btn_Reg_Videos_Latest_Videos_LoadMore,"Load More#xpath=//section[@class='latest_video col-sm-8 stream row load_more_container']//ul//li[6]//h4//a");
				}
				else if(countMostPopular<=5)
				{
					testStepPassed("Load More button is not present");
				}
				
			}
			else
			{
				testStepFailed("Latest Videos are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateMostPopularVideos()
	{
		testStepInfo("***************Most Popular Videos****************");
		try {
			scrollBy(0, 1500);
			this.scrollToElement(OR.img_Video_Most_PopularVideos);
			this.scrollBy(0, -60);
			boolean mostPopularImg=elementPresent(OR.img_Video_Most_PopularVideos);
			boolean mostPopularText=elementPresent(OR.txt_Video_Most_PopularVideos);
			if(mostPopularImg==true && mostPopularText==true)
			{
				int countMostPopular=getElementCount(OR.txt_Video_Most_PopularVideos);
				testStepPassed("Total Number of Most popular Videos "+countMostPopular);
				if(countMostPopular>=6)
				{
					verifyLoadMoreInDesktop(OR.btn_Video_Most_Popular_Video_LoadMore,"Load More#xpath=//div[@class='popular_videos row']//ul//li[7]//h4//a");
				}
				else if(countMostPopular<=6)
				{
					testStepPassed("Load More button is not present");
				}
				
			//	openVideoLinkInWindow(videoText);
			}
			else
			{
				testStepFailed("Most Popular Videos are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
public void openVideoPlayListsLinkInWindow(String strPropertykey) {
		
		try{
			String featuredVideoLink = getText(strPropertykey);
			testStepPassed("Featured PlayLists Link is -"+featuredVideoLink);
			if (this.driver.findElements(By.xpath((String) this.locator)) != null) {
				this.waitForElement(strPropertykey);
				WebElement link = this.driver.findElement(By.xpath((String) this.locator));
				Actions newTab = new Actions(driver);
				newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
				waitTime(5);
				testStepPassed("Openend the article in a new tab");
				//handle windows change
				String base = driver.getWindowHandle();
				Set<String> set = driver.getWindowHandles();
				 
				set.remove(base);
				assert set.size() == 1;
				driver.switchTo().window((String) set.toArray()[0]);
				
				/*String podcastsTitle = getText(strPropertykey);
				testStepPassed("Carousel Link is -"+podcastsTitle);*/
				String title=driver.getTitle();
				testStepPassed("Title of the page "+title);
				if(featuredVideoLink.equalsIgnoreCase(title) || !title.equals("404"))
				{
					testStepPassed("Navigated to correct Forbes PlayLists Page");
					validateTopVideo();
					validateTopAds(OR.adsHomePageTopAds);
					validateRecAds(OR.adsHomePageRecAds);
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Error: redirecting to 404 Page");
				}
			
				
				//close the window
				driver.close();
				driver.switchTo().window(base);
				testStepInfo("Closed the tab");
				// handle windows change and switch back to the main window
				Thread.sleep(2500);
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
						}
			}
		else {
			getCurrentPageURL();
			testStepFailed("No web element found");
			}
		}catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
			}
		
		}

	public void validatePlayListsPage()
	{
		testStepInfo("**********************PlayLists Page*********************");
		try {
			this.scrollToElement(OR.txt_Reg_Videos_SeeAll);
			this.scrollBy(0,-60);
			boolean seeAll=elementPresent(OR.txt_Reg_Videos_SeeAll);
			if(seeAll==true)
			{
				this.scrollToElement(OR.txt_Reg_Videos_SeeAll);
				this.scrollBy(0,-60);
				clickOn(OR.txt_Reg_Videos_SeeAll);
				boolean playLists=elementPresent(OR.txt_Reg_Video_Forbes_PlayLists);
				if(playLists==true)
				{
					int countPlayLists=getElementCount(OR.txt_Reg_Video_Forbes_PlayLists);
					testStepPassed("Total Number of Forbes PlayLists--->"+countPlayLists);
					if(countPlayLists==25)
					{
					for (int i = 1; i <=countPlayLists; i++) {
						
						String getPlaylist=getText("Forbes Playlists#xpath=//div[@class='columns clearfix']//li["+i+"]//a");
						testStepPassed("Play list --"+i+"-"+getPlaylist);
					}
					
					scrollBy(0,1500);
					validateLatestVideos();
					}
					else
					{
						testStepFailed("Play list is missing ");
					}
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Forbes PlayLists lists are not Displayed");
					
				}
				
			}
			else
			{
				testStepFailed("See All PlayLists Link is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateFeaturedPlaylist()
	{
		try {
			testStepInfo("************ Featured PlayLists *****************");
			this.scrollToElement(OR.txt_Reg_Videos_Featured_Playlists);
			this.scrollBy(0, -60);
			boolean featuredPlayLists=elementPresent(OR.txt_Reg_Videos_Featured_Playlists);
			if(featuredPlayLists==true)
			{
				int countFeaturedPlayLists=getElementCount(OR.txt_Reg_Videos_Featured_Playlists);
				testStepPassed("Total Number of Featured Playlists are ----> "+countFeaturedPlayLists);
				for (int i = 1; i <=countFeaturedPlayLists; i++) 
				{
				
				boolean checkFeaturedPlaylist=elementPresent("Featured PlayLists#xpath=//section[@class='featured_playlists rule' or @class='featured_playlists']//li["+i+"]//a");
				if(checkFeaturedPlaylist==true)
				{
					String getFeaturedPlaylist=getText("Featured PlayLists#xpath=//section[@class='featured_playlists rule' or @class='featured_playlists']//li["+i+"]//a");
					testStepPassed("Featured Playlist-"+getFeaturedPlaylist);
				}
				else
				{
					testStepFailed("Featured Playlist is not present");
				}
					//openVideoPlayListsLinkInWindow("Featured PlayLists#xpath=//section[@class='featured_playlists rule']//li["+i+"]//a");
				}
				
			}
			else
			{
				testStepFailed("Featured Playlist is not present");
			}
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validateSearch(String search)
	{
		testStepInfo("************* Search *****************");
		try {
			boolean searchBox=elementPresent(OR.txt_Reg_Videos_Search);
			if(searchBox==true)
			{
			
				testStepPassed("Search Input is Displayed");
			}
			else
			{
				testStepFailed("Search Input is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
/*	public void validateMostPopularVideos()
	{
		testStepInfo("************************************** Most Popular Videos *******************************************");
		try {
			scrollBy(0, 1500);
			boolean mostPopularImg=elementPresent(OR.img_Video_Most_PopularVideos);
			boolean mostPopularText=elementPresent(OR.txt_Video_Most_PopularVideos);
			if(mostPopularImg==true && mostPopularText==true)
			{
				int countMostPopular=getElementCount(OR.txt_Video_Most_PopularVideos);
				testStepPassed("Total Most popular Videos "+countMostPopular);
				
				openVideoLinkInWindow(OR.txt_Video_Most_PopularVideos);
			}
			else
			{
				testStepFailed("Most Popular Videos are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}*/
	
	public void validateVideos(String videoImage, String videoText,String sectionName)
	{
		testStepInfo("***************** "+sectionName +"***************");
		try {
			scrollBy(0, 1500);
			boolean mostPopularImg=elementPresent(videoImage);
			boolean mostPopularText=elementPresent(videoText);
			if(mostPopularImg==true && mostPopularText==true)
			{
				int countMostPopular=getElementCount(videoText);
				testStepPassed("Total "+sectionName+" Videos "+countMostPopular);
				
			//	openVideoLinkInWindow(videoText);
			}
			else
			{
				testStepFailed("sectionName"+" are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validateFeaturedVideoFourFeatures()
	{
		try {
			boolean checkNamefourFeatures=elementPresent(OR.txt_Video_Page_VideoFourFeatures);
			boolean checkImageFourFeatures=elementPresent(OR.img_Video_Page_Feature_Videos);
			if(checkNamefourFeatures==true && checkImageFourFeatures==true)
			{
				int countVideoFeatures=getElementCount(OR.txt_Video_Page_VideoFourFeatures);
				int countVideoImages=getElementCount(OR.img_Video_Page_Feature_Videos);
				testStepPassed("Total Features Video "+countVideoFeatures);
				if(countVideoFeatures==4 && countVideoImages==4)
				{
					
						
							testStepPassed("Four Feature Video Grid block is present");
						
				}
			
				else
				{
					testStepFailed("Four Feature Videos are not present");
				}
				
			
			}
			else
			{
				testStepFailed("Featured video block is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateFeaturedVideoBlock()
	{
		testStepInfo("************ FEATURED **************");
		try {
			scrollBy(0, 1000);
			boolean videoPromoBlockImage=elementPresent(OR.img_Video_Page_VideoPromoblock);
			boolean videoPromoBlockText=elementPresent(OR.txt_Video_Page_VideoPromoText);
			boolean checkVideoBlockDescription=elementPresent(OR.txt_Video_Page_VideoPromo_Description);
			if(videoPromoBlockImage==true &&videoPromoBlockText==true &&checkVideoBlockDescription==true)
			{
				this.scrollToElement(OR.txt_Video_Page_VideoPromoText);
				this.scrollBy(0, -60);
				String getFeaturedVideoTitle=getText(OR.txt_Video_Page_VideoPromoText);
				testStepPassed("Featured Video Title is --"+getFeaturedVideoTitle);
				clickOn(OR.txt_Video_Page_VideoPromoText);
				waitTime(4);
				validateSocialnetworks(OR.img_Reg_Most_Popular_SocialNetwork);
				boolean checkVideoBlock=elementPresent(OR.vid_Reg_Home_Page_Video);
				boolean checkVideotitle=elementPresent(OR.txt_Reg_Home_Page_Videos_Title);
				if(checkVideoBlock==true &&checkVideotitle==true)
				{
					String getStandalonePageVideoTitle=getText(OR.txt_Reg_Home_Page_Videos_Title);
					testStepPassed("Standalone Page video is --"+getStandalonePageVideoTitle);
					boolean checkVideoTitle=elementPresent(OR.txt_Video_Page_Standalone_Video);
					boolean checkVideoImage=elementPresent(OR.img_Video_Page_Standalone_Video);
					if(checkVideoTitle==true && checkVideoImage==true)
					{
						String getStandaloneVideoTitle=getText(OR.txt_Video_Page_Standalone_Video);
						if(getStandaloneVideoTitle.equalsIgnoreCase(getStandalonePageVideoTitle))
						{
							testStepPassed("Standalone page side bar video title and video image is matched");
						}
						else
						{
							testStepPassed("Standalone page side bar video title and video image is not matched");
						}
					}
					else
					{
						testStepFailed("Standalone page side bar video title and video image is not displayed");
					}
					testStepPassed("Video is displayed in Standalone page");
					
					validateTopAds(OR.adsHomePageTopAds);
					validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
					validateUpdatedFooterNavigation();
					
				}
				else
				{
					testStepFailed("Video is not displayed in the standalone page");
				}
				//openVideoLinkInWindow(OR.txt_Video_Page_VideoPromoText);
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Featured Video promo is not Displayed With Description");
			}
			clickOnBackButton();
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void openVideoLinkInWindow(String strPropertykey) {
		
		try{
			String featuredVideoLink = getText(strPropertykey);
			testStepPassed("Featured Link is -"+featuredVideoLink);
			if (this.driver.findElements(By.xpath((String) this.locator)) != null) {
				this.waitForElement(strPropertykey);
				WebElement link = this.driver.findElement(By.xpath((String) this.locator));
				Actions newTab = new Actions(driver);
				newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
				waitTime(5);
				testStepPassed("Openend the article in a new tab");
				//handle windows change
				String base = driver.getWindowHandle();
				Set<String> set = driver.getWindowHandles();
				 
				set.remove(base);
				assert set.size() == 1;
				driver.switchTo().window((String) set.toArray()[0]);
				
				/*String podcastsTitle = getText(strPropertykey);
				testStepPassed("Carousel Link is -"+podcastsTitle);*/
				String title=driver.getTitle();
				testStepPassed("Title of the page "+title);
				if(featuredVideoLink.equalsIgnoreCase(title) || !title.equals("404"))
				{
					testStepPassed("Navigated to correct Featured Page");
					validateTopVideo();
				}
				else
				{
					testStepFailed("Error: redirecting to 404 Page");
				}
			
				
				//close the window
				driver.close();
				driver.switchTo().window(base);
				testStepInfo("Closed the tab");
				// handle windows change and switch back to the main window
				Thread.sleep(2500);
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
						}
			}
		else {
			getCurrentPageURL();
			testStepFailed("No web element found");
			}
		}catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
			}
		
		}
	

	public void validateTopVideo()
	{
		try {
			//boolean videoBlock = elementPresent(OR.vidHomePageVideo);
			boolean videoBlock=elementPresent(OR.vid_Home_Page_Autoplayed);
			boolean skipAds=elementPresent(OR.btn_Reg_Videos_Skip_ads);
			if (videoBlock==true) {
				waitTime(5);
			
				testStepPassed("Video Section is displayed");
				boolean checkPlayButton=elementPresent(OR.btn_VideoPage_Play);
				
				if(checkPlayButton==true)
				{
					mouseOver(OR.vid_Home_Page_Autoplayed);
					testStepPassed("Verified the first video in any landing page is autoplayed");
				}
				else
				{
					testStepFailed("Video is not autoplayed");
				}
				/*if(skipAds==true)
				{
					clickOn(OR.btn_Reg_Videos_Skip_ads);
					testStepPassed("Clicked on the Skip Ads button");
				}
				else
				{
					testStepInfo("Skip Ads button is not Displayed");
				}*/
				
				
			} else {
				testStepFailed("Video section is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testStepFailed("Video is not displayed");
		}
	}

	/**
	 * Validate featured.
	 */
	public void validateFeaturedInMobile() {
		testStepInfo("*************** Featured *****************");
		try {
			this.scrollToElement(OR.img_Video_Page_VideoPromoblock);
			this.scrollBy(0, -60);
			boolean videoPromoBlockImage=elementPresent(OR.img_Video_Page_VideoPromoblock);
			boolean videoPromoBlockText=elementPresent(OR.txt_Video_Page_VideoPromoText);
			if(videoPromoBlockImage==true && videoPromoBlockText==true)
			{
				testStepPassed("Featured Promo Block is displayed");
				/*clickOn(OR.txt_Video_Page_VideoPromoText);
				validateTopVideo();*/
			}
			else
			{
				testStepFailed("Featured Promo Block is not displayed");
			}
			// clickOn(OR.vidHomePageVideo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}



	/**
	 * Verify recommended.
	 */
	public void verifyRecommended() {
		testStepInfo("*********************************** Recommended **************************************************");
		try {
			scrollBy(0, 1000);
			//waitForElement(OR.img_Video_Page_Recommended_Article);
			boolean recommendedText=elementPresent(OR.img_Video_Page_Recommended_Article);
			boolean recommendedVideo=elementPresent(OR.img_Reg_Video_Recommended);
			if(recommendedText==true && recommendedVideo==true)
			{
				
				//openVideoLinkInWindow(OR.img_Video_Page_Recommended_Article);
				int countRecommended=getElementCount(OR.img_Video_Page_Recommended_Article);
				testStepPassed("Total Number of Recommended -"+countRecommended);
				testStepPassed("Recommended Section is displayed");
				boolean nextButton=elementPresent(OR.btn_Reg_Video_Recommended_NextButton);
				for (int i = 1; i <=3; i++) {
					String getRecommendedVideo=getText("#xpath=//div[@class='flex-viewport']//ul[@class='slides clearfix']//li["+i+"]//a/..//h4//a");
				testStepPassed("Recommended Videos are present--"+getRecommendedVideo);
				}
				
				if (nextButton == true) {
					waitTime(3);
					clickOn(OR.btn_Reg_Video_Recommended_NextButton);
					boolean checkvideo=elementPresent("Next Recommended Video#xpath=//div[@class='flex-viewport']//ul[@class='slides clearfix']//li[4]//a/..//h4//a"); 
					if(checkvideo==true)
					{
					String getRecommendedVideo=getText("Next Recommended Video#xpath=//div[@class='flex-viewport']//ul[@class='slides clearfix']//li[4]//a/..//h4//a");
					testStepPassed("Recommended Videos are present--"+getRecommendedVideo);
					waitTime(3);
					}
					else
					{
						testStepFailed("After clicking on the next button - there is no Recommended Video");
					}
				} else {
					getCurrentPageURL();
					testStepFailed("Next Button is not Enabled");
				}
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Recommended Section is not Displayed");
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify load more in desktop.
	 */
	public void verifyLoadMoreInDesktop(String loadMore,String moreVideos) {
		testStepInfo("***************************** Load More *************************************");
		try {
			scrollBy(0, 1300);
			boolean videoloadMore = elementPresent(loadMore);
			if (videoloadMore == true) {
				this.scrollToElement(loadMore);
				this.scrollBy(0, -60);
				clickOn(loadMore);
				boolean latestVideos=elementPresent(moreVideos);
				if (latestVideos==true) {
					String loadedVideo=getText(moreVideos);
					testStepPassed(""+loadedVideo);
					testStepPassed("Verified Load more button is working and loading videos ");
				} 
				else
				{
					testStepFailed("Its not loaded Videos");
				}
				//testStepPassed("Load More button is displayed");
			} else {
				testStepFailed("Load More button is not displayed");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate recommended.
	 */
	public void validateRecommended() {
		testStepInfo("*********************************** Recommended **************************************************");
		try {
			String varNext;
			String varXpath = null;
			String varRecom = getText(OR.txt_Video_Page_Recommended);
			testStepPassed(varRecom);
			int nextButton = 2;
			for (nextButton = 2; nextButton <= 3; nextButton++) {

				varNext = "Next#xpath=//ol[@class='flex-control-nav flex-control-paging']//li//a[text()="
						+ nextButton + "]";
				clickOn(varNext);
				takeAdScreenshot(varNext, "recom");
				int profile = 1;
				for (profile = 1; profile < 15; profile++) {
					varXpath = "Recommended Profile#xpath=//div[@class='flex-viewport']//ul[@class='slides clearfix']//li["
							+ profile + "]//a/..//h4";
					if (profile >= 1 || profile <= 15) {
						String recom = getText(varXpath);
						testStepPassed("Recommended Article is--" + recom);
					}

				}

			}

			testStepPassed("Verified the Forbes RECOMMENDED articles are displayed in the page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify recommended in mobile.
	 */
	public void verifyRecommendedInMobile() {
		testStepInfo("*********************************** Recommended **************************************************");

		try {
			scrollBy(0, 600);
			boolean recommendedLabel=elementPresent(OR.txt_Video_Page_Recommended);
			if(recommendedLabel==true)
			{
				String varRecom = getText(OR.txt_Video_Page_Recommended);
				testStepPassed(varRecom);
				boolean recommendedSlidesCount=elementPresent(OR.btn_Reg_Mob_Video_Page_RecommendedCount);
				if(recommendedSlidesCount==true)
				{
				String recomcount=getText(OR.btn_Reg_Mob_Video_Page_RecommendedCount);
				String[] splitCount=recomcount.split("of");
				//String firstString=splitCount[0].trim();
				String secondString=splitCount[1].trim();
				int totalCount=Integer.parseInt(secondString);
				testStepPassed("Total Number of Videos --->"+totalCount);
				int Recomcount=getElementCount(OR.img_Video_Page_Recommended_Article);
				testStepPassed("Total Number of Recommended Videos--->"+Recomcount);

				scrollBy(0, 300);
				boolean nextButton = elementPresent(OR.btn_Mob_Video_Page_Next);
				for (int i = 1; i <2; i++) {
				
					
					if (nextButton == true) {
						this.scrollToElement(OR.btn_Mob_Video_Page_Next);
						this.scrollBy(0, -60);
						clickOn(OR.btn_Mob_Video_Page_Next);
						waitTime(4);
						
						testStepPassed("Recommended Swipe is working");
					} else {
						testStepFailed("Recommended Swipe is not working");
					}
				}
				
				}
				else
				{
					testStepFailed("Recommended Count is not displayed");
				}
				
			}
			else
			{
				testStepFailed("Recommended Label is not Displayed");
			}
			
		} catch (Exception e) {
			testStepFailed("Recommended Swipe is working");
		}

	}

}
