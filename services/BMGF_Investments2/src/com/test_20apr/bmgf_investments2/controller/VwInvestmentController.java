/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments2.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_20apr.bmgf_investments2.service.VwInvestmentService;
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
 * Controller object for domain model class VwInvestment.
 * @see com.test_20apr.bmgf_investments2.VwInvestment
 */
@RestController(value = "BMGF_Investments2.VwInvestmentController")
@RequestMapping("/BMGF_Investments2/VwInvestment")
@Api(description = "Exposes APIs to work with VwInvestment resource.", value = "VwInvestmentController")
public class VwInvestmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VwInvestmentController.class);

    @Autowired
    @Qualifier("BMGF_Investments2.VwInvestmentService")
    private VwInvestmentService vwInvestmentService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of VwInvestment instances matching the search criteria.")
    public Page<VwInvestment> findVwInvestments(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering VwInvestments list");
        return vwInvestmentService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of VwInvestment instances.")
    public Page<VwInvestment> getVwInvestments(Pageable pageable) {
        LOGGER.debug("Rendering VwInvestments list");
        return vwInvestmentService.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setVwInvestmentService(VwInvestmentService service) {
        this.vwInvestmentService = service;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the VwInvestment instance associated with the given composite-id.")
    public VwInvestment getVwInvestment(@RequestParam(value = "investmentId", required = true) Integer investmentId, @RequestParam(value = "investmentName", required = true) String investmentName, @RequestParam(value = "programId", required = true) Integer programId, @RequestParam(value = "programName", required = true) String programName, @RequestParam(value = "strategyId", required = true) Integer strategyId, @RequestParam(value = "strategyName", required = true) String strategyName, @RequestParam(value = "initiativeId", required = true) Integer initiativeId, @RequestParam(value = "initiativeName", required = true) String initiativeName, @RequestParam(value = "subInitiativeId", required = true) Integer subInitiativeId, @RequestParam(value = "subInitiativeName", required = true) String subInitiativeName, @RequestParam(value = "keyElementId", required = true) Integer keyElementId, @RequestParam(value = "keyElementName", required = true) String keyElementName, @RequestParam(value = "statusId", required = true) Integer statusId, @RequestParam(value = "statusDescription", required = true) String statusDescription, @RequestParam(value = "notes", required = true) String notes) throws EntityNotFoundException {
        VwInvestmentId temp = new VwInvestmentId();
        temp.setInvestmentId(investmentId);
        temp.setInvestmentName(investmentName);
        temp.setProgramId(programId);
        temp.setProgramName(programName);
        temp.setStrategyId(strategyId);
        temp.setStrategyName(strategyName);
        temp.setInitiativeId(initiativeId);
        temp.setInitiativeName(initiativeName);
        temp.setSubInitiativeId(subInitiativeId);
        temp.setSubInitiativeName(subInitiativeName);
        temp.setKeyElementId(keyElementId);
        temp.setKeyElementName(keyElementName);
        temp.setStatusId(statusId);
        temp.setStatusDescription(statusDescription);
        temp.setNotes(notes);
        LOGGER.debug("Getting VwInvestment with id: {}", temp);
        VwInvestment instance = vwInvestmentService.findById(temp);
        LOGGER.debug("VwInvestment details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of VwInvestment instances.")
    public Long countAllVwInvestments() {
        LOGGER.debug("counting VwInvestments");
        Long count = vwInvestmentService.countAll();
        return count;
    }
}