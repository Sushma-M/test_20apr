/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments2.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_20apr.bmgf_investments2.service.InvestmentService;
import com.test_20apr.bmgf_investments2.service.StrategyService;
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
 * Controller object for domain model class Strategy.
 * @see com.test_20apr.bmgf_investments2.Strategy
 */
@RestController(value = "BMGF_Investments2.StrategyController")
@RequestMapping("/BMGF_Investments2/Strategy")
@Api(description = "Exposes APIs to work with Strategy resource.", value = "StrategyController")
public class StrategyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StrategyController.class);

    @Autowired
    @Qualifier("BMGF_Investments2.StrategyService")
    private StrategyService strategyService;

    @Autowired
    @Qualifier("BMGF_Investments2.InvestmentService")
    private InvestmentService investmentService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Strategy instances matching the search criteria.")
    public Page<Strategy> findStrategys(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Strategys list");
        return strategyService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Strategy instances.")
    public Page<Strategy> getStrategys(Pageable pageable) {
        LOGGER.debug("Rendering Strategys list");
        return strategyService.findAll(pageable);
    }

    @RequestMapping(value = "/{id:.+}/investments", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the investments instance associated with the given id.")
    public Page<Investment> findAssociatedinvestments(Pageable pageable, @PathVariable("id") String id) {
        LOGGER.debug("Fetching all associated investments");
        return investmentService.findAssociatedValues(id, "strategy", "strategyId", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setStrategyService(StrategyService service) {
        this.strategyService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Strategy instance.")
    public Strategy createStrategy(@RequestBody Strategy instance) {
        LOGGER.debug("Create Strategy with information: {}", instance);
        instance = strategyService.create(instance);
        LOGGER.debug("Created Strategy with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Strategy instances.")
    public Long countAllStrategys() {
        LOGGER.debug("counting Strategys");
        Long count = strategyService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Strategy instance associated with the given id.")
    public Strategy getStrategy(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting Strategy with id: {}", id);
        Strategy instance = strategyService.findById(id);
        LOGGER.debug("Strategy details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Strategy instance associated with the given id.")
    public Strategy editStrategy(@PathVariable(value = "id") String id, @RequestBody Strategy instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Strategy with id: {}", instance.getStrategyId());
        instance.setStrategyId(id);
        instance = strategyService.update(instance);
        LOGGER.debug("Strategy details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Strategy instance associated with the given id.")
    public boolean deleteStrategy(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Strategy with id: {}", id);
        Strategy deleted = strategyService.delete(id);
        return deleted != null;
    }
}
