<%-- 
    Document   : editarTarea
    Created on : 23 nov 2022, 11:23:11
    Author     : ricar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Editar Tarea</title>
</head>
<body>

    
    <section  class="modal-bg-edit-display-editarProyecto">

        <div class="center-form">
            <div class="head-modal" style="display: flex; align-items: center;justify-content: space-between;">
                <div>
                    <h2>Editar Tarea</h2>
                    <p style="font-weight: 300; font-size: 12px;">Configuración de estado de la tarea</p>    
                </div>  
                <div>
                    <a
                    style="text-decoration: none; 
                    
                    font-weight: 300; 
                    border: 1px solid rgba(255, 255, 255, 0.473);
                    padding: 10px 3rem;
                    border-radius: 5px;
                    margin-right: 2rem;
                    "
                    class="btn-guardar" href="#">Guardar</a>
                    <a 
                    style="text-decoration: none; 
                        
                        font-weight: 300;
                        border: 1px solid rgba(255, 255, 255, 0.558);
                        padding: 10px 3rem;
                        border-radius: 5px;
                        margin-right: 2rem;
                        "
                    class="btn-eliminar" href="${pageContext.request.contextPath}/ServletControlador?accion=eliminarTarea&idTarea=${tarea.idTarea}">Eliminar</a>
                </div>  
            </div>

            <div style="padding: 0 4rem;">
                
                <form style="margin-bottom: 2rem;" class="form-create" method="post">
                    <div style="display: flex; align-items: center; justify-content: space-between; width: 100%;">
                        <h4 style="color: white;">Formulario de tareas</h4>
                        <ul>
                            <li>
                                    <input style="opacity: 0;" type="checkbox" 
                                           <c:if test="${tarea.finalizado == true}">
                                               checked
                                           </c:if>
                                            id="checkFinish" name="checkFinish" value="true">
                                <label for="checkFinish">
                                    <div style="display: flex; align-items: center; column-gap: 0.5rem;">
                                        <img class="mark-form" src="assets/checkmark-outline.svg" width="20">
                                        Finalizar tarea
                                    </div>
                                </label>
                              </li>
                        </ul>

                    </div>

                    <div style="width: 100%;">
                        <div>

                            <div style="display: block">
                                <p class="label-modal">Nombre de la tarea</p>
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input" type="text" placeholder="Nombre de la tarea" value="${tarea.nombre}">
                            </div>
    
                            <div style="display: block;">
                                <p class="label-modal">Descripción</p>
                                <textarea
                                placeholder="Descripción de la tarea"
                                style="width: 100%; margin-bottom: 1.5rem; resize: none;"
                                class="modal-input"
                                name="descripcion-tarea" id="descripion-tarea" cols="30" rows="4" type="text">${tarea.descripcion}</textarea>
                            </div>
                            
                            <div style="display: block;">
                                <p class="label-modal">Fecha de inicio</p>
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" value="${tarea.fechaInicio}">
                            </div>
    
                            <div style="display: block;">
                                <p class="label-modal">Fecha de finalización</p>
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" value="${tarea.fechaFin}">
                            </div>
                            <div style="display: block;">
                                <p class="label-modal">Responsable</p>
                                <select  style="width: 100%;margin-bottom: 1.5rem;"class="modal-input" name="empleados" required> 
                                    
                                    <c:forEach var="empleado" items="${empleados}" varStatus="status">
                                        <option
                                        <c:if test="${empleado.idEmpleado == tarea.idEmpleado}">
                                          selected="selected"
                                        </c:if>
                                             class="option-modal" value="${empleado.idEmpleado}">${empleado.nombre}</option>
                                    </c:forEach>
                                    
                                </select>
                            </div>  
                        </div>
                    </div>  
                </form>
            </div>
        </div>

        

    </section>



    <script>

        //Agregar proyecto
        let agregarTareaModal = document.getElementById('agregar-tarea-modal')
        let btnAgregarTarea = document.getElementById('btn-agregar-tarea')
        let btnCerrarModal = document.getElementById('cerrar-modal')
        
        btnAgregarTarea.addEventListener('click', () => {
            agregarTareaModal.style.display = "flex"
        })

        btnCerrarModal.addEventListener('click', () => {
            agregarTareaModal.style.display = "none"
        })


    </script>

</body>
</html>
