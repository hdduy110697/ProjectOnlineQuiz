
var pathArray = window.location.pathname.split('/');
$("#con-addmoney").click(function () {
    $.ajax({
        url: window.location.origin+"/adminezgame/addmoney",
        type: "post",
        contentType: 'application/json',
        data: JSON.stringify({
            "money": $("#add-money").val(),
            "username": $("#add-user").val()
        })
        ,
        success: function (event) {
                alert(event.error[0].error); 
        }
    });
});
var edit = $(".edit-rate");
for (var i = 0, max = edit.size(); i < max; i++) {
    $(edit[i]).click(function (){
        var id=$(this).attr("value");
        console.log(id);
        $("#edit-rate-id").attr("value",id)
        dialog =$("#dialog-form-edit-rate");
        dialog.dialog("open");
    })
};

$("#con-edit-rate").click(function () {
    var id=$("#edit-rate-id").attr("value");
    $.ajax({
        url: window.location.origin +"/adminezgame/editRate",
        type: "post",
        contentType: 'application/json',
        data: JSON.stringify({
            "id": id,
            "rateArc": $("#edit-rate-arc").val(),
            "rateTo": $("#edit-rate-to").val(),
            "rateLe": $("#edit-rate-le").val(),
            "rateDC": $("#edit-rate-dc").val(),
            "rateKhac": $("#edit-rate-khac").val()
        })
        ,
        success: function (event) {
                alert(event.error[0].error); 
        }
    });
});







