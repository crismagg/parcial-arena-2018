package bootstrap

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import vista.PantallaPrincipalVista

class AgendaApplication extends Application {
	
	new(AgendaBootstrap bootstrap) {
		super(bootstrap)
	}

	static def void main(String[] args) {
		new AgendaApplication(new AgendaBootstrap).start()
	}

	override protected Window<?> createMainWindow() {
		return new PantallaPrincipalVista(this)
	}
	
}
