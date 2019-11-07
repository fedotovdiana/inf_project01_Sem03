<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Checklist ${checklist.name}</title>
</head>
<body>
<p>Films</p>
<#if films?has_content>
<table border="1">
    <#list films as f>
        <tr>
            <td>
                <form action="http://localhost:8080/film" method="get">
                    <input hidden name="film_id" value="${f.id}"/>
                    <input type="submit" id="name" name="film_name" value="${f.name}"/>
                </form>
            </td>
            <td>${f.country}</td>
            <td>${f.date}</td>
            <td>${f.likes}</td>
            <td>
                <form action="http://localhost:8080/removal" method="post">
                    <input hidden name="film_id" value="${f.id}"/>
                    <input hidden name="checklist" value="${checklist.id_checklist}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </#list>
    </#if>
</table>
</body>
</html>

<#--    <script>
          // $(document).ready(function () {
          //     $('#btn_remove').click(function () {
                  // alert("" + $('#name').val() + "was removed");
                  // alert("sssssssss")
                  // $.ajax({
                  //     type: "post",
                  //     url: "/removal",
                  //     data: {
                  //         "film_id": $('#id').val()
                  //     },
                  //     success: function () {
                  //         alert("" + $('#name').val() + "was removed");
                  //         $(('#id').val()).hide();
                  //     }
                  // });
          //     });
          // });
     </script> -->