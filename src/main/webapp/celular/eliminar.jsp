<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eliminar Celular - Sistema de Celulares</title>
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
        .celular-info {
            background-color: #f8f9fa;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        .celular-info-grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 10px;
        }
        .celular-info-grid p {
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
        <h1>Eliminar Celular</h1>
        <% String mensaje = request.getParameter("mensaje"); %>
        <% if (mensaje != null) { %>
            <div class="mensaje"><%= mensaje %></div>
        <% } %>

        <% if (session.getAttribute("celular.buscar") != null) { %>
            <% cel1.modelo.Celular celular = (cel1.modelo.Celular) session.getAttribute("celular.buscar"); %>
            <div class="celular-info">
                <div class="celular-info-grid">
                    <p><strong>ID:</strong> <%= celular.getId() %></p>
                    <p><strong>Marca:</strong> <%= celular.getMarca() %></p>
                    <p><strong>IMEI:</strong> <%= celular.getImei() %></p>
                    <p><strong>Pulgadas:</strong> <%= celular.getPulgadas() %></p>
                    <p><strong>Sistema Operativo:</strong> <%= celular.getSistemaOperativo() %></p>
                    <p><strong>Operador:</strong> <%= celular.getOperador() %></p>
                </div>
            </div>
            <form action="../celular" method="POST">
                <input type="hidden" name="acción" value="eliminar">
                <input type="hidden" name="id" value="<%= celular.getId() %>">
                <button type="submit">Confirmar Eliminación</button>
            </form>
            <% session.removeAttribute("celular.buscar"); %>
        <% } else { %>
            <form action="../celular" method="POST">
                <input type="hidden" name="acción" value="buscar">
                <input type="hidden" name="redir" value="eliminar">
                <div class="form-group">
                    <label for="id">ID del Celular a Eliminar:</label>
                    <input type="text" id="id" name="id" required>
                </div>
                <button type="submit">Buscar Celular</button>
            </form>
        <% } %>

        <div class="volver">
            <a href="../index.jsp">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
