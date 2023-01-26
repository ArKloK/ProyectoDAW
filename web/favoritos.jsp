<%-- 
    Document   : favoritos
    Created on : 26-ene-2023, 16:34:46
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="Entities.Articulos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>PracticaDAW</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/ProyectoDAW/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="/ProyectoDAW/estilos_login.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body class="container-fluid">
        <header class="d-flex justify-content-center">
            <a href="index.html" class="text-decoration-none"><h1 class="text-center text-uppercase" style="color:#EEEEEE;" id="titulo">Videojuegos de Segunda Mano</h1></a>
        </header>
        <nav class="navbar navbar-light bg-gradient navbar-expand-lg" style="background-color: #8EC8DB;" id="navmenu"></nav>

        <section>
            <h2>Listado de los articulos disponibles</h2>
            <table class="table table-dark table-striped table-bordered align-middle">
                <tr>
                    <th class="text-center">Imagen</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Categoria</th>
                    <th>Estado</th>
                </tr>
                <%
                    try {
                        List<Articulos> articulos = (List<Articulos>) request.getAttribute("articulosfavoritos");
                        for (Articulos art : articulos) {
                            out.println("<tr>");
                            out.println("<td class='text-center'><img width='100px' height='100px' src='../img_articulos/" + art.getId() + ".jpg' alt='No encontrado'></td>");
                            out.println("<td>" + art.getNombre() + "</td>");
                            out.println("<td>" + art.getPrecio() + "</td>");
                            out.println("<td>" + art.getCategoria() + "</td>");
                            out.println("<td>" + art.getEstado() + "</td>");
                            out.println("</tr>");
                        }
                    } catch (Exception e) {}

                %>
            </table>
        </section>

        <div class="footers align-items-end">
            <footer id="footer">Carlos Camacho banez&copy; 2022</footer>
        </div>

        <script src="/ProyectoDAW/codex_login.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
