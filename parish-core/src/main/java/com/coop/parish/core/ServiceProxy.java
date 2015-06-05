package com.coop.parish.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.BaseService;

public class ServiceProxy implements InvocationHandler{
	
	private Object obj = null;
	
	private EntityManager em = null;
	
	private ServiceProxy(Object obj){
		this.obj = obj;
	}
	
	public static Object newInstance(Object obj){
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), new ServiceProxy(obj));
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result;
		EntityTransaction tx = null;
		System.out.println("invoking method "+method.getName());
		try{
			BaseService bs  = (BaseService)obj;
			em = bs.getEm();
			tx = em.getTransaction();
			tx.begin();
			result = method.invoke(obj, args);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			if(e.getCause() instanceof ParishException){
				throw new ParishException(e.getCause().getMessage());
			}
			throw new Exception(e.getMessage());
		}finally{
			if(em != null){
				em.clear();
				em.close();
			}
		}
		System.out.println("got result from method "+method.getName());
		return result;
	}
}
