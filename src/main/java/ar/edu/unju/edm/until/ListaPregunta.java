package ar.edu.unju.edm.until;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.edm.entidades.Preguta;

@Component
public class ListaPregunta {
private List<Preguta> lista = new ArrayList<>();
	
	//Constructor por defecto
	public ListaPregunta() {
		// TODO Auto-generated constructor stub
	}

	//Getter and Setters
	public List<Preguta> getListado() {
		return lista;
	}

	public void setListado(List<Preguta> lista) {
		this.lista = lista;
	}

}
