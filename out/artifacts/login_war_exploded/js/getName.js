$.ajax({
    url: '/info',
    method: 'GET',
    dataType: 'json',
    success(ret) {
        console.log(ret);
        $('#username').html(ret.name);
    }
});