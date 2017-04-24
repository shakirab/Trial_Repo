
package forbesOnTrumpPage;

import iSAFE.ApplicationKeywords;


import objectsRepository.OR;


import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ContributorPageValidation.
  */
public class ForbesOnTrumpPageValidation extends ApplicationKeywords {

	
	/** The obj. */
	BaseClass obj;

	
	public ForbesOnTrumpPageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	
	
	public ForbesOnTrumpPageValidation() {

	}

	
	public void validateForbesOnTrumpPage() {
		testStepInfo("**************** Forbes On Trump Page *********************");
		if (currentExecutionMachineName.equalsIgnoreCase("Search_Video"))
		{
			validateForbesOnTrumpHeading(OR.txt_Forbes_On_Trump_Heading,"Forbes On Trump");
			validateTopAds(OR.txt_EditorsPick_EditorPickTopAd);
			validateRecAds(OR.txt_EditorsPick_EditorPickRecAd);
			validateTopxAds(OR.txt_EditorsPick_EditorPickBottomAd);
			verifySearchPageArticleStreamAndSeeMore(OR.txt_EditorsPick_EditorPickArticleStream, OR.button_searchPage_SeeMore, "Forbes On Trump Page");
			validateFirstArticleNavigation(OR.txt_Forbes_On_Trump_First_Article, OR.txt_EditorsPick_EditorPickArticle, "Forbes On Trump");
			validateBadge(OR.icon_Forbes_On_Trump_Badge, OR.txt_Forbes_On_Trump_Heading, "Forbes On Trump");
			
		}
		else if (currentExecutionMachineName.equalsIgnoreCase("AndroidMobile"))
		{
			testStepInfo("**************** Forbes On Trump Page For Mobile *********************");
			validateForbesOnTrumpHeading(OR.txt_Forbes_On_Trump_Heading,"Forbes On Trump");
			validateRecAds(OR.ad_EditorsPick_Mobile_RecAd); 
			validateRecAds(OR.ad_EditorsPick_Mobile_RecxAd);
			validateStickyAds("Forbes On Trump");
			validateShareIcon("Forbes On Trump");
			verifySearchPageArticleStreamAndSeeMore(OR.articles_EditorsPick_Mobile_ArticleStream,OR.button_searchPage_SeeMore,"Forbes On Trump Page");
			validateFirstArticleNavigation(OR.articles_EditorsPick_Mobile_FirstArticle, OR.articles_EditorsPick_Mobile_ArticleHeader, "Forbes On Trump");
			validateBadge(OR.icon_Mob_Forbes_On_Trump_Badge, OR.txt_Forbes_On_Trump_Heading, "Forbes On Trump");
		}
		else
		{
			testStepInfo("**************** Forbes On Trump Page For Mobile *********************");
			validateForbesOnTrumpHeading(OR.txt_Forbes_On_Trump_Heading,"Forbes On Trump");
			validateRecAds(OR.ad_EditorsPick_Mobile_RecAd); 
			validateRecAds(OR.ad_EditorsPick_Mobile_RecxAd);
			validateStickyAds("Forbes On Trump");
			validateShareIcon("Forbes On Trump");
			verifySearchPageArticleStreamAndSeeMore(OR.articles_EditorsPick_Mobile_ArticleStream,OR.button_searchPage_SeeMore,"Forbes On Trump Page");
			validateFirstArticleNavigation(OR.articles_EditorsPick_Mobile_FirstArticle, OR.articles_EditorsPick_Mobile_ArticleHeader, "Forbes On Trump");
			validateBadge(OR.icon_Mob_Forbes_On_Trump_Badge, OR.txt_Forbes_On_Trump_Heading, "Forbes On Trump");
		}
		
	}
	
	
	
}
