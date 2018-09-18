package vista;

import dominio.Contacto;
import org.apache.commons.collections15.Transformer;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.widgets.tables.labelprovider.PropertyLabelProvider;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.commons.model.utils.ObservableUtils;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.TableBuilder;
import org.uqbar.lacar.ui.model.bindings.ViewObservable;
import viewModel.PantallaPrincipalViewModel;

@SuppressWarnings("all")
public class PantallaPrincipalVista extends SimpleWindow<PantallaPrincipalViewModel> {
  public PantallaPrincipalVista(final WindowOwner parent) {
    super(parent, new PantallaPrincipalViewModel());
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Contactos");
    final NotNullObservable selectedUser = new NotNullObservable("contactoSeleccionado");
    final Panel panelCentral = new Panel(mainPanel);
    final Panel panelIzquierdo = new Panel(panelCentral);
    final Panel panelDerecho = new Panel(panelCentral);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panelCentral.setLayout(_horizontalLayout);
    Table<Contacto> _table = new Table<Contacto>(panelIzquierdo, Contacto.class);
    final Procedure1<Table<Contacto>> _function = new Procedure1<Table<Contacto>>() {
      public void apply(final Table<Contacto> it) {
        ViewObservable<Table<Contacto>, TableBuilder<Contacto>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "contactos");
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "contactoSeleccionado");
        it.setNumberVisibleRows(5);
      }
    };
    final Table<Contacto> tablaNombreApellido = ObjectExtensions.<Table<Contacto>>operator_doubleArrow(_table, _function);
    Column<Contacto> _column = new Column<Contacto>(tablaNombreApellido);
    final Procedure1<Column<Contacto>> _function_1 = new Procedure1<Column<Contacto>>() {
      public void apply(final Column<Contacto> it) {
        it.setTitle("Nombre y Apellido");
        it.setFixedSize(170);
        it.bindContentsToProperty("nombreApellido");
      }
    };
    ObjectExtensions.<Column<Contacto>>operator_doubleArrow(_column, _function_1);
    Column<Contacto> _column_1 = new Column<Contacto>(tablaNombreApellido);
    final Procedure1<Column<Contacto>> _function_2 = new Procedure1<Column<Contacto>>() {
      public void apply(final Column<Contacto> it) {
        it.setTitle("Favorito");
        it.setFixedSize(170);
        PropertyLabelProvider<Contacto> _bindContentsToProperty = it.bindContentsToProperty("favorito");
        final Transformer<Boolean, String> _function = new Transformer<Boolean, String>() {
          public String transform(final Boolean valorFavorito) {
            String _xifexpression = null;
            if ((valorFavorito).booleanValue()) {
              _xifexpression = "SI";
            } else {
              _xifexpression = "NO";
            }
            return _xifexpression;
          }
        };
        _bindContentsToProperty.setTransformer(_function);
      }
    };
    ObjectExtensions.<Column<Contacto>>operator_doubleArrow(_column_1, _function_2);
    Button _button = new Button(panelIzquierdo);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Favorito");
        final Action _function = new Action() {
          public void execute() {
            PantallaPrincipalVista.this.cambiarFavorito();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
        it.setWidth(20);
        it.<Object, ControlBuilder>bindEnabled(selectedUser);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_3);
    final Panel panelDerechoTitulo = new Panel(panelDerecho);
    final Panel panelDerechoCentro = new Panel(panelDerecho);
    final Panel panelDerechoBoton = new Panel(panelDerecho);
    Label _label = new Label(panelDerechoTitulo);
    _label.setText("Nuevo Contacto");
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panelDerechoCentro.setLayout(_columnLayout);
    Label _label_1 = new Label(panelDerechoCentro);
    _label_1.setText("Nombre y Apellido:");
    TextBox _textBox = new TextBox(panelDerechoCentro);
    final Procedure1<TextBox> _function_4 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "nuevoContacto.nombreApellido");
        it.setWidth(100);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_4);
    Label _label_2 = new Label(panelDerechoCentro);
    _label_2.setText("Teléfono:");
    TextBox _textBox_1 = new TextBox(panelDerechoCentro);
    final Procedure1<TextBox> _function_5 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "nuevoContacto.telefono");
        it.setWidth(100);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_5);
    Label _label_3 = new Label(panelDerechoCentro);
    _label_3.setText("email:");
    TextBox _textBox_2 = new TextBox(panelDerechoCentro);
    final Procedure1<TextBox> _function_6 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "nuevoContacto.email");
        it.setWidth(100);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_2, _function_6);
    Button _button_1 = new Button(panelDerechoBoton);
    final Procedure1<Button> _function_7 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agregar");
        final Action _function = new Action() {
          public void execute() {
            PantallaPrincipalVista.this.agregarContactoAAgenda();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_7);
  }
  
  public boolean cambiarFavorito() {
    return this.getModelObject().getContactoSeleccionado().toggleFavorito();
  }
  
  public void agregarContactoAAgenda() {
    this.getModelObject().agregarContacto();
    ObservableUtils.firePropertyChanged(this.getModelObject(), "contactos");
  }
}
