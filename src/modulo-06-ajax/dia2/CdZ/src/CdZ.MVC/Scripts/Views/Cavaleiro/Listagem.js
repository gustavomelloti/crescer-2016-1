'use strict';

function buscarCavaleiroPorId(id) {
    return $.ajax({ url: urlCavaleiroGetId, type: 'GET', data: { id: id } });
}

function trocarPagina(pagina) {
    $.ajax({
        url: pagina,
        type: 'GET',
        cache: false,
        success: function (result) {
            $('#content').html(result);
        }
    });
}

$(function () {
    //detalhes
    $(document).on("click", ".info", function () {
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
    });

    
    //paginação
    $(document).on("click", "#contentPager a[href]", function () {
        trocarPagina($(this).attr("href"));
        return false;
    });

    //deletar
    $(document).on("click", ".icon-deletar", function () {
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
    });

    setInterval(function () {
        trocarPagina(urlCavalieroPaginacao + $('.active a').html());
    }, 6000);
});