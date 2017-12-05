package acg.pug.uega.freekick.Modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbl_servicios")
public class Servicios {
	
	
	@Id
	@Column(name="ser_codigo", length = 6)
	private int codigo;
	
	@NotNull
	@Size(min=4,max=20)
	@Column(name="ser_descripcion")
	private String descripcion;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Servicios [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}


}
