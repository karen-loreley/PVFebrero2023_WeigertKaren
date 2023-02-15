package ar.edu.unju.edm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.entidades.Preguta;
import ar.edu.unju.edm.repository.PereguntaRepository;
import ar.edu.unju.edm.service.PereguntaService;
import ar.edu.unju.edm.until.ListaPregunta;

@Service
public class PreguntaServiceImpl implements PereguntaService{

	
	@Autowired
	ListaPregunta lista;
	
	@Autowired
	PereguntaRepository repository;
	
	@Override
	public void guardarPregunta(Preguta preguntaparaguardar) {
		preguntaparaguardar.setEstadopregunta(true);
		repository.save(preguntaparaguardar);
		
	}

	@Override
	public void modificarPregunta(Preguta pregunta) {
		
		pregunta.setEstadopregunta(true);
		repository.save(pregunta);
	}


	@Override
	public void eliminarPregunta(Long codpregunta) throws Exception {
		Preguta aux =new Preguta();
		aux=buscarPregunta(codpregunta);
		aux.setEstadopregunta(false);
		repository.save(aux);
		
	}


	@Override
	public Preguta buscarPregunta(Long codpregunta) throws Exception {
		Preguta encontrada =new Preguta();
		encontrada=repository.findById(codpregunta).orElseThrow(()->new Exception("Pregunta noencontrado"));
	return encontrada;
	}
	
	@Override
	public List<Preguta> mostrarPregunta() {
		List<Preguta>aux =new ArrayList<>();
		List<Preguta>aux2=new ArrayList<>();
		
		aux=(List<Preguta>) repository.findAll();
		for(int i=0;i<aux.size();i++) {
			if(aux.get(i).getEstadopregunta()==true) {
				aux2.add(aux.get(i));
			}
		}
		
		return aux2;
	}
}
