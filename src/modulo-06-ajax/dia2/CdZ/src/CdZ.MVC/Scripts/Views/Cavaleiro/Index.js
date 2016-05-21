'use strict';

function deletarCavaleiro () {
    var idCavaleiro = $(this).attr('data-id-cavaleiro');
    
    $.ajax({
        url: urlCavaleiroDelete,
        data: { idCavaleiro: idCavaleiro },
        type: 'DELETE',
        success: function (response) {
            $('[data-id-cavaleiro=' + idCavaleiro + ']').remove();
        },
        error: function () {
            alert('erro ao deletar');
        }
    });
};

function adicionarCavaleiroNoHtml(cava)
{
    var $cavaleiros = $('#cavaleiros'),
        li = $('<li>').attr('data-id-cavaleiro', cava.Id);
            li.append($('<img>').attr('src', buscarImagemCavaleiro(cava)));
            li.append($('<span>').html('Deletar').addClass('icon-deletar'));
        
            li.click(deletarCavaleiro)

    $cavaleiros.append(li);
}

function buscarImagemCavaleiro(cava)
{
    var imagemThumb = cava.Imagens.filter(function (c) {
        return c.IsThumb;
    })[0];

    return imagemThumb != undefined ? imagemThumb.Url : 'https://cdn0.iconfinder.com/data/icons/social-flat-rounded-rects/512/anonymous-128.png';
}

function buscarTodosCavaleiros()
{
    return $.ajax({ url: urlCavaleiroGet, type: 'GET' });
}

function carregarDadosNaPagina(fn) {
    buscarTodosCavaleiros().then(
        function onSuccess(res) {
            console.log(res);
            res.data.forEach(function (cava) {
                fn(cava);
            });
        },
        function onError(res) {
            var criarSpanComErro = function (msg) {
                return $('<span>').text(msg).addClass('erro');
            };

            $('#feedback')
                .append(criarSpanComErro(res.status))
                .append($('<br>'))
                .append(criarSpanComErro(res.statusText));
        }
    )
};

carregarDadosNaPagina(adicionarCavaleiroNoHtml);

setInterval(function (fn) {
    buscarTodosCavaleiros().then(
        function onSuccess(res) {
            var qtd = 0;

            res.data.forEach(function (cava) {
                if ($('[data-id-cavaleiro=' + cava.Id + ']').length === 0) {
                    adicionarCavaleiroNoHtml(cava);
                    qtd++;
                }
            });

            if (qtd > 0)
                notificarNovosCavaleiros(qtd);
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