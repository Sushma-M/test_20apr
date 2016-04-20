/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/
package com.test_20apr.bmgf_investments.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_20apr.bmgf_investments.service.InvestmentAttributeCodeService;
import com.test_20apr.bmgf_investments.service.InvestmentAttributeService;
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
import com.test_20apr.bmgf_investments.*;
import com.test_20apr.bmgf_investments.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class InvestmentAttribute.
 * @see com.test_20apr.bmgf_investments.InvestmentAttribute
 */
@RestController(value = "BMGF_Investments.InvestmentAttributeController")
@RequestMapping("/BMGF_Investments/InvestmentAttribute")
@Api(description = "Exposes APIs to work with InvestmentAttribute resource.", value = "InvestmentAttributeController")
public class InvestmentAttributeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvestmentAttributeController.class);

    @Autowired
    @Qualifier("BMGF_Investments.InvestmentAttributeService")
    private InvestmentAttributeService investmentAttributeService;

    @Autowired
    @Qualifier("BMGF_Investments.InvestmentAttributeCodeService")
    private InvestmentAttributeCodeService investmentAttributeCodeService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of InvestmentAttribute instances matching the search criteria.")
    public Page<InvestmentAttribute> findInvestmentAttributes(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering InvestmentAttributes list");
        return investmentAttributeService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of InvestmentAttribute instances.")
    public Page<InvestmentAttribute> getInvestmentAttributes(Pageable pageable) {
        LOGGER.debug("Rendering InvestmentAttributes list");
        return investmentAttributeService.findAll(pageable);
    }

    @RequestMapping(value = "/{id:.+}/investmentAttributeCodes", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the investmentAttributeCodes instance associated with the given id.")
    public Page<InvestmentAttributeCode> findAssociatedinvestmentAttributeCodes(Pageable pageable, @PathVariable("id") String id) {
        LOGGER.debug("Fetching all associated investmentAttributeCodes");
        return investmentAttributeCodeService.findAssociatedValues(id, "investmentAttribute", "investmentAttributeId", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setInvestmentAttributeService(InvestmentAttributeService service) {
        this.investmentAttributeService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new InvestmentAttribute instance.")
    public InvestmentAttribute createInvestmentAttribute(@RequestBody InvestmentAttribute instance) {
        LOGGER.debug("Create InvestmentAttribute with information: {}", instance);
        instance = investmentAttributeService.create(instance);
        LOGGER.debug("Created InvestmentAttribute with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of InvestmentAttribute instances.")
    public Long countAllInvestmentAttributes() {
        LOGGER.debug("counting InvestmentAttributes");
        Long count = investmentAttributeService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the InvestmentAttribute instance associated with the given id.")
    public InvestmentAttribute getInvestmentAttribute(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting InvestmentAttribute with id: {}", id);
        InvestmentAttribute instance = investmentAttributeService.findById(id);
        LOGGER.debug("InvestmentAttribute details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the InvestmentAttribute instance associated with the given id.")
    public InvestmentAttribute editInvestmentAttribute(@PathVariable(value = "id") String id, @RequestBody InvestmentAttribute instance) throws EntityNotFoundException {
        LOGGER.debug("Editing InvestmentAttribute with id: {}", instance.getInvestmentAttributeId());
        instance.setInvestmentAttributeId(id);
        instance = investmentAttributeService.update(instance);
        LOGGER.debug("InvestmentAttribute details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the InvestmentAttribute instance associated with the given id.")
    public boolean deleteInvestmentAttribute(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting InvestmentAttribute with id: {}", id);
        InvestmentAttribute deleted = investmentAttributeService.delete(id);
        return deleted != null;
    }
}
