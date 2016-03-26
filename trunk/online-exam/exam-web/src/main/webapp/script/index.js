var currentUrl;

jQuery(document).ready(function () {
    initMenu();
    $("#menu").on("click","a",function(){
        var url=$(this).attr("value");
        if(url&&currentUrl!=url){
            currentUrl=url;
            $("#iframepage").attr("src",com.appRootUrl+url);
        }
    })
});

function initMenu(){
    com.ajax.jsonGet("/user/getAllMenu","",function(result){
        if (result && result.data) {
            var titleHtml = "";
            $.each(result.data, function (i, obj) {

                if(obj.menus && obj.menus.length > 0){
                    titleHtml +="<li class='treeview'><a href='#'><i class='fa fa-link'></i><span>" + obj.naName + "</span>"
                    var t="";
                    t=getChildMemu(t,obj.menus);
                    titleHtml+= "<i class='fa fa-angle-left pull-right'></i></a>"+t+"</li>";
                }else{
                    titleHtml +="<li><a href='#'><i class='fa fa-link'></i><span>" + obj.naName + "</span></a></li>"
                }
            });
            $("#menu").append(titleHtml);
        }
    });
}

function getChildMemu(t,menu){
    t+="<ul class='treeview-menu'>";
    $.each(menu, function (i, m) {
        if(m.childMenu&&m.childMenu.length>0){
            var k="";
            k=getChildMemu(k, m.childMenu);
            t+="<li><a href='#' value='" + m.menuUrl + "'>"+ m.menuName+"<i class='fa fa-angle-left pull-right'></i></a>"+k+"</li>";
        }else{
            t+="<li><a href='#' value='" + m.menuUrl + "'>"+ m.menuName+"</a><i class='fa fa-circle-o'></i></li>";
        }
    });
    t+="</ul>";
    return t;
}

function startInit(){
    var iframe = document.getElementById("iframepage");//这里括号内的"runtime"其实就是上面的ID，要改成自己上面填写的ID。
    if(iframe.Document){//ie自有属性
        iframe.style.height = iframe.Document.documentElement.scrollHeight;
    }else if(iframe.contentDocument){//ie,firefox,chrome,opera,safari
        iframe.height = iframe.contentDocument.body.offsetHeight ;
    }
}