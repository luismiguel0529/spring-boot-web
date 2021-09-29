package com.springbookbackendapirest.controller;

import com.springbookbackendapirest.models.Cliente;
import com.springbookbackendapirest.service.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteController {

    private IClienteService iClienteService;

    public ClienteController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }

    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> getClientes(){
        return iClienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente getCliente(@PathVariable Long id){
        return iClienteService.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return iClienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente clienteBD = iClienteService.findById(id);
        clienteBD.setNombre(cliente.getNombre());
        clienteBD.setApellido(cliente.getApellido());
        clienteBD.setEmail(cliente.getEmail());
        return iClienteService.save(clienteBD);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Long id){
        iClienteService.delete(id);
    }
}
