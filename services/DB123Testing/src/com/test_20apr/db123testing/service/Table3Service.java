/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.db123testing.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.test_20apr.db123testing.*;

/**
 * Service object for domain model class Table3.
 * @see com.test_20apr.db123testing.Table3
 */

public interface Table3Service {
   /**
	 * Creates a new table3.
	 * 
	 * @param created
	 *            The information of the created table3.
	 * @return The created table3.
	 */
	public Table3 create(Table3 created);

	/**
	 * Deletes a table3.
	 * 
	 * @param table3Id
	 *            The id of the deleted table3.
	 * @return The deleted table3.
	 * @throws EntityNotFoundException
	 *             if no table3 is found with the given id.
	 */
	public Table3 delete(Integer table3Id) throws EntityNotFoundException;

	/**
	 * Finds all table3s.
	 * 
	 * @return A list of table3s.
	 */
	public Page<Table3> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Table3> findAll(Pageable pageable);
	
	/**
	 * Finds table3 by id.
	 * 
	 * @param id
	 *            The id of the wanted table3.
	 * @return The found table3. If no table3 is found, this method returns
	 *         null.
	 */
	public Table3 findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a table3.
	 * 
	 * @param updated
	 *            The information of the updated table3.
	 * @return The updated table3.
	 * @throws EntityNotFoundException
	 *             if no table3 is found with given id.
	 */
	public Table3 update(Table3 updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the table3s in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the table3.
	 */

	public long countAll();


    public Page<Table3> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

