package ga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

public class contribPageGACheck extends ApplicationKeywords{
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
	 * Instantiates  Contributor Page GA Check Functions
	 *
	 * @param obj
	 *            the obj
	 */
	public contribPageGACheck(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public contribPageGACheck() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyContribPageGAContents(){
		testStepInfo("*********************************Contributor Page GA/Datalayer validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("Contributor_BrandVoice")) {

			verifyContribPageDataLayerContents();

		} 
		 else {

			}
	}
	
	public void verifyContribPageDataLayerContents(){
		try{
			navigateTo("https://www.forbes.com/sites/lewisdvorkin/");
			/*waitTime(4);
			clickOn(OR.txt_Home_Forbes_Continue_site);*/
			waitTime(20);
			readIndividualContribJS();
			testStepInfo("*********************************BV Group Contributor Page GA/Datalayer validation**********************************");
			navigateTo("https://www.forbes.com/sites/northwesternmutual/");
			readBVGrpContribJS();
			testStepInfo("*********************************BV Contributor Page GA/Datalayer validation**********************************");
			navigateTo("https://www.forbes.com/sites/northwesternmutual/people/brentschutte/");
			readBVContribJS();
			testStepInfo("*********************************Contributor Group GA/Datalayer validation**********************************");
			navigateTo("https://www.forbes.com/sites/theapothecary/");
			readContribGrpBlogJS();
			testStepInfo("*********************************Community Voice Group GA/Datalayer validation**********************************");
			navigateTo("https://www.forbes.com/sites/yec/");
			readCommunityVoiceBlogJS();
		}
		
		catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	}
	
	public void readIndividualContribJS(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
       
        inputMap2.put("brandVoice","cd12");
        inputMap2.put("author", "cd2");
        inputMap2.put("DFPZone","cd16"); 
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("login","cd46");
        inputMap2.put("brandVoiceLive","cd45");
        inputMap2.put("bvProgramType","cd68");
        inputMap2.put("pageType","cd13");
        inputMap2.put("primaryChannel","cd59");
        inputMap2.put("primarySection","cd60");
        inputMap2.put("referrer","dr");
        inputMap2.put("section","cd38");
        //inputMap2.put("shareChild","cd23");
        //inputMap2.put("shareParent","cd22");
        inputMap2.put("slot","cd5");
        inputMap2.put("site","cd3");
        inputMap2.put("contribType","cd9");
        inputMap2.put("contribActive","cd56");
          
        inputMap.put("brandVoice","none");
        inputMap.put("author", "Lewis DVorkin");
        inputMap.put("DFPZone","contribhome");
        inputMap.put("channel","business");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("login","false");
        inputMap.put("pageType","contrib");
        inputMap.put("primaryChannel","Business");
        inputMap.put("primarySection","none");
        inputMap.put("referrer","https://www.forbes.com/forbes/welcome/?toURL=https://www.forbes.com/sites/lewisdvorkin/&refURL=&referrer=");
        inputMap.put("section","lewisdvorkinblog");
        //inputMap.put("shareChild","4a9eaa4e6879");
        //inputMap.put("shareParent","none");
        inputMap.put("brandVoiceLive","false");
        inputMap.put("bvProgramType","none");
        inputMap.put("slot","none");
        inputMap.put("site","lewisdvorkin");
        inputMap.put("contribType","Forbes Staff");
        inputMap.put("contribActive","false");
        
         
        
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

	public void readBVGrpContribJS(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
       
        inputMap2.put("brandVoice","cd12");
        inputMap2.put("author", "cd2");
        inputMap2.put("DFPZone","cd16"); 
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("login","cd46");
        inputMap2.put("brandVoiceLive","cd45");
        inputMap2.put("bvProgramType","cd68");
        inputMap2.put("pageType","cd13");
        inputMap2.put("primaryChannel","cd59");
        inputMap2.put("primarySection","cd60");
        inputMap2.put("referrer","dr");
        inputMap2.put("section","cd38");
        //inputMap2.put("shareChild","cd23");
        //inputMap2.put("shareParent","cd22");
        inputMap2.put("slot","cd5");
        inputMap2.put("site","cd3");
        inputMap2.put("contribType","cd9");
        inputMap2.put("contribActive","cd56");
          
        inputMap.put("brandVoice","northwesternmutual");
        inputMap.put("author", "Northwestern Mutual");
        inputMap.put("DFPZone","contribhome");
        inputMap.put("channel","business");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("login","false");
        inputMap.put("pageType","contrib");
        inputMap.put("primaryChannel","Investing");
        inputMap.put("primarySection","none");
        inputMap.put("referrer","none");
        inputMap.put("section","northwesternmutualblog");
        //inputMap.put("shareChild","4a9eaa4e6879");
        //inputMap.put("shareParent","none");
        inputMap.put("brandVoiceLive","true");
        inputMap.put("bvProgramType","elite");
        inputMap.put("slot","nwmf");
        inputMap.put("site","northwesternmutual");
        inputMap.put("contribType","AdVoice");
        inputMap.put("contribActive","true");
        
         
        
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
	
	public void readBVContribJS(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
       
        inputMap2.put("brandVoice","cd12");
        inputMap2.put("author", "cd2");
        inputMap2.put("DFPZone","cd16"); 
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("login","cd46");
        inputMap2.put("brandVoiceLive","cd45");
        inputMap2.put("bvProgramType","cd68");
        inputMap2.put("pageType","cd13");
        inputMap2.put("primaryChannel","cd59");
        inputMap2.put("primarySection","cd60");
        inputMap2.put("referrer","dr");
        inputMap2.put("section","cd38");
        //inputMap2.put("shareChild","cd23");
        //inputMap2.put("shareParent","cd22");
        inputMap2.put("slot","cd5");
        inputMap2.put("site","cd3");
        inputMap2.put("contribType","cd9");
        inputMap2.put("contribActive","cd56");
          
        inputMap.put("brandVoice","northwesternmutual");
        inputMap.put("author", "Brent Schutte, CFA");
        inputMap.put("DFPZone","contribhome");
        inputMap.put("channel","business");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("login","false");
        inputMap.put("pageType","contrib");
        inputMap.put("primaryChannel","Investing");
        inputMap.put("primarySection","none");
        inputMap.put("referrer","none");
        inputMap.put("section","northwesternmutualblog");
        //inputMap.put("shareChild","4a9eaa4e6879");
        //inputMap.put("shareParent","none");
        inputMap.put("brandVoiceLive","false");
        inputMap.put("bvProgramType","elite");
        inputMap.put("slot","none");
        inputMap.put("site","northwesternmutual");
        inputMap.put("contribType","AdVoice");
        inputMap.put("contribActive","false");
        
         
        
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
	public void readContribGrpBlogJS(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
       
        inputMap2.put("brandVoice","cd12");
        inputMap2.put("author", "cd2");
        inputMap2.put("DFPZone","cd16"); 
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("login","cd46");
        inputMap2.put("brandVoiceLive","cd45");
        inputMap2.put("bvProgramType","cd68");
        inputMap2.put("pageType","cd13");
        inputMap2.put("primaryChannel","cd59");
        inputMap2.put("primarySection","cd60");
        inputMap2.put("referrer","dr");
        inputMap2.put("section","cd38");
        //inputMap2.put("shareChild","cd23");
        //inputMap2.put("shareParent","cd22");
        inputMap2.put("slot","cd5");
        inputMap2.put("site","cd3");
        inputMap2.put("contribType","cd9");
        inputMap2.put("contribActive","cd56");
          
        inputMap.put("brandVoice","none");
        inputMap.put("author", "The Apothecary");
        inputMap.put("DFPZone","contribhome");
        inputMap.put("channel","opinions");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("login","false");
        inputMap.put("pageType","contrib");
        inputMap.put("primaryChannel","Opinion");
        inputMap.put("primarySection","none");
        inputMap.put("referrer","none");
        inputMap.put("section","business");
        //inputMap.put("shareChild","4a9eaa4e6879");
        //inputMap.put("shareParent","none");
        inputMap.put("brandVoiceLive","false");
        inputMap.put("bvProgramType","none");
        inputMap.put("slot","none");
        inputMap.put("site","theapothecary");
        inputMap.put("contribType","Contributor Group");
        inputMap.put("contribActive","true");
        
         
        
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
	
	public void readCommunityVoiceBlogJS(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
       
        inputMap2.put("brandVoice","cd12");
        inputMap2.put("author", "cd2");
        inputMap2.put("DFPZone","cd16"); 
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("login","cd46");
        inputMap2.put("brandVoiceLive","cd45");
        inputMap2.put("bvProgramType","cd68");
        inputMap2.put("pageType","cd13");
        inputMap2.put("primaryChannel","cd59");
        inputMap2.put("primarySection","cd60");
        inputMap2.put("referrer","dr");
        inputMap2.put("section","cd38");
        //inputMap2.put("shareChild","cd23");
        //inputMap2.put("shareParent","cd22");
        inputMap2.put("slot","cd5");
        inputMap2.put("site","cd3");
        inputMap2.put("contribType","cd9");
        inputMap2.put("contribActive","cd56");
          
        inputMap.put("brandVoice","none");
        inputMap.put("author", "YEC Women");
        inputMap.put("DFPZone","contribhome");
        inputMap.put("channel","leadership");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("login","false");
        inputMap.put("pageType","contrib");
        inputMap.put("primaryChannel","Leadership");
        inputMap.put("primarySection","none");
        inputMap.put("referrer","none");
        inputMap.put("section","yecblog");
        //inputMap.put("shareChild","4a9eaa4e6879");
        //inputMap.put("shareParent","none");
        inputMap.put("brandVoiceLive","false");
        inputMap.put("bvProgramType","none");
        inputMap.put("slot","none");
        inputMap.put("site","yec");
        inputMap.put("contribType","CommunityVoice");
        inputMap.put("contribActive","false");
        
         
        
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
