$().ready(() => {

    /*  删除选项模板
        <div class="option">
            <div class="title">title</div>
            <div class="start-time">start-time</div>
            <div class="end-time">end-time</div>
            <button type="button" index="1" class="btn btn-danger">删除此日程</button>
        </div>
    */

    queryMeeting = () => {
        $.ajax({
            url: "../../meeting/get/servlet.do",
            type: "GET",
            success: (res) => {
                // console.log(res);
                res = JSON.parse(res);
                // console.log(res);
                $(".delete").empty();
                for (let index = 0; index < res.length; index++) {
                    $(".delete").append(`
                        <div class="option">
                            <div class="title">${res[index].title}</div>
                            <div class="start-time">${new Date(res[index].startTime).toLocaleString()}</div>
                            <div class="end-time">${res[index].endTime}</div>
                            <button type="button" index="${res[index].id}" class="btn btn-danger">删除此日程</button>
                        </div>
                    `);
                }
            }
        })
    };

    queryMeeting();

    $("#delete").click(() => {
        queryMeeting();
    })

    $("#submit").click(() => {
        $.ajax({
            url: "../../meeting/add/servlet",
            type: "POST",
            data: $("form").serialize(),
            success: (res) => {
                res = JSON.parse(res);
                if(res) {
                    window.alert("添加成功");
                    queryMeeting();
                } else {
                    window.alert("添加失败");
                }
            }
        });
    });

    $(".delete").click((e) => {
        if($(e.target).is($("button"))) {
            let confirm = window.confirm("确认删除吗");
            if (confirm) {
                $.ajax({
                    url: "../../meeting/delete/servlet",
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

})
