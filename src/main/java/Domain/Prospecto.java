
package Domain;


public class Prospecto {
        private int idProspecto;
    private String nombre;
    private String empresa;
    private String numero;
    private String correo;
    private String fechaConsulta;
    private int idEquipo;
    
    //Constuctores

    public Prospecto() {
    }

    // eliminar
    public Prospecto(int idProspecto) {
        this.idProspecto = idProspecto;
    }
    // insertar
     public Prospecto(String nombre, String empresa, String numero, String correo, String fechaConsulta, int idEquipo) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.numero = numero;
        this.correo = correo;
        this.fechaConsulta = fechaConsulta;
        this.idEquipo = idEquipo;
    }
    // editar
    public Prospecto(int idProspecto,String nombre, String empresa, String numero, String correo, String fechaConsulta, int idEquipo) {
         this.idProspecto = idProspecto;
        this.nombre = nombre;
        this.empresa = empresa;
                this.numero = numero;
        this.correo = correo;
        this.fechaConsulta = fechaConsulta;
        this.idEquipo = idEquipo;
    }
    

    public int getIdProspecto() {
        return idProspecto;
    }

    public void setIdProspecto(int idProspecto) {
        this.idProspecto = idProspecto;
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
    
        public String getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(String fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
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
        sb.append("Prospecto{");
        sb.append("idProspecto=").append(idProspecto);
        sb.append(", nombre=").append(nombre);
        sb.append(", empresa=").append(empresa);
        sb.append(", numero=").append(numero);
        sb.append(", correo=").append(correo);
        sb.append(", fechaConsulta=").append(fechaConsulta);
        sb.append(", idEquipo=").append(idEquipo);
        sb.append('}');
        return sb.toString();
    }
    


    
    


}
