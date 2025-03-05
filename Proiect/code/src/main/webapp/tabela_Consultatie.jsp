

<%@page import="DAOImpl.MediciDaoImpl"%>
<%@page import="DAOImpl.PacientiDaoImpl"%>
<%@page import="pojo.Medici"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Pacienti"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultatie</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergeConsultatie").hide();
                $("#modificaConsultatie").hide();

                $("#update").click(function () {
                    $("#modificaConsultatie").show();
                    $("#stergeConsultatie").hide();
                });
                $("#delete").click(function () {
                    $("#stergeConsultatie").show();
                    $("#modificaConsultatie").hide();
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
        <%
            PacientiDaoImpl pacientDaoImpl = new PacientiDaoImpl();
            MediciDaoImpl medicDaoImpl = new MediciDaoImpl();
            List<Pacienti> listaPacienti = new ArrayList();
            listaPacienti = pacientDaoImpl.afiseazaPacienti();
            List<Medici> listaMedici = new ArrayList();
            listaMedici = medicDaoImpl.afiseazaMedici();
            request.setAttribute("listaPacienti", listaPacienti);
            request.setAttribute("listaMedici", listaMedici);
        %>
        <h1 align="center"> Tabela Consultatie:</h1> 
        <table border="1" align="center">
            <tr>
                <td><b>IdConsultatie:</b></td>
                <td><b>IdPacient:</b></td>
                <td><b>Nume:</b></td>
                <td><b>Prenume:</b></td>
                <td><b>Adresa:</b></td>
                <td><b>IdMedic:</b></td>
                <td><b>Nume:</b></td>
                <td><b>Prenume:</b></td>
                <td><b>Sectie:</b></td>
                <td><b>DataConsultatie:</b></td>
                <td><b>Diagnostic:</b></td>
                <td><b>Medicament:</b></td>
            </tr>
            <c:forEach var="consultatie" items="${listaConsultatie}">
                <tr>
                    <td>${consultatie.idconsultatie}</td>
                    <td>${consultatie.pacienti.idpacient}</td>
                    <td>${consultatie.pacienti.nume}</td>
                    <td>${consultatie.pacienti.prenume}</td>
                    <td>${consultatie.pacienti.adresa}</td>
                    <td>${consultatie.medici.idmedic}</td>
                    <td>${consultatie.medici.nume}</td>
                    <td>${consultatie.medici.prenume}</td>
                    <td>${consultatie.medici.sectie}</td>
                    <td>${consultatie.dataConsultatie}</td>
                    <td>${consultatie.diagnostic}</td>
                    <td>${consultatie.medicament}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="ConsultatieController" method="POST">
            <p align="center">
                Modifica: <input type="checkbox" id="update"> Sterge: <input type="checkbox" id="delete" onclick="document.getElementById('idpacient').disabled = this.checked;
                        document.getElementById('idmedic').disabled = this.checked;
                        document.getElementById('dataConsultatie').disabled = this.checked;
                        document.getElementById('diagnostic').disabled = this.checked;
                        document.getElementById('medicament').disabled = this.checked;"><br><br>
                idconsultatie:
                <select name="idconsultatie">
                    <c:forEach items="${listaConsultatie}" var="consultatie">
                        <option value="${consultatie.idconsultatie}">${consultatie.idconsultatie}</option>
                    </c:forEach>
                </select>
                <br><br>
                idpacient:
                <select name="idpacient">
                    <c:forEach items="${listaPacienti}" var="pacienti">
                        <option value="${pacienti.idpacient}">${pacienti.idpacient}, ${pacienti.nume}, ${pacienti.prenume}</option>
                    </c:forEach>
                </select>
                <br><br>
                idmedic:
                <select name="idmedic">
                    <c:forEach items="${listaMedici}" var="medici">
                        <option value="${medici.idmedic}">${medici.idmedic}, ${medici.nume}, ${medici.prenume}</option>
                    </c:forEach>
                </select>
                <br><br>
                Modifica data consultatiei: <input id="nume" type="text" name="dataConsultatie"><br><br>
                Modifica diagnosticul: <input id="prenume" type="text" name="diagnostic"> <br><br>
                Modifica medicametul: <input id="sectie" type="text" name="medicament"> <br><br>
                <button type="submit" id="modificaConsultatie" name="modificaConsultatie"> Modifica</button> <br> <br>
                <button type="submit" id="stergeConsultatie" name="stergeConsultatie"> Sterge </button>
            </p>
        </form>
        <br>
        <p align="center">
            <a href="index.html"><b>Home</b></a>
        </p>
    </body>
</html>
