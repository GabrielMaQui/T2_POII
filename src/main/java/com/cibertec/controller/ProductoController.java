package com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cibertec.models.*;
import com.cibertec.repository.*;
import java.util.List;

@Controller
public class ProductoController {
    private final IProductosRepositorio productoRepository;

    public ProductoController(IProductosRepositorio productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping("/Catalogo")
    public String verCatalogo(Model model) {
        List<Productos> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "catalogo"; 
    }
    
}
