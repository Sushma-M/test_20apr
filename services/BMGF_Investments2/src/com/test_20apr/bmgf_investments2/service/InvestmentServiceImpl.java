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
 * ServiceImpl object for domain model class Investment.
 * @see com.test_20apr.bmgf_investments2.Investment
 */
@Service("BMGF_Investments2.InvestmentService")
public class InvestmentServiceImpl implements InvestmentService {


    private static final Logger LOGGER = LoggerFactory.getLogger(InvestmentServiceImpl.class);

    @Autowired
    @Qualifier("BMGF_Investments2.InvestmentDao")
    private WMGenericDao<Investment, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Investment, String> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
     public Page<Investment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "BMGF_Investments2TransactionManager")
    @Override
    public Investment create(Investment investment) {
        LOGGER.debug("Creating a new investment with information: {}" , investment);
        return this.wmGenericDao.create(investment);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_Investments2TransactionManager")
    @Override
    public Investment delete(String investmentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting investment with id: {}" , investmentId);
        Investment deleted = this.wmGenericDao.findById(investmentId);
        if (deleted == null) {
            LOGGER.debug("No investment found with id: {}" , investmentId);
            throw new EntityNotFoundException(String.valueOf(investmentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<Investment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all investments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<Investment> findAll(Pageable pageable) {
        LOGGER.debug("Finding all investments");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Investment findById(String id) throws EntityNotFoundException {
        LOGGER.debug("Finding investment by id: {}" , id);
        Investment investment=this.wmGenericDao.findById(id);
        if(investment==null){
            LOGGER.debug("No investment found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return investment;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_Investments2TransactionManager")
    @Override
    public Investment update(Investment updated) throws EntityNotFoundException {
        LOGGER.debug("Updating investment with information: {}" , updated);
        this.wmGenericDao.update(updated);

        String id = (String)updated.getInvestmentId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


