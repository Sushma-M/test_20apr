/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments2.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_20apr.bmgf_investments2.service.InvestmentService;
import com.test_20apr.bmgf_investments2.service.StatusService;
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
 * Controller object for domain model class Status.
 * @see com.test_20apr.bmgf_investments2.Status
 */
@RestController(value = "BMGF_Investments2.StatusController")
@RequestMapping("/BMGF_Investments2/Status")
@Api(description = "Exposes APIs to work with Status resource.", value = "StatusController")
public class StatusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    @Qualifier("BMGF_Investments2.StatusService")
    private StatusService statusService;

    @Autowired
    @Qualifier("BMGF_Investments2.InvestmentService")
    private InvestmentService investmentService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Status instances matching the search criteria.")
    public Page<Status> findStatuss(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Statuss list");
        return statusService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Status instances.")
    public Page<Status> getStatuss(Pageable pageable) {
        LOGGER.debug("Rendering Statuss list");
        return statusService.findAll(pageable);
    }

    @RequestMapping(value = "/{id:.+}/investments", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the investments instance associated with the given id.")
    public Page<Investment> findAssociatedinvestments(Pageable pageable, @PathVariable("id") String id) {
        LOGGER.debug("Fetching all associated investments");
        return investmentService.findAssociatedValues(id, "status", "statusId", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setStatusService(StatusService service) {
        this.statusService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Status instance.")
    public Status createStatus(@RequestBody Status instance) {
        LOGGER.debug("Create Status with information: {}", instance);
        instance = statusService.create(instance);
        LOGGER.debug("Created Status with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Status instances.")
    public Long countAllStatuss() {
        LOGGER.debug("counting Statuss");
        Long count = statusService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Status instance associated with the given id.")
    public Status getStatus(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting Status with id: {}", id);
        Status instance = statusService.findById(id);
        LOGGER.debug("Status details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Status instance associated with the given id.")
    public Status editStatus(@PathVariable(value = "id") String id, @RequestBody Status instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Status with id: {}", instance.getStatusId());
        instance.setStatusId(id);
        instance = statusService.update(instance);
        LOGGER.debug("Status details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Status instance associated with the given id.")
    public boolean deleteStatus(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Status with id: {}", id);
        Status deleted = statusService.delete(id);
        return deleted != null;
    }
}
