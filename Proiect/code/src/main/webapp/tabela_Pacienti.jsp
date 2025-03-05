

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pacienti</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergePacient").hide();
                $("#modificaPacient").hide();

                $("#update").click(function () {
                    $("#modificaPacient").show();
                    $("#stergePacient").hide();
                });
                $("#delete").click(function () {
                    $("#stergePacient").show();
                    $("#modificaPacient").hide();
                });
            });
        </script>
 <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 0;
            }

            h1 {
                color: #4CAF50;
                text-align: center;
                margin-top: 30px;
            }

            table {
                width: 90%;
                margin: 30px auto;
                border-collapse: collapse;
                background-color: #fff;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            th, td {
                padding: 12px;
                text-align: left;
                border: 1px solid #ddd;
            }

            th {
                background-color: #4CAF50;
                color: white;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            form {
                text-align: center;
                margin-top: 20px;
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            select, input[type="text"], button {
                padding: 10px;
                margin: 5px;
                font-size: 14px;
                border-radius: 5px;
                border: 1px solid #ccc;
            }

            button {
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            button:hover {
                background-color: #45a049;
            }

            a {
                text-decoration: none;
                color: #4CAF50;
                font-weight: bold;
                padding: 10px 20px;
                display: inline-block;
                margin-top: 20px;
                border-radius: 4px;
                background-color: #ddd;
            }

            a:hover {
                background-color: #bbb;
            }

            .form-group {
                margin-bottom: 15px;
            }

            .form-group input[type="checkbox"] {
                margin-top: 8px;
            }
        </style>
    </head>
    <body>
        <h1 align="center"> Tabela Pacienti:</h1> 
        <table border="1" align="center">
            <tr>
                <td><b>IdPacient:</b></td>
                <td><b>Nume:</b></td>
                <td><b>Prenume:</b></td>
                <td><b>Adresa:</b></td>
            </tr>
            <c:forEach var="pacienti" items="${listaPacienti}">
                <tr>
                    <td>${pacienti.idpacient}</td>
                    <td>${pacienti.nume}</td>
                    <td>${pacienti.prenume}</td>
                    <td>${pacienti.adresa}</td>

                </tr>
            </c:forEach>
        </table>
        <form action="PacientiController" method="POST">
            <p align="center">
                Modifica: <input type="checkbox" id="update"> Sterge: <input type="checkbox" id="delete" onclick="document.getElementById('nume').disabled = this.checked;
                        document.getElementById('prenume').disabled = this.checked;
                        document.getElementById('adresa').disabled = this.checked;"><br><br>
                <select name="idpacient">
                    <c:forEach items="${listaPacienti}" var="pacienti">
                        <option value="${pacienti.idpacient}">${pacienti.idpacient}</option>
                    </c:forEach>
                </select>
                <br><br>
                Modifica Nume: <input id="nume" type="text" name="nume"><br><br>
                Modifica Prenume: <input id="prenume" type="text" name="prenume"> <br><br>
                Modifica Adresa: <input id="adresa" type="text" name="adresa"> <br><br>
                <button type="submit" id="modificaPacient" name="modificaPacient"> Modifica</button> <br> <br>
                <button type="submit" id="stergePacient" name="stergePacient"> Sterge </button>
            </p>
        </form>
        <p align="center">
            <a href="index.html"><b>Home</b></a>
        </p>
    </body>
</html>
