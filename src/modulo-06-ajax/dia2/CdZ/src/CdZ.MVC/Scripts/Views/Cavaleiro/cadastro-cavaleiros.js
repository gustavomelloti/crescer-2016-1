'use strict';

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
            window.location = urlCavalieroBase;
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
    $('.imagens:visible').each(function (indice, elem) {
        novasImagens.push({
            Id: $(this).find('input[name=idImagem]').val(),
            url: $(this).find('input[name=urlImagem]').val(),
            isThumb: $(this).find('input[name=isThumb]').is(':checked')
        });
    });

    var novosGolpes = [];
    $('.golpes:visible').each(function (i) {
        novosGolpes.push({
            Nome: $(this).find('input[name=golpe]').val(),
            Id: $(this).find('input[name=idGolpe]').val()
        });
    });

    return {
        Id: formData.get('Id'),
        Nome: formData.get('Nome'),
        AlturaCm: formData.get('AlturaCm'),
        PesoLb: formData.get('PesoLb'),
        Signo: formData.get('Signo'), 
        TipoSanguineo: formData.get('TipoSanguineo'),
        DataNascimento: data.toISOString(),
        Golpes: novosGolpes,
        LocalNascimento: {
            Texto: formData.get('LocalNascimento.Texto')
        },
        LocalTreinamento: {
            Texto: formData.get('LocalTreinamento.Texto')
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