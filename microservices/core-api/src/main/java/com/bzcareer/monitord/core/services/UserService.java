package com.bzcareer.monitord.core.services;

import java.util.List;

import com.bzcareer.monitord.core.model.UserDAO;

public interface UserService {

	interface ValidationRules {
		int max();

		int min();
	}

	// Validation Rules. Plan on moving this somewhere else but for here its
	// here.
	enum ValidUser implements ValidationRules {
		USERNAME {
			public int max() {
				return 20;
			}

			public int min() {
				return 5;
			}
		},
		PASSWORD {
			public int max() {
				return 10;
			}

			public int min() {
				return 5;
			}
		};
	}

	UserDAO create(UserDAO user);

	UserDAO delete(String id);

	List<UserDAO> findAll();

	UserDAO findById(String id);

	UserDAO update(UserDAO users);

	void deleteAll();
	
	UserDAO findByUsername(String username);
	void delete(UserDAO users);

}
