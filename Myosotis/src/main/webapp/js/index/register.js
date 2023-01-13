$().ready(() => {
    //表单提交
    async function reqest() {
        let res;
        res = await $.ajax({
            url: "../register/servlet",
            type: "POST",
            async: false,
            data: $("form").serialize(),
            success: (res) => {
                res = JSON.parse(res);
                if (res.skip) {
                    location.href = res.url;
                } else {
                    res.error.forEach(element => {
                        $(`#${element}`).addClass("is-invalid");
                    });
                }
            }
        })
    }

    // 消除提示
    $("input").focus((e) => {
        $(e.target).removeClass("is-invalid");
    });

    // 回车提交
    $("input").keyup((e) => {
        if (e.which == 13) {
            $("button").trigger("click");
        }
    })

    //绑定表单提交函数
    $(".form>button").on("click", reqest);

    // var tempIdStr = '<option  value="">选择</option>';
    // $('#manager').append(tempIdStr);
    // $('#manager').selectpicker('refresh');

    $.ajax({
        url: "../register/search/servlet",
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
                    $('#manager').append($(`<option>${e}</option>`));
                })
                $('#manager').selectpicker('refresh');
            }
        }
    });

    $.ajax({
        url: "../register/search/servlet",
        type: "GET",
        data: {
            name: "dept"
        },
        dataType: "JSON",
        success: (res) => {
            // console.log(res);
            if (res.skip) {
                location.href = res.url;
            } else {
                res.options.forEach((e) => {
                    $('#dept').append($(`<option>${e}</option>`));
                })
                $('#dept').selectpicker('refresh');
            }
        }
    });

})