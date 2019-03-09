package jp.ac.ait.oop2.k17053.web;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jp.ac.ait.oop2.k17053.web.database.Database;
import jp.ac.ait.oop2.k17053.web.database.User;
import jp.ac.ait.oop2.k17053.web.utility.Encrypt;

/**
 * 認証Servlet(Signin)
 */
@WebServlet(name = "Auth", urlPatterns = {"/Auth"})
public class Auth extends HttpServlet {

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

        // 認証処理
        try {

            // リクエストからデータ取得
            String email = request.getParameter("form-email");
            String pass = request.getParameter("form-pwd");

            // パスワードをハッシュ化
            String encryptedPass = Encrypt.toHashValue(Encrypt.Algorithm.SHA256, pass);

            // Userデータをデータベースから取得する(emailをキーとする)
            User user = Database.selectUserByEmail(email);

            // userデータが取得できない、または登録されているパスワードがハッシュ化済みパスワードと異なる場合はサインイン失敗
            if (user == null || user.getEmail().equals(encryptedPass)) {
                String error = URLEncoder.encode("サインインに失敗しました。メールアドレスとパスワードを確認してください。", "UTF-8");
                response.sendRedirect(request.getContextPath() + "?error=" + error);
                // sendRedirectはresponseにリダイレクト情報を持たせるだけなのでreturnでメソッドを終了するのが必須
                return;
            }

            // サインイン成功時、セッションを新規作成、SetStatusへリダイレクト
            HttpSession session = request.getSession(true);
            session.setAttribute("SIGNIN_USER", user);
            response.sendRedirect("setstatus");

        } catch (Exception e) {
            // GlassFishServerのコンソールにエラーの詳細を出力しておく
            e.printStackTrace();
            // 処理中にエラーがあった場合トップページにエラーメッセージをパラメータに設定してリダイレクト
            String error = URLEncoder.encode("サインイン処理中にエラーが発生しました。" + e.getLocalizedMessage(), "UTF-8");
            response.sendRedirect(request.getContextPath() + "?error=" + error);
        }
    }

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
        //processRequest(request, response);
        // GETメソッドでは受け付けないので、リダイレクト
        response.sendRedirect(request.getContextPath());
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
    }

}
