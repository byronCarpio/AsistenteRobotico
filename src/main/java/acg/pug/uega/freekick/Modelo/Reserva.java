package acg.pug.uega.freekick.Modelo;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

//Hacienod calase pojo
//Table para cambiar el nombre de la tabla al momento de crear

@Entity
@Table(name="tbl_reserva")
public class Reserva {
	
    
	@Id
	@NotNull(message="El codigo es obligatorio")
	@Column(name = "rsv_codigo")
	private int codigo;

    @NotNull(message="La fecha de reserva debe ser del futuro")
	@Future(message = "La fecha de reserva debe ser del futuro")
	@Temporal(TemporalType.DATE)
	@Column(name = "rsv_fecha_reserva")
	private Date fecha_res;


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Date getFecha_res() {
		return fecha_res;
	}

	public void setFecha_res(Date fecha_res) {
		this.fecha_res = fecha_res;
	}

	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", f_Reserva=" + fecha_res + "]";
	}	
}
