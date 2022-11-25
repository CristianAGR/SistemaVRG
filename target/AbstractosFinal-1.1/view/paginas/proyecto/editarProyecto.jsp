<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Editar Proyecto</title>
</head>
<body>

    <div style="overflow-y: scroll;height: 100vh">
            <!-- ======= MODAL EDITAR TAREA =========== -->
    <section
    style="
    position: absolute; 
    z-index: 100;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.64);
    height: 100%;
    "
    id="agregar-tarea-modal"
    class="modal-bg-edit-display no-display">

        <article class="modal-project">

            <div class="head-modal" style="display: flex; justify-content: space-between; align-items: center;">
                <div>
                    <h2>Agregar tarea</h2>
                    <p style="font-weight: 300; font-size: 12px; margin-bottom: -1rem;">Configuración de estado de la tarea</p>
                </div>
                <p id="cerrar-modal" style="color: white; margin-right: 2rem; cursor: pointer;">Cerrar</p>
            </div>

            <div class="content-modal-edit" style="margin-top: -1rem;">
                
                <form class="form-create" method="post" action="${pageContext.request.contextPath}/ServletControlador?accion=insertarTarea&idProyecto=${proyecto.idProyecto}">
                    <div style="display: flex; align-items: center; justify-content: space-between; width: 850px;">
                        <h4 style="color: white;">Formulario de tareas</h4>
                        <ul>
                            <li>
                                <input style="opacity: 0;" type="checkbox" id="checkFinish" name="checkFinish" value="true">
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
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input" type="text" placeholder="Nombre de la tarea" name="nombre" required>
                            </div>
    
                            <div style="display: block; margin-bottom: 1rem;">
                                <p class="label-modal">Descripción de la tarea</p>
                                <textarea 
                                style="width: 100%; resize: none;"
                                required 
                                name="descripcion" 
                                id="descripcion-tarea" 
                                class="modal-input" rows="2" >
                            </textarea>
                            
                            </div>
                            
                            <div style="display: block;">
                                <p class="label-modal">Fecha de inicio</p>
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" name="fechaInicio" >
                            </div>
    
                            <div style="display: block;">
                                <p class="label-modal">Fecha de finalización</p>
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" name="fechaFin">
                            </div>
                            <div style="display: block;" id="empleados">
                                <p class="label-modal">Responsable</p>
                                
                                <select  style="width: 100%;margin-bottom: 1.5rem;"class="modal-input" name="idEmpleado" required>
                                    <option class="option-modal" value="1">${proyecto.nombre}</option>
                                    <option class="option-modal" value="2">Ricardo2</option>
                                    <option class="option-modal" value="3">Ricardo3</option>
                                    
                                    <c:forEach var="empleado" items="${empleados}" varStatus="status" >
                                    <option class="option-modal" value="${empleado.idEmpleado}">${empleado.nombre}</option>
                                    </c:forEach>
                                    
                                </select>
                                
                            </div>  
                        </div>
                        
                    </div>
                                    
                    <button style="margin-top: -0.5rem;" class="btn-form" type="submit">Guardar proyecto</button>
                    
                </form>

               
            </div>

        </article>

    </section>
    
    <section  class="modal-bg-edit-display-editarProyecto">

        <div class="center-form">
            <div class="head-modal" style="display: flex; align-items: center;justify-content: space-between;">
                <div>
                    <h2>Editar proyecto</h2>
                    <p style="font-weight: 300; font-size: 12px;">Configuración de estado del proyecto</p>    
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
                    class="btn-eliminar" href="#">Eliminar</a>    
                </div>  
            </div>

            <div style="padding: 0 4rem;">
                
                <form style="margin-bottom: 2rem;" class="form-create" method="post">
                    <div style="display: flex; align-items: center; justify-content: space-between; width: 100%;">
                        <h4 style="color: white;">Formulario de proyectos</h4>
                        <ul>
                            <li>
                                <input style="opacity: 0;" type="checkbox" id="checkFinish" name="checkFinish" value="checkFinish">
                                <label for="checkFinish">
                                    <div style="display: flex; align-items: center; column-gap: 0.5rem;">
                                        <img class="mark-form" src="assets/checkmark-outline.svg" width="20">
                                        Finalizar proyecto
                                    </div>
                                </label>
                              </li>
                        </ul>

                    </div>

                    <div style="width: 100%;">
                        <div>

                            <div style="display: block">
                                <p class="label-modal">Nombre del proyecto</p>
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input" type="text" placeholder="Nombre del proyecto" required value="${proyecto.nombre}">
                            </div>
    
                            <div style="display: block;">
                                <p class="label-modal">Tipo de poyecto</p>
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input" type="text" placeholder="Tipo de proyceto" value="${proyecto.tipoProyecto}">
                            </div>
                            
                            <div style="display: block;">
                                <p class="label-modal">Fecha de inicio</p>
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" required value="${proyecto.fechaInicio}">
                            </div>
    
                            <div style="display: block;">
                                <p class="label-modal">Fecha de finalización</p>
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" >
                            </div>
                            <div style="display: block;">
                                <p class="label-modal">Cliente</p>
                                <select  style="width: 100%;margin-bottom: 1.5rem;"class="modal-input" name="empleados" required>
                                    <option class="option-modal" value="ricardo">Ricardo</option>
                                    <option class="option-modal" value="ricardo">Ricardo</option>
                                    <option class="option-modal" value="ricardo">Ricardo</option>
                                    
                                </select>
                            </div>  
                        </div>
                    </div>  
                </form>

                <div style="width: 100%; padding-bottom: 5rem;">
                    <div class="table">
                        <div style="display: flex; justify-content: space-between;">
                            <h3 style="color: white; font-weight: 400;">Tareas</h3>
                            <p style="cursor: pointer;" id="btn-agregar-tarea" class="btn-crear-tarea">Crear Tarea</p>
                        </div>
                        <!-- Main Title DO NOT MODIFY -->
                        <div class="row-table">
                            <p class="text-table">ID</p>
                            <p class="text-table">Nombre de la tarea</p>
                            <p class="text-table">Responsable</p>
                            <p class="text-table">Fecha inicio</p>
                            <p class="text-table">Fecha entrega</p>
                            <p class="text-table">Descripción</p>
                            <p class="text-table">Estado de tarea</p>
                            <p class="text-table">Editar</p>
                        </div>
    
                        <!-- Task Render  -->
                        <c:forEach var="tarea" items="${tareas}" varStatus="status">
                        <div class="row-table">
                            <p class="text-table">${tarea.idTarea}</p>
                            <p class="text-table">${tarea.nombre}</p>
                            <c:forEach var="empleado" items="${empleados}" varStatus="status">
                                <c:if test="${empleado.idEmpleado == tarea.idEmpleado}">
                                <p class="text-table">${empleado.nombre}</p>
                            </c:if>
                            </c:forEach>
                            <p class="text-table">${tarea.fechaInicio}</p>
                            <p class="text-table">${tarea.fechaFin}</p>
                            <p class="text-table">${tarea.descripcion}</p>
                            <c:if  test="${tarea.finalizado == true}" >
                                <p class="text-table">Finalizado</p>
                            </c:if>
                            <c:if  test="${tarea.finalizado == false}" >
                                <p class="text-table">No Finalizado</p>
                            </c:if>
                            <a class="btn-editar-tarea" href="#">Editar</a>
                        </div>
                        </c:forEach>
                       
                    </div>
    
                </div>

               
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
    </div>

</body>
</html>