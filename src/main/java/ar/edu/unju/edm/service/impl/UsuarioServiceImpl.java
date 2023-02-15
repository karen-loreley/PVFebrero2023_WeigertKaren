package ar.edu.unju.edm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.entidades.Usuario;

import ar.edu.unju.edm.repository.UsuarioRepository;
import ar.edu.unju.edm.service.UsuarioService;
import ar.edu.unju.edm.until.ListaUsuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	ListaUsuario lista;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public void guardarUsuario(Usuario usuario) {
		usuario.setEstado(true);
		String pw = usuario.getPassword();
		BCryptPasswordEncoder coder = new BCryptPasswordEncoder(4);
		usuario.setPassword(coder.encode(pw));

		usuarioRepository.save(usuario);
	}
	
	@Override
	public List<Usuario> mostrarUsuarios() {
		List<Usuario> aux = new ArrayList<>();
		List<Usuario> aux2 = new ArrayList<>();

		aux = (List<Usuario>) usuarioRepository.findAll();
		for (int i = 0; i < aux.size(); i++) {
			if (aux.get(i).getEstado() == true) {
				aux2.add(aux.get(i));
			}
		}
		System.out.println("La cantidad de usuarios activos es de: " + aux2.size());

		return aux2;
	}

	@Override
	public void eliminarUsuario(Long dni) throws Exception {
		Usuario aux = new Usuario();
		aux = buscarUsuario(dni);
		aux.setEstado(false);
		usuarioRepository.save(aux);

	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		System.out.println("Usted esta ingresando al metodo modificar usuario" + usuario.getNombre());
		usuarioRepository.save(usuario);

	}

	@Override
	public Usuario buscarUsuario(Long dni) throws Exception {
		Usuario encontrado = new Usuario();
		encontrado = usuarioRepository.findById(dni).orElseThrow(() -> new Exception("Usuario No Encontrado"));
		return encontrado;

	}

}
