package groupContributorPage;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ContributorPageValidation.
  */
public class GroupContributorPageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Group Contributor Page Validation
	// Created by :Shakira
	// Created on :20 Dec 2016

	// ///////////////////////////////////////////////////////////////////////////////
	/** The obj. */
	BaseClass obj;

	
	public GroupContributorPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	
	public GroupContributorPageValidation() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * Validate contributor page.
	 */
	public void validateGroupContributorPage() {
		testStepInfo("****************Group Contributor Page *************************");
		if (currentExecutionMachineName.equalsIgnoreCase("Cont_BV"))
		{
			
			
			
			
			
			//driver.get("http://www.forbes.com/sites/sportsmoney/");
			verifyAuthorName();
			validateContributorImage(OR.img_Reg_Contributor_Page_Image);
			validatecontributorDetails(OR.img_Reg_Groupcontributor_Logo,OR.txt_Reg_Contributor_Page_TypeOFContributor,"Group");
			validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
			
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			//verifyFullBio();
			
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			validateAboutSection();
			validateOurWriters();
			validateWritersHomePage();
			validateTopAds(OR.ads_Reg_Contributor_Page_TopAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds2);
			validateTopxAds(OR.ads_Reg_Contributor_Page_TopxAds);
			validatePromoVideoBlock();
			scrollBy(0, -1000);
			validateArchiveContributor();
			//validateLatestPostsImages();
			clickingAllLatestPosts();
			
			validateMostPopularArticles();
		
			
			
		}
		
		else if(currentExecutionMachineName.equalsIgnoreCase("AndroidMobile"))
		{
			testStepInfo("****************Group Contributor Page For Mobile*************************");
			
			verifyAuthorNameInMobile();
			validatecontributorDetails(OR.img_Reg_Contributor_Page_Image,OR.txt_Reg_Contributor_Page_TypeOFContributor,"Group");
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			boolean shareButton=elementPresent(OR.btn_contributor_Page_ShareButton);
			if(shareButton==true)
			{
				clickOn(OR.btn_contributor_Page_ShareButton);
				validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
				clickOn(OR.btn_contributor_Page_ShareButton);
			}
			else
			{
				testStepFailed("Share Button is not displayed");
			}
			
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds1);
			
			validateAboutSection();
			validateOurWriters();
			validateWritersHomePage();
			
			validateArchiveContributor();
			validateLatestPostsInMobile();
			validateTopxAds(OR.ads_Podcasts_Page_TopAds);
			validateMostPopularArticlesInMobile();
			
		
		}
		else
		{
			testStepInfo("****************Group Contributor Page For Mobile*************************");
			
			verifyAuthorNameInMobile();
			validatecontributorDetails(OR.img_Reg_Contributor_Page_Image,OR.txt_Reg_Contributor_Page_TypeOFContributor,"Group");
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			boolean shareButton=elementPresent(OR.btn_contributor_Page_ShareButton);
			if(shareButton==true)
			{
				clickOn(OR.btn_contributor_Page_ShareButton);
				validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
				clickOn(OR.btn_contributor_Page_ShareButton);
			}
			else
			{
				testStepFailed("Share Button is not displayed");
			}
			
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds1);
			
			validateAboutSection();
			validateOurWriters();
			//validateWritersHomePage();
			
			validateArchiveContributor();
			validateLatestPostsInMobile();
			validateTopxAds(OR.ads_Podcasts_Page_TopAds);
			validateMostPopularArticlesInMobile();
			
		
		}
		
	}
	
	
	
	public void validateQAVideoSection()
	{
		testStepInfo("******************* QA Video ********************");
		try {
			boolean qaVideo=elementPresent(OR.vid_Reg_GroupContributor_Video);
			if(qaVideo==true)
			{
				testStepPassed("QA Test- Video Block is Displayed");
			}
			else
			{
				testStepFailed("QA Test-Video Block is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateTwitterSection()
	{
		testStepInfo("**************** QA Test  *****************");
		try {
			boolean twitterBlock=elementPresent(OR.txt_Reg_GroupContributor_TwitterBlock);
			if(twitterBlock==true)
			{
				testStepPassed("QA Test- Twiiter Block is Displayed");
			}
			else
			{
				testStepFailed("QA Test-Twitter Block is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	
	public void validateAboutOurWriter()
	{
	
		boolean writer=elementPresent(OR.txt_Reg_GroupContributor_FirstWriter);
		if(writer==true)
		{
			clickOn(OR.txt_Reg_GroupContributor_FirstWriter);
			
			boolean writerName=elementPresent(OR.txt_Reg_GroupContributor_WriterName);
			if(writerName==true)
			{
				String getWriterName=getText(OR.txt_Reg_GroupContributor_WriterName);
				testStepPassed(getWriterName);
				boolean viewPosts=elementPresent(OR.txt_Reg_GroupContributor_ViewPosts);
				boolean close=elementPresent(OR.txt_Reg_GroupContributor_Close);
				if(viewPosts==true &&close==true)
				{
					clickOn(OR.txt_Reg_GroupContributor_Close);
					waitTime(2);
					testStepPassed("View Posts and close are present");
				}
				else
				{
					testStepFailed("View Post and close buttons are not Displayed");
				}
			}
			else
			{
				testStepFailed("Writer Name is not Displayed");
			}
		}
	}
	
	public void validateTagLine()
	{
		try {
			boolean tagLine=elementPresent(OR.txt_Reg_Contributor_Page_TagLine);
			if(tagLine==true)
			{
				String getTagLine=getText(OR.txt_Reg_Contributor_Page_TagLine);
				testStepPassed("Contributor Tag Line is present-"+getTagLine);
			}
			else
			{
				testStepFailed("Contributor Tag Line is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}


	
}
