package org.app.pet.service.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

/**
 * Entity for JPA
 * @author ravelu
 *
 * @param <T>
 */
public abstract class AbstractEntityDao<T extends Serializable> {

	private Class<T> classT;
	
	@PersistenceContext
	private EntityManager entityManager;
			
	public Class<T> getClassT() {
		return classT;
	}

	public void setClassT(Class<T> classT) {
		this.classT = classT;
	}

	public T findById(final long id) {
		return entityManager.find(classT, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {		
		return entityManager.createQuery("from " + classT.getName()).getResultList();
	}
	
	public void create(final T item) {
		entityManager.persist(item);
	}
	
	public T update(final T item) {		
		return entityManager.merge(item);
	}
	
	public void delete(final T item) {
		entityManager.remove(item);
	}
	
	public void deleteById(final long id) {
		final T item = findById(id);
		delete(item);
	}
	
	@Transactional
    public void register(Class<T> classT) {
        // Save employee
        this.entityManager.persist(classT);
    }

}
