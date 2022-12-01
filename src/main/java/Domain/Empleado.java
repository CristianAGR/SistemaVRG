
package Domain;


public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String genero;
    private String rol;
    private int idEquipo;
    private String usuario;
    private String contraseña;
    
    //Constuctores

    public Empleado() {
    }

    // eliminar
    public Empleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    // insertar
     public Empleado(String nombre, String genero, String rol, int idEquipo, String usuario, String contraseña) {
        this.nombre = nombre;
        this.genero = genero;
        this.rol = rol;
        this.idEquipo = idEquipo;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    // editar
    public Empleado(int idEmpleado, String nombre, String genero, String rol, int idEquipo, String usuario, String contraseña) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.genero = genero;
        this.rol = rol;
        this.idEquipo = idEquipo;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    

        public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
            @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("idEmpleado=").append(idEmpleado);
        sb.append(", nombre=").append(nombre);
        sb.append(", genero=").append(genero);
        sb.append(", rol=").append(rol);
        sb.append(", idEquipo=").append(idEquipo);
        sb.append('}');
        return sb.toString();
    }


}
