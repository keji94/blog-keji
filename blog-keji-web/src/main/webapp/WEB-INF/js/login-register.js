/*
 *
 * login-register modal
 * Autor: Creative Tim
 * Web-autor: creative.tim
 * Web script: #
 * 
 */
function showRegisterForm(){
    $('.loginBox').fadeOut('fast',function(){
        $('.registerBox').fadeIn('fast');
        $('.login-footer').fadeOut('fast',function(){
            $('.register-footer').fadeIn('fast');
        });
        $('.modal-title').html('Register with');
    }); 
    $('.error').removeClass('alert alert-danger').html('');
       
}
function showLoginForm(){
    $('#loginModal .registerBox').fadeOut('fast',function(){
        $('.loginBox').fadeIn('fast');
        $('.register-footer').fadeOut('fast',function(){
            $('.login-footer').fadeIn('fast');    
        });
        
        $('.modal-title').html('Login with');
    });       
     $('.error').removeClass('alert alert-danger').html(''); 
}

function openLoginModal(){
    showLoginForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}
function openRegisterModal(){
    showRegisterForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}

function loginAjax(email){
    var emailValue = $('#emailLogin')[0].value;
    var passwordValue = $('#passwordLogin')[0].value;
    $.post( "/user/login",{email:emailValue, password:passwordValue}, function( data ) {
            if(data == 1){
                window.location.replace("/home");            
            } else {
                 shakeModal(); 
            }
        });
     // shakeModal();
}

function shakeModal(tip){
    $('#loginModal .modal-dialog').addClass('shake');
         $('.error').addClass('alert alert-danger').html(tip);
         setTimeout( function(){
            $('#loginModal .modal-dialog').removeClass('shake');
         }, 1000 );
}

function checkResigter() {
    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-]+)+$/;
    var email = $('#email')[0].value;
    var length = $('#password')[0].value.length;
    var password = $('#password')[0].value;
    var passwordCon = $('#password_confirmation')[0].value;
    var nickLength = $('#nickname')[0].value.length;
    if (!reg.test(email)) {
        var tip = "请正确填写邮箱";
        shakeModal(tip);
        $('#email').val('');
    }else if (length <= 6) {
        var tip = "密码长度不能小于6位数";
        shakeModal(tip);
        $('#password').val('');
    }else if (passwordCon != password) {
        var tip = "两次输入的密码不一样";
        shakeModal(tip);
        $('#password_confirmation').val('');
    }else if(nickLength == 0) {
        var tip = '昵称不能为空';
        shakeModal(tip);
    }else if(nickLength >=8) {
        var tip = '昵称长度不能超过8';
        shakeModal(tip);
    }

    $.post("/user/register",{userName:email,userPassword:password,userNickname:$('#nickname')[0].value},function (data) {
        if(data.status == 200){
            bootoast({
                message: '注册成功!',
                type: 'info',
                position: 'bottom-center',
                icon: undefined,
                timeout: true,
                animationDuration: 400,
                dismissable: true
            });
            $('#loginModal').modal('hide');
        }
    });

}

   