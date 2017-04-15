	/**
 * 
 */
package com.aka.crud.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aka.crud.model.User;
import com.aka.crud.repository.UserRepository;

/**
 * @author jibanezg
 *
 */
@Service
@Transactional
public class DefaultUserService implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	public DefaultUserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	/* (non-Javadoc)
	 * @see com.aka.crud.service.CRUDService#getAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.aka.crud.service.CRUDService#get(java.io.Serializable)
	 */
	@Transactional(readOnly = true)
	@Override
	public User get(Serializable id) {
		return userRepository.findOne((Long)id);
	}

	/* (non-Javadoc)
	 * @see com.aka.crud.service.CRUDService#create(java.lang.Object)
	 */
	@Override
	public User create(User entity) {
		return userRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.aka.crud.service.CRUDService#update(java.lang.Object)
	 */
	@Override
	public User update(User entity) {
		return userRepository.saveAndFlush(entity);
	}

	/* (non-Javadoc)
	 * @see com.aka.crud.service.CRUDService#remove(java.io.Serializable)
	 */
	@Override
	public void remove(Serializable id) {
		userRepository.delete((Long)id);

	}

}
