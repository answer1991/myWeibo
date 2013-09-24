package com.answer1991.service.aspect;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.answer1991.entity.User;

@Aspect
public class InitFollowAndFansCountAspect {
	private static final String QUERY_FANS_COUNT_SQL = "SELECT COUNT(user_id) FROM follow_and_fans WHERE user_id = ?1";
	private static final String QUERY_FOLLOWS_COUNT_SQL = "SELECT COUNT(fans_user_id) FROM follow_and_fans WHERE fans_user_id = ?1";
	
	@PersistenceContext
	private EntityManager em;
	
	@Pointcut("execution(com.answer1991.entity.User query*(..))")
	private void queryUser() { }
	
	@Pointcut("target(com.answer1991.service.ServiceFacade)")
	private void methodInService() { }
	
	@Pointcut("queryUser() && methodInService() ")
	private void queryUserInSerive(){
		
	}
	
	@AfterReturning(pointcut = "com.answer1991.service.aspect.InitFollowAndFansCountAspect.queryUserInSerive()", returning = "obj")
	public void afterQuery(Object obj) {
		User user = (User) obj;
		Long fansCount = (Long) em.createNativeQuery(QUERY_FANS_COUNT_SQL).setParameter(1, user.getId()).getSingleResult();
		Long followsCount = (Long) em.createNativeQuery(QUERY_FOLLOWS_COUNT_SQL).setParameter(1, user.getId()).getSingleResult();
		user.setFansCount(fansCount);
		user.setFollowsCount(followsCount);
	}
}
