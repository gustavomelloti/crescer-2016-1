'use strict';

// SEPARAR FUNCIONALIADES EM ARQUIVOS (TÁ TUDO MISTURADO)

function deletarCavaleiro () {
    var idCavaleiro = parseInt($(this).parent('li:first').attr('data-id-cavaleiro'));

    $.ajax({
        url: urlCavaleiroDelete,
        data: { idCavaleiro: idCavaleiro },
        type: 'DELETE',
        success: function (response) {
            $('[data-id-cavaleiro=' + idCavaleiro + ']').remove();
            notificarCavaleiros('Cavaleiro excluído!');
        },
        error: function () {
            alert('Erro ao deletar cavaleiro');
        }
    });
};

function adicionarCavaleiroNoHtml(cava)
{
    var $cavaleiros = $('#cavaleiros'),
        li = $('<li>').attr('data-id-cavaleiro', cava.Id);
            li.append(($('<img>').attr('src', buscarImagemCavaleiro(cava))).click(abrirModalDetalhesCavaleiro));
            li.append($('<span>').html($('<a>').attr('href', urlCavaleiroEdit + '/' + cava.Id).html($('<i>').addClass('fa fa-pencil'))));
            li.append(($('<span>').html('<i>').addClass('icon-deletar fa fa-times')).click(deletarCavaleiro));

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
                notificarCavaleiros(qtd + ' novo(s) cavaleiro(s) foram adicionado(s)!');
        }
    );
}, 3000);

function abrirModalDetalhesCavaleiro()
{
    var idCavaleiro = $(this).parents('li:first').attr('data-id-cavaleiro');

    buscarCavaleiroPorId(idCavaleiro).then(
        function onSuccess(res) {
            $('#d_id').html(res.data.Id);
            $('#d_nome').html(res.data.Nome);
            $('#d_peso').html(res.data.PesoLb);
            $('#d_altura').html(res.data.AlturaCm);
            $('#d_nascimento').html(res.data.DataNascimento);
            $('#d_signo').html(res.data.Signo);
            $('#d_tipo_sanguineo').html(res.data.TipoSanguineo);
            $('#d_local_nascimento').html(res.data.LocalNascimento);
            $('#d_local_treinamento').html(res.data.LocalTreinameno);
            $('#d_golpes').html();
            $('#d_imagens').html();
            $('#dialog').dialog({});
        },
        function onError(res) {
            alert("Erro ao buscar detalhes do cavaleiro");
        }
    );
}

function buscarCavaleiroPorId(id)
{
    return $.ajax({ url: urlCavaleiroGetId, type: 'GET', data:{id : id} });
}