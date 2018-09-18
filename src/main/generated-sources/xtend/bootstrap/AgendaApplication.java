package bootstrap;

import bootstrap.AgendaBootstrap;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import vista.PantallaPrincipalVista;

@SuppressWarnings("all")
public class AgendaApplication extends Application {
  public AgendaApplication(final AgendaBootstrap bootstrap) {
    super(bootstrap);
  }
  
  public static void main(final String[] args) {
    AgendaBootstrap _agendaBootstrap = new AgendaBootstrap();
    new AgendaApplication(_agendaBootstrap).start();
  }
  
  protected Window<?> createMainWindow() {
    return new PantallaPrincipalVista(this);
  }
}
