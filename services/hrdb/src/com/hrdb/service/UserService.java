/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.hrdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.hrdb.*;

/**
 * Service object for domain model class User.
 * @see com.hrdb.User
 */

public interface UserService {
   /**
	 * Creates a new user.
	 * 
	 * @param created
	 *            The information of the created user.
	 * @return The created user.
	 */
	public User create(User created);

	/**
	 * Deletes a user.
	 * 
	 * @param userId
	 *            The id of the deleted user.
	 * @return The deleted user.
	 * @throws EntityNotFoundException
	 *             if no user is found with the given id.
	 */
	public User delete(Integer userId) throws EntityNotFoundException;

	/**
	 * Finds all users.
	 * 
	 * @return A list of users.
	 */
	public Page<User> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<User> findAll(Pageable pageable);
	
	/**
	 * Finds user by id.
	 * 
	 * @param id
	 *            The id of the wanted user.
	 * @return The found user. If no user is found, this method returns
	 *         null.
	 */
	public User findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a user.
	 * 
	 * @param updated
	 *            The information of the updated user.
	 * @return The updated user.
	 * @throws EntityNotFoundException
	 *             if no user is found with given id.
	 */
	public User update(User updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the users in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the user.
	 */

	public long countAll();


    public Page<User> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

