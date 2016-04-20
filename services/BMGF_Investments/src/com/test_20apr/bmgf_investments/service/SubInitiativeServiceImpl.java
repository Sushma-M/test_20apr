/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments.service;

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

import com.test_20apr.bmgf_investments.*;


/**
 * ServiceImpl object for domain model class SubInitiative.
 * @see com.test_20apr.bmgf_investments.SubInitiative
 */
@Service("BMGF_Investments.SubInitiativeService")
public class SubInitiativeServiceImpl implements SubInitiativeService {


    private static final Logger LOGGER = LoggerFactory.getLogger(SubInitiativeServiceImpl.class);

    @Autowired
    @Qualifier("BMGF_Investments.SubInitiativeDao")
    private WMGenericDao<SubInitiative, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SubInitiative, String> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "BMGF_InvestmentsTransactionManager")
     public Page<SubInitiative> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "BMGF_InvestmentsTransactionManager")
    @Override
    public SubInitiative create(SubInitiative subinitiative) {
        LOGGER.debug("Creating a new subinitiative with information: {}" , subinitiative);
        return this.wmGenericDao.create(subinitiative);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_InvestmentsTransactionManager")
    @Override
    public SubInitiative delete(String subinitiativeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting subinitiative with id: {}" , subinitiativeId);
        SubInitiative deleted = this.wmGenericDao.findById(subinitiativeId);
        if (deleted == null) {
            LOGGER.debug("No subinitiative found with id: {}" , subinitiativeId);
            throw new EntityNotFoundException(String.valueOf(subinitiativeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "BMGF_InvestmentsTransactionManager")
    @Override
    public Page<SubInitiative> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all subinitiatives");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "BMGF_InvestmentsTransactionManager")
    @Override
    public Page<SubInitiative> findAll(Pageable pageable) {
        LOGGER.debug("Finding all subinitiatives");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "BMGF_InvestmentsTransactionManager")
    @Override
    public SubInitiative findById(String id) throws EntityNotFoundException {
        LOGGER.debug("Finding subinitiative by id: {}" , id);
        SubInitiative subinitiative=this.wmGenericDao.findById(id);
        if(subinitiative==null){
            LOGGER.debug("No subinitiative found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return subinitiative;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "BMGF_InvestmentsTransactionManager")
    @Override
    public SubInitiative update(SubInitiative updated) throws EntityNotFoundException {
        LOGGER.debug("Updating subinitiative with information: {}" , updated);
        this.wmGenericDao.update(updated);

        String id = (String)updated.getSubInitiativeId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "BMGF_InvestmentsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


