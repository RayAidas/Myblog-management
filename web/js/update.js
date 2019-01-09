var art_Id;
var id = $.cookie("id");
console.log(id);
$.ajax({
    type: "GET",
    url: '/article',
    dataType: 'json',
    data:{},
    success: function(res) {
        console.log(res);
        // document.getElementById("r_title").value = res[art_id].art_title;
        art_Id=res[id].art_id;
        $("#r_title").attr("value",res[id].art_title);
        $("#r_content").append(res[id].art_content);
        $("#r_tag").attr("value",res[id].art_tag);
        $("#r_description").append(res[id].art_description);
        var type = res[id].art_type;
        switch (type) {
            case "前端技术":$("#1").attr('checked','true');break;
            case "后端技术":$("#2").attr('checked','true');break;
            case "管理系统":$("#3").attr('checked','true');break;
            case "授人以渔":$("#4").attr('checked','true');break;
            case "程序人生":$("#5").attr('checked','true');break;
        }

    }
})





function update() {
    var art_id=art_Id;
    var title=$('#r_title').val();
    var content=$('#r_content').val();
    var description=$('#r_desciption').val();
    var tag=$('#r_tag').val();
    var type=$('input:radio[name="category"]:checked').val();
    $.ajax({
        type: "POST",
        url: '/upd_art',
        dataType: 'text',
        data: {
            "id":art_id,
            "title":title,
            "type":type,
            "content":content,
            "description":description,
            "tag":tag
        },
        success:function(){
            alert("修改成功");
            window.location.href = "article.html";
        },
        error:function() {
            alert("修改失败");
        }
    });
    return false;
}
$("#count").html($("#r_content").val().length);
$("#r_content").keydown(function () {
    $("#count").html($("#r_content").val().length);
});

