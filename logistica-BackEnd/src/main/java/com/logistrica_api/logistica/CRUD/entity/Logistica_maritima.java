package com.logistrica_api.logistica.CRUD.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

@Data
@Document(collection = "maritima")
public class Logistica_maritima {
    @Id
    private int id;
    private String tipoProducto;
    private int cantidadProducto;
    private LocalDate fechaRegistro;
    private LocalDate fechaEntrega;
    private String puertoEntrega;
    private int precio;
    @Pattern(regexp = "^[A-Z]{3}[0-9]{4}[A-Z]{1}$")
    private String numeroFlota;
    @Pattern(regexp = "^[A-Z]{3}[0-9]{5}[A-Z]{2}$")
    private String numeroGuia;
    private double descuento;
    private double precioDescuento;

    public Logistica_maritima() {}

    public Logistica_maritima(int id, String tipoProducto, int cantidadProducto,
                              LocalDate fechaRegistro, LocalDate fechaEntrega, String puertoEntrega, int precio,
                              String numeroFlota, String numeroGuia, double descuento, double precioDescuento) {
        this.id = id;
        this.tipoProducto = tipoProducto;
        this.cantidadProducto = cantidadProducto;
        this.fechaRegistro = fechaRegistro;
        this.fechaEntrega = fechaEntrega;
        this.puertoEntrega = puertoEntrega;
        this.precio = precio;
        this.numeroFlota = numeroFlota;
        this.numeroGuia = numero_guia();
        this.descuento = descuento();
        this.precioDescuento = precioDescuento();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getPuertoEntrega() { return  puertoEntrega; }

    public void setPuertoEntrega(String puertoEntrega){ this.puertoEntrega = puertoEntrega; }
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNumeroFlota() {
        return numeroFlota;
    }

    public void setNumeroFlota(String numeroFlota) {
        this.numeroFlota = numeroFlota;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numero_guia();
    }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento(); }
    public double getPrecioDescuento() { return precioDescuento; }
    public void setPrecioDescuento() { this.precioDescuento = precioDescuento(); }

    // Private Method

    private double descuento(){
        if(cantidadProducto >= 10){
            return descuento = 0.03;
        }else{
            return descuento = 0.0;
        }
    }

    private double precioDescuento(){
        return precio - (precio * descuento());
    }
    private String numero_guia(){
        StringBuilder n_guia = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++){
            char character = (char) (random.nextInt(26) + 'A');
            n_guia.append(character);
        }
        for (int i = 0; i < 5; i++){
            n_guia.append(random.nextInt(10));
        }
        for (int i = 0; i < 2; i++){
            char character = (char) (random.nextInt(26)+ 'A');
            n_guia.append(character);
        }
        return n_guia.toString();
    }
}
