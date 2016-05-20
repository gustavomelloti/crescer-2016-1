var pesquisarAlbunsPorArtistaId = function (idArtista, fn) {
    $.ajax({
        url: 'https://api.spotify.com/v1/artists/'+idArtista+'/albums?limit=50',
        success: function (result) {
            fn(result);
        }
    });
};

var pesquisarAlbunsPorArtistaNome = function (nomeArtista, fn) {
    $.ajax({
        url: 'https://api.spotify.com/v1/search',
        data: {
            q: nomeArtista,
            type: 'album'
        },
        success: function (result) {
            fn(result.albums);
        }
    });
};

var adicionarImagensAlbuns = function (albuns) {
    $("#albuns").html("");

    albuns.items.forEach(function (element) {
        $('#albuns').append($('<li>').append($('<img>').attr('src', element.images[1].url)));
    });
}