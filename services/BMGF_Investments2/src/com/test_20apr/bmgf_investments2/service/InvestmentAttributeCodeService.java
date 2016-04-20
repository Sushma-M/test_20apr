/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments2.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.test_20apr.bmgf_investments2.*;

/**
 * Service object for domain model class InvestmentAttributeCode.
 * @see com.test_20apr.bmgf_investments2.InvestmentAttributeCode
 */

public interface InvestmentAttributeCodeService {
   /**
	 * Creates a new investmentattributecode.
	 * 
	 * @param created
	 *            The information of the created investmentattributecode.
	 * @return The created investmentattributecode.
	 */
	public InvestmentAttributeCode create(InvestmentAttributeCode created);

	/**
	 * Deletes a investmentattributecode.
	 * 
	 * @param investmentattributecodeId
	 *            The id of the deleted investmentattributecode.
	 * @return The deleted investmentattributecode.
	 * @throws EntityNotFoundException
	 *             if no investmentattributecode is found with the given id.
	 */
	public InvestmentAttributeCode delete(String investmentattributecodeId) throws EntityNotFoundException;

	/**
	 * Finds all investmentattributecodes.
	 * 
	 * @return A list of investmentattributecodes.
	 */
	public Page<InvestmentAttributeCode> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<InvestmentAttributeCode> findAll(Pageable pageable);
	
	/**
	 * Finds investmentattributecode by id.
	 * 
	 * @param id
	 *            The id of the wanted investmentattributecode.
	 * @return The found investmentattributecode. If no investmentattributecode is found, this method returns
	 *         null.
	 */
	public InvestmentAttributeCode findById(String id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a investmentattributecode.
	 * 
	 * @param updated
	 *            The information of the updated investmentattributecode.
	 * @return The updated investmentattributecode.
	 * @throws EntityNotFoundException
	 *             if no investmentattributecode is found with given id.
	 */
	public InvestmentAttributeCode update(InvestmentAttributeCode updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the investmentattributecodes in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the investmentattributecode.
	 */

	public long countAll();


    public Page<InvestmentAttributeCode> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

