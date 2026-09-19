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
    <title>Agregar Celular - Sistema de Celulares</title>
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
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #218838;
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
        <h1>Agregar Celular</h1>
        <% String mensaje = request.getParameter("mensaje"); %>
        <% if (mensaje != null) { %>
            <div class="mensaje"><%= mensaje %></div>
        <% } %>
        <form action="../celular" method="POST">
            <input type="hidden" name="acción" value="agregar">
            <div class="form-row">
                <div class="form-group">
                    <label for="id">ID:</label>
                    <input type="text" id="id" name="id" required>
                </div>
                <div class="form-group">
                    <label for="marca">Marca:</label>
                    <input type="text" id="marca" name="marca" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="imei">IMEI:</label>
                    <input type="text" id="imei" name="imei" required>
                </div>
                <div class="form-group">
                    <label for="pulgadas">Pulgadas:</label>
                    <input type="text" id="pulgadas" name="pulgadas" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="megapixeles">Megapíxeles:</label>
                    <input type="text" id="megapixeles" name="megapixeles" required>
                </div>
                <div class="form-group">
                    <label for="ram">RAM:</label>
                    <input type="text" id="ram" name="ram" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="almacenamientoPrincipal">Almacenamiento Principal:</label>
                    <input type="text" id="almacenamientoPrincipal" name="almacenamientoPrincipal" required>
                </div>
                <div class="form-group">
                    <label for="almacenamientoSecundario">Almacenamiento Secundario:</label>
                    <input type="text" id="almacenamientoSecundario" name="almacenamientoSecundario" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="sistemaOperativo">Sistema Operativo:</label>
                    <input type="text" id="sistemaOperativo" name="sistemaOperativo" required>
                </div>
                <div class="form-group">
                    <label for="operador">Operador:</label>
                    <input type="text" id="operador" name="operador" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="tecnologiaBanda">Tecnología Banda:</label>
                    <input type="text" id="tecnologiaBanda" name="tecnologiaBanda" required>
                </div>
                <div class="form-group">
                    <label for="wifi">WiFi:</label>
                    <select id="wifi" name="wifi" required>
                        <option value="">Seleccione...</option>
                        <option value="Si">Sí</option>
                        <option value="No">No</option>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="bluetooth">Bluetooth:</label>
                    <select id="bluetooth" name="bluetooth" required>
                        <option value="">Seleccione...</option>
                        <option value="Si">Sí</option>
                        <option value="No">No</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="camaras">Cámaras:</label>
                    <input type="text" id="camaras" name="camaras" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="marcaCpu">Marca CPU:</label>
                    <input type="text" id="marcaCpu" name="marcaCpu" required>
                </div>
                <div class="form-group">
                    <label for="velocidadCpu">Velocidad CPU:</label>
                    <input type="text" id="velocidadCpu" name="velocidadCpu" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="nfc">NFC:</label>
                    <select id="nfc" name="nfc" required>
                        <option value="">Seleccione...</option>
                        <option value="Si">Sí</option>
                        <option value="No">No</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="huella">Huella:</label>
                    <select id="huella" name="huella" required>
                        <option value="">Seleccione...</option>
                        <option value="Si">Sí</option>
                        <option value="No">No</option>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="ir">IR:</label>
                    <select id="ir" name="ir" required>
                        <option value="">Seleccione...</option>
                        <option value="Si">Sí</option>
                        <option value="No">No</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="resisteAgua">Resiste Agua:</label>
                    <select id="resisteAgua" name="resisteAgua" required>
                        <option value="">Seleccione...</option>
                        <option value="Si">Sí</option>
                        <option value="No">No</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="cantidadSim">Cantidad SIM:</label>
                <input type="text" id="cantidadSim" name="cantidadSim" required>
            </div>
            <button type="submit">Agregar Celular</button>
        </form>
        <div class="volver">
            <a href="../index.jsp">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
