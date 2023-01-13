$().ready(() => {
    $(`
        <nav>
            <div class="btn-group-vertical">
                <a href="home.html" class="btn btn-outline-success nav-button" id="home">首页</a>
                <a href="announce.html" class="btn btn-outline-success nav-button" id="announce">公告管理</a>
                <a href="HRM.html" class="btn btn-outline-success nav-button" id="HRM">人力资源管理</a>
                <a href="property.html" class="btn btn-outline-success nav-button" id="property">资产管理</a>
            </div>
        </nav>
    `).prependTo("main");
})