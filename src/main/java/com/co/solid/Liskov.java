ackage com.co.solid;

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
 *///////////////////////////////////// Principio de Liskov - Después de la aplicación
 */

abstract class Empleado {

    public abstract void reportarHorasTrabajadas();
}

class Administrador extends Empleado {

    @Override
    public void reportarHorasTrabajadas() {
        System.out.println("Reportando horas trabajadas del administrador...");
    }

    public void generarReporteFinanciero() {
        System.out.println("Generando reporte financiero del sistema...");
    }
}

class Domiciliario extends Empleado {

    @Override
    public void reportarHorasTrabajadas() {
        System.out.println("Reportando horas trabajadas del domiciliario...");
    }
}
class Main {

    public static void main(String[] args) {

        Empleado admin = new Administrador();
        admin.reportarHorasTrabajadas();

        Empleado domi = new Domiciliario();
        domi.reportarHorasTrabajadas();
    }
}


//////////////////////////////////////////////combinacion liskov e isp/////////////////////////////////////////////

// ISP: interfaz base pequeña
interface EmpleadoI {
    void reportarHorasTrabajadas();
}
// ISP: interfaz especializada
interface EmpleadoAdministrativoI extends EmpleadoI {
    void generarReporte();
}
// Clase base opcional para comportamiento común 
abstract class EmpleadoBase implements EmpleadoI {

    protected String nombre;

    public EmpleadoBase(String nombre) {
        this.nombre = nombre;
    }
}
// Administrador cumple completamente su contrato
class Admin extends EmpleadoBase implements EmpleadoAdministrativoI {

    public Admin(String nombre) {
        super(nombre);
    }

    @Override
    public void reportarHorasTrabajadas() {
        System.out.println(nombre + " reporta horas como administrador.");
    }

    @Override
    public void generarReporte() {
        System.out.println(nombre + " genera reporte financiero.");
    }
}
// Domiciliario solo implementa lo que realmente puede hacer
class Domiciliario extends EmpleadoBase {

    public Domiciliario(String nombre) {
        super(nombre);
    }

    @Override
    public void reportarHorasTrabajadas() {
        System.out.println(nombre + " reporta horas como domiciliario.");
    }
}
class Main {

    public static void main(String[] args) {

        EmpleadoAdministrativoI admin = new Admin("Carlos");
        admin.reportarHorasTrabajadas();
        admin.generarReporte();

        EmpleadoI domi = new Domiciliario("Luis");
        domi.reportarHorasTrabajadas();
    }
}



