
package Data;

import static Data.ConexionBD.close;
import static Data.ConexionBD.getConnection;
import Domain.Prospecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProspectoDAO {
            private static final String SQL_SELECT ="SELECT * FROM prospectos";
             private static final String SQL_SELECTXID ="SELECT * FROM productos where idProspecto=";
    private static final String SQL_INSERT = "INSERT INTO prospectos(nombre,empresa, numero, correo, fechaConsulta, idEquipo)VALUES";
    private static final String SQL_DELETE = "DELETE FROM prospectos WHERE idProspecto=";
    
    
    
        public List<Prospecto> seleccionarProspectos(){
     //Hacer una lista para poder insertarlas en la tabla HTML
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Prospecto prospecto = null;
        List<Prospecto> prospectolist = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idProspecto = rs.getInt("idProspecto");
            String nombre = rs.getString("nombre");
            String empresa = rs.getString("empresa");
            String numero = rs.getString("numero");
            String correo = rs.getString("correo");
            String fechaConsulta = rs.getString("fechaConsulta");
            int idEquipo = rs.getInt("idEquipo");
            
            prospecto = new Prospecto(idProspecto,nombre,empresa, numero, correo, fechaConsulta, idEquipo);
            prospectolist.add(prospecto);
            
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
        
        return prospectolist;
    }
        
     public String insertar (Prospecto prospecto){
         String sms ="";
       try { 
           ConexionBD Con = new ConexionBD();
           if (prospecto.getNombre() != null) {
                            Con.ConectarBD();
               Con.sentencia.execute(SQL_INSERT +"('"+prospecto.getNombre()+"','"+prospecto.getEmpresa()+"','"+prospecto.getNumero()+"','"+prospecto.getCorreo()+"','"+prospecto.getFechaConsulta()+"','"+prospecto.getIdEquipo()+"')");
              sms = "Los Datos fueron Insertados con exito";
              Con.DesconectarBD();
           }
         } catch (SQLException ex) {
           sms=ex.toString();
          }
       return sms;
    }
     public String eliminar(Prospecto prospecto) throws SQLException{
         String sms ="";
           Connection conn=null;
           PreparedStatement stmt = null;
           int registros = 0;
       try{
            
            ConexionBD Con=new ConexionBD();
            Con.ConectarBD();
            conn =  getConnection();
            stmt = conn.prepareStatement(SQL_DELETE + prospecto.getIdProspecto());
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
     
          public Prospecto seleccionarProspecto(int id){
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Prospecto prospecto = null;
         try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTXID+id); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
            int idProspecto = rs.getInt("idProspecto");
            String nombre = rs.getString("nombre");
            String empresa = rs.getString("empresa");
            String numero = rs.getString("numero");
            String correo = rs.getString("correo");
            String fechaConsulta = rs.getString("fechaConsulta");
            int idEquipo = rs.getInt("idEquipo");
            
            prospecto = new Prospecto(idProspecto,nombre,empresa, numero, correo, fechaConsulta, idEquipo);
            
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
        return prospecto;
     }
          
     public String actualizar (Prospecto prospecto){
        String sms ="";
       String SQL_UPDATE ="UPDATE prospectos SET nombre='"+prospecto.getNombre()+"',empresa='"+prospecto.getEmpresa()+"',numero='"+prospecto.getNumero()+"',correo='"+prospecto.getCorreo()+"',fechaConsulta='"+prospecto.getFechaConsulta()+"',idEquipo='"+prospecto.getIdEquipo()+"'  WHERE idProspectos= "+prospecto.getIdProspecto();
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
