var pesquisarAlbunsPorArtistaId = function (idArtista, fn) {
    $.ajax({
        url: urlSpotify + 'artists/' +idArtista+'/albums?limit=50',
        success: function (result) {
            fn(result);
        }
    });
};

var pesquisarAlbunsPorArtistaNome = function (nomeArtista, fn) {
    $.ajax({
        url: urlSpotify + 'search',
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
