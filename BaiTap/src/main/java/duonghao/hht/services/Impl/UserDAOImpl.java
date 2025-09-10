package duonghao.hht.services.Impl;

import duonghao.hht.config.JPAConfig;
import duonghao.hht.entity.User;
import duonghao.hht.services.IUserDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserDAOImpl implements IUserDAO{

	@Override
	public User findByUserNameAndPassword(String Username, String Password) {
		EntityManager enma = JPAConfig.getEntityManager();
		try {
			String jpql = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
			TypedQuery<User> query = enma.createQuery(jpql, User.class);
			query.setParameter("username", Username);
            query.setParameter("password", Password);
            return query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally {
			enma.close();
		}
		
	}

}
