package com.springbookbackendapirest.dao;

import com.springbookbackendapirest.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long>
{
}
