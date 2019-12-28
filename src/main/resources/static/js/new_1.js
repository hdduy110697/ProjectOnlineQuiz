
$(function () {
    var dialog;
    dialog = $("#dialog-form-login").dialog({
        autoOpen: false,
        height: "400",
        width: "350",
        modal: true,
        buttons: {
            Đóng: function () {
                dialog.dialog("close");
            }
        },
        close: function () {
        }
    });
    $("#form-login1").click(function () {
        dialog.dialog("open");
    });
    $("#form-login2").click(function () {
        dialogReg = $("#dialog-form-reg");
        dialogReg.dialog("close");
        dialog.dialog("open");
        
        
    });
});

$(function () {
    var dialog;
    dialog = $("#dialog-form-reg").dialog({
        autoOpen: false,
        height: "460",
        width: "350",
        modal: true,
        buttons: {
            Đóng: function () {
                dialog.dialog("close");
            }
        },
        close: function () {
        }
    });
    $("#form-reg1").on("click",function () {
        dialog.dialog("open");
    });
    $("#form-reg2").on("click",function () {
        dialogLogin = $("#dialog-form-login");
        dialogLogin.dialog("close");
        dialog.dialog("open");
    });
});

$(function () {
    var dialog;
    dialog = $("#dialog-form-reset-password").dialog({
        autoOpen: false,
        height: "400",
        width: "350",
        modal: true,
        buttons: {
            Đóng: function () {
                dialog.dialog("close");
            }
        },
        close: function () {
        }
    });
    $("#form-reset-pass").on("click",function () {
        dialogLogin = $("#dialog-form-login");
        dialogLogin.dialog("close");
        dialog.dialog("open");
    });
});
$(function () {
    var dialog;
    dialog = $("#dialog-form-add-money").dialog({
        autoOpen: false,
        height: "350",
        width: "350",
        modal: true,
        buttons: {
            Huỷ: function () {
                dialog.dialog("close");
            }
        },
        close: function () {
        }
    });
    $("#form-addmoney").on("click",function () {
        dialog.dialog("open");
    });
});
$(function () {
    var dialog;
    dialog = $("#dialog-form-change-password").dialog({
        autoOpen: false,
        height: "350",
        width: "350",
        modal: true,
        buttons: {
            Đóng: function () {
                dialog.dialog("close");
            }
        },
        close: function () {
        }
    });
    $("#form-change-password").on("click",function () {
        dialog.dialog("open");
    });
});
$(function () {
    var dialog;
    dialog = $("#dialog-form-change-steamid").dialog({
        autoOpen: false,
        height: "330",
        width: "350",
        modal: true,
        buttons: {
            Huỷ: function () {
                dialog.dialog("close");
            }
        },
        close: function () {
        }
    });
    $("#form-change-steamid").on("click",function () {
        dialog.dialog("open");
    });
});

$(function () {
    var dialog;
    dialog = $("#dialog-info-ck").dialog({
        autoOpen: false,
        height: 'auto',
        width: 'auto',
        modal: true,
        buttons: {
            Đóng: function () {
                dialog.dialog("close");
            }
        },
        close: function () {
            clearInterval(interval_obj);
        }
    });
});
$(function () {
    var dialog;
    dialog = $("#dialog-error-gift").dialog({
        autoOpen: false,
        height: 'auto',
        width: 'auto',
        modal: true,
        buttons: {
            Đóng: function () {
                dialog.dialog("close");
            }
        },
        close: function () {
             window.location.replace(window.location);
        }
    });
});
$(function () {
    var dialog;
    dialog = $("#dialog-form-edit-rate").dialog({
        autoOpen: false,
        height: 'auto',
        width: 'auto',
        modal: true,
        buttons: {
            Đóng: function () {
                dialog.dialog("close");
            }
        },
        close: function () {
             
        }
    });
});


