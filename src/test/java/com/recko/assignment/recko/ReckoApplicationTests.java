package com.recko.assignment.recko;

import com.recko.assignment.recko.bean.ReckoHibernateConfiguration;
import com.recko.assignment.recko.entity.Post;
import com.recko.assignment.recko.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.provider.HibernateUtils;

@SpringBootTest
class ReckoApplicationTests {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session = sessionFactory.openSession();

	@Test
	void testUserAddPost() {

		User user = new User("aditya", "123");
		Post post = new Post("This is content in Post Test");

		user.getPosts().add(post);
		session.persist(user);
	}

}
