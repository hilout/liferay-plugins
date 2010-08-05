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

package com.liferay.twitter.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.twitter.NoSuchFeedException;
import com.liferay.twitter.model.Feed;
import com.liferay.twitter.model.impl.FeedImpl;
import com.liferay.twitter.model.impl.FeedModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the feed service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link FeedUtil} to access the feed persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeedPersistence
 * @see FeedUtil
 * @generated
 */
public class FeedPersistenceImpl extends BasePersistenceImpl<Feed>
	implements FeedPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = FeedImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FETCH_BY_TWITTERUSERID = new FinderPath(FeedModelImpl.ENTITY_CACHE_ENABLED,
			FeedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByTwitterUserId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_TWITTERUSERID = new FinderPath(FeedModelImpl.ENTITY_CACHE_ENABLED,
			FeedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByTwitterUserId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_TWITTERSCREENNAME = new FinderPath(FeedModelImpl.ENTITY_CACHE_ENABLED,
			FeedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByTwitterScreenName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_TWITTERSCREENNAME = new FinderPath(FeedModelImpl.ENTITY_CACHE_ENABLED,
			FeedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByTwitterScreenName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(FeedModelImpl.ENTITY_CACHE_ENABLED,
			FeedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FeedModelImpl.ENTITY_CACHE_ENABLED,
			FeedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the feed in the entity cache if it is enabled.
	 *
	 * @param feed the feed to cache
	 */
	public void cacheResult(Feed feed) {
		EntityCacheUtil.putResult(FeedModelImpl.ENTITY_CACHE_ENABLED,
			FeedImpl.class, feed.getPrimaryKey(), feed);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERUSERID,
			new Object[] { new Long(feed.getTwitterUserId()) }, feed);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERSCREENNAME,
			new Object[] { feed.getTwitterScreenName() }, feed);
	}

	/**
	 * Caches the feeds in the entity cache if it is enabled.
	 *
	 * @param feeds the feeds to cache
	 */
	public void cacheResult(List<Feed> feeds) {
		for (Feed feed : feeds) {
			if (EntityCacheUtil.getResult(FeedModelImpl.ENTITY_CACHE_ENABLED,
						FeedImpl.class, feed.getPrimaryKey(), this) == null) {
				cacheResult(feed);
			}
		}
	}

	/**
	 * Clears the cache for all feeds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(FeedImpl.class.getName());
		EntityCacheUtil.clearCache(FeedImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the feed.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Feed feed) {
		EntityCacheUtil.removeResult(FeedModelImpl.ENTITY_CACHE_ENABLED,
			FeedImpl.class, feed.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TWITTERUSERID,
			new Object[] { new Long(feed.getTwitterUserId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TWITTERSCREENNAME,
			new Object[] { feed.getTwitterScreenName() });
	}

	/**
	 * Creates a new feed with the primary key. Does not add the feed to the database.
	 *
	 * @param feedId the primary key for the new feed
	 * @return the new feed
	 */
	public Feed create(long feedId) {
		Feed feed = new FeedImpl();

		feed.setNew(true);
		feed.setPrimaryKey(feedId);

		return feed;
	}

	/**
	 * Removes the feed with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the feed to remove
	 * @return the feed that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the feed with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedId the primary key of the feed to remove
	 * @return the feed that was removed
	 * @throws com.liferay.twitter.NoSuchFeedException if a feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed remove(long feedId) throws NoSuchFeedException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Feed feed = (Feed)session.get(FeedImpl.class, new Long(feedId));

			if (feed == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + feedId);
				}

				throw new NoSuchFeedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					feedId);
			}

			return remove(feed);
		}
		catch (NoSuchFeedException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Feed removeImpl(Feed feed) throws SystemException {
		feed = toUnwrappedModel(feed);

		Session session = null;

		try {
			session = openSession();

			if (feed.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(FeedImpl.class,
						feed.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(feed);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		FeedModelImpl feedModelImpl = (FeedModelImpl)feed;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TWITTERUSERID,
			new Object[] { new Long(feedModelImpl.getOriginalTwitterUserId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TWITTERSCREENNAME,
			new Object[] { feedModelImpl.getOriginalTwitterScreenName() });

		EntityCacheUtil.removeResult(FeedModelImpl.ENTITY_CACHE_ENABLED,
			FeedImpl.class, feed.getPrimaryKey());

		return feed;
	}

	public Feed updateImpl(com.liferay.twitter.model.Feed feed, boolean merge)
		throws SystemException {
		feed = toUnwrappedModel(feed);

		boolean isNew = feed.isNew();

		FeedModelImpl feedModelImpl = (FeedModelImpl)feed;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, feed, merge);

			feed.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(FeedModelImpl.ENTITY_CACHE_ENABLED,
			FeedImpl.class, feed.getPrimaryKey(), feed);

		if (!isNew &&
				(feed.getTwitterUserId() != feedModelImpl.getOriginalTwitterUserId())) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TWITTERUSERID,
				new Object[] { new Long(feedModelImpl.getOriginalTwitterUserId()) });
		}

		if (isNew ||
				(feed.getTwitterUserId() != feedModelImpl.getOriginalTwitterUserId())) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERUSERID,
				new Object[] { new Long(feed.getTwitterUserId()) }, feed);
		}

		if (!isNew &&
				(!Validator.equals(feed.getTwitterScreenName(),
					feedModelImpl.getOriginalTwitterScreenName()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TWITTERSCREENNAME,
				new Object[] { feedModelImpl.getOriginalTwitterScreenName() });
		}

		if (isNew ||
				(!Validator.equals(feed.getTwitterScreenName(),
					feedModelImpl.getOriginalTwitterScreenName()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERSCREENNAME,
				new Object[] { feed.getTwitterScreenName() }, feed);
		}

		return feed;
	}

	protected Feed toUnwrappedModel(Feed feed) {
		if (feed instanceof FeedImpl) {
			return feed;
		}

		FeedImpl feedImpl = new FeedImpl();

		feedImpl.setNew(feed.isNew());
		feedImpl.setPrimaryKey(feed.getPrimaryKey());

		feedImpl.setFeedId(feed.getFeedId());
		feedImpl.setTwitterUserId(feed.getTwitterUserId());
		feedImpl.setTwitterScreenName(feed.getTwitterScreenName());
		feedImpl.setCreateDate(feed.getCreateDate());
		feedImpl.setModifiedDate(feed.getModifiedDate());
		feedImpl.setLastStatusId(feed.getLastStatusId());

		return feedImpl;
	}

	/**
	 * Finds the feed with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the feed to find
	 * @return the feed
	 * @throws com.liferay.portal.NoSuchModelException if a feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the feed with the primary key or throws a {@link com.liferay.twitter.NoSuchFeedException} if it could not be found.
	 *
	 * @param feedId the primary key of the feed to find
	 * @return the feed
	 * @throws com.liferay.twitter.NoSuchFeedException if a feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed findByPrimaryKey(long feedId)
		throws NoSuchFeedException, SystemException {
		Feed feed = fetchByPrimaryKey(feedId);

		if (feed == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + feedId);
			}

			throw new NoSuchFeedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				feedId);
		}

		return feed;
	}

	/**
	 * Finds the feed with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the feed to find
	 * @return the feed, or <code>null</code> if a feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the feed with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param feedId the primary key of the feed to find
	 * @return the feed, or <code>null</code> if a feed with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed fetchByPrimaryKey(long feedId) throws SystemException {
		Feed feed = (Feed)EntityCacheUtil.getResult(FeedModelImpl.ENTITY_CACHE_ENABLED,
				FeedImpl.class, feedId, this);

		if (feed == null) {
			Session session = null;

			try {
				session = openSession();

				feed = (Feed)session.get(FeedImpl.class, new Long(feedId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (feed != null) {
					cacheResult(feed);
				}

				closeSession(session);
			}
		}

		return feed;
	}

	/**
	 * Finds the feed where twitterUserId = &#63; or throws a {@link com.liferay.twitter.NoSuchFeedException} if it could not be found.
	 *
	 * @param twitterUserId the twitter user id to search with
	 * @return the matching feed
	 * @throws com.liferay.twitter.NoSuchFeedException if a matching feed could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed findByTwitterUserId(long twitterUserId)
		throws NoSuchFeedException, SystemException {
		Feed feed = fetchByTwitterUserId(twitterUserId);

		if (feed == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("twitterUserId=");
			msg.append(twitterUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFeedException(msg.toString());
		}

		return feed;
	}

	/**
	 * Finds the feed where twitterUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param twitterUserId the twitter user id to search with
	 * @return the matching feed, or <code>null</code> if a matching feed could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed fetchByTwitterUserId(long twitterUserId)
		throws SystemException {
		return fetchByTwitterUserId(twitterUserId, true);
	}

	/**
	 * Finds the feed where twitterUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param twitterUserId the twitter user id to search with
	 * @return the matching feed, or <code>null</code> if a matching feed could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed fetchByTwitterUserId(long twitterUserId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { twitterUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TWITTERUSERID,
					finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_SELECT_FEED_WHERE);

				query.append(_FINDER_COLUMN_TWITTERUSERID_TWITTERUSERID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(twitterUserId);

				List<Feed> list = q.list();

				result = list;

				Feed feed = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERUSERID,
						finderArgs, list);
				}
				else {
					feed = list.get(0);

					cacheResult(feed);

					if ((feed.getTwitterUserId() != twitterUserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERUSERID,
							finderArgs, feed);
					}
				}

				return feed;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERUSERID,
						finderArgs, new ArrayList<Feed>());
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Feed)result;
			}
		}
	}

	/**
	 * Finds the feed where twitterScreenName = &#63; or throws a {@link com.liferay.twitter.NoSuchFeedException} if it could not be found.
	 *
	 * @param twitterScreenName the twitter screen name to search with
	 * @return the matching feed
	 * @throws com.liferay.twitter.NoSuchFeedException if a matching feed could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed findByTwitterScreenName(String twitterScreenName)
		throws NoSuchFeedException, SystemException {
		Feed feed = fetchByTwitterScreenName(twitterScreenName);

		if (feed == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("twitterScreenName=");
			msg.append(twitterScreenName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFeedException(msg.toString());
		}

		return feed;
	}

	/**
	 * Finds the feed where twitterScreenName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param twitterScreenName the twitter screen name to search with
	 * @return the matching feed, or <code>null</code> if a matching feed could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed fetchByTwitterScreenName(String twitterScreenName)
		throws SystemException {
		return fetchByTwitterScreenName(twitterScreenName, true);
	}

	/**
	 * Finds the feed where twitterScreenName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param twitterScreenName the twitter screen name to search with
	 * @return the matching feed, or <code>null</code> if a matching feed could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Feed fetchByTwitterScreenName(String twitterScreenName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { twitterScreenName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TWITTERSCREENNAME,
					finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_SELECT_FEED_WHERE);

				if (twitterScreenName == null) {
					query.append(_FINDER_COLUMN_TWITTERSCREENNAME_TWITTERSCREENNAME_1);
				}
				else {
					if (twitterScreenName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_TWITTERSCREENNAME_TWITTERSCREENNAME_3);
					}
					else {
						query.append(_FINDER_COLUMN_TWITTERSCREENNAME_TWITTERSCREENNAME_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (twitterScreenName != null) {
					qPos.add(twitterScreenName);
				}

				List<Feed> list = q.list();

				result = list;

				Feed feed = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERSCREENNAME,
						finderArgs, list);
				}
				else {
					feed = list.get(0);

					cacheResult(feed);

					if ((feed.getTwitterScreenName() == null) ||
							!feed.getTwitterScreenName()
									 .equals(twitterScreenName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERSCREENNAME,
							finderArgs, feed);
					}
				}

				return feed;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERSCREENNAME,
						finderArgs, new ArrayList<Feed>());
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Feed)result;
			}
		}
	}

	/**
	 * Finds all the feeds.
	 *
	 * @return the feeds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Feed> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the feeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of feeds to return
	 * @param end the upper bound of the range of feeds to return (not inclusive)
	 * @return the range of feeds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Feed> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the feeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of feeds to return
	 * @param end the upper bound of the range of feeds to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of feeds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Feed> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Feed> list = (List<Feed>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_FEED);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_FEED;
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Feed>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Feed>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Feed>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the feed where twitterUserId = &#63; from the database.
	 *
	 * @param twitterUserId the twitter user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTwitterUserId(long twitterUserId)
		throws NoSuchFeedException, SystemException {
		Feed feed = findByTwitterUserId(twitterUserId);

		remove(feed);
	}

	/**
	 * Removes the feed where twitterScreenName = &#63; from the database.
	 *
	 * @param twitterScreenName the twitter screen name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTwitterScreenName(String twitterScreenName)
		throws NoSuchFeedException, SystemException {
		Feed feed = findByTwitterScreenName(twitterScreenName);

		remove(feed);
	}

	/**
	 * Removes all the feeds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Feed feed : findAll()) {
			remove(feed);
		}
	}

	/**
	 * Counts all the feeds where twitterUserId = &#63;.
	 *
	 * @param twitterUserId the twitter user id to search with
	 * @return the number of matching feeds
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTwitterUserId(long twitterUserId)
		throws SystemException {
		Object[] finderArgs = new Object[] { twitterUserId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TWITTERUSERID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_FEED_WHERE);

				query.append(_FINDER_COLUMN_TWITTERUSERID_TWITTERUSERID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(twitterUserId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TWITTERUSERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the feeds where twitterScreenName = &#63;.
	 *
	 * @param twitterScreenName the twitter screen name to search with
	 * @return the number of matching feeds
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTwitterScreenName(String twitterScreenName)
		throws SystemException {
		Object[] finderArgs = new Object[] { twitterScreenName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TWITTERSCREENNAME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_FEED_WHERE);

				if (twitterScreenName == null) {
					query.append(_FINDER_COLUMN_TWITTERSCREENNAME_TWITTERSCREENNAME_1);
				}
				else {
					if (twitterScreenName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_TWITTERSCREENNAME_TWITTERSCREENNAME_3);
					}
					else {
						query.append(_FINDER_COLUMN_TWITTERSCREENNAME_TWITTERSCREENNAME_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (twitterScreenName != null) {
					qPos.add(twitterScreenName);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TWITTERSCREENNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the feeds.
	 *
	 * @return the number of feeds
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FEED);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the feed persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.twitter.model.Feed")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Feed>> listenersList = new ArrayList<ModelListener<Feed>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Feed>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = FeedPersistence.class)
	protected FeedPersistence feedPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_FEED = "SELECT feed FROM Feed feed";
	private static final String _SQL_SELECT_FEED_WHERE = "SELECT feed FROM Feed feed WHERE ";
	private static final String _SQL_COUNT_FEED = "SELECT COUNT(feed) FROM Feed feed";
	private static final String _SQL_COUNT_FEED_WHERE = "SELECT COUNT(feed) FROM Feed feed WHERE ";
	private static final String _FINDER_COLUMN_TWITTERUSERID_TWITTERUSERID_2 = "feed.twitterUserId = ?";
	private static final String _FINDER_COLUMN_TWITTERSCREENNAME_TWITTERSCREENNAME_1 =
		"feed.twitterScreenName IS NULL";
	private static final String _FINDER_COLUMN_TWITTERSCREENNAME_TWITTERSCREENNAME_2 =
		"feed.twitterScreenName = ?";
	private static final String _FINDER_COLUMN_TWITTERSCREENNAME_TWITTERSCREENNAME_3 =
		"(feed.twitterScreenName IS NULL OR feed.twitterScreenName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "feed.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Feed exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Feed exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(FeedPersistenceImpl.class);
}