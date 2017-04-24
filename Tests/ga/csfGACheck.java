package ga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class csfGACheck extends ApplicationKeywords{
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
	 * Instantiates  CSF GA Check Functions
	 *
	 * @param obj
	 *            the obj
	 */
	public csfGACheck(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public csfGACheck() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyCsfPageGAContents(){
		testStepInfo("*********************************CSF Page GA/Datalayer validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("CSF_CSR_List_Editors")) {

			verifyCsfPageDataLayerContents();

		} 
		 else {

			}
	}
	
	public void verifyCsfPageDataLayerContents(){
		try{
			testStepInfo("*********************************Validating Business CSF Page GA**********************************");
			navigateTo("https://www.forbes.com/business/");
			/*waitTime(4);
			clickOn(OR.txt_Home_Forbes_Continue_site);*/
			waitTime(17);
			readcsfJS();
			testStepInfo("*********************************Validating Forbes On Trump CSF Page GA**********************************");
			navigateTo("https://www.forbes.com/forbes-on-trump/");
			readForbesOnTrumpcsfJS();
			testStepInfo("*********************************Validating Vinyl CSF Page GA**********************************");
			navigateTo("https://www.forbes.com/vinyl/");
			readVinylcsfJS();
		}
		
		catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());	}
	}
	
	public void readcsfJS(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
       
        inputMap2.put("brandVoice","cd12");
        inputMap2.put("DFPZone","cd16"); 
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("login","cd46");
        inputMap2.put("brandVoiceLive","cd45");
        inputMap2.put("bvProgramType","cd68");
        inputMap2.put("forbesOnTrump","cd69");
        inputMap2.put("pageType","cd13");
        inputMap2.put("primaryChannel","cd59");
        inputMap2.put("primarySection","cd60");
        inputMap2.put("referrer","dr");
        inputMap2.put("section","cd38");
        //inputMap2.put("shareChild","cd23");
        inputMap2.put("shareParent","cd22");
        inputMap2.put("slot","cd5");
          
        inputMap.put("brandVoice","none");
        inputMap.put("DFPZone","channel");
        inputMap.put("channel","business");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("login","false");
        inputMap.put("pageType","csf");
        inputMap.put("primaryChannel","Business");
        inputMap.put("primarySection","none");
        inputMap.put("referrer","https://www.forbes.com/forbes/welcome/?toURL=https://www.forbes.com/business/&refURL=&referrer=");
        inputMap.put("section","none");
        //inputMap.put("shareChild","4a9eaa4e6879");
        inputMap.put("shareParent","none");
        inputMap.put("brandVoiceLive","none");
        inputMap.put("bvProgramType","none");
        inputMap.put("forbesOnTrump","false");
        inputMap.put("slot","business");
        
         
        
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
	
	public void readForbesOnTrumpcsfJS(){
        Map<String,Object> inputMap = new HashMap<String,Object> () ;
        Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
        
       
        inputMap2.put("brandVoice","cd12");
        inputMap2.put("DFPZone","cd16"); 
        inputMap2.put("channel","cd4");
        inputMap2.put("DFPSite","cd15");
        inputMap2.put("login","cd46");
        inputMap2.put("brandVoiceLive","cd45");
        inputMap2.put("bvProgramType","cd68");
        inputMap2.put("forbesOnTrump","cd69");
        inputMap2.put("pageType","cd13");
        inputMap2.put("primaryChannel","cd59");
        inputMap2.put("primarySection","cd60");
        inputMap2.put("referrer","dr");
        inputMap2.put("section","cd38");
        //inputMap2.put("shareChild","cd23");
        inputMap2.put("shareParent","cd22");
        inputMap2.put("slot","cd5");
          
        inputMap.put("brandVoice","none");
        inputMap.put("DFPZone","section");
        inputMap.put("channel","none");
        inputMap.put("DFPSite","fdc.forbes");
        inputMap.put("login","false");
        inputMap.put("pageType","csf");
        inputMap.put("primaryChannel","none");
        inputMap.put("primarySection","Forbes On Trump");
        inputMap.put("referrer","none");
        inputMap.put("section","none");
        //inputMap.put("shareChild","4a9eaa4e6879");
        inputMap.put("shareParent","none");
        inputMap.put("brandVoiceLive","none");
        inputMap.put("bvProgramType","none");
        inputMap.put("forbesOnTrump","true");
        inputMap.put("slot","none");
        
         
        
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
        
        public void readVinylcsfJS(){
            Map<String,Object> inputMap = new HashMap<String,Object> () ;
            Map<String,Object> inputMap2 = new HashMap<String,Object> () ;
            
           
            inputMap2.put("brandVoice","cd12");
            inputMap2.put("DFPZone","cd16"); 
            inputMap2.put("channel","cd4");
            inputMap2.put("DFPSite","cd15");
            inputMap2.put("login","cd46");
            inputMap2.put("brandVoiceLive","cd45");
            inputMap2.put("bvProgramType","cd68");
            inputMap2.put("forbesOnTrump","cd69");
            inputMap2.put("pageType","cd13");
            inputMap2.put("primaryChannel","cd59");
            inputMap2.put("primarySection","cd60");
            inputMap2.put("referrer","dr");
            inputMap2.put("section","cd38");
            //inputMap2.put("shareChild","cd23");
            inputMap2.put("shareParent","cd22");
            inputMap2.put("slot","cd5");
              
            inputMap.put("brandVoice","none");
            inputMap.put("DFPZone","csf");
            inputMap.put("channel","none");
            inputMap.put("DFPSite","fdc.forbes");
            inputMap.put("login","false");
            inputMap.put("pageType","csf");
            inputMap.put("primaryChannel","Business");
            inputMap.put("primarySection","Vinyl");
            inputMap.put("referrer","none");
            inputMap.put("section","none");
            //inputMap.put("shareChild","4a9eaa4e6879");
            inputMap.put("shareParent","none");
            inputMap.put("brandVoiceLive","none");
            inputMap.put("bvProgramType","none");
            inputMap.put("forbesOnTrump","false");
            inputMap.put("slot","none");
            
             
            
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
