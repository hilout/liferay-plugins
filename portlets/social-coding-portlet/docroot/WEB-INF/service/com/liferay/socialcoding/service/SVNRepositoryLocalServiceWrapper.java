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

package com.liferay.socialcoding.service;

/**
 * <p>
 * This class is a wrapper for {@link SVNRepositoryLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SVNRepositoryLocalService
 * @generated
 */
public class SVNRepositoryLocalServiceWrapper
	implements SVNRepositoryLocalService {
	public SVNRepositoryLocalServiceWrapper(
		SVNRepositoryLocalService svnRepositoryLocalService) {
		_svnRepositoryLocalService = svnRepositoryLocalService;
	}

	/**
	* Adds the s v n repository to the database. Also notifies the appropriate model listeners.
	*
	* @param svnRepository the s v n repository to add
	* @return the s v n repository that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.socialcoding.model.SVNRepository addSVNRepository(
		com.liferay.socialcoding.model.SVNRepository svnRepository)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _svnRepositoryLocalService.addSVNRepository(svnRepository);
	}

	/**
	* Creates a new s v n repository with the primary key. Does not add the s v n repository to the database.
	*
	* @param svnRepositoryId the primary key for the new s v n repository
	* @return the new s v n repository
	*/
	public com.liferay.socialcoding.model.SVNRepository createSVNRepository(
		long svnRepositoryId) {
		return _svnRepositoryLocalService.createSVNRepository(svnRepositoryId);
	}

	/**
	* Deletes the s v n repository with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param svnRepositoryId the primary key of the s v n repository to delete
	* @throws PortalException if a s v n repository with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSVNRepository(long svnRepositoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_svnRepositoryLocalService.deleteSVNRepository(svnRepositoryId);
	}

	/**
	* Deletes the s v n repository from the database. Also notifies the appropriate model listeners.
	*
	* @param svnRepository the s v n repository to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSVNRepository(
		com.liferay.socialcoding.model.SVNRepository svnRepository)
		throws com.liferay.portal.kernel.exception.SystemException {
		_svnRepositoryLocalService.deleteSVNRepository(svnRepository);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("unchecked")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _svnRepositoryLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _svnRepositoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _svnRepositoryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _svnRepositoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the s v n repository with the primary key.
	*
	* @param svnRepositoryId the primary key of the s v n repository to get
	* @return the s v n repository
	* @throws PortalException if a s v n repository with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.socialcoding.model.SVNRepository getSVNRepository(
		long svnRepositoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _svnRepositoryLocalService.getSVNRepository(svnRepositoryId);
	}

	/**
	* Gets a range of all the s v n repositories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s v n repositories to return
	* @param end the upper bound of the range of s v n repositories to return (not inclusive)
	* @return the range of s v n repositories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.socialcoding.model.SVNRepository> getSVNRepositories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _svnRepositoryLocalService.getSVNRepositories(start, end);
	}

	/**
	* Gets the number of s v n repositories.
	*
	* @return the number of s v n repositories
	* @throws SystemException if a system exception occurred
	*/
	public int getSVNRepositoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _svnRepositoryLocalService.getSVNRepositoriesCount();
	}

	/**
	* Updates the s v n repository in the database. Also notifies the appropriate model listeners.
	*
	* @param svnRepository the s v n repository to update
	* @return the s v n repository that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.socialcoding.model.SVNRepository updateSVNRepository(
		com.liferay.socialcoding.model.SVNRepository svnRepository)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _svnRepositoryLocalService.updateSVNRepository(svnRepository);
	}

	/**
	* Updates the s v n repository in the database. Also notifies the appropriate model listeners.
	*
	* @param svnRepository the s v n repository to update
	* @param merge whether to merge the s v n repository with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the s v n repository that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.socialcoding.model.SVNRepository updateSVNRepository(
		com.liferay.socialcoding.model.SVNRepository svnRepository,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _svnRepositoryLocalService.updateSVNRepository(svnRepository,
			merge);
	}

	public com.liferay.socialcoding.model.SVNRepository getSVNRepository(
		java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _svnRepositoryLocalService.getSVNRepository(url);
	}

	public void updateSVNRepository(java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_svnRepositoryLocalService.updateSVNRepository(url);
	}

	public SVNRepositoryLocalService getWrappedSVNRepositoryLocalService() {
		return _svnRepositoryLocalService;
	}

	private SVNRepositoryLocalService _svnRepositoryLocalService;
}