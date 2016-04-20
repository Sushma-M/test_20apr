/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/
package com.test_20apr.dbtest123.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_20apr.dbtest123.service.AllDiffTypesService;
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
import com.test_20apr.dbtest123.*;
import com.test_20apr.dbtest123.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class AllDiffTypes.
 * @see com.test_20apr.dbtest123.AllDiffTypes
 */
@RestController(value = "DBtest123.AllDiffTypesController")
@RequestMapping("/DBtest123/AllDiffTypes")
@Api(description = "Exposes APIs to work with AllDiffTypes resource.", value = "AllDiffTypesController")
public class AllDiffTypesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllDiffTypesController.class);

    @Autowired
    @Qualifier("DBtest123.AllDiffTypesService")
    private AllDiffTypesService allDiffTypesService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of AllDiffTypes instances matching the search criteria.")
    public Page<AllDiffTypes> findAllDiffTypess(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering AllDiffTypess list");
        return allDiffTypesService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of AllDiffTypes instances.")
    public Page<AllDiffTypes> getAllDiffTypess(Pageable pageable) {
        LOGGER.debug("Rendering AllDiffTypess list");
        return allDiffTypesService.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setAllDiffTypesService(AllDiffTypesService service) {
        this.allDiffTypesService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new AllDiffTypes instance.")
    public AllDiffTypes createAllDiffTypes(@RequestBody AllDiffTypes instance) {
        LOGGER.debug("Create AllDiffTypes with information: {}", instance);
        instance = allDiffTypesService.create(instance);
        LOGGER.debug("Created AllDiffTypes with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of AllDiffTypes instances.")
    public Long countAllAllDiffTypess() {
        LOGGER.debug("counting AllDiffTypess");
        Long count = allDiffTypesService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the AllDiffTypes instance associated with the given id.")
    public AllDiffTypes getAllDiffTypes(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting AllDiffTypes with id: {}", id);
        AllDiffTypes instance = allDiffTypesService.findById(id);
        LOGGER.debug("AllDiffTypes details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the AllDiffTypes instance associated with the given id.")
    public AllDiffTypes editAllDiffTypes(@PathVariable(value = "id") Integer id, @RequestBody AllDiffTypes instance) throws EntityNotFoundException {
        LOGGER.debug("Editing AllDiffTypes with id: {}", instance.getId());
        instance.setId(id);
        instance = allDiffTypesService.update(instance);
        LOGGER.debug("AllDiffTypes details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the AllDiffTypes instance associated with the given id.")
    public boolean deleteAllDiffTypes(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting AllDiffTypes with id: {}", id);
        AllDiffTypes deleted = allDiffTypesService.delete(id);
        return deleted != null;
    }
}
