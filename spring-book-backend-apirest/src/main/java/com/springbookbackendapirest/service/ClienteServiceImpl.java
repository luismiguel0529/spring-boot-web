package com.springbookbackendapirest.service;

import com.springbookbackendapirest.dao.IClienteDao;
import com.springbookbackendapirest.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    private IClienteDao iClienteDao;

    public ClienteServiceImpl(IClienteDao iClienteDao) {
        this.iClienteDao = iClienteDao;
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) iClienteDao.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return iClienteDao.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return iClienteDao.save(cliente);
    }

    @Override
    public void delete(Long id) {
        iClienteDao.deleteById(id);
    }
}
