package ga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class articleGACheck extends ApplicationKeywords{
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
	public articleGACheck(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public articleGACheck() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyArticlepageGAContents(){
		testStepInfo("*********************************BV Article Page GA/Datalayer validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {

			verifyArticlePageDataLayerContents();

		} 
		 else {

			}
	}
	
	public void verifyArticlePageDataLayerContents(){
		try{
			navigateTo("https://www.forbes.com/sites/maddieberg/2017/02/16/heres-why-pewdiepie-will-still-earn-millions-even-after-anti-semitic-videos/");
			waitTime(18);
			//clickOn(OR.txt_Welcome_Article_Page_Label);
			//waitTime(15);
			readJS();
		}
		
		catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	}
	
	public void readJS(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
        inputMap2.put("author", "cd2");
        inputMap2.put("blogType","cd11");
        inputMap2.put("brandVoice","cd12");
        inputMap2.put("DFPZone","cd16");
        inputMap2.put("categories","cd19");
        inputMap2.put("channel","cd4");
        inputMap2.put("contribActive","cd56");
        inputMap2.put("contribType","cd9");
        inputMap2.put("customPage","cd50");
        inputMap2.put("doNotPaginate","cd40");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("hashtags","cd21");
        inputMap2.put("heroImage","cd48");
        inputMap2.put("imageCount","cd49");
        inputMap2.put("leftRail","cd58");
        inputMap2.put("login","cd46");
        inputMap2.put("naturalID","cd24");
        inputMap2.put("pageNumber","cd33");
        inputMap2.put("pageTotal","cd34");
        inputMap2.put("pageType","cd13");
        inputMap2.put("paragraphs","cd18");
        inputMap2.put("primaryChannel","cd59");
        inputMap2.put("primarySection","cd60");
        inputMap2.put("publishHour","cd35");
        inputMap2.put("published","cd17");
        inputMap2.put("referrer","dr");
        inputMap2.put("section","cd38");
        //inputMap2.put("shareChild","cd23");
        inputMap2.put("shareParent","cd22");
        inputMap2.put("site","cd3");
        inputMap2.put("slot","cd5");
        inputMap2.put("streamPosition","cd64");
        inputMap2.put("trendingHashtags","cd47");
        inputMap2.put("updateDate","cd36");
        inputMap2.put("updateHour","cd37");
        inputMap2.put("videoPlacement","cd42");
        inputMap2.put("weekdayPublish","cd51");
        inputMap2.put("brandVoiceLive","cd45");
        inputMap2.put("bvContentSource","cd61");
        inputMap2.put("bvLeftRailHeadline","cd62");
        inputMap2.put("StreamPosition","cd64");
        inputMap2.put("DFPLineItemID","cd65");
       // inputMap2.put("protocol","cd67");
        inputMap2.put("bvProgramType","cd68");
        inputMap2.put("forbesOnTrump","cd69");
        
        inputMap.put("author","Madeline Berg");
        inputMap.put("blogType","individual");
        inputMap.put("brandVoice","none");
        inputMap.put("DFPZone","article-d");
        inputMap.put("categories","Business,Media & Entertainment,Tech,Games");
        inputMap.put("channel","business");
        inputMap.put("contribActive","false");
        inputMap.put("contribType","Forbes Staff");
        inputMap.put("customPage","http://www.forbes.com/sites/maddieberg/2017/02/16/heres-why-pewdiepie-will-still-earn-millions-even-after-anti-semitic-videos/");
        inputMap.put("doNotPaginate","donotpaginate");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("hashtags","CelebrityMoney");
        inputMap.put("heroImage","false");
        inputMap.put("imageCount","1");
        inputMap.put("leftRail","true");
        inputMap.put("login","false");
        inputMap.put("naturalID","blogAndPostId/blog/post/3609-2961");
        inputMap.put("pageNumber","1");
        inputMap.put("pageTotal","1");
        inputMap.put("pageType","blog:standard");
        inputMap.put("paragraphs","30");
        inputMap.put("primaryChannel","Business");
        inputMap.put("primarySection","Media & Entertainment");
        inputMap.put("publishHour","09");
        inputMap.put("published","2017-02-16");
        inputMap.put("referrer","https://www.forbes.com/forbes/welcome/?toURL=https://www.forbes.com/sites/maddieberg/2017/02/16/heres-why-pewdiepie-will-still-earn-millions-even-after-anti-semitic-videos/&refURL=&referrer=");
        inputMap.put("section","media&entertainment");
        //inputMap.put("shareChild","4a9eaa4e6879");
        inputMap.put("shareParent","none");
        inputMap.put("site","maddieberg");
        inputMap.put("slot","none");
        inputMap.put("streamPosition","0");
        inputMap.put("trendingHashtags","none");
        inputMap.put("updateDate","2017-02-16");
        inputMap.put("updateHour","13");
        inputMap.put("videoPlacement","none");
        inputMap.put("weekdayPublish","Thursday");
        inputMap.put("brandVoiceLive","none");
        inputMap.put("bvContentSource","none");
        inputMap.put("bVLeftRailHeadline","none");
        inputMap.put("streamPosition","0");
        inputMap.put("DFPLineItemID","none");
       // inputMap.put("protocol","https");
        inputMap.put("bvProgramType","none");
        inputMap.put("forbesOnTrump","none");
        
         
        
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
