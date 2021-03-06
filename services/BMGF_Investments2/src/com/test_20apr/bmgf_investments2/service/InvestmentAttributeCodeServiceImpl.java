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
 * ServiceImpl object for domain model class InvestmentAttributeCode.
 * @see com.test_20apr.bmgf_investments2.InvestmentAttributeCode
 */
@Service("BMGF_Investments2.InvestmentAttributeCodeService")
public class InvestmentAttributeCodeServiceImpl implements InvestmentAttributeCodeService {


    private static final Logger LOGGER = LoggerFactory.getLogger(InvestmentAttributeCodeServiceImpl.class);

    @Autowired
    @Qualifier("BMGF_Investments2.InvestmentAttributeCodeDao")
    private WMGenericDao<InvestmentAttributeCode, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<InvestmentAttributeCode, String> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
     public Page<InvestmentAttributeCode> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "BMGF_Investments2TransactionManager")
    @Override
    public InvestmentAttributeCode create(InvestmentAttributeCode investmentattributecode) {
        LOGGER.debug("Creating a new investmentattributecode with information: {}" , investmentattributecode);
        return this.wmGenericDao.create(investmentattributecode);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_Investments2TransactionManager")
    @Override
    public InvestmentAttributeCode delete(String investmentattributecodeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting investmentattributecode with id: {}" , investmentattributecodeId);
        InvestmentAttributeCode deleted = this.wmGenericDao.findById(investmentattributecodeId);
        if (deleted == null) {
            LOGGER.debug("No investmentattributecode found with id: {}" , investmentattributecodeId);
            throw new EntityNotFoundException(String.valueOf(investmentattributecodeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<InvestmentAttributeCode> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all investmentattributecodes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<InvestmentAttributeCode> findAll(Pageable pageable) {
        LOGGER.debug("Finding all investmentattributecodes");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public InvestmentAttributeCode findById(String id) throws EntityNotFoundException {
        LOGGER.debug("Finding investmentattributecode by id: {}" , id);
        InvestmentAttributeCode investmentattributecode=this.wmGenericDao.findById(id);
        if(investmentattributecode==null){
            LOGGER.debug("No investmentattributecode found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return investmentattributecode;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_Investments2TransactionManager")
    @Override
    public InvestmentAttributeCode update(InvestmentAttributeCode updated) throws EntityNotFoundException {
        LOGGER.debug("Updating investmentattributecode with information: {}" , updated);
        this.wmGenericDao.update(updated);

        String id = (String)updated.getInvestmentAttributeCodeId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


