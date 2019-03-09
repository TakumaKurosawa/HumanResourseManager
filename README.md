# H.R.M(Human Resource Manager)仕様書<br><small>2019.1.24</small>

## はじめに
### 導入
前期から通して計30回の講義を通してオブジェクト指向を取り入れたプログラミング言語であるJavaを用いながらプログラミングをする上で非常に重要な考え方やコードの書き方を学んできた．これまでの集大成として，Javaを用いたアプリケーション開発が最終課題として課せられた．本レポートでは最終課題として取り組んだ「H.R.M(Human Resource Manager)」製作について記す．

#### ターゲット
- [x] 会社やチームなどの組織
- [x] 個人の能力等を管理して人材リソースをフル活用したい人
- [x] リモート開発や共同開発をするために集まったメンバーの能力を調べたい人
- [x] 仕事を依頼する際に誰に任せれば良いか迷ったことがある人
#### H.R.Mを作成した経緯
<div style="text-align: center;"><span style="color: red; font-weight: bold;">フリーランス</span>が集まる会社でインターンを経験
<div style="margin: 20px auto;">
<img  src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAK/SURBVHhe7Zpfa9NQGMb7JfTbKXijg6Q4/HMxFLzQ4kZbZBdjV03K1IKCeqOCOlBWBbdWL7b1TtBvcnaeLE/NYtKenCQ1OTkPPLRNznn7Pr82L7SkZWW1WvUd/1vf9UWSe473NVxmrpKCRx0uM1cM+mj2TtyevBG3js4dBxD9phj1zWCo3T+fxMPTt+kAXH/MY3geHq6/GAoAtn99SAVgrKIAdn5/tAAsgBQAjRiCCwE0YQjaS8ACsABSAdghaIegobIALAA1AHYI2iFoqCwAC0ANgB2CdggaKgvAAlADUIkhuN0eXOq5/qTreD+7a3uXw8O5xFBlDsHzvodT2fsP7b5RRH4KJ/MmHH9WBATWK+sSCPp2hzPW0+o7Gn7r/l5g7WIxsbEyAETDa/cdD3/34HXgoiAENaSLBhAPr9133/Gm0SJsMFpMDiVtCEEz0kUOwaTwqLl++Eqsf3kpNucQvGm4JV29tj+JF6LxmsV0IQSNSBc1BKPh0Rt7XhuPxNV9T1x7PxCdjbCOCgAUlNPzwiXAJuG8EIJGpIu4BNLCXz94Lq7sDy6El5lOsT7culhlQsAeOC+A0sJTZUHAejgPgNLDU1khqLwR1sK6Q3Bl4amiIWAdrDMEVx6eKhIC1sBZL4H/Fp5aBuGOIgSch7MAiIfHe2HPysJTRUDAOVgVQGXCU3kh4DisAqBy4ak8EHAMXgagsuGpjBDmDeI1vAhA5cNTOhDwHE4DUJvwlAqErXt/IeARTgPA8NhT+fBUFgg0ACTdKgvXKjyVFQIAJN0sXcvwlAqEzQdPxZPu6J/b5TudZ+KxPFfb8NQyCCqubXgqD4Tah6d0IBgTnsoCwbjwlAoEY8NTiyDcGI/MDk8lQcD/9o0IT8Uh3Pz8ojnhqQBCe3iMwPix06jwVBRC48JTAQTX/y5/IR42Lnx11GqdAdskd3mvLtVdAAAAAElFTkSuQmCC">
</div>
個人個人のできることや<span style="color: red; font-weight: bold;">能力値が把握できず</span>適切な人材に仕事が回らないという現状を体験
<div style="margin: 20px auto;">
<img  src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAK/SURBVHhe7Zpfa9NQGMb7JfTbKXijg6Q4/HMxFLzQ4kZbZBdjV03K1IKCeqOCOlBWBbdWL7b1TtBvcnaeLE/NYtKenCQ1OTkPPLRNznn7Pr82L7SkZWW1WvUd/1vf9UWSe473NVxmrpKCRx0uM1cM+mj2TtyevBG3js4dBxD9phj1zWCo3T+fxMPTt+kAXH/MY3geHq6/GAoAtn99SAVgrKIAdn5/tAAsgBQAjRiCCwE0YQjaS8ACsABSAdghaIegobIALAA1AHYI2iFoqCwAC0ANgB2CdggaKgvAAlADUIkhuN0eXOq5/qTreD+7a3uXw8O5xFBlDsHzvodT2fsP7b5RRH4KJ/MmHH9WBATWK+sSCPp2hzPW0+o7Gn7r/l5g7WIxsbEyAETDa/cdD3/34HXgoiAENaSLBhAPr9133/Gm0SJsMFpMDiVtCEEz0kUOwaTwqLl++Eqsf3kpNucQvGm4JV29tj+JF6LxmsV0IQSNSBc1BKPh0Rt7XhuPxNV9T1x7PxCdjbCOCgAUlNPzwiXAJuG8EIJGpIu4BNLCXz94Lq7sDy6El5lOsT7culhlQsAeOC+A0sJTZUHAejgPgNLDU1khqLwR1sK6Q3Bl4amiIWAdrDMEVx6eKhIC1sBZL4H/Fp5aBuGOIgSch7MAiIfHe2HPysJTRUDAOVgVQGXCU3kh4DisAqBy4ak8EHAMXgagsuGpjBDmDeI1vAhA5cNTOhDwHE4DUJvwlAqErXt/IeARTgPA8NhT+fBUFgg0ACTdKgvXKjyVFQIAJN0sXcvwlAqEzQdPxZPu6J/b5TudZ+KxPFfb8NQyCCqubXgqD4Tah6d0IBgTnsoCwbjwlAoEY8NTiyDcGI/MDk8lQcD/9o0IT8Uh3Pz8ojnhqQBCe3iMwPix06jwVBRC48JTAQTX/y5/IR42Lnx11GqdAdskd3mvLtVdAAAAAElFTkSuQmCC">
</div>
個人の能力を<span style="color: red; font-weight: bold;">チーム内で共有</span>できていればより良いチーム体制になったのでは・・・
<div style="margin: 20px auto;">
<img  src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAK/SURBVHhe7Zpfa9NQGMb7JfTbKXijg6Q4/HMxFLzQ4kZbZBdjV03K1IKCeqOCOlBWBbdWL7b1TtBvcnaeLE/NYtKenCQ1OTkPPLRNznn7Pr82L7SkZWW1WvUd/1vf9UWSe473NVxmrpKCRx0uM1cM+mj2TtyevBG3js4dBxD9phj1zWCo3T+fxMPTt+kAXH/MY3geHq6/GAoAtn99SAVgrKIAdn5/tAAsgBQAjRiCCwE0YQjaS8ACsABSAdghaIegobIALAA1AHYI2iFoqCwAC0ANgB2CdggaKgvAAlADUIkhuN0eXOq5/qTreD+7a3uXw8O5xFBlDsHzvodT2fsP7b5RRH4KJ/MmHH9WBATWK+sSCPp2hzPW0+o7Gn7r/l5g7WIxsbEyAETDa/cdD3/34HXgoiAENaSLBhAPr9133/Gm0SJsMFpMDiVtCEEz0kUOwaTwqLl++Eqsf3kpNucQvGm4JV29tj+JF6LxmsV0IQSNSBc1BKPh0Rt7XhuPxNV9T1x7PxCdjbCOCgAUlNPzwiXAJuG8EIJGpIu4BNLCXz94Lq7sDy6El5lOsT7culhlQsAeOC+A0sJTZUHAejgPgNLDU1khqLwR1sK6Q3Bl4amiIWAdrDMEVx6eKhIC1sBZL4H/Fp5aBuGOIgSch7MAiIfHe2HPysJTRUDAOVgVQGXCU3kh4DisAqBy4ak8EHAMXgagsuGpjBDmDeI1vAhA5cNTOhDwHE4DUJvwlAqErXt/IeARTgPA8NhT+fBUFgg0ACTdKgvXKjyVFQIAJN0sXcvwlAqEzQdPxZPu6J/b5TudZ+KxPFfb8NQyCCqubXgqD4Tah6d0IBgTnsoCwbjwlAoEY8NTiyDcGI/MDk8lQcD/9o0IT8Uh3Pz8ojnhqQBCe3iMwPix06jwVBRC48JTAQTX/y5/IR42Lnx11GqdAdskd3mvLtVdAAAAAElFTkSuQmCC">
</div>
<span style="color: blue; font-weight: bold; background: linear-gradient(transparent 50%, yellow 50%);">H.R.Mを考案</span>
</div>

#### 目的（H.R.Mで達成したいこと）
<span style="font-size: 30px; font-family: serif; font-weight: bold;">"個人の<span style="color: blue; background: linear-gradient(transparent 50%, yellow 50%)">能力(ability)</span>がより価値のある創造を生み出す世界の実現"<br></span>

## H.R.Mの仕様について
### 製品名・種別
H.R.M(Human Resource Manager)
※以下，H.R.Mと呼称
-Webアプリケーション
### 開発環境


| IDE | 言語やフレームワーク等 | バージョン管理 |
| -------- | -------- | -------- |
| NetBeans<br>WebStorm<br>SequelPro     | Java<br>HTML/CSS<br>Javascript<br>BootStrap<br>SemanticUI<br>Vue.js<br>Chart.js<br>jQuery<br>MySQL     | GitHub     |


### 使い方
※添付資料[1]:H.R.Mの使い方.gifを参照
#### 1. 事前に上司やチームリーダーにH.R.Mに登録した組織名（チーム名）を確認しておく
![](https://i.imgur.com/0UbxLAY.png)
#### 2. H.R.Mにアクセス！
![](https://i.imgur.com/X1A4IGu.png)
#### 3. ユーザ登録をする
![](https://i.imgur.com/Tg13OX8.png)

#### 4. ログインする(email, passwordの入力)
![](https://i.imgur.com/o4cSzop.png)

#### 5. 自分のスキルレベルを入力する
![](https://i.imgur.com/n79jPC8.png)

#### 6. 自分のチームメンバーの情報から仕事を受注したい人を絞る
![](https://i.imgur.com/tZQOjJj.jpg)


#### 7. 受注したい人が決まったら，その人のカードの右上にあるボタンをクリック
![](https://i.imgur.com/I6fJORZ.jpg)

#### 8. 好きな連絡手段を選択
![](https://i.imgur.com/I77Ll7T.jpg)

#### 9. オファーを送る👍
![](https://i.imgur.com/brS0MAz.png)

<hr>

### データベース（ER図）
#### テーブル名：ManageTM
![](https://i.imgur.com/1aPeR4L.png)
<br>

<hr>

### データフロー
![](https://i.imgur.com/rCiMbP9.png)
<br>

## バックエンドの主要技術
### ユーザ登録

<i style="background-color: #A8FFF6; display: block;">
まず，ユーザが登録フォームを送信すると，その情報をもとに登録されているデータの中に重複がないかという判定やパスワードの暗号化などがされる．次に，全てのデータを整える処理が終わったUserデータを元にUserクラスのインスタンスが作成される．作られたUserクラスのインスタンスがinsertUserメソッドに渡されるとinsert用のSQL文が発行される．実際にUserテーブルに新規ユーザが登録される
</i>
<br>

Database.java
``` Database.java
/**
     * Userテーブルに新規ユーザー登録
     *
     * @param user Userデータ(idは登録時無視されます)
     * @return 登録成功でtrue
     * @throws SQLException
     */
    public static boolean insertUser(User user) throws SQLException, IOException {

        // 引数のuserから、email, name, passwordをUserテーブルにINSERTします
        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO").append(System.lineSeparator());
            sql.append("  User (").append(System.lineSeparator());
            sql.append("  `name`").append(System.lineSeparator());
            sql.append(", `position`").append(System.lineSeparator());
            sql.append(", `phone`").append(System.lineSeparator());
            sql.append(", `photo`").append(System.lineSeparator());
            sql.append(", `message`").append(System.lineSeparator());
            sql.append(", `email`").append(System.lineSeparator());
            sql.append(", `password`").append(System.lineSeparator());
            sql.append(", `organization_id`").append(System.lineSeparator());
            sql.append(") VALUES (").append(System.lineSeparator());
            sql.append("  ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(");").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(
                    sql.toString(),
                    Statement.RETURN_GENERATED_KEYS // 生成されたIDの値を取得する場合には、フラグを設定する
            );
            // 追加するデータの設定
            stm.setString(1, user.getName()); // name
            stm.setString(2, user.getPosition()); // position
            stm.setString(3, user.getPhone()); // phone
            stm.setBlob(4, user.getPhoto()); // photo
            stm.setString(5, user.getMessage()); // message
            stm.setString(6, user.getEmail()); // email
            stm.setString(7, user.getPassword()); // password
            stm.setString(8, String.valueOf(user.getOrganization_id())); // organization_id:ユーザが入力したチーム名を元にorganization_idを取得

            // パラメータがセットされたSQLを発行
            int result_count = stm.executeUpdate();
            // 登録失敗(更新件数が0件)時、falseを返す
            if (result_count == 0) {
                return false;
            }
            // idの値は、新規登録されたid列の番号を取得して、引数のuserのidに設定する
            // 自動採番されたIDの値を取得する
            int id = 0;
            ResultSet ids = stm.getGeneratedKeys();
            if (ids != null && ids.next()) {
                id = ids.getInt(1);
            }
            user.setId(id);
        }
        return true;
    }
```
UserRegister.java
``` UserRegister.java
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
```

### ユーザステータスのアップデートとメインページへの遷移

<i style="background-color: #A8FFF6; display: block;">
ログイン画面からユーザがログインすると，初回ログイン時（ステータスセットがされていない）には直接ステータス設定画面に遷移するようになっている．ログイン画面から受け取ったサインイン済みユーザ情報から<span style="text-decoration: underline;">organization_id</span>を導き，どの会社のスキルセットを利用するのか取得する．フォームのラベルには各スキルの名前が当てられているため，ユーザはそれぞれのスキルに対する自己評価値を入力し，「スキルセット完了」ボタンを押す．入力されたスキルレベルのデータがDatabase.javaを介してMySQLに保存されるのだが動作としてはまず，入力されたデータをInsertStatus()メソッドで1件追加．次に，SelectLastIdFromStatus()メソッドで追加されたステータスデータのIdを取得（最新のものを取り出すというメソッド）し，updateStatusId(User user, int status_id)メソッドで追加したステータスのID情報をUPDATEして登録する．あとはメインページにUserインスタンスを渡すのみである．
</i>
<br>

setstatus.jsp
``` setstatus.jsp
<%@page import="jp.ac.ait.oop2.k17053.web.database.Status"%>
<%@page import="jp.ac.ait.oop2.k17053.web.database.Skills"%>
<%@page import="jp.ac.ait.oop2.k17053.web.database.Organization"%>
<%@page import="jp.ac.ait.oop2.k17053.web.database.Database"%>
<%@page import="java.util.List" %>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jp.ac.ait.oop2.k17053.web.database.User" %>
<%
    User u = (User) request.getAttribute("SIGNIN_USER");
    Organization team = Database.selectOrganizationById(u.getOrganization_id());
    Skills skills = Database.selectSkillsById(team.getSkills_id());
    Status status = Database.selectStatusById(u.getStatus_id());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css">
        <link rel="stylesheet" href="assets/css/signin.css">
        <title>HRM - SetYourSkillsLevel</title>
    </head>
    <body class="">
        <form class="form-signin" action="go" method="POST" style="display: block;">
            <h2 style="background: linear-gradient(transparent 70%, yellow 70%);">スキルをセットしてユーザ登録を完了しましょう</h2>
            <h3>1. <%= skills.getSkill1()%></h3>
            <div class="ui form w-50">
                <div class="field">
                    <select name="skill1">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
            </div>
            <h3>2. <%= skills.getSkill2()%></h3>
            <div class="ui form w-50">
                <div class="field">
                    <select name="skill2">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
            </div>
            <h3>3. <%= skills.getSkill3()%></h3>
            <div class="ui form w-50">
                <div class="field">
                    <select name="skill3">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
            </div>
            <h3>4. <%= skills.getSkill4()%></h3>
            <div class="ui form w-50">
                <div class="field">
                    <select name="skill4">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
            </div>
            <h3>5. <%= skills.getSkill5()%></h3>
            <div class="ui form w-50">
                <div class="field">
                    <select name="skill5">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
            </div>
            <input type="hidden" name="user" value="<%= u.getId()%>">
            <button class="btn btn-lg btn-primary btn-block" type="submit">スキルセット完了</button>
            <p class="mt-5 mb-3 text-muted text-center">&copy; k17053 2018</p>
        </form>
        <style>
            html,
            body {
                height: 100%;
            }

            body {
                display: -ms-flexbox;
                display: flex;
                -ms-flex-align: center;
                align-items: center;
                background-color: #f5f5f5;
            }
        </style>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/1.11.8/semantic.min.js"></script>   
    </body>
</html>

```
GoMain.java
``` GoMain.java
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

```
Database.java
``` Database.java
/**
     * Userテーブルのstatus_id新しいものに更新
     *
     * @param user
     * @throws SQLException
     */
    public static void updateStatusId(User user, int status_id) throws SQLException {

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE").append(System.lineSeparator());
            sql.append("  User").append(System.lineSeparator());
            sql.append("SET ").append(System.lineSeparator());
            sql.append("  status_id = ? ").append(System.lineSeparator());
            sql.append("WHERE ").append(System.lineSeparator());
            sql.append("  id = ? ").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(sql.toString());

            // パラメータセット
            stm.setString(1, String.valueOf(status_id));
            stm.setString(2, String.valueOf(user.getId()));
            stm.executeUpdate();

        }

    }

    /**
     * Statusテーブルに1件追加
     *
     * @return status_id (ユーザテーブルのstatus_id用)
     * @throws SQLException
     */
    public static int InsertStatusId(int skill1, int skill2, int skill3, int skill4, int skill5) throws SQLException {

        int status_id = 0;

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO").append(System.lineSeparator());
            sql.append("  Status (").append(System.lineSeparator());
            sql.append("  `skill1s`").append(System.lineSeparator());
            sql.append(", `skill2s`").append(System.lineSeparator());
            sql.append(", `skill3s`").append(System.lineSeparator());
            sql.append(", `skill4s`").append(System.lineSeparator());
            sql.append(", `skill5s`").append(System.lineSeparator());
            sql.append(") VALUES (").append(System.lineSeparator());
            sql.append("  ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(");").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(sql.toString());

            // パラメータセット
            stm.setString(1, String.valueOf(skill1));
            stm.setString(2, String.valueOf(skill2));
            stm.setString(3, String.valueOf(skill3));
            stm.setString(4, String.valueOf(skill4));
            stm.setString(5, String.valueOf(skill5));
            stm.executeUpdate();

            status_id = SelectLastIdFromStatus();

        }
        return status_id;
    }
    
    /***
     * 最新のステータスIdを取得する
     * @return last(ステータスIdの最新値）
     * @throws SQLException 
     */

    public static int SelectLastIdFromStatus() throws SQLException {
        int last = 0;

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT").append(System.lineSeparator());
            sql.append("  MAX(id) AS 'id' ").append(System.lineSeparator());
            sql.append("FROM").append(System.lineSeparator());
            sql.append("  Status").append(System.lineSeparator());
            PreparedStatement stm2 = connection.prepareStatement(sql.toString());

            ResultSet rs = stm2.executeQuery();
            if (rs.next()) {
                last = rs.getInt("id");
            }
        }
        return last;
    }
}


```

## フロントエンドの主要技術
### メインページ

<i style="background-color: #A8FFF6; display: block;">
データの表示にはVue.jsをベースに組み立てている．jspで受け取ったUserのリスト型を連想配列に落とし込み，その連想配列をVue.jsのdataコンポーネントで保持した．他にも画面が表示されるまでの間ローディング画面を出すための変数loadinと，ユーザカードの全情報が載っている画面を出力するためのスタイルバインディング変数も用意した．見た目のデザイン面はBootstrapとSemanticUIを使用した．
</i>
<br>

main.jsp
``` main.jsp
<%@page import="java.nio.charset.Charset"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jp.ac.ait.oop2.k17053.web.database.Organization"%>
<%@page import="jp.ac.ait.oop2.k17053.web.database.Status"%>
<%@page import="jp.ac.ait.oop2.k17053.web.database.Skills"%>
<%@page import="jp.ac.ait.oop2.k17053.web.database.Database"%>
<%@page import="jp.ac.ait.oop2.k17053.web.database.User"%>
<%
    User u = (User) request.getAttribute("SIGNIN_USER");
    Organization team = Database.selectOrganizationById(u.getOrganization_id());
    Skills skills = Database.selectSkillsById(team.getSkills_id());
    Status status = Database.selectStatusById(u.getStatus_id());
    ArrayList<User> users = Database.selectUserByOrganizationId(team.getId());
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Human Resourse Manager</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css">
        <link rel="stylesheet/less" type="text/css" href="assets/css/style.less">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-light" style="background-color: #03A9F4;">
                <b class="navbar-brand" style="font-size: 2.5rem; background-color: #faff8b; background-image: linear-gradient(45deg, #faff8b 0%, #2BFF88 49%, #2BD2FF 99%);">
                    <%= team.getTeam_name()%>
                </b>
                <a class="nav-link" href="setstatus" style="color: #ffffff; font-size: 1.5rem; font-weight: bold;">スキル値変更</a>
                <a class="nav-link" href="signout" style="color: #ffffff; font-size: 1.5rem; font-weight: bold;">ログアウト</a>
            </nav>
        </header>
        <main id="app">
            <div class="ui active dimmer loading" v-if="loading">
                <div class="ui massive text loader">Loading</div>
            </div>
            <div class="container-fluid" v-cloak>
                <div class="row">
                    <div class="col">
                        <div class="invisible" :style="{visibility: visible}">
                             <section class="container-fluid">
                                <div class="row active-with-click">
                                    <div class="col-md-4 col-sm-6 col-xs-12 my-5" v-for="(user, index) in users">
                                        <div class="d-block">
                                            <article class="material-card Light-Blue">
                                                <h2>
                                                    <span class="name">{{ user.name }}</span>
                                                    <strong>
                                                        <i class="fa fa-fw fa-star" style="color: #FBFF23;"></i>
                                                        <b style="color: #FBFF23;">{{ user.position }}</b>
                                                    </strong>
                                                    <span style="font-size: 2rem; font-family: serif;" v-if="user.clicked">{{ user.message }}</span>
                                                    <div class="ui divider"></div>
                                                    <div class="ui raised segment  back-chart">
                                                        <span class="ui red ribbon label w-50 font-20">ステータス</span>
                                                        <canvas class="my-3" :id="'myChart' + index" class="chart"></canvas> 
                                                    </div>
                                                    <div v-if="user.clicked">
                                                        <h4>
                                                            Social
                                                        </h4>
                                                        <a href="http://localhost:8080/returnjson/Dashboard" class="fa fa-fw fa-facebook" style="font-size: 4rem;"></a>
                                                        <a href="http://localhost:8080/returnjson/Dashboard" class="fa fa-fw fa-twitter" style="font-size: 4rem;"></a>
                                                        <a href="http://localhost:8080/returnjson/Dashboard" class="fa fa-fw fa-linkedin" style="font-size: 4rem;"></a>
                                                        <a :href="'mailto:' + user.mail" class="fa fas fa-envelope" style="font-size: 4rem;"></a>
                                                        <a :href="'tel:' + user.phone" class="fa fa-fw" style="font-size: 4rem;"><i class="fas fa-phone"></i></a>
                                                    </div>
                                                </h2>
                                                <div class="mc-content">
                                                    <div class="img-container">
                                                        <img class="img-responsive w-100" :src = "'data:image\jpeg' + ';base64,' + user.photo">
                                                    </div>
                                                </div>
                                                <a class="mc-btn-action detail-torigger" v-on:click="onclick(index)">
                                                    <i class="fa fa-bars"></i>
                                                </a>
                                            </article>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/vue@2.5.17/dist/vue.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.min.js" integrity="sha256-MZo5XY1Ah7Z2Aui4/alkfeiq3CopMdV/bbkc/Sh41+s=" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/less.js/2.5.1/less.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

        <script>




var users = [
            <% for (int i = 0; i < users.size(); i++) {%>

{

name: "<%= users.get(i).getName()%>",
        position: "<%= users.get(i).getPosition()%>",
            <% byte[] img = null;%>
            <% BufferedImage photo = ImageIO.read(users.get(i).getPhoto());%>
            <% ByteArrayOutputStream bos = new ByteArrayOutputStream();%>
            <% BufferedOutputStream os = new BufferedOutputStream(bos);%>
            <% photo.flush();%>
            <% ImageIO.write(photo, "png", os);%>
            <% img = bos.toByteArray();%>
photo: "<%= Base64.getEncoder().encodeToString(img)%>",
        status: [
                "<%= Database.selectStatusById(users.get(i).getStatus_id()).getSkill1s()%>",
                "<%= Database.selectStatusById(users.get(i).getStatus_id()).getSkill2s()%>",
                "<%= Database.selectStatusById(users.get(i).getStatus_id()).getSkill3s()%>",
                "<%= Database.selectStatusById(users.get(i).getStatus_id()).getSkill4s()%>",
                "<%= Database.selectStatusById(users.get(i).getStatus_id()).getSkill5s()%>",
        ],
        message: "<%= users.get(i).getMessage()%>",
        phone: "<%= users.get(i).getPhone()%>",
        mail: "<%= users.get(i).getEmail()%>",
        clicked: false
}
,
            <% }%>
];
var skillLabels = ['<%= skills.getSkill1()%>', '<%= skills.getSkill2()%>', '<%= skills.getSkill3()%>', '<%= skills.getSkill4()%>', '<%= skills.getSkill5()%>'];
var app = new Vue({
el: '#app',
        data() {
return{
users: users,
        loading: false,
        visible: 'visible !important'
};
},
        methods: {
        onclick: function (index) {
        if (this.users[index].clicked === false) {
        this.users[index].clicked = true;
        console.log(this.users[index].clicked);
        } else {
        this.users[index].clicked = false;
        console.log(this.users[index].clicked);
        }

        }
        },
        mounted: function () {
        this.$nextTick(function () {
        users.forEach(function (user, index) {
        console.log("init(" + index + ") is fire!");
        var ctx = document.getElementById('myChart' + index).getContext("2d");
        var myChart = new Chart(ctx, {
        type: 'radar',
                data: {
                labels: skillLabels,
                        datasets: [{
                        data: user.status,
                                backgroundColor: "#FC1689"
                        }]
                },
                scaleStartValue: 0,
                options: {
                legend: {
                display: false,
                },
                        scale: {
                        display: true,
                                pointLabels: {
                                fontSize: 15, //フォントサイズ
                                        fontColor: '#000000'
                                },
                                ticks: {
                                stepSize: 1,
                                        max: 5,
                                        beginAtZero: true,
                                        display: false
                                },
                        }
                }
        });
        });
        })

        }
});
$(function () {
$('.material-card > .mc-btn-action').click(function () {
var card = $(this).parent('.material-card');
var icon = $(this).children('i');
icon.addClass('fa-spin-fast');
if (card.hasClass('mc-active')) {
card.removeClass('mc-active');
window.setTimeout(function () {
icon
        .removeClass('fa-arrow-left')
        .removeClass('fa-spin-fast')
        .addClass('fa-bars');
}, 800);
} else {
card.addClass('mc-active');
window.setTimeout(function () {
icon
        .removeClass('fa-bars')
        .removeClass('fa-spin-fast')
        .addClass('fa-arrow-left');
}, 800);
}
});
});
        </script>

        <style>
            a.fa:hover {
                text-decoration: none;
            }

            a:hover {
                opacity: 0.6;
            }

            a.detail-torigger:hover {
                opacity: 0.9;
            }

            main {
                background-color: #fff4a1;
                background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='100%25'%3E%3Cdefs%3E%3ClinearGradient id='a' gradientUnits='userSpaceOnUse' x1='0' x2='0' y1='0' y2='100%25' gradientTransform='rotate(240)'%3E%3Cstop offset='0' stop-color='%23fff4a1'/%3E%3Cstop offset='1' stop-color='%234FE'/%3E%3C/linearGradient%3E%3Cpattern patternUnits='userSpaceOnUse' id='b' width='540' height='450' x='0' y='0' viewBox='0 0 1080 900'%3E%3Cg fill-opacity='0.1'%3E%3Cpolygon fill='%23444' points='90 150 0 300 180 300'/%3E%3Cpolygon points='90 150 180 0 0 0'/%3E%3Cpolygon fill='%23AAA' points='270 150 360 0 180 0'/%3E%3Cpolygon fill='%23DDD' points='450 150 360 300 540 300'/%3E%3Cpolygon fill='%23999' points='450 150 540 0 360 0'/%3E%3Cpolygon points='630 150 540 300 720 300'/%3E%3Cpolygon fill='%23DDD' points='630 150 720 0 540 0'/%3E%3Cpolygon fill='%23444' points='810 150 720 300 900 300'/%3E%3Cpolygon fill='%23FFF' points='810 150 900 0 720 0'/%3E%3Cpolygon fill='%23DDD' points='990 150 900 300 1080 300'/%3E%3Cpolygon fill='%23444' points='990 150 1080 0 900 0'/%3E%3Cpolygon fill='%23DDD' points='90 450 0 600 180 600'/%3E%3Cpolygon points='90 450 180 300 0 300'/%3E%3Cpolygon fill='%23666' points='270 450 180 600 360 600'/%3E%3Cpolygon fill='%23AAA' points='270 450 360 300 180 300'/%3E%3Cpolygon fill='%23DDD' points='450 450 360 600 540 600'/%3E%3Cpolygon fill='%23999' points='450 450 540 300 360 300'/%3E%3Cpolygon fill='%23999' points='630 450 540 600 720 600'/%3E%3Cpolygon fill='%23FFF' points='630 450 720 300 540 300'/%3E%3Cpolygon points='810 450 720 600 900 600'/%3E%3Cpolygon fill='%23DDD' points='810 450 900 300 720 300'/%3E%3Cpolygon fill='%23AAA' points='990 450 900 600 1080 600'/%3E%3Cpolygon fill='%23444' points='990 450 1080 300 900 300'/%3E%3Cpolygon fill='%23222' points='90 750 0 900 180 900'/%3E%3Cpolygon points='270 750 180 900 360 900'/%3E%3Cpolygon fill='%23DDD' points='270 750 360 600 180 600'/%3E%3Cpolygon points='450 750 540 600 360 600'/%3E%3Cpolygon points='630 750 540 900 720 900'/%3E%3Cpolygon fill='%23444' points='630 750 720 600 540 600'/%3E%3Cpolygon fill='%23AAA' points='810 750 720 900 900 900'/%3E%3Cpolygon fill='%23666' points='810 750 900 600 720 600'/%3E%3Cpolygon fill='%23999' points='990 750 900 900 1080 900'/%3E%3Cpolygon fill='%23999' points='180 0 90 150 270 150'/%3E%3Cpolygon fill='%23444' points='360 0 270 150 450 150'/%3E%3Cpolygon fill='%23FFF' points='540 0 450 150 630 150'/%3E%3Cpolygon points='900 0 810 150 990 150'/%3E%3Cpolygon fill='%23222' points='0 300 -90 450 90 450'/%3E%3Cpolygon fill='%23FFF' points='0 300 90 150 -90 150'/%3E%3Cpolygon fill='%23FFF' points='180 300 90 450 270 450'/%3E%3Cpolygon fill='%23666' points='180 300 270 150 90 150'/%3E%3Cpolygon fill='%23222' points='360 300 270 450 450 450'/%3E%3Cpolygon fill='%23FFF' points='360 300 450 150 270 150'/%3E%3Cpolygon fill='%23444' points='540 300 450 450 630 450'/%3E%3Cpolygon fill='%23222' points='540 300 630 150 450 150'/%3E%3Cpolygon fill='%23AAA' points='720 300 630 450 810 450'/%3E%3Cpolygon fill='%23666' points='720 300 810 150 630 150'/%3E%3Cpolygon fill='%23FFF' points='900 300 810 450 990 450'/%3E%3Cpolygon fill='%23999' points='900 300 990 150 810 150'/%3E%3Cpolygon points='0 600 -90 750 90 750'/%3E%3Cpolygon fill='%23666' points='0 600 90 450 -90 450'/%3E%3Cpolygon fill='%23AAA' points='180 600 90 750 270 750'/%3E%3Cpolygon fill='%23444' points='180 600 270 450 90 450'/%3E%3Cpolygon fill='%23444' points='360 600 270 750 450 750'/%3E%3Cpolygon fill='%23999' points='360 600 450 450 270 450'/%3E%3Cpolygon fill='%23666' points='540 600 630 450 450 450'/%3E%3Cpolygon fill='%23222' points='720 600 630 750 810 750'/%3E%3Cpolygon fill='%23FFF' points='900 600 810 750 990 750'/%3E%3Cpolygon fill='%23222' points='900 600 990 450 810 450'/%3E%3Cpolygon fill='%23DDD' points='0 900 90 750 -90 750'/%3E%3Cpolygon fill='%23444' points='180 900 270 750 90 750'/%3E%3Cpolygon fill='%23FFF' points='360 900 450 750 270 750'/%3E%3Cpolygon fill='%23AAA' points='540 900 630 750 450 750'/%3E%3Cpolygon fill='%23FFF' points='720 900 810 750 630 750'/%3E%3Cpolygon fill='%23222' points='900 900 990 750 810 750'/%3E%3Cpolygon fill='%23222' points='1080 300 990 450 1170 450'/%3E%3Cpolygon fill='%23FFF' points='1080 300 1170 150 990 150'/%3E%3Cpolygon points='1080 600 990 750 1170 750'/%3E%3Cpolygon fill='%23666' points='1080 600 1170 450 990 450'/%3E%3Cpolygon fill='%23DDD' points='1080 900 1170 750 990 750'/%3E%3C/g%3E%3C/pattern%3E%3C/defs%3E%3Crect x='0' y='0' fill='url(%23a)' width='100%25' height='100%25'/%3E%3Crect x='0' y='0' fill='url(%23b)' width='100%25' height='100%25'/%3E%3C/svg%3E");
                background-attachment: fixed;
                background-size: cover;
            }

            .name {
                font-size: 3rem;
                font-weight: bold;
            }

            nav {
                margin-bottom: 0 !important;
                text-align: left !important;
                justify-content: start !important;
            }

            .d-block {
                height: 800px;
            }

            .loading {
                height: 100%;
            }

            .chart {
                width: 100% !important;
                height: 100% !important;
            }

            [v-cloak] {
                display: none !important;
            }

            .font-20 {
                font-size: 20px !important;
            }

            .back-chart {
                background-color: #FEEFB8 !important;
            }

            .message {
                font-size: 1rem;
            }

            .position {
                font-size: 6.25rem !important;

            }

            @keyframes octocat-wave {
                0%,
                100% {
                    transform: rotate(0)
                }
                20%,
                60% {
                    transform: rotate(-25deg)
                }
                40%,
                80% {
                    transform: rotate(10deg)
                }
            }

            @media (max-width:500px) {
                .github-corner:hover .octo-arm {
                    animation: none
                }
                .github-corner .octo-arm {
                    animation: octocat-wave 560ms ease-in-out
                }
            }
        </style>
    </body>
</html>

```

## 制作物のアピールポイント
### アイデア
今回の最終課題を行うにあたり，一番苦労した点は作るモノを決めることであった．私の中でせっかく作るのであれば身近で感じた問題を解決できる何かを作りたいという一つの信念のようなものがあったため，自分の日常の生活に焦点を当てて考えてみた．すると，お金に関することや学業に関することなど様々な課題が見つかり，その中でも特にインターン先での課題発見が一番旬だっため，それを題材に取り上げたのだ．この制作物の最初にして最大のアピールポイントは，課題解決をベースに考えついたアイデアにあると私は考える．
### Javaアプリケーションという点にこだわった
この課題の制作を始めた時，あまりJavaアプリケーションとしての比重をかけ過ぎず，比較的得意なフロント側で処理をまとめようと考えていた．そのため，Json形式のファイルを返すだけの役割しか初めはJavaに持たせていなかったのだが，途中で今回の課題の目的を見つめ直し，1年間をかけて学んだJavaで有終の美を飾ろうと軌道修正した．
### ユーザ視点に立ったUIを心がけた
せっかく作るのであれば，ユーザの問題解決とともにUXにもこだわりたいと感じたため本当に必要な情報にデータを絞ることや，見た目の部分でユーザに負担をかけていないか作りながら何度も修正を加えた．正直満足いくUIが作れたか問われれば満足はいっていない．しかし，この短期間での制作やUI/UXデザイナーからのプロトタイプなしという条件を加味すると，健闘できたのではないかと考える．

## 感想
### 良かった点
アジャイル開発手法を適用し，大まかな仕様構想を頼りにとにかく手を動かした．この選択が正しかったのか，最後までプログラムを作りきることができた．もしウォーターフォール型で開発を始めていたら，プログラムを作る前から完成を諦めていたと思う．

とにかくコミットできた点．今回の最終課題には今までで一番コミットできたと自負している．アルバイトやテスト前などで中々時間を捻出するのが難しかったが，隙間時間や寝る時間を使って取り組めたので思っていたよりもこの課題に時間と労力をかけることができた．

これは今回の最終課題を通してだけではなく，講義全体を通してだが，永谷先生に積極的に質問できたことも良かった点だと考える．永谷先生のお時間と労力を奪ってしまったが，質問をしたことで得られた知見や成果は非常に多大なものであった．永谷先生にかけていただいた労力に報いるためにもしっかり完成するんだという強いモチベーションにつながったことも効用としてあげられる．
### 悪かった点
最近勉強しているVue.jsをむやみやたらと使おうとしてしまった点．最近私はVue.jsを勉強しているのだが，今回の課題を通してVue.jsを中心に設計を考えてしまったという反省点を抱いた．必要以上にVue.jsを使おうとしてしまったがためにjspを利用すれば簡単に実装できた処理が中々うまくいかなかったりという事態に何度か陥ってしまった．技術主体でものづくりをしてしまうとこういったことが起きてしまいがちだと思うので，次からは実装したい機能を達成するための技術という位置付けを意識した設計をしたい．

メンテナンス性を考慮できなかったというのも大きな反省点である．オブジェクト指向を学んだ者として，メンテナンス性の高いコードを書くことは絶対必要な点だが，今回作った制作物はクラスの切り分け方が甘かったり，データベース設計の段階でうまく正規化ができていなかったりしてメンテナンス性にかける，その場しのぎのようなプログラムになってしまった．設計の段階で出来るだけ抽象化できるものがないか検討する様にするのと，オブジェクト指向での設計の仕方をもっと勉強する．

PDCAサイクルを回せなかった．今回の最終課題でPlanとDoはできたが，Check（ユーザテストやインタビューなど）ができなかったため，自己完結させてしまったアプリケーションとなった．設計から実装までのスピードを上げて，CheckとActionもできるようになれば，よりユーザに寄り添った良いアプリケーションができたのではないかと考える．

## 参考資料・文献等
* [コトハノチカラ(2009-07-27) -JSPにてBLOB型の画像出力成功！！-](https://blog.goo.ne.jp/tadasuke2002/e/503fd8f0010c998333e7e7475e2c56c6)
* [備忘録的なblog(2010年1月31日日曜日) -【Oracle】JDBC経由でBLOBデータ挿入-](http://se-bikou.blogspot.com/2010/01/jdbcblob.html)
* [BootStrap](https://getbootstrap.com/)
* [BootStrap Cheet Sheet](https://hackerthemes.com/bootstrap-cheatsheet/)
* [SemanticUI](https://semantic-ui.com/introduction/integrations.html)
* [Chart.js](https://misc.0o0o.org/chartjs-doc-ja/)
* [Font Awesome](https://fontawesome.com/start)
* [axios](https://github.com/axios/axios)
* [PhotShopVIP(2018年12月19日) -ウェブデザイン制作が格段にラク！覚えておきたい最新便利ツールまとめ-](http://photoshopvip.net/112862)
* [Grabient](https://www.grabient.com/)
* [SVG Backgrounds](https://www.svgbackgrounds.com/#radiant-gradient)






