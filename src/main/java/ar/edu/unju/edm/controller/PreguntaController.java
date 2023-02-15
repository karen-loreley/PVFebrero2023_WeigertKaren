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
import ar.edu.unju.edm.entidades.Preguta;
import ar.edu.unju.edm.service.PereguntaService;


@Controller
public class PreguntaController {

	private static final Log KAREN=LogFactory.getLog(UsuarioController.class);//hay que cambiarlo?
	
	@Autowired
	Preguta nuevaPregunta;
	
	@Autowired
	PereguntaService preguntaService;
	
	@GetMapping("/otraPregunta")
	public ModelAndView addUser() {
		KAREN.info("ingresando al metodo:Nuevo pregunta");
		ModelAndView modelView= new ModelAndView("cargarPregunta");
		modelView.addObject("pregunta", nuevaPregunta);
		modelView.addObject("editMode", false);
		return modelView;
	}
	
	@PostMapping("/guardarPregunta")
	public String saveUser(@Valid @ModelAttribute("pregunta") Preguta preguntaparaguardar, BindingResult resultado, Model model) {  
		System.out.println(resultado.getAllErrors());
		
		if(resultado.hasErrors()) {
			KAREN.fatal("Error de Validacion");
			model.addAttribute("pregunta",preguntaparaguardar);
			model.addAttribute("editMode", false);
			return "cargarPregunta";
		}
		try { 
			preguntaService.guardarPregunta(preguntaparaguardar);
		}catch(Exception error){ 
			model.addAttribute("formUsuarioErrorMessage", error.getMessage());
			model.addAttribute("pregunta",preguntaparaguardar);
			model.addAttribute("editMode", false);
			KAREN.error("saliendo del metodo: guardar pregunta");
			return "cargarUsuario";
		}
		model.addAttribute("formUsuarioErrorMessage", "pregunta Guardado Correctamente");
		model.addAttribute("pregunta", nuevaPregunta);
		model.addAttribute("editMode", false);
		return "cargarPregunta";
	}
		
	@GetMapping("/listadoPreguntas")
	public ModelAndView listUser() {
		ModelAndView vista = new ModelAndView("listarPreguntas");
		vista.addObject("listaPreguntas", preguntaService.mostrarPregunta());
		
		return vista;
	}
	
	
	
	@GetMapping("/listadoPreguntayUsuario")
	public ModelAndView showMovieCliente() {
		ModelAndView vista = new ModelAndView("listadoPreguntayUsuario");
		vista.addObject("listaPregunta", preguntaService.mostrarPregunta());
		return vista;
	}
	
	@RequestMapping("/eliminarUsuario/{CodPregunta}")
	public String eliminar(@PathVariable(name="CodPregunta")Long CodPregunta, Model model) {
		try {
			preguntaService.eliminarPregunta(CodPregunta);
		}catch(Exception error){
			KAREN.error("Error: Eliminar pregunta");
			model.addAttribute("formUsuarioErrorMessage", error.getMessage());
			return "redirect:/listadoPregunta";
		}
		return "redirect:/listadoPregunta";
	}
	
	@GetMapping("/editarPregunta/{CodPregunta}")
	public ModelAndView ObtenerFormularioEditarPregunta(Model model,@PathVariable (name="CodPregunta") Long CodPregunta)throws Exception {	
	Preguta encontrado = new Preguta();
		encontrado = preguntaService.buscarPregunta(CodPregunta);
		ModelAndView modelView = new ModelAndView("cargarPregunta");
		modelView.addObject("pregunta", encontrado);
		KAREN.info("saliendo del metodo: editar pregunta"+ encontrado.getCodPregunta());
		modelView.addObject("editMode", true);
		return modelView;
	}
	
	@PostMapping("/editarPregunta")
	public ModelAndView postEditarPregunta(@ModelAttribute ("pregunta") Preguta preguntaparamodificar, BindingResult result) {  
			if(result.hasErrors()){
			KAREN.fatal("Error de validacion");
			ModelAndView vista = new ModelAndView("cargarPregunta");
			vista.addObject("pregunta", preguntaparamodificar);
			vista.addObject("editMode",true);
			return vista;
		}
		try{
			preguntaService.modificarPregunta(preguntaparamodificar);
		}catch(Exception error){
			ModelAndView vista = new ModelAndView("cargarPregunta");
			vista.addObject("formUsuarioErrorMessage", error.getMessage());
			vista.addObject("pregunta", preguntaparamodificar);
			vista.addObject("editMode",true);
			KAREN.error("saliendo del metodo: editar pregunta");
			return vista;
		}
		 KAREN.info("Codigo de la pregunta para modificar "+ preguntaparamodificar.getCodPregunta());
		ModelAndView vista1 = new ModelAndView("listadoUsuario");		
		vista1.addObject("listaPregunta", preguntaService.mostrarPregunta());		
		vista1.addObject("formUsuarioErrorMessage","Pregunta modificado Correctamente");
		
		return vista1;
	}
	

		
	
}
