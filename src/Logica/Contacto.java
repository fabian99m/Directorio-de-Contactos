package Logica;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Contacto implements Comparable {

    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private Contacto izquierda;
    private Contacto derecha;

    public Contacto() {
    }

    public Contacto(String nombre, String direccion, String telefono, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Contacto getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Contacto izquierda) {
        this.izquierda = izquierda;
    }

    public Contacto getDerecha() {
        return derecha;
    }

    public void setDerecha(Contacto derecha) {
        this.derecha = derecha;
    }

    // comparador de contactos 
    @Override
    public int compareTo(Object o) {
        Contacto contc = (Contacto) o; // casting
        return nombre.compareToIgnoreCase(contc.nombre);
    }

    public boolean Insertar(Contacto nuevo) {
        Boolean n = false;
        if (compareTo(nuevo) == 0) {
            JOptionPane.showMessageDialog(null, "Contacto repetido!.");
            n = true;
        }
        if (n != true) {
            if (compareTo(nuevo) > 0) {

                if (izquierda == null) {
                    izquierda = nuevo;
                    JOptionPane.showMessageDialog(null, "Contacto agregado correctamente!.");

                } else {
                    izquierda.Insertar(nuevo);
                }
            } else {
                if (derecha == null) {
                    derecha = nuevo;
                    JOptionPane.showMessageDialog(null, "Contacto agregado correctamente!.");
                } else {
                    derecha.Insertar(nuevo);
                }
            }
        }
        return n;
    }

    public Contacto buscar(String unNombre) {
        if (nombre.compareToIgnoreCase(unNombre) == 0) {
            return this;
        } else if (nombre.compareToIgnoreCase(unNombre) > 0) {
            return (izquierda == null) ? null : izquierda.buscar(unNombre);
        } else {
            return (derecha == null) ? null : derecha.buscar(unNombre);
        }
    }

    public void inorden(Vector nombre) {
        if (izquierda != null) {
            izquierda.inorden(nombre);
        }
        nombre.add(this.nombre);
        if (derecha != null) {
            derecha.inorden(nombre);
        }
    }
}
