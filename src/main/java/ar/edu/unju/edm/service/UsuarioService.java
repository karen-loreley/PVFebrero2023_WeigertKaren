package ar.edu.unju.edm.service;

import java.util.List;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.entidades.Usuario;

@Service
public interface UsuarioService {

	public void guardarUsuario(Usuario usuario);

	public List<Usuario> mostrarUsuarios();

	public void eliminarUsuario(Long dni) throws Exception;

	public void modificarUsuario(Usuario usuario);

	public Usuario buscarUsuario(Long id) throws Exception;
}
