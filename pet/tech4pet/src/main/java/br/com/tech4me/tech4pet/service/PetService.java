package br.com.tech4me.tech4pet.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4pet.model.Pet;

public interface PetService {

    List<Pet>obterPets();
    Optional<Pet>obterPetPorId(String id);
    Pet cadastrarpet(Pet pet);
    void excluirPet(String id);
    Pet atualizarPetPorId(String id, Pet pet);
    
    

    
}
