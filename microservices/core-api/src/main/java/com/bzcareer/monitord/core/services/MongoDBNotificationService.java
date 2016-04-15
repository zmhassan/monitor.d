package com.bzcareer.monitord.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.stream.Collectors.toList;
import com.bzcareer.monitord.core.model.Notification;
import com.bzcareer.monitord.core.model.NotificationDAO;
import com.bzcareer.monitord.core.repository.NotificationRepository;

@Service
public class MongoDBNotificationService implements NotificationService {

	@Autowired
	NotificationRepository repo;

 
	@Override
	public NotificationDAO create(NotificationDAO NotificationDAO) {
		Notification Notification = new Notification(NotificationDAO.getNotification_type(), NotificationDAO.getFrom(), NotificationDAO.getMessage());
		Notification saved = repo.save(Notification);
		return new NotificationDAO(saved);
	}

	@Override
	public NotificationDAO delete(String id) {
		Notification Notification = repo.findOne(id);
		repo.delete(id);
		return new NotificationDAO(Notification);
	}

	@Override
	public List<NotificationDAO> findAll() {
		return repo.findAll().stream().map(this::daoConverter).collect(toList());
	}

	private NotificationDAO daoConverter(Notification Notification) {
		return convertToDAO(Notification);
	}

	private NotificationDAO convertToDAO(Notification Notification) {
		return new NotificationDAO(Notification);
	}

	@Override
	public NotificationDAO findById(String id) {
		Notification Notification = repo.findOne(id);
		return convertToDAO(Notification);
	}

	@Override
	public NotificationDAO update(NotificationDAO NotificationDAO) {
		Notification Notification = repo.findOne(NotificationDAO.getId());
		Notification.update(NotificationDAO);
		repo.save(Notification);
		return new NotificationDAO(Notification);
	}

	@Override
	public void delete(NotificationDAO NotificationDAO) {
		Notification Notification = repo.findOne(NotificationDAO.getId());
		repo.delete(Notification);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}
}
