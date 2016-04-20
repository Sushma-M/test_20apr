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
 * ServiceImpl object for domain model class AttributeCategory.
 * @see com.test_20apr.bmgf_investments2.AttributeCategory
 */
@Service("BMGF_Investments2.AttributeCategoryService")
public class AttributeCategoryServiceImpl implements AttributeCategoryService {


    private static final Logger LOGGER = LoggerFactory.getLogger(AttributeCategoryServiceImpl.class);

    @Autowired
    @Qualifier("BMGF_Investments2.AttributeCategoryDao")
    private WMGenericDao<AttributeCategory, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<AttributeCategory, String> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
     public Page<AttributeCategory> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "BMGF_Investments2TransactionManager")
    @Override
    public AttributeCategory create(AttributeCategory attributecategory) {
        LOGGER.debug("Creating a new attributecategory with information: {}" , attributecategory);
        return this.wmGenericDao.create(attributecategory);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_Investments2TransactionManager")
    @Override
    public AttributeCategory delete(String attributecategoryId) throws EntityNotFoundException {
        LOGGER.debug("Deleting attributecategory with id: {}" , attributecategoryId);
        AttributeCategory deleted = this.wmGenericDao.findById(attributecategoryId);
        if (deleted == null) {
            LOGGER.debug("No attributecategory found with id: {}" , attributecategoryId);
            throw new EntityNotFoundException(String.valueOf(attributecategoryId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<AttributeCategory> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all attributecategorys");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<AttributeCategory> findAll(Pageable pageable) {
        LOGGER.debug("Finding all attributecategorys");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public AttributeCategory findById(String id) throws EntityNotFoundException {
        LOGGER.debug("Finding attributecategory by id: {}" , id);
        AttributeCategory attributecategory=this.wmGenericDao.findById(id);
        if(attributecategory==null){
            LOGGER.debug("No attributecategory found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return attributecategory;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_Investments2TransactionManager")
    @Override
    public AttributeCategory update(AttributeCategory updated) throws EntityNotFoundException {
        LOGGER.debug("Updating attributecategory with information: {}" , updated);
        this.wmGenericDao.update(updated);

        String id = (String)updated.getAttributeCategoryId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

