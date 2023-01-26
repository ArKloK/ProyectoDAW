/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlers;

import Entities.Articulos;
import Entities.Usuarios;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ArticulosController", urlPatterns = {"/Articulos/*"})
@MultipartConfig
public class ArticulosController extends HttpServlet {

    UsuariosController users = new UsuariosController();
    @PersistenceContext(unitName = "ProyectoDAWPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if art servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion, vista = "";
        accion = request.getPathInfo();

        switch (accion) {

            case "/show": {
                TypedQuery<Articulos> query;
                List<Articulos> lista_articulos;

                query = em.createNamedQuery("Articulos.findAll", Articulos.class);
                lista_articulos = query.getResultList();

                request.setAttribute("articulos", lista_articulos);
                vista = "/articulos.jsp";
            }
            break;

            case "/showPC": {
                TypedQuery<Articulos> query;
                List<Articulos> lista_articulos;

                query = em.createNamedQuery("Articulos.findByCategoria", Articulos.class);
                query.setParameter("cat", "PC");
                lista_articulos = query.getResultList();

                request.setAttribute("articulos", lista_articulos);
                vista = "/articulos.jsp";
            }
            break;

            case "/showPS4": {
                TypedQuery<Articulos> query;
                List<Articulos> lista_articulos;

                query = em.createNamedQuery("Articulos.findByCategoria", Articulos.class);
                query.setParameter("cat", "PS4");
                lista_articulos = query.getResultList();

                request.setAttribute("articulos", lista_articulos);
                vista = "/articulos.jsp";
            }
            break;

            case "/showXbox": {
                TypedQuery<Articulos> query;
                List<Articulos> lista_articulos;

                query = em.createNamedQuery("Articulos.findByCategoria", Articulos.class);
                query.setParameter("cat", "Xbox One");
                lista_articulos = query.getResultList();

                request.setAttribute("articulos", lista_articulos);
                vista = "/articulos.jsp";
            }
            break;

            case "/showOtros": {
                TypedQuery<Articulos> query;
                List<Articulos> lista_articulos;

                query = em.createNamedQuery("Articulos.findByCategoria", Articulos.class);
                query.setParameter("cat", "Otros");
                lista_articulos = query.getResultList();

                request.setAttribute("articulos", lista_articulos);
                vista = "/articulos.jsp";
            }
            break;

            case "/show_login": {
                TypedQuery<Articulos> query;
                List<Articulos> lista_articulos;

                query = em.createNamedQuery("Articulos.findAll", Articulos.class);
                lista_articulos = query.getResultList();

                request.setAttribute("articulos", lista_articulos);
                vista = "/articulos_login.jsp";
            }
            break;

            case "/showPC_login": {
                TypedQuery<Articulos> query;
                List<Articulos> lista_articulos;

                query = em.createNamedQuery("Articulos.findByCategoria", Articulos.class);
                query.setParameter("cat", "PC");
                lista_articulos = query.getResultList();

                request.setAttribute("articulos", lista_articulos);
                vista = "/articulos_login.jsp";
            }
            break;

            case "/showPS4_login": {
                TypedQuery<Articulos> query;
                List<Articulos> lista_articulos;

                query = em.createNamedQuery("Articulos.findByCategoria", Articulos.class);
                query.setParameter("cat", "PS4");
                lista_articulos = query.getResultList();

                request.setAttribute("articulos", lista_articulos);
                vista = "/articulos_login.jsp";
            }
            break;

            case "/showXbox_login": {
                TypedQuery<Articulos> query;
                List<Articulos> lista_articulos;

                query = em.createNamedQuery("Articulos.findByCategoria", Articulos.class);
                query.setParameter("cat", "Xbox One");
                lista_articulos = query.getResultList();

                request.setAttribute("articulos", lista_articulos);
                vista = "/articulos_login.jsp";
            }
            break;

            case "/showOtros_login": {
                TypedQuery<Articulos> query;
                List<Articulos> lista_articulos;

                query = em.createNamedQuery("Articulos.findByCategoria", Articulos.class);
                query.setParameter("cat", "Otros");
                lista_articulos = query.getResultList();

                request.setAttribute("articulos", lista_articulos);
                vista = "/articulos_login.jsp";
            }
            break;

            case "/InsertarArticulo": {
                Articulos art = new Articulos();
                try {

                    art.setNombre(request.getParameter("nombrearticulo"));
                    art.setPrecio(Integer.parseInt(request.getParameter("precioarticulo")));
                    art.setCategoria(request.getParameter("categoriaarticulo"));
                    art.setEstado(request.getParameter("estadoarticulo"));
                    art.setAntiguedad(request.getParameter("antiguedadarticulo"));
                    art.setDescripcion(request.getParameter("descripcionarticulo"));
                    //art.setUser((Usuarios)users.getSession().getAttribute("usuario"));
                    persist(art);

                    Part filePart = request.getPart("formFile");
                    if (filePart != null) {
                        String nombre = filePart.getName();
                        Long tamaño = filePart.getSize();
                        String file = filePart.getSubmittedFileName();

                        String relativePathFolder = "img_articulos";
                        String absolutePathFolder = "D:/Documentos/UHU/DAW/ProyectoDAW/web/" + relativePathFolder;

                        File folder = new File(absolutePathFolder);
                        if (!folder.exists()) {
                            folder.mkdir();
                        }
                        System.out.println(absolutePathFolder + File.separator + art.getId() + ".jpg");
                        File f = new File(absolutePathFolder + File.separator + art.getId() + ".jpg");

                        OutputStream p = new FileOutputStream(f);
                        InputStream filecontent;
                        filecontent = filePart.getInputStream();
                        System.out.println("Tamaño: " + filePart.getSize());

                        int read = 0;
                        final byte[] bytes = new byte[1024];
                        while ((read = filecontent.read(bytes)) != -1) {
                            p.write(bytes, 0, read);
                        }

                        p.close();
                        filecontent.close();
                        vista = "/publicar_articulos.html";
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                    System.out.println("Error: Imposible persistir  articulo: " + art.getNombre());
                }
            }
            break;

            case "/detalles": {
                String idf = request.getParameter("id");
                TypedQuery<Articulos> query = em.createNamedQuery("Articulos.findById", Articulos.class);
                query.setParameter("id", Integer.parseInt(idf));
                List<Articulos> lr = query.getResultList();
                Articulos art = lr.get(0);
                request.setAttribute("articulo_detalles", art);
                vista = "/detalles.jsp";
            }
            break;

            case "/addFavorito": {
                String idf;
                TypedQuery<Articulos> query;
                List<Articulos> lr;
                List<Articulos> lid = null;
                Articulos art;

                idf = request.getParameter("id");
                if (idf != null) {
                    query = em.createNamedQuery("Articulos.findById", Articulos.class);
                    query.setParameter("id", Long.parseLong(idf));
                    lr = query.getResultList();
                    if (lr != null) { // Esta el artículo
                        try {
                            lid = (List<Articulos>) users.getSession().getAttribute("lart");
                        } catch (Exception e) {
                            e.getMessage();
                        }

                        if (lid == null) {
                            lid = new ArrayList<>();
                        }
                        art = lr.get(0);
                        lid.add(art);
                        try {
                            users.getSession().setAttribute("lart", lid);
                        } catch (Exception e) {
                            e.getMessage();
                        }

                    } else { //No está el art
                        System.out.println("El articulo no se encontraba en la lista. Se puede añadir");
                    }
                } else { //Id no enviado
                    System.out.println("Artículo No registrado en favoritos. Falta Id.");
                }

                query = em.createNamedQuery("Articulos.findAll", Articulos.class);
                lr = query.getResultList();
                request.setAttribute("articulosfavoritos", lr);

                vista = "/articulos_login.jsp";
            }
            break;

            case "/Favoritos": {
                vista = "/favoritos.jsp";
            }
            break;

            case "/delFavorito": {
                String idf;
                List<Articulos> lid;
                idf = request.getParameter("id");
                int i = Integer.parseInt(idf);
                lid = (List<Articulos>) users.getSession().getAttribute("lart");
                lid.remove(i);
                users.getSession().setAttribute("lart", lid);
                vista = "/favoritos.jsp";
            }
            break;
        }
        try {
            if (!"".equals(vista)) {
                RequestDispatcher rd = request.getRequestDispatcher(vista);
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if art servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if art servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns art short description of the servlet.
     *
     * @return art String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

}
