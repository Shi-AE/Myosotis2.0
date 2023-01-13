$().ready(() => {

    $("#submit").click(() => {
        let title = $("#title").val();
        let content = $("#content").val();
        let files = $('#file').prop('files');

        let data = new FormData();
        data.append("file", files[0]);
        data.append("title", title);
        data.append("content",content);

        // console.log(data.get("title"));

        // console.log(files[0]);

        $.ajax({
            url: "../../announce/servlet.do",
            type: "POST",
            data: data,
            cache: false,
            processData: false,
            contentType: false,
            success: (res) => {
                $("#title").val("");
                $("#content").val("");
                res = JSON.parse(res);
                if(res) {
                    window.alert("添加成功");
                } else {
                    window.alert("添加失败");
                }
            }
        });
    })


    $(".delete").click((e) => {
        if($(e.target).is($("button"))) {
            let confirm = window.confirm("确认删除吗");
            if (confirm) {
                $.ajax({
                    url: "../../announce/delete/servlet.do",
                    type: "POST",
                    data: {
                        id: $(e.target).attr("index")
                    },
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
        }
    });

    /*
        <div class="option">
            <p>标题：</p>
            <p>title</p>
            <button type="button" class="btn btn-danger">删除</button>
        </div>
    */

    $("#delete").click(() => {
        $.ajax({
            url: "../../announce/get/servlet.do",
            type: "GET",
            success: (res) => {
                res = JSON.parse(res);
                $(".delete").empty();
                res.allAnnounce.forEach(function(e) {
                    $(".delete").append($(`
                    <div class="option">
                        <p>标题：</p>
                        <p>${e.title}</p>
                        <button type="button" index="${e.id}" class="btn btn-danger">删除</button>
                    </div>
                    `));
                });
            }
        })
    });
})