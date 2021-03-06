/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments2.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.test_20apr.bmgf_investments2.*;


/**
 * ServiceImpl object for domain model class Sysdiagrams.
 * @see com.test_20apr.bmgf_investments2.Sysdiagrams
 */
@Service("BMGF_Investments2.SysdiagramsService")
public class SysdiagramsServiceImpl implements SysdiagramsService {


    private static final Logger LOGGER = LoggerFactory.getLogger(SysdiagramsServiceImpl.class);

    @Autowired
    @Qualifier("BMGF_Investments2.SysdiagramsDao")
    private WMGenericDao<Sysdiagrams, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Sysdiagrams, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
     public Page<Sysdiagrams> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "BMGF_Investments2TransactionManager")
    @Override
    public Sysdiagrams create(Sysdiagrams sysdiagrams) {
        LOGGER.debug("Creating a new sysdiagrams with information: {}" , sysdiagrams);
        return this.wmGenericDao.create(sysdiagrams);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_Investments2TransactionManager")
    @Override
    public Sysdiagrams delete(Integer sysdiagramsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting sysdiagrams with id: {}" , sysdiagramsId);
        Sysdiagrams deleted = this.wmGenericDao.findById(sysdiagramsId);
        if (deleted == null) {
            LOGGER.debug("No sysdiagrams found with id: {}" , sysdiagramsId);
            throw new EntityNotFoundException(String.valueOf(sysdiagramsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<Sysdiagrams> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all sysdiagramss");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<Sysdiagrams> findAll(Pageable pageable) {
        LOGGER.debug("Finding all sysdiagramss");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Sysdiagrams findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding sysdiagrams by id: {}" , id);
        Sysdiagrams sysdiagrams=this.wmGenericDao.findById(id);
        if(sysdiagrams==null){
            LOGGER.debug("No sysdiagrams found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return sysdiagrams;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_Investments2TransactionManager")
    @Override
    public Sysdiagrams update(Sysdiagrams updated) throws EntityNotFoundException {
        LOGGER.debug("Updating sysdiagrams with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getDiagramId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


