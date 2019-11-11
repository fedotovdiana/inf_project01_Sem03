<#include 'header.ftl'>
<#include 'libraries.ftl'>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../front/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../front/css/style.css" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            <#if !(user?has_content)>
            $('#btn_like').attr("disabled", 'disabled');
            $('#btn_dislike').attr("disabled", 'disabled');
            $('#btn_add_to_new').attr("disabled", 'disabled');
            $('#btn_add_to').attr("disabled", 'disabled');
            </#if>
            $('#byn_add_comment').click(function () {
                $.ajax({
                    type: "post",
                    url: "/comment",
                    dataType: "json",
                    data: {
                        "text": $('#text_comment').val(),
                        "film_id": "${film.id}"
                    },
                    success: function (msg) {
                        $('#table_comments').html(
                            "<div class=\"col-sm-12\">" +
                            "<div class=\"card\">" +
                            "<div class=\"card-body\">" +
                            "<div class=\"media-block\">" +
                            "<div class=\"media-body\">" +
                            "<div class=\"mar-btm\">" +
                            "<a href=\"#\" class=\"btn-link text-semibold media-heading box-inline\">" + msg.user_name + "</a>" +
                            "<p class=\"text-muted text-sm\"><i class=\"fa fa-mobile fa-lg\"></i>" + msg.date + "</p> " +
                            "</div>" +
                            " <p>" + $('#text_comment').val() + "</p> " +
                            "</div> " +
                            "</div>" +
                            "</div>" +
                            "</div>" +
                            "</div>")
                        //     "<tr><td>" + msg.user_name + "</td><td>" + $('#text_comment').val() + "</td><td>" + msg.date + "</td></tr>");
                        $('#text_comment').val("");
                    }
                });
            });
            $('#btn_add_to').click(function () {
                $.ajax({
                    type: "post",
                    url: "/film",
                    data: {
                        "input": $('#selector').val(),
                        "film_id": "${film.id}"
                    },
                    success: function () {
                        $('#selector').append("<#list checklists as c><option id=${c.name}>${c.name}</option></#list><option>" + $('#selector').val() + "</option>");
                        $('#btn_add_to').attr("disabled", 'disabled');
                    }
                });
            });
            $('#btn_add_to_new').click(function () {
                $.ajax({
                    type: "post",
                    url: "/creation",
                    data: {
                        "input": $('#text_new_ch').val(),
                        "film_id": "${film.id}"
                    },
                    success: function () {
                        $('#text_new_ch').val("");
                        $('#btn_add_to_new').attr("disabled", 'disabled');
                    }
                });
            });
            $('#btn_like').click(function () {
                $.ajax({
                    type: "post",
                    url: "/like",
                    data: {
                        "film_id": "${film.id}"
                    },
                    success: function () {
                        $('#btn_like').val((parseInt($('#btn_like').val()) + 1) + " likes");
                        $('#btn_like').attr("disabled", 'disabled');
                    }
                });
            });
            $('#btn_dislike').click(function () {
                $.ajax({
                    type: "post",
                    url: "/dislike",
                    data: {
                        "film_id": "${film.id}"
                    },
                    success: function () {
                        $('#btn_dislike').val((parseInt($('#btn_dislike').val()) + 1) + " dislikes");
                        $('#btn_dislike').attr("disabled", 'disabled');
                    }
                });
            });
        });
    </script>
    <title>Film</title>
</head>
<body class="photo">
<@header/>
<div class="container film">
    <div class="row">
        <div class="col-12">
            <h2 class="name">${film.name}</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <img src="../../front/img/${film.name}" alt="..." class="img-thumbnail ">
            <div class="input-group">
                <#if checklists?has_content>
                    <div>
                        <select class="custom-select" id="selector">
                            <option selected>Choose...</option>
                            <#list checklists as c>
                                <option id=${c.name}>${c.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div>
                        <input type="button" class="btn btn-primary btn-pri" id="btn_add_to" value="Add to checklist"/>
                    </div>
                </#if>
                <div>
                    <hr>
                    <input type="text" class="form-control" id="text_new_ch" name="input"/>
                    <input type="hidden" name="film" value="${film.id}"/>
                    <input type="button" class="btn btn-primary btn-pri" id="btn_add_to_new" value="To new checklist"/>
                </div>
            </div>
            <input type="button" class="btn btn-primary btn-pri" id="btn_like" value="${likes} likes">
            <input type="button" class="btn btn-primary btn-pri" id="btn_dislike" value="${dislikes} dislikes">
        </div>
        <#--                <button type="button" class="btn btn-primary btn-pri" data-toggle="modal"-->
        <#--                        data-target="#exampleModal" data-whatever="@mdo">Create new checklist-->
        <#--                </button>-->
        <#--                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"-->
        <#--                     aria-labelledby="exampleModalLabel" aria-hidden="true">-->
        <#--                    <div class="modal-dialog" role="document">-->
        <#--                        <div class="modal-content">-->
        <#--                            <div class="modal-header">-->
        <#--                                <h5 class="modal-title" id="exampleModalLabel">Create checklist</h5>-->
        <#--                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">-->
        <#--                                    <span aria-hidden="true">&times;</span>-->
        <#--                                </button>-->
        <#--                            </div>-->
        <#--                            <div class="modal-body">-->
        <#--                                <form>-->
        <#--                                    <div class="form-group">-->
        <#--                                        <label for="text_new_ch" class="col-form-label">Ether the name:</label>-->
        <#--                                        <input type="text" class="form-control" id="text_new_ch">-->
        <#--                                    </div>-->
        <#--                                </form>-->
        <#--                            </div>-->
        <#--                            <div class="modal-footer">-->
        <#--                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cansel</button>-->
        <#--                                <button type="button"  id="btn_add_to_new" class="btn btn-primary">Create</button>-->
        <#--                            </div>-->
        <#--                        </div>-->
        <#--                    </div>-->
        <#--                </div>-->
        <#--            </div>-->
        <#--        </div>-->
        <#--        <script>-->
        <#--            $('#exampleModal').on('show.bs.modal', function (event) {-->
        <#--                var button = $(event.relatedTarget) // Button that triggered the modal-->
        <#--                var recipient = button.data('whatever')-->
        <#--                $.ajax({-->
        <#--                    type: "post",-->
        <#--                    url: "/creation",-->
        <#--                    data: {-->
        <#--                        "input": $('#text_new_ch').val(),-->
        <#--                        "film_id": "${film.id}"-->
        <#--                    },-->
        <#--                    success: function () {-->
        <#--                        alert("Added in " + $('#text_new_ch').val());-->
        <#--                        $('#text_new_ch').val("");-->
        <#--                        $('#btn_add_to_new').attr("disabled", 'disabled');-->
        <#--                    }-->
        <#--                });// Extract info from data-* attributes-->
        <#--                // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).-->
        <#--                // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.-->
        <#--                var modal = $(this)-->
        <#--                modal.find('.modal-title').text('New message to ' + recipient)-->
        <#--                modal.find('.modal-body input').val(recipient)-->
        <#--            });-->
        <#--        </script>-->

        <div class="col-9">
            <table class="table">
                <tbody>
                <tr>
                    <th scope="row">Release date:</th>
                    <td>${film.date}</td>
                </tr>
                <tr>
                    <th scope="row">Country:</th>
                    <td>${film.country}</td>
                </tr>
                <tr>
                    <th scope="row">Categories:</th>

                    <td>
                        <#list categories as c>${c.name} </#list>
                    </td>

                </tr>
                <tr>
                    <th scope="row">Producers:</th>
                    <#list producers as p>
                        <td><a href="/star?producer_id=${p.id}" class="reg">${p.name}</a></td>
                    </#list>
                </tr>
                <tr>
                    <th scope="row">Scriptwriters:</th>
                    <#list scriptwriters as s>
                        <td><a href="/star?scr_id=${s.id}" class="reg">${s.name}</a></td>
                    </#list>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <h2 class="text-center">Actors</h2>
    </div>
    <div class="row">
        <#list actors as a>
            <div class="col-md-3">
                <div class="card mb-2">
                    <a href="/star?actor_id=${a.id}"><img src="../../front/img/${a.photo}" class="img-thumbnail"
                                                          alt="..."></a>
                </div>
            </div>
        </#list>
    </div>
    <div class="row">
        <h2> Description </h2>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="card">
                <div class="card-body">
                    <p class="card-text">${film.text}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <p></p>
    </div>
    <div class="row">
        <h2>Comments</h2>
    </div>
    <#list comments as c>
        <div class="row" id="table_comments">
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="card">
                    <div class="card-body">
                        <div class="media-block">
                            <div class="media-body">
                                <div class="mar-btm">
                                    <a href="#" class="btn-link text-semibold media-heading box-inline">${c.user}</a>
                                    <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> ${c.date}</p>
                                </div>
                                <p>${c.text}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#list>
    <#if (user?has_content)>
        <div class="row">
            <div class="col-md-12">
                <div class="panel">
                    <div class="panel-body">
                        <textarea class="form-control" id="text_comment" rows="2" placeholder="Add comment"></textarea>
                        <div class="mar-top clearfix">
                            <button class="btn btn-sm btn-primary pull-right" id="byn_add_comment" type="submit"><i
                                        class="fa fa-pencil fa-fw"></i>Add
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#if>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>

<#--<!DOCTYPE html>-->
<#--<html lang="en">-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <title>Film</title>-->
<#--    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>-->
<#--    <script type="text/javascript">-->
<#--        $(document).ready(function () {-->
<#--            <#if !(user?has_content)>-->
<#--                $('#btn_like').attr("disabled", 'disabled');-->
<#--                $('#btn_dislike').attr("disabled", 'disabled');-->
<#--            </#if>-->
<#--            $('#byn_add_comment').click(function () {-->
<#--                $.ajax({-->
<#--                    type: "post",-->
<#--                    url: "/comment",-->
<#--                    dataType: "json",-->
<#--                    data: {-->
<#--                        "text": $('#text_comment').val(),-->
<#--                        "film_id": "${film.id}"-->
<#--                    },-->
<#--                    success: function (msg) {-->
<#--                        $('#table_comments').append("<tr><td>" + msg.user_name + "</td><td>" + $('#text_comment').val() + "</td><td>" + msg.date + "</td></tr>");-->
<#--                        $('#text_comment').val("");-->
<#--                    }-->
<#--                });-->
<#--            });-->
<#--            $('#btn_add_to').click(function () {-->
<#--                $.ajax({-->
<#--                    type: "post",-->
<#--                    url: "/film",-->
<#--                    data: {-->
<#--                        "input": $('#selector').val(),-->
<#--                        "film_id": "${film.id}"-->
<#--                    },-->
<#--                    success: function () {-->
<#--                        alert($('#selector').val());-->
<#--                        $('#selector').append("<#list checklists as c><option id=${c.name}>${c.name}</option></#list><option>" + $('#selector').val() + "</option>");-->
<#--                        $('#btn_add_to').attr("disabled", 'disabled');-->
<#--                    }-->
<#--                });-->
<#--            });-->
<#--            $('#btn_add_to_new').click(function () {-->
<#--                $.ajax({-->
<#--                    type: "post",-->
<#--                    url: "/creation",-->
<#--                    data: {-->
<#--                        "input": $('#text_new_ch').val(),-->
<#--                        "film_id": "${film.id}"-->
<#--                    },-->
<#--                    success: function () {-->
<#--                        alert("Added in " + $('#text_new_ch').val());-->
<#--                        $('#text_new_ch').val("");-->
<#--                        $('#btn_add_to_new').attr("disabled", 'disabled');-->
<#--                    }-->
<#--                });-->
<#--            });-->
<#--            $('#btn_like').click(function () {-->
<#--                $.ajax({-->
<#--                    type: "post",-->
<#--                    url: "/like",-->
<#--                    data: {-->
<#--                        "film_id": "${film.id}"-->
<#--                    },-->
<#--                    success: function () {-->
<#--                        alert("You liked " + ${film.id});-->
<#--                        $('#btn_like').val(parseInt($('#btn_like').val()) + 1);-->
<#--                        $('#btn_like').attr("disabled", 'disabled');-->
<#--                    }-->
<#--                });-->
<#--            });-->
<#--            $('#btn_dislike').click(function () {-->
<#--                $.ajax({-->
<#--                    type: "post",-->
<#--                    url: "/dislike",-->
<#--                    data: {-->
<#--                        "film_id": "${film.id}"-->
<#--                    },-->
<#--                    success: function () {-->
<#--                        alert("You disliked " + ${film.name});-->
<#--                        $('#btn_dislike').val(parseInt($('#btn_dislike').val()) + 1);-->
<#--                        $('#btn_dislike').attr("disabled", 'disabled');-->
<#--                    }-->
<#--                });-->
<#--            });-->
<#--        });-->
<#--    </script>-->
<#--</head>-->
<#--<body>-->
<#--<p>${film.name}</p>-->
<#--<table border="1">-->
<#--    <tr>-->
<#--        <td>${film.country}</td>-->
<#--        <td>${film.date}</td>-->
<#--        <td>${film.photo}</td>-->
<#--        <td>${film.text}</td>-->
<#--        &lt;#&ndash;        <#if user??></#if>&ndash;&gt;-->
<#--        <td><input type="button" id="btn_like" value="${likes}"></td>-->
<#--        <td><input type="button" id="btn_dislike" value="${dislikes}"></td>-->
<#--    </tr>-->
<#--</table>-->

<#--<p>Categories</p>-->
<#--<table border="1">-->
<#--    <#list categories as c>-->
<#--        <tr>-->
<#--            <td>${c.name}</td>-->
<#--        </tr>-->
<#--    </#list>-->
<#--</table>-->

<#--<#if actors?has_content>-->
<#--    <p>Actors</p>-->
<#--    <table border="1">-->
<#--        <#list actors as a>-->
<#--            <tr>-->
<#--                <td>-->
<#--                    <form action="http://localhost:8080/star" method="get">-->
<#--                        <input hidden name="actor_id" value="${a.id}"/>-->
<#--                        <input type="submit" name="actor_name" value="${a.name}"/>-->
<#--                    </form>-->
<#--                </td>-->
<#--                <td>${a.photo}</td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--    </table>-->
<#--</#if>-->

<#--<#if producers?has_content>-->
<#--    <p>Producers</p>-->
<#--    <table border="1">-->
<#--        <#list producers as p>-->
<#--            <tr>-->
<#--                <td>-->
<#--                    <form action="http://localhost:8080/star" method="get">-->
<#--                        <input hidden name="producer_id" value="${p.id}"/>-->
<#--                        <input type="submit" name="producer_name" value="${p.name}"/>-->
<#--                    </form>-->
<#--                </td>-->
<#--                <td>${p.photo}</td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--    </table>-->
<#--</#if>-->

<#--<#if scriptwriters?has_content>-->
<#--    <p>Scriptwriters</p>-->
<#--    <table border="1">-->
<#--        <#list scriptwriters as s>-->
<#--            <tr>-->
<#--                <td>-->
<#--                    <form action="http://localhost:8080/star" method="get">-->
<#--                        <input hidden name="scr_id" value="${s.id}"/>-->
<#--                        <input type="submit" name="scr_name" value="${s.name}"/>-->
<#--                    </form>-->
<#--                </td>-->
<#--                <td>${s.photo}</td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--    </table>-->
<#--</#if>-->

<#--<p>Comments</p>-->
<#--<table border="1" id="table_comments">-->
<#--    <#list comments as c>-->
<#--        <tr>-->
<#--            <td>${c.user}</td>-->
<#--            <td>${c.text}</td>-->
<#--            <td>${c.date}</td>-->
<#--        </tr>-->
<#--    </#list>-->
<#--</table>-->


<#--<#if user??>-->
<#--    <p>Add comment</p>-->
<#--    <div>-->
<#--        <textarea autofocus id="text_comment"></textarea>-->
<#--    </div>-->
<#--    <div>-->
<#--        <input type="button" id="byn_add_comment" value="Add comment"/>-->
<#--    </div>-->
<#--    <#if checklists?has_content>-->
<#--        <div>-->
<#--            <span>-->
<#--            <select id="selector">-->
<#--                <#list checklists as c>-->
<#--                    <option id=${c.name}>${c.name}</option>-->
<#--                </#list>-->
<#--            </select>-->
<#--            </span>-->
<#--            <span>-->
<#--                <input type="button" id="btn_add_to" value="Add film into"/>-->
<#--            </span>-->
<#--        </div>-->
<#--    </#if>-->
<#--    <div>-->
<#--        <input type="text" id="text_new_ch" name="input"/>-->
<#--        &lt;#&ndash;        <input type="hidden" name="film" value="${film.id}"/>&ndash;&gt;-->
<#--        <input type="button" id="btn_add_to_new" value="To new checklist"/>-->
<#--    </div>-->
<#--</#if>-->
<#--</body>-->
<#--</html>-->

