package bean.specificimplementation;

import com.google.gson.annotations.Expose;
import bean.genericimplementation.TableGenericBeanImplementation;
import bean.helper.MetaBeanHelper;
import bean.meta.publicinterface.MetaObjectBeanInterface;
import bean.meta.publicinterface.MetaPropertyBeanInterface;
import helper.EnumHelper;
import helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "usuario",
        SingularDescription = "Usuario",
        PluralDescription = "Usuarios",
        Icon = "fa fa-user",
        Type = EnumHelper.SourceType.Table
)
public class UsuarioSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Nombre completo",
            LongName = "Nombre completo",
            Description = "Nombre completo del usuario",
            Type = EnumHelper.FieldType.Calculated,
            IsForeignKeyDescriptor = true,
            Width = 3,
            MaxLength = 100
    )
    private String nombrecompleto;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Nombre",
            LongName = "Nombre",
            Description = "Nombre del usuario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String nombre;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "1er. Ap.",
            LongName = "Primer Apellido",
            Description = "Primer Apellido del usuario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String primer_apellido;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "2º Ap.",
            LongName = "Segundo Apellido",
            Description = "Segundo Apellido del usuario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String segundo_apellido;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Tel.1",
            LongName = "Teléfono 1",
            Description = "Primer teléfono del usuario",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 20,
            IsVisible = false
    )
    private String telefono;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Dir.",
            LongName = "Dirección",
            Description = "Dirección del cliente",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = RegexConstants.direction,
            RegexHelp = RegexConstants.directionSentence_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String direccion;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "email",
            LongName = "Correo electrónico",
            Description = "Correo electrónico del usuario",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.email,
            RegexHelp = RegexConstants.email_Help,
            MaxLength = 50,
            IsVisible = false
    )
    private String email;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Cod. Postal",
            LongName = "Código Postal",
            Description = "Código Postal del cliente",
            Type = EnumHelper.FieldType.Integer,
            RegexPattern = "[0-9]{5,5}",
            RegexHelp = "5 dígitos",
            IsRequired = false,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 5,
            IsVisible = false
    )
    private String codigo_postal;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "login",
            LongName = "Login",
            Description = "Login para entrar en el sistema",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.nameWithEndingNumbers,
            RegexHelp = RegexConstants.nameWithEndingNumbers_Help,
            MaxLength = 15
    )
    private String login;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.Password
    )
    private String password;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "¿Encargado?",
            LongName = "¿Usuario encargado?",
            Description = "¿Usuario encargado?",
            Type = EnumHelper.FieldType.Boolean,
            IsRequired = true,
            IsVisible = true
    )
    private Integer encargado;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_tipousuario = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Tipo",
            LongName = "Tipo usuario",
            Description = "Tipo de usuario",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "tipousuario",
            Width = 4
    )
    private MetaBeanHelper obj_tipousuario = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_tienda = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Tienda",
            LongName = "Id tienda",
            Description = "Tienda a la que pertenece",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "tienda",
            Width = 4
    )
    private MetaBeanHelper obj_tienda = null;

    public UsuarioSpecificBeanImplementation() {
    }

    public UsuarioSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    @Override
    public void ComputeCalculatedFields() {
        this.nombrecompleto = this.nombre + " " + this.primer_apellido + " " + this.segundo_apellido;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEncargado() {
        return encargado;
    }

    public void setEncargado(Integer encargado) {
        this.encargado = encargado;
    }

    public Integer getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(Integer id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public MetaBeanHelper getObj_tipousuario() {
        return obj_tipousuario;
    }

    public void setObj_tipousuario(MetaBeanHelper obj_tipousuario) {
        this.obj_tipousuario = obj_tipousuario;
    }

    public Integer getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(Integer id_tienda) {
        this.id_tienda = id_tienda;
    }

    public MetaBeanHelper getObj_tienda() {
        return obj_tienda;
    }

    public void setObj_tienda(MetaBeanHelper obj_tienda) {
        this.obj_tienda = obj_tienda;
    }

}
