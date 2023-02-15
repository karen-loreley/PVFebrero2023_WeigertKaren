package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.entidades.Usuario;
import ar.edu.unju.edm.service.UsuarioService;

@Controller
public class UsuarioController {

	private static final Log KAREN=LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	Usuario nuevousuario;
	
	@Autowired
	UsuarioService usuarioServicio;

	@GetMapping("/otroUsuario")
	public ModelAndView addUser() {
		KAREN.info("ingresando al metodo:Nuevo usuario");
		ModelAndView modelView= new ModelAndView("cargarUsuario");
		modelView.addObject("usuario", nuevousuario);
		modelView.addObject("editMode", false);
		return modelView;
	}
	
	
	@PostMapping("/guardarUsuario")
	public String saveUser(@Valid @ModelAttribute("usuario") Usuario usuarioparaguardar, BindingResult resultado, Model model) {  
		System.out.println(resultado.getAllErrors());
		
		if(resultado.hasErrors()) {
			KAREN.fatal("Error de Validacion");
			model.addAttribute("usuario",usuarioparaguardar);
			model.addAttribute("editMode", false);
			return "cargarUsuario";
		}
		try { 
			usuarioServicio.guardarUsuario(usuarioparaguardar);
		}catch(Exception error){ 
			model.addAttribute("formUsuarioErrorMessage", error.getMessage());
			model.addAttribute("usuario",usuarioparaguardar);
			model.addAttribute("editMode", false);
			KAREN.error("saliendo del metodo: guardar usuario");
			return "cargarUsuario";
		}
		model.addAttribute("formUsuarioErrorMessage", "Usuario Guardado Correctamente");
		model.addAttribute("usuario", nuevousuario);
		model.addAttribute("editMode", false);
		return "cargarUsuario";
	}
	
	
		@GetMapping("/listadoUsuario")
		public ModelAndView listUser() {
			ModelAndView vista = new ModelAndView("listarUsuarios");
			vista.addObject("listaUsuario", usuarioServicio.mostrarUsuarios());
			//KAREN.info("ingresando al metodo: listar usuario"+usuarioServicio.mostrarusuarios().get(0).getApellido());
			return vista;
		}
		
	
		@RequestMapping("/eliminarUsuario/{dni}")
		public String eliminar(@PathVariable(name="dni")Long dni, Model model) {
			try {
				usuarioServicio.eliminarUsuario(dni);
			}catch(Exception error){
				KAREN.error("Error: Eliminar usuario");
				model.addAttribute("formUsuarioErrorMessage", error.getMessage());
				return "redirect:/listadoUsuario";
			}
			return "redirect:/listadoUsuario";
		}
		
		
		@GetMapping("/editarUsuario/{dni}")
		public ModelAndView ObtenerFormularioEditarUsuarior(Model model,@PathVariable (name="dni") Long dni)throws Exception {	
		Usuario encontrado = new Usuario();
			encontrado = usuarioServicio.buscarUsuario(dni);
			ModelAndView modelView = new ModelAndView("cargarUsuario");
			modelView.addObject("usuario", encontrado);
			KAREN.info("saliendo del metodo: editar usuario"+ encontrado.getDni());
			modelView.addObject("editMode", true);
			return modelView;
		}
		
		
		@PostMapping("/editarUsuario")
		public ModelAndView postEditarUsuario(@ModelAttribute ("usuario") Usuario usuarioparamodificar, BindingResult result) {  
				if(result.hasErrors()){
				KAREN.fatal("Error de validacion");
				ModelAndView vista = new ModelAndView("cargarUsuario");
				vista.addObject("usuario", usuarioparamodificar);
				vista.addObject("editMode",true);
				return vista;
			}
			try{
				usuarioServicio.modificarUsuario(usuarioparamodificar);
			}catch(Exception error){
				ModelAndView vista = new ModelAndView("cargarUsuario");
				vista.addObject("formUsuarioErrorMessage", error.getMessage());
				vista.addObject("usuario", usuarioparamodificar);
				vista.addObject("editMode",true);
				KAREN.error("saliendo del metodo: editar usuario");
				return vista;
			}
			 KAREN.info("DNI de usuario para modificar "+ usuarioparamodificar.getDni());
			 KAREN.info("Nombre de usuario para modificar "+ usuarioparamodificar.getNombre());
			ModelAndView vista1 = new ModelAndView("listadoUsuario");		
			vista1.addObject("listaUsuario", usuarioServicio.mostrarUsuarios());		
			vista1.addObject("formUsuarioErrorMessage","Usuario modificado Correctamente");
			
			return vista1;
		}
		
		
	

}
