<%-- 
    Document   : adauga_Pacient
    Created on : Nov 22, 2016, 6:19:27 PM
    Author     : vali
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pacienti</title>

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

            input[type="text"], input[type="submit"] {
                width: 100%;
                padding: 8px;
                font-size: 14px;
                border-radius: 4px;
                border: 1px solid #ddd;
            }

            input[type="text"]:focus {
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

        <div id="add">
            <h1>Adauga pacient</h1>
            <form action="PacientiController" method="GET">
                <table>
                    <tr>
                        <td>Nume Pacient:</td>
                        <td><input type="text" name="nume"></td>
                    </tr>
                    <tr>
                        <td>Prenume Pacient:</td>
                        <td><input type="text" name="prenume"></td>
                    </tr>
                    <tr>
                        <td>Adresa Pacient:</td>
                        <td><input type="text" name="adresa"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="adaugaPacient" value="Adauga"></td>
                    </tr>
                </table>
            </form>
        </div>

        <form action="PacientiController" method="POST" style="text-align: center;">
            <input type="submit" name="afiseazaPacienti" value="Afiseaza Pacientii">
        </form>

        <br>
        <a href="index.html">Home</a>

    </body>
</html>
