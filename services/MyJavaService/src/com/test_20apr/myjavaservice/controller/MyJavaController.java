/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
package com.test_20apr.myjavaservice.controller;

import com.test_20apr.myjavaservice.MyJavaService;
import java.lang.String;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/myJava", produces = { "application/json", "application/xml" })
public class MyJavaController {

    @Autowired
    private MyJavaService myJavaService;

    @RequestMapping(value = "/Name", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public String Name() {
        return myJavaService.Name();
    }

    @RequestMapping(value = "/sampleJavaOperation", produces = "application/json", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public String sampleJavaOperation(@RequestParam(value = "name", required = false) String name) {
        return myJavaService.sampleJavaOperation(name);
    }
}