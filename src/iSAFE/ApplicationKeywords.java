/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  AutomationFramework.APIKeywords
 *  baseClass.BaseClass
 *  org.openqa.selenium.By
 *  org.openqa.selenium.WebElement
 *  org.openqa.selenium.remote.RemoteWebDriver
 */
package iSAFE;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomationFramework.APIKeywords;
import AutomationFramework.GenericKeywords;
import Utilities.Mailing;
import baseClass.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import objectsRepository.OR;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationKeywords.
 *
 * @author indium
 */

public class ApplicationKeywords extends APIKeywords {

	/**
	 * Instantiates a new application keywords.
	 *
	 * @param obj
	 *            the obj
	 */
	public ApplicationKeywords(BaseClass obj) {
		super(obj);
	}

	/**
	 * Instantiates a new application keywords.
	 */
	public ApplicationKeywords() {
	}
	
	
	public static boolean checkPageLoadError(){
		   WebDriver driverToCHeck = new ChromeDriver();
		   try{
		    String url = getConfigProperty("URLToCHeck");
		    driverToCHeck.get(url);
		    if(isElementPresent(GOR.pageLoadError , driverToCHeck)){
		     toExecute = false;
		     Mailing.sendMail("404 ng in the home page of forbes </br> "+"URL - "+url, false);
		    }
		   }catch(Exception e){
		    e.printStackTrace();
		   }
		   
		   driverToCHeck.quit();
		   return toExecute;
		  }

	public static String executionReportStatus = "Pass";
	public static void sendMailOnFailure()
	 {
	  if(executionReportStatus.equals("Fail") && GenericKeywords.getConfigProperty("SendMailOnFailure").equalsIgnoreCase("yes"))
	  {
	   /*ZipReportFile.zipReport();
	   Mailing.sendMail(".//TestResults//"+GenericKeywords.timeStamp+".zip");*/
		  
		  //Mailing.sendMail();
		  GenericKeywords.sendMailWithSummary();
	  }
	 }
	
	
	/*public int invalidImageCount;

	public void validateInvalidImages() {
		try {
			invalidImageCount = 0;
			List<WebElement> imagesList = driver
					.findElements(By.tagName("img"));
			testStepPassed("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {

				String imgText = imgElement.getText();
				testStepPassed(imgText);
				if (imgElement != null) {
					verifyimageActive(imgElement);
				}

			}
			testStepPassed("Total no. of invalid images are "
					+ invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			testStepPassed(e.getMessage());
		}
	}

	public void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public void swipeToLeft(int startx,int endx,int starty) 
	{   
	 try {
		/*int startx = 990;  
		  int endx = 40;  
		  int starty = 960;*/
		  writeToLogFile("INFO", "startx = " + startx + " ,endx = " + endx + " , starty = " + starty); 
		  //Swipe from Right to Left. 
		  waitTime(2);
		  ((AndroidDriver)driver).context("NATIVE_APP");
		  testStepPassed("Before Swipe");
		  
		  ((AndroidDriver<WebElement>) driver).swipe(startx, starty, endx, starty, 3000);
		  ((AndroidDriver)driver).context("WEBVIEW");
		  testStepPassed("Swiped to Left");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public void swipeToLeftiOS(int startx,int endx,int starty) 
	{   
	 try {
		/*int startx = 990;  
		  int endx = 40;  
		  int starty = 960;*/
		  writeToLogFile("INFO", "startx = " + startx + " ,endx = " + endx + " , starty = " + starty); 
		  //Swipe from Right to Left. 
		  waitTime(2);
		  ((AndroidDriver)driver).context("NATIVE_APP");
		  testStepPassed("Before Swipe");
		  
		  ((AndroidDriver<WebElement>) driver).swipe(startx, starty, endx, starty, 3000);
		  ((AndroidDriver)driver).context("WEBVIEW");
		  testStepPassed("Swiped to Left");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	

	/*
	 * public void swipeToLeft() { try { int startx = 990; int endx = 40; int
	 * starty = 960; writeToLogFile("INFO", "startx = " + startx + " ,endx = " +
	 * endx + " , starty = " + starty); //Swipe from Right to Left. waitTime(2);
	 * ((AndroidDriver)driver).context("NATIVE_APP");
	 * testStepPassed("Before Swipe"); ((AndroidDriver<WebElement>)
	 * driver).swipe(startx, starty, endx, starty, 5000);
	 * ((AndroidDriver)driver).context("WEBVIEW");
	 * testStepPassed("Swiped to Left"); } catch (Exception e) {
	 * 
	 * } }
	 */

	/*
	 * public void swipeElement() { AppiumDriver appiumDriver = (AppiumDriver)
	 * driver; try {
	 * 
	 * appiumDriver.context("NATIVE_APP"); Dimension size =
	 * appiumDriver.manage().window().getSize(); int startx = (int) (size.width
	 * * 0.8); int endx = (int) (size.width * 0.20); int starty = size.height /
	 * 2; testStepPassed("Before swipping"); appiumDriver.swipe(startx, starty,
	 * endx, starty, 1000); testStepPassed("Slide is swipped");
	 * 
	 * } catch (Exception e) { //this.testStepFailed(e.toString()); } finally {
	 * appiumDriver=null;
	 * 
	 * } }
	 * 
	 * public void swipe(int startx, int starty, int endx, int endy,int
	 * durationMS) { try {
	 * 
	 * ((AppiumDriver<?>)driver).swipe(startx, starty, endx, endy, durationMS);
	 * Dimension size = driver.manage().window().getSize(); startx = (int)
	 * (size.width * 0.8); endx = (int) (size.width * 0.20); starty =
	 * size.height / 2; testStepPassed("Before swipping");
	 * //driver.swipe(startx, starty, endx, endy, durationMS);
	 * testStepPassed("Perform swipe operation"); } catch (Exception e) {
	 * testStepFailed(e.toString()); } }
	 */

	/*
	 * public void swipe(int startx, int starty, int endx, int endy,int
	 * durationMS) { try { AndroidDriver driver1 = (AndroidDriver)driver;
	 * driver1.swipe(startx, starty, endx, endy, durationMS);
	 * testStepPassed("Perform swipe operation"); } catch (Exception e) {
	 * testStepFailed(e.toString()); } }
	 */

	/**
	 * Take ad screenshot.
	 *
	 * @param element
	 *            the element
	 * @param screenshotName
	 *            the screenshot name
	 */
	public void takeAdScreenshot(WebElement element, String screenshotName) {
		try {
			this.driver.executeScript("arguments[0].scrollIntoView();",
					new Object[] { element });
			this.waitTime(3);
			this.manualScreenshot(screenshotName);
		} catch (Exception e) {
			this.testStepFailed(e.toString());
		}
	}

	/**
	 * Take ad screenshot.
	 *
	 * @param objLocator
	 *            the obj locator
	 * @param screenshotName
	 *            the screenshot name
	 */
	public void takeAdScreenshot(String objLocator, String screenshotName) {
		try {
			this.scrollToElement(objLocator);
			this.scrollBy(0, -60);
			this.waitTime(3);
			this.manualScreenshot(screenshotName);
		} catch (Exception e) {
			this.testStepFailed(e.toString());
		}
	}

	/**
	 * Scroll to element.
	 *
	 * @param objLocator
	 *            the obj locator
	 */
	public void scrollToElement(String objLocator) {
		this.waitForElement(objLocator);
		this.driver.executeScript("arguments[0].scrollIntoView(true);",
				new Object[] { this.webElement });
		ApplicationKeywords.writeToLogFile((String) "INFO",
				(String) ("Scroll to " + this.locatorDescription));
	}

	/**
	 * Scroll by.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void scrollBy(int x, int y) {
		this.driver.executeScript("window.scrollBy(" + x + "," + y + ")",
				new Object[0]);
		ApplicationKeywords.writeToLogFile((String) "INFO",
				(String) "Scroll to location: ");
	}

	/**
	 * Verify ad.
	 *
	 * @param adNumber
	 *            the ad number
	 */
	public void verifyAd(int adNumber) {
		this.scrollToElement("Ad place holder#id=article-0-ad-" + adNumber);
		this.takeAdScreenshot("Ad " + adNumber + "#id=inline-article-0-ad-"
				+ adNumber, "Ad No:" + adNumber);
	}

	/**
	 * Test step info.
	 *
	 * @param message
	 *            the message
	 */
	public void testStepInfo(String message) {
		this.writeHtmlTestStepReport("<font style='color:blue'>stepNo"
				+ message + "</font><br/>", this.currentExecutionMachineName,
				this.currentTestCaseName);
	}

	/**
	 * Gets the article heading.
	 *
	 * @param articleNumber
	 *            the article number
	 * @return the article heading
	 */
	public String getArticleHeading(int articleNumber) {
		String strXpath = "Article(" + articleNumber
				+ ")#xpath=//article[@id='article-container-" + --articleNumber
				+ "']//h1[@class='article-headline ng-binding ng-scope']";
		return this.getText(strXpath);
	}

	/**
	 * Gets the main article text.
	 *
	 * @return the main article text
	 */
	public String getMainArticleText() {
		String strXpath = "Main Article heading#xpath=//article[@class='feature promostory promostory-1']/div[@class='feature-headline']/h3/a";
		return this.getText(strXpath);
	}

	/**
	 * Click on top stories.
	 *
	 * @param topStoryNumber
	 *            the top story number
	 * @return the string
	 */
	public String clickOnTopStories(int topStoryNumber) {
		String strXpath = "Top Stories (" + topStoryNumber
				+ ") #xpath=//li[@class='promostory promostory-"
				+ (topStoryNumber += 2) + " ']/h4/a";
		this.scrollToElement(strXpath);
		this.scrollBy(0, -60);
		String articleLinkText = this.getText(strXpath);
		strXpath = "Top Story - " + articleLinkText
				+ "#xpath=//li[@class='promostory promostory-" + topStoryNumber
				+ " ']/h4/a";
		this.clickOn(strXpath);
		return articleLinkText;
	}

	/**
	 * Click on most popular.
	 *
	 * @param mostPopularNumber
	 *            the most popular number
	 * @return the string
	 */
	public String clickOnMostPopular(int mostPopularNumber) {
		String strXpath = "Top Stories ("
				+ mostPopularNumber
				+ ") #xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3[mostPopularNumber]";

		// section[@class='popular_top_stories' or
		// @id='stackMostPopular']//ol//li//h3
		this.scrollToElement(strXpath);
		this.scrollBy(0, -60);
		String articleLinkText = this.getText(strXpath);
		/*
		 * strXpath = "Most Popular- " + articleLinkText +
		 * "#xpath=//li[@class='promostory promostory-" + mostPopularNumber +
		 * " ']/h4/a"; this.clickOn(strXpath);
		 */
		return articleLinkText;
	}

	
	public void validateBottomAds(String bottomStickyAd) {
		try {
			boolean bottomAds = elementPresent(bottomStickyAd);
			if (bottomAds == true) {
				takeAdScreenshot(bottomStickyAd, "Bottom Ads");
				testStepPassed("Bottom sticky Ads is displayed");
			} else {
				testStepFailed("Bottom sticky Ads is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Go to home page.
	 */
	public void goToHomePage() {
		String strXpath = "Forbes logo#xpath=//article[@id='article-container-0']//header[@class='article-header ng-scope']//a[@href='http://www.forbes.com/']/h1";
		this.clickOn(strXpath);
	}

	/**
	 * Gets the element count.
	 *
	 * @param objLocator
	 *            the obj locator
	 * @return the element count
	 */
	public int getElementCount(String objLocator) {
		int elementCount = 0;
		try {
			this.waitForElement(objLocator);
			elementCount = this.driver.findElements(
					By.xpath((String) this.locator)).size();
			ApplicationKeywords.writeToLogFile((String) "INFO",
					(String) ("Total Elements found for "
							+ this.locatorDescription + ": " + elementCount));
		} catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
		}
		return elementCount;
	}

	/**
	 * Verify ads in mobile article.
	 */
	public void verifyAdsInMobileArticle() {
		try {
			String adPlaceHolder = "Ad Placeholder#xpath=//div[@class='article-mobile-ad ng-scope ng-isolate-scope' or @class='article-mobile-ad ng-isolate-scope']";
			int adCount = getElementCount(adPlaceHolder);
			testStepPassed("Verifing (" + adCount + ") Ads in the Aritcle Page");
			int adsNum = 1;
			for (adsNum = 1; adsNum <= adCount; adsNum++) {

				adCount = getElementCount(adPlaceHolder);
				//verifyAd(adsNum);
				testStepPassed("Number of Ads---"+adsNum);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify ads in desktop article.
	 */
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

	/**
	 * Verify top stories links.
	 */
	public void verifyTopStoriesLinks() {
		testStepInfo("***********Top Stories******************");
		int topStoriesCount = getElementCount(OR.lnkTopStories);
		testStepPassed("Total Top Stories: " + topStoriesCount);
		String articleLinkText = clickOnTopStories(1);
		String articleHeading = getArticleHeading(1);
		if (articleHeading.contains(articleLinkText)) {

			testStepPassed("Article Page (" + articleLinkText
					+ ") is displayed");
		} else {
			testStepFailed("Article page (" + articleLinkText
					+ ") is not displayed, instead " + articleHeading
					+ " is displayed");
		}
		clickOnBackButton();
		int articleNo = 0;
		int topStory = 1;
		for (topStory = 1; topStory <= topStoriesCount; topStory++) {

			if (currentExecutionMachineName.startsWith("Desktop")) {
				articleNo = topStory + 1;

			} else {
				articleNo = topStory + 2;
			}

			String strXpath = "Top Stories (" + topStory
					+ ") #xpath=//li[@class='promostory promostory-"
					+ articleNo + " ']/h4/a";
			if (elementPresent(strXpath)) {
				articleLinkText = getText(strXpath);
				testStepPassed("Top Story :" + topStory + " - "
						+ articleLinkText);
			}
		}

	}

	/**
	 * Gets the most popular links.
	 *
	 * @return the most popular links
	 */
	public void getMostPopularLinks() {
		testStepInfo("*****************Most Popular**************");
		List<WebElement> allMostLinks = driver
				.findElements(By
						.xpath("//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3"));
		int linksCount = 0;
		for (linksCount = 0; linksCount < allMostLinks.size(); linksCount++) {

			String textMost = allMostLinks.get(linksCount).getText();
			testStepPassed("Most Popular- " + linksCount + textMost);
			/*
			 * allMostLinks.get(k).click(); clickOnBackButton();
			 */

		}
		// scrollBy(0, 300);

	}

	/**
	 * Verify most popular links.
	 */
	public void verifyMostPopularLinks() {
		testStepInfo("***************Most Popular********************");
		scrollToElement(OR.txt_Home_Most_Popular_Links);
		scrollBy(0, 300);
		int mostPopular = 1;
		for (mostPopular = 1; mostPopular <= 1; mostPopular++) {
			String strXpath = "Most Popular#xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3]";
			clickOn(strXpath);
			String mostPopualrTitle1 = driver.getTitle();
			testStepPassed("Navigated to this page---" + mostPopualrTitle1);
			clickOnBackButton();
		}

	}

	/**
	 * Validate most read.
	 */
	/*
	 * public void validateMostRead() { testStepInfo(
	 * "********************************* Most Read **************************************"
	 * );
	 * 
	 * try { //scrollBy(0, 300); boolean varMostRead =
	 * elementPresent(OR.txt_Most_Popular_Most_Read);
	 * 
	 * if (varMostRead == true) { testStepPassed("Most Read is displayed");
	 * 
	 * } else { testStepFailed("Most Read is not displayed"); }
	 * 
	 * waitTime(10); scrollBy(0, 400);
	 * 
	 * // clickOn(OR.txt_Most_Popular_Page_Most_Read); try { boolean mostRead =
	 * elementPresent(OR.txt_Most_Popular_Page_Most_Read); if (mostRead == true)
	 * {
	 * 
	 * int count=getElementCount(OR.txt_Most_Popular_Page_Most_Read); for (int i
	 * =1; i <=count; i++) { verifyArticleTextsInNewtab(
	 * "Most Read#xpath=//section[@class='most_read']//ol//li["+i+"]//a",
	 * "Most Read#xpath=//section[@class='most_read']//ol//li["+i+"]//a",
	 * OR.txt_Reg_Home_Page_HeadLine_Article); }
	 * 
	 * } else { testStepFailed("Most Read links are not displayed"); } } catch
	 * (Exception e) { // TODO Auto-generated catch block
	 * testStepFailed("Most Read links are not displyed"); } //
	 * clickOnBackButton(); } catch (Exception e) { // TODO Auto-generated catch
	 * block writeToLogFile("ERROR", "Exception: " + e.toString()); } //
	 * testStepPassed("Most Read are displayed");
	 * 
	 * }
	 */

	/**
	 * Gets the current window handle.
	 *
	 * @return the current window handle
	 */
	public String getCurrentWindowHandle() {
		String windowHandle = null;
		try {
			windowHandle = driver.getWindowHandle();
			writeToLogFile("INFO", "Get Current Window Handle: " + windowHandle);

		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return windowHandle;
	}

	/**
	 * Switch to window using title.
	 *
	 * @param windowTitle
	 *            the window title
	 * @return the boolean
	 */
	public Boolean switchToWindowUsingTitle(String windowTitle) {
		Boolean flag = false;
		String title = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				title = driver.getTitle();
				if (title.equals("Microsoft Dynamics CRM")) {
					new WebDriverWait(driver, elementLoadWaitTime)
							.until(ExpectedConditions
									.titleContains(" - Microsoft Dynamics CRM"));
				}
				title = driver.getTitle();
				writeToLogFile("INFO", "Window Title: " + title);
				if (title.equalsIgnoreCase(windowTitle)
						|| title.startsWith(windowTitle)) {
					writeToLogFile("INFO", "Switched to window: " + windowTitle);
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowTitle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}

	/**
	 * Switch to window using handle.
	 *
	 * @param windowHandle
	 *            the window handle
	 * @return the boolean
	 */
	public Boolean switchToWindowUsingHandle(String windowHandle) {
		Boolean flag = false;
		String handle = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				handle = driver.getWindowHandle();
				writeToLogFile("INFO", "Window Title: " + handle);
				if (handle.equals(windowHandle)) {
					writeToLogFile("INFO", "Switched to window: "
							+ windowHandle);
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowHandle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}

	/**
	 * Close window.
	 *
	 * @param windowHandle
	 *            the window handle
	 * @return the boolean
	 */
	public Boolean closeWindow(String windowHandle) {
		Boolean flag = false;
		String handle = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				handle = driver.getWindowHandle();
				writeToLogFile("INFO", "Window Title: " + handle);
				if (handle.equals(windowHandle)) {
					writeToLogFile("INFO", "Switched to window: "
							+ windowHandle);
					driver.close();
					writeToLogFile("INFO", windowHandle + "Window is closed");
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowHandle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}

	public void validateHeading() {
		try {
			boolean forbesLists = elementPresent(OR.txt_Most_Popular_Page_Heading);
			if (forbesLists == true) {
				String forbesListsHeading = getText(OR.txt_Most_Popular_Page_Heading);
				testStepPassed("" + forbesListsHeading);
				clickOnBackButton();
			} else {
				testStepFailed(" Page is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	
/*
	public void verifyQuoteOfTheDay() {
		testStepInfo("************ Quote of the Day ************");
		boolean quote = elementPresent(OR.txt_Home_Forbes_Quote);
		try {
			if (quote == true) {
				String txtQuote = getText(OR.txt_Home_Forbes_Quote);
				testStepPassed("Forbes Quote of the Day- is displayed---"
						+ txtQuote);
			} else {
				testStepFailed("Forbes Quote of the day is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testStepFailed("Forbes Quote of the day is not displayed");
		}
	}*/

	/*public void verifyWelcomeAds() {
		testStepInfo("******************************* Welcome Ads ****************************************");
		try {
			boolean welcomeAds = elementPresent(OR.ads_Welcome_Page_Ads);
			if (welcomeAds == true) {
				testStepPassed(" Welcome Ads is displayed");
				// manualScreenshot(OR.ads_Welcome_Page_Ads);
			} else {
				testStepFailed("Welcome Ads is not present");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testStepFailed("Welcome Ads is not displayed");
		}

	}*/

	/**
	 * Verify real time ads.
	 */
	public void verifyRealTimeAds() {
		testStepInfo("*************** Ads*******************");

		validateTopAds(OR.adsHomePageTopAds);
		validateRecAds(OR.adsHomePageRecAds);
		//validateTopxAds(OR.adsHomePageTopxAds);

		validateRailRecAds(OR.ads_New_Posts_RailRec_Ads);
		validateTextAds();
		validateLogeAds();

	}

	// 3 Aug 2016
	public void verifyLoadMoreInRealTime() {
		scrollBy(0, 750);

		try {
			int countLinks = getElementCount(OR.txt_New_Posts_Recent_Posts);

			testStepPassed("Total Posts displayed-" + countLinks);
			// scrollToElement(OR.btn_Mob_New_Posts_Load_More);

			waitTime(3);
			scrollBy(0, 200);
			boolean loadMore = elementPresent(OR.btn_Mob_New_Posts_Load_More);
			if (loadMore == true) {
				scrollBy(0, 700);
				clickOn(OR.btn_Mob_New_Posts_Load_More);
				testStepPassed("+Load More Button is present");
				int totalPosts = getElementCount(OR.txt_New_Posts_Recent_Posts);

				// testStepPassed("Total Posts displayed-"+totalPosts);
				if (totalPosts > countLinks) {
					testStepPassed("Load More is working");
				}
			} else {
				testStepFailed("+Load More Button is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	public void validateInsideForbes() {
		testStepInfo("*********** Inside Forbes *************");
		boolean insideForbes = elementPresent(OR.txt_Reg_Home_Page_Video);
		if (insideForbes == true) {
			testStepPassed("Inside Forbes Article is displayed");
			/*verifyArticleTextsInNewtab(OR.txt_Reg_Home_Page_Video,
					OR.txt_Reg_Home_Page_Video,
					OR.txt_Reg_Home_Page_HeadLine_Article);*/
		} else {
			testStepFailed("inside Forbes section is not displayed");
		}
	}

	/**
	 * Validate socialconnect.
	 */
	public void validateSocialconnect() {

		testStepInfo("***************** Social connection **********");
		waitTime(3);
		try {
			validateSocialnetworks(OR.img_Reg_Most_Popular_SocialNetwork);
			waitForElement(OR.img_Most_Popular_Social_Facebook);
			scrollToElement(OR.img_Most_Popular_Social_Facebook);
			scrollBy(0, -70);
			clickOn(OR.img_Most_Popular_Social_Facebook);
			String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				waitTime(2);

			}

			driver.close();
			driver.switchTo().window(winHandleBefore);
			testStepPassed("Social Connects are available");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateFullBioFilter() {
		testStepInfo("************** Full Bio Filter**************");
		boolean fullBioFilter = elementPresent(OR.tab_Reg_Article_Page_FullBio_Filter);
		if (fullBioFilter == true) {
			int count = getElementCount(OR.tab_Reg_Article_Page_FullBio_Filter);
			
			boolean fullBio=elementPresent(OR.txt_Article_Page_FullBioContent);
			boolean shortBio=elementPresent(OR.txt_Article_Page_FullBioshortContent);
			if(fullBio==true &&shortBio==true)
			{
				testStepPassed("Full Bio content is present");
			}
			else
			{
				testStepFailed("Full Bio content is not present");
			}
			for (int i = 1; i <= count; i++) {
				String getFullBioTab = "Full Bio Filter#xpath=//div[@class='masked-content']//nav//li["
						+ i + "]";
				
				if (i == 2) {
					clickOn(getFullBioTab);
					boolean checkRecentPosts=elementPresent(OR.txt_Reg_Article_Page_Recent_Posts);
					if(checkRecentPosts==true)
					{
						int countRecent = getElementCount(OR.txt_Reg_Article_Page_Recent_Posts);
						for (int j = 1; j <= countRecent; j++) {
							String recentPosts = "Recent Posts#xpath=//ul[@id='authorMostRecent']//li["
									+ j + "]//a";
							String getRecent = getText(recentPosts);
							testStepPassed(getRecent);
					}
						
					
					}
					else
					{
						testStepFailed("Recent posts are not displayed");
					}

				} else if (i == 3) {
					clickOn(getFullBioTab);
					boolean checkPopularPosts=elementPresent(OR.txt_Reg_Article_Page_Popular_Posts);
					if(checkPopularPosts==true)
					{
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
					else
					{
						testStepFailed("Popular posts are not present");
					}
					
				}

			}
		}
	}

	public void validateLeftStreamArticle() {
		testStepInfo("*************** Left Rail Stream Article ***************");
		try {
			int count = getElementCount(OR.txt_Reg_Article_Page_LeftRailArticle);
			testStepPassed("Total Number of Left Rail Article-" + count);
			if (count >= 10) {
				testStepPassed("Left Rail Article Stream is Present");
			} else {
				testStepFailed("Left Rail Article Stream is not Present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	// **********************************Added Contributor Methods on 16/08/2016

	public void validateLatestPosts() {
		testStepInfo("**************** Latest Posts ********************");
		try {
			scrollBy(0, 2000);
			waitForElement(OR.txt_Contributor_Page_Latest);

			int countPosts = getElementCount(OR.txt_Contributor_Page_Latest);
			testStepPassed("Total Number of Posts are --- " + countPosts);
			for (int i = 1; i <= countPosts; i++) {
				scrollBy(0, 200);
				String countributorPosts = "Contributor Posts#xpath=//span[@ng-controller='ContribNewsController']//div[2]//ul//li["
						+ i + "]//div//div//h3";
				String textPosts = getText(countributorPosts);
				testStepPassed(textPosts);
			}
			if (countPosts == 5) {
				scrollBy(0, 200);
				verifyShowMoreInDesktop();
			}

		} catch (Exception e) {
			testStepInfo("Show more button is not displayed for this Contributor");
		}

	}

	public void validateFollowOnForbes() {
		try {
			boolean followOnForbes = elementPresent(OR.txt_Reg_Article_Page_Follow_OnForbes);
			if (followOnForbes == true) {
				testStepPassed("Follow On Forbes is Displayed");
			} else {
				testStepFailed("Follow On Forbes is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyShowMoreInDesktop() {
		testStepInfo("***************** Show More ********************");
		try {
			scrollBy(0, 700);
			waitTime(3);
			boolean showMore = elementPresent(OR.btn_Contributor_Page_Show_More);
			if (showMore == true) {

				// clickOn(OR.btn_Contributor_Page_Show_More);
				testStepPassed("Show More button is displayed");
			} else {
				testStepFailed("Show More button is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyFollowInMobile() {
		testStepInfo("*************** Follow *******************");
		try {
			boolean follow = elementPresent(OR.btn_Contributor_Page_Follow);
			if (follow == true) {
				testStepPassed("Follow button is displayed");
				clickOn(OR.btn_Contributor_Page_Follow);
				validateFollowOnForbes();
				boolean socialShare = elementPresent(OR.img_Mob_Contributor_Page_Social_Share);
				if (socialShare == true) {
					testStepPassed("Social Shares are displayed");
					clickOn(OR.btn_Mob_Contributor_Page_Close);
				} else {
					testStepFailed("Social Shares are not displayed");
				}

			} else {
				testStepFailed("Follow button is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Created On : 24 June 2016
	 */

	public void verifyNewPostsInMobile() {

		try {
			scrollToElement(OR.tab_Mob_Contributor_Page_Posts_Latest);
			scrollBy(0, -60);
			waitTime(3);
			boolean latest = elementPresent(OR.tab_Mob_Contributor_Page_Posts_Latest);
			if (latest == true) {
				testStepPassed("Latest tab is displayed");

			} else {
				testStepFailed("Latest tab is not displayed");
			}
			// scrollBy(0, 200);
			boolean archive = elementPresent(OR.tab_Mob_Contributor_Page_Posts_Archive);
			if (archive == true) {
				clickOn(OR.tab_Mob_Contributor_Page_Posts_Archive);
				testStepPassed("Archive tab is displayed");
			} else {
				testStepFailed("Archive tab is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public String getCurrentPageURL()
	{
		String currentURL =null;
		try {
			 currentURL=driver.getCurrentUrl();
			testStepPassed("Current Page URL is ---"+currentURL);
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		return currentURL;
	}

	public void validateContriCarousel() {
		testStepInfo("************** Contributor Carousel **************");
		scrollBy(0, 300);
		boolean layoutCarousel = elementPresent(OR.img_Contributor_Page_Layout);

		if (layoutCarousel == true) {
			String title1 = getText(OR.txt_Contributor_Page_Title_Post);
			testStepPassed("Cantributor Carousel Layoutis displayed-" + title1);
			try {

				boolean nextButton = elementPresent(OR.btn_Contributor_Page_Next);
				if (nextButton == true) {

					clickOn(OR.btn_Contributor_Page_Next);
					waitTime(3);
					String title = getText(OR.txt_Contributor_Page_Title_Post);
					testStepPassed("Top Feature Name is -" + title);
					testStepPassed("Contributor Carousel  Next Button is Displayed ");
				} else {
					testStepFailed("Contributor Carousel Previous & Next Button are not Displayed ");
				}

			} catch (Exception e) {
				testStepFailed("Contributor Carousel Previous & Next Button are not Displayed ");
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		} else {
			testStepInfo("Carousel Layout is not Displayed  for this Contributor ");
		}
	}

	public void validateContributorTopFeatures() {
		testStepInfo("************ Contributor Promo Blog **************");
		try {
			scrollBy(0, 200);
			boolean contributorTopFeaturesLayout = elementPresent(OR.txt_contributor_Page_Top_Features);
			if (contributorTopFeaturesLayout == true) {

				int countTopFeatures = getElementCount(OR.txt_contributor_Page_Top_Features);
				testStepPassed("Total Top Features-" + countTopFeatures);

				for (int i = 1; i <= countTopFeatures; i++) {
					scrollBy(0, -200);

					/*
					 * verifyArticleTextsInNewtab(
					 * "Contributor Posts#xpath=//div[@class='stack contrib-top-feature clearfix ng-scope']//ul//li["
					 * + i + "]//h3",
					 * "Contributor Posts#xpath=//div[@class='stack contrib-top-feature clearfix ng-scope']//ul//li["
					 * + i + "]//h3", OR.txt_Reg_Home_Page_HeadLine_Article);
					 */

					openArticlesInNewWindow("Contributor Posts#xpath=//div[@class='stack contrib-top-feature clearfix ng-scope']//ul//li["
							+ i + "]//h3");
					/*
					 * String countributorPosts =
					 * "Contributor Posts#xpath=//div[@class='stack contrib-top-feature clearfix ng-scope']//ul//li["
					 * + i + "]//h3"; String textPosts =
					 * getText(countributorPosts); testStepPassed(textPosts);
					 * 
					 * 
					 * 
					 * boolean articleTitle=elementPresent(OR.
					 * txt_Reg_Home_Page_HeadLine_Article);
					 * if(articleTitle==true) { waitTime(2); String
					 * articleHeading
					 * =getText(OR.txt_Reg_Home_Page_HeadLine_Article);
					 * if(articleHeading.equalsIgnoreCase(textPosts)) {
					 * testStepPassed("Article is navigated to Article Page");
					 * clickOnBackButton(); } else {
					 * testStepFailed("Failed to navigate"); } }
					 * 
					 * else { testStepFailed("Failed"); }
					 */
				}
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyAdsContributorPage() {
		testStepInfo("**************** Contributor Ads *****************");
		try {

			validateTopAds(OR.ads_Contributor_Page_Top_Ads);

			scrollBy(0, 500);
			validateRecAds(OR.ads_BrandVoice_Page_Ads1);

			scrollBy(0, 600);
			boolean recAds2 = elementPresent(OR.ads_BrandVoice_Page_Ads2);
			if (recAds2 == true) {
				testStepPassed("Contributor Rec Ads2 is present");
			} else {
				testStepFailed("Contributor Rec Ads2 is not  present");
			}
			validateTopxAds(OR.ads_BrandVoice_Page_Ads3);

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyDoNotMissLayout() {
		testStepInfo("************* Do Not Miss... *************");
		try {
			// scrollBy(0, 300);
			boolean doNotMiss = elementPresent(OR.txt_Contributor_Page_Do_Not_Miss);
			if (doNotMiss == true) {
				testStepPassed("Do Not Miss Layout is displayed");
			} else {
				testStepFailed("Do Not Miss Layout is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyMostPopular() {
		testStepInfo("**************Contributor Most Popular ***********");
		try {

			scrollBy(0, 100);
			int countMostPopular = getElementCount(OR.txt_Contributor_Page_Most_Popular);
			testStepPassed("Total Most Popular Posts--" + countMostPopular);

			for (int i = 1; i <= countMostPopular; i++) { // scrollBy(0, 500);
				String countributorPosts = "Contributor Posts#xpath=//div[@class='contrib-most-popular ng-scope']//ol//li["
						+ i + "]//h3";
				String textPosts = getText(countributorPosts);
				testStepPassed(textPosts);
			}
			// scrollBy(0,-200);
			boolean showMore = elementPresent(OR.btn_contributor_Page_Show_More);
			if (showMore == true) {
				waitTime(3);
				// clickOn(OR.btn_contributor_Page_Show_More);
				testStepPassed("Show More Button is Displayed");
			} else {
				testStepFailed("Show More Button is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyLoginForm() {
		try {
			
			boolean checkLoginIcon=elementPresent(OR.icon_HomePage_Login);
			if(checkLoginIcon==true)
			{
				testStepPassed("Login icon is present");
				clickOn(OR.icon_HomePage_Login);
				
				waitTime(5);
				boolean login = elementPresent(OR.txt_Login_Page_Login);
				if (login == true) {
					testStepPassed("Login link is present");
					clickOn(OR.txt_Login_Page_Login);
					waitTime(5);
					

				} else {
					testStepFailed("Login Link is not displayed");
				}
			}
			else
			{
				testStepFailed("Login Icon is not present");
			}
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	// ************************************************* Sindhu Methods
	// **********************************************

	/**
	 * Verify ad displayed on BV home page.
	 */

	public void verifyBVPageAdsInDesktop() {
		try {
			testStepInfo("**************Ads on Brand Voice Page***********");

			scrollBy(0, 900);
			List<WebElement> allAdLinks = driver.findElements(By
					.xpath("//iframe[contains(@id,'google_ads_iframe')]"));
			if (allAdLinks.size() == 3) {
				testStepPassed("BV Page validation (BV Ads - Top, Rec, loge ads are displayed)");
			} else if (allAdLinks.size() == 4) {
				testStepPassed("BV Page validation (BV Ads - Top, Rec, loge and mobile ads are displayed)");
			} else if (allAdLinks.size() == 2) {
				testStepInfo("BV Page validation (BV Ads - Two ads of Top, Rec, loge ads are displayed)");
			} else {
				testStepFailed("BV Page validation (BV Ads - Top, Rec, loge ads are not displayed)");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify show more buttons on BV Page
	 */
	public void checkShowMoreCircleButtons() {
		try {
			testStepInfo("***************Show more Buttons in Brand Voice Page****************");
			scrollBy(0, -200);
			List<WebElement> allShowMoreButtons = driver.findElements(By
					.xpath("//div[@class='load-more']/div[@class='circle']"));
			for (int k = 0; k < allShowMoreButtons.size(); k++) {
				scrollBy(0, -100);
				boolean areShowMoreButtonsDisplayed = allShowMoreButtons.get(k)
						.isDisplayed();
				if (areShowMoreButtonsDisplayed == true) {
					testStepPassed("BV Page validation (BV ShowMore Buttons - "
							+ "" + (k + 1) + ") " + areShowMoreButtonsDisplayed);
					scrollBy(0, 200);
				} else {
					testStepFailed("BV Page validation (BV ShowMore Buttons - "
							+ "" + (k + 1) + ") " + areShowMoreButtonsDisplayed);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify mobile sticky ad
	 */
	public void CheckMobileAd(String strXpath) {
		try {
			testStepInfo("***********Mobile Sticky Ad Check**************");
			if (elementPresent(strXpath)) {
				testStepPassed("Mobile Gallery Check (Mobile Gallery sticky ad is displayed on the page");
			} else {
				testStepFailed("Mobile Gallery Check (Mobile Gallery sticky ad is not displayed on the page");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify ads displayed on template gallery page
	 */
	public void checkAdsonTemplateGallery() {
		testStepInfo("*************Ads on Template gallery Page************");
		List<WebElement> allAdLinks = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe') and @title='3rd party ad content']"));
		if (allAdLinks.size() > 0) {
			testStepInfo("***************Ads on the gallery page**************");
			testStepPassed("Gallery Check (Gallery Ads check - "
					+ allAdLinks.size() + " ads are displayed on the page");
		} else {
			testStepFailed("Gallery Check (Gallery Ads check - "
					+ allAdLinks.size() + " ads are displayed on the page");
		}
	}

	/**
	 * Verify ads displayed on angular gallery page
	 */
	public void checkAdsonAngularGallery() {

		testStepInfo("*************** Angular Gallery Ads *************");
		try {
			boolean galleryAds1 = elementPresent(OR.ads_AngularGalleryCheck_TopAd);
			if (galleryAds1 == true) {
				testStepPassed("Angular Gallery --> Top Ad is displayed");
			} else {
				testStepFailed("Angular Gallery --> Top Ad is not displayed");
			}
			boolean galleryAds2 = elementPresent(OR.ads_AngularGalleryCheck_RecAd);
			if (galleryAds2 == true) {
				testStepPassed("Angular Gallery --> Rec Ad is displayed");
			} else {
				testStepFailed("Angular Gallery --> Rec Ad is not displayed");
			}
			boolean galleryAds3 = elementPresent(OR.ads_AngularGalleryCheck_textAd);
			if (galleryAds3 == true) {
				testStepPassed("Angular Gallery --> Text Ad is displayed");

			} else {
				testStepFailed("Angular Gallery --> Text Ad is not displayed");
			}
			/*
			 * scrollBy(0, 300);
			 * waitForElement(OR.ads_AngularGalleryCheck_bottomAd); boolean
			 * galleryAds4 =
			 * elementPresent(OR.ads_AngularGalleryCheck_bottomAd); if
			 * (galleryAds4 == true) {
			 * testStepPassed("Angular Gallery --> Bottom Ad is displayed");
			 * 
			 * } else {
			 * testStepInfo("Angular Gallery --> Bottom Ad is not displayed"); }
			 * boolean galleryAds5 =
			 * elementPresent(OR.ads_AngularGalleryCheck_googleAd); if
			 * (galleryAds5 == true) {
			 * testStepPassed("Angular Gallery --> Google Ad is displayed"); }
			 * else {
			 * testStepInfo("Angular Gallery --> Google Ad is not displayed"); }
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Check the images from gallery
	 */
	public void checkImagesInGallery(String slidecount, String nexticon) {
		try {
			testStepInfo("**************Check the pictures from the gallery**************");
			waitTime(3);
			String SlideCount = getText(slidecount);
			String[] parts = SlideCount.split(" of ");
			int toalSlideCount = Integer.valueOf(parts[1]);
			if (toalSlideCount != 0) {
				testStepPassed("Gallery Check (Gallery images slide check- "
						+ toalSlideCount + " slides are present in the gallery");
			} else {
				testStepInfo("**********Number of pictures in gallery is "
						+ toalSlideCount + "****************");
			}
			for (int i = 1; i < 3; i++) {
				int currentSlideNum = Integer.valueOf(parts[0]);
				testStepPassed("Current Slide number-" + currentSlideNum);
				waitTime(5);
				waitForElement(nexticon);
				clickOn(nexticon);
				testStepPassed("Clicked on the next icon of the gallery");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify Lists and overlay on CSF page
	 */

	public void isListDisplayed() {
		try {
			testStepInfo("************Top 5 List Check************");
			this.scrollBy(0, 30);
			List<WebElement> elements = driver.findElements(By
					.xpath("//div[@class='overlay-item-info']"));
			int count = elements.size();
			for (int i = 0; i < count; i++) {
				if (elements.get(i).isDisplayed()) {
					testStepPassed("Top 5 lists are displayed on the page:: List "
							+ i + " is displayed");
				} else {
					testStepFailed("Top 5 lists are not displayed on the page");
				}
			}
			testStepInfo("Number of lists displayed on the page are " + count);

			elements.get(0).click();

			if (elementPresent((OR.txt_CSFPageCheck_overlayAd))
					&& elementPresent(OR.txt_CSFPageCheck_prevButtonOnOverlay)
					&& elementPresent(OR.txt_CSFPageCheck_nextButtonOnOverlay))

			{
				testStepPassed("CSF Overlay ad , next and prev buttons are displayed on the Overlay window ");
			} else {
				testStepFailed("CSF Overlay ad , next and prev buttons are not displayed on the Overlay window ");
				takeAdScreenshot(OR.txt_CSFPageCheck_overlayAd, "Overlay Ad");
			}
			clickOn(OR.closeButton);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void isListDisplayedOnMobile(String strXpath) {
		try {
			this.scrollBy(0, 30);
			List<WebElement> elements = driver.findElements(By.xpath(strXpath));
			int count = elements.size();
			for (int i = 0; i < count; i++) {
				if (elements.get(i).isDisplayed()) {
					testStepPassed("List Check (Displayed -:: " + i);
				} else {
					testStepFailed("List Check (Not Displayed -:: " + i);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	// Added on 7/28 by Sindhu
	/**
	 * Fluent wait for the element to appear
	 */
	public void fluentwaitforVisibility(String strXpath) {
		try {

			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
			fwait.withTimeout(30, TimeUnit.SECONDS);
			fwait.pollingEvery(2, TimeUnit.SECONDS);
			fwait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(strXpath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Fluent wait for the element to appear - Added by sindhu on 8/17
	 */
	public void WEBCLICK_ListElement(String strPropertykey, int i) {
		try {
			if (this.driver.findElements(By.xpath((String) this.locator)) != null) {
				this.waitForElement(strPropertykey);
				this.driver.findElements(By.xpath((String) this.locator))
						.get(i).click();
				ApplicationKeywords.writeToLogFile((String) "INFO",
						(String) ("Clicked on the Element "
								+ this.locatorDescription + ": " + i));
				testStepPassed("Clicked on -:: " + i + "element");
			} else {
				testStepPassed("No web element found");
			}
		} catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
		}
	}

	public void validateSocialSidebar(String strPropertykey) {
		try {
			if (this.driver.findElements(By.xpath((String) this.locator)) != null) {
				this.waitForElement(strPropertykey);
				List<WebElement> socialShareIcons = this.driver.findElements(By
						.xpath((String) this.locator));
				String emailoption = socialShareIcons.get(0).getAttribute(
						"class");
				if (emailoption.equals("email")) {
					testStepPassed("Side bar - Email option is displayed");
					/*
					 * socialShareIcons.get(0).click();
					 * clickOn(OR.sidebar_emailCloseButton);
					 */
				} else {
					testStepFailed("Side bar - Email option is not displayed");
				}
				String facebookoption = socialShareIcons.get(1).getAttribute(
						"class");
				if (facebookoption.equals("facebook")) {
					testStepPassed("Side bar - facebook option is displayed");
					socialShareIcons.get(1).click();
					closeTabAndSwitchToMain();
				} else {
					testStepFailed("Side bar - facebook option is not displayed");
				}
				String twitteroption = socialShareIcons.get(2).getAttribute(
						"class");
				if (twitteroption.equals("twitter")) {
					testStepPassed("Side bar - twitter option is displayed");
					socialShareIcons.get(2).click();
					closeTabAndSwitchToMain();
				} else {
					testStepFailed("Side bar - twitter option is not displayed");
				}
				String linkedinoption = socialShareIcons.get(3).getAttribute(
						"class");
				if (linkedinoption.equals("linkedin")) {
					testStepPassed("Side bar - linkedin option is displayed");
					socialShareIcons.get(3).click();
					closeTabAndSwitchToMain();
				} else {
					testStepFailed("Side bar - linkedin option is not displayed");
				}
				String googleoption = socialShareIcons.get(4).getAttribute(
						"class");
				if (googleoption.equals("google")) {
					testStepPassed("Side bar - google option is displayed");
					socialShareIcons.get(4).click();
					closeTabAndSwitchToMain();
				} else {
					testStepFailed("Side bar - google option is not displayed");
				}
				String permalinkoption = socialShareIcons.get(5).getAttribute(
						"class");
				if (permalinkoption.equals("permalink expandable")) {
					testStepPassed("Side bar - permalink expandable option is displayed");
				} else {
					testStepFailed("Side bar - permalink expandable option is not displayed");
				}
			} else {
				testStepFailed("No web element found");
			}

		} catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
		}
	}

	/**
	 * Validating Archive
	 */
	public void clickArchive() {
		try {
			testStepInfo("**************Clicking Archive**************");
			boolean archive = elementPresent(OR.button_Mob_BVPage_Validation_Archive);
			if (archive == true) {

				clickOn(OR.button_Mob_BVPage_Validation_Archive);
				boolean archiveFirst = elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabel);
				boolean archivePostsCount = elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabelPostCount);
				if (archiveFirst == true && archivePostsCount == true) {
					String firstLabel = getText(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabel);
					testStepPassed("Archive month with post count is: "
							+ firstLabel);
					testStepPassed("Archive List is displayed");
				} else {
					testStepFailed("Archive List is not displayed");
				}
			} else {
				testStepFailed("Archive are not displayed on the page");
			}
			clickOn(OR.button_Mob_BVPage_Validation_inactiveLatest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Check Whatisthis link in BV
	 */

	public void verifyWhatisthisOnDesktop() {
		testStepInfo("************ What is this ****************");
		try {
			boolean bvlabel = elementPresent(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
			if (bvlabel == true) {
				testStepPassed("BV Page-->ForbesBrandVoice label is displayed");
			} else {
				testStepFailed("BV Page-->ForbesBrandVoice label is not displayed");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Check Article time stamp and number of views
	 */
	public void checkArticleTimeStampandViews() {
		testStepInfo("************ Getting Time stamp and numbe rof views for article ****************");
		try {
			boolean bvtimestamp = elementPresent(OR.txt_BVArticleTimeStamp);
			boolean articleviews = elementPresent(OR.txt_BVArticleViews);

			if (bvtimestamp == true && articleviews == true) {
				String time = getText(OR.txt_BVArticleTimeStamp);
				String numofviews = getText(OR.txt_BVArticleViews);
				testStepPassed("Article time stamp displayed is : " + time
						+ "Number of views are:" + numofviews);
			} else {
				testStepFailed("BV Page-->ForbesBrandVoice label is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Validate hash tag video.
	 */
	public void validateHashTagVideo(String hashTagVideo) {
		testStepInfo("******* Hash Tag Video *****************");
		try {
			boolean topVideo = elementPresent(hashTagVideo);
			if (topVideo == true) {
				getCurrentPageURL();
				takeAdScreenshot(hashTagVideo, "Video");
				testStepPassed("Hash Tag Video is Displayed");
				mouseOver(hashTagVideo);
				waitTime(5);
			
				
				
				boolean checkUnmute=elementPresent("Unmute #xpath=//div[@title='Unmute']");
				if(checkUnmute==true)
				{
					testStepPassed("Autoplayed Video is in unmute");
				}
				else
				{
					testStepFailed("Autoplayed Video is not in mute");
				}
			} else {
				testStepInfo("Hash Tag Video is not Displayed");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void clickingAllLatestPostsAndGallery() {
		try {
			testStepInfo("*********Clicking on all the articles in Latest and Validating***********");
			int count = getElementCount(OR.txt_BVPage_Validation_BVPosts);
			testStepPassed("Total Number of Posts in Latest-" + count);
			for (int i = 1; i <= count; i++) {
				if (getAttributeValue(
						"#xpath=//ul[@class='common-stream articles edittools-stream']/li["
								+ i + "]/div", "ng-switch-when").equals("blog")) {
					testStepPassed("Validating Article post");
					verifyArticleTextsInNewtab(
							"#xpath=//ul[@class='common-stream articles edittools-stream']/li["
									+ i + "]/div/div/a/h3",
							"#xpath=//ul[@class='common-stream articles edittools-stream']/li["
									+ i + "]/div/div/a/h3",
							OR.txt_ArticleTextInLandingpage);
				} else if (getAttributeValue(
						"#xpath=//ul[@class='common-stream articles edittools-stream']/li["
								+ i + "]/div", "ng-switch-when")
						.equals("slide")) {
					testStepPassed("Validating Gallery post");
					verifyArticleTextsInNewtab(
							"#xpath=//ul[@class='common-stream articles edittools-stream']/li["
									+ i + "]/div/div/div/a",
							"#xpath=//ul[@class='common-stream articles edittools-stream']/li["
									+ i + "]/div/div/div/a",
							OR.txt_Reg_New_Posts_Gallery_Title);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validating Most popular articles
	 */
	public void clickingAllMostPopularArticles() {
		try {
			testStepInfo("**********Clicking on all the articles in most popular and Validating**********");

			boolean mostPopular = elementPresent(OR.txt_AllmostPopularArticleTexts);
			if (mostPopular == true) {
				for (int i = 1; i <= getElementCount(OR.txt_AllmostPopularArticleTexts); i++) {
					verifyArticleTextsInNewtab(
							"#xpath=//ol[@class='articles']/li[" + i + "]/a/h3",
							"#xpath=//ol[@class='articles']/li[" + i + "]/a/h3",
							OR.txt_ArticleTextInLandingpage);
				}
			} else {
				testStepFailed("Most Popular Links are not displayed");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate head line article.
	 */
	public void validateHeadLineArticle() {
		try {
			waitTime(3);
			boolean headLine = elementPresent(OR.txt_Reg_Home_Page_HeadLine_Article);
			if (headLine == true) {
				String getTitle = driver.getTitle();
				String headLineArticle = getText(OR.txt_Reg_Home_Page_HeadLine_Article);
				testStepPassed(getTitle + "---is the Title ---"
						+ headLineArticle);
				clickOnBackButton();
			} else {
				testStepFailed("Failed to navigate to Article ");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateFollowOnForbes(String followOnForbesTag) {
		try {
			boolean followOnForbes = elementPresent(followOnForbesTag);
			if (followOnForbes == true) {
				testStepPassed("Follow On Forbes is Displayed");
			} else {
				testStepFailed("Follow On Forbes is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public String openArticleInNewtab(String strPropertykey, String str2)
			throws InterruptedException {
		String textOnlandingpage = null;
		try {
			if (this.driver.findElements(By.xpath((String) this.locator)) != null) {
				this.waitForElement(strPropertykey);
				WebElement link = this.driver.findElement(By
						.xpath((String) this.locator));
				Actions newTab = new Actions(driver);
				newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT)
						.build().perform();
				waitTime(5);
				testStepPassed("Openend the article in a new tab");
				// handle windows change
				String base = driver.getWindowHandle();
				Set<String> set = driver.getWindowHandles();

				set.remove(base);
				assert set.size() == 1;
				driver.switchTo().window((String) set.toArray()[0]);
				textOnlandingpage = getText(str2);
				waitTime(3);

				// close the window
				driver.close();
				driver.switchTo().window(base);
				testStepInfo("Closed the tab");
				// handle windows change and switch back to the main window
				Thread.sleep(2500);
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
			} else {
				getCurrentPageURL();
				testStepFailed("No web element found");
			}
		} catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
		}
		return textOnlandingpage;
	}

	public void closeTabAndSwitchToMain() {
		try {
			// handle windows change
			String base = driver.getWindowHandle();
			Set<String> set = driver.getWindowHandles();

			set.remove(base);
			assert set.size() == 1;
			driver.switchTo().window((String) set.toArray()[0]);
			// close the window
			driver.close();
			testStepPassed("Closed the tab");
			driver.switchTo().window(base);
			// handle windows change and switch back to the main window
			Thread.sleep(2500);
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}

		} catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
		}
	}

	public void verifyArticleTextsInNewtab(String articletext,
			String articletoclick, String validatearticletxt) {
		testStepInfo("**************Article Page****************");
		try {
			String str1 = getText(articletext);
			testStepPassed("Article Text is -" + str1);
			String str2 = openArticleInNewtab(articletoclick,
					validatearticletxt);
			// testStepPassed("Landed Article Page is -"+str2);

			if (!str2.equals("4-0-")) {
				testStepPassed("Article is navigated to article page in a new tab");

			}

			else {
				getCurrentPageURL();
				testStepFailed("Article page is throwing 404 error ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	public void verifyLoginPageHP() {

		try {
			waitForElement(OR.txt_Login_Page_User_Name);
			boolean loginUsername = elementPresent(OR.txt_Login_Page_User_Name);
			boolean loginPassword = elementPresent(OR.txt_Login_Page_Password);
			if (loginUsername == true && loginPassword == true) {
				typeIn(OR.txt_Login_Page_User_Name, retrieve("txtUserName"));
				typeIn(OR.txt_Login_Page_Password, retrieve("txtPassword"));
				clickOn(OR.btn_Login_Page_Login);
			} else {
				testStepFailed("Login Page is not Opened");
			}
			waitTime(5);
			// boolean errorMsg =
			// elementPresent(OR.txt_Login_Page_Error_Message);
			// boolean fieldError =
			// elementPresent(OR.txt_Login_Page_Field_Req_Error);
			boolean user = elementPresent(OR.txt_Login_Page_User_Link);
			if (user == true) {

				String userName = getText(OR.txt_Login_Page_User_Link);
				testStepPassed("Logged into this user-" + userName);
				// clickOn(OR.txt_Login_Page_Logout);
				testStepPassed("Login is verified Successfully");

			} else {

				testStepFailed("Invalid User Name and Password");

			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void openArticlesInNewWindow(String strPropertykey)
			throws InterruptedException {

		try {
			String articleName = getText(strPropertykey);
			testStepPassed("Article Link is -" + articleName);
			if (this.driver.findElements(By.xpath((String) this.locator)) != null) {
				this.waitForElement(strPropertykey);
				WebElement link = this.driver.findElement(By
						.xpath((String) this.locator));
				Actions newTab = new Actions(driver);
				newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT)
						.build().perform();
				waitTime(5);
				testStepPassed("Openend the article in a new window");
				// handle windows change
				String base = driver.getWindowHandle();
				Set<String> set = driver.getWindowHandles();

				set.remove(base);
				assert set.size() == 1;
				driver.switchTo().window((String) set.toArray()[0]);

				/*
				 * String podcastsTitle = getText(strPropertykey);
				 * testStepPassed("Carousel Link is -"+podcastsTitle);
				 */
				String title = driver.getTitle();
				testStepPassed("Title of the page " + title);
				if (articleName.equalsIgnoreCase(title)
						|| !title.contains("404")) {
					testStepPassed("Navigated to correct Article Page");
				} else {
					testStepFailed("Failed to navigate Article Page");
				}

				// close the window
				driver.close();
				driver.switchTo().window(base);
				testStepInfo("*********Closed the New Window*********");
				// handle windows change and switch back to the main window
				Thread.sleep(2500);
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
			} else {
				getCurrentPageURL();
				testStepFailed("No web element found");
			}
		} catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
		}

	}
	

	/**
	 * Validate top image.
	 */
	public void validateTopImage() {
		testStepInfo("**************** Top Image ************");
		try {
			boolean featuredImage = elementPresent(OR.img_Reg_Article_Page_Top_Image);
			if (featuredImage == true) {
				int topImages = getElementCount(OR.img_Reg_Article_Page_Top_Image);

				testStepPassed("Total Images in the Article --" + topImages);

				for (int i = 1; i <=topImages; i++) {
					
					boolean checkImageCaption=elementPresent("Top Images#xpath=//article[@id='article-container-0']//div[@class='wp-caption alignnone']["
							+ i + "]//img/..//p");
					/*boolean checkPhotoCredit=elementPresent("Photo Credit#xpath=//article[@id='article-container-0']//div[@class='wp-caption alignnone']["+i+"]//div[@class='article-body-image']/p");
					if(checkPhotoCredit==true)
					{
						String getPhotoCredit=getText("Photo Credit#xpath=//article[@id='article-container-0']//div[@class='wp-caption alignnone']["+i+"]//div[@class='article-body-image']/p");
						testStepPassed("Image Photo Credit is present---"+getPhotoCredit);
					}
					else
					{
						getCurrentPageURL();
						testStepFailed("Image Photo Credit is not present");
					}*/
					
					if(checkImageCaption==true)
					{
						
						String getImageCaption=getText("Top Images#xpath=//article[@id='article-container-0']//div[@class='wp-caption alignnone']["
								+ i + "]//img/..//p");
						testStepPassed("Image Caption is present---"+i+"-"+getImageCaption);
						
					}
					else
					{
						getCurrentPageURL();
						testStepFailed("Image caption is not displayed");
					}
					
				}

			} else {
				testStepInfo("Top Image is not Displayed in the Article");
				validateTopVideo();
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());

		}
	}
	
	
	/**
	 * Validate top video.
	 */
	public void validateTopVideo() {
		testStepInfo("********** Top Video ************");
		try {
			boolean topVideo = elementPresent(OR.vid_Reg_Article_Page_Top_Video);
			if (topVideo == true) {
				getCurrentPageURL();
				takeAdScreenshot(OR.vid_Reg_Article_Page_Top_Video, "Video");
				testStepPassed("Top Video is Displayed");
			} else {
				testStepInfo("Top Video is not Displayed");
			}
			scrollBy(0, 1000);

			boolean topVideo1 = elementPresent(OR.vid_Reg_Article_Page_Top_Video);
			if (topVideo1 == true) {
				getCurrentPageURL();
				takeAdScreenshot(OR.vid_Reg_Article_Page_Top_Video, "Video");
				testStepPassed(" Top Video is Displayed in Left Rail");
			} else {
				testStepInfo("Top Video is not Displayed  in Left Rail");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void validateAdOnLeftRail()
	{
		testStepInfo("************* Ad On Left Rail ************");
		try {
			
			//driver.get("https://www.forbes.com/sites/stevenbertoni/2017/01/17/adam-carolla-from-manual-laborer-to-media-mogul/#51b560d615c6");
			waitTime(10);
			boolean getAllLeftRailArticle=elementPresent(OR.txt_Article_Page_LeftRail_Articles);
			if(getAllLeftRailArticle==true)
			{
				
				List<WebElement> allLeftRail=driver.findElements(By.cssSelector(".item .ng-binding.ng-scope"));
				int count=allLeftRail.size();
				testStepPassed("Total Articles Present in the leftrail---"+count);
				
				for (int i = 1; i <=count; i++) {
					String getLeftRail=allLeftRail.get(i).getText();
					testStepPassed("LeftRail Articles---"+i+"---"+getLeftRail);
					if(getLeftRail.equals("Voice"))
					{
					testStepPassed("ntv rail ad present in the leftrail");	
					}
					else
					{
						testStepPassed("Normal Articles are present in the leftrail");
					}
				}
				
			/*int getTotalLeftRailArtilces=getElementCount("Total Leftrail articles#cssselector=.item.post .link h3 span");
			//testStepPassed("Total Leftrail articles---"+getTotalLeftRailArtilces);
				for (int i = 3; i <=11; i++) {
					String getArticle="Article#cssselector=.item.post:nth-of-type("+i+") .link h3 span";
					String getAllArticles=getText(getArticle);
					testStepPassed(getAllArticles);
					
					if(getAllArticles.contains("Voice"))
					{
						this.scrollBy(0, 200);
						clickOn("Left rail Article#cssselector=.item.post:nth-of-type("+i+") .link h3 span");
						ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs2.get(1));
					    waitTime(5);
					    testStepPassed("Leftrail Article is opened in the new tab---");
					    validateHeadLineArticle();
					    
					    driver.close();
					    driver.switchTo().window(tabs2.get(0));
						
					}
					else
					{
						testStepInfo("Article page is not having ad on left rail");
					}
				}*/
				
			}
			else
			{
				testStepFailed("Left Rail Articles are not Present");
			}
			
				
			boolean podcastArt=elementPresent("Podacast#cssselector=li:nth-of-type(3) .ng-binding.ng-scope");
			if(podcastArt==true)
			{
				String getPodcast=getText("Podacast#cssselector=li:nth-of-type(3) .ng-binding.ng-scope");
				testStepPassed("Podcast article is present in the 3rd position---"+getPodcast);
			}
			else
			{
				testStepPassed("Normal Article is present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	
	/**
	 * Validate mid of article video.
	 */
	public void validateMidOfArticleVideo() {
		testStepInfo("************* Article Video ***************");

		try {
			boolean topVideo = elementPresent(OR.vid_Reg_Article_Page_Mid_Video);
			if (topVideo == true) {
				int totalVideos=getElementCount(OR.vid_Reg_Article_Page_Mid_Video);
				testStepPassed("Total number of Videos---"+totalVideos);
				
				takeAdScreenshot(OR.vid_Reg_Article_Page_Mid_Video, "Video");
				testStepPassed("Middle Of Article Video is Displayed");
			} else {
				getCurrentPageURL();
				testStepInfo("Middle Of Article Video is not Displayed");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	

	/**
	 * Validate comments.
	 */
	public void validateComments() {
		testStepInfo("***************** Comments ***************");
		try {
			scrollBy(0, 1200);
			waitForElement(OR.txt_Reg_Article_Page_NoComment);
			// boolean
			// comments=elementPresent(OR.txt_Reg_Article_Page_Comments);
			boolean comment = elementPresent(OR.txt_Reg_Article_Page_NoComment);
			if (comment == true) {

				this.scrollToElement(OR.txt_Reg_Article_Page_NoComment);
				this.scrollBy(0, -60);
				clickOn(OR.txt_Reg_Article_Page_NoComment);

				String headLine = getText(OR.txt_Reg_Home_Page_HeadLine_Article);
				String commentsTitle = getText(OR.txt_Reg_Article_Page_Comments_Title);
				if (headLine.contains(commentsTitle)) {

					testStepPassed(commentsTitle + "---is the Title ---"
							+ headLine);
					clickOn(OR.btn_Reg_Article_Page_Comments_Close);

				} else {
					testStepInfo("Comments Block is not Matched ");
				}
			} else {
				getCurrentPageURL();
				testStepInfo("Comments Block is not Displayed ");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate see also.
	 */
	public void validateSeeAlso() {
		testStepInfo("************* See Also *********************");
		try {
			// scrollBy(0, 1500);
			boolean seeAlso = elementPresent(OR.txt_Reg_Article_Page_See_Also);
			if (seeAlso == true) {
				// int
				// countSeeAlso=getElementCount(OR.txt_Reg_Article_Page_See_Also);
				testStepPassed("See Also Block is Displayed - ");
			} else {
				getCurrentPageURL();
				testStepFailed("See Also Block is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate head line article in mobile.
	 */
	
	public void validateHeadLineArticleInMobile() {
		testStepInfo("************** Article Page*****************");
		waitTime(3);
		//boolean headLine = elementPresent(OR.txt_Mob_Reg_Home_Page_TopStories_Title);
		//boolean galleryTitle = elementPresent("Gallery Title#xpath=//p[@class='image-title']");
		
			String getTitle = driver.getTitle();
			//String headLineArticle = getText(OR.txt_Mob_Reg_Home_Page_TopStories_Title);
		//	String galleryName = getText(OR.txt_Mob_Reg_Home_Page_TopStories_Title);
			if (!getTitle.equals("404")) {
				testStepPassed("Article is navigated---"+getTitle);
			} else {
				getCurrentPageURL();
				testStepFailed("Error:404 on Forbes Page");
			}

			clickOnBackButton();
		
	}
	/*public void validateHeadLineArticleInMobile() {
		testStepInfo("******************************************** Article Page********************************************************");
		waitTime(3);
		boolean headLine = elementPresent(OR.txt_Mob_Reg_Home_Page_TopStories_Title);
		boolean galleryTitle = elementPresent("Gallery Title#xpath=//p[@class='image-title']");
		if (headLine == true || galleryTitle == true) {
			String getTitle = driver.getTitle();
			String headLineArticle = getText(OR.txt_Mob_Reg_Home_Page_TopStories_Title);
			String galleryName = getText(OR.txt_Mob_Reg_Home_Page_TopStories_Title);
			if (!getTitle.equals("404")) {
				testStepPassed(getTitle + "---is the Title ---"
						+ headLineArticle + "" + galleryName);
			} else {
				getCurrentPageURL();
				testStepFailed("Error:404 on Forbes Page");
			}

			clickOnBackButton();
		} else {
			getCurrentPageURL();
			testStepFailed("Failed to navigate to Article ");
		}
	}
*/
	public void validateLatestPostsImages() {

		testStepInfo("*********Clicking on all the articles in Latest and Validating***********");
		try {
			int count = getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
			testStepPassed("Total Number of Posts in Latest-" + count);
			for (int i = 1; i <= count; i++) {

				String getArticleTitle = getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
						+ i + "]//h2");

				testStepPassed("Latest Posts Title---->" + getArticleTitle);

			}
			scrollBy(0, 400);
			int countImages = getElementCount(OR.img_Reg_Contributor_Page_LatestPosts_Images);
			testStepPassed("Total Number of Images Present--->" + countImages);
			if (countImages == count) {
				testStepPassed("Image is  Present");
			} else {
				testStepFailed("Image is not Present");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void validateTabNameInLatest() {
		boolean tabName = elementPresent(OR.txt_Reg_BrandVoice_TabNameInLatest);
		if (tabName == true) {
			String getTabName = getText(OR.txt_Reg_BrandVoice_TabNameInLatest);
			testStepPassed("Tab Name in the Latest---->" + getTabName);
			String[] splitString = getTabName.split("LATEST IN");
			String sec = splitString[1];
			testStepPassed("-" + sec);
		} else {
			testStepFailed("Tab Name is not Displayed");
		}
	}

	// Regression
	// Home Page
	public void validateFreeIssuesOfForbes() {
		try {
			testStepInfo("************** FREE Issues OF Forbes ***************");
			boolean freeIssues = elementPresent(OR.txt_Reg_Home_Page_Free_Issues);
			if (freeIssues == true) {
				testStepPassed("Free Issues of Forbes is Displayed");
			} else {
				getCurrentPageURL();
				testStepFailed("Free Issues of Forbes is not Displayed");
			}
		} catch (Exception e) {
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
	public void validateTopAds(String topAd) {

		try {
			boolean topAds = elementPresent(topAd);
			if (topAds == true) {
				waitForElement(topAd);
				this.scrollBy(0, -60);
				takeAdScreenshot(topAd, "Top Ads");
				testStepPassed("Top Ads is present");
			} else {
				getCurrentPageURL();
				testStepFailed("Top Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateRecAds(String recAd) {

		try {
			
			boolean recAds = elementPresent(recAd);
			if (recAds == true) {
				this.scrollToElement(recAd);
				this.scrollBy(0, 1500);
				waitForElement(recAd);
				this.scrollBy(0, -60);
				waitForElement(recAd);
				takeAdScreenshot(recAd, "Rec Ads");
				testStepPassed("Rec Ads is present---" + recAds);
			} else {
				getCurrentPageURL();
				testStepFailed("Rec Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateRailRecAds(String railRecAds) {

		try {
			boolean railAds = elementPresent(railRecAds);
			if (railAds == true) {
				waitForElement(railRecAds);
				// OR.ads_New_Posts_RailRec_Ads
				takeAdScreenshot(railRecAds, "Rail Ads");
				testStepPassed(" Rail Rec Ads is present---" + railAds);
			} else {
				getCurrentPageURL();
				testStepFailed("Rail Rec Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateTextAds() {

		try {
			boolean textAds = elementPresent(OR.ads_New_Posts_Text_Ads);
			if (textAds == true) {
				waitForElement(OR.ads_New_Posts_Text_Ads);
				takeAdScreenshot(OR.ads_New_Posts_Text_Ads, "Text Ads");
				testStepPassed(" Text Ads is present---" + textAds);
			} else {
				getCurrentPageURL();
				testStepFailed("Text Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateLogeAds() {

		try {
			boolean logeAds = elementPresent(OR.ads_New_Posts_Loge_Ads);
			if (logeAds == true) {
				waitForElement(OR.ads_New_Posts_Loge_Ads);
				 takeAdScreenshot(OR.ads_New_Posts_Loge_Ads,"Rec Ads");
				testStepPassed(" Loge Ads is present----" + logeAds);
			} else {
				testStepFailed("Loge Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateTopxAds(String topxAd) {
		try {
			scrollBy(0, 800);
			boolean topxAds = elementPresent(topxAd);
			if (topxAds == true) {
				waitForElement(topxAd);
				scrollBy(0, -60);
				takeAdScreenshot(topxAd, "Topx Ads");
				testStepPassed("Topx Ads is displayed");
			} else {
				testStepFailed("Topx Ads is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

/*	public void validateBottomAds() {
		try {
			boolean bottomAds = elementPresent(OR.ads_Reg_Lists_Page_BottomAds);
			if (bottomAds == true) {
				takeAdScreenshot(OR.ads_Reg_Lists_Page_BottomAds, "Bottom Ads");
				testStepPassed("Bottom Ads ia displayed");
			} else {
				testStepFailed("Bottom Ads is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}*/

	public void validateTabs() {
		testStepInfo("************ Home Page Tabs *****************");
		try {
			boolean editorsPick = elementPresent(OR.tab_Home_Page_EditorsPicks);
			boolean podCasts = elementPresent(OR.tab_Home_Page_Podcasts);
			boolean mostPopular = elementPresent(OR.tab_Most_Popular);
			boolean lists = elementPresent(OR.tab_Home_Page_Lists);
			boolean videos = elementPresent(OR.tab_Home_Page_Video);

			if (editorsPick == true) {
				testStepPassed("Editors Picks tab is present");
			} else {
				testStepFailed("Editors Picks tab is not present");
			}
			if (podCasts == true) {
				testStepPassed("Podcasts tab is present");
			} else {
				testStepFailed("Podcasts Picks tab is not present");
			}
			if (mostPopular == true) {
				testStepPassed("Most Popular tab is present");
			} else {
				testStepFailed("Most Popular tab is not present");
			}
			if (lists == true) {
				testStepPassed("Lists tab is present");
			} else {
				testStepFailed("Lists tab is not present");
			}
			if (videos == true) {
				testStepPassed("Video tab is present");
			} else {
				testStepFailed("Video tab is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateLevelUpLogo(String levelUpIcon, String shortBio) {
		scrollBy(0, 300);

		try {
			boolean levelUpImg = elementPresent(levelUpIcon);

			if (levelUpImg == true) {
				testStepPassed("Level Up Icon is Displayed");
			} else {
				testStepFailed("Level Up Icon is not Displayed");
			}
			boolean checkShortBio = elementPresent(shortBio);
			if (checkShortBio == true) {
				testStepPassed("Home Page LevelUp Short Bio is displayed");
			} else {
				testStepFailed("Home Page LevelUp Short bio is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate email promo.
	 */
	public void validateEmailPromo() {
		testStepInfo("********** Email Promo ***********");
		try {
			scrollBy(0, 200);
			boolean emailPromo = elementPresent(OR.txt_Reg_Home_Page_Email_Promo);
			boolean submitbutton = elementPresent(OR.btn_Reg_MostPopular_submit);
			if (emailPromo == true && submitbutton == true) {
				testStepPassed("Email Promo section is Displayed with Submit Button");
			} else {
				getCurrentPageURL();
				testStepFailed("Email Promo Section is not Displayed with Submit Button");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify social web.
	 */
	 public void verifySocialWeb() {
		  testStepInfo("********* Social Web ***********");
		  try {
		   
			  this.scrollToElement(OR.icon_Most_Popular_Social_Web_Facebook);
			  this.scrollBy(0, -200);
		   boolean checkFacebook=elementPresent(OR.icon_Most_Popular_Social_Web_Facebook);
		   if(checkFacebook==true)
		   {
		   clickOn(OR.icon_Most_Popular_Social_Web_Facebook);
		   
		   boolean facebookLinks=elementPresent(OR.txt_Most_Popular_Social_Web_Facebook);
		   if(facebookLinks==true)
		   {
		    int facebookCount = getElementCount(OR.txt_Most_Popular_Social_Web_Facebook);
		    testStepPassed("Total Links Present on Facebook--" + facebookCount);
		    String facebook = getText(OR.txt_Most_Popular_Social_Web_Facebook);
		    testStepPassed(facebook);
		    testStepPassed("Facebook links are displayed");
		   }
		   else
		   {
		    testStepFailed("Facebook links are not displayed");
		   }
		   
		   }
		   else
		   {
		    testStepFailed("Facebook Tab is not displayed");
		   }
		   
		   boolean checkTwitter=elementPresent(OR.icon_Most_Popular_Social_Web_Twitter);
		   if(checkTwitter==true)
		   {
		   clickOn(OR.icon_Most_Popular_Social_Web_Twitter);
		   boolean twitterLinks=elementPresent(OR.txt_Most_Popular_Twitter);
		   if(twitterLinks==true)
		   {
		    int twitterCount = getElementCount(OR.txt_Most_Popular_Twitter);
		    testStepPassed("Total Links Present on Twitter--" + twitterCount);
		    String twitter = getText(OR.txt_Most_Popular_Twitter);
		    testStepPassed(twitter);
		    testStepPassed("Twitter Links are displayed");
		   }
		   else
		   {
		    testStepFailed("Twitter links are not displayed");
		   }
		   
		   }
		   else
		   {
		    testStepFailed("Twitter Tab is not displayed");
		   }
		   
		   boolean checkLinkedIn=elementPresent(OR.icon_Most_Popular_Social_Web_LinkedIn);
		   if (checkLinkedIn==true) {
		    clickOn(OR.icon_Most_Popular_Social_Web_LinkedIn);
		    boolean linkedInLinks=elementPresent(OR.txt_Most_Popular_Social_Web_LinkedIn);
		    if(linkedInLinks==true)
		    {
		     int linkedInCount = getElementCount(OR.txt_Most_Popular_Social_Web_LinkedIn);
		     testStepPassed("Total Links Present on LinkedIn--" + linkedInCount);
		     String linkedIn = getText(OR.txt_Most_Popular_Social_Web_LinkedIn);
		     testStepPassed(linkedIn);
		     testStepPassed("LinkedIn links are displayed");

		    }
		    else
		    {
		     testStepFailed("LinkedIn links are not Displayed");
		    }
		    
		   }
		   else
		   {
		    testStepFailed("LinkedIn tab is not displayed");
		   }
		   
		  } catch (Exception e) {
		   // TODO Auto-generated catch block
		   writeToLogFile("ERROR", "Exception: " + e.toString());
		  }

		 }
		

	/**
	 * Verify video on home page.
	 */
	public void verifyVideoOnHomePage() {

		testStepInfo("***********Validating Video**************");
		try {

			/*
			 * testStepPassed("Before Video plays");
			 * takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
			 */
			waitTime(5);
			waitForElement(OR.vidHomePageVideo);
			scrollBy(0, 2000);
			scrollToElement(OR.vidHomePageVideo);
			boolean video = elementPresent(OR.vidHomePageVideo);
			if (video == true) {
				testStepPassed("Video Section is displayed");

				try {
					boolean playButton = isElementDisplayed(OR.btn_Home_Page_Video_Play_button);
					if (playButton == true) {
						this.scrollToElement(OR.btn_Home_Page_Video_Play_button);
						this.scrollBy(0, -100);
						clickOn(OR.btn_Home_Page_Video_Play_button);
						// testStepPassed("Video Played for 5 seconds");
						// takeAdScreenshot(OR.vidHomePageVideo,
						// "Home Page Video");
						// clickOn(OR.vidHomePageVideo);
					} else {
						testStepFailed("Video Play button is not loaded");
					}
				} catch (Exception e) {
					testStepFailed("Video is not played");
				}

			} else {
				testStepFailed("Video Section is not displayed");
			}

		} catch (Exception e) {
			testStepFailed("Error occured in the video");
		}
	}

	
	
	
	/**
	 * Verify related topics in mob.
	 */
	public void verifyRelatedTopicsInMob() {
		testStepInfo("********** Related Topics *********");
		try {
			scrollBy(0, 250);
			waitTime(3);
			boolean relatedTopics = elementPresent(OR.txt_Mob_Most_Popular_Related_Topics);
			if (relatedTopics == true) {
				testStepPassed("Related Topics are displayed");
			} else {
				testStepFailed("Related Topics are not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyMostReadOnForbesInMobile() {
		testStepInfo("************* Most Read on Forbes **************");
	
		scrollBy(0, 1800);
		this.scrollToElement(OR.txt_Mob_Most_Popular_Most_Read);
		this.scrollBy(0, -60);
		//takeAdScreenshot(OR.txt_Mob_Most_Popular_Most_Read, "Most Read");
		waitTime(3);
		try {
		
				boolean newsLinks=elementPresent("New Posts#xpath=//div[@class='popular_wrapper']//ul[@class='posts']//li");
				if(newsLinks==true)
				{
					waitTime(5);
					int countNewsPosts = getElementCount("New Posts#xpath=//div[@class='popular_wrapper']//ul[@class='posts']//li");
					if (countNewsPosts == 5) {
						testStepPassed("Total number of new posts" + countNewsPosts);
						for (int i = 1; i <= countNewsPosts; i++) {
							String getAllNewPosts = getText("News Posts#xpath=//div[@class='popular_wrapper']//ul[@class='posts']//li["
									+ i + "]//span");
							testStepPassed(getAllNewPosts);
						}
					} else {
						testStepFailed("Most Read on Forbes News Links are not Displayed");
					}
				}
				 else {
				testStepFailed("Most Read on Forbes News links are not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		try {
			boolean peopleTab=elementPresent(OR.tab_Mob_Home_Page_Most_Read_People);
			if(peopleTab==true)
			{
				clickOn(OR.tab_Mob_Home_Page_Most_Read_People);
				boolean mostReadNews = elementPresent("People#xpath=//div[@class='popular_wrapper']//ul[@class='people']//li");
				if (mostReadNews == true) {

					int countPeople = getElementCount("People#xpath=//div[@class='popular_wrapper']//ul[@class='people']//li");
					if (countPeople == 5) {
						testStepPassed("Total number of People--->" + countPeople);
						for (int i = 1; i <= countPeople; i++) {
							String getAllPeople = getText("People#xpath=//div[@class='popular_wrapper']//ul[@class='people']//li["
									+ i + "]//span");
							testStepPassed(getAllPeople);
						}
						testStepPassed("Most Read on Forbes  People is displayed");
					} else {
						testStepFailed("Most Read on Forbes People Links are not Displayed");
					}
				} else {
					testStepFailed("Most Read on Forbes People is not displayed");
				}
			}
			else
			{
				testStepFailed("People Tab is not present");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		try {
			boolean placesTab=elementPresent(OR.tab_Mob_Home_Page_Most_Read_Places);
			if(placesTab==true)
			{
				clickOn(OR.tab_Mob_Home_Page_Most_Read_Places);
				boolean mostReadNews = elementPresent("Place#xpath=//div[@class='popular_wrapper']//ul[@class='places']//li");
				if (mostReadNews == true) {

					int countPlace = getElementCount("Place#xpath=//div[@class='popular_wrapper']//ul[@class='places']//li");
					if (countPlace == 5) {
						testStepPassed("Total number of Places--->" + countPlace);
						for (int i = 1; i <= countPlace; i++) {
							String getAllPlace = getText("Place#xpath=//div[@class='popular_wrapper']//ul[@class='places']//li["
									+ i + "]//span");
							testStepPassed(getAllPlace);
						}
						testStepPassed("Most Read on Forbes  Place is displayed");
					} else {
						testStepFailed("Most Read on Forbes Places Links are not Displayed");
					}
				} else {
					testStepFailed("Most Read on Forbes Place is  not displayed");
				}
			}
			else
			{
				testStepFailed("Places Tab is not present");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		try {
			boolean companiesTab=elementPresent(OR.tab_Mob_Home_Page_Most_Read_Companies);
			
			if(companiesTab==true)
			{
				clickOn(OR.tab_Mob_Home_Page_Most_Read_Companies);
				boolean mostReadNews = elementPresent("Companies#xpath=//div[@class='popular_wrapper']//ul[@class='companies']//li");
				if (mostReadNews == true) {

					int countCompanies = getElementCount("Companies#xpath=//div[@class='popular_wrapper']//ul[@class='companies']//li");
					if (countCompanies == 5) {
						testStepPassed("Total number of Companies--->"
								+ countCompanies);
						for (int i = 1; i <= countCompanies; i++) {
							String getAllCompanies = getText("Companies#xpath=//div[@class='popular_wrapper']//ul[@class='companies']//li["
									+ i + "]//span");
							testStepPassed(getAllCompanies);
						}
						testStepPassed("Most Read on Forbes Companies is displayed");
					} else {
						testStepFailed("Most Read on Forbes Companies Links are not Displayed");
					}

				} else {
					testStepFailed("Most Read on Forbes Companies is not displayed");
				}
			}
			else
			{
				testStepFailed("Companies Tab is not present");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate switch to full site.
	 */
	public void validateSwitchTofullSite(String switchToFullSite) {
		testStepInfo("************** Switch to Full Website **************");
		try {
			boolean fullSite = elementPresent(switchToFullSite);
			if (fullSite == true) {
				testStepPassed("Switch to full website is displayed");

			} else {
				testStepFailed("Switch to full website is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/*public void verifyBottomAdsInMobile() {
		testStepInfo("******************************** Bottom Ads *****************************************");
		waitTime(4);
		boolean mobileAds = elementPresent(OR.ads_Mob_Home_Page_Mobile_Ads);
		if (mobileAds == true) {
			// takeAdScreenshot(OR.ads_Mob_Home_Page_Mobile_Ads, "Mobile Ads");
			testStepPassed("Mobile Ads is present");
		} else {
			testStepFailed("Mobile Ads is not present");
		}
	}*/

	// Article Page
	/**
	 * Click on main article.
	 */
	public void clickOnMainArticle() {
		try {
			boolean mainArticle = elementPresent(OR.lnk_MainArticle);
			if (mainArticle == true) {
				clickOn(OR.lnk_MainArticle);
				boolean headLine = elementPresent(OR.txt_Article_Page_Heading);
				if (headLine == true) {
					String getTitle = driver.getTitle();
					String headLineArticle = getText(OR.txt_Article_Page_Heading);
					testStepPassed(getTitle + "---is the Title ---"
							+ headLineArticle);
				} else {
					testStepFailed("Failed to navigate to Article ");
				}
			} else {
				testStepFailed("Main Article is not loaded");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		/*
		 * String strXpath =
		 * "Main Article #xpath=//article[@class='feature promostory promostory-1']"
		 * ; this.clickOn(strXpath);
		 */
	}
	//=========================================================================================
	//Views Display Conversion To Iconography logic -  Added by Sindhu - https://jira.forbes.com/browse/PROD-918
	public void checkViewsDisplayIcon(){
		boolean pageViewIcon = elementPresent(OR.txt_Article_Page_View_Count_icon);
		if(pageViewIcon==true){
			testStepPassed("page Views eye Icon is displayed");
		}else{
			testStepPassed("page Views eye Icon is not displayed");
		}
		}
	//=========================================================================================
	public int openArticleLinksInWindow(String strPropertykey,
			String getPageView) {
		int viewCounts = 0;
		try {

			String articleLink = getText(strPropertykey);
			testStepPassed("Article Link is -" + articleLink);

			if (this.driver.findElements(By.xpath((String) this.locator)) != null) {
				this.waitForElement(strPropertykey);
				WebElement link = this.driver.findElement(By
						.xpath((String) this.locator));
				Actions newTab = new Actions(driver);
				newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT)
						.build().perform();
				waitTime(5);
				testStepPassed("Openend the article in a new tab");
				// handle windows change
				String base = driver.getWindowHandle();
				Set<String> set = driver.getWindowHandles();

				set.remove(base);
				assert set.size() == 1;
				driver.switchTo().window((String) set.toArray()[0]);

				waitTime(5);
				/*
				 * String getUrl=driver.getCurrentUrl();
				 * testStepPassed("Current URL------------->"+getUrl); String
				 * splitURL[]= getUrl.split("\\#"); String
				 * firstPart=splitURL[0]; String secPArt=splitURL[1];
				 * testStepPassed(firstPart); testStepPassed(secPArt); String
				 * appendedURL=firstPart.concat("?nobeta");
				 * driver.get(appendedURL); //validatePageLoadTime(appendedURL,
				 * 23, "Article Page");
				 */

				waitTime(5);
				boolean pageView = elementPresent(getPageView);
				if (pageView == true) {
					takeAdScreenshot(getPageView, "Page View count");
					String pageViewCount = getText(getPageView);
					String replaceComma = pageViewCount.replace(",", "");
					//testStepPassed(replaceComma);
					viewCounts = Integer.parseInt(replaceComma);

					testStepPassed("First Time View Count is " + viewCounts);
				} else {
					testStepFailed("Page View Count is not Displayed");
				}

				// close the window
				driver.close();
				driver.switchTo().window(base);
				testStepInfo("Closed the tab");
				// handle windows change and switch back to the main window
				Thread.sleep(2500);
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
			} else {
				getCurrentPageURL();
				testStepFailed("No web element found");
			}
		} catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
		}

		return viewCounts;
	}
	/**
	 * Validate left stream article.
	 */
	public void validateLeftStreamArticle(String leftRailArticle) {
		testStepInfo("********* Left Rail Stream Article ***********");
		try {
			int count = getElementCount(leftRailArticle);
			testStepPassed("Total Number of Left Rail Article-" + count);
			if (count >= 10) {
				testStepPassed("Left Rail Article Stream is Present");
			} else {
				testStepFailed("Left Rail Article Stream is not Present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	// ************************************Article Methods added on 15 Sep 2016

	public void validateLeftRailArticleNavigation(String articleTitle,
			String LeftRailTitle) {
		testStepInfo("*********** Left Rail Article ***************");

		try {
			String articleText = getText(articleTitle);
			System.out.println("article text is" + articleText);
			String leftRailText = getText(LeftRailTitle);
			System.out.println("left article text is" + leftRailText);
			if (leftRailText.contains(articleText)) {
				testStepPassed("Left Rail Article is navigated ");
			} else {
				testStepInfo("Left Rail Article is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Validate hash tag.
	 */
	public void validateHashTag(String hashTagName) {
		testStepInfo("************ Hash Tag ***************");
		try {
			boolean hashTag = elementPresent(hashTagName);
			if (hashTag == true) {

				String getHashTag = getText(hashTagName);
				testStepPassed("Hash Tag is Present-" + getHashTag);
				validateHashTagVideo(OR.vid_Reg_Article_Page_HashTag_Video);
			} else {
				testStepInfo("Hash Tag is not Present");

			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());

		}
	}

	/**
	 * Validate featured image.
	 */
	public void validateFeaturedImage(String featuredImg) {
		testStepInfo("********** Featured Image ***************");
		try {
			boolean featuredImage = elementPresent(featuredImg);
			if (featuredImage == true) {
				takeAdScreenshot(featuredImg, "Featured Image");
				testStepPassed("Featured Image is Displayed for Article");
			} else {
				testStepInfo("Featured Image is not Displayed for the Article");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());

		}
	}

	/**
	 * Validate author details.
	 */
	public void validateAuthorDetailsForDesktop() {
		testStepInfo("************Author Information**********");
		
		
		try {
			boolean tagLine = elementPresent(OR.txt_Reg_Article_Page_TageLine);
			if (tagLine == true) {
				String tagline1 = getText(OR.txt_Reg_Article_Page_TageLine);
				testStepPassed("Tag Line is Present ---" + tagline1);
			} else {
				getCurrentPageURL();
				testStepFailed("Tag Line is not Present ");
			}
		} catch (Exception e) {
			testStepFailed("Tag Line is not Present ");
		}
		try {
			boolean varContributor = elementPresent(OR.img_Article_Page_Contributor);
			if (varContributor == true) {
				testStepPassed("Image is displayed");
			} else {
				getCurrentPageURL();
				testStepFailed("Image is not displayed");
			}
		} catch (Exception e) {
			testStepFailed("Image is not displayed");
		}

	}
	/*public void validateArticleByScroll()
	{
		testStepInfo("******************************** Validating Articles By scrolling ***********************************");
		int countArticles=getElementCount("Article Title#xpath=//section[@id='article-page']//article//h1[@class='article-headline ng-binding']");
		testStepPassed("Total Articles on the page---"+countArticles);
		for (int i = 1; i <=4; i++) {
			
			boolean articles=elementPresent("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
			if(articles==true)
			{
				this.scrollToElement("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
				this.scrollBy(0, -60);
				String titleOfArticle=getText("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
				//testStepPassed("Title of the Article-"+titleOfArticle);
				this.scrollBy(0, 100);
				String currentURL=driver.getTitle();
				testStepPassed("Title of the Article is --- "+i+" - "+currentURL);
				waitTime(8);
				String leftRailArticleTitle=getText("Leftrail Article name#cssselector=.items.ng-scope .item.active .ng-binding.ng-scope");
				testStepPassed("Leftrail article title--"+leftRailArticleTitle);
				this.scrollBy(0, 100);
				if(leftRailArticleTitle.contains(titleOfArticle))
				{
					testStepPassed("Article Title is matching with leftrail of first article");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Article Title is not matching with leftrail of first article");
				}
			}
			else
			{
				getCurrentPageURL();
				testStepInfo(" Next Article are not loaded");
			}
			
			this.scrollToElement(titleOfArticle);
			this.scrollBy(0, -60);
			
		}
	}*/
	

	public void validateArticleByScroll()
	{
		testStepInfo("***************** Validating Articles By scrolling ***********");
		
		int countArticles=getElementCount("Article Title#xpath=//section[@id='article-page']//article//h1[@class='article-headline ng-binding']");
		testStepPassed("Total Articles on the page---"+countArticles);
		for (int i = 1; i <=3; i++) {
			
			boolean articles=elementPresent("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
			if(articles==true)
			{
				this.scrollToElement("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
				this.scrollBy(0, -60);
				//this.scrollBy(0, -60);
				String headOfArticle=getText("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
				//testStepPassed("Title of the Article-"+headOfArticle);
				//this.scrollBy(0, 100);
				String title=driver.getTitle();
				//testStepPassed("Title of the Article is --- "+i+" - "+title);
				waitTime(10);
				this.scrollBy(0, 100);
				waitTime(10);
				/*this.scrollToElement("Article Heading#xpath=//article["+i+"]//h1[@class='article-headline ng-binding']");
				this.scrollBy(0, -60);*/
				
				//String getHeadingOfArticle=getText("Article Heading#xpath=//article["+i+"]//h1[@class='article-headline ng-binding']");
				String leftRailArticleTitle=getText("Leftrail Article name#cssselector=.items.ng-scope .item.active .link .headline.ng-isolate-scope");
				//String getLeft=leftRailArticleTitle.substring(leftRailArticleTitle.lastIndexOf("Voice:")+1);
				//testStepPassed("String of Leftrail artilce----"+getLeft);
				//testStepPassed("Leftrail article title--"+leftRailArticleTitle);
				//this.scrollBy(0, 100);
				waitTime(8);
				if(headOfArticle.trim().contains(title)||leftRailArticleTitle.trim().contains(title)||leftRailArticleTitle.trim().contains(headOfArticle))
				{
					//testStepPassed("Title of the Article---"+title);
					testStepPassed("LeftRail article ---"+leftRailArticleTitle);
					testStepPassed("Article Title is matching with leftrail of first article");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Article Title is not matching with leftrail of first article");
				}
			}
			else
			{
				getCurrentPageURL();
				testStepInfo(" Next Article are not loaded");
			}
			
			/*this.scrollToElement(titleOfArticle);
			this.scrollBy(0, -60);*/
			
		}
	}

	public void validateAuthorName(String authorName)
	{
		try {

			boolean name = elementPresent(authorName);
			
			if (name == true) {
				String getAuthorName = getText(authorName);
				
				testStepPassed("Author Name is displayed---" + getAuthorName);
				

			} else {
				getCurrentPageURL();
				testStepFailed("Author Name is not displayed");
			}
		} catch (Exception e1) {
			testStepFailed("Author Name is not displayed");
		}
	}
	public void validateFullBio() {
		testStepInfo("************** Full Bio ************");
		try {
			boolean fullBio = elementPresent(OR.btn_Mob_Article_Page_Full_Bio);
			if (fullBio == true) {
				clickOn(OR.btn_Mob_Article_Page_Full_Bio);
				String fullBioDetails = getText(OR.txt_Mob_Article_Page_Full_Bio_Details);
				testStepPassed(fullBioDetails);

				testStepPassed("Full Bio is displayed");
				validateFollowOnForbes();
				validateSocialnetworks(OR.img_Mob_Reg_Article_Page_SocialShares);
				//validateFullBioFilter();

				
			} else {
				getCurrentPageURL();
				testStepFailed("Full Bio is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate gallery.
	 */
	public void validateGallery(String galleryIcon, String galleryName) {
		testStepInfo("**************** Article Gallery *******************");
		try {
			boolean gallery = elementPresent(galleryIcon);
			if (gallery == true) {

				// takeAdScreenshot(OR.txt_Reg_Article_Page_Gallery,"Gallery");
				String getGalleryName = getText(galleryName);
				testStepPassed("Gallery is present for this Article- "
						+ getGalleryName);
			} else {
				testStepInfo("Gallery is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyAdsInArticle() {
		boolean ads = elementPresent(OR.txt_Article_Page_Ads);
		/*
		 * if(ads==true) { scrollBy(0, 100);
		 * testStepPassed("Article Ads is present"); } else {
		 * testStepFailed("Article ads is not displayed"); }
		 */

		try {
			int countAds = getElementCount(OR.ads_Reg_Article_Page_AllAds);
			testStepPassed("Total Number of Ads" + countAds);
			int scrollnum = 100;
			for (int count = 1; count <= countAds; count++) {
				scrollBy(scrollnum + 100, 100);
				String allArticleAds = "Article Ads#xpath=//article[@id='article-container-0'][1]//div[@id='fbs-ad-rail-article-0']//div[@class='ng-scope']["
						+ count + "]";
				boolean adPresent = elementPresent(allArticleAds);
				if (adPresent == true) {
					testStepPassed("Article Ads is displayed--" + count);

				} else {
					testStepFailed("Article Ads is not displayed");
				}

			}
		} catch (Exception e) {
			testStepFailed("Article Ads are not loaded properly");
		}
	}

	public void validateRecommended() {

		try {

			//validateRecommendedLabel();
			boolean recommendedLabel=elementPresent(OR.txt_Reg_Article_Page_Recommended_Label);
			if(recommendedLabel==true)
			{
				testStepPassed("Recommended Label is present");
				boolean recommended = elementPresent(OR.txt_Reg_Article_Page_Recommended);
				if (recommended == true) {

					int countRec = getElementCount(OR.txt_Reg_Article_Page_Recommended);
					testStepPassed("Total Recommended -" + countRec);
					for (int i = 1; i <= countRec; i++) {

						String getRecommended = "Recommended#xpath=//div[@class='vp-slick-slider slick-initialized slick-slider']//div[@class='slick-track']//div["
								+ i + "]//div[@class='vp-inner ng-scope']";
						testStepPassed("Recommended Section is Displayed-"
								+ recommended);
					}
				} else {
					getCurrentPageURL();
					testStepFailed("Recommended Section is not displayed");
				}
			}
			else
			{
				testStepFailed("Recommended Label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	//PROD-881
	public void validatePrintBar() {
		testStepInfo("***************Article Print Bar*************");
		try {
			boolean printBar = elementPresent(OR.txt_Reg_Article_Page_Print_Bar);
			if (printBar == true) {
				int countPrintBar = getElementCount(OR.txt_Reg_Article_Page_Print_Bar);

				for (int i = 1; i <= countPrintBar; i++) {
					String printBars = "Print Bar#xpath=//div[@class='article-print-bar ng-scope' or @class='article-print-bar preload-hidden ng-scope']//ul//li["
							+ i + "]//i";
					/*
					 * String getPrintbars=getText(printBars);
					 * testStepPassed(getPrintbars);
					 */
					if (i == 1) {
						testStepPassed("Print Bar is Displayed");
						
					}else if(i==2)
					{
						testStepPassed("Send Us Feedback is Displayed");
					}
					else if (i == 3) {
						testStepPassed("Report Corrections is Displayed");
					} else if (i == 4) {
						testStepPassed("Reprints and Permissions is Displayed");
					} else {
						getCurrentPageURL();
						testStepFailed("Print Bar is not Displayed");
					}
				}

			} else {
				getCurrentPageURL();
				testStepFailed("Print Bar is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateRevContent(String revContent) {
		testStepInfo("*************** Ads By RevContent *****************");

		try {
			this.scrollToElement(revContent);
			this.scrollBy(0, -60);
			boolean revContentText = elementPresent(revContent);
			if (revContentText == true) {

				testStepPassed("Ads By RevContent is Displayed");
			} else {
				getCurrentPageURL();
				testStepFailed("Ads By Revcontent is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	public void ValidateHashTagInMobile()
	{
		try {
			boolean hashTag=elementPresent(OR.txt_Reg_Article_Page_HashTag);
			if(hashTag==true)
			{
				testStepPassed("Article Hashtag is present");
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Article Hashtag is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Validate social share.
	 */
	public void validateSocialShare() {
		try {
			testStepInfo("************* Social Share ************");
			waitTime(3);
			boolean shareArrow=elementPresent(OR.img_Mob_Article_Page_Share_Icon);
			if(shareArrow==true)
			{
			clickOn(OR.img_Mob_Article_Page_Share_Icon);
			validateSocialnetworks(OR.img_Mob_Article_Page_Facebook);
			
			clickOn(OR.img_Mob_Article_Page_Share_Icon);
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Social Share Arrow is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	
	/**
	 * Validate author details for mobile.
	 */
	public void validateAuthorDetailsForMobile() {
		testStepInfo("***************** Author Details  ***********");
		try {
			
			boolean authorImage = elementPresent(OR.img_Article_Page_Contributor);
			if (authorImage == true) {
				// takeAdScreenshot(OR.img_Article_Page_Contributor,"Author Image");
				testStepPassed("Author image is displayed");
			} else {
				getCurrentPageURL();
				testStepFailed("Image is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	
	/**
	 * Validate comments.
	 */
	public void validateCommentsInMobile() {
		testStepInfo("************ Comments **************");
		try {
			this.scrollToElement(OR.txt_Reg_Article_Page_NoComment);
			this.scrollBy(0, -60);
			waitForElement(OR.txt_Reg_Article_Page_NoComment);
			// boolean
			// comments=elementPresent(OR.txt_Reg_Article_Page_Comments);
			boolean comment = elementPresent(OR.txt_Reg_Article_Page_NoComment);
			if (comment == true) {

				testStepPassed("Comments Section is Displayed");
			} else {
				getCurrentPageURL();
				testStepInfo("Comments Block is not Displayed ");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	

	
	public void validateFromWebInMobile()
	{
		testStepInfo("************** From Web ********************");
		try {
			//waitTime(5);
			this.scrollToElement(OR.txt_Mob_Reg_Article_Page_FromWeb);
			this.scrollBy(0, -60);
			boolean fromWeb=elementPresent(OR.txt_Mob_Reg_Article_Page_FromWeb);
			if(fromWeb==true)
			{
				testStepPassed("From Web Section is Present");
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("From Web Section is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateRelatedTopics(String relatedTopics)
	{
		testStepInfo("********** Related Topics ***************");
		try {
			boolean relatedTopic=elementPresent(relatedTopics);
			if(relatedTopic==true)
			{
				testStepPassed("Related Topic Section is displayed");
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Related Topics Section is not displayed ");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void validateArticleStreamImage()
	{
		testStepInfo("*********************Validating Article Stream Image************************");
		try {
			boolean articleImages=elementPresent(OR.img_Article_Page_TrendingStories_Images);
			if(articleImages==true)
			{
				
				int countImages=getElementCount(OR.img_Article_Page_TrendingStories_Images);
				testStepPassed("Total Number of Article Images in the Stream--->"+countImages);
				for (int i = 1; i <countImages; i++) {
					
					boolean checkImage=elementPresent("Article Stream Image#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//div[@class='ratio-holder ng-scope']//img[@class='thumb ng-scope']");
					if(checkImage==true)
					{
						//validateBrokenImages("Article Stream Image#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//div[@class='ratio-holder ng-scope']//img[@class='thumb ng-scope']", "Article Stream ");
						testStepPassed("Article Stream Image is displayed----"+i);
					}
					else
					{
						testStepInfo("Article Stream is not having Image thumbnail");
					}
					
				}
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateAdStream()
	{
		testStepInfo("*************** Validating Ads Article Stream *************");
	
		try {
			
			scrollBy(0, 2000);
			boolean trendingOnForbes=elementPresent(OR.txt_Mob_Article_Page_TrendingONForbes);
			if(trendingOnForbes==true)
			{
				
				testStepPassed("Trending on Forbes is present ");
				//boolean articleLists=elementPresent(OR.txt_Mob_Article_Page_ArticleList);
				//boolean articleImages=elementPresent(OR.img_Article_Page_TrendingStories_Images);
				
					int countArticleList=getElementCount(OR.txt_Mob_Article_Page_ArticleList);
					testStepPassed("Total Number of Articles in the Stream--->"+countArticleList);
					int countImages=getElementCount(OR.img_Article_Page_TrendingStories_Images);
					testStepPassed("Total Number of Article Images in the Stream--->"+countImages);
					
					try {
						for (int i = 1; i <=countArticleList; i++) {
							boolean checkTrendingStoryTitle=elementPresent("Article List in the Stream#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//h3");
							boolean checkImage=elementPresent("Article Stream Image#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//div[@class='ratio-holder ng-scope']");
							if(checkTrendingStoryTitle==true && checkImage==true)
							{
							String getArticleLists=getText("Article List in the Stream#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//h3");
							testStepPassed("Trending Story title--->"+i+"---"+getArticleLists);
							
							this.scrollToElement("Article List in the Stream#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//h3");
							this.scrollBy(0, -60);
							
							testStepPassed("Article stream is having image thumbnail");
							
							
							}
							else
							{
								String getArticleLists=getText("Article List in the Stream#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//h3");
								testStepPassed("Trending Story title--->"+i+"---"+getArticleLists);
								
								this.scrollToElement("Article List in the Stream#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//h3");
								this.scrollBy(0, -100);
								clickOn("Article List in the Stream#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//h3");
								
							   boolean checkImageInArticlePage=elementPresent(OR.img_Article_Page_Stream_thumbnail);
							   
							   if(checkImageInArticlePage==false)
							   {
								   getCurrentPageURL();
								   testStepPassed("Article Stream image is not present in  Article page");
								   clickOnBackButton();
							   }
							   else
							   {
								   getCurrentPageURL();
								   testStepFailed("Article Stream image is present in  Article page");
								   clickOnBackButton();
							   }
							}
						
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
					
				}
				scrollBy(0, 2500);
				boolean adStream=elementPresent(OR.ads_Article_Page_AdsStream);
				if(adStream==true)
				{
					int getCountAds=getElementCount(OR.ads_Article_Page_AdsStream);
					testStepPassed("Total Ads in the Stream--->"+getCountAds);
					if(getCountAds>=1)
					{
						for (int i = 1; i <=getCountAds; i++) {
							waitTime(3);
							
							takeAdScreenshot("Ads Stream#xpath=//article[@class='recommended-stream clearfix ng-scope stream-ad']["+i+"]/div", "Ads");
							testStepPassed("Ads in the Stream--->"+i);
						}
					}
					else
					{
						testStepFailed("Article Stream Ads are not present---");
					}
					
					
				}
				else
				{
					testStepFailed("Ads are not loaded");
				}
				
				boolean moreStoriesButton=elementPresent(OR.btn_Mob_Article_Page_More_Stories);
				if(moreStoriesButton==true)
				{
					testStepPassed("More Trending Stories Button is Displayed");
				}
				else
				{
					testStepFailed("More Trending Stories Button is not Displayed");
				}
				
			
			
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateLoadMoreNextArticle() {

		testStepInfo("************** Load More ****************");
		try {
			scrollBy(0, 3000);
			boolean nextArticleInDesktop = elementPresent(OR.txt_Reg_Article_Page_Next_Article);
			if (nextArticleInDesktop == true) {

				// scrollToElement(OR.txt_Reg_Article_Page_Next_Article);
				takeAdScreenshot(OR.txt_Reg_Article_Page_Next_Article,
						"Next Article");
				testStepPassed(" Scrolled down to Next Article");

				//validateLeftStreamArticle();
				// validateLeftRailArticleNavigation();
			//	validateLeftRailArticleNavigation(OR.txt_Reg_Article_Page_Next_Article_Title,OR.txt_Reg_Article_Page_LeftRail_Article_Heading);
			} else {
				testStepFailed("Failed to Scroll to Next Article");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	public void validateRecommendedLabel() {
		testStepInfo("************* Recommended *****************");
		try {
			this.scrollToElement(OR.txt_Reg_Article_Page_Recommended_Label);
			this.scrollBy(0, -60);
			boolean recommendedLabel = elementPresent(OR.txt_Reg_Article_Page_Recommended_Label);
			if (recommendedLabel == true) {
				testStepPassed("Recommended Label is displayed");
				
				boolean checkVestPocketImage=elementPresent(OR.img_ArticlePage_Vestpocket_Image);
				boolean checkVestPocketLabel=elementPresent(OR.txt_Article_Page_VestPocket_Label);
				if(checkVestPocketLabel==true && checkVestPocketImage==true)
				{
					String getVestPocketLabel=getText(OR.txt_Article_Page_VestPocket_Label);
					testStepPassed("Vest Pocket Label is present--"+getVestPocketLabel);
					boolean checkNextArrow=elementPresent(OR.btn_Reg_Article_Page_Recommended_NextButton);
					if(checkNextArrow==true)
					{
						this.scrollToElement(OR.btn_Reg_Article_Page_Recommended_NextButton);
						this.scrollBy(0, -60);
						clickOn(OR.btn_Reg_Article_Page_Recommended_NextButton);
						//swipeToLeft(990,40,960);
						boolean checkNextVestPocket=elementPresent(OR.txt_Article_Page_VestPocket_Label);
						if(checkNextVestPocket==true)
						{
							String getVestPocketLabel2=getText(OR.txt_Article_Page_VestPocket_Label);
							testStepPassed("Vest Pocket Label is present--"+getVestPocketLabel2);
						}
						else
						{
							testStepFailed("Next Vest Pocket label is not present when we click on next arrow");
						}
						
					}
				}
				else
				{
					testStepFailed("Vest Pocket Label and image is not present");
				}
				/*boolean nextButton=elementPresent(OR.btn_Reg_Article_Page_Recommended_NextButton);
				if(nextButton==true)
				{
					for (int i = 1; i <=2; i++) {
					
						boolean checkName=elementPresent(OR.txt_Reg_article_Page_Recommended_Name);
								if(checkName==true)
								{
									swipeToLeft(900, 40, 900);
									waitTime(3);
									waitTime(5);
									String getName=getText(OR.txt_Reg_article_Page_Recommended_Name);
									testStepPassed("Recommended Story Name---"+getName);
									clickOn(OR.btn_Reg_Article_Page_Recommended_NextButton);
								}
								else{
									testStepFailed("Next Story is not present");
								}
						
						waitTime(5);
						clickOn(OR.btn_Reg_Article_Page_Recommended_NextButton);
					}
				}*/
			} else {
				getCurrentPageURL();
				testStepInfo("Recommended Label is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	// Contributor Page

	public void validatePageLoadTime(String url, long acceptedLoadTime,
			String pageName) {
		try {
			long start = System.currentTimeMillis();
			driver.get(url);
			long finish = System.currentTimeMillis();
			long totalTime = (finish - start) / 1000;
			// testStepPassed(""+totalTime);
			testStepPassed("Total Time for page load - " + totalTime + " secs");
			if (totalTime <= acceptedLoadTime) {
				testStepPassed(pageName + " Takes Accepted Page Load Time");
			} else {
				testStepWarning("Warning: "
						+ pageName
						+ " Takes More Than Accepted Page Load time (Accepted Page Load time is "
						+ acceptedLoadTime + "secs)");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify author name.
	 */

	public void verifyAuthorName() {
		try {
			boolean authorName = elementPresent(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
			if (authorName == true) {
				String contributor = getText(OR.txt_Article_Page_contributor_Forbes_Staff_Name);

				testStepPassed("Navigated to Contributor Page--" + contributor);
				// clickOnBackButton();
			} else {
				testStepFailed("Failed to navigate to the author page");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testStepFailed("Contributor Name link is broke");
		}
	}

	public void validatecontributorDetails(String image, String aType,String contrib) {
		try {
			boolean groupContLogo = elementPresent(image);
			boolean groupType = elementPresent(aType);
			if (groupContLogo == true) {
				testStepPassed("Contributor Logo is Displayed");

			} else {
				testStepFailed(" Contributor Logo is not Displayed");
			}
			if (groupType == true) {
				String atype = getText(aType);
				testStepPassed(contrib+" Contributor Type is Displayed-" + atype);
			} else {
				testStepFailed(contrib+" Contributor Type is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	// ******************************************Contributor Redesign Code

	public void validateTagLine(String contributorTagLine) {
		testStepInfo("**************** Validating Tag Line ***************");
		try {
			boolean tagLine = elementPresent(contributorTagLine);
			if (tagLine == true) {
				String getTagLine = getText(contributorTagLine);
				testStepPassed("Contributor Tag Line is present-" + getTagLine);
			} else {
				testStepFailed("Contributor Tag Line is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyFullBio() {
		testStepInfo("************** Full Bio ***************");
		try {
			waitTime(3);
			boolean varFullBio = elementPresent(OR.btn_Contributor_Page_Full_Bio);
			if (varFullBio == true) {
				testStepPassed("Full Bio is displayed");
				clickOn(OR.btn_Contributor_Page_Full_Bio);
				String fullBio = getText(OR.txt_Contributor_Page_Full_Bio_Details);
				testStepPassed(fullBio);
				clickOn(OR.btn_Contributor_Page_Full_Bio);

			} else {
				testStepFailed("Full Bio is not displayed ");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	public void verifyFollowInDeskyop(String followOnForbes) {
		testStepInfo("**************** Follow *********************");
		try {
			boolean follow = elementPresent(followOnForbes);
			if (follow == true) {

				testStepPassed("Follow is displayed");
			} else {
				testStepFailed("Follow is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateNetworkShares(String socialShares) {
		try {
			boolean socialNet = elementPresent(socialShares);
			if (socialNet == true) {
				int count = getElementCount(socialShares);
				testStepPassed("Social Networks are displayed");
				testStepPassed("Total Social networks are-" + count);
				boolean rss = elementPresent(OR.img_Reg_Contributor_Page_Network_RSS);
				if (rss == true) {
					testStepPassed("RSS Network share is Displayed");
				} else {
					testStepFailed("RSS Network share is not Displayed");
				}
			} else {
				testStepFailed("Social Networks are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validatePromoVideoBlock() {
		try {
			boolean promoVideo = elementPresent(OR.vid_Reg_Contributor_Page_PromoVideo_Block);
			if (promoVideo == true) {
				testStepPassed("Promo Video Block is present");
			} else {
				testStepInfo("Promo video Block is not present ");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateArchiveContributor() {
		testStepInfo("****************Validating Archive***************");
		try {

			boolean latestHeader = elementPresent(OR.txt_Reg_Contributor_PAge_LatestHeader);
			if (latestHeader == true) {
				String latestPost = getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope'][1]//h2");
				testStepPassed("Latest Post is --->" + latestPost);
				waitTime(5);
				scrollBy(0, -1500);
				boolean archive = elementPresent(OR.txt_ReG_Contributor_Page_Archive);
				if (archive == true) {
					this.scrollToElement(OR.txt_ReG_Contributor_Page_Archive);
					this.scrollBy(0, -60);
					clickOn(OR.txt_ReG_Contributor_Page_Archive);
					waitTime(5);
					boolean archiveLabel = elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabel);
					boolean archivePostsCount = elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabelPostCount);
					if (archiveLabel == true && archivePostsCount == true) {
						testStepPassed("Archive List is displayed");

						clickOn(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabel);
						boolean archiveLatestPost = elementPresent(OR.txt_Reg_Contributor_Page_Archive_LatestPost);
						if (archiveLatestPost == true) {
							String getArchiveLatestPost = getText(OR.txt_Reg_Contributor_Page_Archive_LatestPost);
							testStepPassed("Archive Latest Post is Displayed--->"
									+ getArchiveLatestPost);
							/*
							 * if(latestPost.contains(getArchiveLatestPost)) {
							 * scrollBy(0, 300); testStepPassed(
							 * "Latest Post and Latest Article matching"); }
							 * else { testStepFailed(
							 * "Latest post is not displayed in the Archive Section"
							 * ); }
							 */

						} else {
							testStepFailed("Archive Latest Post is not Displayed");
						}

					} else {
						testStepFailed("Archive List is not Displayed");
					}
				}

				boolean latestLink = elementPresent(OR.txt_ReG_Contributor_Page_Archive);
				if (latestLink == true) {
					clickOn(OR.txt_ReG_Contributor_Page_Archive);
				} else {
					testStepFailed("Latest Post Link is not displayed");
				}
			} else {
				testStepFailed("Latest Header Element is not Displayed");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Validating all latest posts and Gallery
	 */
	public void clickingAllLatestPosts() {
		try {

			testStepInfo("*************Validating Ads **************");
			boolean ads = elementPresent(OR.ads_Reg_Contributor_Page_All_Ads);
			int countAds = 0;
			if (ads == true) {
				countAds = getElementCount(OR.ads_Reg_Contributor_Page_All_Ads);
				testStepPassed("Total number of Ads Present on the Page--->"
						+ countAds);
			} else {
				testStepFailed("Ads are not Displayed");
			}
			String latestPostsLinkName;
			String getViewCount;
			testStepInfo("*********Clicking on all the articles in Latest and Validating***********");
			boolean latestHeader = elementPresent(OR.txt_Reg_Contributor_PAge_LatestHeader);
			if (latestHeader == true)

			{
				int count = getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
				testStepPassed("Total Number of Posts in Latest-" + count);

				if(count==1 || count<=4)
				{
					for (int i = 1; i <=count; i++) {

						boolean latestPostslinks = elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
								+ i + "]//h2");
						boolean latestPostsImages = elementPresent("Latest Posts Images#xpath=//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
								+ i
								+ "]//a[contains(@class,'fs-bg-image article-image ratio1x1')]");
						
						
						boolean latestPostsNewPostsLable=elementPresent("Latest Posts New Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h6//span[contains(text(),'New Post')]");
						
						boolean latestPostsViewCount=elementPresent("View Count#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h6//span[@class='article-views ng-scope']");
						if (latestPostslinks == true && latestPostsImages == true && latestPostsNewPostsLable==true && latestPostsViewCount==true) {
							 getViewCount=getText("View Count#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h6//span[@class='article-views ng-scope']");
							
							latestPostsLinkName=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");
							testStepPassed("Latest Posts article is displayed with image---"+i+"-"+latestPostsLinkName);
							testStepPassed("Latest Posts view count in the article stream--"+getViewCount);
							/*openArticlesInNewWindow("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");*/
						} else {
							getCurrentPageURL();
							latestPostsLinkName=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");
							testStepPassed("Name of the Latest Post --->"
									+ latestPostsLinkName);
							testStepInfo("Latest Posts Image is not displayed--->"
									+ i);
						}

					}
					
				}
				else if(count==4)
				{
					for (int i = 1; i <=count; i++) {

						boolean latestPostslinks = elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
								+ i + "]//h2");
						boolean latestPostsImages = elementPresent("Latest Posts Images#xpath=//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
								+ i
								+ "]//a[contains(@class,'fs-bg-image article-image ratio1x1')]");
						if (latestPostslinks == true && latestPostsImages == true) {
							latestPostsLinkName=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");
							getViewCount=getText("View Count#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h6//span[@class='article-views ng-scope']");
							testStepPassed("Latest Posts article is displayed with image---"+latestPostsLinkName);
							testStepPassed("Latest Posts view count in the article stream--"+getViewCount);
							/*openArticlesInNewWindow("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");*/
						} else {
							getCurrentPageURL();
							latestPostsLinkName=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");
							testStepPassed("Name of the Latest Post --->"
									+ latestPostsLinkName);
							testStepInfo("Latest Posts Image is not displayed--->"
									+ i);
						}

					}
					
					
					testStepInfo("************ Do Not Miss ***************** ");
					boolean dontMiss = elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[5]");
					if (dontMiss == true) {
						testStepPassed("Do not Miss Section is Displayed");
					} else {
						testStepFailed("Do Not Miss Section is not Displayed");
					}
				}
				else if(count==5)
				{
					
					for (int i = 1; i <=count; i++) {

						boolean latestPostslinks = elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
								+ i + "]//h2");
						boolean latestPostsImages = elementPresent("Latest Posts Images#xpath=//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
								+ i
								+ "]//a[contains(@class,'fs-bg-image article-image ratio1x1')]");
						if (latestPostslinks == true && latestPostsImages == true) {
							latestPostsLinkName=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");
							getViewCount=getText("View Count#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h6//span[@class='article-views ng-scope']");
							testStepPassed("Latest Posts article is displayed with image---"+latestPostsLinkName);
							testStepPassed("Latest Posts view count in the article stream--"+getViewCount);
							/*openArticlesInNewWindow("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");*/
						} else {
							getCurrentPageURL();
							latestPostsLinkName=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");
							testStepPassed("Name of the Latest Post --->"
									+ latestPostsLinkName);
							testStepInfo("Latest Posts Image is not displayed--->"
									+ i);
						}

					}
					testStepInfo("************ Do Not Miss ***************** ");
					boolean dontMiss = elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[5]");
					if (dontMiss == true) {
						testStepPassed("Do not Miss Section is Displayed");
					} else {
						testStepFailed("Do Not Miss Section is not Displayed");
					}

					testStepInfo("***************Validating Latest Posts By Clicking on the See More Button***********");
					// scrollBy(0, 1000);
					boolean seeMore = elementPresent(OR.btn_Reg_Contributor_Page_SeeMore);
					if (seeMore == true) {
						this.scrollToElement(OR.btn_Reg_Contributor_Page_SeeMore);
						this.scrollBy(0, -50);
						clickOn(OR.btn_Reg_Contributor_Page_SeeMore);
						// refreshPage();
						waitTime(5);
						testStepInfo("***********Validating Ads are Loaded *********");
						boolean adsSeeMore = elementPresent(OR.ads_Reg_Contributor_Page_All_Ads);
						int countAdsSeeMore = 0;
						if (adsSeeMore == true) {
							countAdsSeeMore = getElementCount(OR.ads_Reg_Contributor_Page_All_Ads);
							testStepPassed("Total number of Ads Present on the Page--->"
									+ countAdsSeeMore);
							if (countAdsSeeMore >= countAds) {
								testStepPassed("Validating Ads are loaded");
							} else {
								testStepFailed("Ads are not loaded");
							}
						} else {
							testStepFailed("Ads are not Displayed");
						}
						// refreshPage();
						
						
							this.scrollToElement(OR.txt_Reg_Contributor_Page_LatestPosts);
							this.scrollBy(0, -100);
							int countPosts = getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
							testStepPassed("Total number of Posts--->" + countPosts);
							if (countPosts > count) {
								
								
								testStepPassed("Latest Posts are Displayed after Clicking on See More Button");

								/*boolean latestPosts = elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope'][6]//h2");
								if (latestPosts == true) {
									openArticlesInNewWindow("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope'][6]//h2");
								} else {
									testStepFailed("Latests Posts are not Displayed");
								}*/
							} else {
								testStepFailed("Latest Posts are not Displayed after clicking on See More Button");
							}
						
						
					} else {
						testStepFailed("See More Button is not Present");
					}
				}
				
				else
				{
					testStepFailed("Latest Posts are not present");
				}
				
				

			} else {
				testStepFailed("Latest Header Element is not displayed");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void validateAlLatestPosts() {
		try {

			testStepInfo("*************Validating Ads **************");
			boolean ads = elementPresent(OR.ads_Reg_Contributor_Page_All_Ads);
			int countAds = 0;
			if (ads == true) {
				countAds = getElementCount(OR.ads_Reg_Contributor_Page_All_Ads);
				testStepPassed("Total number of Ads Present on the Page--->"
						+ countAds);
			} else {
				testStepFailed("Ads are not Displayed");
			}
			String latestPostsLinkName;
			testStepInfo("*********Clicking on all the articles in Latest and Validating***********");
			boolean latestHeader = elementPresent(OR.txt_Reg_Contributor_PAge_LatestHeader);
			if (latestHeader == true)

			{
				int count = getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
				testStepPassed("Total Number of Posts in Latest-" + count);

				if(count==1 || count<=4)
				{
					for (int i = 1; i <=count; i++) {

						boolean latestPostslinks = elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
								+ i + "]//h2");
						boolean latestPostsImages = elementPresent("Latest Posts Images#xpath=//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
								+ i
								+ "]//a[contains(@class,'fs-bg-image article-image ratio1x1')]");
						if (latestPostslinks == true && latestPostsImages == true) {
							latestPostsLinkName=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");
							testStepPassed("Latest Posts article is displayed with image---"+latestPostsLinkName);
							/*openArticlesInNewWindow("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");*/
						} else {
							getCurrentPageURL();
							latestPostsLinkName=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
									+ i + "]//h2");
							testStepPassed("Name of the Latest Post --->"
									+ latestPostsLinkName);
							testStepInfo("Latest Posts Image is not displayed--->"
									+ i);
						}

					}
				}
				else if(count==5)
				{
					
					testStepInfo("***************Validating Latest Posts By Clicking on the See More Button***********");
					// scrollBy(0, 1000);
					boolean seeMore = elementPresent(OR.btn_Reg_Contributor_Page_SeeMore);
					if (seeMore == true) {
						this.scrollToElement(OR.btn_Reg_Contributor_Page_SeeMore);
						this.scrollBy(0, -50);
						clickOn(OR.btn_Reg_Contributor_Page_SeeMore);
						// refreshPage();
						waitTime(5);
						testStepInfo("***********Validating Ads are Loaded *********");
						boolean adsSeeMore = elementPresent(OR.ads_Reg_Contributor_Page_All_Ads);
						int countAdsSeeMore = 0;
						if (adsSeeMore == true) {
							countAdsSeeMore = getElementCount(OR.ads_Reg_Contributor_Page_All_Ads);
							testStepPassed("Total number of Ads Present on the Page--->"
									+ countAdsSeeMore);
							if (countAdsSeeMore >= countAds) {
								testStepPassed("Validating Ads are loaded");
							} else {
								testStepFailed("Ads are not loaded");
							}
						} else {
							testStepFailed("Ads are not Displayed");
						}
						// refreshPage();
						
						
							this.scrollToElement(OR.txt_Reg_Contributor_Page_LatestPosts);
							this.scrollBy(0, -100);
							int countPosts = getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
							testStepPassed("Total number of Posts--->" + countPosts);
							if (countPosts > count) {
								
								
								testStepPassed("Latest Posts are Displayed after Clicking on See More Button");

								/*boolean latestPosts = elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope'][6]//h2");
								if (latestPosts == true) {
									openArticlesInNewWindow("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope'][6]//h2");
								} else {
									testStepFailed("Latests Posts are not Displayed");
								}*/
							} else {
								testStepFailed("Latest Posts are not Displayed after clicking on See More Button");
							}
						
						
					} else {
						testStepFailed("See More Button is not Present");
					}
				}
				
				else
				{
					testStepFailed("Latest Posts are not present");
				}
				
				

			} else {
				testStepFailed("Latest Header Element is not displayed");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void verifyContributorNameInMobile()
	{
		testStepInfo("************ Contributor Details *******************");
		try {
			boolean authorName=elementPresent(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
			if(authorName==true)
			{
				
				testStepPassed("Author name is displayed");
			}
			else
			{
				testStepFailed("Author name is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateMostPopularArticles()  {
		testStepInfo("************Validating Most Popular Articles***********");
		try {
			scrollBy(0, 1500);
			boolean mostPopularLabel = elementPresent(OR.txt_Reg_Contributor_Page_MostPopular_Label);
			if (mostPopularLabel == true) {
				testStepPassed("Most Popular Label is Present");
				
				
				boolean mostPopular = elementPresent(OR.txt_Reg_Contributor_Page_MostPopular_Total_Articles);
				if (mostPopular == true) {
					int countMostPopular = getElementCount(OR.txt_Reg_Contributor_Page_MostPopular_Total_Articles);
					testStepPassed("Total number of Most Popular Articles --->"
							+ countMostPopular);

					String getMostPopularArticles;
					boolean currentArticles = elementPresent(OR.txt_Reg_Contributor_Page_MostPopular_CurrentArticles);
					if (currentArticles == true) {
						int countCurrentArticles = getElementCount(OR.txt_Reg_Contributor_Page_MostPopular_CurrentArticles);
						testStepPassed("Total number of articles present----"+countCurrentArticles);
						for (int i = 1; i <= countCurrentArticles; i++) {
							getMostPopularArticles=	getText("Most Popular Current Articles#xpath=//div[@class='slick-list draggable']//div[@class='slick-track']/div[contains(@class,'slick-active')]["
									+ i
									+ "]//article[@class='trending-article']//h2//span");
							testStepPassed("Most Popular Posts are present in the current Article-- "+i+"--"+getMostPopularArticles);
							/*openArticlesInNewWindow("Most Popular Current Articles#xpath=//div[@class='slick-list draggable']//div[@class='slick-track']/div[contains(@class,'slick-active')]["
									+ i
									+ "]//article[@class='trending-article']//h2//span");*/

						}
						scrollBy(0, 100);
						boolean nextButton = elementPresent(OR.btn_Reg_Contributor_Page_MostPopular_NextButton);
						if (nextButton == true) {
							this.scrollToElement(OR.btn_Reg_Contributor_Page_MostPopular_NextButton);
							this.scrollBy(0, -60);
							clickOn(OR.btn_Reg_Contributor_Page_MostPopular_NextButton);
							boolean isNextmostPopularArticle=elementPresent("Most Popular Current Articles#xpath=//div[@class='slick-list draggable']//div[@class='slick-track']/div[contains(@class,'slick-active')][1]//article[@class='trending-article']//h2//span");
							if(isNextmostPopularArticle==true)
							{
								String getNextMostPopularArticle=getText("Most Popular Current Articles#xpath=//div[@class='slick-list draggable']//div[@class='slick-track']/div[contains(@class,'slick-active')][1]//article[@class='trending-article']//h2//span");
								testStepPassed("Validating Next Slide Article is displayed-"+getNextMostPopularArticle);
							}
							//openArticlesInNewWindow("Most Popular Current Articles#xpath=//div[@class='slick-list draggable']//div[@class='slick-track']/div[contains(@class,'slick-active')][1]//article[@class='trending-article']//h2//span");
						} else {
							testStepInfo("Validating Next Slide Article: Next Button is not Present");
						}

					}
				} else {
					getCurrentPageURL();
					testStepFailed("Most Popular Articles are not Present");
				}
			} else {
				getCurrentPageURL();
				testStepFailed("Most Popular Label is not Present");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Author : Shakira Created on : 23 June 2016
	 * 
	 */
	public void verifyContributorDetailsInMobile() {
		testStepInfo("*********** Contributor Details *************");
		try {
			boolean authorName = elementPresent(OR.txt_Mob_Contributor_Page_Author_Name);
			if (authorName == true) {

				//clickOn(OR.txt_Mob_Contributor_Page_Author_Name);

				/*
				 * String url=driver.getCurrentUrl(); testStepPassed(url);
				 * String[] splittedUrl= url.split("#"); String
				 * firstPart=splittedUrl[0]; String secPart=splittedUrl[1];
				 * testStepPassed(firstPart); //testStepPassed(secPart); String
				 * appenedURL=firstPart.concat("?view=csf_contrib");
				 * driver.get(appenedURL);
				 */
				testStepPassed("Author name is displayed");
			} else {
				getCurrentPageURL();
				testStepFailed("Author name is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyAuthorNameInMobile() {
		//testStepInfo("************************************* Contributor Details ************************************************");
		try {
			/*
			 * boolean contributorImage =
			 * elementPresent(OR.img_Mob_Contributor_Page_Author_Image); if
			 * (contributorImage == true) {
			 * testStepPassed("Contributor image is displayed"); } else {
			 * testStepFailed("Contributor image is not displayed"); }
			 */
			boolean contributor = elementPresent(OR.txt_Mob_Contributor_Page_Author);
			if (contributor == true) {
				String contributorName = getText(OR.txt_Mob_Contributor_Page_Author);
				testStepPassed("Author Name is displayed---" + contributorName);
			} else {
				testStepFailed("Author Name is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateSocialnetworks(String socialShares) {
		testStepInfo("**************** Top Social Shares**************");
		try {
			waitTime(2);
			this.scrollToElement(socialShares);
			this.scrollBy(0, -60);
			boolean socialNet = elementPresent(socialShares);
			if (socialNet == true) {
				int count = getElementCount(socialShares);
				testStepPassed("Top Social Networks are displayed");
				testStepPassed("Total Social networks are-" + count);
			} else {
				getCurrentPageURL();
				testStepFailed("Social Networks are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateLatestPostsInMobile() {
		testStepInfo("***********Clicking on all the articles in Latest and Validating***********");
		try {
			// scrollBy(0, 300);
			int count = getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
			testStepPassed("Total Number of Posts in Latest-" + count);

			for (int i = 1; i <=count; i++) {

				boolean latestPostslinks = elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']//h2//span");
				boolean latestPostsImages = elementPresent("Latest Posts Images#xpath=//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
						+ i
						+ "]//a[contains(@class,'fs-bg-image article-image ratio1x1')]");
				// boolean
				// latestGallery=elementPresent("Latest Gallery#xpath=//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//a[@class='fs-bg-image article-image ratio1x1 stream-gallery']");
				if (latestPostslinks == true && latestPostsImages == true) {
					this.scrollToElement("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
							+ i + "]//h2");
					this.scrollBy(0, -60);
					// takeAdScreenshot("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2",
					// "Latest Posts");
					String getLatestPosts=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
							+ i + "]//h2");
					testStepPassed(getLatestPosts);
					// scrollBy(0, 80);
				}

				else {
					getCurrentPageURL();
					String latestPostsLinkName = getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["
							+ i + "]//h2");
					testStepPassed("Name of the Latest Post --->"
							+ latestPostsLinkName);
					testStepInfo("Latest Posts Image is not displayed--->" + i);
				}
			}

			testStepInfo("*************** Validating Show More Button*************");
			boolean showMore = elementPresent(OR.btn_Reg_Contributor_Page_SeeMore);
			if (showMore == true) {
				this.scrollToElement(OR.btn_Reg_Contributor_Page_SeeMore);
				this.scrollBy(0, -60);
				clickOn(OR.btn_Reg_Contributor_Page_SeeMore);
				waitTime(5);
				int countLatest = getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
				testStepPassed("Total Number of Posts in Latest-" + countLatest);
				if (countLatest > count) {
					testStepPassed("Latest Posts are displayed after clicking on Show more button");
				} else {
					testStepFailed("Latest Posts are not displayed after clicking on Show more button");
				}

			} else {
				testStepFailed("Show More Button is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	public void validateMostPopularArticlesInMobile() {
		testStepInfo("*************Validating all the articles in Most Popular************");
		try {
			this.scrollBy(0, -60);
			boolean mostPopularLabel = elementPresent(OR.txt_Reg_Contributor_Page_MostPopular_Label);
			if (mostPopularLabel == true) {
				testStepPassed("Most Popular Label is Present");
				
				
				boolean mostPopularLinks = elementPresent("Most Popular Articles#xpath=//div[@class='trending-item ng-scope']//article[@class='trending-article']//h2//span");
				if (mostPopularLinks == true) {
					int getCount = getElementCount("Most Popular Articles#xpath=//div[@class='trending-item ng-scope']//article[@class='trending-article']//h2//span");
					testStepPassed("Total Number of Most Popular Articles--->"
							+ getCount);
					for (int i = 1; i <= getCount; i++) {

						String getMostPopularLinks = getText("Most Popular Articles#xpath=//div[@class='trending-item ng-scope']["
								+ i
								+ "]//article[@class='trending-article']//h2//span");
						testStepPassed("Most Popular Article Name--->" + i + "--->"
								+ getMostPopularLinks);
					/*	this.scrollToElement("Most Popular Articles#xpath=//div[@class='trending-item ng-scope']["
								+ i + "]//article[@class='trending-article']");
						this.scrollBy(0, -80);
						clickOn("Most Popular Articles#xpath=//div[@class='trending-item ng-scope']["
								+ i + "]//article[@class='trending-article']");
						validateHeadLineArticleInMobile();*/
					}

				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Most Popular Articles are not displayed");
				}
			} else {
				getCurrentPageURL();
				testStepFailed("Most Popular Label is not Present");
			}
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	// BrandVoice Page

	public void validateContributorImage(String contribImage) {

		try {
			boolean contribImg = elementPresent(contribImage);
			if (contribImg == true) {
				testStepPassed("Contributor Image is Displayed");
			} else {
				testStepFailed("Contributor Image is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateVoiceLogo(String forbesLogo, String voiceLogo,
			String VoiceName) {
		testStepInfo("*****************Validating Voice Logo****************");
		try {
			boolean forbesCommVoiceLogo = elementPresent(forbesLogo);
			boolean communityVoiceLogo = elementPresent(voiceLogo);
			if (forbesCommVoiceLogo == true) {
				testStepPassed("Forbes " + VoiceName + " Logo is Displayed");
			} else {
				testStepFailed("Forbes  " + VoiceName
						+ " Logo is not Displayed");
			}
			if (communityVoiceLogo == true) {
				testStepPassed("" + VoiceName + " Logo is Displayed");
			} else {
				testStepFailed("" + VoiceName + " Logo is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateWhatIsThisLabel() {
		testStepInfo("**************What Is this Link**************");
		boolean whatIsThis = elementPresent(OR.link_BVHomePage_whatisthis);
		if (whatIsThis == true) {
			testStepPassed("What is this Link is displayed");

			mouseOver(OR.link_BVHomePage_whatisthis);
			testStepPassed("What Is This is displayed");
			/*
			 * this.scrollToElement(OR.link_BVHomePage_whatisthis);
			 * this.scrollBy(0, -60); clickOn(OR.link_BVHomePage_whatisthis);
			 * waitTime(5); boolean whatIsThisDescr=elementPresent(OR.
			 * txt_Reg_BrandVoice_What_Is_This_Description);
			 * if(whatIsThisDescr==true) {
			 * testStepPassed("What Is This Description is displayed"); } else {
			 * testStepFailed("What Is This Description is not Displayed"); }
			 * this.scrollToElement(OR.link_BVHomePage_whatisthis);
			 * this.scrollBy(0, -60); clickOn(OR.link_BVHomePage_whatisthis);
			 */
			// clickOn(OR.link_BVHomePage_whatisthisCloseButton);

		} else {
			testStepFailed("What is this is not displayed");
		}
	}

	public void validatePromoSectionInBrandVoice() {
		testStepInfo("***********Validating Promo Section*************");
		try {
			boolean promo = elementPresent(OR.txt_Reg_Brandvoice_Article_Page_Promo);
			if (promo == true) {
				testStepPassed("BV Promo block is displayed");
				//openArticlesInNewWindow(OR.txt_Reg_Brandvoice_Article_Page_Promo);
			} else {
				testStepInfo("Promo Section is not Displayed");
			}

			boolean promoRelatedArticles = elementPresent(OR.txt_Reg_Brandvoice_PromoBlockRelated_Articles);
			if (promoRelatedArticles == true) {

				int countRelatedArticles = getElementCount(OR.txt_Reg_Brandvoice_PromoBlockRelated_Articles);
				testStepPassed("Related Articles in Promo Section--->"
						+ countRelatedArticles);
				for (int i = 1; i <= countRelatedArticles; i++) {
					String relatedArticles=getText("Related Articles#xpath=//ul[@class='related-articles clearfix']//li["
							+ i + "]//h3/span");
					testStepPassed("Promo Block Articles are displayed");
					/*openArticlesInNewWindow("Related Articles#xpath=//ul[@class='related-articles clearfix']//li["
							+ i + "]//h3/span");*/
				}
			} else {
				testStepInfo("Related Articles are not Present in the Promo Section");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateAboutSection() {
		testStepInfo("******************About Section*****************");
		try {
			boolean aboutLabel = elementPresent(OR.txt_Reg_Group_Contributor_AboutLabel);

			if (aboutLabel == true) {
				testStepPassed("Group Contributor Page-->About Label is displayed");
			} else {
				testStepFailed("Group Contributor Page-->About Label  is not displayed");
			}
			boolean aboutDescription = elementPresent(OR.txt_Reg_Group_Contributor_AboutDescription);
			if (aboutDescription == true) {
				String getAboutDescription = getText(OR.txt_Reg_Group_Contributor_AboutDescription);
				testStepPassed("About Description is Displayed--->"
						+ getAboutDescription);
				boolean readMore = elementPresent(OR.icons_readmoreInAbout);
				if (readMore == true) {
					this.scrollToElement(OR.icons_readmoreInAbout);
					this.scrollBy(0, -60);
					clickOn(OR.icons_readmoreInAbout);

					boolean readLess = elementPresent(OR.icons_readlessInAbout);
					if (readLess == true) {
						this.scrollToElement(OR.icons_readlessInAbout);
						this.scrollBy(0, -60);
						clickOn(OR.icons_readlessInAbout);
					} else {
						testStepInfo("Read Less Button is not displayed");
					}
				} else {
					testStepInfo("Read More button is not Displayed");
				}
			} else {
				testStepFailed("About Description is not Displayed");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	public void validateOurWriters() {
		testStepInfo("********** Our Writer ******************");
		try {
			// scrollBy(0, 200);
			boolean writerLabel = elementPresent(OR.txt_Reg_Group_Contributor_WriterLAbel);
			if (writerLabel == true) {
				testStepPassed("Our writer Label is Displayed");
			} else {
				testStepFailed("Our Writer Label is not Displayed");
			}
			boolean writerLists = elementPresent(OR.img_Reg_Group_Contributor_WritersList);
			if (writerLists == true) {
				int countWriters = getElementCount(OR.img_Reg_Group_Contributor_WritersList);
				testStepPassed("Total number of Writers --->" + countWriters);

				boolean loadMore = elementPresent(OR.btn_Reg_Group_Contributor_LoadMore);
				if (loadMore == true) {
					this.scrollToElement(OR.btn_Reg_Group_Contributor_LoadMore);
					this.scrollBy(0, -60);
					clickOn(OR.btn_Reg_Group_Contributor_LoadMore);

					int countOurWriters = getElementCount(OR.img_Reg_Group_Contributor_WritersList);
					testStepPassed("After clicking on Load More Total number of Writers --->"
							+ countOurWriters);
					if (countOurWriters > countWriters) {
						testStepPassed("Writers are loaded after clicking on Load more button");
						// scrollBy(0, 500);
						boolean loadMoreLess = elementPresent(OR.btn_Reg_Group_Contributor_LoadMoreLess);
						if (loadMoreLess == true) {
							this.scrollToElement(OR.btn_Reg_Group_Contributor_LoadMoreLess);
							this.scrollBy(0, -60);
							clickOn(OR.btn_Reg_Group_Contributor_LoadMoreLess);
						} else {
							getCurrentPageURL();
							testStepFailed("Load more Less Button is not Displayed");
						}
					} else {
						getCurrentPageURL();
						testStepFailed("Writers are not loaded after clicking on Load more button");
					}
				}
			} else {
				getCurrentPageURL();
				testStepFailed("Writer List is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	public void validateWritersHomePage() {
		testStepInfo("********* Writer Page*************");
		try {
			boolean writerLists = elementPresent(OR.img_Reg_Group_Contributor_WritersList);
			if (writerLists == true) {
				for (int i = 1; i <= 1; i++) {

					this.scrollToElement("Writers List#xpath=//div[@class='writers clearfix ng-scope']//ul//li[1]//img");
					this.scrollBy(0, -60);
					clickOn("Writers List#xpath=//div[@class='writers clearfix ng-scope']//ul//li[1]//img");
					boolean writerName = elementPresent(OR.txt_Reg_GroupContributor_WriterName);
					if (writerName == true) {
						String getWriterName = getText(OR.txt_Reg_GroupContributor_WriterName);
						testStepPassed("Writer Name is ---->" + getWriterName);

						scrollBy(0, 800);
						boolean writersBio = elementPresent(OR.txt_Reg_Group_Contributor_WriterBio);
						if (writersBio == true) {
							String getWritersBio = getText(OR.txt_Reg_Group_Contributor_WriterBio);
							testStepPassed("Writer's bio--->" + getWritersBio);
							boolean viewAllPosts = elementPresent(OR.btn_Reg_Group_Contributor_View_All_Posts);
							if (viewAllPosts == true) {
								this.scrollToElement(OR.btn_Reg_Group_Contributor_View_All_Posts);
								this.scrollBy(0, -60);
								clickOn(OR.btn_Reg_Group_Contributor_View_All_Posts);
								waitTime(5);
								String title = driver.getTitle();
								String currentURl = driver.getCurrentUrl();
								testStepPassed(currentURl);
								testStepPassed("Title of the Page-->" + title);
								/*
								 * String getWriterName1=getText(OR.
								 * txt_Reg_GroupContributor_WriterName);
								 * testStepPassed
								 * ("Writer Name is ---->"+getWriterName1);
								 * if(title.contains(getWriterName)
								 * ||currentURl.contains(getWriterName)
								 * ||getWriterName1.contains(getWriterName))
								 * 
								 * { testStepPassed("Writer Name is matching");
								 * } else { getCurrentPageURL();
								 * testStepFailed("Write Name is not matched");
								 * }
								 */
								clickOnBackButton();
								waitTime(5);
							}
						}
					}

				}
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateFilterTabs() {
		testStepInfo("*************Validating BrandVoice Filter Tabs**********");
		boolean tabs = elementPresent(OR.tab_Reg_BrandVoice_AllTab);
		if (tabs == true) {
			int countTabs = getElementCount(OR.tab_Reg_BrandVoice_AllTab);
			testStepPassed("Total number of Tabs--->" + countTabs);
			for (int i = 2; i <= countTabs; i++) {
				boolean checkTabs = elementPresent("Brandvoice Tabs#xpath=//div[@class='sub-blogs-list ng-scope']//li["
						+ i + "]/a");
				if (checkTabs == true) {
					String tabNameInFilter = getText("Brandvoice Tabs#xpath=//div[@class='sub-blogs-list ng-scope']//li["
							+ i + "]/a");
					testStepInfo("************************Validating the filter---->"
							+ i + "-" + tabNameInFilter + "***************");
					this.scrollToElement("Brandvoice Tabs#xpath=//div[@class='sub-blogs-list ng-scope']//li["
							+ i + "]/a");
					this.scrollBy(0, -60);
					clickOn("Brandvoice Tabs#xpath=//div[@class='sub-blogs-list ng-scope']//li["
							+ i + "]/a");
					/*
					 * String url=driver.getCurrentUrl(); testStepPassed(url);
					 * String[] splittedUrl= url.split("#"); String
					 * firstPart=splittedUrl[0]; String secPart=splittedUrl[1];
					 * testStepPassed(firstPart); //testStepPassed(secPart);
					 * String appenedURL=firstPart.concat("?view=csf_contrib");
					 * driver.get(appenedURL); scrollBy(0, 400);
					 */

					testStepInfo("***********Validating Tab name with Latest**********");
					boolean tabName = elementPresent(OR.txt_Reg_BrandVoice_TabNameInLatest);
					if (tabName == true) {
						String getTabName = getText(OR.txt_Reg_BrandVoice_TabNameInLatest);
						testStepPassed("Tab Name in the Latest---->"
								+ getTabName);
						String[] splitString = getTabName.split("LATEST IN");
						String sec = splitString[1];
						String removeSpace[] = sec.split("\\s");
						String s1 = removeSpace[0];
						String s2 = removeSpace[1];
						// testStepPassed(s1);
						// testStepPassed(s2);
						//testStepPassed("-" + sec);

						if (tabNameInFilter.contains(s2)) {
							testStepPassed("Filter Tab name is matching with Latest ");
						} else {
							getCurrentPageURL();
							testStepFailed("Filter Tab name is not matching with Latest ");
						}
					} else {
						testStepFailed("Tab Name is not Displayed");
					}
					//clickingAllLatestPosts();
					//validateMostPopularArticles();
					clickOnBackButton();
					// clickOnBackButton();
				} else {
					getCurrentPageURL();
					testStepFailed("BrandVoice Tab is not Displayed-->" + i);
				}

			}
		} else {
			getCurrentPageURL();
			testStepFailed("BrandVoice Tab is not Displayed");
		}
	}
	

	
	// Special Features
		public void verifyColehaanContentsInDesktop() {
			boolean isdisplayed = elementPresent(OR.img_Colehaanimage);
			if (isdisplayed == true) {
				testStepPassed("Cole haan SF >> Intro image is displayed");
			} else {
				testStepFailed("Cole haan SF >> Intro image is not displayed");
			}
			waitTime(3);
			checkAdsOnColeHaanCSF();
			scrollBy(0, 1000);
		}
		public void verifydellContentsInDesktop() {
			boolean islogo = elementPresent(OR.txt_bvlogo);
			if (islogo == true) {
				testStepPassed("BV SF >>BV Logo is displayed");
			} else {
				testStepFailed("BV SF >> BV tag line is displayed");
			}
			boolean istag = elementPresent(OR.txt_bvtag);
			if (istag == true) {
				testStepPassed("BV SF >>BV Logo is displayed");
			} else {
				testStepFailed("BV SF >> BV tag line is displayed");
			}
			checkAdsOnBVCSF();
			boolean isdisplayed = elementPresent(OR.txt_DellVoice);
			if (isdisplayed == true) {
				testStepPassed("Dell  SF >> Dell Voice text is displayed upon scroll");
			} else {
				testStepFailed("Dell  SF >> Dell Voice text is not displayed upon scroll");
			}
			waitTime(3);
			checkSections_DellSFF();

		}
		
		public void checkAdsOnBVCSF() {
			boolean isad1displayed = elementPresent(OR.ad_ColehaanFirstTopad);

			if (isad1displayed == true) {
				testStepPassed("Dell SF >> First Ad is loaded and displayed");
			} else {
				testStepFailed("Dell SF >> First Ad is not loaded and not displayed");
			}
			scrollBy(0, 7000);
			waitTime(5);
			boolean isad2displayed = elementPresent(OR.ad_DellSecondAd);

			if (isad2displayed == true) {
				testStepPassed("Dell SF >> Second Ad is loaded and displayed");
			} else {
				testStepFailed("Dell SF >> Second Ad is not loaded and not displayed");
			}
		}

		public void checkSections_DellSFF() {
			try {
				testStepInfo("*******validating sections********");
				for (int i = 0; i < 11; i++) {
					String sections = "#xpath=//section[@id='row-" + i + "']";
					if (elementPresent(sections)) {
						testStepPassed("Dell SF >> Section-" + i
								+ " is loaded and displayed");
					} else {
						testStepFailed("Dell SF >> Section-" + i
								+ " is not loaded and not displayed");
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}

		}
		
		public void verifyoppenheimerContentsInDesktop() {
			verifySFBVLogoInDesktop();
			waitTime(3);
			checkads("//div[@csf-ad-unit='top']");
			checkSections_OppenheimerSFF();

		}

		public void checkSections_OppenheimerSFF() {
			try {
				testStepInfo("*******validating sections********");
				for (int i = 0; i < 8; i++) {
					String sections = "#xpath=//section[@id='row-" + i + "']";
					if (elementPresent(sections)) {
						testStepPassed("OppenheimerFunds SF >> Section-" + i
								+ " is loaded and displayed");
					} else {
						testStepFailed("OppenheimerFunds SF >> Section-" + i
								+ " is not loaded and not displayed");
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}

		}
		public void checkads(String strXpath) {
			try {
				this.scrollBy(0, 30);
				List<WebElement> elements = driver.findElements(By.xpath(strXpath));
				int count = elements.size();
				for (int i = 0; i < count; i++) {
					if (elements.get(i).isDisplayed()) {
						testStepPassed("Ad " + i + " is displayed");
						scrollBy(0, 1200);
					} else {
						testStepPassed("Ad " + i + " is not displayed");
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		public void verifySFBVLogoInDesktop() {
			try {

				boolean islogo = elementPresent(OR.txt_bvlogo);
				if (islogo == true) {
					testStepPassed("BV SF >>BV Logo is displayed");
				} else {
					testStepFailed("BV SF >> BV tag line is displayed");
				}
				boolean istag = elementPresent(OR.txt_bvtag);
				if (istag == true) {
					testStepPassed("BV SF >>BV Logo is displayed");
				} else {
					testStepFailed("BV SF >> BV tag line is displayed");
				}
			} catch (Exception e) {
				writeToLogFile((String) "ERROR",
						(String) ("Exception: " + e.toString()));
			}
		}
		
		public void checkAdsOnColeHaanCSF() {
			scrollBy(0, 700);
			waitTime(5);
			boolean isad1displayed = elementPresent(OR.ad_ColehaanFirstTopad);
			if (isad1displayed == true) {
				testStepPassed("Cole haan SF >> First Ad is loaded and displayed");
			} else {
				testStepFailed("Cole haan SF >> First Ad is not loaded and not displayed");
			}
			scrollBy(0, 4000);
			boolean isad2displayed = elementPresent(OR.ad_ColehaanSecondTopad);

			if (isad2displayed == true) {
				testStepPassed("Cole haan SF >> Second Ad is loaded and displayed");
			} else {
				testStepFailed("Cole haan SF >> Second Ad is not loaded and not displayed");
			}
		}
	public void checkads() {
		try {
			testStepInfo("*******validating Ads********");
			isListDisplayedOnMobile(OR.ads_JohnHancockVoice);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	public void checkSections_JohnHancockSFF() {
		try {
			testStepInfo("*******validating sections********");
			for (int i = 0; i < 10; i++) {
				String sections = "#xpath=//section[@id='row-" + i + "']";
				if (elementPresent(sections)) {
					testStepPassed("Dell SF >> Section-" + i
							+ " is loaded and displayed");
				} else {
					testStepFailed("Dell SF >> Section-" + i
							+ " is not loaded and not displayed");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	
	
	public void checktheChapters(String strXpath) {
		try {
			// this.scrollBy(0, 30);
			List<WebElement> elements = driver.findElements(By.xpath(strXpath));
			int count = elements.size();
			for (int i = 0; i < count; i++) {
				if (elements.get(i).isDisplayed()) {
					testStepPassed("Chpater " + i + " is displayed");
				} else {
					testStepPassed("Chapter " + i + " is not displayed");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void verifyKPMGContentsInDesktop() {
		boolean islogo = elementPresent(OR.txt_bvlogo);
		if (islogo == true) {
			testStepPassed("BV SF >>BV Logo is displayed");
		} else {
			testStepFailed("BV SF >> BV Logo is not displayed");
		}
		boolean istag = elementPresent(OR.txt_bvtag);
		if (istag == true) {
			testStepPassed("BV SF >>BV tag line is displayed");
		} else {
			testStepFailed("BV SF >> BV tag line is not displayed");
		}
		waitTime(3);
		boolean isheader = elementPresent(OR.txt_KPMGVoice);
		if (isheader == true) {
			testStepPassed("BV SF >>BV Header Label is displayed");
		} else {
			testStepFailed("BV SF >> BV Header label is not displayed");
		}
		waitTime(3);
		boolean isMissionLinkDisplayed = elementPresent(OR.txt_KPMGVoiceMission);
		boolean isChapterLinkDisplayed = elementPresent(OR.txt_KPMGVoiceChapters);
		if (isMissionLinkDisplayed == true && isChapterLinkDisplayed == true) {
			testStepPassed("KPMG SF SF >>Mission and Chapters is displayed");
			clickOn(OR.txt_KPMGVoiceMission);
			boolean isadDisplayed = elementPresent(OR.txt_KPMGVoiceSFAd);
			boolean issectionDisplayed = elementPresent(OR.txt_KPMGMission_Section);
			if (isadDisplayed == true) {
				testStepPassed("KPMG SF >>Ad is displayed");
			} else {
				testStepPassed("KPMG SF>>Ad is not displayed");
			}
			if (issectionDisplayed == true) {
				testStepPassed("KPMG SF >>sexction is displayed");
			} else {
				testStepPassed("KPMG SF >>Section is not displayed");
			}
		} else {
			testStepPassed("KPMG SF >>Mission and Chapters is not displayed");
		}
		clickOnBackButton();
		checktheChapters("//ul[@class='ww-chapters__menu__items']/li");

	}

	
	public void verifyjohnhancockContentsInDesktop() {
		boolean islogo = elementPresent(OR.txt_bvlogo);
		if (islogo == true) {
			testStepPassed("BV SF >>BV Logo is displayed");
		} else {
			testStepFailed("BV SF >> BV tag line is displayed");
		}
		boolean istag = elementPresent(OR.txt_bvtag);
		if (istag == true) {
			testStepPassed("BV SF >>BV Logo is displayed");
		} else {
			testStepFailed("BV SF >> BV tag line is displayed");
		}
		waitTime(3);
		scrollBy(0, 2000);
		checkads();
		checkSections_JohnHancockSFF();
	}
	
	
	// Login

	public void verifyLoginPage() {

		try {
			waitForElement(OR.txt_Login_Page_User_Name);
			boolean loginUsername = elementPresent(OR.txt_Login_Page_User_Name);
			boolean loginPassword = elementPresent(OR.txt_Login_Page_Password);
			if (loginUsername == true && loginPassword == true) {
				typeIn(OR.txt_Login_Page_User_Name, retrieve("txtUserName"));
				typeIn(OR.txt_Login_Page_Password, retrieve("txtPassword"));
				clickOn(OR.btn_Login_Page_Login);
			} else {
				testStepFailed("Login Page is not Opened");
			}
			waitTime(5);
			// boolean errorMsg =
			// elementPresent(OR.txt_Login_Page_Error_Message);
			// boolean fieldError =
			// elementPresent(OR.txt_Login_Page_Field_Req_Error);
			/*boolean user = elementPresent(OR.txt_Login_Page_User_Link);
			if (user == true) {

				String userName = getText(OR.txt_Login_Page_User_Link);
				testStepPassed("Logged into this user-" + userName);
				// clickOn(OR.txt_Login_Page_Logout);
				testStepPassed("Login is verified Successfully");

			} else {

				testStepFailed("Invalid User Name and Password");

			}*/
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Verify US tab is clicking
	 */
	public void verifyUSUserZone() {
		testStepInfo("***************** User Zone Tabs ****************");
		try {
			boolean usTab = elementPresent(OR.txt_Home_User_Zone_US);

			if (usTab == true) {
				// clickOn(OR.txt_Home_User_Zone_US);
				testStepPassed("US tab is displayed");
			} else {
				testStepFailed("US tab is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify Europe tab is clicking
	 */
	public void verifyEuropeUserZone() {

		try {
			boolean europeTab = elementPresent(OR.txt_Home_User_Zone_Europe);
			if (europeTab == true) {
				// clickOn(OR.txt_Home_User_Zone_Europe);
				testStepPassed("Europe tab is displayed");
			} else {
				testStepFailed("Europe tab is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify Asia tab is clicking
	 */
	public void verifyAsiaUserZone() {

		try {
			boolean asiaTab = elementPresent(OR.txt_Home_User_Zone_Asia);
			if (asiaTab == true) {
				waitTime(3);
				// clickOn(OR.txt_Home_User_Zone_Asia);
				testStepPassed("Asia tab is displayed");
			} else {
				testStepFailed("Asia tab is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	public void verifyFollowForbes() {
		testStepInfo("***************** Follow Forbes ****************");
		try {
			int followAvatar = 1;
			for (followAvatar = 1; followAvatar <= 5; followAvatar++) {
				String followForbes = "Follow Forbes#xpath=//div[@class='follow_links']//ul//li["
						+ followAvatar + "]";
				getText(followForbes);
				boolean follow = elementPresent(followForbes);
				if (follow == true) {

					testStepPassed("Follow On Forbes Avataras are present--"
							+ followAvatar + "-");
				} else {
					testStepFailed("Follow On Forbes Avataras are not present");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Verifying first link of Top stories
	 */
	public void verifyTopStory() {
		testStepInfo("************** Top Stories *************");
		try {
			boolean topStory = elementPresent(OR.txt_Home_Page_Top_Stories1);
			if (topStory == true) {
				String topStories = getText(OR.txt_Home_Page_Top_Stories1);
				testStepPassed("First Link of Top Stories ---" + topStories);
			} else {
				testStepFailed("Top Story is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateSignUpInLevelUp() {
		testStepInfo("****************** Level Up *******************");
		try {
			boolean signupFor = elementPresent(OR.txt_Reg_Home_Page_SignUpfor);
			if (signupFor == true) {
				String signUpfor = getText(OR.txt_Reg_Home_Page_SignUpfor);
				testStepPassed("Sign Up For is Displayed-" + signUpfor);
			} else {
				testStepFailed("Sign Up For is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Verify ads in lsits.
	 */
	public void verifyAdsInLsits() {
		testStepInfo("******************* Topx Ads *******************");

		try {
			scrollBy(0, 1000);
			int adsCount = 1;
			for (adsCount = 1; adsCount <= 1; adsCount++) {
				scrollBy(0, 300);
				String varXpath = "Topx Ads#xpath=//tbody[@id='list-table-body']//tr[@class='ad']["
						+ adsCount + "]";

				scrollToElement(varXpath);

				// clickOn(varXpath);
				waitTime(1);

				takeAdScreenshot(varXpath, "Topx Ads");
				testStepPassed("Topx Ads displayed " + adsCount);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	public void validateCountryDropdown(String countryLabel,String countryLists)
	{
		testStepInfo("********************Validate Countries dropdown*******************");
		try {
			boolean checkCountry=elementPresent(countryLabel);
			if(checkCountry==true)
			{
			
				
				testStepPassed("Country label is present");
				//OR.txt_Lists_Page_Country
				mouseOver(countryLabel);
				
				//OR.txt_Lists_Page_Countries_DropDown
				boolean checkCountriesLists=elementPresent(countryLists);
				if(checkCountriesLists==true)
				{
					int getCountriesCount=getElementCount(countryLists);
					testStepPassed("Total Number of Countries present in the dropdown lists--"+getCountriesCount);
					
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Country dropdown is not displayed");
				}
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Country label is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateSpreadsheetAndReprintLinks()
	{
		testStepInfo("****************** Validate Spreadsheet and Reprints*******************");
		try {
			boolean checkSpreadsheet=elementPresent(OR.txt_Lists_Page_Spreadsheet);
			if(checkSpreadsheet==true)
			{
				testStepPassed("Spreadsheet link is present in the full list page");
			}
			else
			{
				testStepFailed("Spreadsheet link is not present in the full list page");
			}
			
			boolean checkreprint=elementPresent(OR.txt_Lists_Page_Reprints);
			if(checkreprint==true)
			{
				testStepPassed("Reprints link is present in the full list page");
			}
			else
			{
				testStepFailed("Reprints link is not present in the full list page");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Verify full list.
	 */
	public void verifyFullList() {
		testStepInfo("************** Full Lists ***************");

		try {
			boolean titleOfPage = elementPresent(OR.txt_Lists_Page_Title);
			if (titleOfPage == true) {
				String title = getText(OR.txt_Lists_Page_Title);
				testStepPassed("Navigated to corresponding page --" + title);
				/*
				 * scrollBy(0, 200); scrollBy(0, -100);
				 */
				waitForElement(OR.btn_Lists_Page_Full_List);
				boolean seeFullLists = elementPresent(OR.btn_Lists_Page_Full_List);
				if (seeFullLists == true) {
					this.scrollToElement(OR.btn_Lists_Page_Full_List);
					this.scrollBy(0, -60);
					clickOn(OR.btn_Lists_Page_Full_List);
					waitTime(5);
					testStepPassed("See Full Lists button is displayed");
					validateSpreadsheetAndReprintLinks();
					validateCountryDropdown(OR.txt_Lists_Page_Country,OR.txt_Lists_Page_Countries_DropDown);
					
				} else {
					testStepFailed("See Full lists Button is not Displayed");
				}
			}

			else
			{
				getCurrentPageURL();
				testStepFailed("navigated to different page");
			}
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void validateBilionairesLists() {
		testStepInfo("***************** Billionaires List Page *********************");
		

		try {
			
			
			boolean checkBillionairesLists=elementPresent(OR.img_Lists_Page_BillionairesLists);
			if(checkBillionairesLists==true)
			{
				int getListsCount=getElementCount(OR.img_Lists_Page_BillionairesLists);
				testStepPassed("Billionaires Lists count is --"+getListsCount);
				int getRankCount=getElementCount(OR.txt_Lists_Page_billionaires_Rank);
				int getNameCount=getElementCount(OR.txt_Lists_Page_billionaires_Name);
				int getWorthCount=getElementCount(OR.txt_Lists_Page_billionaires_Worth);
				if(getListsCount==getRankCount && getListsCount==getNameCount && getListsCount==getWorthCount)
				{
					testStepPassed("Billionaires lists is displayed with Rank,Name and Worth");
				}
				else
				{
					testStepPassed("Billionaires lists is nor displayed with Rank or Name or Worth");
				}
				
			}
			else
			{
				testStepFailed("Billionaires List is not displayed");
			}
			waitForElement(OR.btn_Lists_Page_Next10);
			boolean next10=elementPresent(OR.btn_Lists_Page_Next10);
			if(next10==true)
			{
			clickOn(OR.btn_Lists_Page_Next10);
			testStepPassed("Next 10 arrow is present");
			boolean previous10=elementPresent(OR.btn_Lists_Page_Previous10);
			if(previous10==true)
			{
				clickOn(OR.btn_Lists_Page_Previous10);
				testStepPassed("Previous 10 arrow is present");
			}
			else
			{
				testStepFailed("Previous 10 arrow is not present");
			}
			
			}
			else
			{
			testStepFailed("Next 10 arrow is not present");
			}
		}
		catch(Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

		

		public void validateProfilePage()
		{
			try{
			waitTime(2);
			boolean checkBillGatesList = elementPresent(OR.img_Lists_Page_Profile);
			if (checkBillGatesList == true) {
				clickOn(OR.img_Lists_Page_Profile);
				String profileName = getText(OR.txt_Lists_Page_Profile_Name);
				testStepPassed("Profile name is --" + profileName);
				waitTime(2);
				
				
				boolean nextArrow=elementPresent(OR.btn_Lists_Page_Next);
				if(nextArrow==true)
				{
				clickOn(OR.btn_Lists_Page_Next);
				testStepPassed("Next arrow is present");
				boolean previousArrow=elementPresent(OR.btn_Lists_Page_Previous);
				if(previousArrow==true)
				{
					clickOn(OR.btn_Lists_Page_Previous);
					testStepPassed("Previous arrow is present");
				}
				else
				{
					testStepFailed("Previous arrow is not present");
				}
				
				}
				else
				{
					testStepFailed("Next arrow is not present");
				}
				waitTime(3);
				boolean seeFullProfile = elementPresent(OR.btn_Lists_Page_See_Full_Profile);
				if (seeFullProfile == true) {
					
					testStepInfo("****************Validate Networth date**************");
					boolean checkRealTimeNetWorth=elementPresent(OR.txt_Lists_Page_RealTimeNetWorth);
					if(checkRealTimeNetWorth==true)
					{
						String getRealTimeNetWorth=getText(OR.txt_Lists_Page_RealTimeNetWorth);
						testStepPassed(getRealTimeNetWorth);
						String[] getDate=getRealTimeNetWorth.split("of");
						//String date1=getDate[0].trim();
						String date2=getDate[1].trim();
						testStepPassed( "Net Worth Date on Profile---"+date2);
						
						clickOn(OR.btn_Lists_Page_See_Full_Profile);
						
						
						
						
						
						
						boolean checkNetWorthDate=elementPresent(OR.txt_Lists_Page_InProfile_PrimaryRealTimeNetWorth);
						if(checkNetWorthDate==true)
						{
							String getProfileNetWorth=getText(OR.txt_Lists_Page_InProfile_PrimaryRealTimeNetWorth);
							testStepPassed(getProfileNetWorth);
							String[] getnetWorthDate=getRealTimeNetWorth.split("of");
							//String nDate1=getnetWorthDate[0].trim();
							String nDate2=getnetWorthDate[1].trim();
							testStepPassed( "Net Worth Date on Profile---"+nDate2);
							if(date2.equalsIgnoreCase(nDate2))
							{
								testStepPassed("Profile Promo block networth date is matching with the Profile page net worth date");
							}
							else
							{
								testStepFailed("Profile Promo block networth date is not matching with the Profile page net worth date");	
							}
						}
						else
						{
							testStepFailed("Net Worth date is not present in the profile page");
						}
					}
					else
					{
						testStepFailed("Net Worth date is not present in the profile promo block page");
					}
					validateBioGraphy();
					validateNetWorthOverTime();
					validateQuoteInProfilePage();
					testStepInfo("****************Validate Ads**************");
					validateTopAds(OR.adsHomePageTopAds);	
					validateRecAds(OR.adsHomePageRecAds);
					validateRailRecAds(OR.ads_New_Posts_RailRec_Ads);
					validateTextAds();
					validateLogeAds();
					validateProfileRank();
					
				} else {
					testStepFailed("See Full Profile button is not Dsiplayed");
				}
				//validateMarketUpdate();
				/*waitForElement(OR.btn_Lists_Page_Load_More);
				boolean loadMore = elementPresent(OR.btn_Lists_Page_Load_More);
				if (loadMore == true) {

					testStepPassed("Load More button is Displayed");
					clickOn(OR.btn_Lists_Page_Load_More);
				} else {
					testStepFailed("Load More button is not displayed");
				}*/
			} else {
				testStepFailed("Profile is not Displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		clickOnBackButton();
		}
		
		public void validateProfileRank()
		{
			testStepInfo("*********************Validate Next Profile*********************");
			try {
				
				
				boolean checkProfileRank=elementPresent(OR.txt_Lists_Page_Profile_Rank);
				if(checkProfileRank==true)
				{
					testStepPassed("Profile rank is present");
					
					boolean checkNextArrow=elementPresent(OR.btn_Lists_Page_NextArrow);
					if(checkNextArrow==true)
					{
						testStepPassed("Next Arrow is present");
						
						clickOn(OR.btn_Lists_Page_NextArrow);
						validateProfileName_Logo();
						boolean checkPreviousArrow=elementPresent(OR.btn_Lists_Page_PrevArrow);
						if(checkPreviousArrow==true)
						{
							clickOn(OR.btn_Lists_Page_PrevArrow);
							testStepPassed("Previous Arrow is present");
						}
						else
						{
							testStepFailed("Prevoius Arrow is not present");
						}
						
						
					}
					else
					{
						getCurrentPageURL();
						testStepFailed("Next Arrow is not present");
					}
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Profile rank is not present");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		public void validateQuoteInProfilePage()
		{
			testStepInfo("******************Validate Quote******************");
			boolean checkQuote=elementPresent(OR.txt_Lists_Page_Quote);
			if(checkQuote==true)
			{
				String getQuote=getText(OR.txt_Lists_Page_Quote);
				testStepPassed("Quote is present in the profile page---"+getQuote);
				
				
			}
			else
			{
				testStepFailed("Quote is not present in the profile page");
			}
			boolean checkQuoteIcon=elementPresent(OR.icon_Lists_Page_Quote_Icon);
			if(checkQuoteIcon==true)
			{
				testStepPassed("Quote icon is present");
			}
			else
			{
				testStepFailed("Quote icon is not present");
			}
			
			boolean checkQuoteName=elementPresent(OR.txt_Lists_Page_NameOfQuote);
			if(checkQuoteName==true)
			{
				String getQuoteName=getText(OR.txt_Lists_Page_NameOfQuote);
				testStepPassed("Quote Name is present---"+getQuoteName);
			}
			else
			{
				testStepFailed("Quote Name is not present");
			}
			
		}
		
		public void validateNetWorthOverTime()
		{
			testStepInfo("******************Net Worth Over Time***************");
			try {
				boolean checkNetWorthOverTime=elementPresent(OR.txt_List_Page_NetWorthOverTime);
				if(checkNetWorthOverTime==true)
				{
					testStepPassed("Net worth over time label is present");
					
					boolean checkBarChart=elementPresent(OR.txt_List_Page_Historical_Chart);
				
					if(checkBarChart==true)
					{
						this.scrollToElement(OR.txt_List_Page_Historical_Chart);
						this.scrollBy(0, -60);
						mouseOver(OR.txt_List_Page_Historical_Chart);
						waitTime(3);
						boolean checkWorth=elementPresent(OR.txt_Lists_Page_Worth);
						boolean checkName=elementPresent(OR.txt_Lists_Page_Name);
						boolean checkDate=elementPresent(OR.txt_Lists_Page_Date);
						if(checkWorth==true)
						{
							testStepPassed("Net Worth Over time bar chart is present with worth");
						}
						else
						{
							testStepPassed("Net Worth is not present");
						}
						
						if(checkName==true)
						{
							testStepPassed("Net Worth Over time bar chart is present with name");
						}
						else
						{
							testStepPassed("Name is not present");
						}
						
						if(checkDate==true)
						{
							testStepPassed("Net Worth Over time bar chart is present with date");
						}
						else
						{
							testStepPassed("Date is not present");
						}
						
					}
				}
				else
				{
					testStepFailed("Net Worth over time label is not present");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
		}
		
		public void validateBioGraphy()
		{
			testStepInfo("******************Validate Biography******************");
			try {
				
				boolean checkBiography=elementPresent(OR.txt_Lists_Page_Biography);
				if(checkBiography==true)
				{
					String getBiography=getText(OR.txt_Lists_Page_Biography);
					testStepPassed("Biography is present---"+getBiography);
					
					boolean checkMoreButton=elementPresent(OR.btn_Lists_Page_MoreLess);
					if(checkMoreButton==true)
					{
						
						testStepPassed("More button is present");
						this.scrollToElement(OR.btn_Lists_Page_MoreLess);
						this.scrollBy(0, -60);
						clickOn(OR.btn_Lists_Page_MoreLess);
						waitTime(3);
						String getFullBiography=getText(OR.txt_Lists_Page_Biography);
						testStepPassed("Full Biography is present"+getFullBiography);
					}
					else
					{
						testStepInfo("More button is not present");
					}
					boolean checkLessButton=elementPresent(OR.btn_Lists_Page_MoreLess);
					if(checkLessButton==true)
					{
					this.scrollToElement(OR.btn_Lists_Page_MoreLess);
					this.scrollBy(0, -100);
					waitTime(5);
					clickOn(OR.btn_Lists_Page_MoreLess);
					}
					else
					{
						testStepFailed("Less Button is not present");
					}
				}
				else
				{
					testStepPassed("Hidden biography is not present");
				}
					
					
				
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}

		public void validateProfileName_Logo()
		{
			testStepInfo("****************Validate current Profile **************");
			try {
				boolean checkProfileImage=elementPresent(OR.img_Lists_Page_Profile_Logo);
				
				if(checkProfileImage==true)
				{
					testStepPassed(" Profile Logo is present in the Profile page");
				}
				else
				{
					testStepFailed(" Profile Logo is not present in the Profile page");
				}
				boolean checkProfileName=elementPresent(OR.txt_Lsits_Page_Profile_Details);
				if(checkProfileName==true)
				{
					String profile = getText(OR.txt_Lsits_Page_Profile_Details);
					testStepPassed(" Profile name is present --" + profile);
				}
				else
				{
					testStepFailed(" Profile Name is not present in the Profile page");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
			
		}
		
		
	public void validateMarketUpdate()
	{
		testStepInfo("****************** Market Update ****************");
		try {
			boolean marketUpdateLable=elementPresent(OR.txt_Lists_Page_Marketupdate);
			if(marketUpdateLable==true)
			{
				testStepPassed("Market update Lable is displayed");
				boolean marketUpdateBlock=elementPresent(OR.txt_Lists_Page_Market_Update_Graph);
				if(marketUpdateBlock==true)
				{
					takeAdScreenshot(OR.txt_Lists_Page_Market_Update_Graph, "Market Update");
					testStepPassed("Market update block is displayed");
				}
				else
				{
					testStepFailed("Market update block is not displayed");
				}
			}
			else
			{
				testStepFailed("Market update Lable is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	// CSF Page

		public void verifyCSFPageContentsInDesktop() {
			validatePageLoadTime("http://www.forbes.com/actors/?nowelcome", 15,
					"Actors CSF Page");
			checkAdOnCSF();
			isListDisplayed();
			checkImagesOnCSF();
			checkvideosOnCSF();
			validateUpdatedFooterNavigation();
		}
		
		public void checkAdOnCSF() {
			try {
				waitTime(3);
				int adCount = getElementCount(OR.ads_CSFPageCheck_allAdsOnCSF);
				testStepInfo("AdCount Upon landing on  CSF Page is" + adCount);
				if (adCount != 0) {
					testStepPassed("CSF Page Check : " + adCount
							+ " ads are displayed on the CSF page");
				} else {
					testStepFailed("CSF Page Check : Ads are displayed on the CSF page");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		public void checkImagesOnCSF() {
			try {
				testStepInfo("****************Images check on CSF Page****************");
				List<WebElement> images = driver.findElements(By
						.xpath("//div[@class='block-image ratio16x9']"));
				for (int i = 0; i < images.size(); i++) {
					if (images.get(i).isDisplayed()) {
						testStepPassed("CSF image" + i + " is displayed");
					} else {
						testStepFailed("CSF image" + i + " is not displayed");
					}
				}
				testStepPassed("Number of CSF images displayed: " + images.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}

		public void checkvideosOnCSF() {
			try {
				testStepInfo("***************Videos check on CSF Page*****************");
				List<WebElement> videos = driver.findElements(By
						.xpath("//div[contains(@class,'video-thumb ratio16x9')]"));
				for (int i = 0; i < videos.size(); i++) {
					if (videos.get(i).isDisplayed()) {
						testStepPassed("CSF video" + i + " is displayed");
					} else {
						testStepFailed("CSF video" + i + " is not displayed");
					}
				}
				testStepPassed("Number of CSF Videos displayed: " + videos.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		public void verifySearchPageArticleStreamAndSeeMore(String stream,String button,String name){
			try{
			testStepInfo("*********************************Validate the article stream and check see more button**********************************");
			int editorsPickPageArticleStreamCount= getElementCount(stream);
			if(editorsPickPageArticleStreamCount==10){
				testStepPassed(name+"-->  article stream count is "+editorsPickPageArticleStreamCount+" as expected");
			}
			else{
				getCurrentPageURL();
				testStepFailed(name+"-->  article stream count is "+editorsPickPageArticleStreamCount+" and id not expected");
			}
			
			boolean isButtonDisplayed = elementPresent(button);
			if(isButtonDisplayed==true){
				testStepPassed(name+"--> See more button is displayed");
			}
			else{
				getCurrentPageURL();
				testStepFailed(name+"--> See more button is not displayed");
			}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
	

		public void validateBadge(String badge,String titleOfThePage,String name)
		{
			testStepInfo("********************* Validating Badge**********************");
			try {
				
				//validateTopAds(OR.ads_Article_Page_Top_Ads);
				boolean isBadge=elementPresent(badge);
				if(isBadge==true)
				{
					waitTime(5);
					
					clickOn(badge);
					testStepPassed(name+" - Badge is present");
					boolean titleOfPage=elementPresent(titleOfThePage);
					if(titleOfPage==true)
					{
						testStepPassed("Directed to -"+name+" -page on clikcing the badge"); 
					}
					else
					{
						testStepFailed("Not Directed to "+name+" on clikcing the badge");
					}
				}
				else
				{
					getCurrentPageURL();
					testStepFailed(name+" Badge is not present");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
		}
		public void validateFirstArticleNavigation(String firstArticle, String navigatedArticle, String name)
		{
			testStepInfo("*********************** Validating Article Navigation ************************");
			try {
				this.scrollToElement(firstArticle);
				this.scrollBy(0, -100);
				boolean isFirstArticle=elementPresent(firstArticle);
				if(isFirstArticle==true)
				{
					String headingOfFirstArticle=getText(firstArticle);
					clickOn(firstArticle);
					String headingOfArticle=getText(navigatedArticle);
					//headingOfArticle
					if(headingOfArticle.equals(headingOfFirstArticle))
					{
					testStepPassed(name+"first post when clicked is navigated to the article");
					}
					else
					{
						getCurrentPageURL();
						testStepFailed(name+" first post when clicked is not navigated to the article");
					}
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
			
		}
		public void validateForbesOnTrumpHeading(String xpath,String name)
		{
			testStepInfo("************************Validating Title*******************************");
			try {
				boolean heading=elementPresent(xpath);
				if(heading==true)
				{
					testStepPassed(name+"--- Heading is present");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed(name+"--- Heading is not present");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		public void validateStickyAds(String name)
		{
			try {
				boolean stickyAd=elementPresent(OR.ad_EditorsPick_Mobile_StickyAd);
				if(stickyAd==true){
					takeAdScreenshot(OR.ad_EditorsPick_Mobile_StickyAd, "Sticky");
					testStepPassed(name+"mobile StickyAd is displayed");
				}
				else{
					getCurrentPageURL();
					testStepFailed(name+"mobile StickyAd is not displayed");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		
		public void validateShareIcon(String name)
		{
			try {
				boolean shareIcon=elementPresent(OR.icon_EditorsPick_Mobile_ShareIcon);
				if(shareIcon==true){
					testStepPassed("Editors Pick Mobile : Editors picks share icon is displayed");
				}
				else{
					getCurrentPageURL();
					testStepFailed("Editors Pick Mobile : Editors picks share icon is not displayed");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		
		

		public void validateWhatIsThisLabelInMobile()
		{
			testStepInfo("**************What Is this Link**************");
			boolean whatIsThis = elementPresent(OR.link_BVHomePage_whatisthis);
			if (whatIsThis == true) {

				clickOn(OR.link_BVHomePage_whatisthis);
				
				
				waitTime(3);
				
				
				boolean checkWhatIsThis=elementPresent(OR.txt_Reg_BrandVoice_What_Is_This_Description);
				if(checkWhatIsThis==true)
				{
					String getWhatIsThis=getText(OR.txt_Reg_BrandVoice_What_Is_This_Description);
					testStepPassed("What is this present--"+getWhatIsThis);
				}
				else
				{
					testStepFailed("What is this is not displayed");
				}
			} else {
				testStepFailed("What is this is not displayed");
			}
		}
		
		//14 Dec 2016
				public void validateFilterDropdown()
				{
					testStepInfo("******** Validate Filtering tabs****************");
					boolean dropDown=elementPresent("#xpath=//div[@class='list-hover']//ul//li");
					if(dropDown==true)
					{
						this.scrollToElement("Tabs#xpath=//div[@class='list-hover']//ul//li");
						this.scrollBy(0, -60);
						clickOn("Tabs#xpath=//i[@class='icon icon-chevron-down']");
						int count=getElementCount("#xpath=//div[@class='list-hover']//ul//li");
						testStepPassed("Total Number of Tabs--->"+count);
						String getAll=null;
						for (int j = 1; j <=count; j++) {
							getAll=getText("Tabs#xpath=//div[@class='list-hover']//ul//li["+j+"]//a");
							testStepPassed("Tab names--->"+getAll);
						}
						
						for (int i = 2; i <=count; i++) {
							//String tabNameInFilter=getText("Brandvoice Tabs#xpath=//div[@class='list-hover']//ul//li["+i+"]//a");
							
							this.scrollToElement("Tabs#xpath=//div[@class='list-hover']//ul//li");
							this.scrollBy(0, -60);
							clickOn("Arrow down#xpath=//i[@class='icon icon-chevron-down']");
							
							this.scrollToElement("Tabs#xpath=//div[@class='list-hover']//ul//li["+i+"]//a");
							this.scrollBy(0, -60);
							clickOn("Tabs#xpath=//div[@class='list-hover']//ul//li["+i+"]//a");
							
							
							String url=driver.getCurrentUrl();
							testStepPassed(url);
							String[] splittedUrl= url.split("#");
							String firstPart=splittedUrl[0];
							String secPart=splittedUrl[1];
							//testStepPassed(firstPart);
							//testStepPassed(secPart);
							String appenedURL=firstPart.concat("?view=csf_contrib");
							driver.get(appenedURL);
							
							testStepInfo("************Validating Tab name with Latest****************");
							boolean tabName=elementPresent(OR.txt_Reg_BrandVoice_TabNameInLatest);
							if(tabName==true)
							{
								
								
								String getTabName=getText(OR.txt_Reg_BrandVoice_TabNameInLatest);
								testStepPassed("Tab Name in the Latest---->"+getTabName);
								String[] splitString=getTabName.split("LATEST IN");
								String sec=splitString[1];
								String removeSpace[]=sec.split("\\s");
								String s1=removeSpace[0];
								String s2=removeSpace[1];
								//testStepPassed(s1);
								//testStepPassed(s2);
								testStepPassed("Tab Name is Displayed in the Latest--->"+sec);
								
							/*	if(getAll.trim().contains(s2))
								{
									testStepPassed(" Filter Tab name is matching in Latest ");
								}
								else
								{
									getCurrentPageURL();
									testStepFailed(" Filter Tab name is not matching in Latest ");
								}*/
							}
							else
							{
								testStepFailed("Latest Label is not Displayed");
							}
							
							//validateLatestPostsInMobile();
							clickOnBackButton();
							clickOnBackButton();
							
						}
						
					}
				}
				
				
				
				public int invalidImageCount;
				public void verifyimageActive(WebElement imgElement,String nameOfImage) {
					try {
						HttpClient client = HttpClientBuilder.create().build();
					//	HttpGet request = new HttpGet(imgElement.getAttribute("src"));
						HttpGet request = new HttpGet(imgElement.getAttribute("src"));
						
						HttpResponse response = client.execute(request);
						// verifying response code he HttpStatus should be 200 if not,
						// increment as invalid images count
						
						int resp_Code = response.getStatusLine().getStatusCode();
						if ((resp_Code==404) || (resp_Code==505) || !(resp_Code==200))
						{
							//invalidImageCount++;
							getCurrentPageURL();
							
							testStepFailed(nameOfImage+" Image is broken");
							
						
						}
						else
						{
							testStepPassed(nameOfImage+" Image is present");	
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				
				public void validateFilterByChannels()
				{
					testStepInfo("*****************Validate Filter By ***************");
					try {
						boolean checkFilterBy=elementPresent("Select Channel#xpath=//select");
						if(checkFilterBy==true)
						{
							WebElement element=driver.findElement(By.xpath("//select"));
							Select selectValue=new Select(element);
							List<WebElement> allChannels=selectValue.getOptions();
							for (int i =0; i <=allChannels.size(); i++) {
								String getAllChannels=allChannels.get(i).getText();
								testStepPassed("Channel Name is --"+getAllChannels);
							}
							
						}
						else
						{
							testStepFailed("Filter by dropdown is not present");
						}
					} catch (Exception e) {
						writeToLogFile("ERROR", "Exception: " + e.toString());
					}
				}
				public void validateBrokenImages(String xpathImage, String imageName)
				{
					try {
						//invalidImageCount = 0;
						
						//List<WebElement> imagesList = driver.findElements(By.tagName("img"));
						//System.out.println("Total no. of images are " + imagesList.size());
						//String getAttribute=getAttributeValue(OR.img_Reg_Contributor_Page_Image, "src");
						WebElement getAttribute=driver.findElement(By.xpath(xpathImage));
							if (getAttribute != null) {
								verifyimageActive(getAttribute,imageName);
							}
							else
							{
								testStepFailed("Image is not present");
							}
						
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
				}
		
				
				//Mantis Tickets
				
				//PROD-885
				public void validateFooterFeedback()
				{
					testStepInfo("***********************Validate Footer Feedback*********************");
					try {
						this.scrollToElement(OR.txt_Footer_FeedBack);
						this.scrollBy(0, -60);
						boolean checkFeedback=elementPresent(OR.txt_Footer_FeedBack);
						if(checkFeedback==true)
						{
							testStepPassed("Footer Feedback is present");
						}
						else
						{
							testStepFailed("Footer Feedback is not present");
						}
					} catch (Exception e) {
						writeToLogFile("ERROR", "Exception: " + e.toString());
					}
				}
				
				public void validateFooterCopy()
				{
					testStepInfo("*************Validate Footer***********");
					try {
						boolean checkFooterCopy=elementPresent(OR.txt_Home_Page_Footer_Copy);
						if(checkFooterCopy==true)
						{
							String getFooterCopy=getText(OR.txt_Home_Page_Footer_Copy);
							testStepPassed("Footer Copy is present"+getFooterCopy);
						}
						else
						{
							testStepFailed("Footer copy is not present");
						}
					} catch (Exception e) {
						writeToLogFile("ERROR", "Exception: " + e.toString());
					}
					
				}
				//PROD-889
				public void validateUpdatedFooterNavigation()
				{
					testStepInfo("********************Validate Footer Links********************");
					try {
						boolean checkAdChoices =elementPresent(OR.txt_Footer_Link_AdChoices);
						if(checkAdChoices==true)
						{
							testStepPassed("Footer AdChoices link is present");
						}
						else
						{
							testStepFailed("Footer AdChoices link is not present");
						}
						boolean checkPrivacyStatement =elementPresent(OR.txt_Footer_Link_AdChoices);
						if(checkPrivacyStatement==true)
						{
							testStepPassed("Footer Privacy Statement link is present");
						}
						else
						{
							testStepFailed("Footer  Privacy Statement link is not present");
						}
						boolean checkTermsAndConditions =elementPresent(OR.txt_Footer_Link_TermsAndcondition);
						if(checkTermsAndConditions==true)
						{
							testStepPassed("Footer Terms And conditions link is present");
						}
						else
						{
							testStepFailed("Footer Terms And conditions link is not present");
						}
						boolean checkContactUs =elementPresent(OR.txt_Footer_Link_ContactUs);
						if(checkContactUs==true)
						{
							testStepPassed("Footer contact US link is present");
						}
						else
						{
							testStepFailed("Footer contact US link is not present");
						}
						boolean checkSendUsFeedback =elementPresent(OR.txt_Footer_Link_SendUsFeedback);
						if(checkSendUsFeedback==true)
						{
							testStepPassed("Footer Send Us Feedback link is present");
						}
						else
						{
							testStepFailed("Footer Send Us Feedback link is not present");
						}
						boolean checkJobAtForbes =elementPresent(OR.txt_Footer_Link_JobsAtForbes);
						if(checkJobAtForbes==true)
						{
							testStepPassed("Footer Job At Forbes link is present");
						}
						else
						{
							testStepFailed("Footer Job At Forbes link is not present");
						}
						boolean checkReprintsAndPermissions =elementPresent(OR.txt_Footer_Link_ReprintsAndPermissions);
						if(checkReprintsAndPermissions==true)
						{
							testStepPassed("Footer Reprints and Permissions link is present");
						}
						else
						{
							testStepFailed("Footer Reprints and Permissions link is not present");
						}
						boolean checkForbesPressRoom =elementPresent(OR.txt_Footer_Link_ForbesPressRoom);
						if(checkForbesPressRoom==true)
						{
							testStepPassed("Footer Forbes Press Room link is present");
						}
						else
						{
							testStepFailed("Footer Forbes Press Room link is not present");
						}
						boolean checkAdvertise =elementPresent(OR.txt_Footer_Link_Advertise);
						if(checkAdvertise==true)
						{
							testStepPassed("Footer Advertise link is present");
						}
						else
						{
							testStepFailed("Footer Advertise link is not present");
						}
					} catch (Exception e) {
						writeToLogFile("ERROR", "Exception: " + e.toString());
					}
					
					
				}
				
				public void validateSocialSharesInMobile()
				{
					try {
						boolean checkSocialShareIcon=elementPresent(OR.icon_HomePage_SocialShare);
						if(checkSocialShareIcon==true)
						{
							clickOn(OR.icon_HomePage_SocialShare);
							validateSocialnetworks(OR.img_HomePage_SocialShares);
						}
						else
						{
							testStepFailed("Social Share icon is not present");
						}
					} catch (Exception e) {
						writeToLogFile("ERROR", "Exception: " + e.toString());
					}
				}
				public void validateSearchIcon()
				{
					testStepInfo("*************Validate Search Icon***********");
					try {
						boolean checkSearchIcon=elementPresent(OR.icon_HomePage_Search);
						if(checkSearchIcon==true)
						{
							testStepPassed("Search Icon is present");
							clickOn(OR.icon_HomePage_Search);
							boolean checkSearchField=elementPresent(OR.txt_HomePage_SearchField);
							if(checkSearchField==true)
							{
								testStepPassed("Search Field is present");
							}
							else
							{
								testStepFailed("Search field is not present");
							}
							clickOn(OR.icon_HomePage_Search);
						}
						else
						{
							testStepFailed("Search Icon is not present");
						}
					} catch (Exception e) {
						writeToLogFile("ERROR", "Exception: " + e.toString());
					}
					
				}
				public void validateRelatedArticles()
				{
					testStepInfo("*************Validate Related Articles***********");
					
					try {
						boolean checkRelatedArticles=elementPresent(OR.txt_Home_Page_RelatedArticles);
						boolean checkRelatedArticlesDate=elementPresent(OR.txt_Home_Page_RelatedArticles_Date);
						
						if(checkRelatedArticles==true && checkRelatedArticlesDate==true)
						{
							int getCount=getElementCount(OR.txt_Home_Page_RelatedArticles);
							testStepPassed("Total Number of Related Articles--"+getCount);
							int getDateCount=getElementCount(OR.txt_Home_Page_RelatedArticles_Date);
							testStepPassed("Total Number of Related Articles Date--"+getDateCount);
							
							int getAuthorCount=getElementCount(OR.txt_Home_Page_RelatedArticles_AuthorName);
							testStepPassed("Total Number of Related Articles--"+getAuthorCount);
							for (int i = 1; i <=getCount; i++) {
								
								boolean checkRelatedArticle=elementPresent("Related Articles#xpath=//div[@class='related-article ng-scope']["+i+"]//h2");
								boolean checkRelatedArticleDate=elementPresent("Related Articles#xpath=//div[@class='related-article ng-scope']["+i+"]//div[@class='display-date ng-binding ng-scope']");
								if(checkRelatedArticle==true && checkRelatedArticleDate==true)
								{
									String getRelatedArticle=getText("Related Articles#xpath=//div[@class='related-article ng-scope']["+i+"]//h2");
									
									String getRelatedArticleDate=getText("Related Articles#xpath=//div[@class='related-article ng-scope']["+i+"]//div[@class='display-date ng-binding ng-scope']");
									testStepPassed("Related Article is present "+i+"-"+getRelatedArticleDate+"--->"+getRelatedArticle);
								}
								else
								{
									testStepFailed("Related Article is not present "+i);
								}
							}
						}
					} catch (Exception e) {
						writeToLogFile("ERROR", "Exception: " + e.toString());
					}
				}
				public void validatePromoBlock()
				{
					testStepInfo("*************Validate Promo block***********");
					try {
						boolean checkPromoBlockTemplate=elementPresent(OR.txt_Home_Page_PromoBlock_Template);
						if(checkPromoBlockTemplate==true)
						{
							testStepPassed("Promo Block Template is present");
						}
						else
						{
							testStepFailed("Promo Block Template is not present");
						}
						boolean checkPromoBlockContent=elementPresent(OR.txt_Home_Page_PromoBlock_Content);
						if(checkPromoBlockContent==true)
						{
							testStepPassed("Promo Block Content is present");
						}
						else
						{
							testStepFailed("Promo Block Content is not present");
						}
					} catch (Exception e) {
						writeToLogFile("ERROR", "Exception: " + e.toString());
					}
				}
				
				//31 March 2017
				
				public void validateSeeRealTimeRanking()
				{
					testStepInfo("*****************See Real Time Ranking*******************");
					try {
						boolean checkSeeRealtimeRank=elementPresent(OR.btn_Lists_Page_See_Real_Time_Ranking);
						if(checkSeeRealtimeRank==true)
						{
							testStepPassed("See Real Time Ranking button is present");
						}
						else
						{
							testStepFailed("See Real Time Ranking button is not present");
						}
					} catch (Exception e) {
						writeToLogFile("ERROR", "Exception: " + e.toString());
					}
					
				}
				
}