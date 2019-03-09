<% request.setCharacterEncoding("UTF-8"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <title>HouseholdAccounts - Register</title>
        <link rel="stylesheet" href="assets/css/signin.css">
    </head>

    <body class="text-center">
        <form class="form-signin" enctype="multipart/form-data" action="UserRegister" method="POST">
            <h1 class="h2 mb-3 font-weight-normal"><strong>新規登録</strong></h1>
            <% if (request.getParameter("info") != null) {%>
            <div class="alert alert-info" role="alert"><%= request.getParameter("info")%></div>
            <% }%>
            <% if (request.getParameter("error") != null) {%>
            <div class="alert alert-danger" role="alert"><%= request.getParameter("error")%></div>
            <% }%>
            <label for="inputEmail" class="sr-only">Eメールアドレス</label>
            <input type="email" id="inputEmail" name="form-email" class="form-control form-control-first" placeholder="sample@sample.com" required autofocus>
            <label for="inputPassword" class="sr-only">パスワード</label>
            <input type="password" name="form-pwd" id="inputPassword" class="form-control form-control-last" placeholder="Password" required>
            <label for="inputName" class="sr-only">あなたの名前</label>
            <input type="text" id="inputName" name="form-name" class="form-control" placeholder="Your Name" required>
            <input type="file" name="form-photo" class="form-control form-control-last" required>
            <label class="sr-only">所属チーム名</label>
            <input type="text" name="form-organization" class="form-control form-control-last" placeholder="team name" required>
            <label class="sr-only">あなたのポジション（役職）</label>
            <input type="text" name="form-position" class="form-control form-control-last" placeholder="position" required>
            <label class="sr-only">電話番号</label>
            <input type="text" name="form-phone" class="form-control form-control-last" placeholder="Phone" required>
            <label class="sr-only">ひとこと</label>
            <input type="textarea" name="form-message" class="form-control form-control-last" placeholder="ex) こんにちは！私は〇〇です．．．．" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">登録する！</button>
            <p class="mt-5 mb-3 text-muted">&copy; k17053 2018</p>
        </form>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    </body>
</html>