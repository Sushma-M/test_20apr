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
 * ServiceImpl object for domain model class VwInvestment.
 * @see com.test_20apr.bmgf_investments2.VwInvestment
 */
@Service("BMGF_Investments2.VwInvestmentService")
public class VwInvestmentServiceImpl implements VwInvestmentService {


    private static final Logger LOGGER = LoggerFactory.getLogger(VwInvestmentServiceImpl.class);

    @Autowired
    @Qualifier("BMGF_Investments2.VwInvestmentDao")
    private WMGenericDao<VwInvestment, VwInvestmentId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<VwInvestment, VwInvestmentId> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
     public Page<VwInvestment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }


    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<VwInvestment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all vwinvestments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public Page<VwInvestment> findAll(Pageable pageable) {
        LOGGER.debug("Finding all vwinvestments");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public VwInvestment findById(VwInvestmentId id) throws EntityNotFoundException {
        LOGGER.debug("Finding vwinvestment by id: {}" , id);
        VwInvestment vwinvestment=this.wmGenericDao.findById(id);
        if(vwinvestment==null){
            LOGGER.debug("No vwinvestment found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return vwinvestment;
    }

    @Transactional(readOnly = true, value = "BMGF_Investments2TransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


