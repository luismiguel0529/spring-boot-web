package com.springbookbackendapirest.controller;

import com.springbookbackendapirest.models.Cliente;
import com.springbookbackendapirest.service.IClienteService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> getCliente(@PathVariable Long id){
        Cliente cliente;
        Map<String, Object> response = new HashMap<>();
        try {
            cliente = iClienteService.findById(id);
        } catch (DataAccessException e){
            response.put("mensaje","Error al realizar la consulta en la BD");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>( response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (cliente == null){
            response.put("mensaje","Usuario con id: ".concat(id.toString()).concat(" no encontrado"));
            return new ResponseEntity<Map<String, Object>>( response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveCliente(@Valid @RequestBody Cliente cliente, BindingResult result){

        Cliente clienteNew = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()){
            List<String> errors = new ArrayList<>();
            result.getFieldErrors().forEach(fieldError -> errors.add("El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage()));
            response.put("errors",errors);
            errors.forEach(System.out::println);
            return new ResponseEntity<Map<String, Object>>( response, HttpStatus.BAD_REQUEST);
        }
        try {
            clienteNew = iClienteService.save(cliente);
        } catch (DataAccessException e){
            response.put("mensaje","Error al realizar la insercion en la BD");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>( response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","El cliente ha sido creado con éxito");
        response.put("cliente", clienteNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente clienteBD = iClienteService.findById(id);
        Map<String, Object> response = new HashMap<>();
        if (clienteBD == null){
            response.put("mensaje","Error no se pudo actualizar el cliente");
            return new ResponseEntity<Map<String, Object>>( response, HttpStatus.NOT_FOUND);
        }

        Cliente clienteUpdate;
        try {
            clienteBD.setNombre(cliente.getNombre());
            clienteBD.setApellido(cliente.getApellido());
            clienteBD.setEmail(cliente.getEmail());
            clienteBD.setCreateAt(cliente.getCreateAt());

            clienteUpdate = iClienteService.save(clienteBD);

        } catch (DataAccessException e){
            response.put("mensaje","Error al actualizar el cliente en la BD");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>( response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","El cliente ha sido actualizado con éxito");
        response.put("cliente", clienteUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteCliente(@PathVariable Long id){

        Map<String, Object> response = new HashMap<>();
        try {
            iClienteService.delete(id);
        } catch (DataAccessException e){
            response.put("mensaje","Error al eliminar el cliente de la BD");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>( response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Cliente eliminado con éxito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
