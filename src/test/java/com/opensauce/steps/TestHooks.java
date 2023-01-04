package com.opensauce.steps;

import com.qascript.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class TestHooks extends BaseClass {



   @Before
    public void setup(){
       initializeDriver();

   }

   @After
    public void close(){
       closeDriver();
   }
}
