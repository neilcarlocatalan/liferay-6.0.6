/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.polls.service.persistence;

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
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.polls.NoSuchVoteException;
import com.liferay.portlet.polls.model.PollsVote;
import com.liferay.portlet.polls.model.impl.PollsVoteImpl;
import com.liferay.portlet.polls.model.impl.PollsVoteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the polls vote service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link PollsVoteUtil} to access the polls vote persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PollsVotePersistence
 * @see PollsVoteUtil
 * @generated
 */
public class PollsVotePersistenceImpl extends BasePersistenceImpl<PollsVote>
	implements PollsVotePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = PollsVoteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_QUESTIONID = new FinderPath(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByQuestionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONID = new FinderPath(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByQuestionId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CHOICEID = new FinderPath(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByChoiceId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CHOICEID = new FinderPath(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByChoiceId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_Q_U = new FinderPath(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByQ_U",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_Q_U = new FinderPath(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByQ_U",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the polls vote in the entity cache if it is enabled.
	 *
	 * @param pollsVote the polls vote to cache
	 */
	public void cacheResult(PollsVote pollsVote) {
		EntityCacheUtil.putResult(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteImpl.class, pollsVote.getPrimaryKey(), pollsVote);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_Q_U,
			new Object[] {
				new Long(pollsVote.getQuestionId()),
				new Long(pollsVote.getUserId())
			}, pollsVote);
	}

	/**
	 * Caches the polls votes in the entity cache if it is enabled.
	 *
	 * @param pollsVotes the polls votes to cache
	 */
	public void cacheResult(List<PollsVote> pollsVotes) {
		for (PollsVote pollsVote : pollsVotes) {
			if (EntityCacheUtil.getResult(
						PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
						PollsVoteImpl.class, pollsVote.getPrimaryKey(), this) == null) {
				cacheResult(pollsVote);
			}
		}
	}

	/**
	 * Clears the cache for all polls votes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(PollsVoteImpl.class.getName());
		EntityCacheUtil.clearCache(PollsVoteImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the polls vote.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(PollsVote pollsVote) {
		EntityCacheUtil.removeResult(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteImpl.class, pollsVote.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_Q_U,
			new Object[] {
				new Long(pollsVote.getQuestionId()),
				new Long(pollsVote.getUserId())
			});
	}

	/**
	 * Creates a new polls vote with the primary key. Does not add the polls vote to the database.
	 *
	 * @param voteId the primary key for the new polls vote
	 * @return the new polls vote
	 */
	public PollsVote create(long voteId) {
		PollsVote pollsVote = new PollsVoteImpl();

		pollsVote.setNew(true);
		pollsVote.setPrimaryKey(voteId);

		return pollsVote;
	}

	/**
	 * Removes the polls vote with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the polls vote to remove
	 * @return the polls vote that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a polls vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the polls vote with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param voteId the primary key of the polls vote to remove
	 * @return the polls vote that was removed
	 * @throws com.liferay.portlet.polls.NoSuchVoteException if a polls vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote remove(long voteId)
		throws NoSuchVoteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PollsVote pollsVote = (PollsVote)session.get(PollsVoteImpl.class,
					new Long(voteId));

			if (pollsVote == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + voteId);
				}

				throw new NoSuchVoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					voteId);
			}

			return remove(pollsVote);
		}
		catch (NoSuchVoteException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PollsVote removeImpl(PollsVote pollsVote)
		throws SystemException {
		pollsVote = toUnwrappedModel(pollsVote);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, pollsVote);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		PollsVoteModelImpl pollsVoteModelImpl = (PollsVoteModelImpl)pollsVote;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_Q_U,
			new Object[] {
				new Long(pollsVoteModelImpl.getQuestionId()),
				new Long(pollsVoteModelImpl.getUserId())
			});

		EntityCacheUtil.removeResult(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteImpl.class, pollsVote.getPrimaryKey());

		return pollsVote;
	}

	public PollsVote updateImpl(
		com.liferay.portlet.polls.model.PollsVote pollsVote, boolean merge)
		throws SystemException {
		pollsVote = toUnwrappedModel(pollsVote);

		boolean isNew = pollsVote.isNew();

		PollsVoteModelImpl pollsVoteModelImpl = (PollsVoteModelImpl)pollsVote;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, pollsVote, merge);

			pollsVote.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
			PollsVoteImpl.class, pollsVote.getPrimaryKey(), pollsVote);

		if (!isNew &&
				((pollsVote.getQuestionId() != pollsVoteModelImpl.getOriginalQuestionId()) ||
				(pollsVote.getUserId() != pollsVoteModelImpl.getOriginalUserId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_Q_U,
				new Object[] {
					new Long(pollsVoteModelImpl.getOriginalQuestionId()),
					new Long(pollsVoteModelImpl.getOriginalUserId())
				});
		}

		if (isNew ||
				((pollsVote.getQuestionId() != pollsVoteModelImpl.getOriginalQuestionId()) ||
				(pollsVote.getUserId() != pollsVoteModelImpl.getOriginalUserId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_Q_U,
				new Object[] {
					new Long(pollsVote.getQuestionId()),
					new Long(pollsVote.getUserId())
				}, pollsVote);
		}

		return pollsVote;
	}

	protected PollsVote toUnwrappedModel(PollsVote pollsVote) {
		if (pollsVote instanceof PollsVoteImpl) {
			return pollsVote;
		}

		PollsVoteImpl pollsVoteImpl = new PollsVoteImpl();

		pollsVoteImpl.setNew(pollsVote.isNew());
		pollsVoteImpl.setPrimaryKey(pollsVote.getPrimaryKey());

		pollsVoteImpl.setVoteId(pollsVote.getVoteId());
		pollsVoteImpl.setUserId(pollsVote.getUserId());
		pollsVoteImpl.setQuestionId(pollsVote.getQuestionId());
		pollsVoteImpl.setChoiceId(pollsVote.getChoiceId());
		pollsVoteImpl.setVoteDate(pollsVote.getVoteDate());

		return pollsVoteImpl;
	}

	/**
	 * Finds the polls vote with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the polls vote to find
	 * @return the polls vote
	 * @throws com.liferay.portal.NoSuchModelException if a polls vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the polls vote with the primary key or throws a {@link com.liferay.portlet.polls.NoSuchVoteException} if it could not be found.
	 *
	 * @param voteId the primary key of the polls vote to find
	 * @return the polls vote
	 * @throws com.liferay.portlet.polls.NoSuchVoteException if a polls vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote findByPrimaryKey(long voteId)
		throws NoSuchVoteException, SystemException {
		PollsVote pollsVote = fetchByPrimaryKey(voteId);

		if (pollsVote == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + voteId);
			}

			throw new NoSuchVoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				voteId);
		}

		return pollsVote;
	}

	/**
	 * Finds the polls vote with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the polls vote to find
	 * @return the polls vote, or <code>null</code> if a polls vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the polls vote with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param voteId the primary key of the polls vote to find
	 * @return the polls vote, or <code>null</code> if a polls vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote fetchByPrimaryKey(long voteId) throws SystemException {
		PollsVote pollsVote = (PollsVote)EntityCacheUtil.getResult(PollsVoteModelImpl.ENTITY_CACHE_ENABLED,
				PollsVoteImpl.class, voteId, this);

		if (pollsVote == null) {
			Session session = null;

			try {
				session = openSession();

				pollsVote = (PollsVote)session.get(PollsVoteImpl.class,
						new Long(voteId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (pollsVote != null) {
					cacheResult(pollsVote);
				}

				closeSession(session);
			}
		}

		return pollsVote;
	}

	/**
	 * Finds all the polls votes where questionId = &#63;.
	 *
	 * @param questionId the question id to search with
	 * @return the matching polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PollsVote> findByQuestionId(long questionId)
		throws SystemException {
		return findByQuestionId(questionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the polls votes where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question id to search with
	 * @param start the lower bound of the range of polls votes to return
	 * @param end the upper bound of the range of polls votes to return (not inclusive)
	 * @return the range of matching polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PollsVote> findByQuestionId(long questionId, int start, int end)
		throws SystemException {
		return findByQuestionId(questionId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the polls votes where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question id to search with
	 * @param start the lower bound of the range of polls votes to return
	 * @param end the upper bound of the range of polls votes to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PollsVote> findByQuestionId(long questionId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				questionId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PollsVote> list = (List<PollsVote>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_QUESTIONID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_POLLSVOTE_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				list = (List<PollsVote>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_QUESTIONID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_QUESTIONID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first polls vote in the ordered set where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching polls vote
	 * @throws com.liferay.portlet.polls.NoSuchVoteException if a matching polls vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote findByQuestionId_First(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		List<PollsVote> list = findByQuestionId(questionId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionId=");
			msg.append(questionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVoteException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last polls vote in the ordered set where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching polls vote
	 * @throws com.liferay.portlet.polls.NoSuchVoteException if a matching polls vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote findByQuestionId_Last(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		int count = countByQuestionId(questionId);

		List<PollsVote> list = findByQuestionId(questionId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionId=");
			msg.append(questionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVoteException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the polls votes before and after the current polls vote in the ordered set where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param voteId the primary key of the current polls vote
	 * @param questionId the question id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next polls vote
	 * @throws com.liferay.portlet.polls.NoSuchVoteException if a polls vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote[] findByQuestionId_PrevAndNext(long voteId,
		long questionId, OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		PollsVote pollsVote = findByPrimaryKey(voteId);

		Session session = null;

		try {
			session = openSession();

			PollsVote[] array = new PollsVoteImpl[3];

			array[0] = getByQuestionId_PrevAndNext(session, pollsVote,
					questionId, orderByComparator, true);

			array[1] = pollsVote;

			array[2] = getByQuestionId_PrevAndNext(session, pollsVote,
					questionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PollsVote getByQuestionId_PrevAndNext(Session session,
		PollsVote pollsVote, long questionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_POLLSVOTE_WHERE);

		query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(questionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(pollsVote);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PollsVote> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the polls votes where choiceId = &#63;.
	 *
	 * @param choiceId the choice id to search with
	 * @return the matching polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PollsVote> findByChoiceId(long choiceId)
		throws SystemException {
		return findByChoiceId(choiceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the polls votes where choiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param choiceId the choice id to search with
	 * @param start the lower bound of the range of polls votes to return
	 * @param end the upper bound of the range of polls votes to return (not inclusive)
	 * @return the range of matching polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PollsVote> findByChoiceId(long choiceId, int start, int end)
		throws SystemException {
		return findByChoiceId(choiceId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the polls votes where choiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param choiceId the choice id to search with
	 * @param start the lower bound of the range of polls votes to return
	 * @param end the upper bound of the range of polls votes to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PollsVote> findByChoiceId(long choiceId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				choiceId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PollsVote> list = (List<PollsVote>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CHOICEID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_POLLSVOTE_WHERE);

			query.append(_FINDER_COLUMN_CHOICEID_CHOICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(choiceId);

				list = (List<PollsVote>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_CHOICEID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CHOICEID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first polls vote in the ordered set where choiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param choiceId the choice id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching polls vote
	 * @throws com.liferay.portlet.polls.NoSuchVoteException if a matching polls vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote findByChoiceId_First(long choiceId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		List<PollsVote> list = findByChoiceId(choiceId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("choiceId=");
			msg.append(choiceId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVoteException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last polls vote in the ordered set where choiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param choiceId the choice id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching polls vote
	 * @throws com.liferay.portlet.polls.NoSuchVoteException if a matching polls vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote findByChoiceId_Last(long choiceId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		int count = countByChoiceId(choiceId);

		List<PollsVote> list = findByChoiceId(choiceId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("choiceId=");
			msg.append(choiceId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVoteException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the polls votes before and after the current polls vote in the ordered set where choiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param voteId the primary key of the current polls vote
	 * @param choiceId the choice id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next polls vote
	 * @throws com.liferay.portlet.polls.NoSuchVoteException if a polls vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote[] findByChoiceId_PrevAndNext(long voteId, long choiceId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		PollsVote pollsVote = findByPrimaryKey(voteId);

		Session session = null;

		try {
			session = openSession();

			PollsVote[] array = new PollsVoteImpl[3];

			array[0] = getByChoiceId_PrevAndNext(session, pollsVote, choiceId,
					orderByComparator, true);

			array[1] = pollsVote;

			array[2] = getByChoiceId_PrevAndNext(session, pollsVote, choiceId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PollsVote getByChoiceId_PrevAndNext(Session session,
		PollsVote pollsVote, long choiceId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_POLLSVOTE_WHERE);

		query.append(_FINDER_COLUMN_CHOICEID_CHOICEID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(choiceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(pollsVote);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PollsVote> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the polls vote where questionId = &#63; and userId = &#63; or throws a {@link com.liferay.portlet.polls.NoSuchVoteException} if it could not be found.
	 *
	 * @param questionId the question id to search with
	 * @param userId the user id to search with
	 * @return the matching polls vote
	 * @throws com.liferay.portlet.polls.NoSuchVoteException if a matching polls vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote findByQ_U(long questionId, long userId)
		throws NoSuchVoteException, SystemException {
		PollsVote pollsVote = fetchByQ_U(questionId, userId);

		if (pollsVote == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionId=");
			msg.append(questionId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVoteException(msg.toString());
		}

		return pollsVote;
	}

	/**
	 * Finds the polls vote where questionId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param questionId the question id to search with
	 * @param userId the user id to search with
	 * @return the matching polls vote, or <code>null</code> if a matching polls vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote fetchByQ_U(long questionId, long userId)
		throws SystemException {
		return fetchByQ_U(questionId, userId, true);
	}

	/**
	 * Finds the polls vote where questionId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param questionId the question id to search with
	 * @param userId the user id to search with
	 * @return the matching polls vote, or <code>null</code> if a matching polls vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsVote fetchByQ_U(long questionId, long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { questionId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_Q_U,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_POLLSVOTE_WHERE);

			query.append(_FINDER_COLUMN_Q_U_QUESTIONID_2);

			query.append(_FINDER_COLUMN_Q_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				qPos.add(userId);

				List<PollsVote> list = q.list();

				result = list;

				PollsVote pollsVote = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_Q_U,
						finderArgs, list);
				}
				else {
					pollsVote = list.get(0);

					cacheResult(pollsVote);

					if ((pollsVote.getQuestionId() != questionId) ||
							(pollsVote.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_Q_U,
							finderArgs, pollsVote);
					}
				}

				return pollsVote;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_Q_U,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (PollsVote)result;
			}
		}
	}

	/**
	 * Finds all the polls votes.
	 *
	 * @return the polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PollsVote> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the polls votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of polls votes to return
	 * @param end the upper bound of the range of polls votes to return (not inclusive)
	 * @return the range of polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PollsVote> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the polls votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of polls votes to return
	 * @param end the upper bound of the range of polls votes to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PollsVote> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PollsVote> list = (List<PollsVote>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_POLLSVOTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_POLLSVOTE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PollsVote>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PollsVote>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the polls votes where questionId = &#63; from the database.
	 *
	 * @param questionId the question id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQuestionId(long questionId) throws SystemException {
		for (PollsVote pollsVote : findByQuestionId(questionId)) {
			remove(pollsVote);
		}
	}

	/**
	 * Removes all the polls votes where choiceId = &#63; from the database.
	 *
	 * @param choiceId the choice id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByChoiceId(long choiceId) throws SystemException {
		for (PollsVote pollsVote : findByChoiceId(choiceId)) {
			remove(pollsVote);
		}
	}

	/**
	 * Removes the polls vote where questionId = &#63; and userId = &#63; from the database.
	 *
	 * @param questionId the question id to search with
	 * @param userId the user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQ_U(long questionId, long userId)
		throws NoSuchVoteException, SystemException {
		PollsVote pollsVote = findByQ_U(questionId, userId);

		remove(pollsVote);
	}

	/**
	 * Removes all the polls votes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PollsVote pollsVote : findAll()) {
			remove(pollsVote);
		}
	}

	/**
	 * Counts all the polls votes where questionId = &#63;.
	 *
	 * @param questionId the question id to search with
	 * @return the number of matching polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQuestionId(long questionId) throws SystemException {
		Object[] finderArgs = new Object[] { questionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUESTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POLLSVOTE_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the polls votes where choiceId = &#63;.
	 *
	 * @param choiceId the choice id to search with
	 * @return the number of matching polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByChoiceId(long choiceId) throws SystemException {
		Object[] finderArgs = new Object[] { choiceId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CHOICEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POLLSVOTE_WHERE);

			query.append(_FINDER_COLUMN_CHOICEID_CHOICEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(choiceId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHOICEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the polls votes where questionId = &#63; and userId = &#63;.
	 *
	 * @param questionId the question id to search with
	 * @param userId the user id to search with
	 * @return the number of matching polls votes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQ_U(long questionId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { questionId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_Q_U,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_POLLSVOTE_WHERE);

			query.append(_FINDER_COLUMN_Q_U_QUESTIONID_2);

			query.append(_FINDER_COLUMN_Q_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_Q_U, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the polls votes.
	 *
	 * @return the number of polls votes
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

				Query q = session.createQuery(_SQL_COUNT_POLLSVOTE);

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
	 * Initializes the polls vote persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portlet.polls.model.PollsVote")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PollsVote>> listenersList = new ArrayList<ModelListener<PollsVote>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PollsVote>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PollsVoteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = PollsChoicePersistence.class)
	protected PollsChoicePersistence pollsChoicePersistence;
	@BeanReference(type = PollsQuestionPersistence.class)
	protected PollsQuestionPersistence pollsQuestionPersistence;
	@BeanReference(type = PollsVotePersistence.class)
	protected PollsVotePersistence pollsVotePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_POLLSVOTE = "SELECT pollsVote FROM PollsVote pollsVote";
	private static final String _SQL_SELECT_POLLSVOTE_WHERE = "SELECT pollsVote FROM PollsVote pollsVote WHERE ";
	private static final String _SQL_COUNT_POLLSVOTE = "SELECT COUNT(pollsVote) FROM PollsVote pollsVote";
	private static final String _SQL_COUNT_POLLSVOTE_WHERE = "SELECT COUNT(pollsVote) FROM PollsVote pollsVote WHERE ";
	private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 = "pollsVote.questionId = ?";
	private static final String _FINDER_COLUMN_CHOICEID_CHOICEID_2 = "pollsVote.choiceId = ?";
	private static final String _FINDER_COLUMN_Q_U_QUESTIONID_2 = "pollsVote.questionId = ? AND ";
	private static final String _FINDER_COLUMN_Q_U_USERID_2 = "pollsVote.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pollsVote.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PollsVote exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PollsVote exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(PollsVotePersistenceImpl.class);
}