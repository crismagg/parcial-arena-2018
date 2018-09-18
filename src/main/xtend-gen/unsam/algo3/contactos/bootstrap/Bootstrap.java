package unsam.algo3.contactos.bootstrap;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import unsam.algo3.contactos.domain.Agenda;
import unsam.algo3.contactos.domain.Contacto;

@SuppressWarnings("all")
public class Bootstrap {
  public static Agenda getAgenda() {
    Agenda agenda = new Agenda();
    Contacto _contacto = new Contacto();
    final Procedure1<Contacto> _function = new Procedure1<Contacto>() {
      public void apply(final Contacto it) {
        it.setNombreApellido("Rick Grimes");
        it.setEmail("rick@hotmail.com");
        it.setTelefono("1523467980");
      }
    };
    Contacto _doubleArrow = ObjectExtensions.<Contacto>operator_doubleArrow(_contacto, _function);
    agenda.agregarContacto(_doubleArrow);
    Contacto _contacto_1 = new Contacto();
    final Procedure1<Contacto> _function_1 = new Procedure1<Contacto>() {
      public void apply(final Contacto it) {
        it.setNombreApellido("Walter White");
        it.setEmail("wally@gmail.com");
        it.setTelefono("1523467981");
        it.setFavorito(true);
      }
    };
    Contacto _doubleArrow_1 = ObjectExtensions.<Contacto>operator_doubleArrow(_contacto_1, _function_1);
    agenda.agregarContacto(_doubleArrow_1);
    Contacto _contacto_2 = new Contacto();
    final Procedure1<Contacto> _function_2 = new Procedure1<Contacto>() {
      public void apply(final Contacto it) {
        it.setNombreApellido("Barry Allen");
        it.setEmail("barry@yahoo.com");
        it.setTelefono("1523467983");
      }
    };
    Contacto _doubleArrow_2 = ObjectExtensions.<Contacto>operator_doubleArrow(_contacto_2, _function_2);
    agenda.agregarContacto(_doubleArrow_2);
    return agenda;
  }
}
