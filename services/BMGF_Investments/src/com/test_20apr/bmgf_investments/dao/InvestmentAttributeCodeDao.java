/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.test_20apr.bmgf_investments.*;
/**
* Specifies methods used to obtain and modify InvestmentAttributeCode related information
* which is stored in the database.
*/
@Repository("BMGF_Investments.InvestmentAttributeCodeDao")
public class InvestmentAttributeCodeDao extends WMGenericDaoImpl <InvestmentAttributeCode, String> {

    @Autowired
    @Qualifier("BMGF_InvestmentsTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

