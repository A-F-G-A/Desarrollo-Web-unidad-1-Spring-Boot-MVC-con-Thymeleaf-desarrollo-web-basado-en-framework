<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Reportes Celulares - Sistema de Celulares</title>
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
        .reporte-section {
            margin-bottom: 30px;
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 5px;
        }
        .reporte-section h2 {
            color: #007bff;
            margin-top: 0;
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
        <h1>Reportes de Celulares</h1>

        <div class="reporte-section">
            <h2>Reporte 1: Buscar por Marca</h2>
            <form action="../celular" method="POST">
                <input type="hidden" name="acción" value="buscarMarca">
                <div class="form-group">
                    <label for="marca">Marca:</label>
                    <input type="text" id="marca" name="marca" placeholder="Ej: Samsung, Apple, Xiaomi" required>
                </div>
                <button type="submit">Buscar por Marca</button>
            </form>
        </div>

        <div class="reporte-section">
            <h2>Reporte 2: Buscar por Sistema Operativo</h2>
            <form action="../celular" method="POST">
                <input type="hidden" name="acción" value="buscarSistema">
                <div class="form-group">
                    <label for="sistemaOperativo">Sistema Operativo:</label>
                    <input type="text" id="sistemaOperativo" name="sistemaOperativo" placeholder="Ej: Android, iOS" required>
                </div>
                <button type="submit">Buscar por Sistema Operativo</button>
            </form>
        </div>

        <div class="reporte-section">
            <h2>Reporte 3: Buscar por Operador</h2>
            <form action="../celular" method="POST">
                <input type="hidden" name="acción" value="buscarOperador">
                <div class="form-group">
                    <label for="operador">Operador:</label>
                    <input type="text" id="operador" name="operador" placeholder="Ej: Claro, Movistar, Tigo" required>
                </div>
                <button type="submit">Buscar por Operador</button>
            </form>
        </div>

        <div class="volver">
            <a href="../index.jsp">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
