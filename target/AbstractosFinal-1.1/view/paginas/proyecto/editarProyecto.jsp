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

<style>
    

    .checkProject{
        position: absolute;
        width: 350px;
        height: 350px;
        top:0;
        left: 0;
        opacity: 0;
    }
    
    .container-check{
        position: relative;
        overflow:hidden;
    }
    
    .btn-guardar-proyecto{
        color: #8b8c8d;
        transition: 0.3s;
        background-color: transparent;
        font-size: 1rem;
    }
    
    .btn-guardar-proyecto:hover{
        background-color: white;
        color: black;
    }
    
</style>

<body>
    <!-- Modal para agregar una tarea -->    
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
                    
                    
    <div style="overflow-y: scroll;height: 100vh">
        
         <section  class="modal-bg-edit-display-editarProyecto">
                
            <div class="center-form">
                <div class="content-project">
                    
                    <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificarProyecto&idProyecto=${proyecto.idProyecto}" method="POST" >
                        <div class="head-modal" style="display: flex; align-items: center;justify-content: space-between;">
                <div>
                    <h2>Editar proyecto</h2>
                    <p style="font-weight: 300; font-size: 12px;">Configuración de estado del proyecto</p>    
                </div>  
                <div>
                    <button
                         style=
                            "   text-decoration: none; 
                                cursor: pointer;
                                font-weight: 300; 
                                border: 1px solid rgba(255, 255, 255, 0.473);
                                padding: 10px 3rem;
                                border-radius: 5px;
                                margin-right: 2rem;
                            "
                        class="btn-guardar-proyecto" type="submit">
                        Guardar
                    </button>
                    <a 
                        style="text-decoration: none;
                        
                        font-weight: 300;
                        border: 1px solid rgba(255, 255, 255, 0.558);
                        padding: 10px 3rem;
                        border-radius: 5px;
                        margin-right: 2rem;
                        "
                        class="btn-guardar"
                        href="${pageContext.request.contextPath}/ServletControlador?accion=eliminarProyecto&idProyecto=${proyecto.idProyecto}">
                        Eliminar
                    </a>
                </div>  
            </div>

            <div style="padding: 0 4rem;">
                
                
                    <div style="display: flex; align-items: center; justify-content: space-between; width: 100%; margin-top: 2rem; margin-bottom: 1rem;">
                        <h4 style="color: white;">Formulario de proyectos  </h4>
                        <ul class="container-check">
                            <li>
                                <c:if test="${proyecto.finalizado == 0}">
                                    <input class="checkProject" type="checkbox" id="checkFinish" name="finalizado" value="1">
                                </c:if>
                                <c:if test="${proyecto.finalizado == 1}">
                                    <input checked class="checkProject" type="checkbox" id="checkFinish" name="finalizado" value="1">
                                </c:if>
                                <label for="checkFinish">
                                    <div style="display: flex; align-items: center; column-gap: 0.5rem;">
                                        <!-- <img class="mark-form" src="assets/checkmark-outline.svg" width="20"> -->
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
                                <input name="nombre" style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input" type="text" placeholder="Nombre del proyecto" required value="${proyecto.nombre}">
                            </div>
    
                            <div style="display: block;">
                                <p class="label-modal">Tipo de poyecto</p>
                                <input name="tipo" style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input" type="text" placeholder="Tipo de proyceto" value="${proyecto.tipoProyecto}">
                            </div>
                            
                            <div style="display: block;">
                                <p class="label-modal">Fecha de inicio</p>
<<<<<<< HEAD
                                <input name="fechaInicio" style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" required value="${proyecto.fechaInicio}">
=======
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date"  value="${proyecto.fechaInicio}">
>>>>>>> 42cbea22bd7ef820d34578c183b0d210391fd1ff
                            </div>
    
                            <div style="display: block;">
                                <p class="label-modal">Fecha de finalización</p>
<<<<<<< HEAD
                                <input name="fechaFin" style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" value="${proyecto.fechaFin}" >
=======
                                <input style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" value="${proyecto.fechaFin}">
>>>>>>> 42cbea22bd7ef820d34578c183b0d210391fd1ff
                            </div>
                            <div style="display: block;">
                                <p class="label-modal">Cliente</p>
                                <select  style="width: 100%;margin-bottom: 1.5rem;"class="modal-input" name="cliente" required>
                                        <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                        <c:if test="${cliente.idCliente == proyecto.idCliente}">
                                            <option class="option-modal" value="${cliente.idCliente}">${cliente.nombre}</option>
                                        </c:if>
                                    </c:forEach>
                                    <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                        <c:if test="${cliente.idCliente != proyecto.idCliente}">
                                            <option class="option-modal" value="${cliente.idCliente}">${cliente.nombre}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>  
                        </div>
                    </div>  
                    </div>
                    </form>
                
                <!-- ============= Comienza tabla de tareas ================ -->
                <div style="width: 100%; padding-bottom: 5rem; padding:2rem 4rem">
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
                            <a style="text-decoration: none" 
                               class="btn-editar-tarea"
                               href="${pageContext.request.contextPath}/ServletControlador?accion=editarTarea&idTarea=${tarea.idTarea}">
                                Editar
                            </a>
                        </div>
                        </c:forEach>
                       
                    </div>
    
                </div>

               
            </div>
            </div>

        

        </section>


    </div>
                            
                            

    <script>
        

        //Agregar proyecto
        let agregarTareaModal = document.getElementById('agregar-tarea-modal');
        let btnAgregarTarea = document.getElementById('btn-agregar-tarea');
        let btnCerrarModal = document.getElementById('cerrar-modal');
        
        btnAgregarTarea.addEventListener('click', () => {
            agregarTareaModal.style.display = "flex";
        });

        btnCerrarModal.addEventListener('click', () => {
            agregarTareaModal.style.display = "none";
        });


    </script>
    
</body>
</html>