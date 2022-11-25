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
    
    <style>
        
        .btn-guardar{
            background-color: transparent;
        }
        
        .btn-guardar:hover{
            background-color: white;
            color: black;
            cursor:pointer;
        }
    </style>
    
</head>
<body>

    
    <section  class="modal-bg-edit-display-editarProyecto">

        <form style="margin-bottom: 2rem;"  method="post" action="${pageContext.request.contextPath}/ServletControlador?accion=updateTarea&idTarea=${tarea.idTarea}&idProyecto=${tarea.idProyecto}">
            
            <div class="center-form">
            <div class="head-modal" style="display: flex; align-items: center;justify-content: space-between;">
                <div>
                    <h2>Editar Tarea</h2>
                    <p style="font-weight: 300; font-size: 12px;">Configuración de estado de la tarea</p>    
                </div>  
                <div>
                    <button
                    style="text-decoration: none; 
                    font-weight: 300; 
                    border: 1px solid rgba(255, 255, 255, 0.473);
                    padding: 10px 3rem;
                    border-radius: 5px;
                    margin-right: 2rem;
                    font-size: 1rem;    
                    "
                    class="btn-guardar"
                    type="submit">Guardar</button>
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
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input" type="text" placeholder="Nombre de la tarea" name="nombre"value="${tarea.nombre}">
                            </div>
    
                            <div style="display: block;">
                                <p class="label-modal">Descripción</p>
                                <textarea
                                placeholder="Descripción de la tarea"
                                style="width: 100%; margin-bottom: 1.5rem; resize: none;"
                                class="modal-input"
                                id="descripion-tarea" cols="30" rows="4" type="text" name="descripcion">${tarea.descripcion}</textarea>
                            </div>
                            
                            <div style="display: block;">
                                <p class="label-modal">Fecha de inicio</p>
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" name="fechaInicio"value="${tarea.fechaInicio}">
                            </div>
    
                            <div style="display: block;">
                                <p class="label-modal">Fecha de finalización</p>
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" name="fechaFin"value="${tarea.fechaFin}">
                            </div>
                            <div style="display: block;">
                                <p class="label-modal">Responsable</p>
                                <select  style="width: 100%;margin-bottom: 1.5rem;"class="modal-input" name="idEmpleado" required> 
                                    
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
            </div>
        </div>
            
        </form> 

        

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
