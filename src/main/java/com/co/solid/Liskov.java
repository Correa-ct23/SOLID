package com.co.solid;

/**
 * Sistema de empleados en app de domicilios
 * Principio de Liskov - Antes de la aplicación
 */

class Empleado {

    public void reportarHorasTrabajadas() {
        System.out.println("Reportando Horas Trabajadas...");
    }

    public void generarReporte() {
        System.out.println("Generando reporte general...");
    }
}

class Administrador extends Empleado {

    @Override
    public void reportarHorasTrabajadas() {
        System.out.println("Reportando horas trabajadas del administrador...");
    }

    @Override
    public void generarReporte() {
        System.out.println("Generando reporte financiero del sistema...");
    }
}

class Domiciliario extends Empleado {

    @Override
    public void reportarHorasTrabajadas() {
        System.out.println("Reportando horas trabajadas del domiciliario...");
    }

    @Override
    public void generarReporte() {
        throw new UnsupportedOperationException("El domiciliario no genera reportes");
    }
}

/**
 * Violación de liskov
 */

class Main {

    public static void main(String[] args) {

        Empleado admin  = new Administrador();
        admin.reportarHorasTrabajadas();
        admin.generarReporte();

        Empleado domiciliario = new Domiciliario();
        admin.reportarHorasTrabajadas();
        domiciliario.generarReporte();
    }
}

/**
 * Principio de Liskov - Después de la aplicación
 */

interface EmpleadoI {
    void reportarHorasTrabajadas();
}

interface EmpleadoAdministrativoI  extends EmpleadoI {
    void generarReporte();
}

class Admin implements EmpleadoAdministrativoI  {

    @Override
    public void reportarHorasTrabajadas() {
        System.out.println("Reportando horas trabajadas del administrador...");
    }

    @Override
    public void generarReporte() {
        System.out.println("Generando reporte financiero del sistema...");
    }
}

class Domiciliarioo implements EmpleadoI {

    @Override
    public void reportarHorasTrabajadas() {
        System.out.println("Reportando horas trabajadas del administrador...");
    }

}

/**
 * Cumplimiento de liskov
 */
class Main {

    public static void main(String[] args) {

        EmpleadoAdministrativoI admin = new Admin();
        admin.reportarHorasTrabajadas();
        admin.generarReporte();

        EmpleadoI domi = new Domiciliarioo();
        domi.reportarHorasTrabajadas();
    }
}
