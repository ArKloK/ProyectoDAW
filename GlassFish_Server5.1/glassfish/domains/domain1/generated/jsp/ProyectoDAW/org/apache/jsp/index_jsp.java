package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Entities.Articulos;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      response.setHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Igual que el index.html pero cargando todos los productos -->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>PracticaDAW</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"/ProyectoDAW/estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"/ProyectoDAW/estilos_login.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container-fluid\">\n");
      out.write("        <header class=\"d-flex justify-content-center\">\n");
      out.write("            <a href=\"index.html\" class=\"text-decoration-none\"><h1 class=\"text-center text-uppercase\" style=\"color:#EEEEEE;\" id=\"titulo\">Videojuegos de Segunda Mano</h1></a>\n");
      out.write("        </header>\n");
      out.write("        <nav class=\"navbar navbar-light bg-gradient navbar-expand-lg\" style=\"background-color: #8EC8DB;\" id=\"navmenu\">\n");
      out.write("\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <!--Modal Login-->\n");
      out.write("        <div class=\"modal fade\" id=\"ModalLogin\" tabindex=\"-1\" aria-labelledby=\"ModalFormLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog modal-dialog-centered\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <button type=\"button\" class=\"btn-close btn-close-white\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                        <div class=\"myform bg-dark\">\n");
      out.write("                            <h1 class=\"text-center\">Login</h1>\n");
      out.write("                            <form id=\"form_login\" onsubmit=\"return validar_form_login();\" method=\"post\" action=\"Usuarios/Login\" novalidate>\n");
      out.write("                                <div class=\"mb-3 mt-4 form-group\" id=\"DivCorreo_L\">\n");
      out.write("                                    <label for=\"InputEmail1_L\" class=\"form-label\">Correo Electronico</label>\n");
      out.write("                                    <input type=\"email\" class=\"form-control\" id=\"InputEmail1_L\" name=\"InputEmail1_L\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mb-3 form-group\" id=\"DivPassword_L\">\n");
      out.write("                                    <label for=\"InputPassword1_L\" class=\"form-label\">Contraseña</label>\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" id=\"InputPassword1_L\" name=\"InputPassword1_L\" required>\n");
      out.write("                                </div>\n");
      out.write("                                ");

                                    if (request.getAttribute("errorlogin")!=null) {
                                            out.println("<span>" + request.getAttribute("errorlogin").toString() + "</span>");
                                        }
                                
      out.write("\n");
      out.write("                                \n");
      out.write("                                <button type=\"submit\" class=\"btn btn-light mt-3\">INICIAR SESION</button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--Modal Registro-->\n");
      out.write("        <div class=\"modal fade\" id=\"ModalRegistro\" tabindex=\"-1\" aria-labelledby=\"ModalFormLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog modal-dialog-centered\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <button type=\"button\" class=\"btn-close btn-close-white\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                        <div class=\"myform bg-dark\">\n");
      out.write("                            <h1 class=\"text-center\">Registro</h1>\n");
      out.write("                            <form id=\"form_registro\" onsubmit=\"return validar_form_registro();\" action=\"Usuarios/Registro\" enctype=\"multipart/form-data\" method=\"post\" novalidate>\n");
      out.write("                                <div class=\"mb-3 mt-4 form-group\" id=\"DivCorreo\">\n");
      out.write("                                    <label for=\"InputEmail1_R\" class=\"form-label\">Correo Electronico</label>\n");
      out.write("                                    <input type=\"email\" class=\"form-control\" id=\"InputEmail1_R\" onchange=\"validarCorreoDB();\" name=\"InputEmail1_R\" aria-describedby=\"emailHelp\" required>\n");
      out.write("                                    <span id=\"correovalido\"></span>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mb-3 mt-4 form-group\" id=\"DivNombre\">\n");
      out.write("                                    <label for=\"InputNombre_R\" class=\"form-label\">Nombre</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"InputNombre_R\" name=\"InputNombre_R\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mb-3 form-group\" id=\"DivPassword\">\n");
      out.write("                                    <label for=\"InputPassword_R\" class=\"form-label\">Contraseña</label>\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" id=\"InputPassword_R\" name=\"InputPassword_R\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mb-3\" id=\"DivRPassword\">\n");
      out.write("                                    <label for=\"InputRPassword_R\" class=\"form-label\">Repetir Contraseña</label>\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" name=\"InputRPassword\" id=\"InputRPassword_R\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-light mt-3\">Registro</button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"footers align-items-end\">\n");
      out.write("            <footer id=\"footer\">Carlos Camacho banez&copy; 2022</footer>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"/ProyectoDAW/AJAXjs.js\"></script>\n");
      out.write("        <script src=\"/ProyectoDAW/codex.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
