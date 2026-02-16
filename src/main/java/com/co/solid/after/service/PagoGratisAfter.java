package com.co.solid.after.service;

public class PagoGratisAfter extends PagoAfter {

    @Override
    public void pagar() {
        System.out.println("No requiere pago");
    }

    @Override
    public void generarFactura(){
        System.out.println("Factura siendo generada por pago gratis...");
    }
}
