package com.homeaharaa.TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
		 
		@Test
 
		public void testCase1() {
 
			System.out.println(" @Test:-This is the Test Case 1");
 
		}
 
		@Test
 
		public void testCase2() {
 
			System.out.println("@Test:-This is the Test Case 2");
 
		}
 
		@BeforeMethod
 
		public void beforeMethod() {
 
			System.out.println("@BeforeMethod:-This will execute before every Method");
 
		}
 
		@AfterMethod
 
		public void afterMethod() {
 
			System.out.println("@afterMethod:-This will execute after every Method");
 
		}
 
		@BeforeClass
 
		public void beforeClass() {
 
			System.out.println("@beforeClass:-This will execute before the Class");
 
		}
		@AfterClass
 
		public void afterClass() {
 
			System.out.println("@afterClass:-This will execute after the Class");
 
		}
 
		@BeforeTest
 
		public void beforeTest() {
 
			System.out.println("@BeforeTest:-This will execute before the Test");
 
		}
 
		@AfterTest
 
		public void afterTest() {
 
			System.out.println("@afterTest:-This will execute after the Test");
 
		}
 
		@BeforeSuite
 
		public void beforeSuite() {
 
			System.out.println("@beforeSuite:-This will execute before the Test Suite");
 
		}
 
		@AfterSuite
 
		public void afterSuite() {
 
			System.out.println("@beforeSuite:-This will execute after the Test Suite");
 
		}
 
	}


