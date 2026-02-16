package com.co.solid.after.service;

public class PagoConTarjetaAfter extends PagoAfter {

    @Override
    public void pagar(){
        System.out.println("Pago siendo procesado con tarjeta...");
    }

    @Override
    public void generarFactura(){
        System.out.println("Factura siendo generada por pago con tarjeta...");
    }

}
