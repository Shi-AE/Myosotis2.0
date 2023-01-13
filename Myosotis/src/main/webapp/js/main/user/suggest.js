$().ready(() => {

    /* 发送目标
    <option value="员工编号">员工姓名</option>
    */

    //一次性获取
    $("select").one("click",(e) => {
        $.ajax({
            url: "../../register/search/servlet.do",
            type: "GET",
            data: {
                name: "manager"
            },
            dataType: "JSON",
            success: (res) => {
                // console.log(res);
                if (res.skip) {
                    location.href = res.url;
                } else {
                    res.options.forEach((e) => {
                        $('select').append($(`<option>${e}</option>`));
                    })
                }
            }
        });
    });

    $("#submit").click(() => {
        $.ajax({
            url: "../../suggest/send/servlet.do",
            type: "POST",
            data: $("form").serialize(),
            success: (res) => {
                res = JSON.parse(res);
                if(res) {
                    window.alert("发送成功");
                } else {
                    window.alert("发送失败");
                }
            }
        });
    });

    /*  接收内容
        <div class="option">
            <div class="name">发送人：sender</div>
            <div class="content">内容：content</div>
            <button type="button" id="confirma" index="id" class="btn btn-success">确认接收</button>
        </div>
    */

    $.ajax({
        url: "../../suggest/get/servlet.do",
        type: "GET",
        dataType: "JSON",
        success: (res) => {
            // console.log(res);
            res.forEach((e) => {
                $(".recept").append($(`
                    <div class="option">
                        <div class="name">发送人：${e.sender}</div>
                        <div class="content">内容：${e.content}</div>
                        <button type="button" id="confirma" index="${e.id}" class="btn btn-success">确认接收</button>
                    </div>
                `));
            })
        }
    })

    $(".recept").click((e) => {
        if($(e.target).is($("button"))) {
            $.ajax({
                url: "../../suggest/delete/servlet.do",
                type: "POST",
                data: {
                    id: $(e.target).attr("index")
                },
                success: (res) => {
                    res = JSON.parse(res);
                    if(res) {
                        window.alert("接收成功");
                        $(e.target).parent().remove();
                    } else {
                        window.alert("接收失败");
                    }
                }
            });
        }
    });
})