<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp?mensaje=Debe iniciar sesión para acceder");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Reportes Usuarios - Sistema de Celulares</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
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
        .reporte-section {
            margin-bottom: 30px;
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 5px;
        }
        .reporte-section h2 {
            color: #007bff;
            margin-top: 0;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        input[type="text"], select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .volver {
            text-align: center;
            margin-top: 20px;
        }
        .volver a {
            color: #007bff;
            text-decoration: none;
        }
        .volver a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Reportes Parametrizados de Usuarios</h1>

        <div class="reporte-section">
            <h2>Reporte 1: Buscar Usuarios por Rol</h2>
            <form action="../usuario" method="POST">
                <input type="hidden" name="acción" value="buscarRol">
                <div class="form-group">
                    <label for="rol">Rol del Usuario:</label>
                    <select id="rol" name="rol" required>
                        <option value="">Seleccione un rol...</option>
                        <option value="admin">Administrador (admin)</option>
                        <option value="usuario">Usuario Estándar (usuario)</option>
                    </select>
                </div>
                <button type="submit">Generar Reporte por Rol</button>
            </form>
        </div>

        <div class="reporte-section">
            <h2>Reporte 2: Buscar Usuarios por Nombre</h2>
            <form action="../usuario" method="POST">
                <input type="hidden" name="acción" value="buscarNombre">
                <div class="form-group">
                    <label for="nombre">Nombre o Coincidencia:</label>
                    <input type="text" id="nombre" name="nombre" placeholder="Ej: Juan, María, Admin" required>
                </div>
                <button type="submit">Generar Reporte por Nombre</button>
            </form>
        </div>

        <div class="volver">
            <a href="../index.jsp">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
