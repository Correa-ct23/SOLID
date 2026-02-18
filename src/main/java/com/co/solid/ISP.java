package com.co.solid;

/**
 * Sistema de empleados en app de domicilios
 * Principio de segregación de interfaces - Antes de la aplicación
 */

interface EmpleadoI {

    void tomarPedido();
    void cocinar();
    void entregarPedido();
    void generarReporte();
}

/**
 * Violación de ISP
 */

class Cocinero implements EmpleadoI {

    @Override
    public void tomarPedido() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando pedido...");
    }

    @Override
    public void entregarPedido() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void generarReporte() {
        throw new UnsupportedOperationException();
    }
}

/**
 * Sistema de empleados en app de domicilios
 * Principio de segregación de interfaces - Después de la aplicación
 */

interface TomadorPedidoI {
    void tomarPedido();
}

interface CocineroI {
    void cocinar();
}

interface RepartidorI {
    void entregarPedido();
}

interface ReportadorI {
    void generarReporte();
}

class Cocinero implements CocineroI {

    @Override
    public void cocinar() {
        System.out.println("Cocinando pedido...");
    }
}

class Domiciliario implements RepartidorI {

    @Override
    public void entregarPedido() {
        System.out.println("Entregando pedido al cliente...");
    }
}

class Administrador implements ReportadorI {

    @Override
    public void generarReporte() {
        System.out.println("Generando reporte general...");
    }
}