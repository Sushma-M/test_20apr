/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments2.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_20apr.bmgf_investments2.service.AttributeCategoryService;
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
 * Controller object for domain model class AttributeCategory.
 * @see com.test_20apr.bmgf_investments2.AttributeCategory
 */
@RestController(value = "BMGF_Investments2.AttributeCategoryController")
@RequestMapping("/BMGF_Investments2/AttributeCategory")
@Api(description = "Exposes APIs to work with AttributeCategory resource.", value = "AttributeCategoryController")
public class AttributeCategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttributeCategoryController.class);

    @Autowired
    @Qualifier("BMGF_Investments2.AttributeCategoryService")
    private AttributeCategoryService attributeCategoryService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of AttributeCategory instances matching the search criteria.")
    public Page<AttributeCategory> findAttributeCategorys(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering AttributeCategorys list");
        return attributeCategoryService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of AttributeCategory instances.")
    public Page<AttributeCategory> getAttributeCategorys(Pageable pageable) {
        LOGGER.debug("Rendering AttributeCategorys list");
        return attributeCategoryService.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setAttributeCategoryService(AttributeCategoryService service) {
        this.attributeCategoryService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new AttributeCategory instance.")
    public AttributeCategory createAttributeCategory(@RequestBody AttributeCategory instance) {
        LOGGER.debug("Create AttributeCategory with information: {}", instance);
        instance = attributeCategoryService.create(instance);
        LOGGER.debug("Created AttributeCategory with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of AttributeCategory instances.")
    public Long countAllAttributeCategorys() {
        LOGGER.debug("counting AttributeCategorys");
        Long count = attributeCategoryService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the AttributeCategory instance associated with the given id.")
    public AttributeCategory getAttributeCategory(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting AttributeCategory with id: {}", id);
        AttributeCategory instance = attributeCategoryService.findById(id);
        LOGGER.debug("AttributeCategory details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the AttributeCategory instance associated with the given id.")
    public AttributeCategory editAttributeCategory(@PathVariable(value = "id") String id, @RequestBody AttributeCategory instance) throws EntityNotFoundException {
        LOGGER.debug("Editing AttributeCategory with id: {}", instance.getAttributeCategoryId());
        instance.setAttributeCategoryId(id);
        instance = attributeCategoryService.update(instance);
        LOGGER.debug("AttributeCategory details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the AttributeCategory instance associated with the given id.")
    public boolean deleteAttributeCategory(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting AttributeCategory with id: {}", id);
        AttributeCategory deleted = attributeCategoryService.delete(id);
        return deleted != null;
    }
}