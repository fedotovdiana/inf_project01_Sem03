<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Film</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            <#if !(user?has_content)>
                $('#btn_like').attr("disabled", 'disabled');
                $('#btn_dislike').attr("disabled", 'disabled');
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
                        $('#table_comments').append("<tr><td>" + msg.user_name + "</td><td>" + $('#text_comment').val() + "</td><td>" + msg.date + "</td></tr>");
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
                        alert($('#selector').val());
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
                        alert("Added in " + $('#text_new_ch').val());
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
                        alert("You liked " + ${film.id});
                        $('#btn_like').val(parseInt($('#btn_like').val()) + 1);
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
                        alert("You disliked " + ${film.name});
                        $('#btn_dislike').val(parseInt($('#btn_dislike').val()) + 1);
                        $('#btn_dislike').attr("disabled", 'disabled');
                    }
                });
            });
        });
    </script>
</head>
<body>
<p>${film.name}</p>
<table border="1">
    <tr>
        <td>${film.country}</td>
        <td>${film.date}</td>
        <td>${film.photo}</td>
        <td>${film.text}</td>
        <#--        <#if user??></#if>-->
        <td><input type="button" id="btn_like" value="${likes}"></td>
        <td><input type="button" id="btn_dislike" value="${dislikes}"></td>
    </tr>
</table>

<p>Categories</p>
<table border="1">
    <#list categories as c>
        <tr>
            <td>${c.name}</td>
        </tr>
    </#list>
</table>

<#if actors?has_content>
    <p>Actors</p>
    <table border="1">
        <#list actors as a>
            <tr>
                <td>
                    <form action="http://localhost:8080/star" method="get">
                        <input hidden name="actor_id" value="${a.id}"/>
                        <input type="submit" name="actor_name" value="${a.name}"/>
                    </form>
                </td>
                <td>${a.photo}</td>
            </tr>
        </#list>
    </table>
</#if>

<#if producers?has_content>
    <p>Producers</p>
    <table border="1">
        <#list producers as p>
            <tr>
                <td>
                    <form action="http://localhost:8080/star" method="get">
                        <input hidden name="producer_id" value="${p.id}"/>
                        <input type="submit" name="producer_name" value="${p.name}"/>
                    </form>
                </td>
                <td>${p.photo}</td>
            </tr>
        </#list>
    </table>
</#if>

<#if scriptwriters?has_content>
    <p>Scriptwriters</p>
    <table border="1">
        <#list scriptwriters as s>
            <tr>
                <td>
                    <form action="http://localhost:8080/star" method="get">
                        <input hidden name="scr_id" value="${s.id}"/>
                        <input type="submit" name="scr_name" value="${s.name}"/>
                    </form>
                </td>
                <td>${s.photo}</td>
            </tr>
        </#list>
    </table>
</#if>

<p>Comments</p>
<table border="1" id="table_comments">
    <#list comments as c>
        <tr>
            <td>${c.user}</td>
            <td>${c.text}</td>
            <td>${c.date}</td>
        </tr>
    </#list>
</table>


<#if user??>
    <p>Add comment</p>
    <div>
        <textarea autofocus id="text_comment"></textarea>
    </div>
    <div>
        <input type="button" id="byn_add_comment" value="Add comment"/>
    </div>
    <#if checklists?has_content>
        <div>
            <span>
            <select id="selector">
                <#list checklists as c>
                    <option id=${c.name}>${c.name}</option>
                </#list>
            </select>
            </span>
            <span>
                <input type="button" id="btn_add_to" value="Add film into"/>
            </span>
        </div>
    </#if>
    <div>
        <input type="text" id="text_new_ch" name="input"/>
        <#--        <input type="hidden" name="film" value="${film.id}"/>-->
        <input type="button" id="btn_add_to_new" value="To new checklist"/>
    </div>
</#if>
</body>
</html>
