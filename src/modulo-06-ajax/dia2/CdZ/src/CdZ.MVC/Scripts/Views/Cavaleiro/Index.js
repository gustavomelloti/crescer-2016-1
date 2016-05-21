'use strict';

function deletarCavaleiro () {
    $('.icon-deletar').click(function () {
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
    });
};

function adicionarCavaleiroNoHtml(cava)
{
    var $cavaleiros = $('#cavaleiros'),
        li = $('<li>').attr('data-id-cavaleiro', cava.Id);
            li.append(($('<img>').attr('src', buscarImagemCavaleiro(cava))).click(abrirModalDetalhesCavaleiro));
            li.append($('<span>').html($('<a>').attr('href', urlCavaleiroEdit + '/' + cava.Id).html('Editar | ')));
            li.append(($('<span>').html('Deletar').addClass('icon-deletar')).click(deletarCavaleiro));
            li.append(gerarHtmlDetalhesCavaleiro(cava));

    $cavaleiros.append(li);
}

function gerarHtmlDetalhesCavaleiro(cava) {
    return $('<div>').attr('style', 'display:none').attr('id', 'dialog' + cava.Id)
        .append('<div>').html(cava.Nome);
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

function abrirModalDetalhesCavaleiro()
{
    var idCavaleiro = $(this).parents('li:first').attr('data-id-cavaleiro');

    $('#dialog' + idCavaleiro).dialog({});
}

