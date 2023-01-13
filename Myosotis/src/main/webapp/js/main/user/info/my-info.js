$().ready(() => {
    $(`
        <nav>
            <div class="btn-group-vertical f">
                <button class="btn btn-outline-success nav-button left" id="set">设置</button>
                <ul class="btn-group-vertical none s">
                    <button class="btn btn-outline-success nav-button pilcrow" id="shield">屏蔽</button>
                    <button class="btn btn-outline-success nav-button pilcrow" id="privacy">隐私</button>
                    <button class="btn btn-outline-success nav-button pilcrow" id="preference">偏好设置</button>
                    <button class="btn btn-outline-success nav-button pilcrow" id="mail">邮件设置</button>
                </ul>
                <button class="btn btn-outline-success nav-button left" id="info">我的信息</button>
                <ul class="btn-group-vertical none s">
                    <button class="btn btn-outline-success nav-button pilcrow" id="safe">账号与密码安全</button>
                    <button class="btn btn-outline-success nav-button pilcrow" id="team">企业/组织/团队</button>
                    <button class="btn btn-outline-success nav-button pilcrow" id="friend">我的好友</button>
                </ul>
            </div>
        </nav>
    `).prependTo("main");

    $("#shield").click(() => {
        location.href = "shield.html";
    });

    $("#privacy").click(() => {
        location.href = "privacy.html";
    });

    $("#preference").click(() => {
        location.href = "preference.html";
    });

    $("#mail").click(() => {
        location.href = "mail.html";
    });

    $("#safe").click(() => {
        location.href = "safe.html";
    });

    $("#team").click(() => {
        location.href = "team.html";
    });

    $("#friend").click(() => {
        location.href = "friend.html";
    });
});