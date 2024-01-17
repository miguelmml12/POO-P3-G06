package modelo;

import java.util.ArrayList;

public class Emprendedor extends Persona {
    private String descripcion;
    public Emprendedor(String cedula, String nombre, String   nombrePersona, String telefono, String email, String direccion, String sitioWeb, ArrayList<String> redesSociales, String descripcion) {
        super(cedula, nombre, nombrePersona, telefono, email, direccion, sitioWeb, redesSociales);
        this.descripcion = descripcion;
    }

public void setNombre(String nombre) {
  this.nombre = nombre;
}

public void setTelefono(String telefono) {
  this.telefono = telefono;
}

public void setEmail(String email) {
  this.email = email;
}

public void setDireccion(String direccion) {
  this.direccion = direccion;
}

public void setSitioWeb(String sitioWeb) {
  this.sitioWeb = sitioWeb;
}

public void setRedesSociales(ArrayList<String> redesSociales) {
  this.redesSociales = redesSociales;
}

public void setDescripcion(String descripcion) {
  this.descripcion = descripcion;
}
  
    // Getter y setter específico para Emprendedor, teniendo en cuenta lo heredado.

  public String getNombre(){
    return nombre;
  }
  
  public String getDescripcion() {
    return descripcion;
  }


  
  public String toString(){
    return "Emprededor " + nombre +" " + "id: " + cedula;
  }
  public String info(){
    return "Emprendedor " + nombre +" " + "id: " + cedula + " persona responsabble: " + nombrePersona +  "  telefono: " +telefono + " email: " + email+ " direccion: " +direccion + "  SitioWeb: " + sitioWeb + "  Redes Sociales: " + redesSociales + "  Descripcion: " + descripcion;
  }

  // public void setDescripcion(String descripcion) {
  //   this.descripcion = descripcion;
  // }

  

  
}