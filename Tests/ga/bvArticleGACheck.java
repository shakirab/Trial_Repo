package ga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

public class bvArticleGACheck extends ApplicationKeywords{
	
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
	public bvArticleGACheck(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public bvArticleGACheck() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyBVArticlepageGAContents(){
		testStepInfo("*********************************BV Article Page GA/Datalayer validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("Contributor_BrandVoice")) {

			verifyBVArticlePageDataLayerContents();

		} 
		 else {

			}
	}
	
	public void verifyBVArticlePageDataLayerContents(){
		try{
			navigateTo("https://www.forbes.com/sites/sap/2016/11/11/smart-cities-the-next-digital-frontier");
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
        inputMap2.put("published","cd29");
        inputMap2.put("referrer","cd54");
        inputMap2.put("section","cd38");
       // inputMap2.put("shareChild","cd23");
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
        inputMap2.put("bVContentSource","cd61");
        inputMap2.put("bvLeftRailHeadline","cd62");
        inputMap2.put("StreamPosition","cd64");
        inputMap2.put("DFPLineitemID","cd65");
        inputMap2.put("protocol","cd67");
        inputMap2.put("bVProgramType","cd68");
        inputMap2.put("forbesOnTrump","cd69");
        
        inputMap.put("author","Paul Taylor");
        inputMap.put("blogType","ad");
        inputMap.put("brandVoice","sap");
        inputMap.put("DFPZone","article-d");
        inputMap.put("categories","Business,Logistics & Transportation,Tech,Data Driven,Cloud Computing,Green Tech");
        inputMap.put("channel","business");
        inputMap.put("contribActive","true");
        inputMap.put("contribType","AdVoice");
        inputMap.put("customPage","http://www.forbes.com/sites/sap/2016/11/11/smart-cities-the-next-digital-frontier/");
        inputMap.put("doNotPaginate","none");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("hashtags","ChangeTheWorld");
        inputMap.put("heroImage","false");
        inputMap.put("imageCount","1");
        inputMap.put("leftRail","true");
        inputMap.put("login","false");
        inputMap.put("naturalID","blogAndPostId/blog/post/1194-32795");
        inputMap.put("pageNumber","1");
        inputMap.put("pageTotal","1");
        inputMap.put("pageType","blog:standard");
        inputMap.put("paragraphs","18");
        inputMap.put("primaryChannel","Business");
        inputMap.put("primarySection","none");
        inputMap.put("publishHour","07");
        inputMap.put("published","2016-11-11");
        inputMap.put("referrer","none");
        inputMap.put("section","sapblog");
       // inputMap.put("shareChild","67b11b8f7c11");
        inputMap.put("shareParent","none");
        inputMap.put("site","sap");
        inputMap.put("slot","sap");
        inputMap.put("streamPosition","0");
        inputMap.put("trendingHashtags","none");
        inputMap.put("updateDate","2016-11-11");
        inputMap.put("updateHour","16");
        inputMap.put("videoPlacement","none");
        inputMap.put("weekdayPublish","Friday");
        inputMap2.put("brandVoiceLive","true");
        inputMap2.put("bVContentSource","client");
        inputMap2.put("bVLeftRailHeadline","recommend");
        inputMap2.put("StreamPosition","0");
        inputMap2.put("DFPLineitemID","none");
        inputMap2.put("bVProgramType","elite");
        inputMap2.put("forbesOnTrump","false");
        
         
        
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
