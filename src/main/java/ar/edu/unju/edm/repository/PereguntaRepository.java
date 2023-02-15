package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.entidades.Preguta;

@Repository
public interface PereguntaRepository extends CrudRepository<Preguta, Long>{
	
	public List<Preguta> findByEstado(Boolean estado);
}
