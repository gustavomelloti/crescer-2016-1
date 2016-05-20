$('#pesquisar-artista').click(function () {
    var nomeArtista = $('#artista-nome').val();
    
    if (nomeArtista === "Justin Bieber")
        nomeArtista = aplicarRegraJustinBiber();

    pesquisarAlbunsPorArtistaNome(nomeArtista, function (albuns) {
        adicionarImagensAlbuns(albuns);
    });
})