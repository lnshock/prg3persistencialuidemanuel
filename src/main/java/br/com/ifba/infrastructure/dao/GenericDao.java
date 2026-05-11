/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

/**
 *
 * @author LUID1.7
 */
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.lang.reflect.ParameterizedType;

public abstract class GenericDao<T> implements GenericIDao<T> {
    
    protected static EntityManager entityManager;
    private final Class<T> persistentClass;

    // Inicializa a conexão com o banco de dados
    static {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gerenciamento_curso");
        entityManager = factory.createEntityManager();
    }

    public GenericDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public T update(T entity) {
        entityManager.getTransaction().begin();
        T updated = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return updated;
    }

    @Override
    public void delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(entity));
        entityManager.getTransaction().commit();
    }
    // Retorna todos os registros da entidade específica
    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from " + persistentClass.getName()).getResultList();
    }
    // Busca um registro pelo ID
    @Override
    public T findById(Long id) {
        return entityManager.find(persistentClass, id);
    }
}