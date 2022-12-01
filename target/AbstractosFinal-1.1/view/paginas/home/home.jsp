<%-- 
    Document   : home
    Created on : 30 nov 2022, 7:17:55
    Author     : ricar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema VRG</title>
        <link rel="icon" type="image/x-icon" href="../../../assets/logoSingleNew.ico">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap" rel="stylesheet">
        
        <style>

        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }

        body{
            background-color: white;
        }

        nav{
            height: 10vh;
            width: 100%;
            display: flex;
            padding: 1.5rem 3rem;
            justify-content: space-between;
            align-items: center;
        }

        .nav-links{
            display: flex;
            column-gap: 2rem;
            font-size: 0.9rem;
            align-items: center;
        }

        .nav-link{
            list-style: none;
            text-decoration: none;
            font-weight: 500;
            color: rgba(128, 128, 128, 0.816);
        }

        .btn-nav{
            padding: 8px 1.5rem;
            background-color: black;
            color: white;
            font-size: 0.9rem;
            border-radius: 5px;
            font-weight: 500;
        }

        .content{
            display: flex;
            padding: 2rem 8rem;
            justify-content: center;
            column-gap: 6rem;
            align-items: center;
            height: 90vh;
        }

        .col-1{
            width: 500px;
        }

        h1{
            font-weight: 400;
            font-size: 3rem;
        }

        .btn-google{
            border: 1px solid rgba(0, 0, 0, 0.350);
            display: flex;
            align-items: center;
            justify-content: center;
            column-gap: 1rem;
            padding: 10px 0;
            margin-top: 2rem;
        }

        .terms{
            font-size: 0.8rem;
            margin-top: 5rem;
            font-weight: 300;
            color: rgba(0, 0, 0, 0.749);
        }

    </style>
    </head>
    <body>
        <main>
        <nav>
            <div style="display: flex;">
                <ul class="nav-links">
                    <img src="../../../assets/logoNegro.svg" alt="logo" width="150">
                <li class="nav-link">¿Por qué usar Sistema VRG?</li>
                <li class="nav-link">Funciones</li>
                <li class="nav-link">Recursos</li>
                <li class="nav-link">Enterprise</li>
                <li class="nav-link">Precios</li>
            </ul>
            </div>
            <div style="display: flex; align-items: center; column-gap: 2rem;">
                <div style="height: 30px; width: 1px; background-color: rgba(128, 128, 128, 0.472);"></div>
                <p class="nav-link gray-link">Contactar a Ventas</p>
                <a href="../../../view/paginas/home/login.jsp" class="nav-link gray-link">Iniciar sesión</a>
                <div class="btn-nav">Comenzar</div>
            </div>
        </nav>


        <div class="content">
            <div class="col-1">
                <h1>Los equipos no pierden de vista el trabajo gracias a Sistema VRG</h1>
                <p style="color: rgba(128, 128, 128, 0.9); font-size: 1.5rem; font-weight: 300; margin-top: 3rem;">Mira los planes, da seguimiento al progreso y mantén las conversaciones laborales en un solo lugar. Si gestionas los proyectos con Asana, estarás al tanto de todo lo que hace tu equipo.</p>
                <div class="btn-google">
                    <img src="../../../assets/google.svg" alt="google" width="32">
                    Registrate con tu cuenta de trabajo de Google</div>
                <p class="terms">
                    Al registrarme, acepto la Política de privacidad y los Términos de servicio de Asana.
                </p>
            </div>
            <div class="col-2">
                <img src="../../../assets/hero-vrg.png" alt="hero">
            </div>
        </div>


    </main>
    </body>
</html>
