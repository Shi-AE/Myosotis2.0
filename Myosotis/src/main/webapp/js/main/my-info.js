$().ready(() => {

    $(`
        <header class="shadow">
            <div class="log"></div>
            <nav>
                <div class="home">返回</div>
                <button type="button" class="btn btn-danger exit">退出系统</button>
            </nav>
        </header>
    `).prependTo("body");

    $.each($("nav > .f > button"),(index,e) => {
        $(e).click(() => {
            if($(e).hasClass("left")) {
                $(e).removeClass("left");
                $(e).addClass("down");
            } else if($(e).hasClass("down")) {
                $(e).removeClass("down");
                $(e).addClass("left");
            }
            if($(e).next().hasClass("none")) {
                $(e).next().removeClass("none");
                $(e).next().addClass("appear-action");
            } else {
                $(e).next().addClass("none");
                $(e).next().removeClass("appear-action");
            }
        });
    });

    $(".home").click(() => {
        location.href = "../home.html";
    });

    $(".log").click(() => {
        location.href = "";
    });

    //退出系统关闭session
    $("header .exit").click(() => {
        $.ajax({
            url: "../../../exit/servlet.do",
            type: "GET",
            success: () => {
                location.href = "../../../common/exit.html";
            }
        })
    })
});