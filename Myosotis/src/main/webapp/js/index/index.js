$().ready(() => {
    async function reqest(e) {
        let target = e.data.target;
        let res;
        res = await $.ajax({
            url: `${target}/entry/servlet`,
            type: "POST",
            data: $(".active form").serialize(),
            success: (res) => {
                res = JSON.parse(res);
                if (res.skip) {
                    location.href = res.url;
                } else {
                    $(`#${target}-${res.error}`).addClass("is-invalid");
                    let err;
                    if(res.error == "account") {
                        err = $(`<div class="err">账号错误</div>`);
                        $("body").append(err);
                    } else {
                        err = $(`<div class="err">密码错误</div>`);
                        $("body").append(err);
                    }
                    setTimeout(() => {
                        $(err).remove();
                    }, 3000);
                }
            }
        })
    }

    // 消除提示
    $("input").focus((e) => {
        $(e.target).removeClass("is-invalid");
    });

    // 回车提交
    $(".tab-content").keyup((e) => {
        if(e.which == 13) {
            let inputs = $(".active input");
            if($(inputs[0]).val() && $(inputs[1]).val()) {
                $(".active button").trigger("click");
            }
        }
    })

    $("#user-submit").on("click", { target: "user" },reqest);
    $("#admin-submit").on("click", { target: "admin" },reqest);
})