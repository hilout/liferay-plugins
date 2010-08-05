/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.chat.service.base;

import com.liferay.chat.model.Status;
import com.liferay.chat.service.EntryLocalService;
import com.liferay.chat.service.StatusLocalService;
import com.liferay.chat.service.persistence.EntryFinder;
import com.liferay.chat.service.persistence.EntryPersistence;
import com.liferay.chat.service.persistence.StatusFinder;
import com.liferay.chat.service.persistence.StatusPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the status local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.chat.service.impl.StatusLocalServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link com.liferay.chat.service.StatusLocalServiceUtil} to access the status local service.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.chat.service.impl.StatusLocalServiceImpl
 * @see com.liferay.chat.service.StatusLocalServiceUtil
 * @generated
 */
public abstract class StatusLocalServiceBaseImpl implements StatusLocalService {
	/**
	 * Adds the status to the database. Also notifies the appropriate model listeners.
	 *
	 * @param status the status to add
	 * @return the status that was added
	 * @throws SystemException if a system exception occurred
	 */
	public Status addStatus(Status status) throws SystemException {
		status.setNew(true);

		return statusPersistence.update(status, false);
	}

	/**
	 * Creates a new status with the primary key. Does not add the status to the database.
	 *
	 * @param statusId the primary key for the new status
	 * @return the new status
	 */
	public Status createStatus(long statusId) {
		return statusPersistence.create(statusId);
	}

	/**
	 * Deletes the status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statusId the primary key of the status to delete
	 * @throws PortalException if a status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteStatus(long statusId)
		throws PortalException, SystemException {
		statusPersistence.remove(statusId);
	}

	/**
	 * Deletes the status from the database. Also notifies the appropriate model listeners.
	 *
	 * @param status the status to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteStatus(Status status) throws SystemException {
		statusPersistence.remove(status);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("unchecked")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return statusPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("unchecked")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return statusPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("unchecked")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return statusPersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return statusPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the status with the primary key.
	 *
	 * @param statusId the primary key of the status to get
	 * @return the status
	 * @throws PortalException if a status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Status getStatus(long statusId)
		throws PortalException, SystemException {
		return statusPersistence.findByPrimaryKey(statusId);
	}

	/**
	 * Gets a range of all the statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of statuses to return
	 * @param end the upper bound of the range of statuses to return (not inclusive)
	 * @return the range of statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Status> getStatuses(int start, int end)
		throws SystemException {
		return statusPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of statuses.
	 *
	 * @return the number of statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int getStatusesCount() throws SystemException {
		return statusPersistence.countAll();
	}

	/**
	 * Updates the status in the database. Also notifies the appropriate model listeners.
	 *
	 * @param status the status to update
	 * @return the status that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Status updateStatus(Status status) throws SystemException {
		status.setNew(false);

		return statusPersistence.update(status, true);
	}

	/**
	 * Updates the status in the database. Also notifies the appropriate model listeners.
	 *
	 * @param status the status to update
	 * @param merge whether to merge the status with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the status that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Status updateStatus(Status status, boolean merge)
		throws SystemException {
		status.setNew(false);

		return statusPersistence.update(status, merge);
	}

	/**
	 * Gets the entry local service.
	 *
	 * @return the entry local service
	 */
	public EntryLocalService getEntryLocalService() {
		return entryLocalService;
	}

	/**
	 * Sets the entry local service.
	 *
	 * @param entryLocalService the entry local service
	 */
	public void setEntryLocalService(EntryLocalService entryLocalService) {
		this.entryLocalService = entryLocalService;
	}

	/**
	 * Gets the entry persistence.
	 *
	 * @return the entry persistence
	 */
	public EntryPersistence getEntryPersistence() {
		return entryPersistence;
	}

	/**
	 * Sets the entry persistence.
	 *
	 * @param entryPersistence the entry persistence
	 */
	public void setEntryPersistence(EntryPersistence entryPersistence) {
		this.entryPersistence = entryPersistence;
	}

	/**
	 * Gets the entry finder.
	 *
	 * @return the entry finder
	 */
	public EntryFinder getEntryFinder() {
		return entryFinder;
	}

	/**
	 * Sets the entry finder.
	 *
	 * @param entryFinder the entry finder
	 */
	public void setEntryFinder(EntryFinder entryFinder) {
		this.entryFinder = entryFinder;
	}

	/**
	 * Gets the status local service.
	 *
	 * @return the status local service
	 */
	public StatusLocalService getStatusLocalService() {
		return statusLocalService;
	}

	/**
	 * Sets the status local service.
	 *
	 * @param statusLocalService the status local service
	 */
	public void setStatusLocalService(StatusLocalService statusLocalService) {
		this.statusLocalService = statusLocalService;
	}

	/**
	 * Gets the status persistence.
	 *
	 * @return the status persistence
	 */
	public StatusPersistence getStatusPersistence() {
		return statusPersistence;
	}

	/**
	 * Sets the status persistence.
	 *
	 * @param statusPersistence the status persistence
	 */
	public void setStatusPersistence(StatusPersistence statusPersistence) {
		this.statusPersistence = statusPersistence;
	}

	/**
	 * Gets the status finder.
	 *
	 * @return the status finder
	 */
	public StatusFinder getStatusFinder() {
		return statusFinder;
	}

	/**
	 * Sets the status finder.
	 *
	 * @param statusFinder the status finder
	 */
	public void setStatusFinder(StatusFinder statusFinder) {
		this.statusFinder = statusFinder;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = statusPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = EntryLocalService.class)
	protected EntryLocalService entryLocalService;
	@BeanReference(type = EntryPersistence.class)
	protected EntryPersistence entryPersistence;
	@BeanReference(type = EntryFinder.class)
	protected EntryFinder entryFinder;
	@BeanReference(type = StatusLocalService.class)
	protected StatusLocalService statusLocalService;
	@BeanReference(type = StatusPersistence.class)
	protected StatusPersistence statusPersistence;
	@BeanReference(type = StatusFinder.class)
	protected StatusFinder statusFinder;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}