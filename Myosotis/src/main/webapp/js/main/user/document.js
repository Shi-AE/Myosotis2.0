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
        let target = $("#target").val();
        let note = $("#note").val();
        let files = $("#file").prop("files");

        // console.log(files[0].sec);

        let data = new FormData();
        data.append("file", files[0]);
        data.append("target", target);
        data.append("note",note);

        // console.log(data.get("title"));

        // console.log(files[0]);

        $.ajax({
            url: "../../document/send/servlet.do",
            type: "POST",
            data: data,
            cache: false,
            processData: false,
            contentType: false,
            success: (res) => {
                $("#target").val("");
                $("#note").val("");
                res = JSON.parse(res);
                if(res) {
                    window.alert("发送成功");
                } else {
                    window.alert("发送失败");
                }
            }
        });
    });

    /*
        <div class="option">
            <div class="name">发送人：${e.sender}</div>
            <div class="name">文件名：${e.name}</div>
            <div class="note">文件备注：${e.note}</div>
            <button type="button" index="${e.id}" file-name="${e.name}" class="btn btn-success get">接收文件</button>
            <button type="button" index="${e.id}" class="btn btn-success delete">删除文件</button>
        </div>
    */

    $.ajax({
        url: "../../document/get/servlet.do",
        type: "GET",
        success: (res) => {
            res = JSON.parse(res);
            // console.log(res);
            res.forEach((e) => {
                $(".recept").append($(`
                    <div class="option">
                        <div class="name">发送人：${e.sender}</div>
                        <div class="name">文件名：${e.name}</div>
                        <div class="note">文件备注：${e.note}</div>
                        <button type="button" index="${e.id}" file-name="${e.name}" class="btn btn-success get">接收文件</button>
                        <button type="button" index="${e.id}" class="btn btn-success delete">删除文件</button>
                    </div>
                `))
            });
        }
    });

    /*  链接
        <a href="e.target.result" download="name"></a>
    */

    $(".recept").click((e) => {
        if($(e.target).is($(".get"))) {
            fetch(`../../document/download/servlet.do?id=${$(e.target).attr("index")}`,{
                method: 'get',
                responseType: 'arraybuffer'
            })
            .then(res=>{
                // console.log(res);
                return res.arrayBuffer();
            })
            .then((res) => {
                console.log(res);
                const blob = new Blob([res], {type: "arraybuffer"});
                const link = document.createElement('a');
                link.href = URL.createObjectURL(blob);
                link.download = $(e.target).attr("file-name");
                link.click();
                window.URL.revokeObjectURL(link.href);
            })
        }
    })

    $(".recept").click((e) => {
        if($(e.target).is($(".delete"))) {
            $.ajax({
                url: "../../document/delete/servlet.do",
                type: "POST",
                data: {id: $(e.target).attr("index")},
                success: (res) => {
                    res = JSON.parse(res);
                    if(res) {
                        window.alert("删除成功");
                        $(e.target).parent().remove();
                    } else {
                        window.alert("删除失败");
                    }
                }
            });
        }
    });

});