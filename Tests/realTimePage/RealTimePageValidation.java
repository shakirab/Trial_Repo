/**
 * Check all the ads and the page has content
 * Real Time label with the graph
 * Chek all the lins(All, Business, Investing, Tech etc)
 * Check for the stream
 * Check Load more button at the bottom of the page

 */

package realTimePage;



import iSAFE.ApplicationKeywords;

import java.util.List;

import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import baseClass.BaseClass;


public class RealTimePageValidation extends ApplicationKeywords {
	
	/** The obj. */
	BaseClass obj;


	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Podcast Page Validation
	// Created by :Shakira
	// Created on :Oct 2016
	
	// ///////////////////////////////////////////////////////////////////////////////
	
	
	public RealTimePageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	
	public RealTimePageValidation() {

	}

	public void verifyNewPostsPage() {
		
		if (currentExecutionMachineName.equalsIgnoreCase("NP_MP_Gallery"))
		{
			testStepInfo("**********************Real Time Page**********************");
			validatePageLoadTime("https://www.forbes.com/real-time/?nowelcome",21, "New Posts Page");
			verifyNewPostsTitle();
			waitTime(2);
			verifyGraph();
			verifyRealTimeChannelTabs();
			//verifyNewPostedPosts();
		
			verifyRealTimeAds();
			validateLoadMore(OR.txt_New_Posts_Load_More);
		}
		else if(currentExecutionMachineName.equalsIgnoreCase("AndroidMobile"))
		{
			testStepInfo("**********************Real Time Page For Mobile**********************");
			validatePageLoadTime("https://www.forbes.com/real-time/?nowelcome",11, "New Posts Page");
			waitTime(5);
			validateFilterByChannels();
			validateNewPostsHeading();
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
			verifyRecentPostsInNewPosts();
			validateLoadMore(OR.btn_Mob_New_Posts_Load_More);
		}
		else
		{
			testStepInfo("**********************Real Time Page For Mobile**********************");
			validatePageLoadTime("https://www.forbes.com/real-time/?nowelcome",11, "New Posts Page");
			waitTime(5);
			validateFilterByChannels();
			validateNewPostsHeading();
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
			verifyRecentPostsInNewPosts();
			validateLoadMore(OR.btn_Mob_New_Posts_Load_More);
			
			
		}

	}

	

	
	

	public void verifyNewPostsTitle()
	{
		boolean newPosts=elementPresent(OR.txt_Header_Navigation_New_Post);
		if(newPosts==true)
		{
			String varRealPost = getText(OR.txt_Header_Navigation_New_Post);
			testStepPassed("Navigated to this page--" + varRealPost);
			testStepPassed("Navigated to New Posts Page");
		}
		else
		{
			testStepFailed("Failed to navigate to New Posts");
		}
	}
	public void verifyNewPostedPosts()
	{
		testStepInfo("**************Newly Posted Events*******************");
		try {
			scrollBy(0, 100);
			waitForElement(OR.txt_New_Posts_link);
			boolean newPosts=elementPresent(OR.txt_New_Posts_link);
			if (newPosts==true) 
			{
			
				String newPostsLink=getText(OR.txt_New_Posts_link);
				testStepPassed(newPostsLink);
			}
			else
			{
				testStepFailed("Newly Posted Posts are not loaded");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify graph.
	 */
	public void verifyGraph() {
		String varGraph = null;
		testStepInfo("***************** Graph *****************");
		try {
			int graphNo=1;
			for (graphNo = 1; graphNo <= 3; graphNo++) {

				waitTime(3);
				varGraph = "Graph#xpath=//div[@class='visualStats']//dd[" + graphNo
						+ "]//canvas";
				 boolean graph=elementPresent(varGraph);
				testStepPassed("Graph -"+graphNo+"-"+graph);

			}
			
			int labelNo=1;
			for (labelNo= 1; labelNo <= 3; labelNo++) {
				String label = "Label#xpath=//div[@class='visualStats']//dt[" + labelNo
						+ "]";
				String textLabel = getText(label);
				testStepPassed("Graph is present with Labels--" + textLabel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate load more.
	 */
	public void validateLoadMore(String checkLoadMore) {
		testStepInfo("*****************Load More*******************");
		try {
			boolean loadMore = elementPresent(checkLoadMore);
			if (loadMore == true) {
				testStepPassed(" +Load More button is displayed");
			}
			else
			{
				testStepFailed(" +Load More button is not displayed ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	
	}

	/**
	 * Verify real time channel tabs.
	 */
	public void verifyRealTimeChannelTabs() {
		int countImages = 0;
		testStepInfo("***************Real Time Channel Tabs******************");
		try {
			int channelTab=1;
			for (channelTab = 1; channelTab <= 8;channelTab++) {

				String varXpath = "Real time Channel Tabs#xpath=//div[@id='realtimechanneltabs']//ul//li[@data-channel-mapping='channel_"
						+ channelTab + "']";

				clickOn(varXpath);
				waitTime(2);
				String varChannel = getText(varXpath);

				testStepPassed("Real time channel is --" + varChannel);
				boolean image = elementPresent(OR.img_New_Posts_Images);
				if (image == true) {
					countImages = getElementCount(OR.img_New_Posts_Images);
					//manualScreenshot(OR.img_New_Posts_Images);
					testStepPassed("Total images are dispalyed --" + countImages);
					// testStepPassed("Images are Displayed");

				} else {
					testStepFailed("Images are not Displayed");
				}

			}

			clickOn(OR.txt_New_Posts_Channel_Tab10);
			String varChannel = getText(OR.txt_New_Posts_Channel_Tab10);
			testStepPassed("Real time channel is --" + varChannel);

			clickOn(OR.txt_New_Posts_Channel_Tab);
			String varChannel1 = getText(OR.txt_New_Posts_Channel_Tab);
			testStepPassed("Real time channel is --" + varChannel1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	
	/**
	 * Mobile Script
	 * Created On : 21 June
	 */
	public void validateNewPostsHeading()
	{
		try {
			//clickOn(OR.tab_Mob_New_Posts);
			waitTime(5);
			String newPostsHeading=getText(OR.txt_Header_Navigation_New_Post);
			testStepPassed("Redirected to - "+newPostsHeading+" -Page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void verifyRecentPostsInNewPosts()
	{
		
		//clickOn(OR.txt_Mob_New_Posts_Recent);
		try {
			boolean recentPosts=elementPresent(OR.txt_Mob_New_Posts_Recent);
			if (recentPosts==true)
			{
				int countNewPosts=getElementCount(OR.txt_Mob_New_Posts_Recent);
				testStepPassed("Total Number of New Posts--"+countNewPosts);
				for (int i = 1; i <=countNewPosts; i++) {
					String recentPost=getText("Recent Posts#xpath=//li[@class='stream_item edittools-contentitem']["+i+"]//h2//a");
					testStepPassed("New Post is -"+recentPost);
			
				}
					
			}
			else
			{
				testStepFailed("Recent Posts is not displayed");	
				
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		//scrollBy(0, 750);
		//verifyLoadMoreInRealTime();
		
	}
}
