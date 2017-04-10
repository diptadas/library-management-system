$(document).ready(function(e) {
    $('.glyphicon-pencil').on('click', function() {
        $('.issue').modal();
        var id = $(this).data('id');
        var name = $(this).data('name');
        $('#test1').text(id);
        $('#test2').text(name);
    });
    $('#pro_sub').on('click', function() {
        var id2 = $('#test1').text();
        var std_id = $('#std_id').val();
        $.ajax({
            url: "IssueBookServlet",
            type: "POST",
            data: {
                "book_id": id2,
                "student_id": std_id
            },
            dataType: "text",
            success: function(data, status, xhr) {
                var response = xhr.getResponseHeader("success");
                $('.issue').modal('hide');
                $('#myModal').modal();
                $('#text').html(response);
            }
        });
    });
    $('#sub_ret').on('click', function() {
        var id3 = $('#ret_book_id').val();
        var std_id2 = $('#ret_std_id').val();
        $.ajax({
            url: "ReturnBookServlet",
            type: "POST",
            data: {
                "book_id": id3,
                "student_id": std_id2
            },
            dataType: "text",
            success: function(data, status, xhr) {
                var response = xhr.getResponseHeader("success");
                $('.return').modal('hide');
                $('#myModal').modal();
                $('#text').html(response);
            }
        });
    });
    $('#std_status_btn').on('click', function() {
        var id4 = $('#std_status_id').val();
        $.ajax({
            url: "StudentStatusServlet",
            type: "POST",
            data: {
                "student_id": id4
            },
            dataType: "json",
            success: function(response) {                
                $("#std_status_res").find("tr:gt(0)").remove();
                if (response.length != 0) {
                    var trHTML = '';
                    $.each(response, function(index, row) {
                        trHTML += '<tr><td>' + row.book_id + '</td><td>' + row.name + '</td><td>' + row.date_issue + '</td></tr>';
                    });
                    $('#std_status_res').html(trHTML);
                } else $('#std_status_res').html('No Data');
            }
        });
    });
    $('#book_status_btn').on('click', function() {
        var id5 = $('#book_status_id').val();
        $.ajax({
            url: "BookStatusServlet",
            type: "POST",
            data: {
                "book_id": id5
            },
            dataType: "json",
            success: function(response) {             
                $("#book_status_res").find("tr:gt(0)").remove();
                if (response.length != 0) {
                    var trHTML = '';
                    $.each(response, function(index, row) {
                        trHTML += '<tr><td>' + row.studentId + '</td><td>' + row.dateIssue + '</td></tr>';
                    });
                    $('#book_status_res').html(trHTML);
                } else $('#book_status_res').html('No Data');
            }
        });
    });
    $('#editSubBtn').on('click', function() {
        var name = $('#lib_name').val();
        var email = $('#email').val();
        var pass = $('#password').val();
        $.ajax({
            url: "UpdateLibrarianServlet",
            type: "POST",
            data: {
                "lib_name": name,
                "email": email,
                "password": pass
            },
            dataType: "text",
            success: function(data, status, xhr) {
                var response = xhr.getResponseHeader("success");
                $('.edit').modal('hide');
                $('#myModal').modal();
                $('#text').html(response);
                setTimeout(function() {
                    location.reload();
                }, 1000);
            }
        });
    });
});