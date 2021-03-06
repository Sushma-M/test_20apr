/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.dbtest123.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.test_20apr.dbtest123.*;

/**
 * Service object for domain model class Types.
 * @see com.test_20apr.dbtest123.Types
 */

public interface TypesService {
   /**
	 * Creates a new types.
	 * 
	 * @param created
	 *            The information of the created types.
	 * @return The created types.
	 */
	public Types create(Types created);

	/**
	 * Deletes a types.
	 * 
	 * @param typesId
	 *            The id of the deleted types.
	 * @return The deleted types.
	 * @throws EntityNotFoundException
	 *             if no types is found with the given id.
	 */
	public Types delete(Integer typesId) throws EntityNotFoundException;

	/**
	 * Finds all typess.
	 * 
	 * @return A list of typess.
	 */
	public Page<Types> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Types> findAll(Pageable pageable);
	
	/**
	 * Finds types by id.
	 * 
	 * @param id
	 *            The id of the wanted types.
	 * @return The found types. If no types is found, this method returns
	 *         null.
	 */
	public Types findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a types.
	 * 
	 * @param updated
	 *            The information of the updated types.
	 * @return The updated types.
	 * @throws EntityNotFoundException
	 *             if no types is found with given id.
	 */
	public Types update(Types updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the typess in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the types.
	 */

	public long countAll();


    public Page<Types> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

