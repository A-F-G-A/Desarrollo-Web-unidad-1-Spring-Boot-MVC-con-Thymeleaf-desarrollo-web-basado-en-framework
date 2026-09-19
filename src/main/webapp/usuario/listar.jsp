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
    <title>Listar Usuarios - Sistema de Celulares</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .reporte-info {
            text-align: center;
            margin-bottom: 20px;
            padding: 10px;
            background-color: #e7f3ff;
            border-radius: 5px;
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
        <h1>Listado de Usuarios</h1>

        <% String reporte = request.getParameter("reporte"); %>
        <% String valor = request.getParameter("valor"); %>
        <% if (reporte != null && valor != null) { %>
            <div class="reporte-info">
                <% if (reporte.equals("rol")) { %>
                    <p>Reporte: Usuarios con rol = <%= valor %></p>
                <% } else if (reporte.equals("nombre")) { %>
                    <p>Reporte: Usuarios con nombre que contiene = <%= valor %></p>
                <% } %>
            </div>
        <% } %>

        <% if (session.getAttribute("usuario.listar") != null) { %>
            <% cel1.modelo.Usuario[] usuarios = (cel1.modelo.Usuario[]) session.getAttribute("usuario.listar"); %>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Rol</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (cel1.modelo.Usuario usuario : usuarios) { %>
                        <tr>
                            <td><%= usuario.getId() %></td>
                            <td><%= usuario.getNombre() %></td>
                            <td><%= usuario.getRol() %></td>
                            <td><%= usuario.getEmail() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
            <% session.removeAttribute("usuario.listar"); %>
        <% } else { %>
            <p>No hay usuarios para mostrar.</p>
        <% } %>

        <div class="volver">
            <a href="../index.jsp">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
