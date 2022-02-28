package org.senai.devinhouse.m1s09.controller;

import org.senai.devinhouse.m1s09.model.Cliente;
import org.senai.devinhouse.m1s09.service.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private CrudService<Cliente> clienteService;

    public ClienteController(CrudService<Cliente> clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(produces="application/json")
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.ok().body(clienteService.get());
    }

    @GetMapping(produces="application/json", path = "/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable int id){
        return ResponseEntity.ok().body(clienteService.findById(id));
    }

    @PostMapping(produces="application/json", consumes = "application/json")
    public ResponseEntity<String> postCliente(
            @RequestBody @Validated @Valid Cliente cliente,
            UriComponentsBuilder uriBuilder){
        URI uri = uriBuilder.path("/cliente/").buildAndExpand(cliente).toUri();
        System.out.println(uri);
        return ResponseEntity.created(uri).body("\"id:\"" + clienteService.save(cliente));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> putCliente(
            @PathVariable int id, @RequestBody @Validated Cliente cliente,
            UriComponentsBuilder uriBuilder){
        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(id).toUri();
        System.out.println(uri);
        return ResponseEntity.ok().body(clienteService.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCurso(@PathVariable int id, UriComponentsBuilder uriBuilder){
        URI uri = uriBuilder.path("/curso/{id}").buildAndExpand(id).toUri();
        System.out.println(uri);
        return ResponseEntity.ok().body(clienteService.delete(id));
    }

//    @GetMapping("/{nome}")
//    public Cliente cliente(@PathVariable String nome){
//        return new Cliente(1 ,nome, "000.000.000-00");
//    }
}
