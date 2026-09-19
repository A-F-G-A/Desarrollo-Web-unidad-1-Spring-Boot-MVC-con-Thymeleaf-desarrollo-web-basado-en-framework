<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modificar Celular - Sistema de Celulares</title>
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
        .form-row {
            display: flex;
            gap: 15px;
            margin-bottom: 15px;
        }
        .form-group {
            flex: 1;
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-size: 14px;
        }
        input[type="text"],
        select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
        }
        button {
            width: 100%;
            padding: 12px;
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
        <h1>Modificar Celular</h1>
        <% String mensaje = request.getParameter("mensaje"); %>
        <% if (mensaje != null) { %>
            <div class="mensaje"><%= mensaje %></div>
        <% } %>

        <% if (session.getAttribute("celular.buscar") != null) { %>
            <% cel1.modelo.Celular celular = (cel1.modelo.Celular) session.getAttribute("celular.buscar"); %>
            <form action="../celular" method="POST">
                <input type="hidden" name="acción" value="modificar">
                <div class="form-row">
                    <div class="form-group">
                        <label for="id">ID:</label>
                        <input type="text" id="id" name="id" value="<%= celular.getId() %>" readonly>
                    </div>
                    <div class="form-group">
                        <label for="marca">Marca:</label>
                        <input type="text" id="marca" name="marca" value="<%= celular.getMarca() %>" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="imei">IMEI:</label>
                        <input type="text" id="imei" name="imei" value="<%= celular.getImei() %>" required>
                    </div>
                    <div class="form-group">
                        <label for="pulgadas">Pulgadas:</label>
                        <input type="text" id="pulgadas" name="pulgadas" value="<%= celular.getPulgadas() %>" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="megapixeles">Megapíxeles:</label>
                        <input type="text" id="megapixeles" name="megapixeles" value="<%= celular.getMegapixeles() %>" required>
                    </div>
                    <div class="form-group">
                        <label for="ram">RAM:</label>
                        <input type="text" id="ram" name="ram" value="<%= celular.getRam() %>" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="almacenamientoPrincipal">Almacenamiento Principal:</label>
                        <input type="text" id="almacenamientoPrincipal" name="almacenamientoPrincipal" value="<%= celular.getAlmacenamientoPrincipal() %>" required>
                    </div>
                    <div class="form-group">
                        <label for="almacenamientoSecundario">Almacenamiento Secundario:</label>
                        <input type="text" id="almacenamientoSecundario" name="almacenamientoSecundario" value="<%= celular.getAlmacenamientoSecundario() %>" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="sistemaOperativo">Sistema Operativo:</label>
                        <input type="text" id="sistemaOperativo" name="sistemaOperativo" value="<%= celular.getSistemaOperativo() %>" required>
                    </div>
                    <div class="form-group">
                        <label for="operador">Operador:</label>
                        <input type="text" id="operador" name="operador" value="<%= celular.getOperador() %>" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="tecnologiaBanda">Tecnología Banda:</label>
                        <input type="text" id="tecnologiaBanda" name="tecnologiaBanda" value="<%= celular.getTecnologiaBanda() %>" required>
                    </div>
                    <div class="form-group">
                        <label for="wifi">WiFi:</label>
                        <select id="wifi" name="wifi" required>
                            <option value="Si" <%= celular.getWifi().equals("Si") ? "selected" : "" %>>Sí</option>
                            <option value="No" <%= celular.getWifi().equals("No") ? "selected" : "" %>>No</option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="bluetooth">Bluetooth:</label>
                        <select id="bluetooth" name="bluetooth" required>
                            <option value="Si" <%= celular.getBluetooth().equals("Si") ? "selected" : "" %>>Sí</option>
                            <option value="No" <%= celular.getBluetooth().equals("No") ? "selected" : "" %>>No</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="camaras">Cámaras:</label>
                        <input type="text" id="camaras" name="camaras" value="<%= celular.getCamaras() %>" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="marcaCpu">Marca CPU:</label>
                        <input type="text" id="marcaCpu" name="marcaCpu" value="<%= celular.getMarcaCpu() %>" required>
                    </div>
                    <div class="form-group">
                        <label for="velocidadCpu">Velocidad CPU:</label>
                        <input type="text" id="velocidadCpu" name="velocidadCpu" value="<%= celular.getVelocidadCpu() %>" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="nfc">NFC:</label>
                        <select id="nfc" name="nfc" required>
                            <option value="Si" <%= celular.getNfc().equals("Si") ? "selected" : "" %>>Sí</option>
                            <option value="No" <%= celular.getNfc().equals("No") ? "selected" : "" %>>No</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="huella">Huella:</label>
                        <select id="huella" name="huella" required>
                            <option value="Si" <%= celular.getHuella().equals("Si") ? "selected" : "" %>>Sí</option>
                            <option value="No" <%= celular.getHuella().equals("No") ? "selected" : "" %>>No</option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label for="ir">IR:</label>
                        <select id="ir" name="ir" required>
                            <option value="Si" <%= celular.getIr().equals("Si") ? "selected" : "" %>>Sí</option>
                            <option value="No" <%= celular.getIr().equals("No") ? "selected" : "" %>>No</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="resisteAgua">Resiste Agua:</label>
                        <select id="resisteAgua" name="resisteAgua" required>
                            <option value="Si" <%= celular.getResisteAgua().equals("Si") ? "selected" : "" %>>Sí</option>
                            <option value="No" <%= celular.getResisteAgua().equals("No") ? "selected" : "" %>>No</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="cantidadSim">Cantidad SIM:</label>
                    <input type="text" id="cantidadSim" name="cantidadSim" value="<%= celular.getCantidadSim() %>" required>
                </div>
                <button type="submit">Modificar Celular</button>
            </form>
            <% session.removeAttribute("celular.buscar"); %>
        <% } else { %>
            <form action="../celular" method="POST">
                <input type="hidden" name="acción" value="buscar">
                <input type="hidden" name="redir" value="modificar">
                <div class="form-group">
                    <label for="id">ID del Celular a Modificar:</label>
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
