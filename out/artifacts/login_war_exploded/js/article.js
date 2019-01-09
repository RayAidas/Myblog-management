var titles=[];
var types=[];
var tags=[];
var times=[];
var ids=[];
function r_onclick(id){
    $.cookie("id",id);
}

function dele(d_id) {
    $.ajax({
        type: "POST",
        url: '/del_art',
        dataType: 'text',
        data: {
            "id": ids[d_id]
        },
        success: function () {
            alert("删除成功")
        },
        error: function () {
            alert("删除失败")
        }
    })
}

$(function () {
    $.ajax({
        type: "GET",
        url: '/article',
        dataType: 'json',
        data:{},
        success: function(res) {
            console.log(res);
            if(res) {
                for (var i=0;i<res.length;i++){
                    titles.push(res[i].art_title);
                    types.push(res[i].art_type);
                    tags.push(res[i].art_tag);
                    times.push(res[i].art_cre_time);
                    ids.push(res[i].art_id);
                }
            }
            var data="";
            for (var j = 0; j <res.length; j++) {
                data += "<tr>";
                data += "<td><input type=\"checkbox\" class=\"input-control\" name=\"checkbox[]\" /></td>";
                data += "<td class=\"article-title\">"+titles[j]+"</td>";
                data += "<td>"+types[j]+"</td>";
                data += "<td class=\"hidden-sm\">"+tags[j]+"</td>";
                data += "<td class=\"hidden-sm\">0</td>";
                data += "<td>"+times[j]+"</td>";
                data += "<td><button  onclick='r_onclick(name)'><a href='update-article.html'>修改</a></button> <button onclick=\"dele("+j+")\">删除</button></td>";
                data += "</tr>";
            }
            // console.log(data);
            document.getElementById("art_list").innerHTML=data;

            var list = $("#art_list>tr button:even");
            var checkbox = $("input[type='checkbox'][name='checkbox[]']");

            for(var k=0;k<res.length;k++){
                list.eq(k).attr("name",k);
                checkbox.eq(k).attr("value",k);
            }
        }
    });
});
