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

package com.liferay.knowledgebase.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.knowledgebase.model.Template;
import com.liferay.knowledgebase.service.ArticleLocalService;
import com.liferay.knowledgebase.service.ArticleService;
import com.liferay.knowledgebase.service.TemplateLocalService;
import com.liferay.knowledgebase.service.TemplateService;
import com.liferay.knowledgebase.service.persistence.ArticlePersistence;
import com.liferay.knowledgebase.service.persistence.TemplatePersistence;

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

import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageService;
import com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence;
import com.liferay.portlet.social.service.SocialActivityLocalService;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the template local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.knowledgebase.service.impl.TemplateLocalServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link com.liferay.knowledgebase.service.TemplateLocalServiceUtil} to access the template local service.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.knowledgebase.service.impl.TemplateLocalServiceImpl
 * @see com.liferay.knowledgebase.service.TemplateLocalServiceUtil
 * @generated
 */
public abstract class TemplateLocalServiceBaseImpl
	implements TemplateLocalService {
	/**
	 * Adds the template to the database. Also notifies the appropriate model listeners.
	 *
	 * @param template the template to add
	 * @return the template that was added
	 * @throws SystemException if a system exception occurred
	 */
	public Template addTemplate(Template template) throws SystemException {
		template.setNew(true);

		return templatePersistence.update(template, false);
	}

	/**
	 * Creates a new template with the primary key. Does not add the template to the database.
	 *
	 * @param templateId the primary key for the new template
	 * @return the new template
	 */
	public Template createTemplate(long templateId) {
		return templatePersistence.create(templateId);
	}

	/**
	 * Deletes the template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateId the primary key of the template to delete
	 * @throws PortalException if a template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteTemplate(long templateId)
		throws PortalException, SystemException {
		templatePersistence.remove(templateId);
	}

	/**
	 * Deletes the template from the database. Also notifies the appropriate model listeners.
	 *
	 * @param template the template to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteTemplate(Template template)
		throws PortalException, SystemException {
		templatePersistence.remove(template);
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
		return templatePersistence.findWithDynamicQuery(dynamicQuery);
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
		return templatePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
		return templatePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return templatePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the template with the primary key.
	 *
	 * @param templateId the primary key of the template to get
	 * @return the template
	 * @throws PortalException if a template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Template getTemplate(long templateId)
		throws PortalException, SystemException {
		return templatePersistence.findByPrimaryKey(templateId);
	}

	/**
	 * Gets the template with the UUID and group id.
	 *
	 * @param uuid the UUID of template to get
	 * @param groupId the group id of the template to get
	 * @return the template
	 * @throws PortalException if a template with the UUID and group id could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Template getTemplateByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return templatePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Gets a range of all the templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of templates to return
	 * @param end the upper bound of the range of templates to return (not inclusive)
	 * @return the range of templates
	 * @throws SystemException if a system exception occurred
	 */
	public List<Template> getTemplates(int start, int end)
		throws SystemException {
		return templatePersistence.findAll(start, end);
	}

	/**
	 * Gets the number of templates.
	 *
	 * @return the number of templates
	 * @throws SystemException if a system exception occurred
	 */
	public int getTemplatesCount() throws SystemException {
		return templatePersistence.countAll();
	}

	/**
	 * Updates the template in the database. Also notifies the appropriate model listeners.
	 *
	 * @param template the template to update
	 * @return the template that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Template updateTemplate(Template template) throws SystemException {
		template.setNew(false);

		return templatePersistence.update(template, true);
	}

	/**
	 * Updates the template in the database. Also notifies the appropriate model listeners.
	 *
	 * @param template the template to update
	 * @param merge whether to merge the template with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the template that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Template updateTemplate(Template template, boolean merge)
		throws SystemException {
		template.setNew(false);

		return templatePersistence.update(template, merge);
	}

	/**
	 * Gets the article local service.
	 *
	 * @return the article local service
	 */
	public ArticleLocalService getArticleLocalService() {
		return articleLocalService;
	}

	/**
	 * Sets the article local service.
	 *
	 * @param articleLocalService the article local service
	 */
	public void setArticleLocalService(ArticleLocalService articleLocalService) {
		this.articleLocalService = articleLocalService;
	}

	/**
	 * Gets the article remote service.
	 *
	 * @return the article remote service
	 */
	public ArticleService getArticleService() {
		return articleService;
	}

	/**
	 * Sets the article remote service.
	 *
	 * @param articleService the article remote service
	 */
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	/**
	 * Gets the article persistence.
	 *
	 * @return the article persistence
	 */
	public ArticlePersistence getArticlePersistence() {
		return articlePersistence;
	}

	/**
	 * Sets the article persistence.
	 *
	 * @param articlePersistence the article persistence
	 */
	public void setArticlePersistence(ArticlePersistence articlePersistence) {
		this.articlePersistence = articlePersistence;
	}

	/**
	 * Gets the template local service.
	 *
	 * @return the template local service
	 */
	public TemplateLocalService getTemplateLocalService() {
		return templateLocalService;
	}

	/**
	 * Sets the template local service.
	 *
	 * @param templateLocalService the template local service
	 */
	public void setTemplateLocalService(
		TemplateLocalService templateLocalService) {
		this.templateLocalService = templateLocalService;
	}

	/**
	 * Gets the template remote service.
	 *
	 * @return the template remote service
	 */
	public TemplateService getTemplateService() {
		return templateService;
	}

	/**
	 * Sets the template remote service.
	 *
	 * @param templateService the template remote service
	 */
	public void setTemplateService(TemplateService templateService) {
		this.templateService = templateService;
	}

	/**
	 * Gets the template persistence.
	 *
	 * @return the template persistence
	 */
	public TemplatePersistence getTemplatePersistence() {
		return templatePersistence;
	}

	/**
	 * Sets the template persistence.
	 *
	 * @param templatePersistence the template persistence
	 */
	public void setTemplatePersistence(TemplatePersistence templatePersistence) {
		this.templatePersistence = templatePersistence;
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
	 * Gets the message-boards message local service.
	 *
	 * @return the message-boards message local service
	 */
	public MBMessageLocalService getMBMessageLocalService() {
		return mbMessageLocalService;
	}

	/**
	 * Sets the message-boards message local service.
	 *
	 * @param mbMessageLocalService the message-boards message local service
	 */
	public void setMBMessageLocalService(
		MBMessageLocalService mbMessageLocalService) {
		this.mbMessageLocalService = mbMessageLocalService;
	}

	/**
	 * Gets the message-boards message remote service.
	 *
	 * @return the message-boards message remote service
	 */
	public MBMessageService getMBMessageService() {
		return mbMessageService;
	}

	/**
	 * Sets the message-boards message remote service.
	 *
	 * @param mbMessageService the message-boards message remote service
	 */
	public void setMBMessageService(MBMessageService mbMessageService) {
		this.mbMessageService = mbMessageService;
	}

	/**
	 * Gets the message-boards message persistence.
	 *
	 * @return the message-boards message persistence
	 */
	public MBMessagePersistence getMBMessagePersistence() {
		return mbMessagePersistence;
	}

	/**
	 * Sets the message-boards message persistence.
	 *
	 * @param mbMessagePersistence the message-boards message persistence
	 */
	public void setMBMessagePersistence(
		MBMessagePersistence mbMessagePersistence) {
		this.mbMessagePersistence = mbMessagePersistence;
	}

	/**
	 * Gets the social activity local service.
	 *
	 * @return the social activity local service
	 */
	public SocialActivityLocalService getSocialActivityLocalService() {
		return socialActivityLocalService;
	}

	/**
	 * Sets the social activity local service.
	 *
	 * @param socialActivityLocalService the social activity local service
	 */
	public void setSocialActivityLocalService(
		SocialActivityLocalService socialActivityLocalService) {
		this.socialActivityLocalService = socialActivityLocalService;
	}

	/**
	 * Gets the social activity persistence.
	 *
	 * @return the social activity persistence
	 */
	public SocialActivityPersistence getSocialActivityPersistence() {
		return socialActivityPersistence;
	}

	/**
	 * Sets the social activity persistence.
	 *
	 * @param socialActivityPersistence the social activity persistence
	 */
	public void setSocialActivityPersistence(
		SocialActivityPersistence socialActivityPersistence) {
		this.socialActivityPersistence = socialActivityPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = templatePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ArticleLocalService.class)
	protected ArticleLocalService articleLocalService;
	@BeanReference(type = ArticleService.class)
	protected ArticleService articleService;
	@BeanReference(type = ArticlePersistence.class)
	protected ArticlePersistence articlePersistence;
	@BeanReference(type = TemplateLocalService.class)
	protected TemplateLocalService templateLocalService;
	@BeanReference(type = TemplateService.class)
	protected TemplateService templateService;
	@BeanReference(type = TemplatePersistence.class)
	protected TemplatePersistence templatePersistence;
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
	@BeanReference(type = MBMessageLocalService.class)
	protected MBMessageLocalService mbMessageLocalService;
	@BeanReference(type = MBMessageService.class)
	protected MBMessageService mbMessageService;
	@BeanReference(type = MBMessagePersistence.class)
	protected MBMessagePersistence mbMessagePersistence;
	@BeanReference(type = SocialActivityLocalService.class)
	protected SocialActivityLocalService socialActivityLocalService;
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
}