/**
 * Created by skale on 12/26/15.
 */
$(document).ready(function () {

    $('.editBtn').click(function () {

        var currentTD = $(this).parents('tr').find('td');

        if ($(this).html() == 'Edit') {
            $.each(currentTD, function () {
                $(this).prop('contenteditable', true)
            });
        } else {
            $.each(currentTD, function () {
                $(this).prop('contenteditable', false)

            });
        }

        $(this).html($(this).html() == 'Edit' ? 'Save' : 'Edit')

    });

});