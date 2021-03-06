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
 * ServiceImpl object for domain model class AttributeCategoryCode.
 * @see com.test_20apr.bmgf_investments2.AttributeCategoryCode
 */
@Service("BMGF_Investments2.AttributeCategoryCodeService")
public class AttributeCategoryCodeServiceImpl implements AttributeCategoryCodeService {


    private static final Logger LOGGER = LoggerFactory.getLogger(AttributeCategoryCodeServiceImpl.class);

    @Autowired
    @Qualifier("BMGF_Investments2.AttributeCategoryCodeDao")
    private WMGenericDao<AttributeCategoryCode, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<AttributeCategoryCode, String> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
     public Page<AttributeCategoryCode> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "BMGF_Investments2TransactionManager")
    @Override
    public AttributeCategoryCode create(AttributeCategoryCode attributecategorycode) {
        LOGGER.debug("Creating a new attributecategorycode with information: {}" , attributecategorycode);
        return this.wmGenericDao.create(attributecategorycode);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_Investments2TransactionManager")
    @Override
    public AttributeCategoryCode delete(String attributecategorycodeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting attributecategorycode with id: {}" , attributecategorycodeId);
        AttributeCategoryCode deleted = this.wmGenericDao.findById(attributecategorycodeId);
        if (deleted == null) {
            LOGGER.debug("No attributecategorycode found with id: {}" , attributecategorycodeId);
            throw new EntityNotFoundException(String.valueOf(attributecategorycodeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<AttributeCategoryCode> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all attributecategorycodes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<AttributeCategoryCode> findAll(Pageable pageable) {
        LOGGER.debug("Finding all attributecategorycodes");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public AttributeCategoryCode findById(String id) throws EntityNotFoundException {
        LOGGER.debug("Finding attributecategorycode by id: {}" , id);
        AttributeCategoryCode attributecategorycode=this.wmGenericDao.findById(id);
        if(attributecategorycode==null){
            LOGGER.debug("No attributecategorycode found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return attributecategorycode;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_Investments2TransactionManager")
    @Override
    public AttributeCategoryCode update(AttributeCategoryCode updated) throws EntityNotFoundException {
        LOGGER.debug("Updating attributecategorycode with information: {}" , updated);
        this.wmGenericDao.update(updated);

        String id = (String)updated.getAttributeCategoryCodeId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


