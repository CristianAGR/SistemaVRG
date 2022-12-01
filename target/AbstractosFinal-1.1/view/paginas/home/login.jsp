<%-- 
    Document   : login
    Created on : 30 nov 2022, 7:18:46
    Author     : ricar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/x-icon" href="../../../assets/logoSingleNew.ico">
        <title>Inicar sesión</title>
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

        main{
            width: 100%;
            height: 100vh;
            background-color: #F9F8F8;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .card{
            height: 600px;
            width: 450px;
            background-color: white;
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            box-shadow: -2px 10px 29px 3px rgba(0,0,0,0.22);
            -webkit-box-shadow: -2px 10px 29px 3px rgba(0,0,0,0.22);
            -moz-box-shadow: -2px 10px 29px 3px rgba(0,0,0,0.22);
        }

        form{
            margin: 2rem 0;
            display: flex;
            flex-direction: column;
        }

        label{
            font-size: 0.8rem;
        }

        input{
            outline: none;
            width: 320px;
            height: 42px;
            border: 1px solid gray;
            border-radius: 5px;
            padding-left: 1rem;
        }

        button{
            height: 42px;
            outline: none;
            background-color: #726AB9;
            border: none;
            color: white;
            border-radius: 5px;
            font-weight: 500;
        }
    </style>

</head>
<body>

    <main>
        <div class="card">
            <img src="../../../assets/logoSVG.svg" alt="logo" width="100" style="margin-bottom: -2rem;">
            <h3 style="font-weight: 500; font-size: 1.5rem; text-align: center; margin-top: 2rem; color: #000000c1;">Iniciar sesión</h3>
            <div style="width: 420px; height: 1px;"></div>
            <form method="post"action="${pageContext.request.contextPath}/ServletControlador?accion=login">
                <label for="usuario">Nombre de usuario</label>
                <input type="text" name="usuario" required>

                <label for="usuario" style="margin-top: 1.5rem;">Contraseña</label>
                <input type="text" name="contrasenia">

                <button type="submit" style="margin-top: 2rem; cursor: pointer;">
                    Inicar sesión
                </button>
            </form>

            <p style="font-size: 0.9rem;">¿No tienes cuenta? <span style="color: #726AB9;">Registrate</span></p>
            <p style="text-align: center; font-size: 0.7rem; width: 320px; margin-top: 1rem;">Este sitio está protegido por reCAPTCHA y se rige bajo la Política de privacidad y los Términos del servicio de Google.</p>
        </div>
    </main>
    
</body>
</html>
