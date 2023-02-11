package ar.edu.unju.edm.entidades;

import javax.persistence.Id;

public class Preguta {

	@Id
	private Long CodPregunta;
	private String EnunciadoNivel;
	private String Opcion01;
	private String Opcion02;
	private String Opcion03;
	private String Opcion04;
	private String OpcionCorrecta;
	private Long Puntaje;
	
	
	
	
	//constructor vacio
	
	public Preguta() {
		super();
	}
	
	//geter and seters
	
	public Long getCodPregunta() {
		return CodPregunta;
	}
	public void setCodPregunta(Long codPregunta) {
		CodPregunta = codPregunta;
	}
	public String getEnunciadoNivel() {
		return EnunciadoNivel;
	}
	public void setEnunciadoNivel(String enunciadoNivel) {
		EnunciadoNivel = enunciadoNivel;
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
	
}
