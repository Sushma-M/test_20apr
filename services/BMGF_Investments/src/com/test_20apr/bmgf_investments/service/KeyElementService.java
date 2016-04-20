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
 * Service object for domain model class KeyElement.
 * @see com.test_20apr.bmgf_investments.KeyElement
 */

public interface KeyElementService {
   /**
	 * Creates a new keyelement.
	 * 
	 * @param created
	 *            The information of the created keyelement.
	 * @return The created keyelement.
	 */
	public KeyElement create(KeyElement created);

	/**
	 * Deletes a keyelement.
	 * 
	 * @param keyelementId
	 *            The id of the deleted keyelement.
	 * @return The deleted keyelement.
	 * @throws EntityNotFoundException
	 *             if no keyelement is found with the given id.
	 */
	public KeyElement delete(String keyelementId) throws EntityNotFoundException;

	/**
	 * Finds all keyelements.
	 * 
	 * @return A list of keyelements.
	 */
	public Page<KeyElement> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<KeyElement> findAll(Pageable pageable);
	
	/**
	 * Finds keyelement by id.
	 * 
	 * @param id
	 *            The id of the wanted keyelement.
	 * @return The found keyelement. If no keyelement is found, this method returns
	 *         null.
	 */
	public KeyElement findById(String id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a keyelement.
	 * 
	 * @param updated
	 *            The information of the updated keyelement.
	 * @return The updated keyelement.
	 * @throws EntityNotFoundException
	 *             if no keyelement is found with given id.
	 */
	public KeyElement update(KeyElement updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the keyelements in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the keyelement.
	 */

	public long countAll();


    public Page<KeyElement> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
