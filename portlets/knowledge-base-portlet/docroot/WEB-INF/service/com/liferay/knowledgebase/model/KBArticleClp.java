/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.knowledgebase.model;

import com.liferay.knowledgebase.service.ClpSerializer;
import com.liferay.knowledgebase.service.KBArticleLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class KBArticleClp extends BaseModelImpl<KBArticle> implements KBArticle {
	public KBArticleClp() {
	}

	public Class<?> getModelClass() {
		return KBArticle.class;
	}

	public String getModelClassName() {
		return KBArticle.class.getName();
	}

	public long getPrimaryKey() {
		return _kbArticleId;
	}

	public void setPrimaryKey(long primaryKey) {
		setKbArticleId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _kbArticleId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("kbArticleId", getKbArticleId());
		attributes.put("resourcePrimKey", getResourcePrimKey());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rootResourcePrimKey", getRootResourcePrimKey());
		attributes.put("parentResourcePrimKey", getParentResourcePrimKey());
		attributes.put("version", getVersion());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("description", getDescription());
		attributes.put("priority", getPriority());
		attributes.put("sections", getSections());
		attributes.put("viewCount", getViewCount());
		attributes.put("latest", getLatest());
		attributes.put("main", getMain());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long kbArticleId = (Long)attributes.get("kbArticleId");

		if (kbArticleId != null) {
			setKbArticleId(kbArticleId);
		}

		Long resourcePrimKey = (Long)attributes.get("resourcePrimKey");

		if (resourcePrimKey != null) {
			setResourcePrimKey(resourcePrimKey);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long rootResourcePrimKey = (Long)attributes.get("rootResourcePrimKey");

		if (rootResourcePrimKey != null) {
			setRootResourcePrimKey(rootResourcePrimKey);
		}

		Long parentResourcePrimKey = (Long)attributes.get(
				"parentResourcePrimKey");

		if (parentResourcePrimKey != null) {
			setParentResourcePrimKey(parentResourcePrimKey);
		}

		Integer version = (Integer)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double priority = (Double)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		String sections = (String)attributes.get("sections");

		if (sections != null) {
			setSections(sections);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Boolean latest = (Boolean)attributes.get("latest");

		if (latest != null) {
			setLatest(latest);
		}

		Boolean main = (Boolean)attributes.get("main");

		if (main != null) {
			setMain(main);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_kbArticleRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getKbArticleId() {
		return _kbArticleId;
	}

	public void setKbArticleId(long kbArticleId) {
		_kbArticleId = kbArticleId;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setKbArticleId", long.class);

				method.invoke(_kbArticleRemoteModel, kbArticleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setResourcePrimKey", long.class);

				method.invoke(_kbArticleRemoteModel, resourcePrimKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean isResourceMain() {
		return _resourceMain;
	}

	public void setResourceMain(boolean resourceMain) {
		_resourceMain = resourceMain;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_kbArticleRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_kbArticleRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_kbArticleRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_kbArticleRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_kbArticleRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_kbArticleRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getRootResourcePrimKey() {
		return _rootResourcePrimKey;
	}

	public void setRootResourcePrimKey(long rootResourcePrimKey) {
		_rootResourcePrimKey = rootResourcePrimKey;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setRootResourcePrimKey",
						long.class);

				method.invoke(_kbArticleRemoteModel, rootResourcePrimKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getParentResourcePrimKey() {
		return _parentResourcePrimKey;
	}

	public void setParentResourcePrimKey(long parentResourcePrimKey) {
		_parentResourcePrimKey = parentResourcePrimKey;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setParentResourcePrimKey",
						long.class);

				method.invoke(_kbArticleRemoteModel, parentResourcePrimKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getVersion() {
		return _version;
	}

	public void setVersion(int version) {
		_version = version;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", int.class);

				method.invoke(_kbArticleRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_kbArticleRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_kbArticleRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_kbArticleRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public double getPriority() {
		return _priority;
	}

	public void setPriority(double priority) {
		_priority = priority;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setPriority", double.class);

				method.invoke(_kbArticleRemoteModel, priority);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getSections() {
		return _sections;
	}

	public void setSections(String sections) {
		_sections = sections;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setSections", String.class);

				method.invoke(_kbArticleRemoteModel, sections);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setViewCount", int.class);

				method.invoke(_kbArticleRemoteModel, viewCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getLatest() {
		return _latest;
	}

	public boolean isLatest() {
		return _latest;
	}

	public void setLatest(boolean latest) {
		_latest = latest;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setLatest", boolean.class);

				method.invoke(_kbArticleRemoteModel, latest);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getMain() {
		return _main;
	}

	public boolean isMain() {
		return _main;
	}

	public void setMain(boolean main) {
		_main = main;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setMain", boolean.class);

				method.invoke(_kbArticleRemoteModel, main);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_kbArticleRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_kbArticleRemoteModel, statusByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_kbArticleRemoteModel, statusByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;

		if (_kbArticleRemoteModel != null) {
			try {
				Class<?> clazz = _kbArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_kbArticleRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getAttachmentsFolderId() {
		try {
			String methodName = "getAttachmentsFolderId";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public java.util.List<com.liferay.portal.kernel.repository.model.FileEntry> getAttachmentsFileEntries() {
		try {
			String methodName = "getAttachmentsFileEntries";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.liferay.portal.kernel.repository.model.FileEntry> returnObj =
				(java.util.List<com.liferay.portal.kernel.repository.model.FileEntry>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public boolean isFirstVersion() {
		try {
			String methodName = "isFirstVersion";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public java.lang.String getAttachmentsDirName() {
		try {
			String methodName = "getAttachmentsDirName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public long getClassPK() {
		try {
			String methodName = "getClassPK";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public boolean isRoot() {
		try {
			String methodName = "isRoot";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public java.lang.String[] getAttachmentsFileNames() {
		try {
			String methodName = "getAttachmentsFileNames";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String[] returnObj = (java.lang.String[])invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	public boolean getApproved() {
		return isApproved();
	}

	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isInTrash() {
		if (getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public BaseModel<?> getKBArticleRemoteModel() {
		return _kbArticleRemoteModel;
	}

	public void setKBArticleRemoteModel(BaseModel<?> kbArticleRemoteModel) {
		_kbArticleRemoteModel = kbArticleRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _kbArticleRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_kbArticleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			KBArticleLocalServiceUtil.addKBArticle(this);
		}
		else {
			KBArticleLocalServiceUtil.updateKBArticle(this);
		}
	}

	@Override
	public KBArticle toEscapedModel() {
		return (KBArticle)ProxyUtil.newProxyInstance(KBArticle.class.getClassLoader(),
			new Class[] { KBArticle.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KBArticleClp clone = new KBArticleClp();

		clone.setUuid(getUuid());
		clone.setKbArticleId(getKbArticleId());
		clone.setResourcePrimKey(getResourcePrimKey());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRootResourcePrimKey(getRootResourcePrimKey());
		clone.setParentResourcePrimKey(getParentResourcePrimKey());
		clone.setVersion(getVersion());
		clone.setTitle(getTitle());
		clone.setContent(getContent());
		clone.setDescription(getDescription());
		clone.setPriority(getPriority());
		clone.setSections(getSections());
		clone.setViewCount(getViewCount());
		clone.setLatest(getLatest());
		clone.setMain(getMain());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());

		return clone;
	}

	public int compareTo(KBArticle kbArticle) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				kbArticle.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KBArticleClp)) {
			return false;
		}

		KBArticleClp kbArticle = (KBArticleClp)obj;

		long primaryKey = kbArticle.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", kbArticleId=");
		sb.append(getKbArticleId());
		sb.append(", resourcePrimKey=");
		sb.append(getResourcePrimKey());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", rootResourcePrimKey=");
		sb.append(getRootResourcePrimKey());
		sb.append(", parentResourcePrimKey=");
		sb.append(getParentResourcePrimKey());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", sections=");
		sb.append(getSections());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append(", latest=");
		sb.append(getLatest());
		sb.append(", main=");
		sb.append(getMain());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("com.liferay.knowledgebase.model.KBArticle");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kbArticleId</column-name><column-value><![CDATA[");
		sb.append(getKbArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourcePrimKey</column-name><column-value><![CDATA[");
		sb.append(getResourcePrimKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootResourcePrimKey</column-name><column-value><![CDATA[");
		sb.append(getRootResourcePrimKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentResourcePrimKey</column-name><column-value><![CDATA[");
		sb.append(getParentResourcePrimKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sections</column-name><column-value><![CDATA[");
		sb.append(getSections());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latest</column-name><column-value><![CDATA[");
		sb.append(getLatest());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>main</column-name><column-value><![CDATA[");
		sb.append(getMain());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _kbArticleId;
	private long _resourcePrimKey;
	private boolean _resourceMain;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _rootResourcePrimKey;
	private long _parentResourcePrimKey;
	private int _version;
	private String _title;
	private String _content;
	private String _description;
	private double _priority;
	private String _sections;
	private int _viewCount;
	private boolean _latest;
	private boolean _main;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private BaseModel<?> _kbArticleRemoteModel;
}