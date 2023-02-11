package ar.edu.unju.edm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ar.edu.unju.edm.entidades.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

}
