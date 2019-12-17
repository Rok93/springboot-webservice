var index = {
    init: function () {
        var _this = this;

        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () { // 1. 'btn-update' id를 가진 HTML 엘리먼트에 click 이벤트가 발생할 때 update function을 실행하도록 이벤트 등록
            _this.update();
        })
    },
    save: function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';  //글 등록이 성공하면 메인페이지(/)로 이동합니다.
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update: function () { // 2. 신규로 추가될 update function 이다.
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val()

        $.ajax({
            type: 'PUT', // 3. 여러 HTTP Method 중 PUT 메소드를 선택한다. (Controller에 있는 Api에서 이미 @PutMapping으로 선언했기 때문에 PUT을 사용해야 한다)
            url: '/api/v1/posts/' + id, // 4. 어느 게시글을 수정할지 URL Path로 구분하기 위해 Path에 id를 추가한다.
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.')
            window.location.href = '/';
        }).fail(function () {
            alert(JSON.stringify(data))
        });

    }

};

index.init();