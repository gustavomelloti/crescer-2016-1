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
        },
        error: function (request, status) {
            $('#erro-albuns').html('Caro usuário, devido a um erro ' + request.status + ', não foi possível pesquisar.');
        }
    }); 
};
