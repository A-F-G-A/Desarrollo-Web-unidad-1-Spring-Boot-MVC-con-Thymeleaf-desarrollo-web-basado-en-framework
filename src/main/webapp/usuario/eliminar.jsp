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
    <title>Eliminar Usuario - Sistema de Celulares</title>
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
            background-color: #dc3545;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #c82333;
        }
        .mensaje {
            text-align: center;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            background-color: #d4edda;
            color: #155724;
        }
        .usuario-info {
            background-color: #f8f9fa;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        .usuario-info p {
            margin: 5px 0;
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
        <h1>Eliminar Usuario</h1>
        <% String mensaje = request.getParameter("mensaje"); %>
        <% if (mensaje != null) { %>
            <div class="mensaje"><%= mensaje %></div>
        <% } %>

        <% if (session.getAttribute("usuario.buscar") != null) { %>
            <% cel1.modelo.Usuario usuario = (cel1.modelo.Usuario) session.getAttribute("usuario.buscar"); %>
            <div class="usuario-info">
                <p><strong>ID:</strong> <%= usuario.getId() %></p>
                <p><strong>Nombre:</strong> <%= usuario.getNombre() %></p>
                <p><strong>Rol:</strong> <%= usuario.getRol() %></p>
                <p><strong>Email:</strong> <%= usuario.getEmail() %></p>
            </div>
            <form action="../usuario" method="POST">
                <input type="hidden" name="acción" value="eliminar">
                <input type="hidden" name="id" value="<%= usuario.getId() %>">
                <button type="submit">Confirmar Eliminación</button>
            </form>
            <% session.removeAttribute("usuario.buscar"); %>
        <% } else { %>
            <form action="../usuario" method="POST">
                <input type="hidden" name="acción" value="buscar">
                <input type="hidden" name="redir" value="eliminar">
                <div class="form-group">
                    <label for="id">ID del Usuario a Eliminar:</label>
                    <input type="text" id="id" name="id" required>
                </div>
                <button type="submit">Buscar Usuario</button>
            </form>
        <% } %>

        <div class="volver">
            <a href="../index.jsp">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
