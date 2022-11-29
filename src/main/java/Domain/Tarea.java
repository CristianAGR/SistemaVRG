
package Domain;


public class Tarea {
    private int idTarea;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private boolean finalizado;
    private int idProyecto;
    private int idEmpleado;


    
    //Constuctores

    public Tarea() {
    }

    // eliminar
    public Tarea(int idTarea) {
        this.idTarea = idTarea;
    }
    // insertar
     public Tarea(String nombre, String descripcion, String fechaInicio, String fechaFin, boolean finalizado, int idProyecto, int idEmpleado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.finalizado = finalizado;
        this.idProyecto = idProyecto;
        this.idEmpleado = idEmpleado;
    }
    // editar
    public Tarea(int idTarea,String nombre, String descripcion, String fechaInicio, String fechaFin, boolean finalizado, int idProyecto, int idEmpleado) {
         this.idTarea = idTarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.finalizado = finalizado;
        this.idProyecto = idProyecto;
        this.idEmpleado = idEmpleado;
    }
    

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tarea{");
        sb.append("idTarea=").append(idTarea);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", fechaFin=").append(fechaFin);
        sb.append(", finalizado=").append(finalizado);
        sb.append(", idProyecto=").append(idProyecto);
        sb.append(", idEmpleado=").append(idEmpleado);
        sb.append('}');
        return sb.toString();
    }
}
