/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.db123testing.service;

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

import com.test_20apr.db123testing.*;


/**
 * ServiceImpl object for domain model class Table3.
 * @see com.test_20apr.db123testing.Table3
 */
@Service("DB123Testing.Table3Service")
public class Table3ServiceImpl implements Table3Service {


    private static final Logger LOGGER = LoggerFactory.getLogger(Table3ServiceImpl.class);

    @Autowired
    @Qualifier("DB123Testing.Table3Dao")
    private WMGenericDao<Table3, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table3, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
     public Page<Table3> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "DB123TestingTransactionManager")
    @Override
    public Table3 create(Table3 table3) {
        LOGGER.debug("Creating a new table3 with information: {}" , table3);
        return this.wmGenericDao.create(table3);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "DB123TestingTransactionManager")
    @Override
    public Table3 delete(Integer table3Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting table3 with id: {}" , table3Id);
        Table3 deleted = this.wmGenericDao.findById(table3Id);
        if (deleted == null) {
            LOGGER.debug("No table3 found with id: {}" , table3Id);
            throw new EntityNotFoundException(String.valueOf(table3Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Page<Table3> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all table3s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Page<Table3> findAll(Pageable pageable) {
        LOGGER.debug("Finding all table3s");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Table3 findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding table3 by id: {}" , id);
        Table3 table3=this.wmGenericDao.findById(id);
        if(table3==null){
            LOGGER.debug("No table3 found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return table3;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "DB123TestingTransactionManager")
    @Override
    public Table3 update(Table3 updated) throws EntityNotFoundException {
        LOGGER.debug("Updating table3 with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


