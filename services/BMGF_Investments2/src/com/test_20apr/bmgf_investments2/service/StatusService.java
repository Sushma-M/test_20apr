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
 * Service object for domain model class Status.
 * @see com.test_20apr.bmgf_investments2.Status
 */

public interface StatusService {
   /**
	 * Creates a new status.
	 * 
	 * @param created
	 *            The information of the created status.
	 * @return The created status.
	 */
	public Status create(Status created);

	/**
	 * Deletes a status.
	 * 
	 * @param statusId
	 *            The id of the deleted status.
	 * @return The deleted status.
	 * @throws EntityNotFoundException
	 *             if no status is found with the given id.
	 */
	public Status delete(String statusId) throws EntityNotFoundException;

	/**
	 * Finds all statuss.
	 * 
	 * @return A list of statuss.
	 */
	public Page<Status> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Status> findAll(Pageable pageable);
	
	/**
	 * Finds status by id.
	 * 
	 * @param id
	 *            The id of the wanted status.
	 * @return The found status. If no status is found, this method returns
	 *         null.
	 */
	public Status findById(String id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a status.
	 * 
	 * @param updated
	 *            The information of the updated status.
	 * @return The updated status.
	 * @throws EntityNotFoundException
	 *             if no status is found with given id.
	 */
	public Status update(Status updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the statuss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the status.
	 */

	public long countAll();


    public Page<Status> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

