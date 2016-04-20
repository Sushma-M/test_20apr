/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.test_20apr.bmgf_investments.*;

/**
 * Service object for domain model class Investment.
 * @see com.test_20apr.bmgf_investments.Investment
 */

public interface InvestmentService {
   /**
	 * Creates a new investment.
	 * 
	 * @param created
	 *            The information of the created investment.
	 * @return The created investment.
	 */
	public Investment create(Investment created);

	/**
	 * Deletes a investment.
	 * 
	 * @param investmentId
	 *            The id of the deleted investment.
	 * @return The deleted investment.
	 * @throws EntityNotFoundException
	 *             if no investment is found with the given id.
	 */
	public Investment delete(String investmentId) throws EntityNotFoundException;

	/**
	 * Finds all investments.
	 * 
	 * @return A list of investments.
	 */
	public Page<Investment> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Investment> findAll(Pageable pageable);
	
	/**
	 * Finds investment by id.
	 * 
	 * @param id
	 *            The id of the wanted investment.
	 * @return The found investment. If no investment is found, this method returns
	 *         null.
	 */
	public Investment findById(String id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a investment.
	 * 
	 * @param updated
	 *            The information of the updated investment.
	 * @return The updated investment.
	 * @throws EntityNotFoundException
	 *             if no investment is found with given id.
	 */
	public Investment update(Investment updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the investments in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the investment.
	 */

	public long countAll();


    public Page<Investment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
