/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.ait.oop2.k17053.web;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.ac.ait.oop2.k17053.web.database.Database;
import jp.ac.ait.oop2.k17053.web.database.User;

/**
 *
 * @author k17053kk
 */
@WebServlet(name = "GoMain", urlPatterns = {"/go"})
public class GoMain extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            // リクエストからデータ取得
            int skill1 = Integer.parseInt(request.getParameter("skill1"));
            int skill2 = Integer.parseInt(request.getParameter("skill2"));
            int skill3 = Integer.parseInt(request.getParameter("skill3"));
            int skill4 = Integer.parseInt(request.getParameter("skill4"));
            int skill5 = Integer.parseInt(request.getParameter("skill5"));
            int user_id = Integer.parseInt(request.getParameter("user"));

            int status_id = Database.InsertStatusId(skill1, skill2, skill3, skill4, skill5);

            User u = Database.selectUserById(user_id);

            Database.updateStatusId(u, status_id);

            request.setAttribute("SIGNIN_USER", u);
            getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);

        } catch (Exception e) {
            // GlassFishServerのコンソールにエラーの詳細を出力しておく
            e.printStackTrace();

            // 処理中にエラーがあった場合"create_user.jsp"へ"error"パラメータにエラーメッセージを設定してリダイレクト
            String error = URLEncoder.encode("ステータス更新処理中にエラーが発生しました。" + e.getLocalizedMessage(), "UTF-8");
            response.sendRedirect(request.getContextPath() + "/dashboard.jsp?error=" + error);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
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
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
