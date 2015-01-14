/**
 * 
 */
package com.github.popemay.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.popemay.repository.model.User;

/**
 * @author meimeidong
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class UserRepositoryTest {
	@Autowired
	@Qualifier("oracleRepository")
	private IUserRepository oracleRepository;

	@Test
	public void shouldFindUser() {
		User user = oracleRepository.find("a@a.com");
		Assert.assertNull(user);
	}
}
