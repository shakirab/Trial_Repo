
package loginWithHPArticleValidation;



import objectsRepository.OR;
import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;


public class LoginHPArticle extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	public LoginHPArticle(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	public LoginHPArticle() {

		// TODO Auto-generated constructor st ub
	}

	
	public void validateHPArticle() {

		if (currentExecutionMachineName.equalsIgnoreCase("LoginHPArticle")) {
			testStepInfo("**************** HOME PAGE ********************");
			verifyLoginForm();
			verifyLoginPage();
			driver.get("https://www.forbes.com/home_usa/");
			validateSocialSharesInMobile();
			validateSearchIcon();
			validatePromoBlock();
			
			testStepInfo("****************** ARTICLE PAGE *********************");
			driver.get("https://www.forbes.com/home_usa/");
			boolean checkPromo=elementPresent(OR.txt_Home_Page_Top_Stories1);
			if(checkPromo==true)
			{
				clickOn(OR.txt_Home_Page_Top_Stories1);
				
				validateHashTag(OR.txt_Reg_Article_Page_HashTag);
				validateAuthorDetailsForDesktop();
				validateFullBio();
				verifyAdsInArticle();
				
			}
			
			testStepInfo("*************** Lists Page***************");
			validatePageLoadTime("https://www.forbes.com/billionaires/list/", 20, "Lists Page");
			validateTopAds(OR.adsHomePageTopAds);	
			validateSpreadsheetAndReprintLinks();
			validateSeeRealTimeRanking();
			validateSocialnetworks(OR.img_Reg_Lists_Page_SocialShare_Options);
			verifyAdsInLsits();
			
			testStepInfo("****************** CSF PAGE ****************");
			driver.get("https://www.forbes.com/actors");
			verifyCSFPageContentsInDesktop();
			testStepInfo("*******************BV SF ***********************");
			driver.get("http://www.forbes.com/colehaan/daring-to-step-forward/");
			verifyColehaanContentsInDesktop();
			
			
			
		}
		
	}

}
