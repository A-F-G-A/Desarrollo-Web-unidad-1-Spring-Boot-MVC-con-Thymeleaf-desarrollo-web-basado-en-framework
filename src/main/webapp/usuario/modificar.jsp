<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modificar Usuario - Sistema de Celulares</title>
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
        input[type="text"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #ffc107;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #e0a800;
        }
        .mensaje {
            text-align: center;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            background-color: #d4edda;
            color: #155724;
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
        <h1>Modificar Usuario</h1>
        <% String mensaje = request.getParameter("mensaje"); %>
        <% if (mensaje != null) { %>
            <div class="mensaje"><%= mensaje %></div>
        <% } %>

        <% if (session.getAttribute("usuario.buscar") != null) { %>
            <% cel1.modelo.Usuario usuario = (cel1.modelo.Usuario) session.getAttribute("usuario.buscar"); %>
            <form action="../usuario" method="POST">
                <input type="hidden" name="acción" value="modificar">
                <div class="form-group">
                    <label for="id">ID:</label>
                    <input type="text" id="id" name="id" value="<%= usuario.getId() %>" readonly>
                </div>
                <div class="form-group">
                    <label for="clave">Clave:</label>
                    <input type="password" id="clave" name="clave" value="<%= usuario.getClave() %>" required>
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" value="<%= usuario.getNombre() %>" required>
                </div>
                <div class="form-group">
                    <label for="rol">Rol:</label>
                    <select id="rol" name="rol" required>
                        <option value="admin" <%= usuario.getRol().equals("admin") ? "selected" : "" %>>Administrador</option>
                        <option value="usuario" <%= usuario.getRol().equals("usuario") ? "selected" : "" %>>Usuario</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email" value="<%= usuario.getEmail() %>" required>
                </div>
                <button type="submit">Modificar Usuario</button>
            </form>
            <% session.removeAttribute("usuario.buscar"); %>
        <% } else { %>
            <form action="../usuario" method="POST">
                <input type="hidden" name="acción" value="buscar">
                <input type="hidden" name="redir" value="modificar">
                <div class="form-group">
                    <label for="id">ID del Usuario a Modificar:</label>
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
