$().ready(() => {

    // 创建节点
    let background = $(`
        <div class="bear"></div>
        <div class="mountain1"></div>
        <div class="mountain2"></div>
        <div class="mountain3"></div>
    `)

    let light = () => {
        $("main .work").css({
            color: "#000000"
        });
        $("body").css({
            backgroundColor: "#ffffff"
        });
    }

    let dark = () => {
        $("main .work").css({
            color: "#ffffff"
        });
        $("body").css({
            backgroundColor: "#2B2929"
        });
    }

    //检查cookie状态
    let check_cookie = () => {
        if($.cookie("background") == undefined) {
            $.cookie("background",true,{expires: 7});
        }
        if($.cookie("background") == "true") {
            background.appendTo("body");
            $("#background-switch").prop("checked",true);
            dark();
        } else if($.cookie("background") == "false") {
            $("#background-switch").prop("checked",false);
            light();
        }
    }

    check_cookie();

    //根据开关状态调整背景
    $("#background-switch").change(() => {
        if($("#background-switch").prop("checked")) {
            background.appendTo("body");
            dark();
            $.cookie("background",true,{expires: 7});
        } else {
            background.remove();
            light();
            $.cookie("background",false,{expires: 7});
        }
    })

    /*  会议
        <a href="meeting.html" class="option">
            <div class="title">会议标题：title</div>
            <div class="start-time">会议开始时间：start-time</div>
            <div class="end-time">会议结束时间：end-time</div>
        </a>
    */

    $.ajax({
        url: "../../meeting/get/servlet.do",
        type: "GET",
        success: (res) => {
            // console.log(res);
            res = JSON.parse(res);
            // console.log(res);
            for (let index = 0; index < res.length; index++) {
                $(".meeting").append(`
                    <a href="meeting.html" class="option">
                        <div class="title">会议标题：${res[index].title}</div>
                        <div class="start-time">会议开始时间：${new Date(res[index].startTime).toLocaleString()}</div>
                        <div class="end-time">会议结束时间：${res[index].endTime}</div>
                    </a>
                `);
            }
        }
    })

    /*  邮件
        <a href="mail.html" class="option">
            <div class="name">发送人：sender</div>
        </a>
    */

    $.ajax({
        url: "../../suggest/get/servlet.do",
        type: "GET",
        dataType: "JSON",
        success: (res) => {
            // console.log(res);
            res.forEach((e) => {
                $(".mail").append($(`
                    <a href="mail.html" class="option">
                        <div class="name">发送人：${e.sender}sender</div>
                    </a>
                `));
            })
        }
    })

    /*  文档
        <a href="document.html" class="option">
            <div class="name">发送人：${e.sender}</div>
            <div class="name">文件名：${e.name}</div>
        </a>
    */

    $.ajax({
        url: "../../document/get/servlet.do",
        type: "GET",
        success: (res) => {
            res = JSON.parse(res);
            // console.log(res);
            res.forEach((e) => {
                $(".document").append($(`
                    <a href="document.html" class="option">
                        <div class="name">发送人：${e.sender}</div>
                        <div class="name">文件名：${e.name}</div>
                    </a>
                `))
            });
        }
    });

    /*  建议
        <a href="suggest.html" class="option">
            <div class="name">发送人：sender</div>
        </a>
    */

    $.ajax({
        url: "../../suggest/get/servlet.do",
        type: "GET",
        dataType: "JSON",
        success: (res) => {
            // console.log(res);
            res.forEach((e) => {
                $(".suggest").append($(`
                    <a href="suggest.html" class="option">
                        <div class="name">发送人：${e.sender}sender</div>
                    </a>
                `));
            })
        }
    })
})