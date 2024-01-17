package modelo;

public class Stand {
  String codigo;

  Emprendedor emprendedor = null;
  Auspiciante auspiciante = null;

public Stand(String label){
  codigo = label;

}
  
public String getCodigo() {
    return codigo;
}

public void setCodigo(String codigo) {
    this.codigo = codigo;
}

public Emprendedor getEmprendedor() {
    return emprendedor;
}

public void setEmprendedor(Emprendedor emprendedor) {
    this.emprendedor = emprendedor;
}

public Auspiciante getAuspiciante() {
    return auspiciante;
}

public void setAuspiciante(Auspiciante auspiciante) {
    this.auspiciante = auspiciante;
}

public String toString() {
  return "[" + codigo + "]";
}
  public String info() {
    if(auspiciante != null){
      return "[" + codigo + "] " + auspiciante.info();
  
    }
    else if(emprendedor != null){
      return "[" + codigo + "] " + emprendedor.info();
    }
    else{
      return "[" + codigo + "]" + "stands sin emprendedor ni auspiciante";
    }
  }
}