package com.logistrica_api.logistica.CRUD.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;


@Data
@Document(collection = "terrestre")
public class Logistica_Terrestre {
    @Id
    private int id;
    private String tipoProducto;
    private int cantidadProducto;
    private LocalDate fechaRegistro;
    private LocalDate fechaEntrega;
    private String bodegaEntrega;
    private int precio;
    @Pattern(regexp = "^[A-Z]{3}[0-9]{3}$")
    private String placaVehiculo;
    @Pattern(regexp = "^[A-Z]{2}[0-9]{6}[A-Z]{2}$")
    private String numeroGuia;
    private double descuento;
    private double precioDescuento;

    public Logistica_Terrestre() {}

    public Logistica_Terrestre(int id, String tipoProducto, int cantidadProducto,
                               LocalDate fechaRegistro, LocalDate fechaEntrega, String bodegaEntrega,
                               int precio, String placaVehiculo, String numeroGuia, double descuento, double precioDescuento) {
        this.id = id;
        this.tipoProducto = tipoProducto;
        this.cantidadProducto = cantidadProducto;
        this.fechaRegistro = fechaRegistro;
        this.fechaEntrega = fechaEntrega;
        this.bodegaEntrega = bodegaEntrega;
        this.precio = precio;
        this.placaVehiculo = placaVehiculo;
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

    public String getBodegaEntrega() {
        return bodegaEntrega;
    }

    public void setBodegaEntrega(String bodegaEntrega) {
        this.bodegaEntrega = bodegaEntrega;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
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

    // private methods

    private double descuento(){
        if(cantidadProducto > 10){
            return descuento = 0.05;
        }else{
            return descuento = 0.0;
        }
    }

    private double precioDescuento(){
        return precio - (precio * descuento());
    }
    private String numero_guia()
    {
        Random random = new Random();
        StringBuilder n_guia = new StringBuilder();

        for(int i = 0; i < 2; i++){
            char character = (char) (random.nextInt(26) + 'A');
            n_guia.append(character);
        }
        for (int i = 0; i < 6; i++){
            n_guia.append(Integer.toString(random.nextInt(10)));
        }
        for (int i = 0; i < 2; i++){
            char character = (char) (random.nextInt(26) + 'A');
            n_guia.append(character);
        }
        return n_guia.toString();
    }
}
