package com.co.solid.before.service;

public class PagoGratisBefore extends PagoBefore {

    @Override
    public void pagar(){
        throw new UnsupportedOperationException("No se puede pagar");
    }

    @Override
    public void generarFactura() {
        System.out.println("Generando factura de pago por tarjeta...");
    }
}
