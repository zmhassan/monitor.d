package com.bzcareer.monitord.core.services;

import java.util.List;

import com.bzcareer.monitord.core.model.NotificationDAO;

public interface NotificationService {

	NotificationDAO create(NotificationDAO inboxDAO);

	NotificationDAO delete(String id);

	List<NotificationDAO> findAll();

	NotificationDAO findById(String id);

	NotificationDAO update(NotificationDAO inboxDAO);

	void deleteAll();

	void delete(NotificationDAO inboxDAO);
}
