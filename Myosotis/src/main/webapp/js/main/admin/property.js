$().ready(() => {

    /*
        <div class="option">
            <div>item</div>
            <div>number</div>
            <div class="mb-3">
                <input type="text" class="form-control" name="number"></input>
            </div>
            <button type="button" index="id" class="btn btn-success updete">更新数量</button>
            <button type="button" index="id" class="btn btn-danger delete">删除项目</button>
        </div>
    */

    const get = () =>{
        $.ajax({
            url: "../../property/get/servlet.do",
            type: "GET",
            dataType: "JSON",
            success: (res) => {
                res.forEach((e) => {
                    $(".manager").append($(`
                        <div class="option">
                            <div>${e.item}</div>
                            <div>${e.number}</div>
                            <div class="mb-3">
                                <input type="text" class="form-control" name="number"></input>
                            </div>
                            <button type="button" index="${e.id}" class="btn btn-success updete">更新数量</button>
                            <button type="button" index="${e.id}" class="btn btn-danger delete">删除项目</button>
                        </div>
                    `))
                });
            }
        });
    }

    get();

    $("#add").click(() => {
        $.ajax({
            url: "../../property/add/servlet.do",
            type: "POST",
            data: $("form").serialize(),
            success: (res) => {
                res = JSON.parse(res);
                if(res) {
                    window.alert("添加成功");
                    $(".manager").empty();
                    get();
                } else {
                    window.alert("添加失败");
                }
            }
        });
    });

    $(".manager").click((e) => {
        if ($(e.target).is($(".updete"))) {
            $.ajax({
                url: "../../property/update/servlet.do",
                type: "POST",
                data: {
                    id: $(e.target).attr("index"),
                    number: $(e.target).parent().find("input").val()
                },
                success: (res) => {
                    res = JSON.parse(res);
                    if(res) {
                        window.alert("更改成功");
                        $(".manager").empty();
                        get();
                    } else {
                        window.alert("更改失败");
                    }
                }
            });
        } else if($(e.target).is($(".delete"))) {
            $.ajax({
                url: "../../property/delete/servlet.do",
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
    });
    
})