/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/
package com.test_20apr.db123testing.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_20apr.db123testing.service.TypesService;
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
import com.test_20apr.db123testing.*;
import com.test_20apr.db123testing.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Types.
 * @see com.test_20apr.db123testing.Types
 */
@RestController(value = "DB123Testing.TypesController")
@RequestMapping("/DB123Testing/Types")
@Api(description = "Exposes APIs to work with Types resource.", value = "TypesController")
public class TypesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypesController.class);

    @Autowired
    @Qualifier("DB123Testing.TypesService")
    private TypesService typesService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Types instances matching the search criteria.")
    public Page<Types> findTypess(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Typess list");
        return typesService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Types instances.")
    public Page<Types> getTypess(Pageable pageable) {
        LOGGER.debug("Rendering Typess list");
        return typesService.findAll(pageable);
    }

    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Retrieves content for the given BLOB field in Types instance")
    public DownloadResponse getTypesBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value = "download", defaultValue = "false") boolean download) {
        LOGGER.debug("Retrieves content for the given BLOB field {} in Types instance", fieldName);
        if (!WMRuntimeUtils.isLob(Types.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        Types instance = typesService.findById(id);
        return WMMultipartUtils.buildDownloadResponseForBlob(instance, fieldName, httpServletRequest, download);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "Creates a new Types instance.")
    public Types createTypes(@RequestBody Types instance) {
        LOGGER.debug("Create Types with information: {}", instance);
        instance = typesService.create(instance);
        LOGGER.debug("Created Types with information: {}", instance);
        return instance;
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setTypesService(TypesService service) {
        this.typesService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Types instance.This API should be used when the Types instance has fields that requires multipart data.")
    public Types createTypes(MultipartHttpServletRequest multipartHttpServletRequest) {
        Types types = WMMultipartUtils.toObject(multipartHttpServletRequest, Types.class, "DB123Testing");
        LOGGER.debug("Creating a new types with information: {}", types);
        return typesService.create(types);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Types instances.")
    public Long countAllTypess() {
        LOGGER.debug("counting Typess");
        Long count = typesService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Types instance associated with the given id.")
    public Types getTypes(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Types with id: {}", id);
        Types instance = typesService.findById(id);
        LOGGER.debug("Types details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Types instance associated with the given id.")
    public Types editTypes(@PathVariable(value = "id") Integer id, @RequestBody Types instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Types with id: {}", instance.getId());
        instance.setId(id);
        instance = typesService.update(instance);
        LOGGER.debug("Types details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Types instance associated with the given id.This API should be used when Types instance fields that require multipart data.")
    public Types editTypes(@PathVariable(value = "id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        Types newtypes = WMMultipartUtils.toObject(multipartHttpServletRequest, Types.class, "DB123Testing");
        newtypes.setId(id);
        Types oldtypes = typesService.findById(id);
        WMMultipartUtils.updateLobsContent(oldtypes, newtypes);
        LOGGER.debug("Updating types with information: {}", newtypes);
        return typesService.update(newtypes);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Types instance associated with the given id.")
    public boolean deleteTypes(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Types with id: {}", id);
        Types deleted = typesService.delete(id);
        return deleted != null;
    }
}