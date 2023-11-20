package com.example.demo.Controlador;

import com.example.demo.entidades.Autor;
import com.example.demo.repositorios.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista")

public class AutorController {
    @Autowired
    AutorRepository autorRepository;

    //LEER
    /*
    @GetMapping("/autores")
    public  String autor(Model model){

        List <Autor> autores=autorRepository.findAll() ;
        model.addAttribute("autores", autores);
        return "autor/autor";
    }

     */


    @GetMapping("/autores2")
    public  List <Autor> autores (){

        List <Autor> autores=autorRepository.findAll() ;
        return autorRepository.findAll();
    }

    @PostMapping("/autores2")
    public Autor crear(@RequestBody Autor autor){
     return autorRepository.save(autor);
    }


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

     */
}
