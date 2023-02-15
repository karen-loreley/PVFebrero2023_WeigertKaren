package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.entidades.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
	
	public List<Usuario> findByEstado(Boolean estado);

}
