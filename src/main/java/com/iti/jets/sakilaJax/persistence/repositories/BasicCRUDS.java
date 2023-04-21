package com.iti.jets.sakilaJax.persistence.repositories;

import com.iti.jets.sakilaJax.util.RequestThreadLocal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BasicCRUDS<T> {
    private final Class<T> entityClass;
    public BasicCRUDS(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T findById (Object id){
        System.out.printf("finding By id: "+id);
        EntityManager entityManager = RequestThreadLocal.getInstance().get();
        return entityManager.find(entityClass,id);
    }

    public List<T> findAllPaged(int offset, int limit){
        EntityManager entityManager = RequestThreadLocal.getInstance().get();
        String query = "from "+entityClass.getName()+" t";
        TypedQuery<T> typedQuery = entityManager.createQuery(query, entityClass);
        typedQuery.setFirstResult(offset);
        typedQuery.setMaxResults(limit);
        return typedQuery.getResultList();
    }

    public T updateOrInsertEntityById(T updatedEntity){
        EntityManager entityManager = RequestThreadLocal.getInstance().get();
        entityManager.getTransaction().begin();
        entityManager.merge(updatedEntity);
        entityManager.getTransaction().commit();
        return updatedEntity;
    }

    public Boolean deleteEntityById(Object id){
        EntityManager entityManager = RequestThreadLocal.getInstance().get();
        if(findById(id)==null)return false;
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(findById(id));
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            return false;
        }

        return true;
    }

}
