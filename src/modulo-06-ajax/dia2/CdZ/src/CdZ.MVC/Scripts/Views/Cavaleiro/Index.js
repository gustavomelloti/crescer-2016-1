'use strict';

function adicionarCavaleiroNoHtml(cava)
{
    var $cavaleiros = $('#cavaleiros');

    $cavaleiros.append(
        $('<li>').attr('data-id-cavaleiro', cava.Id).append(cava.Nome)
    );
}

function buscarTodosCavaleiros()
{
    return $.ajax({ url: urlCavaleiroGet, type: 'GET' });
}

function carregarDadosNaPagina(fn) {
    buscarTodosCavaleiros().then(
        function onSuccess(res) {
            res.data.forEach(function (cava) {
                fn(cava);
            });
        },
        function onError(res) {
            console.error(':(');
            console.error(res);

            var criarSpanComErro = function (msg) {
                return $('<span>').text(msg).addClass('erro');
            };

            $('#feedback')
            .append(criarSpanComErro(res.status))
            .append($('<br>'))
            .append(criarSpanComErro(res.statusText));
        }
    )
    .always(function (res) {
        console.log('acabouuuuuuuu');
    });
};

carregarDadosNaPagina(adicionarCavaleiroNoHtml);

setInterval(function (fn) {
    buscarTodosCavaleiros().then(
        function onSuccess(res) {
            res.data.forEach(function (cava) {
                if ($('[data-id-cavaleiro=' + cava.Id + ']').length === 0)
                    adicionarCavaleiroNoHtml(cava);
            });
        }
    );
}, 3000);

function registrarEventoDoBotao() {
    $('#btnCriar').click(function () {

        $.ajax({
            url: urlCavaleiroPost,
            type: 'POST',
            data: {
                Nome: 'Xiru ' + new Date().getTime(),
                AlturaCm: 187,
                Signo: 7,
                TipoSanguineo: 1,
                DataNascimento: new Date(),
                Golpes: ['Cólera do Dragão', 'Cólera dos 100 dragões'],
                LocalNascimento: {
                    Texto: 'Beijing'
                },
                LocalTreinamento: {
                    Texto: '5 picos de rosan'
                },
                Imagens: [{
                    Url: 'http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg',
                    IsThumb: true
                }, {
                    Url: 'http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg',
                    IsThumb: false
                }]
            }
        });

    });
};

registrarEventoDoBotao();