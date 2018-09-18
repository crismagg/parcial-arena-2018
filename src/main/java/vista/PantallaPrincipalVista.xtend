package vista

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import viewModel.PantallaPrincipalViewModel
import org.uqbar.arena.widgets.tables.Table
import dominio.Contacto
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.commons.model.utils.ObservableUtils

class PantallaPrincipalVista extends SimpleWindow<PantallaPrincipalViewModel>{
	
	new(WindowOwner parent) {
		super(parent,new PantallaPrincipalViewModel)
	}
	
	override protected addActions(Panel actionsPanel) {
	
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.title = "Contactos"
		val selectedUser = new NotNullObservable("contactoSeleccionado")
		val panelCentral = new Panel(mainPanel)
		val panelIzquierdo = new Panel(panelCentral)
		val panelDerecho = new Panel(panelCentral)
		panelCentral.layout = new HorizontalLayout
		
		val tablaNombreApellido = new Table<Contacto>(panelIzquierdo, typeof(Contacto)) => [
			items <=> "contactos"
			value <=> "contactoSeleccionado"
			numberVisibleRows = 5
		]
		new Column<Contacto>(tablaNombreApellido) => [
			title = "Nombre y Apellido"
			fixedSize = 170
			bindContentsToProperty("nombreApellido")
		]
		new Column<Contacto>(tablaNombreApellido) => [
			title = "Favorito"
			fixedSize = 170
			(bindContentsToProperty("favorito")).transformer = [ Boolean valorFavorito | if (valorFavorito) "SI" else "NO" ]
		]
		
		new Button(panelIzquierdo) => [
			caption = "Favorito"
			onClick([|this.cambiarFavorito])
			setAsDefault
			width = 20
			bindEnabled(selectedUser)
		]
		
		val panelDerechoTitulo = new Panel(panelDerecho)
		val panelDerechoCentro = new Panel(panelDerecho)
		val panelDerechoBoton = new Panel(panelDerecho)
		
		new Label(panelDerechoTitulo).text = "Nuevo Contacto"		
		panelDerechoCentro.layout = new ColumnLayout(2)
		new Label(panelDerechoCentro).text = "Nombre y Apellido:"
		new TextBox(panelDerechoCentro) => [
			value <=> "nuevoContacto.nombreApellido"
	   		width = 100 
		]
		new Label(panelDerechoCentro).text = "Teléfono:"
		new TextBox(panelDerechoCentro) => [
			value <=> "nuevoContacto.telefono"
	   		width = 100 
		]
		new Label(panelDerechoCentro).text = "email:"
		new TextBox(panelDerechoCentro) => [
			value <=> "nuevoContacto.email"
    		width = 100 
		]
		new Button(panelDerechoBoton) => [
			caption = "Agregar"
			onClick([|this.agregarContactoAAgenda])
			setAsDefault
		]
	}
	
	def cambiarFavorito(){
		modelObject.contactoSeleccionado.toggleFavorito
	}
	
	def agregarContactoAAgenda(){
		modelObject.agregarContacto
		ObservableUtils.firePropertyChanged(modelObject, "contactos")
	}
}