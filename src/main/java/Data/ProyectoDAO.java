/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import static Data.ConexionBD.close;
import static Data.ConexionBD.getConnection;
import Domain.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author axelg
 */
public class ProyectoDAO {
            private static final String SQL_SELECT ="SELECT * FROM proyectos";
             private static final String SQL_SELECTXID ="SELECT idProyecto,nombre,tipoProyecto,fechaInicio,fechaFin,finalizado,idCliente FROM proyectos where idProyecto=";
    private static final String SQL_INSERT = "INSERT INTO proyectos(nombre,tipoProyecto,fechaInicio,fechaFin,finalizado,idCliente)VALUES";
    private static final String SQL_DELETE = "DELETE FROM proyectos WHERE idProyecto=";
    
    
    
        public List<Proyecto> seleccionarProyectos(){
     //Hacer una lista para poder insertarlas en la tabla HTML
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Proyecto proyecto = null;
        List<Proyecto> proyectolist = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idProyecto = rs.getInt("idProyecto");
            String nombre = rs.getString("nombre");
            String tipoProyecto = rs.getString("tipoProyecto");
            String fechaInicio = rs.getString("fechaInicio");
            String fechaFin = rs.getString("fechaFin");
            int finalizado = rs.getInt("finalizado");
            int idCliente = rs.getInt("idCliente");
            
            proyecto = new Proyecto(idProyecto,nombre,tipoProyecto,fechaInicio,fechaFin,finalizado,idCliente);
            proyectolist.add(proyecto);
            
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
        
        return proyectolist;
    }
        
     public String insertar (Proyecto proyecto){
         String sms ="";
       try { 
           ConexionBD Con = new ConexionBD();
           if (proyecto.getNombre() != null) {
               Con.ConectarBD();
               Con.sentencia.execute(SQL_INSERT +"('"+proyecto.getNombre()+"','"+proyecto.getTipoProyecto()+"','"+proyecto.getFechaInicio()+"','"+proyecto.getFechaFin()+"','"+proyecto.getFinalizado()+"','"+proyecto.getIdCliente()+"')");
              sms = "Los Datos fueron Insertados con exito";
              Con.DesconectarBD();
           }
         } catch (SQLException ex) {
           sms=ex.toString();
          }
       return sms;
    }
     public String eliminar(Proyecto proyecto) throws SQLException{
         String sms ="";
           Connection conn=null;
           PreparedStatement stmt = null;
           int registros = 0;
       try{
            
            ConexionBD Con=new ConexionBD();
            Con.ConectarBD();
            conn =  getConnection();
            stmt = conn.prepareStatement(SQL_DELETE + proyecto.getIdProyecto());
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
     
          public Proyecto seleccionarProyecto(int id){
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Proyecto proyecto = null;
         try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTXID+id); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idProyecto = rs.getInt("idProyecto");
            String nombre = rs.getString("nombre");
            String tipoProyecto = rs.getString("tipoProyecto");
            String fechaInicio = rs.getString("fechaInicio");
            String fechaFin = rs.getString("fechaFin");
            int finalizado = rs.getInt("finalizado");
            int idCliente = rs.getInt("idCliente");
            
            proyecto = new Proyecto(idProyecto,nombre,tipoProyecto,fechaInicio,fechaFin,finalizado,idCliente);
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
        return proyecto;
     }
          
     public String actualizar (Proyecto proyecto){
        String sms ="";
       String SQL_UPDATE ="UPDATE proyectos SET nombre='"+proyecto.getNombre()+"',tipoProyecto='"+proyecto.getTipoProyecto()+"',fechaInicio='"+proyecto.getFechaInicio()+"',fechaFin='"+proyecto.getFechaFin()+"',finalizado='"+proyecto.getFinalizado()+"',idCliente='"+proyecto.getIdCliente()+"' WHERE idProyecto = "+proyecto.getIdProyecto();
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
