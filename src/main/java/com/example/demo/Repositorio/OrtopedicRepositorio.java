/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;


import com.example.demo.Interface.OrtopedicInterface;
import com.example.demo.Modelo.Ortopedic;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository

public class OrtopedicRepositorio {
    @Autowired
    private OrtopedicInterface ortopedicCrudRepository;
    
      public List<Ortopedic> getAll(){
        return (List<Ortopedic>) ortopedicCrudRepository.findAll();
    }
    
    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicCrudRepository.findById(id);
    }

    public Ortopedic save(Ortopedic ortopedic){
        return ortopedicCrudRepository.save(ortopedic);
    }
    
     public void delete(Ortopedic ortopedic){
         ortopedicCrudRepository.delete(ortopedic);
    }
    
     
    
}
