<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Buscar Usuario - Sistema de Celulares</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
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
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        input[type="text"] {
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
        .resultado {
            margin-top: 20px;
            padding: 15px;
            background-color: #f8f9fa;
            border-radius: 5px;
        }
        .resultado p {
            margin: 5px 0;
        }
        .acciones {
            margin-top: 15px;
        }
        .acciones a {
            display: inline-block;
            margin-right: 10px;
            padding: 8px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .acciones a:hover {
            background-color: #0056b3;
        }
        .volver {
            text-align: center;
            margin-top: 15px;
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
        <h1>Buscar Usuario</h1>
        <form action="../usuario" method="POST">
            <input type="hidden" name="acción" value="buscar">
            <div class="form-group">
                <label for="id">ID del Usuario:</label>
                <input type="text" id="id" name="id" required>
            </div>
            <button type="submit">Buscar</button>
        </form>

        <% if (session.getAttribute("usuario.buscar") != null) { %>
            <% cel1.modelo.Usuario usuario = (cel1.modelo.Usuario) session.getAttribute("usuario.buscar"); %>
            <div class="resultado">
                <p><strong>ID:</strong> <%= usuario.getId() %></p>
                <p><strong>Nombre:</strong> <%= usuario.getNombre() %></p>
                <p><strong>Rol:</strong> <%= usuario.getRol() %></p>
                <p><strong>Email:</strong> <%= usuario.getEmail() %></p>
                <div class="acciones">
                    <a href="../usuario?acción=buscar&id=<%= usuario.getId() %>&redir=modificar">Modificar</a>
                    <a href="../usuario?acción=buscar&id=<%= usuario.getId() %>&redir=eliminar">Eliminar</a>
                </div>
            </div>
            <% session.removeAttribute("usuario.buscar"); %>
        <% } %>

        <div class="volver">
            <a href="../index.jsp">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
