/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/


package com.test_20apr.bmgf_investments2.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wavemaker.runtime.data.model.CustomProcedure;
import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;

@Service
public class BMGF_Investments2ProcedureExecutorServiceImpl implements BMGF_Investments2ProcedureExecutorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BMGF_Investments2ProcedureExecutorServiceImpl.class);

	@Autowired
	@Qualifier("BMGF_Investments2WMProcedureExecutor")
	private WMProcedureExecutor procedureExecutor;


	@Transactional(value = "BMGF_Investments2TransactionManager")
	@Override
	public List<Object> executeWMCustomProcedure(CustomProcedure procedure) {
	    return procedureExecutor.executeCustomProcedure(procedure);
	}


}

