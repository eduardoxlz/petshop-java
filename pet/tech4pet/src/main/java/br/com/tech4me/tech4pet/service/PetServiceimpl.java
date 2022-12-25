package br.com.tech4me.tech4pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4pet.model.Pet;
import br.com.tech4me.tech4pet.repository.PetRepository;

@Service
public class PetServiceimpl implements PetService {
    @Autowired
    private PetRepository repositorio;

    @Override
    public List<Pet> obterPets() {
        return repositorio.findAll();
    }

    @Override
    public Pet cadastrarpet(Pet pet) {
        return repositorio.save(pet);
    }

    @Override
    public void excluirPet(String id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public Pet atualizarPetPorId(String id,Pet pet){
        pet.setId(id);
    return repositorio.save(pet);
    }

    @Override
    public Optional<Pet> obterPetPorId(String id){
        return repositorio.findById(id);
    }
    

}