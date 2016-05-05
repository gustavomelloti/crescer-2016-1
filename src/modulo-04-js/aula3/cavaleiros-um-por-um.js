$(document).ready(function(){
    for (var i in goldSaints)
        exibirCavaleiros(i);
    
    function exibirCavaleiros(index) {
        setTimeout(function() {
            $div = $('<div>').append($('<img>').attr('src', goldSaints[index].imagens[0].url));
            $(".cavaleiros").append($div.append($div));
        }, 1000*index);
    }
});
