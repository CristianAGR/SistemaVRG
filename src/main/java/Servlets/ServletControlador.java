
package Servlets;

import Data.ClienteDAO;
import Data.EmpleadoDAO;
import Data.ProspectoDAO;
import Data.ProyectoDAO;
import Data.TareasDAO;
import Domain.Cliente;
import Domain.Empleado;
import Domain.Prospecto;
import Domain.Proyecto;
import Domain.Tarea;
import java.io.IOException;
import static java.lang.Boolean.valueOf;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author axelg
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

             @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editarProyecto":
                    this.editarProyecto(request, response);
                    break;
                case "editarTarea":
                    this.editarTarea(request, response);
                    break;
                case "eliminarTarea":
                {
                    try {
                        this.eliminarTarea(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
        private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
        HttpSession sesion = request.getSession();    
        // ======== Clientes ==========    
        List<Cliente> clientes = new ClienteDAO().seleccionarClientes();
        sesion.setAttribute("clientes", clientes);
        
        // ======== Proyectos ==========
        List<Proyecto> proyectos = new ProyectoDAO().seleccionarProyectos();
        sesion.setAttribute("proyectos", proyectos);
        
        // ======== Empleados ==========
        List<Empleado> empleados = new EmpleadoDAO().seleccionarEmpleados();
        sesion.setAttribute("empleados", empleados);
        
        // ======== Prospectos ==========
        List<Prospecto> prospectos = new ProspectoDAO().seleccionarProspectos();
        sesion.setAttribute("prospectos", prospectos);
        
        response.sendRedirect("menu.jsp");
    }
        
    private void editarProyecto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idProyecto
        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        Proyecto proyecto = new ProyectoDAO().seleccionarProyecto(idProyecto);
        // hacemos una lista de los empleados
        List<Empleado> empleados = new EmpleadoDAO().seleccionarEmpleados();
        // hacemos una lista de las tareas con el mismo id de Proyecto
        List<Tarea> tareas = new TareasDAO().seleccionarTareasIdProyecto(idProyecto);
        // enviamos los atributos
        request.setAttribute("proyecto", proyecto);
        request.setAttribute("tareas", tareas);
        request.setAttribute("empleados", empleados);
        
        // ingresamos la dirección del jsp al que se quiere ir
        String jspEditar = "/view/paginas/proyecto/editarProyecto.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void editarTarea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idTarea
        int idTarea = Integer.parseInt(request.getParameter("idTarea"));
        Tarea tarea = new TareasDAO().seleccionarTarea(idTarea);
        // hacemos una lista de los empleados
        List<Empleado> empleados = new EmpleadoDAO().seleccionarEmpleados();
        // enviamos el atributo
        request.setAttribute("tarea", tarea);
        request.setAttribute("empleados", empleados);
        
        // ingresamos la dirección del jsp al que se quiere ir
        String jspEditar = "/view/paginas/tarea/editarTarea.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void eliminarTarea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        //recuperamos los valores del formulario editarTarea
        int idTarea = Integer.parseInt(request.getParameter("idTarea"));
     
        //Creamos el objeto de tarea (modelo)
        Tarea tarea = new Tarea(idTarea);

        //Eliminamos el  objeto en la base de datos
        String registrosModificados = new TareasDAO().eliminar(tarea);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
        
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertarTarea":
                    this.insertarTarea(request, response);
                    break;
                case "updateTarea":
                    this.updateTarea(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void insertarTarea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarTarea
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");
        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        boolean finalizado = valueOf(request.getParameter("checkFinish"));

        //Creamos el objeto de tarea (modelo)
        Tarea tarea = new Tarea(nombre, descripcion, fechaInicio, fechaFin, finalizado,   idProyecto, idEmpleado);
        //Tarea tarea = new Tarea("tarea1", "tarea1", "07/12/22", "07/02/23", false,   1, 1);
        //Insertamos el nuevo objeto en la base de datos
        String registrosModificados = new TareasDAO().insertar(tarea);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
        private void updateTarea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            //recuperamos los valores del formulario editarTarea
        int idTarea = Integer.parseInt(request.getParameter("idTarea"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");
        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        boolean finalizado = valueOf(request.getParameter("checkFinish"));
        
        //Creamos el objeto de tarea (modelo)
        Tarea tarea = new Tarea(idTarea, nombre, descripcion, fechaInicio, fechaFin, finalizado,   idProyecto, idEmpleado);
        
        //Modificar el objeto en la base de datos
        String registrosModificados = new TareasDAO().actualizar(tarea);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }



}
