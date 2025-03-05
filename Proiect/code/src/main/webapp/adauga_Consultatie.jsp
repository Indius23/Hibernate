
<%@ page import="DAOImpl.MediciDaoImpl" %>
<%@ page import="DAOImpl.PacientiDaoImpl" %>
<%@ page import="pojo.Medici" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.Pacienti" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultatie</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                color: #333;
                margin: 0;
                padding: 0;
            }
            
            h1 {
                text-align: center;
                color: #4CAF50;
                padding: 20px;
                margin-top: 20px;
            }

            #add {
                width: 60%;
                margin: 0 auto;
                background-color: #fff;
                padding: 30px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
                margin-top: 30px;
            }

            table {
                width: 100%;
                margin-top: 20px;
                border-collapse: collapse;
            }

            table td {
                padding: 10px;
                text-align: left;
                font-size: 14px;
            }

            select, input[type="text"], input[type="submit"] {
                width: 100%;
                padding: 8px;
                font-size: 14px;
                border-radius: 4px;
                border: 1px solid #ddd;
            }

            select:focus, input[type="text"]:focus {
                outline: none;
                border-color: #4CAF50;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            form {
                margin: 0;
            }

            a {
                text-decoration: none;
                color: #333;
                font-weight: bold;
                padding: 10px 20px;
                display: inline-block;
                border-radius: 4px;
                background-color: #ddd;
                margin-top: 30px;
            }

            a:hover {
                background-color: #bbb;
            }
        </style>

    </head>
    <body>

        <%
            PacientiDaoImpl pacientDaoImpl = new PacientiDaoImpl();
            MediciDaoImpl medicDaoImpl = new MediciDaoImpl();
            List<Pacienti> listaPacienti = pacientDaoImpl.afiseazaPacienti();
            List<Medici> listaMedici = medicDaoImpl.afiseazaMedici();
            request.setAttribute("listaPacienti", listaPacienti);
            request.setAttribute("listaMedici", listaMedici);
        %>

        <div id="add">
            <h1>Adauga o noua consultatie</h1>
            <form action="ConsultatieController" method="GET">
                <table>
                    <tr>
                        <td>Pacient:</td>
                        <td>
                            <select name="idpacient">
                                <c:forEach items="${listaPacienti}" var="pacienti">
                                    <option value="${pacienti.idpacient}">
                                        ${pacienti.idpacient}, ${pacienti.nume}, ${pacienti.prenume}, ${pacienti.adresa}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Medic:</td>
                        <td>
                            <select name="idmedic">
                                <c:forEach items="${listaMedici}" var="medici">
                                    <option value="${medici.idmedic}">
                                        ${medici.idmedic}, ${medici.nume}, ${medici.prenume}, ${medici.sectie}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Data Consultatie:</td>
                        <td><input type="text" name="dataConsultatie"></td>
                    </tr>
                    <tr>
                        <td>Diagnostic:</td>
                        <td><input type="text" name="diagnostic"></td>
                    </tr>
                    <tr>
                        <td>Medicament:</td>
                        <td><input type="text" name="medicament"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="adaugaConsultatie" value="Adauga"></td>
                    </tr>
                </table>
            </form>
        </div>

        <form action="ConsultatieController" method="POST" style="text-align: center;">
            <input type="submit" name="afiseazaConsultatie" value="Afiseaza Consultatiile">
        </form>

        <br>
        <a href="index.html">Home</a>

    </body>
</html>
