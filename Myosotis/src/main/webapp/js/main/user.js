$().ready(() => {
    $(`
        <nav>
            <div class="btn-group-vertical">
                <a href="home.html" class="btn btn-outline-success nav-button" id="home">首页</a>
                <a href="announce.html" class="btn btn-outline-success nav-button" id="announce">公告</a>
                <a href="meeting.html" class="btn btn-outline-success nav-button" id="meeting">会议管理</a>
                <a href="document.html" class="btn btn-outline-success nav-button" id="document">文档管理</a>
                <a href="mail.html" class="btn btn-outline-success nav-button" id="mail">邮件管理</a>
                <a href="suggest.html" class="btn btn-outline-success nav-button" id="suggest">意见管理</a>
            </div>
    </nav>
    `).prependTo("main");
})