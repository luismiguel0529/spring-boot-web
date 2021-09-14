package com.springboot.springbootjpa.app.repository;

import com.springboot.springbootjpa.app.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface IClientDaoRepository extends CrudRepository<Client, Long> {

}
