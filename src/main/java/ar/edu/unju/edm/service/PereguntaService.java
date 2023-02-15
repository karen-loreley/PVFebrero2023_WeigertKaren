package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.entidades.Preguta;


@Service
public interface PereguntaService {
	
	public void guardarPregunta(Preguta preguntaparaguardar);
	public void modificarPregunta(Preguta pregunta);
	public void eliminarPregunta(Long codpregunta) throws Exception;
	public Preguta buscarPregunta(Long codpregunta) throws Exception;
	public List<Preguta> mostrarPregunta(); 

}
