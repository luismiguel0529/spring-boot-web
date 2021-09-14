package com.springboot.springbootjpa.app.service;

import com.springboot.springbootjpa.app.models.Client;

import java.util.List;

public interface IClientService {

    public List<Client> findAll();

    public void save(Client client);

    public Client findById(Long id);

    public void delete(Long id);
}
