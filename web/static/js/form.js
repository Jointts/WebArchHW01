/**
 * Created by pagulane on 28.03.16.
 */

function showForm(id){
    $.getJSON( "poetryservice", { 'id':id }, function( data ) {
        var response = "<h1>" + data.title + "</h1><p>" + data.content + "</p><p>" + data.year + "</p><input type='button' value='Close' onclick='closeForm()'>";
        $( ".poetryDetail" ).html( response );
    });
}

function closeForm(){
    $( ".poetryDetail" ).html( "" );
}
