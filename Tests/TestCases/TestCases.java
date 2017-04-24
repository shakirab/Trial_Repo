package TestCases;

import editorsPick.EditorsPickCheck;
import forbesOnTrumpPage.ForbesOnTrumpPageValidation;
import ga.articleGACheck;
import ga.bvArticleGACheck;
import ga.contribPageGACheck;
import ga.csfGACheck;
import ga.csrGACheck;
import ga.welcomeAdGACheck;
import galleryCheck.GalleryPageFunctionalityCheck;
import groupContributorPage.GroupContributorPageValidation;
import homePageRedesign.HomePageRedesignValidation;
import iSAFE.ApplicationKeywords;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import levelUpPage.LevelUpPageValidation;
import loginPage.LoginPageValidation;
import loginWithHPArticleValidation.LoginHPArticle;
import mostPopularHashTagPage.MostPopularHashTagPageValidation;
import mostPopularPage.MostPopularPageValidation;
import newWelcomePageForArticle.WelcomeArticlePageValidation;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import podcastsPage.PodCastsPageValidation;
import profilePage.ProfilePageValidation;
import realTimePage.RealTimePageValidation;
import searchPage.searchPageFunctionality;
import signUpPage.SignUpValidation;
import socialLoginPage.SocialLoginPageValidation;
import specialfeaturesPages.colehaanCSFFunctionality;
import specialfeaturesPages.dellSFFunctionality;
import specialfeaturesPages.johnhancockSFFunctionality;
import specialfeaturesPages.kpmgSFFunctionality;
import specialfeaturesPages.oppenheimerFunctionality;
import sslCertification.SSLCertificationValidation;
import testingBuckets.Report404Validation;
import videoPage.VideoPageValidation;
import welcomePage.WelcomePageValidation;
import AutomationFramework.GenericKeywords;
import ampPage.AmpPageValidation;
import angularGalleryCheck.AngularGalleryFunctionalityCheck;
import articlePage.ArticlePageValidation;
import baseClass.BaseClass;
import billionairesWelcomePage.BillionairesWelcomePageValidation;
import bvArticlePage.BVArticlePageValidation;
import bvContribPage.BVContributorPageValidation;
import bvPageCheck.BVPageFunctions;

import communityVoicePage.CommunityVoiceValidation;

import contributorPage.ContributorPageValidation;
import csfPageCheck.CSFPageFunctionality;
import csrPageCheck.CSRPageFunctionality;

@Listeners({ Utilities.HtmlReport.class })
public class TestCases {
	String machineName = "";
	BaseClass obj;
	WelcomePageValidation welcomePageValidation;
	ArticlePageValidation articlePageValidation;
	MostPopularPageValidation mostPopularPageValidation;
	RealTimePageValidation realTimePageValidation;
	ContributorPageValidation contributorPageValidation;
	VideoPageValidation videoPageValidation;
	ProfilePageValidation profilePageValidation;
	WelcomeArticlePageValidation welcomeArticlePageValidation;
	Report404Validation report404Validation;
	LevelUpPageValidation levelUpPageValidation;
	PodCastsPageValidation podCastsPageValidation;
	SSLCertificationValidation sSLCertificationValidation;
	BVPageFunctions bvpagefunctions;
	GalleryPageFunctionalityCheck gallerypagefunctionalitycheck;
	AngularGalleryFunctionalityCheck angulargalleryfunctionalitycheck;
	CSFPageFunctionality csffunctionality;
	CSRPageFunctionality csrfunctionality;
	searchPageFunctionality searchpagefunctionalityobj;
	EditorsPickCheck editorspickcheck;
	AmpPageValidation amppagevalidation;
	GroupContributorPageValidation groupContributorPageValidation;
	MostPopularHashTagPageValidation mostPopularHashTagPageValidation;
	BVContributorPageValidation bvContributorPageValidation;
	CommunityVoiceValidation communityVoiceValidation;
	colehaanCSFFunctionality colehaanfunctionality;
	dellSFFunctionality dellfunctionality;
	johnhancockSFFunctionality johnhancockfunctionality;
	oppenheimerFunctionality oppenheimerfunctionality;
	kpmgSFFunctionality kpmgsffunctionality;
	BVArticlePageValidation bvarticlepage;
	LoginHPArticle loginHPArticle;
	LoginPageValidation loginPageValidation;
	SignUpValidation signUpValidation;
	SocialLoginPageValidation socialLoginPageValidation;
	ForbesOnTrumpPageValidation forbesOnTrumpPageValidation;
	// BVOraclePageValidation bvOraclePageValidation;
	HomePageRedesignValidation homePageRedesignValidation;
	BillionairesWelcomePageValidation billionairesWelcomePageValidation;
	bvArticleGACheck bvarticlegacheck;
	articleGACheck articlegacheck;
	welcomeAdGACheck wagacheck;
	csfGACheck csfgacheck;
	csrGACheck csrgacheck;
	contribPageGACheck contribPagegacheck;
	
	public void TestStart(String testCaseDescription, String hostName,
			String testCaseName) {

		obj.currentTestCaseName = testCaseName;
		obj.setEnvironmentTimeouts();
		obj.reportStart(testCaseDescription, hostName);
		obj.iterationCount.clear();
		obj.iterationCountInTextData();

	}

	@BeforeClass
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port",
			"selenium.browser", "selenium.os", "selenium.browserVersion",
			"selenium.osVersion", "TestData.SheetNumber" })
	public void precondition(String machineName, String host, String port,
			String browser, String os, String browserVersion, String osVersion,
			String sheetNo) {

		// module2functionalities.udid="ZX1D64HN6H";
		obj = new BaseClass();
		// obj.udid = "4d0059c64bf62133";
		obj.udid = "320820f1755181c5";
		//obj.udid = "ZY222XZJZ3";
		// obj.udid = "4100e772f24e924d";
		// obj.udid = "72cf335d";
		if (os.contains("Android")) {
			// obj.startServer(host,port);
			// obj.waitTime(10);
		}
		obj.setup(machineName, host, port, browser, os, browserVersion,
				osVersion, sheetNo);

	}

	@AfterClass
	public void closeSessions() {
		obj.closeAllSessions();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC001_MR_WelcomePage(String machineName, Method method)
			throws MalformedURLException {

		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {

			TestStart("Welcome Page Validations", machineName, method.getName());
			welcomePageValidation = new WelcomePageValidation(obj);
			for (int i = 0; i < welcomePageValidation.iterationCount.size(); i++) {

				welcomePageValidation.dataRowNo = Integer
						.parseInt(welcomePageValidation.iterationCount.get(i)
								.toString());
				welcomePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						welcomePageValidation.currentExecutionMachineName,
						welcomePageValidation.currentTestCaseName);
				// welcomePageValidation.navigateTo("http://www.forbes.com/forbes/welcome/?autoforward=false");
				welcomePageValidation.verifyWelcomePage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("Welcome Page Validations", machineName, method.getName());
			welcomePageValidation = new WelcomePageValidation(obj);
			for (int i = 0; i < welcomePageValidation.iterationCount.size(); i++) {

				welcomePageValidation.dataRowNo = Integer
						.parseInt(welcomePageValidation.iterationCount.get(i)
								.toString());
				welcomePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						welcomePageValidation.currentExecutionMachineName,
						welcomePageValidation.currentTestCaseName);
				// welcomePageValidation.navigateTo("http://www.forbes.com/forbes/welcome/?autoforward=false");
				welcomePageValidation.verifyWelcomePage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("Welcome Page Validations", machineName, method.getName());
			welcomePageValidation = new WelcomePageValidation(obj);
			for (int i = 0; i < welcomePageValidation.iterationCount.size(); i++) {

				welcomePageValidation.dataRowNo = Integer
						.parseInt(welcomePageValidation.iterationCount.get(i)
								.toString());
				welcomePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						welcomePageValidation.currentExecutionMachineName,
						welcomePageValidation.currentTestCaseName);
				// welcomePageValidation.navigateTo("http://www.forbes.com/forbes/welcome/?autoforward=false");
				welcomePageValidation.verifyWelcomePage();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = welcomePageValidation.testCaseExecutionStatus;
		obj.testFailure = welcomePageValidation.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC002_MR_HomePageRedesign(String machineName, Method method)
			throws MalformedURLException {

		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {
			TestStart("Home page Validations", machineName, method.getName());
			homePageRedesignValidation = new HomePageRedesignValidation(obj);
			for (int i = 0; i < homePageRedesignValidation.iterationCount.size(); i++) {

				homePageRedesignValidation.dataRowNo = Integer
						.parseInt(homePageRedesignValidation.iterationCount.get(i)
								.toString());
				homePageRedesignValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								homePageRedesignValidation.currentExecutionMachineName,
						homePageRedesignValidation.currentTestCaseName);
				// homePageValidation.navigateTo("http://www.forbes.com");
				homePageRedesignValidation.validateHomePage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("Home page Validations", machineName, method.getName());
			homePageRedesignValidation = new HomePageRedesignValidation(obj);
			for (int i = 0; i < homePageRedesignValidation.iterationCount.size(); i++) {

				homePageRedesignValidation.dataRowNo = Integer
						.parseInt(homePageRedesignValidation.iterationCount.get(i)
								.toString());
				homePageRedesignValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								homePageRedesignValidation.currentExecutionMachineName,
						homePageRedesignValidation.currentTestCaseName);
				homePageRedesignValidation.navigateTo("https://www.forbes.com/");
				homePageRedesignValidation.validateHomePage();
			}
		}

		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("Home page Validations", machineName, method.getName());
			homePageRedesignValidation = new HomePageRedesignValidation(obj);
			for (int i = 0; i < homePageRedesignValidation.iterationCount.size(); i++) {

				homePageRedesignValidation.dataRowNo = Integer
						.parseInt(homePageRedesignValidation.iterationCount.get(i)
								.toString());
				homePageRedesignValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								homePageRedesignValidation.currentExecutionMachineName,
						homePageRedesignValidation.currentTestCaseName);
				homePageRedesignValidation.navigateTo("http://www.forbes.com");
				homePageRedesignValidation.validateHomePage();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = homePageRedesignValidation.testCaseExecutionStatus;
		obj.testFailure = homePageRedesignValidation.testFailure;
		TestEnd();
	}



	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC003_MR_ArticlePage(String machineName, Method method) {

		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {
			TestStart("Article Page Validations", machineName, method.getName());
			articlePageValidation = new ArticlePageValidation(obj);
			for (int i = 0; i < articlePageValidation.iterationCount.size(); i++) {
				articlePageValidation.dataRowNo = Integer
						.parseInt(articlePageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ articlePageValidation.dataRowNo);
				articlePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						articlePageValidation.currentExecutionMachineName,
						articlePageValidation.currentTestCaseName);
				articlePageValidation
						.navigateTo("http://www.forbes.com/home_usa/?nowelcome");
				articlePageValidation.validateArticlePage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("Article Page Validations", machineName, method.getName());
			articlePageValidation = new ArticlePageValidation(obj);
			for (int i = 0; i < articlePageValidation.iterationCount.size(); i++) {
				articlePageValidation.dataRowNo = Integer
						.parseInt(articlePageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ articlePageValidation.dataRowNo);
				articlePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						articlePageValidation.currentExecutionMachineName,
						articlePageValidation.currentTestCaseName);
				articlePageValidation
						.navigateTo("http://www.forbes.com/home_usa/?nowelcome");
				articlePageValidation.validateArticlePage();
			}
		}

		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("Article Page Validations", machineName, method.getName());
			articlePageValidation = new ArticlePageValidation(obj);
			for (int i = 0; i < articlePageValidation.iterationCount.size(); i++) {
				articlePageValidation.dataRowNo = Integer
						.parseInt(articlePageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ articlePageValidation.dataRowNo);
				articlePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						articlePageValidation.currentExecutionMachineName,
						articlePageValidation.currentTestCaseName);
				articlePageValidation
						.navigateTo("http://www.forbes.com/home_usa/?nowelcome");
				articlePageValidation.validateArticlePage();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = articlePageValidation.testCaseExecutionStatus;
		obj.testFailure = articlePageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC004_MR_ContributorPage(String machineName, Method method) {

		if (obj.currentExecutionMachineName.equalsIgnoreCase("Cont_BV")) {

			TestStart("Contributor Page Validations", machineName,
					method.getName());
			contributorPageValidation = new ContributorPageValidation(obj);
			for (int i = 0; i < contributorPageValidation.iterationCount.size(); i++) {
				contributorPageValidation.dataRowNo = Integer
						.parseInt(contributorPageValidation.iterationCount.get(
								i).toString());
				System.out.println("-------------->"
						+ contributorPageValidation.dataRowNo);
				contributorPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						contributorPageValidation.currentExecutionMachineName,
						contributorPageValidation.currentTestCaseName);
				contributorPageValidation
						.navigateTo("http://www.forbes.com/home_usa/?nowelcome");
				contributorPageValidation.validateContributorPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("Contributor Page Validations", machineName,
					method.getName());
			contributorPageValidation = new ContributorPageValidation(obj);
			for (int i = 0; i < contributorPageValidation.iterationCount.size(); i++) {
				contributorPageValidation.dataRowNo = Integer
						.parseInt(contributorPageValidation.iterationCount.get(
								i).toString());
				System.out.println("-------------->"
						+ contributorPageValidation.dataRowNo);
				contributorPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						contributorPageValidation.currentExecutionMachineName,
						contributorPageValidation.currentTestCaseName);
				contributorPageValidation
						.navigateTo("http://www.forbes.com/home_usa/?nowelcome");
				contributorPageValidation.validateContributorPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("Contributor page Validations", machineName, method.getName());
			contributorPageValidation = new ContributorPageValidation(obj);
			for (int i = 0; i < contributorPageValidation.iterationCount.size(); i++) {

				contributorPageValidation.dataRowNo = Integer
						.parseInt(contributorPageValidation.iterationCount.get(
								i).toString());
				contributorPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						contributorPageValidation.currentExecutionMachineName,
						contributorPageValidation.currentTestCaseName);
				contributorPageValidation
						.navigateTo("http://www.forbes.com/home_usa/?nowelcome");
				contributorPageValidation.validateContributorPage();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = contributorPageValidation.testCaseExecutionStatus;
		obj.testFailure = contributorPageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC005_MR_BVPageTest(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("Cont_BV")) {
			TestStart("BrandVoice Page validation", machineName,
					method.getName());
			bvpagefunctions = new BVPageFunctions(obj);
			for (int i = 0; i < bvpagefunctions.iterationCount.size(); i++) {
				bvpagefunctions.dataRowNo = Integer
						.parseInt(bvpagefunctions.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ bvpagefunctions.dataRowNo);
				bvpagefunctions.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						bvpagefunctions.currentExecutionMachineName,
						bvpagefunctions.currentTestCaseName);
				bvpagefunctions
						.navigateTo("http://www.forbes.com/sites/northwesternmutual/?nowelcome");
				bvpagefunctions.verifyBVpageContents();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("BrandVoice Page validation", machineName,
					method.getName());
			bvpagefunctions = new BVPageFunctions(obj);
			for (int i = 0; i < bvpagefunctions.iterationCount.size(); i++) {
				bvpagefunctions.dataRowNo = Integer
						.parseInt(bvpagefunctions.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ bvpagefunctions.dataRowNo);
				bvpagefunctions.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						bvpagefunctions.currentExecutionMachineName,
						bvpagefunctions.currentTestCaseName);
				bvpagefunctions
						.navigateTo("http://www.forbes.com/sites/northwesternmutual/?nowelcome");
				bvpagefunctions.verifyBVpageContents();
			}
		} 
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("BrandVoice Page validation", machineName,
					method.getName());
			bvpagefunctions = new BVPageFunctions(obj);
			for (int i = 0; i < bvpagefunctions.iterationCount.size(); i++) {
				bvpagefunctions.dataRowNo = Integer
						.parseInt(bvpagefunctions.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ bvpagefunctions.dataRowNo);
				bvpagefunctions.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						bvpagefunctions.currentExecutionMachineName,
						bvpagefunctions.currentTestCaseName);
				bvpagefunctions
						.navigateTo("http://www.forbes.com/sites/northwesternmutual/?nowelcome");
				bvpagefunctions.verifyBVpageContents();
			}
		} 
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = bvpagefunctions.testCaseExecutionStatus;
		obj.testFailure = bvpagefunctions.testFailure;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC022_MR_BVArticlePage(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("Cont_BV")) {
			TestStart("BV Article Page validation", machineName,
					method.getName());
			bvarticlepage = new BVArticlePageValidation(obj);
			for (int i = 0; i < bvarticlepage.iterationCount.size(); i++) {
				bvarticlepage.dataRowNo = Integer
						.parseInt(bvarticlepage.iterationCount.get(i)
								.toString());
				System.out.println("-------------->" + bvarticlepage.dataRowNo);
				bvarticlepage.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						bvarticlepage.currentExecutionMachineName,
						bvarticlepage.currentTestCaseName);
				bvarticlepage
						.navigateTo("http://www.forbes.com/sites/northwesternmutual/");
				bvarticlepage.verifyBVArticlepageContents();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("BV Article Page validation", machineName,
					method.getName());
			bvarticlepage = new BVArticlePageValidation(obj);
			for (int i = 0; i < bvarticlepage.iterationCount.size(); i++) {
				bvarticlepage.dataRowNo = Integer
						.parseInt(bvarticlepage.iterationCount.get(i)
								.toString());
				System.out.println("-------------->" + bvarticlepage.dataRowNo);
				bvarticlepage.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						bvarticlepage.currentExecutionMachineName,
						bvarticlepage.currentTestCaseName);
				bvarticlepage
						.navigateTo("http://www.forbes.com/sites/northwesternmutual/");
				bvarticlepage.verifyBVArticlepageContents();
			}
		} 
		
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("BV Article Page validation", machineName,
					method.getName());
			bvarticlepage = new BVArticlePageValidation(obj);
			for (int i = 0; i < bvarticlepage.iterationCount.size(); i++) {
				bvarticlepage.dataRowNo = Integer
						.parseInt(bvarticlepage.iterationCount.get(i)
								.toString());
				System.out.println("-------------->" + bvarticlepage.dataRowNo);
				bvarticlepage.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						bvarticlepage.currentExecutionMachineName,
						bvarticlepage.currentTestCaseName);
				bvarticlepage
						.navigateTo("http://www.forbes.com/sites/northwesternmutual/");
				bvarticlepage.verifyBVArticlepageContents();
			}
		}
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = bvarticlepage.testCaseExecutionStatus;
		obj.testFailure = bvarticlepage.testFailure;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC006_MR_NewPostPage(String machineName, Method method) {

		if (obj.currentExecutionMachineName.equalsIgnoreCase("NP_MP_Gallery")) {
			TestStart("New Posts Page Validations", machineName,
					method.getName());
			realTimePageValidation = new RealTimePageValidation(obj);
			for (int i = 0; i < realTimePageValidation.iterationCount.size(); i++) {
				realTimePageValidation.dataRowNo = Integer
						.parseInt(realTimePageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ realTimePageValidation.dataRowNo);
				realTimePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						realTimePageValidation.currentExecutionMachineName,
						realTimePageValidation.currentTestCaseName);
				// realTimePageValidation.navigateTo("http://www.forbes.com/real-time/");
				realTimePageValidation.verifyNewPostsPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("New Posts Page Validations", machineName,
					method.getName());
			realTimePageValidation = new RealTimePageValidation(obj);
			for (int i = 0; i < realTimePageValidation.iterationCount.size(); i++) {
				realTimePageValidation.dataRowNo = Integer
						.parseInt(realTimePageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ realTimePageValidation.dataRowNo);
				realTimePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						realTimePageValidation.currentExecutionMachineName,
						realTimePageValidation.currentTestCaseName);
				// realTimePageValidation.navigateTo("http://www.forbes.com/real-time/");
				realTimePageValidation.verifyNewPostsPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("New Posts Page Validations", machineName,
					method.getName());
			realTimePageValidation = new RealTimePageValidation(obj);
			for (int i = 0; i < realTimePageValidation.iterationCount.size(); i++) {
				realTimePageValidation.dataRowNo = Integer
						.parseInt(realTimePageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ realTimePageValidation.dataRowNo);
				realTimePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						realTimePageValidation.currentExecutionMachineName,
						realTimePageValidation.currentTestCaseName);
				// realTimePageValidation.navigateTo("http://www.forbes.com/real-time/");
				realTimePageValidation.verifyNewPostsPage();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = realTimePageValidation.testCaseExecutionStatus;
		obj.testFailure = realTimePageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC007_MR_MostPopularPage(String machineName, Method method)
			throws Exception {

		if (obj.currentExecutionMachineName.equalsIgnoreCase("NP_MP_Gallery")) {
			TestStart("Most Popular validation", machineName, method.getName());
			mostPopularPageValidation = new MostPopularPageValidation(obj);
			for (int i = 0; i < mostPopularPageValidation.iterationCount.size(); i++) {
				mostPopularPageValidation.dataRowNo = Integer
						.parseInt(mostPopularPageValidation.iterationCount.get(
								i).toString());
				System.out.println("-------------->"
						+ mostPopularPageValidation.dataRowNo);
				mostPopularPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						mostPopularPageValidation.currentExecutionMachineName,
						mostPopularPageValidation.currentTestCaseName);
				// mostPopularPageValidation.navigateTo("http://www.forbes.com/most-popular/");
				mostPopularPageValidation.verifyMostPopularPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile"))

		{
			TestStart("Most Popular validation", machineName, method.getName());
			mostPopularPageValidation = new MostPopularPageValidation(obj);
			for (int i = 0; i < mostPopularPageValidation.iterationCount.size(); i++) {
				mostPopularPageValidation.dataRowNo = Integer
						.parseInt(mostPopularPageValidation.iterationCount.get(
								i).toString());
				System.out.println("-------------->"
						+ mostPopularPageValidation.dataRowNo);
				mostPopularPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						mostPopularPageValidation.currentExecutionMachineName,
						mostPopularPageValidation.currentTestCaseName);
				// mostPopularPageValidation.navigateTo("http://www.forbes.com/most-popular/");
				mostPopularPageValidation.verifyMostPopularPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("iOS"))

		{
			TestStart("Most Popular validation", machineName, method.getName());
			mostPopularPageValidation = new MostPopularPageValidation(obj);
			for (int i = 0; i < mostPopularPageValidation.iterationCount.size(); i++) {
				mostPopularPageValidation.dataRowNo = Integer
						.parseInt(mostPopularPageValidation.iterationCount.get(
								i).toString());
				System.out.println("-------------->"
						+ mostPopularPageValidation.dataRowNo);
				mostPopularPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						mostPopularPageValidation.currentExecutionMachineName,
						mostPopularPageValidation.currentTestCaseName);
				// mostPopularPageValidation.navigateTo("http://www.forbes.com/most-popular/");
				mostPopularPageValidation.verifyMostPopularPage();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = mostPopularPageValidation.testCaseExecutionStatus;
		obj.testFailure = mostPopularPageValidation.testFailure;
		TestEnd();
	}

	/*
	 * @Test(alwaysRun = true)
	 * 
	 * @Parameters({ "selenium.machinename" }) public void
	 * TC10_MR_TemplateGalleryCheck(String machineName, Method method) {
	 * 
	 * if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop1")) {
	 * TestStart("Template Gallery Check", machineName, method.getName());
	 * gallerypagefunctionalitycheck = new GalleryPageFunctionalityCheck(obj);
	 * for (int i = 0; i < gallerypagefunctionalitycheck.iterationCount.size();
	 * i++) { gallerypagefunctionalitycheck.dataRowNo = Integer
	 * .parseInt(gallerypagefunctionalitycheck.iterationCount.get(i)
	 * .toString()); System.out.println("-------------->" +
	 * gallerypagefunctionalitycheck.dataRowNo);
	 * gallerypagefunctionalitycheck.writeHtmlTestStepReport(
	 * "<font size=4 style='color:blue'>DataSet:" + (i + 1) + "</font><br/>",
	 * gallerypagefunctionalitycheck.currentExecutionMachineName,
	 * gallerypagefunctionalitycheck.currentTestCaseName);
	 * gallerypagefunctionalitycheck
	 * .navigateTo("http://www.forbes.com/most-popular/");
	 * gallerypagefunctionalitycheck.verifyTemplateGallery(); } } else
	 * if(obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
	 * TestStart("Template Gallery Check", machineName, method.getName());
	 * gallerypagefunctionalitycheck = new GalleryPageFunctionalityCheck(obj);
	 * for (int i = 0; i < gallerypagefunctionalitycheck.iterationCount.size();
	 * i++) { gallerypagefunctionalitycheck.dataRowNo = Integer
	 * .parseInt(gallerypagefunctionalitycheck.iterationCount.get(i)
	 * .toString()); System.out.println("-------------->" +
	 * gallerypagefunctionalitycheck.dataRowNo);
	 * gallerypagefunctionalitycheck.writeHtmlTestStepReport(
	 * "<font size=4 style='color:blue'>DataSet:" + (i + 1) + "</font><br/>",
	 * gallerypagefunctionalitycheck.currentExecutionMachineName,
	 * gallerypagefunctionalitycheck.currentTestCaseName);
	 * gallerypagefunctionalitycheck
	 * .navigateTo("http://www.forbes.com/most-popular/");
	 * gallerypagefunctionalitycheck.verifyTemplateGallery(); } } else { throw
	 * new SkipException(""); } obj.testCaseExecutionStatus =
	 * gallerypagefunctionalitycheck.testCaseExecutionStatus;
	 * obj.testFailure=gallerypagefunctionalitycheck.testFailure; TestEnd(); }
	 */

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC008_MR_AngularGalleryCheck(String machineName, Method method)
			throws MalformedURLException, IOException {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("NP_MP_Gallery")) {
			TestStart("Angular Gallery Check", machineName, method.getName());
			angulargalleryfunctionalitycheck = new AngularGalleryFunctionalityCheck(
					obj);
			for (int i = 0; i < angulargalleryfunctionalitycheck.iterationCount
					.size(); i++) {
				angulargalleryfunctionalitycheck.dataRowNo = Integer
						.parseInt(angulargalleryfunctionalitycheck.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ angulargalleryfunctionalitycheck.dataRowNo);
				angulargalleryfunctionalitycheck
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>DataSet:"
										+ (i + 1) + "</font><br/>",
								angulargalleryfunctionalitycheck.currentExecutionMachineName,
								angulargalleryfunctionalitycheck.currentTestCaseName);
				angulargalleryfunctionalitycheck
						.navigateTo("https://www.forbes.com/pictures/ehmk45eielm/15-honda-accord/#7e41f3d511aa");
				angulargalleryfunctionalitycheck.verifyAngularGallery();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("Angular Gallery Check", machineName, method.getName());
			angulargalleryfunctionalitycheck = new AngularGalleryFunctionalityCheck(
					obj);
			for (int i = 0; i < angulargalleryfunctionalitycheck.iterationCount
					.size(); i++) {
				angulargalleryfunctionalitycheck.dataRowNo = Integer
						.parseInt(angulargalleryfunctionalitycheck.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ angulargalleryfunctionalitycheck.dataRowNo);
				angulargalleryfunctionalitycheck
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>DataSet:"
										+ (i + 1) + "</font><br/>",
								angulargalleryfunctionalitycheck.currentExecutionMachineName,
								angulargalleryfunctionalitycheck.currentTestCaseName);
				angulargalleryfunctionalitycheck
						.navigateTo("https://www.forbes.com/pictures/ehmk45eielm/15-honda-accord/#7e41f3d511aa");
				angulargalleryfunctionalitycheck.verifyAngularGallery();
			}
		} 
		 else if (obj.currentExecutionMachineName.startsWith("iOS")) {
				TestStart("Angular Gallery Check", machineName, method.getName());
				angulargalleryfunctionalitycheck = new AngularGalleryFunctionalityCheck(
						obj);
				for (int i = 0; i < angulargalleryfunctionalitycheck.iterationCount
						.size(); i++) {
					angulargalleryfunctionalitycheck.dataRowNo = Integer
							.parseInt(angulargalleryfunctionalitycheck.iterationCount
									.get(i).toString());
					System.out.println("-------------->"
							+ angulargalleryfunctionalitycheck.dataRowNo);
					angulargalleryfunctionalitycheck
							.writeHtmlTestStepReport(
									"<font size=4 style='color:blue'>DataSet:"
											+ (i + 1) + "</font><br/>",
									angulargalleryfunctionalitycheck.currentExecutionMachineName,
									angulargalleryfunctionalitycheck.currentTestCaseName);
					angulargalleryfunctionalitycheck
							.navigateTo("https://www.forbes.com/pictures/ehmk45eielm/15-honda-accord/#7e41f3d511aa");
					angulargalleryfunctionalitycheck.verifyAngularGallery();
				}
			}
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = angulargalleryfunctionalitycheck.testCaseExecutionStatus;
		obj.testFailure = angulargalleryfunctionalitycheck.testFailure;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC009_MR_VideoPage(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("Search_Video")) {
			TestStart("Video Page Validations", machineName, method.getName());
			videoPageValidation = new VideoPageValidation(obj);
			for (int i = 0; i < videoPageValidation.iterationCount.size(); i++) {
				videoPageValidation.dataRowNo = Integer
						.parseInt(videoPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ videoPageValidation.dataRowNo);
				videoPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						videoPageValidation.currentExecutionMachineName,
						videoPageValidation.currentTestCaseName);
				// videoPageValidation.navigateTo("http://www.forbes.com/video/");
				videoPageValidation.verifyVideoPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("Video Page Validations", machineName, method.getName());
			videoPageValidation = new VideoPageValidation(obj);
			for (int i = 0; i < videoPageValidation.iterationCount.size(); i++) {
				videoPageValidation.dataRowNo = Integer
						.parseInt(videoPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ videoPageValidation.dataRowNo);
				videoPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						videoPageValidation.currentExecutionMachineName,
						videoPageValidation.currentTestCaseName);
				// videoPageValidation.navigateTo("http://www.forbes.com/video/");
				videoPageValidation.verifyVideoPage();
			}
		} 
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("Video Page Validations", machineName, method.getName());
			videoPageValidation = new VideoPageValidation(obj);
			for (int i = 0; i < videoPageValidation.iterationCount.size(); i++) {
				videoPageValidation.dataRowNo = Integer
						.parseInt(videoPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ videoPageValidation.dataRowNo);
				videoPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						videoPageValidation.currentExecutionMachineName,
						videoPageValidation.currentTestCaseName);
				// videoPageValidation.navigateTo("http://www.forbes.com/video/");
				videoPageValidation.verifyVideoPage();
			}
		}
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = videoPageValidation.testCaseExecutionStatus;
		obj.testFailure = videoPageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC010_MR_CSFPageCheck(String machineName, Method method)
			throws MalformedURLException, IOException {
		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("CSF_CSR_List_Editors")) {
			TestStart("CSF Check", machineName, method.getName());
			csffunctionality = new CSFPageFunctionality(obj);
			for (int i = 0; i < csffunctionality.iterationCount.size(); i++) {
				csffunctionality.dataRowNo = Integer
						.parseInt(csffunctionality.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ csffunctionality.dataRowNo);
				csffunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						csffunctionality.currentExecutionMachineName,
						csffunctionality.currentTestCaseName);
				csffunctionality.navigateTo("http://www.forbes.com/actors");
				csffunctionality.verifyCSFpageContents();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("CSF Check", machineName, method.getName());
			csffunctionality = new CSFPageFunctionality(obj);
			for (int i = 0; i < csffunctionality.iterationCount.size(); i++) {
				csffunctionality.dataRowNo = Integer
						.parseInt(csffunctionality.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ csffunctionality.dataRowNo);
				csffunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						csffunctionality.currentExecutionMachineName,
						csffunctionality.currentTestCaseName);
				csffunctionality.navigateTo("http://www.forbes.com/actors");
				csffunctionality.verifyCSFpageContents();
			}
		} 
		
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("CSF Check", machineName, method.getName());
			csffunctionality = new CSFPageFunctionality(obj);
			for (int i = 0; i < csffunctionality.iterationCount.size(); i++) {
				csffunctionality.dataRowNo = Integer
						.parseInt(csffunctionality.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ csffunctionality.dataRowNo);
				csffunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						csffunctionality.currentExecutionMachineName,
						csffunctionality.currentTestCaseName);
				csffunctionality.navigateTo("http://www.forbes.com/actors");
				csffunctionality.verifyCSFpageContents();
			}
		}
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = csffunctionality.testCaseExecutionStatus;
		obj.testFailure = csffunctionality.testFailure;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC011_MR_CSRPageCheck(String machineName, Method method)
			throws MalformedURLException, IOException {
		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("CSF_CSR_List_Editors")) {
			TestStart("CSR Check", machineName, method.getName());
			csrfunctionality = new CSRPageFunctionality(obj);
			for (int i = 0; i < csrfunctionality.iterationCount.size(); i++) {
				csrfunctionality.dataRowNo = Integer
						.parseInt(csrfunctionality.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ csrfunctionality.dataRowNo);
				csrfunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						csrfunctionality.currentExecutionMachineName,
						csrfunctionality.currentTestCaseName);
				csrfunctionality.navigateTo("http://www.forbes.com/business");
				csrfunctionality.verifyCSRpageContents();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("CSR Check", machineName, method.getName());
			csrfunctionality = new CSRPageFunctionality(obj);
			for (int i = 0; i < csrfunctionality.iterationCount.size(); i++) {
				csrfunctionality.dataRowNo = Integer
						.parseInt(csrfunctionality.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ csrfunctionality.dataRowNo);
				csrfunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						csrfunctionality.currentExecutionMachineName,
						csrfunctionality.currentTestCaseName);
				csrfunctionality.navigateTo("http://www.forbes.com/business");
				csrfunctionality.verifyCSRpageContents();
			}
		} 
		
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("CSR Check", machineName, method.getName());
			csrfunctionality = new CSRPageFunctionality(obj);
			for (int i = 0; i < csrfunctionality.iterationCount.size(); i++) {
				csrfunctionality.dataRowNo = Integer
						.parseInt(csrfunctionality.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ csrfunctionality.dataRowNo);
				csrfunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						csrfunctionality.currentExecutionMachineName,
						csrfunctionality.currentTestCaseName);
				csrfunctionality.navigateTo("http://www.forbes.com/business");
				csrfunctionality.verifyCSRpageContents();
			}
		}
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = csrfunctionality.testCaseExecutionStatus;
		obj.testFailure = csrfunctionality.testFailure;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC012_MR_ProfilePage(String machineName, Method method) {
		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("CSF_CSR_List_Editors")) {
			TestStart("Lists Page Validations", machineName, method.getName());
			profilePageValidation = new ProfilePageValidation(obj);
			for (int i = 0; i < profilePageValidation.iterationCount.size(); i++) {
				profilePageValidation.dataRowNo = Integer
						.parseInt(profilePageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ profilePageValidation.dataRowNo);
				profilePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								profilePageValidation.currentExecutionMachineName,
						profilePageValidation.currentTestCaseName);
				// listsPageValidation.navigateTo("http://www.forbes.com/billionaires/");
				profilePageValidation.verifyProfilePage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {

			TestStart("Lists Page Validations", machineName, method.getName());
			profilePageValidation = new ProfilePageValidation(obj);
			for (int i = 0; i < profilePageValidation.iterationCount.size(); i++) {
				profilePageValidation.dataRowNo = Integer
						.parseInt(profilePageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ profilePageValidation.dataRowNo);
				profilePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								profilePageValidation.currentExecutionMachineName,
								profilePageValidation.currentTestCaseName);
				// listsPageValidation.navigateTo("http://www.forbes.com/billionaires/");
				profilePageValidation.verifyProfilePage();
			}
		} 
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {

			TestStart("Lists Page Validations", machineName, method.getName());
			profilePageValidation = new ProfilePageValidation(obj);
			for (int i = 0; i < profilePageValidation.iterationCount.size(); i++) {
				profilePageValidation.dataRowNo = Integer
						.parseInt(profilePageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ profilePageValidation.dataRowNo);
				profilePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								profilePageValidation.currentExecutionMachineName,
								profilePageValidation.currentTestCaseName);
				// listsPageValidation.navigateTo("http://www.forbes.com/billionaires/");
				profilePageValidation.verifyProfilePage();
			}
		} 
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = profilePageValidation.testCaseExecutionStatus;
		obj.testFailure = profilePageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC013_MR_SearchPage(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("Search_Video")) {
			TestStart("Search Page Validations", machineName, method.getName());
			searchpagefunctionalityobj = new searchPageFunctionality(obj);
			for (int i = 0; i < searchpagefunctionalityobj.iterationCount
					.size(); i++) {
				searchpagefunctionalityobj.dataRowNo = Integer
						.parseInt(searchpagefunctionalityobj.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ searchpagefunctionalityobj.dataRowNo);
				searchpagefunctionalityobj.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						searchpagefunctionalityobj.currentExecutionMachineName,
						searchpagefunctionalityobj.currentTestCaseName);
				searchpagefunctionalityobj.navigateTo("http://www.forbes.com");
				searchpagefunctionalityobj.verifySearchpageContents();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {

			TestStart("Search Page Validations", machineName, method.getName());
			searchpagefunctionalityobj = new searchPageFunctionality(obj);
			for (int i = 0; i < searchpagefunctionalityobj.iterationCount
					.size(); i++) {
				searchpagefunctionalityobj.dataRowNo = Integer
						.parseInt(searchpagefunctionalityobj.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ searchpagefunctionalityobj.dataRowNo);
				searchpagefunctionalityobj.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						searchpagefunctionalityobj.currentExecutionMachineName,
						searchpagefunctionalityobj.currentTestCaseName);
				searchpagefunctionalityobj.navigateTo("http://www.forbes.com");
				searchpagefunctionalityobj.verifySearchpageContents();
			}
		}
		 else if (obj.currentExecutionMachineName.startsWith("iOS")) {

				TestStart("Search Page Validations", machineName, method.getName());
				searchpagefunctionalityobj = new searchPageFunctionality(obj);
				for (int i = 0; i < searchpagefunctionalityobj.iterationCount
						.size(); i++) {
					searchpagefunctionalityobj.dataRowNo = Integer
							.parseInt(searchpagefunctionalityobj.iterationCount
									.get(i).toString());
					System.out.println("-------------->"
							+ searchpagefunctionalityobj.dataRowNo);
					searchpagefunctionalityobj.writeHtmlTestStepReport(
							"<font size=4 style='color:blue'>Forbes:" + (i + 1)
									+ "</font><br/>",
							searchpagefunctionalityobj.currentExecutionMachineName,
							searchpagefunctionalityobj.currentTestCaseName);
					searchpagefunctionalityobj.navigateTo("http://www.forbes.com");
					searchpagefunctionalityobj.verifySearchpageContents();
				}
			} 
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = searchpagefunctionalityobj.testCaseExecutionStatus;
		obj.testFailure = searchpagefunctionalityobj.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC014_MR_EditorsPickPage(String machineName, Method method) {
		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("CSF_CSR_List_Editors")) {
			TestStart("Editors Pick Page Validations", machineName,
					method.getName());
			editorspickcheck = new EditorsPickCheck(obj);
			for (int i = 0; i < editorspickcheck.iterationCount.size(); i++) {
				editorspickcheck.dataRowNo = Integer
						.parseInt(editorspickcheck.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ editorspickcheck.dataRowNo);
				editorspickcheck.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						editorspickcheck.currentExecutionMachineName,
						editorspickcheck.currentTestCaseName);
				editorspickcheck
						.navigateTo("http://www.forbes.com/editors-picks/");
				editorspickcheck.verifyEditorsPickpageContents();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {

			TestStart("Editors pick Page Validations", machineName,
					method.getName());
			editorspickcheck = new EditorsPickCheck(obj);
			for (int i = 0; i < editorspickcheck.iterationCount.size(); i++) {
				editorspickcheck.dataRowNo = Integer
						.parseInt(editorspickcheck.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ editorspickcheck.dataRowNo);
				editorspickcheck.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						editorspickcheck.currentExecutionMachineName,
						editorspickcheck.currentTestCaseName);
				editorspickcheck
						.navigateTo("http://www.forbes.com/editors-picks/");
				editorspickcheck.verifyEditorsPickpageContents();
			}
		}
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {

			TestStart("Editors pick Page Validations", machineName,
					method.getName());
			editorspickcheck = new EditorsPickCheck(obj);
			for (int i = 0; i < editorspickcheck.iterationCount.size(); i++) {
				editorspickcheck.dataRowNo = Integer
						.parseInt(editorspickcheck.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ editorspickcheck.dataRowNo);
				editorspickcheck.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						editorspickcheck.currentExecutionMachineName,
						editorspickcheck.currentTestCaseName);
				editorspickcheck
						.navigateTo("http://www.forbes.com/editors-picks/");
				editorspickcheck.verifyEditorsPickpageContents();
			}
		}
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = editorspickcheck.testCaseExecutionStatus;
		obj.testFailure = editorspickcheck.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC015_MR_WelcomeArticlePage(String machineName, Method method) {
		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("WelcomeArticle_Gallery")) {
			TestStart("Welcome Article Page Validations", machineName,
					method.getName());
			welcomeArticlePageValidation = new WelcomeArticlePageValidation(obj);
			for (int i = 0; i < welcomeArticlePageValidation.iterationCount
					.size(); i++) {
				welcomeArticlePageValidation.dataRowNo = Integer
						.parseInt(welcomeArticlePageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ welcomeArticlePageValidation.dataRowNo);
				welcomeArticlePageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>Forbes:"
										+ (i + 1) + "</font><br/>",
								welcomeArticlePageValidation.currentExecutionMachineName,
								welcomeArticlePageValidation.currentTestCaseName);
				welcomeArticlePageValidation
						.navigateTo("http://www.google.co.in/?gfe_rd=cr&ei=rKq2V5yHFYbB8geiw7bQAQ&gws_rd=ssl#q=forbes.com/sites&tbm=nws");
				// welcomeArticlePageValidation.validateArticleWelcomePage();
				welcomeArticlePageValidation.validateArticleWelcomePage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {

			TestStart("Welcome Article Page Validations", machineName,
					method.getName());
			welcomeArticlePageValidation = new WelcomeArticlePageValidation(obj);
			for (int i = 0; i < welcomeArticlePageValidation.iterationCount
					.size(); i++) {
				welcomeArticlePageValidation.dataRowNo = Integer
						.parseInt(welcomeArticlePageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ welcomeArticlePageValidation.dataRowNo);
				welcomeArticlePageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>Forbes:"
										+ (i + 1) + "</font><br/>",
								welcomeArticlePageValidation.currentExecutionMachineName,
								welcomeArticlePageValidation.currentTestCaseName);
				welcomeArticlePageValidation
						.navigateTo("https://www.google.co.in/search?q=forbes.com/sites&prmd=nvi&source=lnms&tbm=nws&sa=X&ved=0ahUKEwitrp6itM3OAhXFKh4KHc8QC-gQ_AUIBygB&biw=360&bih=640");
				welcomeArticlePageValidation.validateArticleWelcomePage();
			}
		}
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {

			TestStart("Welcome Article Page Validations", machineName,
					method.getName());
			welcomeArticlePageValidation = new WelcomeArticlePageValidation(obj);
			for (int i = 0; i < welcomeArticlePageValidation.iterationCount
					.size(); i++) {
				welcomeArticlePageValidation.dataRowNo = Integer
						.parseInt(welcomeArticlePageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ welcomeArticlePageValidation.dataRowNo);
				welcomeArticlePageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>Forbes:"
										+ (i + 1) + "</font><br/>",
								welcomeArticlePageValidation.currentExecutionMachineName,
								welcomeArticlePageValidation.currentTestCaseName);
				welcomeArticlePageValidation
						.navigateTo("https://www.google.co.in/search?q=forbes.com/sites&prmd=nvi&source=lnms&tbm=nws&sa=X&ved=0ahUKEwitrp6itM3OAhXFKh4KHc8QC-gQ_AUIBygB&biw=360&bih=640");
				welcomeArticlePageValidation.validateArticleWelcomePage();
			}
		}
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = welcomeArticlePageValidation.testCaseExecutionStatus;
		obj.testFailure = welcomeArticlePageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC016_MR_WelcomeGalleryPage(String machineName, Method method) {
		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("WelcomeArticle_Gallery")) {
			TestStart("Welcome Gallery Page Validations", machineName,
					method.getName());
			welcomeArticlePageValidation = new WelcomeArticlePageValidation(obj);
			for (int i = 0; i < welcomeArticlePageValidation.iterationCount
					.size(); i++) {
				welcomeArticlePageValidation.dataRowNo = Integer
						.parseInt(welcomeArticlePageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ welcomeArticlePageValidation.dataRowNo);
				welcomeArticlePageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>Forbes:"
										+ (i + 1) + "</font><br/>",
								welcomeArticlePageValidation.currentExecutionMachineName,
								welcomeArticlePageValidation.currentTestCaseName);
				welcomeArticlePageValidation
						.navigateTo("http://www.google.co.in/?gfe_rd=cr&ei=rKq2V5yHFYbB8geiw7bQAQ&gws_rd=ssl#tbm=nws&q=forbes.com%2Fpictures");
				welcomeArticlePageValidation.validateLatestGallery();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {

			TestStart("Welcome Gallery Page Validations", machineName,
					method.getName());
			welcomeArticlePageValidation = new WelcomeArticlePageValidation(obj);
			for (int i = 0; i < welcomeArticlePageValidation.iterationCount
					.size(); i++) {
				welcomeArticlePageValidation.dataRowNo = Integer
						.parseInt(welcomeArticlePageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ welcomeArticlePageValidation.dataRowNo);
				welcomeArticlePageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>Forbes:"
										+ (i + 1) + "</font><br/>",
								welcomeArticlePageValidation.currentExecutionMachineName,
								welcomeArticlePageValidation.currentTestCaseName);
				welcomeArticlePageValidation
						.navigateTo("http://www.google.co.in/search?q=forbes.com/pictures&prmd=niv&source=lnms&tbm=nws&sa=X&ved=0ahUKEwjbqNyGus3OAhVMox4KHfv3A8UQ_AUIBygB&biw=360&bih=640&dpr=3");
				welcomeArticlePageValidation.validateLatestGallery();
			}
		} 
		
		 else if (obj.currentExecutionMachineName.startsWith("iOS")) {

				TestStart("Welcome Gallery Page Validations", machineName,
						method.getName());
				welcomeArticlePageValidation = new WelcomeArticlePageValidation(obj);
				for (int i = 0; i < welcomeArticlePageValidation.iterationCount
						.size(); i++) {
					welcomeArticlePageValidation.dataRowNo = Integer
							.parseInt(welcomeArticlePageValidation.iterationCount
									.get(i).toString());
					System.out.println("-------------->"
							+ welcomeArticlePageValidation.dataRowNo);
					welcomeArticlePageValidation
							.writeHtmlTestStepReport(
									"<font size=4 style='color:blue'>Forbes:"
											+ (i + 1) + "</font><br/>",
									welcomeArticlePageValidation.currentExecutionMachineName,
									welcomeArticlePageValidation.currentTestCaseName);
					welcomeArticlePageValidation
							.navigateTo("https://www.google.co.in/search?q=forbes.com/pictures&prmd=niv&source=lnms&tbm=nws&sa=X&ved=0ahUKEwjbqNyGus3OAhVMox4KHfv3A8UQ_AUIBygB&biw=360&bih=640&dpr=3");
					welcomeArticlePageValidation.validateLatestGallery();
				}
			}
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = welcomeArticlePageValidation.testCaseExecutionStatus;
		obj.testFailure = welcomeArticlePageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC017_MR_404ReportPage(String machineName, Method method) {

		if (obj.currentExecutionMachineName.equalsIgnoreCase("TestingBucket")) {
			TestStart("Testing Buckets Page Validations", machineName,
					method.getName());
			report404Validation = new Report404Validation(obj);
			for (int i = 0; i < report404Validation.iterationCount.size(); i++) {
				report404Validation.dataRowNo = Integer
						.parseInt(report404Validation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ report404Validation.dataRowNo);
				report404Validation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						report404Validation.currentExecutionMachineName,
						report404Validation.currentTestCaseName);
				report404Validation.navigateTo("http://www.forbes.com/");
				report404Validation.validate404Report();
			}
		}
		/*
		 * else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		 * {
		 * 
		 * TestStart("Testing Buckets Page Validations", machineName,
		 * method.getName()); report404Validation = new
		 * Report404Validation(obj); for (int i = 0; i <
		 * report404Validation.iterationCount.size(); i++) {
		 * report404Validation.dataRowNo = Integer
		 * .parseInt(report404Validation.iterationCount.get(i) .toString());
		 * System.out.println("-------------->" +
		 * report404Validation.dataRowNo);
		 * report404Validation.writeHtmlTestStepReport(
		 * "<font size=4 style='color:blue'>Forbes:" + (i + 1) + "</font><br/>",
		 * report404Validation.currentExecutionMachineName,
		 * report404Validation.currentTestCaseName);
		 * report404Validation.navigateTo
		 * ("http://www.forbes.com/forbes/welcome/?view=beta-b");
		 * report404Validation.validate404Report(); } }
		 */
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = report404Validation.testCaseExecutionStatus;
		obj.testFailure = report404Validation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC027_MR_LoginHPArticlePage(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("LoginHPArticle")) {
			TestStart("Login HP Article Page Validations", machineName,
					method.getName());
			loginHPArticle = new LoginHPArticle(obj);
			for (int i = 0; i < loginHPArticle.iterationCount.size(); i++) {
				loginHPArticle.dataRowNo = Integer
						.parseInt(loginHPArticle.iterationCount.get(i)
								.toString());
				System.out
						.println("-------------->" + loginHPArticle.dataRowNo);
				loginHPArticle.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						loginHPArticle.currentExecutionMachineName,
						loginHPArticle.currentTestCaseName);
				loginHPArticle.navigateTo("http://www.forbes.com/");
				loginHPArticle.validateHPArticle();
			}
		}
		else if (obj.currentExecutionMachineName.equalsIgnoreCase("AndroidMobile")) {
			TestStart("Login HP Article Page Validations", machineName,
					method.getName());
			loginHPArticle = new LoginHPArticle(obj);
			for (int i = 0; i < loginHPArticle.iterationCount.size(); i++) {
				loginHPArticle.dataRowNo = Integer
						.parseInt(loginHPArticle.iterationCount.get(i)
								.toString());
				System.out
						.println("-------------->" + loginHPArticle.dataRowNo);
				loginHPArticle.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						loginHPArticle.currentExecutionMachineName,
						loginHPArticle.currentTestCaseName);
				loginHPArticle.navigateTo("http://www.forbes.com/");
				loginHPArticle.validateHPArticle();
			}
		} 
			
			else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = loginHPArticle.testCaseExecutionStatus;
		obj.testFailure = loginHPArticle.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC018_MR_LoginPage(String machineName, Method method) {

		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {
			TestStart("Login Page Validations", machineName, method.getName());
			loginPageValidation = new LoginPageValidation(obj);
			for (int i = 0; i < loginPageValidation.iterationCount.size(); i++) {
				loginPageValidation.dataRowNo = Integer
						.parseInt(loginPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ loginPageValidation.dataRowNo);
				loginPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						loginPageValidation.currentExecutionMachineName,
						loginPageValidation.currentTestCaseName);
				loginPageValidation.navigateTo("http://www.forbes.com/");
				loginPageValidation.validateLoginPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {

			TestStart("Login Page Validations", machineName, method.getName());
			loginPageValidation = new LoginPageValidation(obj);
			for (int i = 0; i < loginPageValidation.iterationCount.size(); i++) {
				loginPageValidation.dataRowNo = Integer
						.parseInt(loginPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ loginPageValidation.dataRowNo);
				loginPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						loginPageValidation.currentExecutionMachineName,
						loginPageValidation.currentTestCaseName);
				loginPageValidation
						.navigateTo("http://www.forbes.com/home_usa/");
				loginPageValidation.validateLoginPage();
			}
		}
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {

			TestStart("Login Page Validations", machineName, method.getName());
			loginPageValidation = new LoginPageValidation(obj);
			for (int i = 0; i < loginPageValidation.iterationCount.size(); i++) {
				loginPageValidation.dataRowNo = Integer
						.parseInt(loginPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ loginPageValidation.dataRowNo);
				loginPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						loginPageValidation.currentExecutionMachineName,
						loginPageValidation.currentTestCaseName);
				loginPageValidation
						.navigateTo("http://www.forbes.com/home_usa/");
				loginPageValidation.validateLoginPage();
			}
		}
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = loginPageValidation.testCaseExecutionStatus;
		obj.testFailure = loginPageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC019_MR_SignUpPage(String machineName, Method method) {

		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {
			TestStart("SignUp Page Validations", machineName, method.getName());
			signUpValidation = new SignUpValidation(obj);
			for (int i = 0; i < signUpValidation.iterationCount.size(); i++) {
				signUpValidation.dataRowNo = Integer
						.parseInt(signUpValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ signUpValidation.dataRowNo);
				signUpValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						signUpValidation.currentExecutionMachineName,
						signUpValidation.currentTestCaseName);
				signUpValidation.navigateTo("http://www.forbes.com/home_usa/");
				signUpValidation.validateSignUpPage();
			}
		} 
		
		else if (obj.currentExecutionMachineName
				.equalsIgnoreCase("AndroidMobile")) {
			TestStart("SignUp Page Validations", machineName, method.getName());
			signUpValidation = new SignUpValidation(obj);
			for (int i = 0; i < signUpValidation.iterationCount.size(); i++) {
				signUpValidation.dataRowNo = Integer
						.parseInt(signUpValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ signUpValidation.dataRowNo);
				signUpValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						signUpValidation.currentExecutionMachineName,
						signUpValidation.currentTestCaseName);
				signUpValidation.navigateTo("http://www.forbes.com/home_usa/");
				signUpValidation.validateSignUpPage();
			}
		}
		
		else if (obj.currentExecutionMachineName
				.equalsIgnoreCase("iOS")) {
			TestStart("SignUp Page Validations", machineName, method.getName());
			signUpValidation = new SignUpValidation(obj);
			for (int i = 0; i < signUpValidation.iterationCount.size(); i++) {
				signUpValidation.dataRowNo = Integer
						.parseInt(signUpValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ signUpValidation.dataRowNo);
				signUpValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						signUpValidation.currentExecutionMachineName,
						signUpValidation.currentTestCaseName);
				signUpValidation.navigateTo("http://www.forbes.com/home_usa/");
				signUpValidation.validateSignUpPage();
			}
		}
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = signUpValidation.testCaseExecutionStatus;
		obj.testFailure = signUpValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC020_MR_SocialLoginPage(String machineName, Method method) {

		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {
			TestStart("Social Login Page Validations", machineName,
					method.getName());
			socialLoginPageValidation = new SocialLoginPageValidation(obj);
			for (int i = 0; i < socialLoginPageValidation.iterationCount.size(); i++) {
				socialLoginPageValidation.dataRowNo = Integer
						.parseInt(socialLoginPageValidation.iterationCount.get(
								i).toString());
				System.out.println("-------------->"
						+ socialLoginPageValidation.dataRowNo);
				socialLoginPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						socialLoginPageValidation.currentExecutionMachineName,
						socialLoginPageValidation.currentTestCaseName);
				socialLoginPageValidation
						.navigateTo("http://www.forbes.com/home_usa/");
				socialLoginPageValidation.validateSocialLoginPage();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = socialLoginPageValidation.testCaseExecutionStatus;
		obj.testFailure = socialLoginPageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC021_MR_AMPPage(String machineName, Method method) {

		if (obj.currentExecutionMachineName.equalsIgnoreCase("AMP")) {
			TestStart("AMP Page Validations", machineName, method.getName());
			amppagevalidation = new AmpPageValidation(obj);
			for (int i = 0; i < amppagevalidation.iterationCount.size(); i++) {
				amppagevalidation.dataRowNo = Integer
						.parseInt(amppagevalidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ amppagevalidation.dataRowNo);
				amppagevalidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						amppagevalidation.currentExecutionMachineName,
						amppagevalidation.currentTestCaseName);
				amppagevalidation.navigateTo("http://validator.ampproject.org");
				amppagevalidation.verifyAMPpageContents();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = amppagevalidation.testCaseExecutionStatus;
		obj.testFailure = amppagevalidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC022_MR_SFPage(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("SFCheck")) {
			TestStart("Special Features Page Validations", machineName,
					method.getName());
			colehaanfunctionality = new colehaanCSFFunctionality(obj);
			for (int i = 0; i < colehaanfunctionality.iterationCount.size(); i++) {
				colehaanfunctionality.dataRowNo = Integer
						.parseInt(colehaanfunctionality.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ colehaanfunctionality.dataRowNo);
				colehaanfunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						colehaanfunctionality.currentExecutionMachineName,
						colehaanfunctionality.currentTestCaseName);
				colehaanfunctionality
						.navigateTo("http://www.forbes.com/colehaan/daring-to-step-forward/");
				colehaanfunctionality.verifySFpageContents();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = colehaanfunctionality.testCaseExecutionStatus;
		obj.testFailure = colehaanfunctionality.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC023_MR_DellSFPage(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("SFCheck")) {
			TestStart("Special Features Page Validations", machineName,
					method.getName());
			dellfunctionality = new dellSFFunctionality(obj);
			for (int i = 0; i < colehaanfunctionality.iterationCount.size(); i++) {
				dellfunctionality.dataRowNo = Integer
						.parseInt(dellfunctionality.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ dellfunctionality.dataRowNo);
				dellfunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						dellfunctionality.currentExecutionMachineName,
						dellfunctionality.currentTestCaseName);
				dellfunctionality
						.navigateTo("http://www.forbes.com/dell/cities-transformed");
				dellfunctionality.verifydellSFpageContents();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = dellfunctionality.testCaseExecutionStatus;
		obj.testFailure = dellfunctionality.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC024_MR_JohnHancockSFPage(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("SFCheck")) {
			TestStart("Special Features Page Validations", machineName,
					method.getName());
			johnhancockfunctionality = new johnhancockSFFunctionality(obj);
			for (int i = 0; i < johnhancockfunctionality.iterationCount.size(); i++) {
				johnhancockfunctionality.dataRowNo = Integer
						.parseInt(johnhancockfunctionality.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ johnhancockfunctionality.dataRowNo);
				johnhancockfunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						johnhancockfunctionality.currentExecutionMachineName,
						johnhancockfunctionality.currentTestCaseName);
				johnhancockfunctionality
						.navigateTo("http://www.forbes.com/johnhancock/in-a-lifetime-healthcare/");
				johnhancockfunctionality.verifyjohnhancockContentsInDesktop();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = johnhancockfunctionality.testCaseExecutionStatus;
		obj.testFailure = johnhancockfunctionality.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC025_MR_OppenheimerFundsPage(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("SFCheck")) {
			TestStart("Special Features Page Validations", machineName,
					method.getName());
			oppenheimerfunctionality = new oppenheimerFunctionality(obj);
			for (int i = 0; i < oppenheimerfunctionality.iterationCount.size(); i++) {
				oppenheimerfunctionality.dataRowNo = Integer
						.parseInt(oppenheimerfunctionality.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ oppenheimerfunctionality.dataRowNo);
				oppenheimerfunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						oppenheimerfunctionality.currentExecutionMachineName,
						oppenheimerfunctionality.currentTestCaseName);
				oppenheimerfunctionality
						.navigateTo("http://www.forbes.com/oppenheimerfunds/the-upside");
				oppenheimerfunctionality.verifyOppenmhiemerSFpageContents();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = oppenheimerfunctionality.testCaseExecutionStatus;
		obj.testFailure = oppenheimerfunctionality.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC026_MR_KPMGSFPage(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("SFCheck")) {
			TestStart("Special Features Page Validations", machineName,
					method.getName());
			kpmgsffunctionality = new kpmgSFFunctionality(obj);
			for (int i = 0; i < kpmgsffunctionality.iterationCount.size(); i++) {
				kpmgsffunctionality.dataRowNo = Integer
						.parseInt(kpmgsffunctionality.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ kpmgsffunctionality.dataRowNo);
				kpmgsffunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						kpmgsffunctionality.currentExecutionMachineName,
						kpmgsffunctionality.currentTestCaseName);
				kpmgsffunctionality
						.navigateTo("http://www.forbes.com/kpmg/the-great-rewrite/#/");
				kpmgsffunctionality.verifyKPMGSFpageContents();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = kpmgsffunctionality.testCaseExecutionStatus;
		obj.testFailure = kpmgsffunctionality.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC023_MR_GroupContributorPage(String machineName, Method method) {

		if (obj.currentExecutionMachineName.equalsIgnoreCase("Cont_BV")) {
			TestStart("Group Contributor Page Validations", machineName,
					method.getName());
			groupContributorPageValidation = new GroupContributorPageValidation(
					obj);
			for (int i = 0; i < groupContributorPageValidation.iterationCount
					.size(); i++) {
				groupContributorPageValidation.dataRowNo = Integer
						.parseInt(groupContributorPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ groupContributorPageValidation.dataRowNo);
				groupContributorPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>Forbes:"
										+ (i + 1) + "</font><br/>",
								groupContributorPageValidation.currentExecutionMachineName,
								groupContributorPageValidation.currentTestCaseName);
				groupContributorPageValidation
						.navigateTo("http://www.forbes.com/sites/sportsmoney/");
				groupContributorPageValidation.validateGroupContributorPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {

			TestStart("Group Contributor Page Validations---Mobile",
					machineName, method.getName());
			groupContributorPageValidation = new GroupContributorPageValidation(
					obj);
			for (int i = 0; i < groupContributorPageValidation.iterationCount
					.size(); i++) {
				groupContributorPageValidation.dataRowNo = Integer
						.parseInt(groupContributorPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ groupContributorPageValidation.dataRowNo);
				groupContributorPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>Forbes:"
										+ (i + 1) + "</font><br/>",
								groupContributorPageValidation.currentExecutionMachineName,
								groupContributorPageValidation.currentTestCaseName);
				groupContributorPageValidation
						.navigateTo("http://www.forbes.com/sites/sportsmoney/");
				groupContributorPageValidation.validateGroupContributorPage();
			}
		}
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {

			TestStart("Group Contributor Page Validations---Mobile",
					machineName, method.getName());
			groupContributorPageValidation = new GroupContributorPageValidation(
					obj);
			for (int i = 0; i < groupContributorPageValidation.iterationCount
					.size(); i++) {
				groupContributorPageValidation.dataRowNo = Integer
						.parseInt(groupContributorPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ groupContributorPageValidation.dataRowNo);
				groupContributorPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>Forbes:"
										+ (i + 1) + "</font><br/>",
								groupContributorPageValidation.currentExecutionMachineName,
								groupContributorPageValidation.currentTestCaseName);
				groupContributorPageValidation
						.navigateTo("http://www.forbes.com/sites/sportsmoney/");
				groupContributorPageValidation.validateGroupContributorPage();
			}
		}
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = groupContributorPageValidation.testCaseExecutionStatus;
		obj.testFailure = groupContributorPageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC028_MR_PodcastsPage(String machineName, Method method)
			throws Exception {

		if (obj.currentExecutionMachineName.equalsIgnoreCase("NP_MP_Gallery")) {
			TestStart("Podcasts Page Validations", machineName,
					method.getName());
			podCastsPageValidation = new PodCastsPageValidation(obj);
			for (int i = 0; i < podCastsPageValidation.iterationCount.size(); i++) {
				podCastsPageValidation.dataRowNo = Integer
						.parseInt(podCastsPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ podCastsPageValidation.dataRowNo);
				podCastsPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						podCastsPageValidation.currentExecutionMachineName,
						podCastsPageValidation.currentTestCaseName);
				podCastsPageValidation
						.navigateTo("http://www.forbes.com/podcasts/");
				podCastsPageValidation.verifyPodcastsPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("Podcasts Page Validations", machineName,
					method.getName());
			podCastsPageValidation = new PodCastsPageValidation(obj);
			for (int i = 0; i < podCastsPageValidation.iterationCount.size(); i++) {
				podCastsPageValidation.dataRowNo = Integer
						.parseInt(podCastsPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ podCastsPageValidation.dataRowNo);
				podCastsPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						podCastsPageValidation.currentExecutionMachineName,
						podCastsPageValidation.currentTestCaseName);
				podCastsPageValidation
						.navigateTo("http://www.forbes.com/podcasts/");
				podCastsPageValidation.verifyPodcastsPage();
			}
		}
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("Podcasts Page Validations", machineName,
					method.getName());
			podCastsPageValidation = new PodCastsPageValidation(obj);
			for (int i = 0; i < podCastsPageValidation.iterationCount.size(); i++) {
				podCastsPageValidation.dataRowNo = Integer
						.parseInt(podCastsPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ podCastsPageValidation.dataRowNo);
				podCastsPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						podCastsPageValidation.currentExecutionMachineName,
						podCastsPageValidation.currentTestCaseName);
				podCastsPageValidation
						.navigateTo("http://www.forbes.com/podcasts/");
				podCastsPageValidation.verifyPodcastsPage();
			}
		} 
		
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = podCastsPageValidation.testCaseExecutionStatus;
		obj.testFailure = podCastsPageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC34_MR_CommunityVoicePage(String machineName, Method method) {

		if (obj.currentExecutionMachineName.equalsIgnoreCase("Cont_BV")) {
			TestStart("Community Voice Page Validations", machineName,
					method.getName());
			communityVoiceValidation = new CommunityVoiceValidation(obj);
			for (int i = 0; i < communityVoiceValidation.iterationCount.size(); i++) {
				communityVoiceValidation.dataRowNo = Integer
						.parseInt(communityVoiceValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ communityVoiceValidation.dataRowNo);
				communityVoiceValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						communityVoiceValidation.currentExecutionMachineName,
						communityVoiceValidation.currentTestCaseName);
				communityVoiceValidation
						.navigateTo("http://www.forbes.com/sites/yec/");
				communityVoiceValidation.validateCommunityVoicePage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {

			TestStart("Community Voice Page Validations", machineName,
					method.getName());
			communityVoiceValidation = new CommunityVoiceValidation(obj);
			for (int i = 0; i < communityVoiceValidation.iterationCount.size(); i++) {
				communityVoiceValidation.dataRowNo = Integer
						.parseInt(communityVoiceValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ communityVoiceValidation.dataRowNo);
				communityVoiceValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						communityVoiceValidation.currentExecutionMachineName,
						communityVoiceValidation.currentTestCaseName);
				communityVoiceValidation
						.navigateTo("http://www.forbes.com/sites/yec/");
				communityVoiceValidation.validateCommunityVoicePage();
			}
		} 
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {

			TestStart("Community Voice Page Validations", machineName,
					method.getName());
			communityVoiceValidation = new CommunityVoiceValidation(obj);
			for (int i = 0; i < communityVoiceValidation.iterationCount.size(); i++) {
				communityVoiceValidation.dataRowNo = Integer
						.parseInt(communityVoiceValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ communityVoiceValidation.dataRowNo);
				communityVoiceValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						communityVoiceValidation.currentExecutionMachineName,
						communityVoiceValidation.currentTestCaseName);
				communityVoiceValidation
						.navigateTo("http://www.forbes.com/sites/yec/");
				communityVoiceValidation.validateCommunityVoicePage();
			}
		} 
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = communityVoiceValidation.testCaseExecutionStatus;
		obj.testFailure = communityVoiceValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC035_MR_BVPage_SAP(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("Cont_BV")) {
			TestStart("SAP BrandVoice Page validation", machineName,
					method.getName());
			bvpagefunctions = new BVPageFunctions(obj);
			for (int i = 0; i < bvpagefunctions.iterationCount.size(); i++) {
				bvpagefunctions.dataRowNo = Integer
						.parseInt(bvpagefunctions.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ bvpagefunctions.dataRowNo);
				bvpagefunctions.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>" + (i + 1)
								+ "</font><br/>",
						bvpagefunctions.currentExecutionMachineName,
						bvpagefunctions.currentTestCaseName);
				bvpagefunctions.navigateTo("http://www.forbes.com/sites/sap/");
				bvpagefunctions.verifyBVpageContents();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("Sap BrandVoice Page validation", machineName,
					method.getName());
			bvpagefunctions = new BVPageFunctions(obj);
			for (int i = 0; i < bvpagefunctions.iterationCount.size(); i++) {
				bvpagefunctions.dataRowNo = Integer
						.parseInt(bvpagefunctions.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ bvpagefunctions.dataRowNo);
				bvpagefunctions.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>" + (i + 1)
								+ "</font><br/>",
						bvpagefunctions.currentExecutionMachineName,
						bvpagefunctions.currentTestCaseName);
				bvpagefunctions.navigateTo("http://www.forbes.com/sites/sap/");
				bvpagefunctions.verifyBVpageContents();
			}
		} 
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("Sap BrandVoice Page validation", machineName,
					method.getName());
			bvpagefunctions = new BVPageFunctions(obj);
			for (int i = 0; i < bvpagefunctions.iterationCount.size(); i++) {
				bvpagefunctions.dataRowNo = Integer
						.parseInt(bvpagefunctions.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ bvpagefunctions.dataRowNo);
				bvpagefunctions.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>" + (i + 1)
								+ "</font><br/>",
						bvpagefunctions.currentExecutionMachineName,
						bvpagefunctions.currentTestCaseName);
				bvpagefunctions.navigateTo("http://www.forbes.com/sites/sap/");
				bvpagefunctions.verifyBVpageContents();
			}
		} 
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = bvpagefunctions.testCaseExecutionStatus;
		obj.testFailure = bvpagefunctions.testFailure;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC036_MR_BVPage_ORACLE(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("Cont_BV")) {
			TestStart("ORACLE BrandVoice Page validation", machineName,
					method.getName());
			bvpagefunctions = new BVPageFunctions(obj);
			for (int i = 0; i < bvpagefunctions.iterationCount.size(); i++) {
				bvpagefunctions.dataRowNo = Integer
						.parseInt(bvpagefunctions.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ bvpagefunctions.dataRowNo);
				bvpagefunctions.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>" + (i + 1)
								+ "</font><br/>",
						bvpagefunctions.currentExecutionMachineName,
						bvpagefunctions.currentTestCaseName);
				bvpagefunctions
						.navigateTo("http://www.forbes.com/sites/oracle/");
				bvpagefunctions.verifyBVpageContents();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("Oracle BrandVoice Page validation", machineName,
					method.getName());
			bvpagefunctions = new BVPageFunctions(obj);
			for (int i = 0; i < bvpagefunctions.iterationCount.size(); i++) {
				bvpagefunctions.dataRowNo = Integer
						.parseInt(bvpagefunctions.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ bvpagefunctions.dataRowNo);
				bvpagefunctions.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>" + (i + 1)
								+ "</font><br/>",
						bvpagefunctions.currentExecutionMachineName,
						bvpagefunctions.currentTestCaseName);
				bvpagefunctions
						.navigateTo("http://www.forbes.com/sites/oracle/");
				bvpagefunctions.verifyBVpageContents();
			}
		}
		 else if (obj.currentExecutionMachineName.startsWith("iOS")) {
				TestStart("Oracle BrandVoice Page validation", machineName,
						method.getName());
				bvpagefunctions = new BVPageFunctions(obj);
				for (int i = 0; i < bvpagefunctions.iterationCount.size(); i++) {
					bvpagefunctions.dataRowNo = Integer
							.parseInt(bvpagefunctions.iterationCount.get(i)
									.toString());
					System.out.println("-------------->"
							+ bvpagefunctions.dataRowNo);
					bvpagefunctions.writeHtmlTestStepReport(
							"<font size=4 style='color:blue'>" + (i + 1)
									+ "</font><br/>",
							bvpagefunctions.currentExecutionMachineName,
							bvpagefunctions.currentTestCaseName);
					bvpagefunctions
							.navigateTo("http://www.forbes.com/sites/oracle/");
					bvpagefunctions.verifyBVpageContents();
				}
			}
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = bvpagefunctions.testCaseExecutionStatus;
		obj.testFailure = bvpagefunctions.testFailure;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC029_MR_LevelUpPage(String machineName, Method method) {

		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {
			TestStart("LevelUp Page Validations", machineName, method.getName());
			levelUpPageValidation = new LevelUpPageValidation(obj);
			for (int i = 0; i < levelUpPageValidation.iterationCount.size(); i++) {
				levelUpPageValidation.dataRowNo = Integer
						.parseInt(levelUpPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ levelUpPageValidation.dataRowNo);
				levelUpPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						levelUpPageValidation.currentExecutionMachineName,
						levelUpPageValidation.currentTestCaseName);
				levelUpPageValidation
						.navigateTo("http://www.forbes.com/sites/levelup/?nowelcome");
				levelUpPageValidation.validateLevelUpPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("LevelUp Page Validations", machineName, method.getName());
			levelUpPageValidation = new LevelUpPageValidation(obj);
			for (int i = 0; i < levelUpPageValidation.iterationCount.size(); i++) {
				levelUpPageValidation.dataRowNo = Integer
						.parseInt(levelUpPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ levelUpPageValidation.dataRowNo);
				levelUpPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						levelUpPageValidation.currentExecutionMachineName,
						levelUpPageValidation.currentTestCaseName);
				levelUpPageValidation
						.navigateTo("http://www.forbes.com/sites/levelup/?nowelcome");
				levelUpPageValidation.validateLevelUpPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("LevelUp Page Validations", machineName, method.getName());
			levelUpPageValidation = new LevelUpPageValidation(obj);
			for (int i = 0; i < levelUpPageValidation.iterationCount.size(); i++) {
				levelUpPageValidation.dataRowNo = Integer
						.parseInt(levelUpPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ levelUpPageValidation.dataRowNo);
				levelUpPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						levelUpPageValidation.currentExecutionMachineName,
						levelUpPageValidation.currentTestCaseName);
				levelUpPageValidation
						.navigateTo("http://www.forbes.com/sites/levelup/?nowelcome");
				levelUpPageValidation.validateLevelUpPage();
			}
		}

		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = levelUpPageValidation.testCaseExecutionStatus;
		obj.testFailure = levelUpPageValidation.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC037_MR_MostPopularHashPage(String machineName, Method method)
			throws Exception {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("NP_MP_Gallery")) {
			TestStart("Most Popular HashTag Page validation", machineName,
					method.getName());
			mostPopularHashTagPageValidation = new MostPopularHashTagPageValidation(
					obj);
			for (int i = 0; i < mostPopularHashTagPageValidation.iterationCount
					.size(); i++) {
				mostPopularHashTagPageValidation.dataRowNo = Integer
						.parseInt(mostPopularHashTagPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ mostPopularHashTagPageValidation.dataRowNo);
				mostPopularHashTagPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>DataSet:"
										+ (i + 1) + "</font><br/>",
								mostPopularHashTagPageValidation.currentExecutionMachineName,
								mostPopularHashTagPageValidation.currentTestCaseName);
				mostPopularHashTagPageValidation
						.navigateTo("http://www.forbes.com/most-popular");
				mostPopularHashTagPageValidation.verifyMostPopularHashTagPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("BrandVoice Page validation", machineName,
					method.getName());
			mostPopularHashTagPageValidation = new MostPopularHashTagPageValidation(
					obj);
			for (int i = 0; i < mostPopularHashTagPageValidation.iterationCount
					.size(); i++) {
				mostPopularHashTagPageValidation.dataRowNo = Integer
						.parseInt(mostPopularHashTagPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ mostPopularHashTagPageValidation.dataRowNo);
				mostPopularHashTagPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>DataSet:"
										+ (i + 1) + "</font><br/>",
								mostPopularHashTagPageValidation.currentExecutionMachineName,
								mostPopularHashTagPageValidation.currentTestCaseName);
				mostPopularHashTagPageValidation
						.navigateTo("http://www.forbes.com/most-popular");
				mostPopularHashTagPageValidation.verifyMostPopularHashTagPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("BrandVoice Page validation", machineName,
					method.getName());
			mostPopularHashTagPageValidation = new MostPopularHashTagPageValidation(
					obj);
			for (int i = 0; i < mostPopularHashTagPageValidation.iterationCount
					.size(); i++) {
				mostPopularHashTagPageValidation.dataRowNo = Integer
						.parseInt(mostPopularHashTagPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ mostPopularHashTagPageValidation.dataRowNo);
				mostPopularHashTagPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>DataSet:"
										+ (i + 1) + "</font><br/>",
								mostPopularHashTagPageValidation.currentExecutionMachineName,
								mostPopularHashTagPageValidation.currentTestCaseName);
				mostPopularHashTagPageValidation
						.navigateTo("http://www.forbes.com/most-popular");
				mostPopularHashTagPageValidation.verifyMostPopularHashTagPage();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = mostPopularHashTagPageValidation.testCaseExecutionStatus;
		obj.testFailure = mostPopularHashTagPageValidation.testFailure;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC038_MR_BVContributorPage(String machineName, Method method)
			throws Exception {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("Cont_BV")) {
			TestStart("BrandVoice contributor Page validation", machineName,
					method.getName());
			bvContributorPageValidation = new BVContributorPageValidation(obj);
			for (int i = 0; i < bvContributorPageValidation.iterationCount
					.size(); i++) {
				bvContributorPageValidation.dataRowNo = Integer
						.parseInt(bvContributorPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ bvContributorPageValidation.dataRowNo);
				bvContributorPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>DataSet:"
										+ (i + 1) + "</font><br/>",
								bvContributorPageValidation.currentExecutionMachineName,
								bvContributorPageValidation.currentTestCaseName);
				bvContributorPageValidation
						.navigateTo("http://www.forbes.com/sites/northwesternmutual/people/brentschutte/");
				bvContributorPageValidation.validateBVContributorPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("BrandVoice Contributor Page validation", machineName,
					method.getName());
			bvContributorPageValidation = new BVContributorPageValidation(obj);
			for (int i = 0; i < bvContributorPageValidation.iterationCount
					.size(); i++) {
				bvContributorPageValidation.dataRowNo = Integer
						.parseInt(bvContributorPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ bvContributorPageValidation.dataRowNo);
				bvContributorPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>DataSet:"
										+ (i + 1) + "</font><br/>",
								bvContributorPageValidation.currentExecutionMachineName,
								bvContributorPageValidation.currentTestCaseName);
				bvContributorPageValidation
						.navigateTo("http://www.forbes.com/sites/northwesternmutual/people/brentschutte/");
				bvContributorPageValidation.validateBVContributorPage();
			}
		} 
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("BrandVoice Contributor Page validation", machineName,
					method.getName());
			bvContributorPageValidation = new BVContributorPageValidation(obj);
			for (int i = 0; i < bvContributorPageValidation.iterationCount
					.size(); i++) {
				bvContributorPageValidation.dataRowNo = Integer
						.parseInt(bvContributorPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ bvContributorPageValidation.dataRowNo);
				bvContributorPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>DataSet:"
										+ (i + 1) + "</font><br/>",
								bvContributorPageValidation.currentExecutionMachineName,
								bvContributorPageValidation.currentTestCaseName);
				bvContributorPageValidation
						.navigateTo("http://www.forbes.com/sites/northwesternmutual/people/brentschutte/");
				bvContributorPageValidation.validateBVContributorPage();
			}
		}
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = bvContributorPageValidation.testCaseExecutionStatus;
		obj.testFailure = bvContributorPageValidation.testFailure;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC030_MR_SSLCertification(String machineName, Method method) {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("SSL")) {
			TestStart("SSL Certification Page Validations", machineName,
					method.getName());
			sSLCertificationValidation = new SSLCertificationValidation(obj);
			for (int i = 0; i < sSLCertificationValidation.iterationCount
					.size(); i++) {
				sSLCertificationValidation.dataRowNo = Integer
						.parseInt(sSLCertificationValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ sSLCertificationValidation.dataRowNo);
				sSLCertificationValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>" + (i + 1)
								+ "</font><br/>",
						sSLCertificationValidation.currentExecutionMachineName,
						sSLCertificationValidation.currentTestCaseName);

				sSLCertificationValidation.verifySSLCertification();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("SSL Certification Page Validations---Mobile",
					machineName, method.getName());
			sSLCertificationValidation = new SSLCertificationValidation(obj);
			for (int i = 0; i < sSLCertificationValidation.iterationCount
					.size(); i++) {
				sSLCertificationValidation.dataRowNo = Integer
						.parseInt(sSLCertificationValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ sSLCertificationValidation.dataRowNo);
				sSLCertificationValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						sSLCertificationValidation.currentExecutionMachineName,
						sSLCertificationValidation.currentTestCaseName);
				sSLCertificationValidation.verifySSLCertification();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = sSLCertificationValidation.testCaseExecutionStatus;
		obj.testFailure = sSLCertificationValidation.testFailure;
		TestEnd();

	}
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC031_MR_GADataLayerValidation(String machineName, Method method) {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Contributor_BrandVoice"))
		{
		TestStart("GA Datalayer Validations", machineName, method.getName());
		bvarticlegacheck = new bvArticleGACheck(obj);
		for (int i = 0; i < bvarticlegacheck.iterationCount.size(); i++) {
			bvarticlegacheck.dataRowNo = Integer
					.parseInt(bvarticlegacheck.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ bvarticlegacheck.dataRowNo);
			bvarticlegacheck.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>Forbes:" + (i + 1)
							+ "</font><br/>",
							bvarticlegacheck.currentExecutionMachineName,
							bvarticlegacheck.currentTestCaseName);
			
			bvarticlegacheck.verifyBVArticlePageDataLayerContents();
		}
		}
		 
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = bvarticlegacheck.testCaseExecutionStatus;
		obj.testFailure=bvarticlegacheck.testFailure;
		TestEnd();

	}
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC032_MR_ArticleGADataLayerValidation(String machineName, Method method) {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Welcome_Home_Article")){
			TestStart("GA Datalayer Validations", machineName, method.getName());
			articlegacheck = new articleGACheck(obj);
			for (int i = 0; i < articlegacheck.iterationCount.size(); i++) {
				articlegacheck.dataRowNo = Integer
						.parseInt(articlegacheck.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ articlegacheck.dataRowNo);
				articlegacheck.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								articlegacheck.currentExecutionMachineName,
								articlegacheck.currentTestCaseName);
				
				articlegacheck.verifyArticlePageDataLayerContents();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = articlegacheck.testCaseExecutionStatus;
		obj.testFailure=articlegacheck.testFailure;
		TestEnd();

	}
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC033_MR_WAGADataLayerValidation(String machineName, Method method) {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Welcome_Home_Article")){
			TestStart("GA Datalayer Validations", machineName, method.getName());
			wagacheck = new welcomeAdGACheck(obj);
			for (int i = 0; i < wagacheck.iterationCount.size(); i++) {
				wagacheck.dataRowNo = Integer
						.parseInt(wagacheck.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ wagacheck.dataRowNo);
				wagacheck.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								wagacheck.currentExecutionMachineName,
								wagacheck.currentTestCaseName);
				wagacheck.verifywWAPageFromGoogleDataLayerContents();
				wagacheck.verifyWApageGAContents();
				wagacheck.verifywWAArticlePageFromGoogleDataLayerContents();
			//	wagacheck.verifywWAGalleryPageFromGoogleDataLayerContents();
				
				wagacheck.verifywWAPageFromFBDataLayerContents();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = wagacheck.testCaseExecutionStatus;
		obj.testFailure=wagacheck.testFailure;
		TestEnd();

	}
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC040_MR_CSFGADataLayerValidation(String machineName, Method method) {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("CSF_CSR_List_Editors")){
			TestStart("GA Datalayer Validations", machineName, method.getName());
			csfgacheck = new csfGACheck(obj);
			for (int i = 0; i < csfgacheck.iterationCount.size(); i++) {
				csfgacheck.dataRowNo = Integer
						.parseInt(csfgacheck.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ csfgacheck.dataRowNo);
				csfgacheck.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								csfgacheck.currentExecutionMachineName,
								csfgacheck.currentTestCaseName);
				csfgacheck.verifyCsfPageDataLayerContents();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = csfgacheck.testCaseExecutionStatus;
		obj.testFailure=csfgacheck.testFailure;
		TestEnd();

	}
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC041_MR_CSRGADataLayerValidation(String machineName, Method method) {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("CSF_CSR_List_Editors")){
			TestStart("GA Datalayer Validations", machineName, method.getName());
			csrgacheck = new csrGACheck(obj);
			for (int i = 0; i < csrgacheck.iterationCount.size(); i++) {
				csrgacheck.dataRowNo = Integer
						.parseInt(csrgacheck.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ csrgacheck.dataRowNo);
				csrgacheck.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								csrgacheck.currentExecutionMachineName,
								csrgacheck.currentTestCaseName);
				csrgacheck.verifyCsrPageDataLayerContents();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = csrgacheck.testCaseExecutionStatus;
		obj.testFailure=csrgacheck.testFailure;
		TestEnd();

	}
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC042_MR_ContribPageGADataLayerValidation(String machineName, Method method) {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Contributor_BrandVoice")){
			TestStart("GA Datalayer Validations", machineName, method.getName());
			contribPagegacheck = new contribPageGACheck(obj);
			for (int i = 0; i < contribPagegacheck.iterationCount.size(); i++) {
				contribPagegacheck.dataRowNo = Integer
						.parseInt(contribPagegacheck.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ contribPagegacheck.dataRowNo);
				contribPagegacheck.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								contribPagegacheck.currentExecutionMachineName,
								contribPagegacheck.currentTestCaseName);
				contribPagegacheck.verifyContribPageDataLayerContents();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = contribPagegacheck.testCaseExecutionStatus;
		obj.testFailure=contribPagegacheck.testFailure;
		TestEnd();

	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC039_MR_ForbesOnTrumpPageValidation(String machineName,
			Method method) throws Exception {
		if (obj.currentExecutionMachineName.equalsIgnoreCase("Search_Video")) {
			TestStart("Forbes On Trump Page Validation", machineName,
					method.getName());
			forbesOnTrumpPageValidation = new ForbesOnTrumpPageValidation(obj);
			for (int i = 0; i < forbesOnTrumpPageValidation.iterationCount
					.size(); i++) {
				forbesOnTrumpPageValidation.dataRowNo = Integer
						.parseInt(forbesOnTrumpPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ forbesOnTrumpPageValidation.dataRowNo);
				forbesOnTrumpPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>DataSet:"
										+ (i + 1) + "</font><br/>",
								forbesOnTrumpPageValidation.currentExecutionMachineName,
								forbesOnTrumpPageValidation.currentTestCaseName);
				forbesOnTrumpPageValidation
						.navigateTo("http://www.forbes.com/forbes-on-trump/");
				forbesOnTrumpPageValidation.validateForbesOnTrumpPage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("Forbes On Trump Page validation For Mobile",
					machineName, method.getName());
			forbesOnTrumpPageValidation = new ForbesOnTrumpPageValidation(obj);
			for (int i = 0; i < forbesOnTrumpPageValidation.iterationCount
					.size(); i++) {
				forbesOnTrumpPageValidation.dataRowNo = Integer
						.parseInt(forbesOnTrumpPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ forbesOnTrumpPageValidation.dataRowNo);
				forbesOnTrumpPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>DataSet:"
										+ (i + 1) + "</font><br/>",
								forbesOnTrumpPageValidation.currentExecutionMachineName,
								forbesOnTrumpPageValidation.currentTestCaseName);
				forbesOnTrumpPageValidation
						.navigateTo("http://www.forbes.com/forbes-on-trump/");
				forbesOnTrumpPageValidation.validateForbesOnTrumpPage();
			}
		}
		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("Forbes On Trump Page validation For Mobile",
					machineName, method.getName());
			forbesOnTrumpPageValidation = new ForbesOnTrumpPageValidation(obj);
			for (int i = 0; i < forbesOnTrumpPageValidation.iterationCount
					.size(); i++) {
				forbesOnTrumpPageValidation.dataRowNo = Integer
						.parseInt(forbesOnTrumpPageValidation.iterationCount
								.get(i).toString());
				System.out.println("-------------->"
						+ forbesOnTrumpPageValidation.dataRowNo);
				forbesOnTrumpPageValidation
						.writeHtmlTestStepReport(
								"<font size=4 style='color:blue'>DataSet:"
										+ (i + 1) + "</font><br/>",
								forbesOnTrumpPageValidation.currentExecutionMachineName,
								forbesOnTrumpPageValidation.currentTestCaseName);
				forbesOnTrumpPageValidation
						.navigateTo("http://www.forbes.com/forbes-on-trump/");
				forbesOnTrumpPageValidation.validateForbesOnTrumpPage();
			}
		} 
		
		else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = forbesOnTrumpPageValidation.testCaseExecutionStatus;
		obj.testFailure = forbesOnTrumpPageValidation.testFailure;
		TestEnd();
	}
	
	
	
	
	

	
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC040_MR_BillionairesWelcomePage(String machineName, Method method)
			throws MalformedURLException {

		if (obj.currentExecutionMachineName
				.equalsIgnoreCase("CSF_CSR_List_Editors")) {
			TestStart("Billionaires Welcome page Validations", machineName, method.getName());
			billionairesWelcomePageValidation = new BillionairesWelcomePageValidation(obj);
			for (int i = 0; i < billionairesWelcomePageValidation.iterationCount.size(); i++) {

				billionairesWelcomePageValidation.dataRowNo = Integer
						.parseInt(billionairesWelcomePageValidation.iterationCount.get(i)
								.toString());
				billionairesWelcomePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								billionairesWelcomePageValidation.currentExecutionMachineName,
								billionairesWelcomePageValidation.currentTestCaseName);
				// homePageValidation.navigateTo("http://www.forbes.com");
				billionairesWelcomePageValidation.verifyBillionairesWelcomePage();
			}
		} else if (obj.currentExecutionMachineName.startsWith("AndroidMobile")) {
			TestStart("Billionaires Welcome page Validations", machineName, method.getName());
			billionairesWelcomePageValidation = new BillionairesWelcomePageValidation(obj);
			for (int i = 0; i < billionairesWelcomePageValidation.iterationCount.size(); i++) {

				billionairesWelcomePageValidation.dataRowNo = Integer
						.parseInt(billionairesWelcomePageValidation.iterationCount.get(i)
								.toString());
				billionairesWelcomePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								billionairesWelcomePageValidation.currentExecutionMachineName,
								billionairesWelcomePageValidation.currentTestCaseName);
				billionairesWelcomePageValidation.navigateTo("http://www.forbes.com/billionaires/");
				billionairesWelcomePageValidation.verifyBillionairesWelcomePage();
			}
		}

		else if (obj.currentExecutionMachineName.startsWith("iOS")) {
			TestStart("Billionaires Welcome page Validations", machineName, method.getName());
			billionairesWelcomePageValidation = new BillionairesWelcomePageValidation(obj);
			for (int i = 0; i < billionairesWelcomePageValidation.iterationCount.size(); i++) {

				billionairesWelcomePageValidation.dataRowNo = Integer
						.parseInt(billionairesWelcomePageValidation.iterationCount.get(i)
								.toString());
				billionairesWelcomePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
								billionairesWelcomePageValidation.currentExecutionMachineName,
								billionairesWelcomePageValidation.currentTestCaseName);
				billionairesWelcomePageValidation.navigateTo("http://www.forbes.com");
				 billionairesWelcomePageValidation.verifyBillionairesWelcomePage();
			}
		} else {
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = billionairesWelcomePageValidation.testCaseExecutionStatus;
		obj.testFailure = billionairesWelcomePageValidation.testFailure;
		TestEnd();
	}
	public void TestEnd() {
		obj.waitTime(1);
		if (obj.testFailure) {
			ApplicationKeywords.executionReportStatus = "Fail";
		}
		if (obj.testCaseExecutionStatus) {
			GenericKeywords.testFailed();
		}

	}

	@BeforeMethod
	public void before() {
		obj.testFailure = false;
	}

}
