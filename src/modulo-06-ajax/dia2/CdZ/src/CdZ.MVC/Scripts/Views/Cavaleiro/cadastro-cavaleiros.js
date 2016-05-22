﻿'use strict';

$(function () {
    $('#DataNascimento').datepicker({
        dateFormat: 'dd/mm/yy',
        changeYear: true,
        yearRange: "1900:2016"
    });

    var $frmNovoCavaleiro = $('#frmNovoCavaleiro');

    $frmNovoCavaleiro.submit(function (e) {
        $.ajax({
            url: urlCavaleiroPost,
            type: 'POST',
            data: converterFormParaCavaleiro($frmNovoCavaleiro)
        }).done(function (res) {
            console.log('cadastrou');
        });

        return e.preventDefault();
    });


    $('#btnAdicionarImg').click(function () {
        $('.form-horizontal > .form-group').last().before(gerarElementoLiComInputs());
    });

    $('#btnAdicionarGolpe').click(function () {
        $('.form-horizontal > .form-group').last().before(gerarElementoLiComInputTexto());
    });

});

function converterFormParaCavaleiro($form) {

    var formData = new FormData($form[0]);

    var data = $('#DataNascimento').datepicker('getDate');

    var novasImagens = [];
    $('.imagens').each(function (indice, elem) {
        novasImagens.push({
            url: $(this).find('input[name=urlImagem]').val(),
            isThumb: $(this).find('input[name=isThumb]').is(':checked')
        });
    });

    var novosGolpes = [];
    $('.golpes').each(function (i) {
        novosGolpes.push($(this).find('input[name=golpe]').val());
    });

    return {
        Nome: formData.get('Nome'),
        AlturaCm: formData.get('AlturaCm'),
        PesoLb: formData.get('PesoLb'),
        Signo: formData.get('Signo'), 
        TipoSanguineo: formData.get('TipoSanguineo'),
        DataNascimento: data.toISOString(),
        Golpes: novosGolpes,
        LocalNascimento: {
            Texto: formData.get('LocalNascimento')
        },
        LocalTreinamento: {
            Texto: formData.get('LocalTreinamento')
        },
        Imagens: novasImagens
    };
}

function gerarElementoLiComInputs() {
    return $('#estrutura-imagem').clone().attr('style', '');
};

function gerarElementoLiComInputTexto() {
    return $('#estrutura-golpe').clone().attr('style', '');
};