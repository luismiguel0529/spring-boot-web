//package com.springboot.springbootjpa.app.service;
//
//import com.springboot.springbootjpa.app.models.Client;
//import com.springboot.springbootjpa.app.repository.IClientDaoRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Repository
//public class ClientImplRepository implements IClientDaoRepository {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @SuppressWarnings("unchecked")
//    @Transactional(readOnly = true)
//    @Override
//    public List<Client> findAll() {
//        return em.createQuery("from Client").getResultList();
//    }
//
//    @Override
//    @Transactional
//    public void save(Client client) {
//        if (client.getId() != null && client.getId() > 0){
//            em.merge(client);
//        } else {
//            em.persist(client);
//        }
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Client findById(Long id) {
//        return em.find(Client.class,id);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Long id) {
//        em.remove(findById(id));
//    }
//}
