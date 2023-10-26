package com.cibertec.models;

import java.util.*;

public class Carrito{
    private List<Productos> productosEnCarrito = new ArrayList<>();

    public List<Productos> getProductosEnCarrito() {
        return productosEnCarrito;
    }

    public void agregarProducto(Productos producto) {
        productosEnCarrito.add(producto);
    }

    public void vaciarCarrito() {
        productosEnCarrito.clear();
    }
}




