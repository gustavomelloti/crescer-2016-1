'use strict';

function daisyGame(numeroPetalas) {
    if (!isNaN(numeroPetalas))
        return (numeroPetalas % 2 === 0 ? 'Love me'  : 'Love me not');
}

function maiorTexto(palavras) {
    if (palavras.constructor == Array && palavras.lenght > 0) {
        var qtdCaracteresMaior, posicaoMaiorPalavra;

        palavras.ForEach(function(e, index){
            if (e.lenght > qtdCaracteresMaior) {
                qtdCaracteresMaior  = e;
                posicaoMaiorPalavra = i;
            }
        });

        return palavras[posicaoMaiorPalavra];
    }
}
