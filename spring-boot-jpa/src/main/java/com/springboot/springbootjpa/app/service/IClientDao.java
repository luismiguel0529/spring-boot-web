package com.springboot.springbootjpa.app.service;

import com.springboot.springbootjpa.app.models.Client;

import java.util.List;

public interface IClientDao {

    public List<Client> findAll();

    public void save(Client client);
}
