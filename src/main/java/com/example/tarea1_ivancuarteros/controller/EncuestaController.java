package com.example.tarea1_ivancuarteros.controller;


import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.example.tarea1_ivancuarteros.entity.Encuesta;
import com.example.tarea1_ivancuarteros.repository.EncuestaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class EncuestaController {

    private EncuestaRepository encuestaRepository;
    public EncuestaController(EncuestaRepository repository) {
        this.encuestaRepository = repository;
    }

    @GetMapping("/encuestas")
    public String findAll(Model model) {
        List<Encuesta> encuestas = this.encuestaRepository.findAll();
        model.addAttribute("encuestas", encuestas);
        return "encuesta-list";
    }

    @GetMapping("/encuestas/add")
    public String add(Model model) {
        List<Encuesta> encuestas = this.encuestaRepository.findAll();
        Encuesta e1 = new Encuesta(null, "Iván", "Cuarteros Adrián", "ivan333ee333@gmail.com", 19, "680579162", LocalDate.now(), "Trabajo", "Restaurante", "Satisfecho", "Muy buen servicio");
        Encuesta e2 = new Encuesta(null, "Javier", "Fernandez Martinez", "martinezfernandez@gmail.com", 19, "655896325", LocalDate.now(), "Vacaciones", "Piscina", "Muy satisfecho", "El mejor sitio de vacaciones");
        encuestas.add(e1);
        encuestas.add(e2);
        model.addAttribute("encuestas", encuestas);
        this.encuestaRepository.saveAll(encuestas);
        return "redirect:/encuestas";
    }

    @GetMapping("/encuestas/new")
    public String newEncuesta(Model model) {
        model.addAttribute("encuesta", new Encuesta());
        return "encuesta-new";
    }

    @PostMapping("/encuestas/new")
    public String newEncuestaInsert(@Valid Encuesta encuesta, BindingResult result) {
        if (result.hasErrors()) {
            return "encuesta-new";


        }
        encuestaRepository.save(encuesta);
        return "redirect:/encuestas";
    }
    @GetMapping("/encuestas/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        //Obtenemos el producto de la BD a partir del id de la barra de direcciones
        Optional<Encuesta> encuesta = encuestaRepository.findById(id);
        if (encuesta.isPresent()) {
            //Mandamos el producto a la vista
            model.addAttribute("encuesta", encuesta.get());
            return "encuesta-view";
        } else {
            return "redirect:/encuestas";
        }
    }
    @GetMapping("/encuestas/edit/{id}")
    public String editEncuesta(@PathVariable Long id, Model model){
        Optional<Encuesta> encuesta = encuestaRepository.findById(id);
        if(encuesta.isPresent()){
            //Pasamos el objeto a la vista
            model.addAttribute("encuesta",encuesta.get());
            return "encuesta-edit";
        }

        return "redirect:/encuestas";
    }

    @PostMapping("/encuestas/edit/{id}")
    public String editEncuestaUpdate(@PathVariable Long id, Encuesta encuesta){
        encuesta.setId(id);
        encuestaRepository.save(encuesta);
        return "redirect:/encuestas";
    }

    @GetMapping("/encuestas/del/{id}")
    public String delEncuesta(@PathVariable Long id, Model model) {
        Optional<Encuesta> encuesta = encuestaRepository.findById(id);
        if(encuesta.isPresent()){
            encuestaRepository.deleteById(id);
        }
        return "redirect:/encuestas";

    }
}
