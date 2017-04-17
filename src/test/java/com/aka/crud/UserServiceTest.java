package com.aka.crud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aka.crud.model.User;
import com.aka.crud.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void createUserSuccessfuly() throws Exception {

		User user = new User();
		user.setName("Carlos");
		SimpleDateFormat formaDate = new SimpleDateFormat("dd/MM/yyyy");
		user.setBirthday((Date) formaDate.parse("30/04/1975"));
		userService.create(user);

		assertEquals("Carlos", user.getName());
		assertNotNull(user.getId());

	}

	@Test
	public void removeUserSuccessfuly() throws Exception {
		
		User user = new User();
		user.setName("Carlos");
		SimpleDateFormat formaDate = new SimpleDateFormat("dd/MM/yyyy");
		user.setBirthday((Date) formaDate.parse("30/04/1975"));
		userService.create(user);
		
		assertNotNull(user.getId());
		userService.remove(user.getId());
		
		assertTrue(userService.get(user.getId())==null);

	}

	@Test
	public void updateUserSuccessfuly() throws Exception {

		User user = new User();
		user.setName("Carlos");
		SimpleDateFormat formaDate = new SimpleDateFormat("dd/MM/yyyy");
		user.setBirthday((Date) formaDate.parse("30/04/1975"));
		userService.create(user);

		assertEquals("Carlos", user.getName());
		assertNotNull(user.getId());

		user.setName("Jose Carlos");
		userService.update(user);
		assertEquals("Jose Carlos", user.getName());

	}

	@Test
	public void getAllUserSuccessfuly() throws Exception {


		User user = new User();
		user.setName("Carlos");
		SimpleDateFormat formaDate = new SimpleDateFormat("dd/MM/yyyy");
		user.setBirthday((Date) formaDate.parse("30/04/1975"));
		userService.create(user);

		user = new User();
		user.setName("Pedro");
		formaDate = new SimpleDateFormat("dd/MM/yyyy");
		user.setBirthday((Date) formaDate.parse("01/05/1973"));
		userService.create(user);

		assertTrue(userService.getAll().size() == 2);

	}

}
