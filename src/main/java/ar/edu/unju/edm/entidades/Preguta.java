package ar.edu.unju.edm.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "preguntas")
public class Preguta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name= "codpregunta")
	private Long CodPregunta;
	
	@NotEmpty
	@Column(name="enunciado")
	private String Enunciado;
	
	@Min(value = 1, message = "solo hay 3 niveles, el menor es 1")
	@Max(value = 3, message = "solo hay 3 niveles, el mayor en 3")
	@NotNull
	private int Nivel;//es una evalucion
	
	@NotEmpty
	private String Opcion01;//preguntas 1-2-3-4-5
	
	@NotEmpty
	private String Opcion02;
	
	@NotEmpty
	private String Opcion03;
	
	@NotEmpty
	private String Opcion04;
	
	@NotEmpty
	private String OpcionCorrecta;
	
	@NotNull
	private Long Puntaje;
	
	private Boolean estadopregunta;
	
	
	//constructor vacio
	
	public Preguta() {
		super();
	}
	
	
	
	//geters and seters

	
	
	public Long getCodPregunta() {
		return CodPregunta;
	}

	public void setCodPregunta(Long codPregunta) {
		CodPregunta = codPregunta;
	}

	public String getEnunciado() {
		return Enunciado;
	}

	public void setEnunciado(String enunciado) {
		Enunciado = enunciado;
	}

	public int getNivel() {
		return Nivel;
	}

	public void setNivel(int nivel) {
		Nivel = nivel;
	}

	public String getOpcion01() {
		return Opcion01;
	}

	public void setOpcion01(String opcion01) {
		Opcion01 = opcion01;
	}

	public String getOpcion02() {
		return Opcion02;
	}

	public void setOpcion02(String opcion02) {
		Opcion02 = opcion02;
	}

	public String getOpcion03() {
		return Opcion03;
	}

	public void setOpcion03(String opcion03) {
		Opcion03 = opcion03;
	}

	public String getOpcion04() {
		return Opcion04;
	}

	public void setOpcion04(String opcion04) {
		Opcion04 = opcion04;
	}

	public String getOpcionCorrecta() {
		return OpcionCorrecta;
	}

	public void setOpcionCorrecta(String opcionCorrecta) {
		OpcionCorrecta = opcionCorrecta;
	}

	public Long getPuntaje() {
		return Puntaje;
	}

	public void setPuntaje(Long puntaje) {
		Puntaje = puntaje;
	}
	
	public Boolean getEstadopregunta() {
		return estadopregunta;
	}



	public void setEstadopregunta(Boolean estadopregunta) {
		this.estadopregunta = estadopregunta;
	}

	
	
}