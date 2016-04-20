/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/
package com.test_20apr.bmgf_investments2.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_20apr.bmgf_investments2.service.InitiativeService;
import com.test_20apr.bmgf_investments2.service.InvestmentService;
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
 * Controller object for domain model class Initiative.
 * @see com.test_20apr.bmgf_investments2.Initiative
 */
@RestController(value = "BMGF_Investments2.InitiativeController")
@RequestMapping("/BMGF_Investments2/Initiative")
@Api(description = "Exposes APIs to work with Initiative resource.", value = "InitiativeController")
public class InitiativeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitiativeController.class);

    @Autowired
    @Qualifier("BMGF_Investments2.InitiativeService")
    private InitiativeService initiativeService;

    @Autowired
    @Qualifier("BMGF_Investments2.InvestmentService")
    private InvestmentService investmentService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Initiative instances matching the search criteria.")
    public Page<Initiative> findInitiatives(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Initiatives list");
        return initiativeService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Initiative instances.")
    public Page<Initiative> getInitiatives(Pageable pageable) {
        LOGGER.debug("Rendering Initiatives list");
        return initiativeService.findAll(pageable);
    }

    @RequestMapping(value = "/{id:.+}/investments", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the investments instance associated with the given id.")
    public Page<Investment> findAssociatedinvestments(Pageable pageable, @PathVariable("id") String id) {
        LOGGER.debug("Fetching all associated investments");
        return investmentService.findAssociatedValues(id, "initiative", "initiativeId", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setInitiativeService(InitiativeService service) {
        this.initiativeService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Initiative instance.")
    public Initiative createInitiative(@RequestBody Initiative instance) {
        LOGGER.debug("Create Initiative with information: {}", instance);
        instance = initiativeService.create(instance);
        LOGGER.debug("Created Initiative with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Initiative instances.")
    public Long countAllInitiatives() {
        LOGGER.debug("counting Initiatives");
        Long count = initiativeService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Initiative instance associated with the given id.")
    public Initiative getInitiative(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting Initiative with id: {}", id);
        Initiative instance = initiativeService.findById(id);
        LOGGER.debug("Initiative details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Initiative instance associated with the given id.")
    public Initiative editInitiative(@PathVariable(value = "id") String id, @RequestBody Initiative instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Initiative with id: {}", instance.getInitiativeId());
        instance.setInitiativeId(id);
        instance = initiativeService.update(instance);
        LOGGER.debug("Initiative details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Initiative instance associated with the given id.")
    public boolean deleteInitiative(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Initiative with id: {}", id);
        Initiative deleted = initiativeService.delete(id);
        return deleted != null;
    }
}
