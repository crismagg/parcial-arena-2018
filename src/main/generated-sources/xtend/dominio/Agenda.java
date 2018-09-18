package dominio;

import dominio.Contacto;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Agenda {
  private List<Contacto> contactos = new ArrayList<Contacto>();
  
  public boolean agregarContacto(final Contacto contacto) {
    return this.contactos.add(contacto);
  }
  
  @Pure
  public List<Contacto> getContactos() {
    return this.contactos;
  }
  
  public void setContactos(final List<Contacto> contactos) {
    this.contactos = contactos;
  }
}
