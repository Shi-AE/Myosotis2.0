$().ready(() => {
    //获取公告内容
    /*
    公告模板
    <div class="carousel-item active">
        <img src="../../img/announce/a1.png" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
            <h5>二十大！！！</h5>
            <p>二十大新消息</p>
        </div>
    </div>
    滚动条
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    */

    $.ajax({
        url: "../../announce/get/servlet.do",
        type: "GET",
        success: (res) => {
            // console.log(res);
            res = JSON.parse(res);
            // console.log(res);
            res.allAnnounce.forEach(function(e,t) {
                // console.log(t,e.url,e.title,e.content);
                $(".carousel-inner").append($(`
                    <div class="carousel-item">
                        <img src="../../img/announce/${e.url}" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>${e.title}</h5>
                            <p>${e.content}</p>
                        </div>
                    </div>
                `));
                $(".carousel-indicators").append($(`
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="${t + 1}" aria-label="Slide ${t + 2}"></button>
                `));
            });
        }
    })
})