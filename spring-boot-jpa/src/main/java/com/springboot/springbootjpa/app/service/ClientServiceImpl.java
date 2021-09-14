package com.springboot.springbootjpa.app.service;

import com.springboot.springbootjpa.app.models.Client;
import com.springboot.springbootjpa.app.repository.IClientDaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService{

    private IClientDaoRepository iClientDao;

    public ClientServiceImpl(IClientDaoRepository iClientDao) {
        this.iClientDao = iClientDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return (List<Client>) iClientDao.findAll();
    }

    @Override
    @Transactional
    public void save(Client client) {
        iClientDao.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return iClientDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iClientDao.deleteById(id);
    }
}
