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
    <title>Listar Celulares - Sistema de Celulares</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 1200px;
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
            font-size: 12px;
        }
        th, td {
            padding: 8px;
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
        <h1>Listado de Celulares</h1>

        <% String reporte = request.getParameter("reporte"); %>
        <% String valor = request.getParameter("valor"); %>
        <% if (reporte != null && valor != null) { %>
            <div class="reporte-info">
                <% if (reporte.equals("marca")) { %>
                    <p>Reporte: Celulares con marca que contiene = <%= valor %></p>
                <% } else if (reporte.equals("sistema")) { %>
                    <p>Reporte: Celulares con sistema operativo que contiene = <%= valor %></p>
                <% } else if (reporte.equals("operador")) { %>
                    <p>Reporte: Celulares con operador que contiene = <%= valor %></p>
                <% } %>
            </div>
        <% } %>

        <% if (session.getAttribute("celular.listar") != null) { %>
            <% cel1.modelo.Celular[] celulares = (cel1.modelo.Celular[]) session.getAttribute("celular.listar"); %>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Marca</th>
                        <th>IMEI</th>
                        <th>Pulgadas</th>
                        <th>Megapíxeles</th>
                        <th>RAM</th>
                        <th>Alm. Principal</th>
                        <th>Alm. Secundario</th>
                        <th>Sistema Operativo</th>
                        <th>Operador</th>
                        <th>Tecnología Banda</th>
                        <th>WiFi</th>
                        <th>Bluetooth</th>
                        <th>Cámaras</th>
                        <th>Marca CPU</th>
                        <th>Velocidad CPU</th>
                        <th>NFC</th>
                        <th>Huella</th>
                        <th>IR</th>
                        <th>Resiste Agua</th>
                        <th>Cantidad SIM</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (cel1.modelo.Celular celular : celulares) { %>
                        <tr>
                            <td><%= celular.getId() %></td>
                            <td><%= celular.getMarca() %></td>
                            <td><%= celular.getImei() %></td>
                            <td><%= celular.getPulgadas() %></td>
                            <td><%= celular.getMegapixeles() %></td>
                            <td><%= celular.getRam() %></td>
                            <td><%= celular.getAlmacenamientoPrincipal() %></td>
                            <td><%= celular.getAlmacenamientoSecundario() %></td>
                            <td><%= celular.getSistemaOperativo() %></td>
                            <td><%= celular.getOperador() %></td>
                            <td><%= celular.getTecnologiaBanda() %></td>
                            <td><%= celular.getWifi() %></td>
                            <td><%= celular.getBluetooth() %></td>
                            <td><%= celular.getCamaras() %></td>
                            <td><%= celular.getMarcaCpu() %></td>
                            <td><%= celular.getVelocidadCpu() %></td>
                            <td><%= celular.getNfc() %></td>
                            <td><%= celular.getHuella() %></td>
                            <td><%= celular.getIr() %></td>
                            <td><%= celular.getResisteAgua() %></td>
                            <td><%= celular.getCantidadSim() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
            <% session.removeAttribute("celular.listar"); %>
        <% } else { %>
            <p>No hay celulares para mostrar.</p>
        <% } %>

        <div class="volver">
            <a href="../index.jsp">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
