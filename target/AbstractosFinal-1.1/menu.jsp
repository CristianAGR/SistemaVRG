<%@page import="Data.ClienteDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema VRG</title>
    <link rel="icon" type="image/x-icon" href="assets/logoSingleNew.ico">
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
    
    <!-- =============== INTRO APP =============== -->
    <div class="intro">
        <div class="center-rectangle">
            <img src="assets/Eclipse-1s-200px.svg" alt="loading" width="100px">
            <img class="logo" src="assets/logoVRG.svg" alt="logo" width="200px">
        </div>
    </div>

<!-- ========== Agregar Proyecto =============== -->
    <section 
    style="
    position: absolute; 
    z-index: 100;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.64);
    "

    id="agregar-proyecto-modal" 
    class="modal-bg-edit-display no-display">

        <article class="modal-project" style="z-index: 105;">

            <div class="head-modal" style="display: flex; justify-content: space-between; align-items: center;">
                <div>
                    <h2>Agregar proyecto</h2>
                <p style="font-weight: 300; font-size: 12px; margin-bottom: -1rem;">Configuración de estado del proyecto</p>
                </div>
                <p id="cerrar-modal" style="color: white; margin-right: 2rem; cursor: pointer;">Cerrar</p>
            </div>

            <div class="content-modal-edit" style="margin-top: -1rem;">
                
                <!-- =========== INSERT PROYECT ============== -->
                <form
                    action="${pageContext.request.contextPath}/ServletControlador?accion=insertarProyecto"
                    method="POST"
                    class="form-create" >
                    
                    <div style="display: flex; align-items: center; justify-content: space-between; width: 850px;">
                        <h4 style="color: white;">Formulario de proyectos</h4>
                    </div>

                    <div style="width: 100%; margin-top: 2rem;">
                        <div>

                            <div style="display: block">
                                <p class="label-modal">Nombre del proyecto</p>
                                <input name="nombre" style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input" type="text" placeholder="Nombre del proyecto">
                            </div>
    
                            <div style="display: block;">
                                <p class="label-modal">Tipo de poyecto</p>
                                <input name="tipo" style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input" type="text" placeholder="Tipo de proyecto">
                            </div>
                            
                            <div style="display: block;">
                                <p class="label-modal">Fecha de inicio</p>
                                <input name="fechaInicio" style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" >
                            </div>
    
                            <div style="display: block;">
                                <p class="label-modal">Fecha de finalización</p>
                                <input name="fechaFin" style="width: 100%;margin-bottom: 1.5rem;" required class="modal-input inpt-date" type="date" >
                            </div>
                            <div style="display: block;">
                                <p class="label-modal">Cliente</p>
                                <select name="cliente" style="width: 100%;margin-bottom: 1.5rem;"class="modal-input" required>
                                    <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                        <option class="option-modal" value="${cliente.idCliente}">${cliente.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>  
                        </div>
                        
                    </div>

                    <button type="submit" style="margin-top: -0.5rem;" class="btn-form">
                        Guardar proyecto
                    </button>

                    
                </form>

               
            </div>

        </article>

    </section>
    
    <main>
        <!-- Navbar -->
        <aside>
            <img class="aside-logo" src="assets/logoVRG.svg" alt="logo">
            <div class="items-nav">
                <div class="item-nav">
                    <img class="item-icon" src="assets/home-outline.svg" alt="">
                    <p class="item-text">Inicio</p>
                </div>
                <div class="item-nav">
                    <img class="item-icon" src="assets/checkmark-circle-outline.svg" alt="">
                    <p class="item-text">Mis tareas</p>
                </div>
                <div class="item-nav">
                    <img class="item-icon" src="assets/notifications-outline.svg" alt="">
                    <p class="item-text">Bandeja de entrada</p>
                </div>
                <div class="item-nav">
                    <img class="item-icon" src="assets/stats-chart-outline.svg" alt="">
                    <p class="item-text">Informes</p>
                </div>
                <div class="item-nav">
                    <img class="item-icon" src="assets/folder-outline.svg" alt="">
                    <p class="item-text">Portafolios</p>
                </div>
                <div class="item-nav">
                    <img class="item-icon" src="assets/library-outline.svg" alt="">
                    <p class="item-text">Objetivo</p>
                </div>
            </div>
            <div class="line"></div>

            <div class="team-aside">

                <h5 style="color: #807e80; margin-bottom: 10px;" >Equipos</h5>
                <p class="team-title" style="font-weight: 300; color: white; margin-bottom: 1rem;">Desarrollo Web</p>
                <div class="team-icons" style="margin-bottom: 1rem;">
                    <img class="profile-team" src="assets/Ellipse 1.svg" alt="">
                    <img class="profile-team" src="assets/Ellipse 2.svg" alt="">
                    <img class="profile-team" src="assets/Ellipse 3.svg" alt="">
                    <img class="profile-team" src="assets/Ellipse 4.svg" alt="">
                    <img class="profile-team" src="assets/Ellipse 5.svg" alt="">
                    <img class="profile-team" src="assets/Ellipse 6.svg" alt="">
                    <img class="profile-team" src="assets/Ellipse 7.svg" alt="">
                </div>

                <div class="project-name">
                    <div class="square square-1"></div>
                    <p class="item-text">RIDO</p>
                </div>

                <div class="project-name">
                    <div class="square square-2"></div>
                    <p class="item-text">07 ONU</p>
                </div>

                <div class="project-name">
                    <div class="square square-3"></div>
                    <p class="item-text">Java Serverlet</p>
                </div>

                <div class="project-name">
                    <div class="square square-4"></div>
                    <p class="item-text">Python IA</p>
                </div>

                <div class="project-name">
                    <div class="square square-5"></div>
                    <p class="item-text">PMI Project</p>
                </div>

                <p style="color: #9e9e9e; font-weight: 300; font-size: 12px; margin-top: 1rem; margin-bottom: 2rem;">Mostrar más proyectos</p>

                <div class="add-team">
                    <img style="filter: invert(52%) sepia(0%) saturate(1080%) hue-rotate(87deg) brightness(94%) contrast(84%);" src="assets/add-outline.svg" alt="add" width="20px">
                    <p style="color: #9e9e9e; font-weight: 300;">Agregar equipo</p>
                </div>
            </div>

            <div class="option-aside">
                <img src="assets/illustration_invite_teammates.svg" alt="invite">
                <p style="color: white; font-weight: 300;">Invitar a compañeros de equipo</p>                
            </div>

            <div class="option-aside" style="border-top: 1px solid #505051;">
                <img width="28px" style="filter: invert(54%) sepia(6%) saturate(5168%) hue-rotate(314deg) brightness(102%) contrast(88%);" src="assets/help-circle-outline.svg" alt="">
                <p style="color: white; font-weight: 300; ">Ayuda y puesta en marcha</p> 
            </div>

        </aside>

        <!-- Content -->
        <div class="content">


            <header>
                <div class="nav">
                    <h3 style="color: white;">Inicio</h3>
                    <div class="content-profile">
                        <input style="color: white;" class="search" type="text" placeholder="Buscar">
                        <img style="filter: invert(72%) sepia(5%) saturate(105%) hue-rotate(251deg) brightness(91%) contrast(80%);" width="35px" src="assets/add-circle-outline.svg" alt="add">
                        <div class="change-plan">
                            <p class="btn-nav">Cambiar de plan</p>
                        </div>
                        <img width="30px" src="assets/Ellipse 3.svg" alt="profile-img">
                    </div>
                </div>

                <div class="main-info">
                    <p style="color: white;">Miércoles, 9 de Novimebre</p>
                    <p style="color: white; font-size: 2.5rem;">Buen día, Fulanito</p>

                    <div style="margin-top: 2rem;" class="counter">

                        <div class="counter-item">
                            <p class="text-counter">Mi semana</p>
                            <img class="img-counter" src="assets/chevron-down-outline.svg" alt="" width="20">
                        </div>

                        <div class="vertical-line"></div>

                        <div class="counter-item">
                            <img class="img-counter" src="assets/checkmark-outline.svg" alt="" width="20">
                            <p class="count-counter">5</p>
                            <p class="text-counter">Tareas finalizadas</p>
                        </div>

                        <div class="counter-item">
                            <img class="img-counter" src="assets/people-outline.svg" alt="" width="20">
                            <p class="count-counter">7</p>
                            <p class="text-counter">Colaboradores</p>
                        </div>
                        

                        
                    </div>
                </div>

            </header>

            <section class="first-section" id="clientes">
                <div class="rectangle-section" >

                    <div class="title-rectangle">
                        <img width="40px" src="assets/Ellipse 3.svg" alt="profile-img">
                        <h3 style="color: white; font-size: 1.5rem;">Clientes</h3>
                        <img style="filter: invert(72%) sepia(0%) saturate(834%) hue-rotate(74deg) brightness(91%) contrast(89%);" width="20px" src="assets/lock-closed-outline.svg" alt="">
                    </div>

                    <!-- ================== SE RENDERIZAN LAS CARDS DE LOS CLIENTES ================== -->
                    
                    <div class="horizontal-container">
                        <!-- Iteramos cada elemento de la lista de clientes -->
                        <c:forEach var="cliente" items="${clientes}" varStatus="status" >
                        <div style="position: relative;" class="cliente-card">
                            <div class="circle-name">
                                ${cliente.nombre.substring(0,2).toUpperCase()}
                            </div>
                            <h5 style="color: white;margin-top: 1rem; margin-bottom: 5px;">${cliente.nombre}</h5>
                            <p style="color: white; font-weight: 300;font-size: .8rem;">${cliente.empresa}</p>
                            <div class="btn-profile" >
                                Ver perfil
                            </div>
                        </div>
                        </c:forEach>
                    </div>

                </div>

                

                <div class="rectangle-section" id="proyectos">
                    <div style="border-bottom: none;" class="title-rectangle">
                        <h3 style="color: white; font-size: 1.5rem; ">Proyectos</h3>
                    </div>

                    <div class="projects-container">

                        <!-- ========== CREATE PROJECT ========== -->
                        <div id="btn-agregar-proyecto" class="create-project">
                            <img width="50" src="assets/addProject.svg" alt="">
                            <h3 style="font-size: 0.9rem;">Crear proyecto</h3>
                        </div>

                        <!-- ========= SHOW PROJECTS ============= -->
                        <c:forEach var="proyecto" items="${proyectos}" varStatus="status" > 
                            <% ClienteDAO cliente = new ClienteDAO(); %>
                        <a
                            style="text-decoration: none"
                            href="${pageContext.request.contextPath}/ServletControlador?accion=editarProyecto&idProyecto=${proyecto.idProyecto}"
                                           class="btn btn-secondary">
                           <div class="project">
                             <img width="50" src="assets/proectIcon.svg" alt="">
                             <div style="display: flex; flex-direction: column;">
                                 <h3 style="font-size: 0.9rem;">
                                     ${proyecto.nombre}
                                 </h3>
                                 <p style="color: #969799; font-weight: 300; font-size: 12px;">${proyecto.tipoProyecto}</p>
                             </div>
                           </div>
                        </a>
                        </c:forEach>
                    </div>

                </div>
            </section>

            <section class="second-section">
                <div class="full-section">
                    <div style="border-bottom: none; display: flex; align-items: center;" class="title-rectangle">
                        <h3 style="color: white; font-size: 1.5rem; ">Empleados</h3>
                        <p style="font-size: 12px;color: #969799;">Colaboradores frecuentes</p>
                    </div>

                    <!-- ================== SE RENDERIZAN LAS CARDS DE LOS EMPLEADOS ================== -->
                    
                    <div class="horizontal-container" style="margin-top: -0.2rem;">
                        <c:forEach var="empleado" items="${empleados}" varStatus="status">
                        <div style="position: relative;" class="cliente-card">
                            <div class="circle-name">
                                ${empleado.nombre.substring(0,2).toUpperCase()}
                            </div>
                            <h5 style="color: white;margin-top: 1rem; margin-bottom: 5px;">${empleado.nombre}</h5>
                            <p style="color: white; font-weight: 300;font-size: .8rem;">${empleado.rol}</p>
                            <div class="btn-profile" >
                                Ver perfil
                            </div>
                        </div>
                        </c:forEach>

                        

                </div>
                </div>
            </section>

            <section class="second-section">
                <div class="full-section">
                    <div style="border-bottom: none; display: flex; align-items: center;" class="title-rectangle">
                        <h3 style="color: white; font-size: 1.5rem; ">Prospectos</h3>
                        <p style="font-size: 12px;color: #969799;">Últimos de este mes</p>
                    </div>

                    <!-- ================== SE RENDERIZAN LAS CARDS DE LOS PROSPECTOS ================== -->
                    
                    <div class="horizontal-container" style="margin-top: -0.2rem;">

                        <c:forEach var="prospecto" items="${prospectos}" varStatus="status">
                            <div style="position: relative;" class="cliente-card">
                            <div class="circle-name">
                                ${prospecto.nombre.substring(0,2).toUpperCase()}
                            </div>
                            <h5 style="color: white;margin-top: 1rem; margin-bottom: 5px;">${prospecto.nombre}</h5>
                            <p style="color: white; font-weight: 300;font-size: .8rem;">${prospecto.empresa}</p>
                            <div class="btn-profile" >
                                Ver perfil
                            </div>
                        </div>
                        </c:forEach>

                        
                </div>
                </div>
            </section>

        </div>

    </main>



    <script>
        // ============= ANIMACION DE INICIO DE LA PAGINA =============
        let intro = document.querySelector('.intro')
        window.addEventListener('DOMContentLoaded', () => {
            //Desktop
            document.body.classList.add('stop-scrolling')
            //Mobile
            //document.body.addEventListener("touchmove", function(e){e.preventDefault()} )
            setTimeout(() => {
                intro.style.animation = "hiddeIntro 0.5s"
                setTimeout(() => {
                    intro.style.display = "none";
                    document.body.classList.remove('stop-scrolling')
                    //document.body.removeEventListener('touchmove')
                }, "500")
            }, "2000")
            
        })

        let checkFinish = document.querySelector('#checkFinish')
        let imgFinish = document.querySelector('.mark-form')
        
        
        //Agregar proyecto
        let agregarProyectoModal = document.getElementById('agregar-proyecto-modal')
        let btnAgregarProyecto = document.getElementById('btn-agregar-proyecto')
        let btnCerrarModal = document.getElementById('cerrar-modal')
        
        btnAgregarProyecto.addEventListener('click', () => {
            agregarProyectoModal.style.display = "flex"
        })

        btnCerrarModal.addEventListener('click', () => {
            agregarProyectoModal.style.display = "none"
        })
        
        
        // ========= ANIMACION DE BOTONES ================
        checkFinish.addEventListener('change', e => {
        if(e.target.checked === true) {
            console.log("Checkbox is checked - boolean value: ", e.target.checked)
            imgFinish.style.filter = "invert(56%) sepia(22%) saturate(660%) hue-rotate(102deg) brightness(88%) contrast(85%)"
        }
        if(e.target.checked === false) {
            console.log("Checkbox is not checked - boolean value: ", e.target.checked)
            imgFinish.style.filter = "invert(61%) sepia(47%) saturate(0%) hue-rotate(181deg) brightness(91%) contrast(88%)"
        }
        });
        

    </script>


</body>
</html>
