//copiando codigo de la clase emprendedores, ojo
package modelo;
import java.util.ArrayList;

public class Auspiciante extends Persona {
    public Sector sector;
    public String descripcion;
    public boolean stand_en_feria;

    public Auspiciante(String cedula, String nombre, String nombrePersona, String telefono, String email, String direccion, String sitioWeb,ArrayList<String> redesSociales, Sector sector) {
        super(cedula, nombre, nombrePersona, telefono, email, direccion, sitioWeb,redesSociales);
        this.sector = sector;
    }

  // public Sector getSector() {
  //   return sector;
  // }
  //   public void setSector(Sector sector) {
  //     this.sector = sector;
  //   }
  // public void setRedesSocilaes(ArrayList<String> redesSociales){
  //   this.redesSociales = redesSociales;
  // }

    public Sector getSector() {
        return sector;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isStand_en_feria() {
        return stand_en_feria;
    }

@Override  
public void setNombre(String nombre) {
    this.nombre = nombre;
}
  public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
  }
  
  public void setStand_en_feria(boolean stand_en_feria) {
      this.stand_en_feria = stand_en_feria;
  }
@Override
public void setTelefono(String telefono) {
    this.telefono = telefono;
}
@Override
public void setEmail(String email) {
    this.email = email;
}
@Override
public void setDireccion(String direccion) {
    this.direccion = direccion;
}
@Override
public void setSitioWeb(String sitioWeb) {
    this.sitioWeb = sitioWeb;
}
@Override
public void setRedesSociales(ArrayList<String> redesSociales) {
    this.redesSociales = redesSociales;
}

public void setSector(Sector sector) {
    this.sector = sector;
}
  @Override
  public String toString(){
    return "Auspiciante " + nombre +" " + "id: " + cedula;
  }
  public String info(){
    return "Auspiciante " + nombre +" " + "id: " + cedula + " persona responsabble: " + nombrePersona +  "  telefono: " +telefono + " email: " + email+ " direccion: " +direccion + "  SitioWeb: " + sitioWeb + "  Redes Sociales: " + redesSociales + "  Sector: " + sector;
  }
}