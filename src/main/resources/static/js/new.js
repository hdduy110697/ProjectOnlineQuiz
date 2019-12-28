/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var s = 0.0;
var vnd = 0;
var s5 = 0.0;
var rate = $('#rate').attr("value");
var rateArc = $('#rateArc').attr("value");
var rateDC = $('#rateDC').attr("value");
var rateTo = $('#rateTo').attr("value");
var rateLe = $('#rateLe').attr("value");
var rateOther = $('#rateOther').attr("value");
var checkrate = 0;
var interval_obj;
var pathArray = window.location.pathname.split('/');
function formatNumber(nStr, decSeperate, groupSeperate) {
    nStr += '';
    x = nStr.split(decSeperate);
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + groupSeperate + '$2');
    }
    return x1 + x2;
}
;


function getItem() {
    var item = $('#itemGift > .item_box');
    var listIdItem = '';
    var listNameItem = '';
    for (var i = 0, max = item.length; i < max; i++) {
        var id = item[i].id + ",";
        var name = item[i].getAttribute("name") + ",";
        listIdItem = listIdItem + id;
        listNameItem = listNameItem + name;
    }
    $("#idItem").attr("value", listIdItem);
    $("#nameItem").attr("value", listNameItem);
}
;

var dem = 1;
$(".item_box").click(function gift() {
    var obj = this;
    var check = $(obj).attr('check');
    var value = $(obj).attr("value");
    var name = $(obj).attr("name");
    var rarity = $(obj).attr("rarity");
    var x;
    if (check == 1) {
        var f = $(obj).attr("value");
        $(obj).attr('check', '0');
        $('.bagList').append(obj);
        if (name == "Dragonclaw Hook" || name == "Inscribed Dragonclaw Hook") {
            var temp = (value * rateDC) / rate;
            temp = Math.round(temp * 100.0) / 100.0;
            x = temp;

        } else if (rarity == "arcana") {
            var temp = (value * rateArc) / rate;
            temp = Math.round(temp * 100.0) / 100.0;
            x = temp;

        } else if (value < 16) {
            var temp = (value * rateLe) / rate;
            temp = Math.round(temp * 100.0) / 100.0;
            x = temp;

        } else if (value > 100) {
            var temp = (value * rateTo) / rate;

            temp = Math.round(temp * 100.0) / 100.0;
            x = temp;

        } else {
            var temp = (value * rateOther) / rate;
            temp = Math.round(temp * 100.0) / 100.0;
            x = temp;

        }
        s = Number(s) - Number(f);
        dem = dem - 1;
        s5 = Number(s5) - Number(x);
        getItem();

        console.log(s5);
    }
    if (dem > 50) {
        alert("Max Item được chọn");
    } else if (check == 0) {
        $(obj).attr('check', '1');
        $('#itemGift').append(obj);
        var f = $(obj).attr("value");
        if (name == "Dragonclaw Hook" || name == "Inscribed Dragonclaw Hook") {
            var temp = (value * rateDC) / rate;
            temp = Math.round(temp * 100.0) / 100.0;
            x = temp;
        } else if (rarity == "arcana") {
            var temp = (value * rateArc) / rate;
            console.log(temp);
            temp = Math.round(temp * 100.0) / 100.0;
            console.log(temp);
            x = temp;
        } else if (value < 16) {
            var temp = (value * rateLe) / rate;
            console.log(temp);
            temp = Math.round(temp * 100.0) / 100.0;
            console.log(temp);
            x = temp;
        } else if (value > 100) {

            var temp = (value * rateTo) / rate;
            console.log(temp);
            temp = Math.round(temp * 100.0) / 100.0;
            console.log(temp);
            x = temp;
        } else {
            var temp = (value * rateOther) / rate;
            console.log(temp);
            temp = Math.round(temp * 100.0) / 100.0;
            console.log(temp);
            x = temp;
        }
        getItem();
        s = Number(s) + Number(f);
        dem = dem + 1;
        s5 = Number(s5) + Number(x);
    }
    s5 = Math.round(s5 * 100.0) / 100.0;
    ;
    s = s.toFixed(2);
    $("#total").html(s);
    $("#value").attr("value", s);
    var price = s5 * rate;
    price = price / 1000;
    vnd = Math.ceil(price);
    vnd = vnd * 1000;
    $('#money').attr("value", vnd);
    vnd = formatNumber(vnd, '.', ',');
    $('#price').html(vnd);

});
function getInfoInvoice() {
    $.ajax({
        url: window.location.origin+ "/api/v1/invoice/info",
        type: "get",
        data: {
        }
        ,
        success: function (event) {
            if (event.status === "Đang đợi") {
                $("#status-check").text("Đang đợi chuyển khoản");
                $("#loader").attr("style", "");
            } else if (event.status === "Thành công") {
                $("#loader").attr("style", "display: none");
                $("#status-check").text("Thành công");
                $("#status-check").attr("class", "alert alert-success");

            } else {
                $("#loader").attr("style", "display: none");
                $("#status-check").text("Thất bại do quá thời gian chuyển khoản, hoặc sms đang bị lag");
                $("#status-check").attr("class", "alert alert-danger");
            }

        }
    })
}
;
function getName() {
    var id = $('#friendSteamId').attr("value");
    $.ajax({
        url: window.location.origin + '/api/v1/getuser/' + id,
        type: 'get',
        success: function (result) {
            $('#friendNickname').attr('value', result.nickname);
            $('#friendSteamId').attr('value', result.steamId);
        }});
}
;
$(document).ready(function () {
    $('#friendSteamId').blur(function (event) {
        var id = $('#friendSteamId').val();
        $.ajax({
            url: window.location.origin + '/api/v1/getuser/' + id,
            type: 'get',
            success: function (result) {
                if (result.flag) {
                    $('#friendNickname').val(result.nickname);
                    $('#friendSteamId').attr('value', result.steamId);
                    $('#friendSteamId').val(result.steamId);
                } else {
                    $('#friendNickname').attr('value', "");
                    $('#friendSteamId').attr('value', "");
                }
            }});
    });
});
$("#con-reg").click(function () {
    $("#userNameError").text("");
    $("#passwordError").text("");
    $("#passwordConfirmError").text("");
    $("#emailError").text("");
    $("#idSteamError").text("");
    $.ajax({
        url:window.location.origin + "/registration",
        type: "post",
        contentType: 'application/json',
        data: JSON.stringify(
                {
                    "userName": $("#userName").val(),
                    "password": $("#password").val(),
                    "passwordConfirm": $("#passwordConfirm").val(),
                    "email": $("#email").val(),
                    "idSteam": $("#idSteam").val(),
                })
        ,
        success: function (data) {

            if (data.status == 400) {
                for (var i = 0, max = data.error.length; i < max; i++) {
                    var select = "#" + data.error[i].field + "Error";
                    $(select).text(data.error[i].error);
                    $(select).attr("style", "")
                }

            } else {
                alert("Đăng kí thành công quý khách vui lòng kiểm tra email để kích hoạt tài khoản");
                dialog = $("#dialog-form-reg");
                dialog.dialog("close");
            }
        }
    });
});

$("#con-reset-password").click(function () {
    $.ajax({
        url: window.location.origin+ "/resetPassword",
        type: "get",
        data: {
            email: $("#emailResetPass").val(),
        }
        ,
        success: function (event) {
            if (event.status == 200) {
                alert("Quý khách vui lòng kiểm tra email để đặt lại mật khẩu");
                dialog = $("#dialog-form-reset-password");
                dialog.dialog("close");
            } else {
                alert("Mail không tồn tại trong hệ thống");
            }

        }
    });
});
$("#con-addmoney").click(function () {
    $.ajax({
        url: window.location.origin + "/user/addmoney",
        type: "post",
        contentType: 'application/json',
        data: JSON.stringify({
            "money": $("#add-money").val(),
            "method": $("#add-method").val()
        })
        ,
        success: function (event) {
            if (event.status == 400) {
                for (var i = 0, max = event.error.length; i < max; i++) {
                    var select = "#add" + event.error[i].field + "Error";
                    $(select).text(event.error[i].error);
                }
            } else {
                $("#dialog-form-add-money").dialog("close");
                for (var i = 0, max = event.error.length; i < max; i++) {
                    var select = "#" + event.error[i].field + "-info-add";
                    $(select).text(event.error[i].error);
                }
                getInfoInvoice();
                interval_obj = setInterval(function () {
                    getInfoInvoice();
                }, 5000);
                $("#dialog-info-ck").dialog("open");
            }
        }
    });
});
$("#con-change-password").click(function () {

    $.ajax({
        url: window.location.origin + "/user/changePassword",
        type: "post",
        contentType: 'application/json',
        data: JSON.stringify({
            "oddPassword": $("#oddPassword").val(),
            "newPassword": $("#newPassword").val(),
            "newPasswordConfirm": $("#newPasswordConfirm").val()
        })
        ,
        success: function (event) {
            if (event.status == 400) {
                for (var i = 0, max = event.error.length; i < max; i++) {
                    var select = "#" + event.error[i].field + "Error";
                    $(select).text(event.error[i].error);
                }
            } else {
                alert("Đổi mật khẩu thành công");
                dialog = $("#dialog-form-change-password");
                dialog.dialog("close");
            }
        }
    });
});
$("#con-change-steamid").click(function () {
    $("#newSteamIdError").text("");
    $("#passwordChangeSteamError").text("");
    $.ajax({
        url: window.location.origin + "/user/changeSteamId",
        type: "post",
        contentType: 'application/json',
        data: JSON.stringify({
            "newSteamId": $("#newSteamId").val(),
            "password": $("#passwordChangeSteam").val(),
        })
        ,
        success: function (event) {
            if (event.status == 400) {
                for (var i = 0, max = event.error.length; i < max; i++) {
                    var select = "#" + event.error[i].field + "Error";
                    $(select).text(event.error[i].error);
                    $(select).attr("style", "");
                }
            } else {
                alert("Đổi steamID thành công");
                dialog = $("#dialog-form-change-steamid");
                dialog.dialog("close");
            }

        }
    });
});
$("#con-gift").click(function () {
    var value = $("#value").attr("value");
    var money = $("#money").attr("value");
    var nameItem = $("#nameItem").attr("value");
    var idItem = $("#idItem").attr("value");
    var action = $("#action").attr("value");
    $.ajax({
        url: window.location.origin + "/gift",
        type: "post",
        contentType: 'application/json',
        data: JSON.stringify({
            "steamID": $("#friendSteamId").val(),
            "nickname": $("#friendNickname").val(),
            "value": value,
            "money": money,
            "method": $("#method").val(),
            "nameItem": nameItem,
            "idItem": idItem,
            "action": action

        })
        ,
        success: function (event) {
            if (event.status == 400) {
                for (var i = 0, max = event.error.length; i < max; i++) {
                    var select = "#" + event.error[i].field + "-error-gift";
                    $(select).text(event.error[i].error);
                    $(select).attr("style", "");
                }
                $("#dialog-error-gift").dialog("open");
            } else if (event.status == 301) {
                alert("Gift Thành Công");
                window.location.replace(window.location);
            } else {
                for (var i = 0, max = event.error.length; i < max; i++) {
                    var select = "#" + event.error[i].field + "-info-add";
                    $(select).text(event.error[i].error);
                }
                getInfoInvoice();
                interval_obj = setInterval(function () {
                    getInfoInvoice();
                }, 5000);
                $("#dialog-info-ck").dialog("open");
            }
        }
    });
});






