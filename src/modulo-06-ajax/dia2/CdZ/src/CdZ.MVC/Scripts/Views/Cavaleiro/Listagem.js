﻿'use strict';

function deletarCavaleiro() {
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

function abrirModalDetalhesCavaleiro() {
    var idCavaleiro = $(this).parents('li:first').attr('data-id-cavaleiro');

    buscarCavaleiroPorId(idCavaleiro).then(
        function onSuccess(res) {
            console.log(res);
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

function buscarCavaleiroPorId(id) {
    return $.ajax({ url: urlCavaleiroGetId, type: 'GET', data: { id: id } });
}

$(function () {
    $(document).on("click", "#contentPager a[href]", function () {
        $.ajax({
            url: $(this).attr("href"),
            type: 'GET',
            cache: false,
            success: function (result) {
                $('#content').html(result);
            }
        });
        return false;
    });
});