package dominio;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Contacto {
  private String nombreApellido;
  
  private String email;
  
  private String telefono;
  
  private boolean favorito = false;
  
  public boolean toggleFavorito() {
    return this.favorito = (!this.favorito);
  }
  
  @Pure
  public String getNombreApellido() {
    return this.nombreApellido;
  }
  
  public void setNombreApellido(final String nombreApellido) {
    this.nombreApellido = nombreApellido;
  }
  
  @Pure
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(final String email) {
    this.email = email;
  }
  
  @Pure
  public String getTelefono() {
    return this.telefono;
  }
  
  public void setTelefono(final String telefono) {
    this.telefono = telefono;
  }
  
  @Pure
  public boolean isFavorito() {
    return this.favorito;
  }
  
  public void setFavorito(final boolean favorito) {
    this.favorito = favorito;
  }
}
