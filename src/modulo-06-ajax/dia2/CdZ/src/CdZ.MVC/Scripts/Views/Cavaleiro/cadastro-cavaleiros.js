'use strict';

$(function () {

    $('#DataNascimento').datepicker({
        dateFormat: 'dd/mm/yy'
    });

    var $frmNovoCavaleiro = $('#frmNovoCavaleiro');

    $frmNovoCavaleiro.submit(function (e) {
        $.ajax({
            url: urlCavaleiroPost,
            type: 'POST',
            data: converterFormParaCavaleiro($frmNovoCavaleiro)
        }).done(function (res) {
           
        });

        return e.preventDefault();
    });

    // Adicionando campos para imagens
    var $novasImagens = $('#novasImagens');

    $('#btnAdicionarImg').click(function () {
        var $novoLi = gerarElementoLiComInputs();
        $novasImagens.append($novoLi);
    });

    $('#btnAdicionarGolpe').click(function () {
        $('#novosGolpes').append(gerarElementoLiComInputTexto());
    });

});

function converterFormParaCavaleiro($form) {

    var formData = new FormData($form[0]);

    var data = $('#DataNascimento').datepicker('getDate');

    var novasImagens = [];
    $('#novasImagens li').each(function (indice, elem) {
        novasImagens.push({
            url: $(this).find('input[name=urlImagem]').val(),
            isThumb: $(this).find('input[name=isThumb]').is(':checked')
        });
    });

    var novosGolpes = [];
    $('#novosGolpes li').each(function (i) {
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

function adicionarBtnExclusao(idCavaleiro, $img) {
    var $btnExcluir = $('<button>')
      // É possível criar atributos novos, sugestão: utilizar o prefixo data-*
      // Desta forma não quebramos a especificação do HTML de informar mais de um elemento com o mesmo id
      .attr('data-cavaleiro-id', idCavaleiro)
      .addClass('btn btn-small btn-danger btn-canto-imagem')
      .text('X');
    $btnExcluir.insertAfter($img);
    $btnExcluir.click(excluirCavaleiro);
};

function gerarElementoLiComInputs() {
    var $novoTxt = $('<input>').attr('name', 'urlImagem').attr('type', 'text').attr('placeholder', 'Ex: bit.ly/shiryu.png');
    var $novoCheckbox =
      // Dentro de um label para pode vincular o texto ao checkbox
      $('<label>')
        .append(
          $('<input>')
          .attr('type', 'checkbox')
          .attr('name', 'isThumb')
          .attr('checked', 'checked'))
        .append('É thumbnail?');
    return $('<li>').append($novoTxt).append($novoCheckbox);
};

function gerarElementoLiComInputTexto() {
    var $novoTxt = $('<input>').attr('name', 'golpe').attr('type', 'text').attr('placeholder', 'Ex: Pó de diamante');
    return $('<li>').append($novoTxt);
};