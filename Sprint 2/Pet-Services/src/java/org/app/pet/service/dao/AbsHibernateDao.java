package org.app.pet.service.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbsHibernateDao<T extends Serializable> {

	private Class<T> classT;
	
	@Autowired
	public HibernateTemplate  hibernateTemplate;
			
	public Class<T> getClassT() {
		return classT;
	}

	public void setClassT(Class<T> classT) {
		this.classT = classT;
	}
	
	@SuppressWarnings("unchecked")
	public  T findByColumns(final String primaryCol, String id) {		
		if(id != null) { 
			List<Object> listObj = hibernateTemplate.find("from "+ classT.getName() + " where "+ primaryCol + " =? ",id);
			if(listObj != null && listObj.size() > 0) {
				return ((T) listObj.get(0));
			}
		}
        return null;
	}


	@SuppressWarnings("unchecked")
	public  T findById(final String primaryCol, final long id) {
		List<Object> listObj = hibernateTemplate.find("from "+ classT.getName() + " where "+ primaryCol + " =? ",id);		
		T item = null;
		if(listObj != null && listObj.size() > 0) {
			return ((T) listObj.get(0));
		}
        return item;
	}
	
	public List<Object> findAll() {		
		List<Object> listObj = hibernateTemplate.find("from " + classT.getName());
		return listObj;
	}
	
	public void create(final T item) {
		
		hibernateTemplate.save(item);
	}
	
	public T update(final T item) {		
		hibernateTemplate.update(item);
		return item;
	}
	
	public void delete(final T item) {
		hibernateTemplate.delete(item);
	}
	
	public void deleteById(final String primaryCol, final long id) {
		final T item = findById(primaryCol, id);
		delete(item);
	}
	
/*	@Transactional
    public void register(Class<T> classT) {
        // Save employee
        this.entityManager.persist(classT);
    }
*/}
