package viewModel

import org.uqbar.commons.model.annotations.Observable
import dominio.Agenda
import bootstrap.AgendaBootstrap
import org.eclipse.xtend.lib.annotations.Accessors
import dominio.Contacto
import org.uqbar.commons.model.annotations.Transactional

@Accessors
@Observable
@Transactional
class PantallaPrincipalViewModel {
	Agenda miAgenda = AgendaBootstrap.agenda
	Contacto contactoSeleccionado
	Contacto nuevoContacto = new Contacto
	
	new() {
		resetearContacto
	}
	
	def getContactos(){
		miAgenda.contactos
	}
	
	def agregarContacto(){
		miAgenda.agregarContacto(nuevoContacto)
		resetearContacto
	}
	
	def resetearContacto(){
		nuevoContacto = new Contacto
	}
	
}