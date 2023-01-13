$().ready(() => {
    //检查cookie状态
    let check_cookie = () => {
        if($.cookie("info-privacy") == undefined) {
            $.cookie("info-privacy",false,{expires: 7,path: "/main/user"});
        }
        if($.cookie("info-privacy") == "true") {
            $("#info-privacy").prop("checked",true);
        } else if($.cookie("info-privacy") == "false") {
            $("#info-privacy").prop("checked",false);
        }
    }
    check_cookie();

    //根据开关状态调整设置状态
    $("#info-privacy").change(() => {
        if($("#info-privacy").prop("checked")) {
            $.cookie("info-privacy",true,{expires: 7,path: "/main/user"});
        } else {
            $.cookie("info-privacy",false,{expires: 7,path: "/main/user"});
        }
    })
});