package com.example.demo;

//import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectClasses;
//import org.junit.platform.suite.api.IncludeTags;
//import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import com.example.demo.service.NumServiceTest;



//@SelectPackages({"com.howtodoinjava.junit5.examples.packageA"
//				,"com.howtodoinjava.junit5.examples.packageB"})

//@IncludeTags("production")
//@SelectPackages("com.example.demo.service")
//@IncludePackages("com.example.demo.service")
@SelectClasses( NumServiceTest.class )
@Suite
public class TestSuite {

}