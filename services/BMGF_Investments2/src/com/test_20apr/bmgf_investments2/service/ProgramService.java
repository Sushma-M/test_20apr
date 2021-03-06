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
 * Service object for domain model class Program.
 * @see com.test_20apr.bmgf_investments2.Program
 */

public interface ProgramService {
   /**
	 * Creates a new program.
	 * 
	 * @param created
	 *            The information of the created program.
	 * @return The created program.
	 */
	public Program create(Program created);

	/**
	 * Deletes a program.
	 * 
	 * @param programId
	 *            The id of the deleted program.
	 * @return The deleted program.
	 * @throws EntityNotFoundException
	 *             if no program is found with the given id.
	 */
	public Program delete(String programId) throws EntityNotFoundException;

	/**
	 * Finds all programs.
	 * 
	 * @return A list of programs.
	 */
	public Page<Program> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Program> findAll(Pageable pageable);
	
	/**
	 * Finds program by id.
	 * 
	 * @param id
	 *            The id of the wanted program.
	 * @return The found program. If no program is found, this method returns
	 *         null.
	 */
	public Program findById(String id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a program.
	 * 
	 * @param updated
	 *            The information of the updated program.
	 * @return The updated program.
	 * @throws EntityNotFoundException
	 *             if no program is found with given id.
	 */
	public Program update(Program updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the programs in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the program.
	 */

	public long countAll();


    public Page<Program> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

