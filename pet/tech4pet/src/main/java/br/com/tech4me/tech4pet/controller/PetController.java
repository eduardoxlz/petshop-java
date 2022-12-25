package br.com.tech4me.tech4pet.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4pet.model.Pet;
import br.com.tech4me.tech4pet.service.PetService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService servico;


@GetMapping
public ResponseEntity<List<Pet>> obterPets(){
    return  new ResponseEntity<>(servico.obterPets(),HttpStatus.OK);

    
}

@GetMapping("/{id}")
public ResponseEntity<Pet> obterPetPorId(@PathVariable String id){
    Optional<Pet> retorno = servico.obterPetPorId(id);

    if(retorno.isPresent()){
    return new ResponseEntity<>(retorno.get(),HttpStatus.FOUND);

    }else{

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    }



    @PostMapping
    public ResponseEntity<Pet> cadastrarpet(@RequestBody Pet pet){
        return new ResponseEntity<>(servico.cadastrarpet(pet), HttpStatus.CREATED);


    
}

    @DeleteMapping("/{id}")
        public ResponseEntity<Void> excluirPet(@PathVariable String id){
            servico.excluirPet(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);



        }

        @PutMapping("/{id}")
        public ResponseEntity<Pet> atualizarPet(@PathVariable String id, @RequestBody Pet pet){
            return new ResponseEntity<>(servico.atualizarPetPorId(id,pet), HttpStatus.ACCEPTED);

                


        }



    }


