<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mensaje - Sistema de Celulares</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: 100px auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .mensaje {
            text-align: center;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
            background-color: #f8d7da;
            color: #721c24;
        }
        .volver {
            text-align: center;
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
        <h1>Mensaje del Sistema</h1>
        <% String mensaje = request.getParameter("mensaje"); %>
        <% if (mensaje != null) { %>
            <div class="mensaje">
                <%= mensaje %>
            </div>
        <% } else { %>
            <div class="mensaje">
                No hay mensaje disponible.
            </div>
        <% } %>
        <div class="volver">
            <a href="index.jsp">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
