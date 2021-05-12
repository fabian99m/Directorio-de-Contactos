package Logica;

import javax.swing.JOptionPane;

public class Directorio {

    private Contacto contactoRaiz;
    private int tama;

    public Directorio() {
    }

    public Directorio(Contacto contactoRaiz, int tama) {
        this.contactoRaiz = contactoRaiz;
        this.tama = 0;
    }

    public Contacto getContactoRaiz() {
        return contactoRaiz;
    }

    public void setContactoRaiz(Contacto contactoRaiz) {
        this.contactoRaiz = contactoRaiz;
    }

    public int getTama() {
        return tama;
    }

    public void setTama(int tama) {
        this.tama = tama;
    } 
    
    public boolean EstaVacio() {
        return contactoRaiz==null;
    }

    public void AgregarContacto(String nom, String tel, String dir, String correo) {
        Contacto c = new Contacto(nom, tel, dir, correo);
        if (contactoRaiz == null) {
            contactoRaiz = c;
            JOptionPane.showMessageDialog(null, "Contacto agregado correctamente!.");
           tama++;
        } else {
            if( contactoRaiz.Insertar(c)==false) {
                tama++;
            }
        }
     
    }
    
    public Contacto buscarContacto( String nombre )
    {
        return contactoRaiz == null ? null : contactoRaiz.buscar( nombre );
    }
}
