/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/
package com.test_20apr.bmgf_investments2.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_20apr.bmgf_investments2.service.InvestmentService;
import com.test_20apr.bmgf_investments2.service.KeyElementService;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wordnik.swagger.annotations.*;
import com.test_20apr.bmgf_investments2.*;
import com.test_20apr.bmgf_investments2.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class KeyElement.
 * @see com.test_20apr.bmgf_investments2.KeyElement
 */
@RestController(value = "BMGF_Investments2.KeyElementController")
@RequestMapping("/BMGF_Investments2/KeyElement")
@Api(description = "Exposes APIs to work with KeyElement resource.", value = "KeyElementController")
public class KeyElementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeyElementController.class);

    @Autowired
    @Qualifier("BMGF_Investments2.KeyElementService")
    private KeyElementService keyElementService;

    @Autowired
    @Qualifier("BMGF_Investments2.InvestmentService")
    private InvestmentService investmentService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of KeyElement instances matching the search criteria.")
    public Page<KeyElement> findKeyElements(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering KeyElements list");
        return keyElementService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of KeyElement instances.")
    public Page<KeyElement> getKeyElements(Pageable pageable) {
        LOGGER.debug("Rendering KeyElements list");
        return keyElementService.findAll(pageable);
    }

    @RequestMapping(value = "/{id:.+}/investments", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the investments instance associated with the given id.")
    public Page<Investment> findAssociatedinvestments(Pageable pageable, @PathVariable("id") String id) {
        LOGGER.debug("Fetching all associated investments");
        return investmentService.findAssociatedValues(id, "keyElement", "keyElementId", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setKeyElementService(KeyElementService service) {
        this.keyElementService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new KeyElement instance.")
    public KeyElement createKeyElement(@RequestBody KeyElement instance) {
        LOGGER.debug("Create KeyElement with information: {}", instance);
        instance = keyElementService.create(instance);
        LOGGER.debug("Created KeyElement with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of KeyElement instances.")
    public Long countAllKeyElements() {
        LOGGER.debug("counting KeyElements");
        Long count = keyElementService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the KeyElement instance associated with the given id.")
    public KeyElement getKeyElement(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting KeyElement with id: {}", id);
        KeyElement instance = keyElementService.findById(id);
        LOGGER.debug("KeyElement details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the KeyElement instance associated with the given id.")
    public KeyElement editKeyElement(@PathVariable(value = "id") String id, @RequestBody KeyElement instance) throws EntityNotFoundException {
        LOGGER.debug("Editing KeyElement with id: {}", instance.getKeyElementId());
        instance.setKeyElementId(id);
        instance = keyElementService.update(instance);
        LOGGER.debug("KeyElement details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the KeyElement instance associated with the given id.")
    public boolean deleteKeyElement(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting KeyElement with id: {}", id);
        KeyElement deleted = keyElementService.delete(id);
        return deleted != null;
    }
}
