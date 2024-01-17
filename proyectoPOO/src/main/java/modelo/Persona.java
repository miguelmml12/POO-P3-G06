package modelo;
import java.util.ArrayList;

public class Persona {
    protected String cedula;
    protected String nombre;
    protected String nombrePersona;
    protected String telefono;
    protected String email;
    protected String direccion;
    protected String sitioWeb;
    protected ArrayList<String> redesSociales;

    public Persona(String cedula, String nombre, String nombrePersona, String telefono, String email, String direccion,String sitioWeb, ArrayList<String> redesSociales) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.nombrePersona = nombrePersona;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.sitioWeb = sitioWeb;
        this.redesSociales = redesSociales;
    }

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public ArrayList<String> getRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(ArrayList<String> redesSociales) {
		this.redesSociales = redesSociales;
	}
  
}
  

