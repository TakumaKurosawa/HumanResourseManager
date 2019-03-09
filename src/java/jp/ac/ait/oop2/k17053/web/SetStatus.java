package jp.ac.ait.oop2.k17053.web;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jp.ac.ait.oop2.k17053.web.database.User;

/**
 * ダッシュボードServlet
 */
@WebServlet(name = "SetStatus", urlPatterns = {"/setstatus"})
public class SetStatus extends HttpServlet {

    // サインイン済みユーザー取得用のキー
    private static final String SIGNIN_USER_KEY = "SIGNIN_USER";

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

        HttpSession session = request.getSession(false);  // セッション取得(新規作成はしない)
        if (session == null) {
            // セッションが存在しないのでサインインページへリダイレクト
            response.sendRedirect(request.getContextPath());
            return;
        } else if (session.getAttribute(SIGNIN_USER_KEY) == null
                || !(session.getAttribute(SIGNIN_USER_KEY) instanceof User)) {
            // セッションは存在するが、データの形式が不正なのでサインインページへリダイレクト
            response.sendRedirect(request.getContextPath());
            return;
        }

        // Userデータをセッションから取得してリクエストスコープに変換
        User u = (User) session.getAttribute(SIGNIN_USER_KEY);
        request.setAttribute(SIGNIN_USER_KEY, u);

        try {

            if (u.getStatus_id() != 0) {
                request.setAttribute("SIGNIN_USER", u);
                getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
            }

            // WEB-INF/dashbord.jspへフォワード
            getServletContext().getRequestDispatcher("/WEB-INF/setstatus.jsp").forward(request, response);

        } catch (Exception e) {
            // GlassFishServerのコンソールにエラーの詳細を出力しておく
            e.printStackTrace();
            // 処理中にエラーがあった場合サインイン画面へリダイレクト
            String error = URLEncoder.encode("ダッシュボード表示処理にエラーが発生しました。" + e.getLocalizedMessage(), "UTF-8");
            response.sendRedirect(request.getContextPath() + "?error=" + error);
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
