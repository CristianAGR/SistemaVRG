
package Domain;


public class Proyecto {
    private int idProyecto;
    private String nombre;
    private String tipoProyecto;
    private String fechaInicio;
    private String fechaFin;
    private boolean finalizado;
    private int idCliente;
    //Constuctores

    public Proyecto() {
    }

    public Proyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
     public Proyecto(String nombre, String tipoProyecto, String fechaInicio, String fechaFin, int idCliente, boolean finalizado) {
        this.nombre = nombre;
        this.tipoProyecto = tipoProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idCliente = idCliente;
        this.finalizado = finalizado;
    }

    public Proyecto(int idProyecto,String nombre, String tipoProyecto, String fechaInicio, String fechaFin, boolean finalizado, int idCliente) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.tipoProyecto = tipoProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.finalizado = finalizado;
        this.idCliente = idCliente;
    }
    

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
   
    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
            @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proyecto{");
        sb.append("idProyecto=").append(idProyecto);
        sb.append(", nombre=").append(nombre);
        sb.append(", tipoProyecto=").append(tipoProyecto);
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", fechaFin=").append(fechaFin);
        sb.append(", finalizado=").append(finalizado);
        sb.append("idCliente=").append(idCliente);
        sb.append('}');
        return sb.toString();
    }
}
