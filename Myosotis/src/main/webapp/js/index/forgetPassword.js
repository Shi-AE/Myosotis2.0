$().ready(() => {
    /*
        <h2>编号：1</h2>
        <h2>联系方式：13738377227</h2>
    */


    $.ajax({
        url: "../get/contact/servlet",
        type: "GET",
        dataType: "JSON",
        success: (res) => {
            console.log(res);
            res.forEach((e) => {
                $("body").append($(`
                    <h2>编号：${e.id}</h2>
                    <h2>联系方式：${e.contact}</h2>
                `))
            });
        }
    });
})