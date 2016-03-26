$(document).ready(function() {
    $('#loginForm').validate({

        focusInvalid: false, // do not focus the last invalid input
        rules: {
            loginId: {
                required: true
            },
            pwd: {
                required: true
            }
        },

        messages: {
            loginId: {
                required: "请填写登录帐号。"
            },
            pwd: {
                required: "请填写登录密码。"
            }
        },

        errorElement: "em",
        errorPlacement: function ( error, element ) {
            error.addClass( "help-block" );

            if ( element.prop( "type" ) === "checkbox" ) {
                error.insertAfter( element.parent( "label" ) );
            } else {
                error.insertAfter( element );
            }
        },
        highlight: function ( element, errorClass, validClass ) {
            $( element ).parents( ".form-group" ).addClass( "has-error" ).removeClass( "has-success" );
        },
        unhighlight: function (element, errorClass, validClass) {
            $( element ).parents( ".form-group" ).addClass( "has-success" ).removeClass( "has-error" );
        },

        submitHandler: function (form) {
            ajaxSubmit(form);
        }
    });




    $('#forgetForm').validate({
        errorElement: 'label', //default input error message container
        errorClass: 'help-inline', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        ignore: "",
        rules: {
            email: {
                required: true,
                email: true
            }
        },

        messages: {
            email: {
                required: "Email 是必填项。"
            }
        },

        invalidHandler: function (event, validator) { //display error alert on form submit

        },

        highlight: function (element) { // hightlight error inputs
            $(element)
                .closest('.control-group').addClass('error'); // set error class to the control group
        },

        success: function (label) {
            label.closest('.control-group').removeClass('error');
            label.remove();
        },

        errorPlacement: function (error, element) {
            error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
        },

        submitHandler: function (form) {

        }
    });
    $('#forget-password').on("click",function () {
        $('.login-form').hide();
        $('.forget-form').show();
    });

    $('#back-btn').on("click",function () {
        $('.login-form').show();
        $('.forget-form').hide();
    });

    $('#formSubmit').on("click",function(){
        $('#loginForm').submit();
    })
});


//将form转为AJAX提交
function ajaxSubmit(frm) {
    var dataPara = getFormJson(frm);
    com.ajax.jsonPost("/log/userLogin",dataPara,function(data){
        if(data.code==com.ajax.jsonResult.success){
            $.messager.popup("登录成功，正在跳转！");
            setTimeout(function(){
                window.location.href=com.appRootUrl+"/views/index.jsp";
            },3000);

        }else{
            $.messager.popup(data.message);
        }
    });
}

