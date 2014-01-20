/**
 * Archetype - phresco-javawebservice-archetype
 *
 * Copyright (C) 1999-2013 Photon Infotech Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.photon.phresco.testcases;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.photon.phresco.Screens.WelcomeScreen;
import com.photon.phresco.uiconstants.PhrescoJavaWebserviceUiConstants;
import com.photon.phresco.uiconstants.PhrescoUiConstants;



public class JavaWebServiceTest {

	
	private  PhrescoUiConstants phrscEnv;
	private  PhrescoJavaWebserviceUiConstants javaWservice;
	private  WelcomeScreen welcomeScreen;
	private  String methodName;
	

	@Parameters(value = { "browser", "platform" })
	@BeforeTest
	public void setUp(String browser,String platform) throws Exception
	{
		
		phrscEnv=new PhrescoUiConstants();
		javaWservice=new PhrescoJavaWebserviceUiConstants();
		
		String selectedBrowser = browser;
		String selectedPlatform = platform;
		methodName = Thread.currentThread().getStackTrace()[1]
		                                					.getMethodName();
		Reporter.log("Selected Browser to execute testcases--->>"
		                                					+ selectedBrowser);
		String applicationURL = phrscEnv.PROTOCOL + "://"+ phrscEnv.HOST + ":" + phrscEnv.PORT+ "/";
	
		welcomeScreen = new WelcomeScreen(selectedBrowser,
				selectedPlatform, applicationURL,
				phrscEnv.CONTEXT);
		
		
	}

	
	@Test
	public void testHelloWorldPage()
			throws InterruptedException, IOException, Exception {
		try {
			
			System.out
			.println("---------testHelloWorldPage()-------------");
			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			
			welcomeScreen.javaWebservcieHelloWorld(methodName, javaWservice);
			
		} catch (Exception t) {
			t.printStackTrace();

		}
	}
	@AfterTest
	public  void tearDown() {
		welcomeScreen.closeBrowser();
	}

}
	
	





