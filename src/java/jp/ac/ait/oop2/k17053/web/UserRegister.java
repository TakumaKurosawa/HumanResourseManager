package jp.ac.ait.oop2.k17053.web;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import jp.ac.ait.oop2.k17053.web.database.Database;
import jp.ac.ait.oop2.k17053.web.database.User;
import jp.ac.ait.oop2.k17053.web.utility.Encrypt;

/**
 * User登録Servlet
 */
@WebServlet(name = "UserRegister", urlPatterns = {"/UserRegister"})
@MultipartConfig(
        fileSizeThreshold = 32768,
        maxFileSize = 5242880,
        maxRequestSize = 27262976
)
public class UserRegister extends HttpServlet {

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
            InputStream photo = null;
            Part filePart = request.getPart("form-photo");
            if (filePart != null) {
                photo = filePart.getInputStream();
            }
            String name = request.getParameter("form-name");
            String organization = request.getParameter("form-organization");
            String position = request.getParameter("form-position");
            String phone = request.getParameter("form-phone");
            String message = request.getParameter("form-message");
            String email = request.getParameter("form-email");
            String pass = request.getParameter("form-pwd");

            /* 空文字またはnullだった場合、
               正しいデータ登録が行えないため以下の処理を使いエラー表示させます。*/
            if (email == null || email.isEmpty()
                    || name == null || name.isEmpty()
                    || photo == null
                    || pass == null || pass.isEmpty()
                    || position == null || position.isEmpty()
                    || phone == null || phone.isEmpty()
                    || message == null || message.isEmpty()) {
                String error = URLEncoder.encode("未入力項目があります。", "UTF-8");
                response.sendRedirect(request.getContextPath() + "/create_user.jsp?error=" + error);
                return;
            }

            // パスワードをハッシュ化
            String encryptedPass = Encrypt.toHashValue(Encrypt.Algorithm.SHA256, pass);

            User user = Database.selectUserByEmail(email);
            if (user != null) {
                // すでに登録済みのデータ
                String info = URLEncoder.encode("そのメールアドレスは使用できません。", "UTF-8");
                response.sendRedirect(request.getContextPath() + "/create_user.jsp?info=" + info);
                return;
            }

            // このシステムに登録されているチーム名が見つからなかった時はエラーメッセージを返してリダイレクト
            int result = Database.selectOrganization(organization);
            if (result == 0) {
                String error = URLEncoder.encode("そのチームは現在登録されていません。あなたが新しくチームを登録しましょう！！", "UTF-8");
                response.sendRedirect(request.getContextPath() + "/create_user.jsp?error=" + error);
                return;
            }

            // 入力されたデータでUserインスタンスを作成
            user = new User(name, photo, position, phone, message, email, encryptedPass, result);

            // Userテーブルに登録
            if (!Database.insertUser(user)) {
                // 登録失敗時、"create_user.jsp"へ"error"パラメータにエラーメッセージを設定してリダイレクト
                String error = URLEncoder.encode("ユーザー登録処理中にエラーが発生しました。", "UTF-8");
                response.sendRedirect(request.getContextPath() + "/create_user.jsp?error=" + error);
                return;
            }

            // 登録成功後、サインイン画面に"info"パラメータへ登録完了のメッセージをパラメータに設定しリダイレクト
            String info = URLEncoder.encode("アカウントの新規登録が完了しました。", "UTF-8");
            response.sendRedirect(request.getContextPath() + "?info=" + info);

        } catch (Exception e) {
            // GlassFishServerのコンソールにエラーの詳細を出力しておく
            e.printStackTrace();

            // 処理中にエラーがあった場合"create_user.jsp"へ"error"パラメータにエラーメッセージを設定してリダイレクト
            String error = URLEncoder.encode("ユーザー登録処理中にエラーが発生しました。" + e.getLocalizedMessage(), "UTF-8");
            response.sendRedirect(request.getContextPath() + "/create_user.jsp?error=" + error);
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
