package com.bzcareer.monitord.core.services;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzcareer.monitord.core.model.UserDAO;
import com.bzcareer.monitord.core.model.Users;
import com.bzcareer.monitord.core.repository.UserRepository;

@Service
public class MongoDBUserService implements UserService {

	@Autowired
	UserRepository repo;

	@Override
	public UserDAO create(UserDAO userDAO) {
		Users user = repo.save(new Users(userDAO.getUsername(), userDAO.getPassword(), userDAO.getTeam()));
		return new UserDAO(user);
	}

	private UserDAO convertToDAO(Users user) {
		return new UserDAO(user);
	}

	@Override
	public UserDAO delete(String id) {
		Users user = findUserById(id);
		repo.delete(user);
		return convertToDAO(user);
	}

	private Users findUserById(String id) {
		return repo.findOne(id);
	}

	@Override
	public List<UserDAO> findAll() {
		return repo.findAll().stream().map(this::daoConverter).collect(toList());
	}

	private UserDAO daoConverter(Users user) {
		return convertToDAO(user);
	}

	@Override
	public UserDAO findById(String id) {
		Users user = findUserById(id);
		return convertToDAO(user);
	}

	@Override
	public UserDAO update(UserDAO usersDao) {
		Users user = findUserById(usersDao.getId());
		user.update(usersDao);
		repo.save(user);
		return usersDao;
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	@Override
	public UserDAO findByUsername(String username) {
		Users user = repo.findByUsername(username);
		if (user != null) {
			return convertToDAO(user);
		}
		return null;
	}

	@Override
	public void delete(UserDAO usersDao) {
		Users user = findUserById(usersDao.getId());
		repo.delete(user);
	}

}
