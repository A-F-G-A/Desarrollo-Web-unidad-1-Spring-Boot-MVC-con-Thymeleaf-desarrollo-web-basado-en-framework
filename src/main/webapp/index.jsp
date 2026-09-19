<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sistema de Gestión de Celulares</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 900px;
            margin: 50px auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .user-info {
            text-align: center;
            margin-bottom: 20px;
            padding: 15px;
            background-color: #e7f3ff;
            border-radius: 5px;
        }
        .menu-section {
            margin-bottom: 30px;
        }
        .menu-section h2 {
            color: #007bff;
            border-bottom: 2px solid #007bff;
            padding-bottom: 10px;
        }
        .menu-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 15px;
            margin-top: 15px;
        }
        .menu-item {
            padding: 15px;
            background-color: #f8f9fa;
            border-radius: 5px;
            text-align: center;
        }
        .menu-item a {
            display: block;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }
        .menu-item a:hover {
            color: #0056b3;
        }
        .logout {
            text-align: center;
            margin-top: 30px;
        }
        .logout a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #dc3545;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .logout a:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Sistema de Gestión de Celulares</h1>

        <% if (session.getAttribute("usuario") != null) { %>
            <% cel1.modelo.Usuario usuario = (cel1.modelo.Usuario) session.getAttribute("usuario"); %>
            <div class="user-info">
                <p>Bienvenido, <%= usuario.getNombre() %> (<%= usuario.getRol() %>)</p>
            </div>

            <div class="menu-section">
                <h2>Gestión de Usuarios</h2>
                <div class="menu-grid">
                    <div class="menu-item">
                        <a href="usuario/agregar.jsp">Agregar Usuario</a>
                    </div>
                    <div class="menu-item">
                        <a href="usuario/buscar.jsp">Buscar Usuario</a>
                    </div>
                    <div class="menu-item">
                        <a href="usuario/modificar.jsp">Modificar Usuario</a>
                    </div>
                    <div class="menu-item">
                        <a href="usuario/eliminar.jsp">Eliminar Usuario</a>
                    </div>
                    <div class="menu-item">
                        <a href="usuario?acción=listartodo">Listar Todos los Usuarios</a>
                    </div>
                </div>
            </div>

            <div class="menu-section">
                <h2>Reportes de Usuarios</h2>
                <div class="menu-grid">
                    <div class="menu-item">
                        <a href="usuario/reportes.jsp">Formulario de Reportes (Rol / Nombre)</a>
                    </div>
                    <div class="menu-item">
                        <a href="usuario?acción=buscarRol&rol=admin">Usuarios Administradores</a>
                    </div>
                    <div class="menu-item">
                        <a href="usuario?acción=buscarRol&rol=usuario">Usuarios Normales</a>
                    </div>
                </div>
            </div>

            <div class="menu-section">
                <h2>Gestión de Celulares</h2>
                <div class="menu-grid">
                    <div class="menu-item">
                        <a href="celular/agregar.jsp">Agregar Celular</a>
                    </div>
                    <div class="menu-item">
                        <a href="celular/buscar.jsp">Buscar Celular</a>
                    </div>
                    <div class="menu-item">
                        <a href="celular/modificar.jsp">Modificar Celular</a>
                    </div>
                    <div class="menu-item">
                        <a href="celular/eliminar.jsp">Eliminar Celular</a>
                    </div>
                    <div class="menu-item">
                        <a href="celular?acción=listartodo">Listar Todos los Celulares</a>
                    </div>
                    <div class="menu-item">
                        <a href="celular/reportes.jsp">Reportes de Celulares</a>
                    </div>
                </div>
            </div>

            <div class="logout">
                <a href="usuario?acción=logout">Cerrar Sesión</a>
            </div>
        <% } else { %>
            <div style="text-align: center;">
                <p>Bienvenido al Sistema de Gestión de Celulares</p>
                <p><a href="login.jsp" style="color: #007bff; text-decoration: none;">Iniciar Sesión</a></p>
            </div>
        <% } %>
    </div>
</body>
</html>
