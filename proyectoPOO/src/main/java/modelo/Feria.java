package modelo;
import java.util.ArrayList;
import java.util.Arrays;

public class Feria {
    private static int codigoIncremental = 1;
    public int codigo;
    public String nombre;
    public String descripcion;
    public String lugar;
    public String fechaInicio;
    public String fechaFin;
    public String horario;
    // private int[] cantidadStands;  // Cantidad de stands por sección
    public ArrayList<Emprendedor> emprendedores;
    public ArrayList<Auspiciante> auspiciantes_en_feria;
  public ArrayList<Stand> seccion1  = new ArrayList<Stand>();
  public ArrayList<Stand> seccion2  = new ArrayList<Stand>();
  public ArrayList<Stand> seccion3  = new ArrayList<Stand>();
  public ArrayList<Stand> seccion4  = new ArrayList<Stand>();


  

  public Feria(String nombre, String descripcion, String lugar, String fechaInicio, String fechaFin, String horario,ArrayList<Stand> seccion1,ArrayList<Stand> seccion2,ArrayList<Stand> seccion3,ArrayList<Stand> seccion4) {
    this.codigo = codigoIncremental++;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.lugar = lugar;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.horario = horario;
    this.seccion1 = seccion1;
    this.seccion2 = seccion2;
    this.seccion3 = seccion3;
    this.seccion4 = seccion4;
    emprendedores = new ArrayList<Emprendedor>();
    auspiciantes_en_feria = new ArrayList<Auspiciante>();
  }

public ArrayList<Stand> getSeccion1(){
  return seccion1;
}
public ArrayList<Stand> getSeccion2(){
  return seccion2;
}
public ArrayList<Stand> getSeccion3(){
  return seccion3;
}
public ArrayList<Stand> getSeccion4(){
  return seccion4;
}
  
public int getCodigo() {
    return codigo;
}

public String getNombre() {
    return nombre;
}

public String getDescripcion() {
    return descripcion;
}

public String getLugar() {
    return lugar;
}

public String getFechaInicio() {
    return fechaInicio;
}

public String getFechaFin() {
    return fechaFin;
}

public String getHorario() {
    return horario;
}



public ArrayList<Emprendedor> getEmprendedores() {
    return emprendedores;

}

public ArrayList<Auspiciante> getAuspiciantes_en_feria() {
    return auspiciantes_en_feria;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public void setLugar(String lugar) {
    this.lugar = lugar;
}

public void setFechaInicio(String fechaInicio) {
    this.fechaInicio = fechaInicio;
}

public void setFechaFin(String fechaFin) {
    this.fechaFin = fechaFin;
}

public void setHorario(String horario) {
    this.horario = horario;
}


public String toString() {
  return "Codigo: " + codigo + " / Feria " + nombre + " / Fecha de inicio: " + fechaInicio + " / lugar: " + lugar + " / Cantidad de auspiciantes: " + auspiciantes_en_feria.size();
}
   
}


