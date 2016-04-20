/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/
package com.test_20apr.dbtest123.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_20apr.dbtest123.service.CompositesDiffService;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestBody;
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
 * Controller object for domain model class CompositesDiff.
 * @see com.test_20apr.dbtest123.CompositesDiff
 */
@RestController(value = "DBtest123.CompositesDiffController")
@RequestMapping("/DBtest123/CompositesDiff")
@Api(description = "Exposes APIs to work with CompositesDiff resource.", value = "CompositesDiffController")
public class CompositesDiffController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompositesDiffController.class);

    @Autowired
    @Qualifier("DBtest123.CompositesDiffService")
    private CompositesDiffService compositesDiffService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of CompositesDiff instances matching the search criteria.")
    public Page<CompositesDiff> findCompositesDiffs(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CompositesDiffs list");
        return compositesDiffService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of CompositesDiff instances.")
    public Page<CompositesDiff> getCompositesDiffs(Pageable pageable) {
        LOGGER.debug("Rendering CompositesDiffs list");
        return compositesDiffService.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setCompositesDiffService(CompositesDiffService service) {
        this.compositesDiffService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new CompositesDiff instance.")
    public CompositesDiff createCompositesDiff(@RequestBody CompositesDiff instance) {
        LOGGER.debug("Create CompositesDiff with information: {}", instance);
        instance = compositesDiffService.create(instance);
        LOGGER.debug("Created CompositesDiff with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the CompositesDiff instance associated with the given composite-id.")
    public CompositesDiff getCompositesDiff(@RequestParam(value = "date1", required = true) Date date1, @RequestParam(value = "timestamp2", required = true) Date timestamp2, @RequestParam(value = "datetime2", required = true) Date datetime2, @RequestParam(value = "time2", required = true) Date time2, @RequestParam(value = "id", required = true) Integer id, @RequestParam(value = "column7", required = true) String column7) throws EntityNotFoundException {
        CompositesDiffId temp = new CompositesDiffId();
        temp.setDate1(date1);
        temp.setTimestamp2(timestamp2);
        temp.setDatetime2(datetime2);
        temp.setTime2(time2);
        temp.setId(id);
        temp.setColumn7(column7);
        LOGGER.debug("Getting CompositesDiff with id: {}", temp);
        CompositesDiff instance = compositesDiffService.findById(temp);
        LOGGER.debug("CompositesDiff details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the CompositesDiff instance associated with the given composite-id.")
    public CompositesDiff editCompositesDiff(@RequestParam(value = "date1", required = true) Date date1, @RequestParam(value = "timestamp2", required = true) Date timestamp2, @RequestParam(value = "datetime2", required = true) Date datetime2, @RequestParam(value = "time2", required = true) Date time2, @RequestParam(value = "id", required = true) Integer id, @RequestParam(value = "column7", required = true) String column7, @RequestBody CompositesDiff instance) throws EntityNotFoundException {
        CompositesDiffId temp = new CompositesDiffId();
        temp.setDate1(date1);
        temp.setTimestamp2(timestamp2);
        temp.setDatetime2(datetime2);
        temp.setTime2(time2);
        temp.setId(id);
        temp.setColumn7(column7);
        compositesDiffService.delete(temp);
        instance = compositesDiffService.create(instance);
        LOGGER.debug("CompositesDiff details with id is updated: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the CompositesDiff instance associated with the given composite-id.")
    public boolean deleteCompositesDiff(@RequestParam(value = "date1", required = true) Date date1, @RequestParam(value = "timestamp2", required = true) Date timestamp2, @RequestParam(value = "datetime2", required = true) Date datetime2, @RequestParam(value = "time2", required = true) Date time2, @RequestParam(value = "id", required = true) Integer id, @RequestParam(value = "column7", required = true) String column7) throws EntityNotFoundException {
        CompositesDiffId temp = new CompositesDiffId();
        temp.setDate1(date1);
        temp.setTimestamp2(timestamp2);
        temp.setDatetime2(datetime2);
        temp.setTime2(time2);
        temp.setId(id);
        temp.setColumn7(column7);
        LOGGER.debug("Deleting CompositesDiff with id: {}", temp);
        CompositesDiff deleted = compositesDiffService.delete(temp);
        return deleted != null;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of CompositesDiff instances.")
    public Long countAllCompositesDiffs() {
        LOGGER.debug("counting CompositesDiffs");
        Long count = compositesDiffService.countAll();
        return count;
    }
}
