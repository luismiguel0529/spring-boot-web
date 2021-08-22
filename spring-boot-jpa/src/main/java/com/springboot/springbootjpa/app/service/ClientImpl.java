package com.springboot.springbootjpa.app.service;

import com.springboot.springbootjpa.app.models.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClientImpl implements IClientDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Client> findAll() {
        return em.createQuery("from Client").getResultList();
    }

    @Override
    @Transactional
    public void save(Client client) {
        em.persist(client);
    }
}
