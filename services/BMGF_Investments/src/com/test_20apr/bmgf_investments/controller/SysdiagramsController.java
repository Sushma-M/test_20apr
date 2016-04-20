/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/
package com.test_20apr.bmgf_investments.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_20apr.bmgf_investments.service.SysdiagramsService;
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
 * Controller object for domain model class Sysdiagrams.
 * @see com.test_20apr.bmgf_investments.Sysdiagrams
 */
@RestController(value = "BMGF_Investments.SysdiagramsController")
@RequestMapping("/BMGF_Investments/Sysdiagrams")
@Api(description = "Exposes APIs to work with Sysdiagrams resource.", value = "SysdiagramsController")
public class SysdiagramsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysdiagramsController.class);

    @Autowired
    @Qualifier("BMGF_Investments.SysdiagramsService")
    private SysdiagramsService sysdiagramsService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Sysdiagrams instances matching the search criteria.")
    public Page<Sysdiagrams> findSysdiagramss(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Sysdiagramss list");
        return sysdiagramsService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Sysdiagrams instances.")
    public Page<Sysdiagrams> getSysdiagramss(Pageable pageable) {
        LOGGER.debug("Rendering Sysdiagramss list");
        return sysdiagramsService.findAll(pageable);
    }

    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Retrieves content for the given BLOB field in Sysdiagrams instance")
    public DownloadResponse getSysdiagramsBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value = "download", defaultValue = "false") boolean download) {
        LOGGER.debug("Retrieves content for the given BLOB field {} in Sysdiagrams instance", fieldName);
        if (!WMRuntimeUtils.isLob(Sysdiagrams.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        Sysdiagrams instance = sysdiagramsService.findById(id);
        return WMMultipartUtils.buildDownloadResponseForBlob(instance, fieldName, httpServletRequest, download);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @ApiOperation(value = "Creates a new Sysdiagrams instance.This API should be used when the Sysdiagrams instance has fields that requires multipart data.")
    public Sysdiagrams createSysdiagrams(MultipartHttpServletRequest multipartHttpServletRequest) {
        Sysdiagrams sysdiagrams = WMMultipartUtils.toObject(multipartHttpServletRequest, Sysdiagrams.class, "BMGF_Investments");
        LOGGER.debug("Creating a new sysdiagrams with information: {}", sysdiagrams);
        return sysdiagramsService.create(sysdiagrams);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setSysdiagramsService(SysdiagramsService service) {
        this.sysdiagramsService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Sysdiagrams instance.")
    public Sysdiagrams createSysdiagrams(@RequestBody Sysdiagrams instance) {
        LOGGER.debug("Create Sysdiagrams with information: {}", instance);
        instance = sysdiagramsService.create(instance);
        LOGGER.debug("Created Sysdiagrams with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Sysdiagrams instances.")
    public Long countAllSysdiagramss() {
        LOGGER.debug("counting Sysdiagramss");
        Long count = sysdiagramsService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Sysdiagrams instance associated with the given id.")
    public Sysdiagrams getSysdiagrams(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Sysdiagrams with id: {}", id);
        Sysdiagrams instance = sysdiagramsService.findById(id);
        LOGGER.debug("Sysdiagrams details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Sysdiagrams instance associated with the given id.")
    public Sysdiagrams editSysdiagrams(@PathVariable(value = "id") Integer id, @RequestBody Sysdiagrams instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Sysdiagrams with id: {}", instance.getDiagramId());
        instance.setDiagramId(id);
        instance = sysdiagramsService.update(instance);
        LOGGER.debug("Sysdiagrams details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Sysdiagrams instance associated with the given id.This API should be used when Sysdiagrams instance fields that require multipart data.")
    public Sysdiagrams editSysdiagrams(@PathVariable(value = "id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        Sysdiagrams newsysdiagrams = WMMultipartUtils.toObject(multipartHttpServletRequest, Sysdiagrams.class, "BMGF_Investments");
        newsysdiagrams.setDiagramId(id);
        Sysdiagrams oldsysdiagrams = sysdiagramsService.findById(id);
        WMMultipartUtils.updateLobsContent(oldsysdiagrams, newsysdiagrams);
        LOGGER.debug("Updating sysdiagrams with information: {}", newsysdiagrams);
        return sysdiagramsService.update(newsysdiagrams);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Sysdiagrams instance associated with the given id.")
    public boolean deleteSysdiagrams(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Sysdiagrams with id: {}", id);
        Sysdiagrams deleted = sysdiagramsService.delete(id);
        return deleted != null;
    }
}
