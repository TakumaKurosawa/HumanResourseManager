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
