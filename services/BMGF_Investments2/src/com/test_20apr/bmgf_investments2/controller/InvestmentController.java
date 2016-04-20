/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments2.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
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
 * Controller object for domain model class Investment.
 * @see com.test_20apr.bmgf_investments2.Investment
 */
@RestController(value = "BMGF_Investments2.InvestmentController")
@RequestMapping("/BMGF_Investments2/Investment")
@Api(description = "Exposes APIs to work with Investment resource.", value = "InvestmentController")
public class InvestmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvestmentController.class);

    @Autowired
    @Qualifier("BMGF_Investments2.InvestmentService")
    private InvestmentService investmentService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Investment instances matching the search criteria.")
    public Page<Investment> findInvestments(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Investments list");
        return investmentService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Investment instances.")
    public Page<Investment> getInvestments(Pageable pageable) {
        LOGGER.debug("Rendering Investments list");
        return investmentService.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setInvestmentService(InvestmentService service) {
        this.investmentService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Investment instance.")
    public Investment createInvestment(@RequestBody Investment instance) {
        LOGGER.debug("Create Investment with information: {}", instance);
        instance = investmentService.create(instance);
        LOGGER.debug("Created Investment with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Investment instances.")
    public Long countAllInvestments() {
        LOGGER.debug("counting Investments");
        Long count = investmentService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Investment instance associated with the given id.")
    public Investment getInvestment(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting Investment with id: {}", id);
        Investment instance = investmentService.findById(id);
        LOGGER.debug("Investment details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Investment instance associated with the given id.")
    public Investment editInvestment(@PathVariable(value = "id") String id, @RequestBody Investment instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Investment with id: {}", instance.getInvestmentId());
        instance.setInvestmentId(id);
        instance = investmentService.update(instance);
        LOGGER.debug("Investment details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Investment instance associated with the given id.")
    public boolean deleteInvestment(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Investment with id: {}", id);
        Investment deleted = investmentService.delete(id);
        return deleted != null;
    }
}
