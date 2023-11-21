package com.example.demo.Controlador;

import com.example.demo.entidades.Autor;
import com.example.demo.repositorios.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lista")

public class AutorController {
    @Autowired
    AutorRepository autorRepository;


    /////LEER
    @GetMapping("/autores2")
    public  List <Autor> autores (){

        List <Autor> autores=autorRepository.findAll() ;
        return autorRepository.findAll();
    }

    ///CREAR
    @PostMapping("/autores2")
    public Autor crear(@RequestBody Autor autor){
        return autorRepository.save(autor);
    }

    //ELIMINAR
    @GetMapping("/autores2/{id}")
    public ResponseEntity<Boolean> eliminarAutor(@PathVariable int id) {
        Optional<Autor> autor = autorRepository.findById(id);
        autorRepository.delete(autor.get());
        return ResponseEntity.ok(true);
    }


//EDITAR

    @PutMapping("/autores2/{id}")
    public ResponseEntity<Autor> updateUser(@PathVariable int id, @RequestBody Autor autorData){
        //En primer lugar, buscamos el Usuario
        Optional<Autor> autor = autorRepository.findById(id);

        //Usuario encontrado para realizar update sobre él.
        Autor autorActualizar = autor.get();

        //Copiamos los nuevos datos al usuario
        Autor autorActualiza;
        autorActualizar.copyDataFromUser(autorData);

        //Guadramos en la DB
        Autor userSaved = autorRepository.save(autorActualizar);
        return ResponseEntity.ok(userSaved);


    }








    /*

      //LEER
    /*
    @GetMapping("/autores")
    public  String autor(Model model){

        List <Autor> autores=autorRepository.findAll() ;
        model.addAttribute("autores", autores);
        return "autor/autor";
    }


    ///EDITAR
    @PutMapping("/users/{id}")
    public ResponseEntity<Autor> updateUser(@PathVariable int id, @RequestBody Autor userUpdateData){
        //En primer lugar, buscamos el Usuario
        Optional<Autor> findUser = autorRepository.findById(id);

        //Si está presente lo devolvemos
        if(findUser.isPresent()){
            //Usuario encontrado para realizar update sobre él.
            Autor userToUpdate = findUser.get();
            //Copiamos los nuevos datos al usuario
            userToUpdate.copyDataFromUser(userUpdateData);
            //Guadramos en la DB
            Autor userSaved = autorRepository.save(userToUpdate);
            return ResponseEntity.ok(userSaved);
        }
        else {
            throw new NotFoundException("Not found User by id: " + id);
        }
    }
    */





/*
    //CREAR
    @GetMapping("/autor/form")
    public String formulario(Model model){
        model.addAttribute("autor", new Autor());


        return "autor/autorForm";
    }

    @PostMapping("autor/form")
    public String crear( Autor autor){
        autorRepository.save(autor);

        return "redirect:/autores";
    }

    /Eliminar
    @GetMapping("/libro/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        libroRepository.deleteById(id);
        return "redirect:/libros";
    }

    //editar


     */

}
