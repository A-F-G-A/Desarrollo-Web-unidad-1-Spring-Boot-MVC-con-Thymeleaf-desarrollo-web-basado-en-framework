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
    <title>Buscar Celular - Sistema de Celulares</title>
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
        .resultado-grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 10px;
        }
        .resultado-grid p {
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
        <h1>Buscar Celular</h1>
        <form action="../celular" method="POST">
            <input type="hidden" name="acción" value="buscar">
            <div class="form-group">
                <label for="id">ID del Celular:</label>
                <input type="text" id="id" name="id" required>
            </div>
            <button type="submit">Buscar</button>
        </form>

        <% if (session.getAttribute("celular.buscar") != null) { %>
            <% cel1.modelo.Celular celular = (cel1.modelo.Celular) session.getAttribute("celular.buscar"); %>
            <div class="resultado">
                <div class="resultado-grid">
                    <p><strong>ID:</strong> <%= celular.getId() %></p>
                    <p><strong>Marca:</strong> <%= celular.getMarca() %></p>
                    <p><strong>IMEI:</strong> <%= celular.getImei() %></p>
                    <p><strong>Pulgadas:</strong> <%= celular.getPulgadas() %></p>
                    <p><strong>Megapíxeles:</strong> <%= celular.getMegapixeles() %></p>
                    <p><strong>RAM:</strong> <%= celular.getRam() %></p>
                    <p><strong>Almacenamiento Principal:</strong> <%= celular.getAlmacenamientoPrincipal() %></p>
                    <p><strong>Almacenamiento Secundario:</strong> <%= celular.getAlmacenamientoSecundario() %></p>
                    <p><strong>Sistema Operativo:</strong> <%= celular.getSistemaOperativo() %></p>
                    <p><strong>Operador:</strong> <%= celular.getOperador() %></p>
                    <p><strong>Tecnología Banda:</strong> <%= celular.getTecnologiaBanda() %></p>
                    <p><strong>WiFi:</strong> <%= celular.getWifi() %></p>
                    <p><strong>Bluetooth:</strong> <%= celular.getBluetooth() %></p>
                    <p><strong>Cámaras:</strong> <%= celular.getCamaras() %></p>
                    <p><strong>Marca CPU:</strong> <%= celular.getMarcaCpu() %></p>
                    <p><strong>Velocidad CPU:</strong> <%= celular.getVelocidadCpu() %></p>
                    <p><strong>NFC:</strong> <%= celular.getNfc() %></p>
                    <p><strong>Huella:</strong> <%= celular.getHuella() %></p>
                    <p><strong>IR:</strong> <%= celular.getIr() %></p>
                    <p><strong>Resiste Agua:</strong> <%= celular.getResisteAgua() %></p>
                    <p><strong>Cantidad SIM:</strong> <%= celular.getCantidadSim() %></p>
                </div>
                <div class="acciones">
                    <a href="../celular?acción=buscar&id=<%= celular.getId() %>&redir=modificar">Modificar</a>
                    <a href="../celular?acción=buscar&id=<%= celular.getId() %>&redir=eliminar">Eliminar</a>
                </div>
            </div>
            <% session.removeAttribute("celular.buscar"); %>
        <% } %>

        <div class="volver">
            <a href="../index.jsp">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
