
package Data;

import static Data.ConexionBD.close;
import static Data.ConexionBD.getConnection;
import Domain.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TareasDAO {
                private static final String SQL_SELECT ="SELECT * FROM tareas";
             private static final String SQL_SELECTXID ="SELECT * FROM tareas where idTarea=";
             private static final String SQL_SELECTXID_PROYECTO ="SELECT * FROM tareas where idProyecto=";
    private static final String SQL_INSERT = "INSERT INTO tareas(nombre, descripcion, fechaInicio, fechaFin, finalizado, idProyecto,idEmpleado)VALUES";
    private static final String SQL_DELETE = "DELETE FROM tareas WHERE idTarea=";
    
    
    
        public List<Tarea> seleccionarTareas(){
     //Hacer una lista para poder insertarlas en la tabla HTML
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tarea tarea = null;
        List<Tarea> tarealist = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idTarea = rs.getInt("idTarea");
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String fechaInicio = rs.getString("fechaInicio");
            String fechaFin = rs.getString("fechaFin");
            boolean finalizado = rs.getBoolean("finalizado");
            int idProyecto = rs.getInt("idProyecto");
            int idEmpleado = rs.getInt("idEmpleado");
            
            tarea = new Tarea(idTarea,nombre,descripcion, fechaInicio, fechaFin, finalizado, idProyecto, idEmpleado);
            tarealist.add(tarea);
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);//Error de SQL
            
        }
        finally{
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);//Error de SQL
            }
        
        }
        return tarealist;
    }
        
                public List<Tarea> seleccionarTareasIdProyecto(int id){
     //Hacer una lista para poder insertarlas en la tabla HTML
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tarea tarea = null;
        List<Tarea> tarealist = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTXID_PROYECTO + id); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idTarea = rs.getInt("idTarea");
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String fechaInicio = rs.getString("fechaInicio");
            String fechaFin = rs.getString("fechaFin");
            boolean finalizado = rs.getBoolean("finalizado");
            int idProyecto = rs.getInt("idProyecto");
            int idEmpleado = rs.getInt("idEmpleado");
            
            tarea = new Tarea(idTarea,nombre,descripcion, fechaInicio, fechaFin, finalizado, idProyecto, idEmpleado);
            tarealist.add(tarea);
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);//Error de SQL
            
        }
        finally{
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);//Error de SQL
            }
        
        }
        return tarealist;
    }
        
     public String insertar (Tarea tarea){
         String sms ="";
       try { 
           ConexionBD Con = new ConexionBD();
           if (tarea.getNombre() != null) {
                            Con.ConectarBD();
                            int tareaF;
                            if(tarea.isFinalizado() == true) {
                                tareaF = 1;
                            } else { tareaF = 0;}
               Con.sentencia.execute(SQL_INSERT +"('"+tarea.getNombre()+"','"+tarea.getDescripcion()+"','"+tarea.getFechaInicio()+"','"+tarea.getFechaFin()+"','"+tareaF+"','"+tarea.getIdProyecto()+"','"+tarea.getIdEmpleado()+"')");
              sms = "Los Datos fueron Insertados con exito";
              Con.DesconectarBD();
           }
         } catch (SQLException ex) {
           sms=ex.toString();
          }
       return sms;
    }
     public String eliminar(Tarea tarea) throws SQLException{
         String sms ="";
           Connection conn=null;
           PreparedStatement stmt = null;
           int registros = 0;
       try{
            
            ConexionBD Con=new ConexionBD();
            Con.ConectarBD();
            conn =  getConnection();
            stmt = conn.prepareStatement(SQL_DELETE + tarea.getIdTarea());
            registros = stmt.executeUpdate();
            if(registros == 1) {
                sms="Eliminado";
            } else {
                sms="No Eliminado";
            }
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
       return sms;
    }
     
          public Tarea seleccionarTarea(int id){
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tarea tarea = null;
         try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTXID+id); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idTarea = rs.getInt("idTarea");
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String fechaInicio = rs.getString("fechaInicio");
            String fechaFin = rs.getString("fechaFin");
            boolean finalizado = rs.getBoolean("finalizado");
            int idProyecto = rs.getInt("idProyecto");
            int idEmpleado = rs.getInt("idEmpleado");
            
            tarea = new Tarea(idTarea,nombre,descripcion, fechaInicio, fechaFin, finalizado, idProyecto, idEmpleado);
            
             }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);//Error de SQL
            
        }
        finally{
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);//Error de SQL
            }
        
        }
        return tarea;
     }
          
     public String actualizar (Tarea tarea){
        String sms ="";
       String SQL_UPDATE ="UPDATE tareas SET nombre='"+tarea.getNombre()+"',descripcion='"+tarea.getDescripcion()+"',fechaInicio='"+tarea.getFechaInicio()+"',fechaFin='"+tarea.getFechaFin()+"',finalizado='"+tarea.isFinalizado()+"',idProyecto='"+tarea.getIdProyecto()+"',idEmpleado='"+tarea.getIdEmpleado()+"'  WHERE idTarea= "+tarea.getIdTarea();
     try { 
            ConexionBD Con=new ConexionBD();
            Con.ConectarBD();
            Con.sentencia.execute(SQL_UPDATE);
            sms="Registro Actualizado";
            Con.DesconectarBD();
        }catch (SQLException ex) {
            sms=ex.toString();
        }
       return sms;
    }
}
