/**
 * Check Contributor Home page
 * Check on Contributor Image & Name
 * Click on Follow button
 * Click on Full Bio
 * Click on Show More

 */

package levelUpPage;

import iSAFE.ApplicationKeywords;

import java.util.List;

import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ContributorPageValidation.
  */
public class LevelUpPageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :LEVEL Up Page Validation
	// Created by :Shakira
	// Created on :Nov 2016

	// ///////////////////////////////////////////////////////////////////////////////
	/** The obj. */
	BaseClass obj;

	
	public LevelUpPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	
	public LevelUpPageValidation() {

		// TODO Auto-generated constructor stub
	}

	public void validateLevelUpPage() {
		
		if (currentExecutionMachineName.equalsIgnoreCase("Wel_HP_Article_LvlUp"))
		{
			testStepInfo("***************** LevelUp Page ********************");
			//driver.get("http://www.forbes.com/sites/levelup/");
			waitTime(10);
			verifyAuthorName();
			validatecontributorDetails(OR.img_Reg_Groupcontributor_Logo,OR.txt_Reg_Contributor_Page_TypeOFContributor,"LevelUp");
			validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
			validateContributorImage(OR.img_Reg_Contributor_Page_Image);
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			//verifyFullBio();
			
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			validateTopAds(OR.ads_Reg_Contributor_Page_TopAds);
			scrollBy(0, 1000);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds2);
			
			
			validateTopxAds(OR.ads_Reg_Contributor_Page_TopxAds);
			validatePromoVideoBlock();
			this.scrollBy(0, -600);
			clickingAllLatestPosts();
			validateArchiveContributor();
			//validateLatestPostsImages();
			
			validateMostPopularArticles();
			
		}
		else if (currentExecutionMachineName.equalsIgnoreCase("AndroidMobile"))
		{
			testStepInfo("***************** LevelUp Page For Mobile********************");
			verifyContributorNameInMobile();
			validatecontributorDetails(OR.img_Reg_Contributor_Page_Image,OR.txt_Reg_Contributor_Page_TypeOFContributor,"LevelUp");
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			
			//verifyAuthorNameInMobile();
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			this.scrollBy(0, -10);
			//validateTopAds(OR.ads_Welcome_Page_Ads);
			validateLatestPostsInMobile();
			validateArchiveContributor();
			
			//validateRecAds(OR.ads_Podcasts_Page_TopAds);
			validateMostPopularArticlesInMobile();
		}
		else 
		{
			testStepInfo("***************** LevelUp Page For Mobile********************");
			verifyContributorNameInMobile();
			validatecontributorDetails(OR.img_Reg_Contributor_Page_Image,OR.txt_Reg_Contributor_Page_TypeOFContributor,"LevelUp");
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			
			//verifyAuthorNameInMobile();
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			this.scrollBy(0, -10);
			//validateTopAds(OR.ads_Welcome_Page_Ads);
			validateLatestPostsInMobile();
			validateArchiveContributor();
			
			//validateRecAds(OR.ads_Podcasts_Page_TopAds);
			validateMostPopularArticlesInMobile();
			
		
		}
		
	}
	
	
	
}
