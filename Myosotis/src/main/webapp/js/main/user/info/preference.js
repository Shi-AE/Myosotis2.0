$().ready(() => {
    //检查cookie状态
    let check_cookie = () => {
        if($.cookie("background-set") == undefined) {
            $.cookie("background-set",false,{expires: 7,path: "main/user"});
        }
        if($.cookie("shortcut-key") == undefined) {
            $.cookie("shortcut-key",false,{expires: 7,path: "main/user"});
        }
        if($.cookie("background-set") == "true") {
            $("#background-set").prop("checked",true);
        } else if($.cookie("background-set") == "false") {
            $("#background-set").prop("checked",false);
        }
        if($.cookie("shortcut-key") == "true") {
            $("#shortcut-key").prop("checked",true);
        } else if($.cookie("shortcut-key") == "false") {
            $("#shortcut-key").prop("checked",false);
        }
    }
    check_cookie();

    //根据开关状态调整设置状态
    $("#background-set").change(() => {
        if($("#background-set").prop("checked")) {
            $.cookie("background-set",true,{expires: 7,path: "main/user"});
        } else {
            $.cookie("background-set",false,{expires: 7,path: "main/user"});
        }
    })

    $("#shortcut-key").change(() => {
        if($("#shortcut-key").prop("checked")) {
            $.cookie("shortcut-key",true,{expires: 7,path: "main/user"});
        } else {
            $.cookie("shortcut-key",false,{expires: 7,path: "main/user"});
        }
    })
});