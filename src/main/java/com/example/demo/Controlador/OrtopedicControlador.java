/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import java.util.List;
import java.util.Optional;

import com.example.demo.Modelo.Ortopedic;
import com.example.demo.Servicio.OrtopedicServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Ortopedic")
@CrossOrigin(origins = "*")

public class OrtopedicControlador {
     @Autowired
    private OrtopedicServicio ortopedicService;
    @GetMapping("/all")
    public List<Ortopedic> getOrtopedics(){
        return ortopedicService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Ortopedic> getOrtopedic(@PathVariable("id") int ortopedicId) {
        return ortopedicService.getOrtopedic(ortopedicId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic save(@RequestBody Ortopedic ortopedic) {
        return ortopedicService.save(ortopedic);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic update(@RequestBody Ortopedic ortopedic) {
        return ortopedicService.update(ortopedic);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return ortopedicService.deleteOrtopedic(id);
    }
    
  
}
