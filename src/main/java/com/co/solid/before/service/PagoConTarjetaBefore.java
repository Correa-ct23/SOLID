package com.co.solid.before.service;

public class PagoConTarjetaBefore extends PagoBefore {

    @Override
    public void pagar(){
        System.out.println("Pago siendo procesado con tarjeta...");
    }

    @Override
    public void generarFactura() {
        System.out.println("Generando factura de pago por tarjeta...");
    }
}
