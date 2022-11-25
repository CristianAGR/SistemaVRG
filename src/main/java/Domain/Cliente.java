
package Domain;


public class Cliente {
    private int idCliente;
    private String nombre;
    private String empresa;
    private String numero;
    private String correo;
    private int idEquipo;
    //Constuctores

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }
     public Cliente(String nombre, String empresa, String numero, String correo, int idEquipo) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.numero = numero;
        this.correo = correo;
        this.idEquipo = idEquipo;
    }

    public Cliente(int idCliente,String nombre, String empresa, String numero, String correo, int idEquipo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.empresa = empresa;
        this.numero = numero;
        this.correo = correo;
        this.idEquipo = idEquipo;
    }
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
    
        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("idCliente=").append(idCliente);
        sb.append(", nombre=").append(nombre);
        sb.append(", empresa=").append(empresa);
        sb.append(", numero=").append(numero);
        sb.append(", correo=").append(correo);
        sb.append("idEquipo=").append(idEquipo);
        sb.append('}');
        return sb.toString();
    }
}
