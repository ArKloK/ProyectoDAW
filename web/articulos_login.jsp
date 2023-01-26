<%@page import="java.util.List"%>
<%@page import="Entities.Articulos"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/html.html to edit this template
-->
<html>
    <head>
        <title>PracticaDAW</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
        <link href="/ProyectoDAW/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="/ProyectoDAW/estilos_login.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <header class="d-flex justify-content-center">
            <a href="index.html" class="text-decoration-none"><h1 class="text-center text-uppercase" style="color:#EEEEEE;" id="titulo">Videojuegos de Segunda Mano</h1></a>
        </header>
        <nav class="navbar navbar-light bg-gradient navbar-expand-lg" style="background-color: #8EC8DB;" id="navmenu">

        </nav>

        <section id="contenido">
            <h2>Listado de los articulos disponibles</h2>
            <table class="table table-dark table-striped table-bordered align-middle">
                <tr>
                    <th class="text-center">Imagen</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Categoria</th>
                    <th>Estado</th>
                    <th>Más detalles</th>
                </tr>
                <%
                    List<Articulos> articulos = (List<Articulos>) request.getAttribute("articulos");
                    for (Articulos art : articulos) {
                        out.println("<tr>");
                        out.println("<td class='text-center'><img width='100px' height='100px' src='../img_articulos/" + art.getId() + ".jpg' alt='No encontrado'></td>");
                        out.println("<td>" + art.getNombre() + "</td>");
                        out.println("<td>" + art.getPrecio() + "</td>");
                        out.println("<td>" + art.getCategoria() + "</td>");
                        out.println("<td>" + art.getEstado() + "</td>");
                        out.println("<td><a class='nav-link text-light' href='/ProyectoDAW/Articulos/detalles?id=" + art.getId() + "'>Detalles</a> </br> " + 
                                    "<a class='nav-link text-light' href='/ProyectoDAW/Articulos/addFavorito?id=" + art.getId() + "'>Añadir a favoritos</a></td>");
                        out.println("</tr>");
                    }
                %>
            </table>
        </section>
        <div class="footers align-items-end">
            <footer id="footer">Carlos Camacho banez&copy; 2022</footer>
        </div>
        <script src="/ProyectoDAW/codex_login.js"></script>
        <script src="/ProyectoDAW/funciones.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>

