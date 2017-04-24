package ga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class welcomeAdGACheck extends ApplicationKeywords{
	
	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :
	// Purpose :
	// Parameters :
	// Return Value :
	// Created by :
	// Created on :
	// Remarks :
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates  BVPage Functions
	 *
	 * @param obj
	 *            the obj
	 */
	public welcomeAdGACheck(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public welcomeAdGACheck() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyWApageGAContents(){
		testStepInfo("*********************************WA Page GA/Datalayer validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {

			verifywWAPageDataLayerContents();

		} 
		 else {

			}
	}
	
	public void verifywWAPageDataLayerContents(){
		try{
			testStepInfo("*********************************Validating WA Page with autoforward as false**********************************");
			navigateTo("https://www.forbes.com/forbes/welcome/?autoforward=false");
			readJS();
			driver.manage().deleteAllCookies();
		}
		
		catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	}
	
	public void readJS(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
  
        inputMap2.put("DFPZone","cd16");
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("referrer","dr");
        inputMap2.put("trueIntendedPage","CD63");
        
        inputMap.put("DFPZone","welcome");
        inputMap.put("channel","ads");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("referrer","");
        inputMap.put("trueIntendedPage","none");
        
         
        
        if (driver instanceof JavascriptExecutor) {
            
            JavascriptExecutor js = (JavascriptExecutor)driver;
            java.util.ArrayList o = (ArrayList) js.executeScript("return window.dataLayer;");
            Iterator i = o.iterator();
            Map<String,Object> mapFromBrowser = (Map<String, Object>) i.next();
            System.out.println("String Json: " + mapFromBrowser.size());

               for (Map.Entry<String, Object> inputMapObject : inputMap.entrySet()) {
             	  /**
            	    * condition if Browser map contain any input Map Keys
            	    */
                    if (mapFromBrowser.containsKey(inputMapObject.getKey())) {
                 	   //if condition to check the values are same for the given key
                        if(mapFromBrowser.get(inputMapObject.getKey()).toString().equalsIgnoreCase(inputMapObject.getValue().toString())){
                          testStepPassed("CD Value is-> "+inputMap2.get(inputMapObject.getKey()).toString()+"::"+inputMapObject.getKey()+" and the value is "+mapFromBrowser.get(inputMapObject.getKey()));
                          
                        }else { //else condition if the values are different
                     	   testStepFailed("CD value mismatch->"+inputMap2.get(inputMapObject.getKey()).toString()+" :: "+inputMapObject.getKey()+" ; Value generated is  "+mapFromBrowser.get(inputMapObject.getKey()));
                        }
                    } else {
                 	   //Else condition if Browser map does not contain any input Map Keys
                 	   testStepFailed("CD Value "+inputMap2.get(inputMapObject.getKey()).toString()+" doesn't exist for "+inputMapObject.getKey() +" and the value is "+inputMapObject.getValue());
               }
          }
  }
}
	
	public void verifywWAArticlePageFromGoogleDataLayerContents(){
		try{
			testStepInfo("*********************************Validating WA Page with article from google**********************************");
			navigateTo("https://www.google.com/#q=Uber+Scrambles+To+Investigate+Shocking+Sexual+Harassment+Claim");
			clickOn(OR.url_Article_google);
			readJSWAArticleFromGoogle();
			driver.manage().deleteAllCookies();
		}
		
		catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	}
	
	public void readJSWAArticleFromGoogle(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
  
        inputMap2.put("DFPZone","cd16");
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("referrer","dr");
        inputMap2.put("trueIntendedPage","CD63");
        
        inputMap.put("DFPZone","welcome");
        inputMap.put("channel","ads");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("referrer","https://www.google.com/");
        inputMap.put("trueIntendedPage","https://www.forbes.com/sites/briansolomon/2017/02/20/uber-scrambles-to-investigate-sexual-harassment-claim/");
        
         
        
        if (driver instanceof JavascriptExecutor) {
            
            JavascriptExecutor js = (JavascriptExecutor)driver;
            java.util.ArrayList o = (ArrayList) js.executeScript("return window.dataLayer;");
            Iterator i = o.iterator();
            Map<String,Object> mapFromBrowser = (Map<String, Object>) i.next();
            System.out.println("String Json: " + mapFromBrowser.size());

               for (Map.Entry<String, Object> inputMapObject : inputMap.entrySet()) {
             	  /**
            	    * condition if Browser map contain any input Map Keys
            	    */
                    if (mapFromBrowser.containsKey(inputMapObject.getKey())) {
                 	   //if condition to check the values are same for the given key
                        if(mapFromBrowser.get(inputMapObject.getKey()).toString().equalsIgnoreCase(inputMapObject.getValue().toString())){
                          testStepPassed("CD Value is-> "+inputMap2.get(inputMapObject.getKey()).toString()+"::"+inputMapObject.getKey()+" and the value is "+mapFromBrowser.get(inputMapObject.getKey()));
                          
                        }else { //else condition if the values are different
                     	   testStepFailed("CD value mismatch->"+inputMap2.get(inputMapObject.getKey()).toString()+" :: "+inputMapObject.getKey()+" ; Value generated is  "+mapFromBrowser.get(inputMapObject.getKey()));
                        }
                    } else {
                 	   //Else condition if Browser map does not contain any input Map Keys
                 	   testStepFailed("CD Value "+inputMap2.get(inputMapObject.getKey()).toString()+" doesn't exist for "+inputMapObject.getKey() +" and the value is "+inputMapObject.getValue());
               }
          }
  }
}
	
	public void verifywWAGalleryPageFromGoogleDataLayerContents(){
		try{
			testStepInfo("*********************************Validating WA Page with Gallery from google**********************************");
			navigateTo("https://www.google.com/#q=16+Of+The+Best%2C+Most+Presidentialist+Cartoons+About+President-Elect+Donald+Trump");
			WEBCLICK_ListElement(OR.url_Gallery_google,0);
			//clickOn(OR.url_Gallery_google);
			waitTime(3);
			readJSWAGalleryFromGoogle();
			driver.manage().deleteAllCookies();
		}
		
		catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	}
	
	public void readJSWAGalleryFromGoogle(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
  
        inputMap2.put("DFPZone","cd16");
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("referrer","dr");
        inputMap2.put("trueIntendedPage","CD63");
        
        inputMap.put("DFPZone","welcome");
        inputMap.put("channel","ads");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("referrer","https://www.google.com/");
        inputMap.put("trueIntendedPage","https://www.forbes.com/pictures/hfje45gell/this-way-to-the-bigly-t/");
        
         
        
        if (driver instanceof JavascriptExecutor) {
            
            JavascriptExecutor js = (JavascriptExecutor)driver;
            java.util.ArrayList o = (ArrayList) js.executeScript("return window.dataLayer;");
            Iterator i = o.iterator();
            Map<String,Object> mapFromBrowser = (Map<String, Object>) i.next();
            System.out.println("String Json: " + mapFromBrowser.size());

               for (Map.Entry<String, Object> inputMapObject : inputMap.entrySet()) {
             	  /**
            	    * condition if Browser map contain any input Map Keys
            	    */
                    if (mapFromBrowser.containsKey(inputMapObject.getKey())) {
                 	   //if condition to check the values are same for the given key
                        if(mapFromBrowser.get(inputMapObject.getKey()).toString().equalsIgnoreCase(inputMapObject.getValue().toString())){
                          testStepPassed("CD Value is-> "+inputMap2.get(inputMapObject.getKey()).toString()+"::"+inputMapObject.getKey()+" and the value is "+mapFromBrowser.get(inputMapObject.getKey()));
                          
                        }else { //else condition if the values are different
                     	   testStepFailed("CD value mismatch->"+inputMap2.get(inputMapObject.getKey()).toString()+" :: "+inputMapObject.getKey()+" ; Value generated is  "+mapFromBrowser.get(inputMapObject.getKey()));
                        }
                    } else {
                 	   //Else condition if Browser map does not contain any input Map Keys
                 	   testStepFailed("CD Value "+inputMap2.get(inputMapObject.getKey()).toString()+" doesn't exist for "+inputMapObject.getKey() +" and the value is "+inputMapObject.getValue());
               }
          }
  }
}
	
	public void verifywWAPageFromGoogleDataLayerContents(){
		try{
			testStepInfo("*********************************Validating WA Page from google**********************************");
			navigateTo("https://www.google.com/#q=forbes");
			//refreshPage();
			clickOn(OR.url_Forbes_google);
			String pageurl = getCurrentPageURL();
			if(pageurl.contains("https://www.forbes.com/")){
				testStepInfo("Skipped the WA page and landed on homepage");
				readJSWAFromGoogleScenario2();
				driver.manage().deleteAllCookies();
				
			}
			else{
			readJSWAFromGoogle();
			driver.manage().deleteAllCookies();
			}
		}
		
		catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	}
	
	public void readJSWAFromGoogle(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
  
        inputMap2.put("DFPZone","cd16");
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("referrer","dr");
        inputMap2.put("trueIntendedPage","CD63");
        
        inputMap.put("DFPZone","welcome");
        inputMap.put("channel","ads");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("referrer","https://www.google.com/");
        inputMap.put("trueIntendedPage","https://www.forbes.com/");
        
         
        
        if (driver instanceof JavascriptExecutor) {
            
            JavascriptExecutor js = (JavascriptExecutor)driver;
            java.util.ArrayList o = (ArrayList) js.executeScript("return window.dataLayer;");
            Iterator i = o.iterator();
            Map<String,Object> mapFromBrowser = (Map<String, Object>) i.next();
            System.out.println("String Json: " + mapFromBrowser.size());

               for (Map.Entry<String, Object> inputMapObject : inputMap.entrySet()) {
             	  /**
            	    * condition if Browser map contain any input Map Keys
            	    */
                    if (mapFromBrowser.containsKey(inputMapObject.getKey())) {
                 	   //if condition to check the values are same for the given key
                        if(mapFromBrowser.get(inputMapObject.getKey()).toString().equalsIgnoreCase(inputMapObject.getValue().toString())){
                          testStepPassed("CD Value is-> "+inputMap2.get(inputMapObject.getKey()).toString()+"::"+inputMapObject.getKey()+" and the value is "+mapFromBrowser.get(inputMapObject.getKey()));
                          
                        }else { //else condition if the values are different
                     	   testStepFailed("CD value mismatch->"+inputMap2.get(inputMapObject.getKey()).toString()+" :: "+inputMapObject.getKey()+" ; Value generated is  "+mapFromBrowser.get(inputMapObject.getKey()));
                        }
                    } else {
                 	   //Else condition if Browser map does not contain any input Map Keys
                 	   testStepFailed("CD Value "+inputMap2.get(inputMapObject.getKey()).toString()+" doesn't exist for "+inputMapObject.getKey() +" and the value is "+inputMapObject.getValue());
               }
          }
  }
}
	public void readJSWAFromGoogleScenario2(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
  
        inputMap2.put("DFPZone","cd16");
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("referrer","dr");
        inputMap2.put("pageType","cd13");
        inputMap2.put("section","cd38");
        //inputMap2.put("trueIntendedPage","CD63");
        
        inputMap.put("DFPZone","home");
        inputMap.put("channel","home");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("referrer","https://www.google.com/");
        inputMap.put("pageType","csf");
        inputMap.put("section","main");
       // inputMap.put("trueIntendedPage","https://www.forbes.com/");
        
         
        
        if (driver instanceof JavascriptExecutor) {
            
            JavascriptExecutor js = (JavascriptExecutor)driver;
            java.util.ArrayList o = (ArrayList) js.executeScript("return window.dataLayer;");
            Iterator i = o.iterator();
            Map<String,Object> mapFromBrowser = (Map<String, Object>) i.next();
            System.out.println("String Json: " + mapFromBrowser.size());

               for (Map.Entry<String, Object> inputMapObject : inputMap.entrySet()) {
             	  /**
            	    * condition if Browser map contain any input Map Keys
            	    */
                    if (mapFromBrowser.containsKey(inputMapObject.getKey())) {
                 	   //if condition to check the values are same for the given key
                        if(mapFromBrowser.get(inputMapObject.getKey()).toString().equalsIgnoreCase(inputMapObject.getValue().toString())){
                          testStepPassed("CD Value is-> "+inputMap2.get(inputMapObject.getKey()).toString()+"::"+inputMapObject.getKey()+" and the value is "+mapFromBrowser.get(inputMapObject.getKey()));
                          
                        }else { //else condition if the values are different
                     	   testStepFailed("CD value mismatch->"+inputMap2.get(inputMapObject.getKey()).toString()+" :: "+inputMapObject.getKey()+" ; Value generated is  "+mapFromBrowser.get(inputMapObject.getKey()));
                        }
                    } else {
                 	   //Else condition if Browser map does not contain any input Map Keys
                 	   testStepFailed("CD Value "+inputMap2.get(inputMapObject.getKey()).toString()+" doesn't exist for "+inputMapObject.getKey() +" and the value is "+inputMapObject.getValue());
               }
          }
  }
}
	
	public void verifywWAPageFromFBDataLayerContents(){
		try{
			testStepInfo("*********************************Validating WA Page from google**********************************");
			navigateTo("https://www.forbes.com/sites/leliagowland/2017/02/21/leaving-on-a-jet-plane-3-strategies-to-ease-business-travel/?utm_source=followingimmediate&utm_source=FBPAGE&utm_medium=email&utm_medium=social&utm_campaign=20170221&utm_campaign=sprinklrForbesWoman&utm_content=816113620#631a1c4d4ae9");
			/*typeIn(OR.txtBox_Fb_Username, "satluri@forbes.com");
			typeIn(OR.txtBox_Fb_Password, "Saibaba@13");
			clickOn(OR.button_FBsubmit);
			navigateTo("https://www.facebook.com/pg/forbes/posts/?ref=page_internal");
			clickOn(OR.button_FBPosts);
			clickOn(OR.url_ForbesPost);
			String winHandleBefore = driver.getWindowHandle();
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}*/
			readJSWAFromFB();
		}
		
		catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	}
	
	public void readJSWAFromFB(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
  
        inputMap2.put("DFPZone","cd16");
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("referrer","dr");
        inputMap2.put("trueIntendedPage","CD63");
        
        inputMap.put("DFPZone","welcome");
        inputMap.put("channel","ads");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("referrer","");
        inputMap.put("trueIntendedPage","https://www.forbes.com/sites/leliagowland/2017/02/21/leaving-on-a-jet-plane-3-strategies-to-ease-business-travel/");
        
         
        
        if (driver instanceof JavascriptExecutor) {
            
            JavascriptExecutor js = (JavascriptExecutor)driver;
            java.util.ArrayList o = (ArrayList) js.executeScript("return window.dataLayer;");
            Iterator i = o.iterator();
            Map<String,Object> mapFromBrowser = (Map<String, Object>) i.next();
            System.out.println("String Json: " + mapFromBrowser.size());

               for (Map.Entry<String, Object> inputMapObject : inputMap.entrySet()) {
             	  /**
            	    * condition if Browser map contain any input Map Keys
            	    */
                    if (mapFromBrowser.containsKey(inputMapObject.getKey())) {
                 	   //if condition to check the values are same for the given key
                        if(mapFromBrowser.get(inputMapObject.getKey()).toString().equalsIgnoreCase(inputMapObject.getValue().toString())){
                          testStepPassed("CD Value is-> "+inputMap2.get(inputMapObject.getKey()).toString()+"::"+inputMapObject.getKey()+" and the value is "+mapFromBrowser.get(inputMapObject.getKey()));
                          
                        }else { //else condition if the values are different
                     	   testStepFailed("CD value mismatch->"+inputMap2.get(inputMapObject.getKey()).toString()+" :: "+inputMapObject.getKey()+" ; Value generated is  "+mapFromBrowser.get(inputMapObject.getKey()));
                        }
                    } else {
                 	   //Else condition if Browser map does not contain any input Map Keys
                 	   testStepFailed("CD Value "+inputMap2.get(inputMapObject.getKey()).toString()+" doesn't exist for "+inputMapObject.getKey() +" and the value is "+inputMapObject.getValue());
               }
          }
  }
}

}
