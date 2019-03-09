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
