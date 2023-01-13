$().ready(() => {
    $(`
        <header class="shadow">
            <div class="log"></div>
            <nav>
                <div class="user">我的主页</div>
                <button type="button" class="btn btn-danger exit">退出系统</button>
            </nav>
        </header>
    `).prependTo("body");

    $(".user").click(() => {
        location.href = "info/my-info.html";
    });

    $(".log").click(() => {
        location.href = "";
    })

    //退出系统关闭session
    $("header .exit").click(() => {
        $.ajax({
            url: "../../exit/servlet.do",
            type: "GET",
            success: () => {
                location.href = "../../common/exit.html";
            }
        })
    })
})