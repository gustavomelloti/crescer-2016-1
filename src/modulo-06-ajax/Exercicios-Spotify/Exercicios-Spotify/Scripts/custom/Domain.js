var aplicarRegraJustinBiber = function () {
    var numeroEntre1E10 = Math.random() * (10 - 1) + 1;

    return numeroEntre1E10 <= 8 ? 'douchebag' : 'Justin Bieber';
};

var adicionarImagensAlbuns = function (albuns) {
    limparDadosUltimaPesquisa();

    if (albuns.items == 0)
        $('#erro-albuns').html("Nenhum álbum encontrado.");

    albuns.items.forEach(function (element) {
        $('#albuns').append($('<li>').append($('<img>').attr('src', element.images[1].url)));
    });
}

var limparDadosUltimaPesquisa = function () {
    $("#albuns").html("");
    $('#erro-albuns').html("");
}