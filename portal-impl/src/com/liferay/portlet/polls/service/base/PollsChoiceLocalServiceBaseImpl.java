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

package com.liferay.portlet.polls.service.base;

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
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.polls.model.PollsChoice;
import com.liferay.portlet.polls.service.PollsChoiceLocalService;
import com.liferay.portlet.polls.service.PollsQuestionLocalService;
import com.liferay.portlet.polls.service.PollsQuestionService;
import com.liferay.portlet.polls.service.PollsVoteLocalService;
import com.liferay.portlet.polls.service.PollsVoteService;
import com.liferay.portlet.polls.service.persistence.PollsChoiceFinder;
import com.liferay.portlet.polls.service.persistence.PollsChoicePersistence;
import com.liferay.portlet.polls.service.persistence.PollsQuestionPersistence;
import com.liferay.portlet.polls.service.persistence.PollsVotePersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the polls choice local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.polls.service.impl.PollsChoiceLocalServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.polls.service.PollsChoiceLocalServiceUtil} to access the polls choice local service.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.polls.service.impl.PollsChoiceLocalServiceImpl
 * @see com.liferay.portlet.polls.service.PollsChoiceLocalServiceUtil
 * @generated
 */
public abstract class PollsChoiceLocalServiceBaseImpl
	implements PollsChoiceLocalService {
	/**
	 * Adds the polls choice to the database. Also notifies the appropriate model listeners.
	 *
	 * @param pollsChoice the polls choice to add
	 * @return the polls choice that was added
	 * @throws SystemException if a system exception occurred
	 */
	public PollsChoice addPollsChoice(PollsChoice pollsChoice)
		throws SystemException {
		pollsChoice.setNew(true);

		return pollsChoicePersistence.update(pollsChoice, false);
	}

	/**
	 * Creates a new polls choice with the primary key. Does not add the polls choice to the database.
	 *
	 * @param choiceId the primary key for the new polls choice
	 * @return the new polls choice
	 */
	public PollsChoice createPollsChoice(long choiceId) {
		return pollsChoicePersistence.create(choiceId);
	}

	/**
	 * Deletes the polls choice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param choiceId the primary key of the polls choice to delete
	 * @throws PortalException if a polls choice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deletePollsChoice(long choiceId)
		throws PortalException, SystemException {
		pollsChoicePersistence.remove(choiceId);
	}

	/**
	 * Deletes the polls choice from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pollsChoice the polls choice to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deletePollsChoice(PollsChoice pollsChoice)
		throws SystemException {
		pollsChoicePersistence.remove(pollsChoice);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return pollsChoicePersistence.findWithDynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return pollsChoicePersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
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
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return pollsChoicePersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return pollsChoicePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the polls choice with the primary key.
	 *
	 * @param choiceId the primary key of the polls choice to get
	 * @return the polls choice
	 * @throws PortalException if a polls choice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PollsChoice getPollsChoice(long choiceId)
		throws PortalException, SystemException {
		return pollsChoicePersistence.findByPrimaryKey(choiceId);
	}

	/**
	 * Gets a range of all the polls choices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of polls choices to return
	 * @param end the upper bound of the range of polls choices to return (not inclusive)
	 * @return the range of polls choices
	 * @throws SystemException if a system exception occurred
	 */
	public List<PollsChoice> getPollsChoices(int start, int end)
		throws SystemException {
		return pollsChoicePersistence.findAll(start, end);
	}

	/**
	 * Gets the number of polls choices.
	 *
	 * @return the number of polls choices
	 * @throws SystemException if a system exception occurred
	 */
	public int getPollsChoicesCount() throws SystemException {
		return pollsChoicePersistence.countAll();
	}

	/**
	 * Updates the polls choice in the database. Also notifies the appropriate model listeners.
	 *
	 * @param pollsChoice the polls choice to update
	 * @return the polls choice that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public PollsChoice updatePollsChoice(PollsChoice pollsChoice)
		throws SystemException {
		pollsChoice.setNew(false);

		return pollsChoicePersistence.update(pollsChoice, true);
	}

	/**
	 * Updates the polls choice in the database. Also notifies the appropriate model listeners.
	 *
	 * @param pollsChoice the polls choice to update
	 * @param merge whether to merge the polls choice with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the polls choice that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public PollsChoice updatePollsChoice(PollsChoice pollsChoice, boolean merge)
		throws SystemException {
		pollsChoice.setNew(false);

		return pollsChoicePersistence.update(pollsChoice, merge);
	}

	/**
	 * Gets the polls choice local service.
	 *
	 * @return the polls choice local service
	 */
	public PollsChoiceLocalService getPollsChoiceLocalService() {
		return pollsChoiceLocalService;
	}

	/**
	 * Sets the polls choice local service.
	 *
	 * @param pollsChoiceLocalService the polls choice local service
	 */
	public void setPollsChoiceLocalService(
		PollsChoiceLocalService pollsChoiceLocalService) {
		this.pollsChoiceLocalService = pollsChoiceLocalService;
	}

	/**
	 * Gets the polls choice persistence.
	 *
	 * @return the polls choice persistence
	 */
	public PollsChoicePersistence getPollsChoicePersistence() {
		return pollsChoicePersistence;
	}

	/**
	 * Sets the polls choice persistence.
	 *
	 * @param pollsChoicePersistence the polls choice persistence
	 */
	public void setPollsChoicePersistence(
		PollsChoicePersistence pollsChoicePersistence) {
		this.pollsChoicePersistence = pollsChoicePersistence;
	}

	/**
	 * Gets the polls choice finder.
	 *
	 * @return the polls choice finder
	 */
	public PollsChoiceFinder getPollsChoiceFinder() {
		return pollsChoiceFinder;
	}

	/**
	 * Sets the polls choice finder.
	 *
	 * @param pollsChoiceFinder the polls choice finder
	 */
	public void setPollsChoiceFinder(PollsChoiceFinder pollsChoiceFinder) {
		this.pollsChoiceFinder = pollsChoiceFinder;
	}

	/**
	 * Gets the polls question local service.
	 *
	 * @return the polls question local service
	 */
	public PollsQuestionLocalService getPollsQuestionLocalService() {
		return pollsQuestionLocalService;
	}

	/**
	 * Sets the polls question local service.
	 *
	 * @param pollsQuestionLocalService the polls question local service
	 */
	public void setPollsQuestionLocalService(
		PollsQuestionLocalService pollsQuestionLocalService) {
		this.pollsQuestionLocalService = pollsQuestionLocalService;
	}

	/**
	 * Gets the polls question remote service.
	 *
	 * @return the polls question remote service
	 */
	public PollsQuestionService getPollsQuestionService() {
		return pollsQuestionService;
	}

	/**
	 * Sets the polls question remote service.
	 *
	 * @param pollsQuestionService the polls question remote service
	 */
	public void setPollsQuestionService(
		PollsQuestionService pollsQuestionService) {
		this.pollsQuestionService = pollsQuestionService;
	}

	/**
	 * Gets the polls question persistence.
	 *
	 * @return the polls question persistence
	 */
	public PollsQuestionPersistence getPollsQuestionPersistence() {
		return pollsQuestionPersistence;
	}

	/**
	 * Sets the polls question persistence.
	 *
	 * @param pollsQuestionPersistence the polls question persistence
	 */
	public void setPollsQuestionPersistence(
		PollsQuestionPersistence pollsQuestionPersistence) {
		this.pollsQuestionPersistence = pollsQuestionPersistence;
	}

	/**
	 * Gets the polls vote local service.
	 *
	 * @return the polls vote local service
	 */
	public PollsVoteLocalService getPollsVoteLocalService() {
		return pollsVoteLocalService;
	}

	/**
	 * Sets the polls vote local service.
	 *
	 * @param pollsVoteLocalService the polls vote local service
	 */
	public void setPollsVoteLocalService(
		PollsVoteLocalService pollsVoteLocalService) {
		this.pollsVoteLocalService = pollsVoteLocalService;
	}

	/**
	 * Gets the polls vote remote service.
	 *
	 * @return the polls vote remote service
	 */
	public PollsVoteService getPollsVoteService() {
		return pollsVoteService;
	}

	/**
	 * Sets the polls vote remote service.
	 *
	 * @param pollsVoteService the polls vote remote service
	 */
	public void setPollsVoteService(PollsVoteService pollsVoteService) {
		this.pollsVoteService = pollsVoteService;
	}

	/**
	 * Gets the polls vote persistence.
	 *
	 * @return the polls vote persistence
	 */
	public PollsVotePersistence getPollsVotePersistence() {
		return pollsVotePersistence;
	}

	/**
	 * Sets the polls vote persistence.
	 *
	 * @param pollsVotePersistence the polls vote persistence
	 */
	public void setPollsVotePersistence(
		PollsVotePersistence pollsVotePersistence) {
		this.pollsVotePersistence = pollsVotePersistence;
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
	 * Gets the resource finder.
	 *
	 * @return the resource finder
	 */
	public ResourceFinder getResourceFinder() {
		return resourceFinder;
	}

	/**
	 * Sets the resource finder.
	 *
	 * @param resourceFinder the resource finder
	 */
	public void setResourceFinder(ResourceFinder resourceFinder) {
		this.resourceFinder = resourceFinder;
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
	 * Gets the user finder.
	 *
	 * @return the user finder
	 */
	public UserFinder getUserFinder() {
		return userFinder;
	}

	/**
	 * Sets the user finder.
	 *
	 * @param userFinder the user finder
	 */
	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = pollsChoicePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = PollsChoiceLocalService.class)
	protected PollsChoiceLocalService pollsChoiceLocalService;
	@BeanReference(type = PollsChoicePersistence.class)
	protected PollsChoicePersistence pollsChoicePersistence;
	@BeanReference(type = PollsChoiceFinder.class)
	protected PollsChoiceFinder pollsChoiceFinder;
	@BeanReference(type = PollsQuestionLocalService.class)
	protected PollsQuestionLocalService pollsQuestionLocalService;
	@BeanReference(type = PollsQuestionService.class)
	protected PollsQuestionService pollsQuestionService;
	@BeanReference(type = PollsQuestionPersistence.class)
	protected PollsQuestionPersistence pollsQuestionPersistence;
	@BeanReference(type = PollsVoteLocalService.class)
	protected PollsVoteLocalService pollsVoteLocalService;
	@BeanReference(type = PollsVoteService.class)
	protected PollsVoteService pollsVoteService;
	@BeanReference(type = PollsVotePersistence.class)
	protected PollsVotePersistence pollsVotePersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceFinder.class)
	protected ResourceFinder resourceFinder;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserFinder.class)
	protected UserFinder userFinder;
}