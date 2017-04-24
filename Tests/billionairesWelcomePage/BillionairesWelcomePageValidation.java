
package billionairesWelcomePage;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;



import baseClass.BaseClass;


public class BillionairesWelcomePageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Billionaires Welcome Page Validation
	// Created by :Shakira
	// Created on :27 March 2017

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new lists page validation.
	 *
	 * @param obj
	 *            the obj
	 */
	public BillionairesWelcomePageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}


	public BillionairesWelcomePageValidation() {

	}

	public void verifyBillionairesWelcomePage() {
		
		
		if (currentExecutionMachineName.equalsIgnoreCase("CSF_CSR_List_Editors")) {
			
			testStepInfo("*************** Billionaires Welcome Page***************");
			
			waitTime(3);
			validatePageLoadTime("http://www.forbes.com/billionaires/",20,"Billionaires welcome Page");
			
			validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
			validateCSFPromoBlock();
			validateTopAds(OR.ad_ColehaanFirstTopad);
			validateRecAds(OR.ads_Most_Popular_HashTag_Ads);
			validateRecAds(OR.ad_Lsits_Page_CSF_TopAd);
			validateVideoSection();
			validateLabelWithImage(OR.txt_Lists_Page_Article,OR.img_Lists_Page_Article,"Article");
			
			validateRelatedArticlesInBillionaresPage();
			validateLabelWithImage(OR.txt_Lists_Page_Pictures,OR.img_Lists_Page_Pictures,"Pictures");
			validateCountryDropdown(OR.txt_BillionairesPage_Country,OR.txt_BillionairesPage_CountryLists);
			validateFilterInLists();
			validateBillionaireOverlayLists();
			validateCarouselNavigation();
			validateTimelineEmbed();
			validateFooterCopy();
			validateUpdatedFooterNavigation();
		} 
		else if (currentExecutionMachineName.equalsIgnoreCase("AndroidMobile")) {
			testStepInfo("*************** Billionaires Page For Mobile***************");
			validatePageLoadTime("http://www.forbes.com/billionaires/",20,"Billionaires welcome Page");
			
			
			
			validateSocialShare();
			validateCSFPromoBlock();
			validateTopAds(OR.ad_ColehaanFirstTopad);
			validateRecAds(OR.ads_Most_Popular_HashTag_Ads);
			validateRecAds(OR.ad_Lsits_Page_CSF_TopAd);
			
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			
			validateVideoSection();
			validateLabelWithImage(OR.txt_Lists_Page_Article,OR.img_Lists_Page_Article,"Article");
			
			validateRelatedArticlesInBillionaresPage();
			validateLabelWithImage(OR.txt_Lists_Page_Pictures,OR.img_Lists_Page_Pictures,"Pictures");
			validateCountryDropdown(OR.txt_BillionairesPage_Country,OR.txt_BillionairesPage_CountryLists);
			validateFilterInLists();
			validateBillionaireOverlayLists();
			validateCarouselNavigation();
			validateTimelineEmbedInmobile();
			validateFooterCopy();
			validateUpdatedFooterNavigation();
		
		}
		else {
			testStepInfo("*************** Billionaires welcome Page For Mobile***************");
			waitTime(3);
			validatePageLoadTime("http://www.forbes.com/billionaires/",20,"Billionaires welcome Page");
			
			validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
			validateCSFPromoBlock();
			validateTopAds(OR.ad_ColehaanFirstTopad);
			validateTopAds(OR.ads_Most_Popular_HashTag_Ads);
			validateTopAds(OR.ad_Lsits_Page_CSF_TopAd);
			validateVideoSection();
			//validateArticle();
		}
	}

	
	
	public void validateTimelineEmbed()
	{
		testStepInfo("**********************Validate Timeline embed*******************");
		try {
			switchToFrame("timeline #xpath=.//*[@id='row-13']/div/ul//iframe");
			
			this.scrollToElement(OR.img_Billionaires_TimelineEmbed);
			this.scrollBy(0, -60);
			boolean checkTimelineMediaImage=elementPresent(OR.img_Billionaires_TimelineEmbed);
			if(checkTimelineMediaImage==true)
			{
				testStepPassed("Timeline Media Image is present");
			
				boolean checkTimelineTitle=elementPresent(OR.txt_BillionaresPage_TimelineTitle);
				boolean checkTimelineContent=elementPresent(OR.txt_billionairesPage_TimelineText_Content);
				if(checkTimelineTitle==true && checkTimelineContent==true)
				{
					String getTimelineTitle=getText(OR.txt_BillionaresPage_TimelineTitle);
					
					testStepPassed("Timeline Title is present--"+getTimelineTitle);
					String getTimelineContent=getText(OR.txt_billionairesPage_TimelineText_Content);
					testStepPassed("Timeline Text content is present--"+getTimelineContent);
					
					
					boolean checkNextArrow=elementPresent(OR.btn_BillionairesPage_TimelineNextButton);
					if(checkNextArrow==true)
					{
						testStepPassed("Timeline next navigation arrow is present");
						mouseOver(OR.btn_BillionairesPage_TimelineNextButton);
						
						boolean checkNextNavTitle=elementPresent(OR.txt_BillionairesPage_NextNav_Title);
						
						if(checkNextNavTitle==true)
						{
							testStepPassed("Next Navigation title is present");
						}
						else
						{
							testStepFailed("Next Navigation title is not present");
						}
					}
					else
					{
						testStepInfo("Next navigation arrow is not present");
					}
					
				}
				else
				{
					testStepFailed("Timeline Title/Content is not present");
				}
			}
			else
			{
				testStepFailed("Timeline Media Image is not present");
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void validateTimelineEmbedInmobile()
	{
		testStepInfo("**********************Validate Timeline embed*******************");
		try {
			switchToFrame("timeline #xpath=.//*[@id='row-13']/div/ul//iframe");
			
			
			this.scrollToElement(OR.img_Billionaires_TimelineEmbed);
			this.scrollBy(0, -60);
			boolean checkTimelineMediaImage=elementPresent(OR.img_Billionaires_TimelineEmbed);
			if(checkTimelineMediaImage==true)
			{
				testStepPassed("Timeline Media Image is present");
			
				boolean checkTimelineTitle=elementPresent(OR.txt_BillionaresPage_TimelineTitle);
				boolean checkTimelineContent=elementPresent(OR.txt_billionairesPage_TimelineText_Content);
				if(checkTimelineTitle==true && checkTimelineContent==true)
				{
					String getTimelineTitle=getText(OR.txt_BillionaresPage_TimelineTitle);
					
					testStepPassed("Timeline Title is present--"+getTimelineTitle);
					String getTimelineContent=getText(OR.txt_billionairesPage_TimelineText_Content);
					testStepPassed("Timeline Text content is present--"+getTimelineContent);
					
					
					boolean checkNextArrow=elementPresent(OR.btn_BillionairesPage_TimelineNextButton);
					if(checkNextArrow==true)
					{
						testStepPassed("Timeline next navigation arrow is present");
						//clickOn(OR.btn_BillionairesPage_TimelineNextButton);
						
						boolean checkNextNavTitle=elementPresent(OR.txt_BillionairesPage_NextNav_Title);
						
						if(checkNextNavTitle==true)
						{
							testStepPassed("Next Navigation title is present");
						}
						else
						{
							testStepFailed("Next Navigation title is not present");
						}
					}
					else
					{
						testStepInfo("Next navigation arrow is not present");
					}
					
				}
				else
				{
					testStepFailed("Timeline Title/Content is not present");
				}
			}
			else
			{
				testStepFailed("Timeline Media Image is not present");
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	
	public void validateCarouselNavigation()
	{
		testStepInfo("******************Carousel Navigation******************");
		try {
			boolean checkNext10Button=elementPresent(OR.btn_BillionairesPage_Next10);
			if(checkNext10Button==true)
			{
				this.scrollToElement(OR.btn_BillionairesPage_Next10);
				this.scrollBy(0, -60);
				clickOn(OR.btn_BillionairesPage_Next10);
				validateBillionaireOverlayLists();
				
				boolean checkPrevious10=elementPresent(OR.btn_BillionairesPage_Previous10);
				if(checkPrevious10==true)
				{
					testStepPassed("Previous 10 button is present");
				}
				else
				{
					testStepFailed("Previous 10 button is not present");
				}
				boolean checkSeeFullList=elementPresent(OR.txt_BillionairesPage_SeeFullList);
				if(checkSeeFullList==true)
				{
					testStepPassed("See Full List button is present");
				}
				else
				{
					testStepFailed("See Full List button is not present");
				}
			}
			else
			{
				testStepFailed("Next 10 Button is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	
	public void validateFilterInLists()
	{
		testStepInfo("*********************** List Filter************************");
		try {
			boolean checkListFilter=elementPresent(OR.txt_Billionaires_Filter_Lists);
			if(checkListFilter==true)
			{
				int getFilterCount=getElementCount(OR.txt_Billionaires_Filter_Lists);
				testStepPassed("Total number of List Filter --"+getFilterCount);
				for (int i =2; i <=getFilterCount; i++) {
					boolean checkFilters=elementPresent("Filter#xpath=//section[@id='row-11']/div/ul/li/div/div/div[2]/ul/li["+i+"]");
					if(checkFilters==true)
					{
						String getListFilter=getText("Filter#xpath=//section[@id='row-11']/div/ul/li/div/div/div[2]/ul/li["+i+"]");
						testStepPassed("List Filter is present-"+i+"--"+getListFilter);
					}
					else
					{
						testStepFailed("List Filter is not present-"+i);
					}
				}
				
			}
			else
			{
				testStepFailed("List Filter is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateBillionaireOverlayLists()
	{
		testStepInfo("********************Billionaires Lists************************");
		try {
			boolean checkTheListsLabel=elementPresent(OR.txt_BillionairesPage_Lists);
			if(checkTheListsLabel==true)
			{
				testStepPassed("The Lists Label is present");
				boolean checkBillionairesLists=elementPresent(OR.img_BillionairesPage_Overlaylists);
				if(checkBillionairesLists==true)
				{
					int getCount=getElementCount(OR.img_BillionairesPage_Overlaylists);
					testStepPassed("Billionaires Lists count is --"+getCount);
					for (int i = 1; i <=getCount; i++) {
						
						boolean checkBillionairesInfo=elementPresent("Billionaires Info#xpath=//ul[@class='overlay-list']//li["+i+"]//span[@class='name ng-binding']");
								
						if(checkBillionairesInfo==true)
						{
							String getBillionairesInfo=getText("Billionaires Info#xpath=//ul[@class='overlay-list']//li["+i+"]//span[@class='name ng-binding']");
							
							waitTime(3);
							testStepPassed("Billionaires Info is present "+i+"-"+getBillionairesInfo);
						}
						else
						{
							testStepFailed("Billionaires Info is not present--"+i);
						}
					}
				}
				else
				{
					testStepFailed("Billionaires Lists is not present");
				}
			}
			else
			{
				
				testStepFailed("The Lists Label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		
	}
	public void validateRelatedArticlesInBillionaresPage()
	{
		testStepInfo("**********************Related Articles*********************");
		try {
			boolean checkBillionairesRelatedArticles=elementPresent(OR.img_BillionairesPage_Related_Articles);
			if(checkBillionairesRelatedArticles==true)
			{
				int getArticleCount=getElementCount(OR.img_BillionairesPage_Related_Articles);
				testStepPassed("Total Related Articles are present-"+getArticleCount);
				for (int i =1; i <=getArticleCount; i++) {
					
					boolean checkRelatedArticleTitle=elementPresent("Related Article Title#xpath=//section[@id='row-6']//ul[@class='related-articles clearfix']//li["+i+"]//div[@class='article-meta']//h3/span");
					boolean checkRelatedArticleName=elementPresent("Related Article Name#xpath=//section[@id='row-6']//ul[@class='related-articles clearfix']//li["+i+"]//div[@class='article-meta']//span[@class='name-desc']/a");
					boolean checkRelatedArticleType=elementPresent("Related Article Type#xpath=//section[@id='row-6']//ul[@class='related-articles clearfix']//li["+i+"]//div[@class='article-meta']//span[@class='atype']/span");
					boolean checkRelatedArticleAvatar=elementPresent("Related Article Avatar#xpath=//section[@id='row-6']//ul[@class='related-articles clearfix']//li["+i+"]//div[@class='article-meta']//cite//a[@class='avatar']");
					
					
					if(checkRelatedArticleTitle==true && checkRelatedArticleName==true && checkRelatedArticleType==true && checkRelatedArticleAvatar==true)
					{
						String getArticleTitle=getText("Related Article Title#xpath=//section[@id='row-6']//ul[@class='related-articles clearfix']//li["+i+"]//div[@class='article-meta']//h3/span");
					
						testStepPassed("Related Article Title,Name,Type and Avatar are present--"+i+"--"+getArticleTitle);
					}
					else
					{
						getCurrentPageURL();
						testStepFailed("Related Article Title is not present-"+i);
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
	public void validateLabelWithImage(String labelName,String image,String name)
	{
		testStepInfo("**************"+name+"*************");
		try {
			boolean checkArticleLabel=elementPresent(labelName);
			if(checkArticleLabel==true)
			{
				testStepPassed(name+" Label is present");
				
				this.scrollToElement(image);
				this.scrollBy(0, -100);
				boolean checkArticleImage=elementPresent(image);
				if(checkArticleImage==true)
				{
					testStepPassed(name+" Image is present");
				}
				else
				{
					testStepFailed(name+" Image is not present");
				}
				
			}
			else
			{
				testStepFailed(name+"Label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateVideoSection()
	{
		testStepInfo("******************Validate Video Section****************");
		try {
			boolean checkVideoLabel=elementPresent(OR.txt_Lists_Page_Video);
			if(checkVideoLabel==true)
			{
				testStepPassed("Video Label is present");
				boolean checkVideoBlock=elementPresent(OR.video_Lists_Page_VideoBlock);
				//boolean checkPlayButton=elementPresent(OR.icon_Lists_Page_PlayButton);
				if(checkVideoBlock==true)
				{
					
					testStepPassed("Video block is present");
					
					//testStepPassed("Video is playing by clicking on the play button");
				}
				else
				{
					testStepFailed("Video block is not present");
				}
			}
			else
			{
				testStepFailed("Video label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	public void validateCSFPromoBlock()
	{
		testStepInfo("******************Validate Promo Block Video****************");
		try {
			this.scrollToElement(OR.video_Lists_Page_CSF_PromoBlock);
			this.scrollBy(0, -60);
			boolean checkPromoBlockVideo=elementPresent(OR.video_Lists_Page_CSF_PromoBlock);
			
			if(checkPromoBlockVideo==true)
			{
				testStepPassed("CSF Promo Block video is present");
			}
			else
			{
				testStepFailed("CSF Promo Block video is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	

}
