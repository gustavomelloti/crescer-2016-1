$(document).ready(function(){
    goldSaints = JSON.parse(localStorage.getItem('cavaleiros')) || goldSaints;

    (function() {
        for (var i in goldSaints)
            adicionarCavaleiroHtml(i);
    })();

    function adicionarCavaleiroHtml(i) {
        $div = $('<div>').attr('data-id-cavaleiro', goldSaints[i].id);
            $div = $div.append($('<img>').attr('src', 'img/delete.png').addClass('delete'));
            $div = $div.append($('<img>').attr('src', goldSaints[i].imagens[0].url));


            $divDetalhes = $('<div>').addClass('detalhes').css('display', 'none');
                $divDetalhes.append( $('<div>').append($('<span>Nome:</span> <span>'+goldSaints[i].nome+'</span>')));
                $divDetalhes.append( $('<div>').append($('<span>Data nascimento:</span> <span>'+new
                Date(goldSaints[i].dataNascimento).formatarData()+'</span>')));
                $divDetalhes.append( $('<div>').append($('<span>Altura(M):</span> <span>'+goldSaints[i].alturaCm.converterParaMetros().formatarNumero()+'</span>')));
                $divDetalhes.append( $('<div>').append($('<span>Peso(KG):</span> <span>'+ (goldSaints[i].pesoLb === undefined ? 'não informado' : goldSaints[i].pesoLb.lbParaKilos().formatarNumero()) +'</span>')));
                $divDetalhes.append( $('<div>').append($('<span>Golpes:</span> <span>'+goldSaints[i].golpes.toString()+'</span>'))) ;
                $divDetalhes.append( $('<div>').append($('<span>local Treinamento:</span> <span>'+goldSaints[i].localTreinamento+'</span>'))) ;
                $divDetalhes.append( $('<div>').append($('<span>Local Nascimento:</span> <span>'+goldSaints[i].localNascimento+'</span>'))) ;
                $divDetalhes.append( $('<div>').append($('<span>Signo:</span> <span>'+goldSaints[i].signo+'</span>'))) ;
                $divDetalhes.append( $('<div>').append($('<span>Tipo Sanguíneo:</span> <span>'+goldSaints[i].tipoSanguineo+'</span>'))) ;

        $(".cavaleiros").append($div.append($divDetalhes));
    }

    function adicionarCavaleiro() {
        var golpesCavaleiro = [];
            $("[name^='golpes']").each(function(){ golpesCavaleiro.push($(this).val())});

        goldSaints.push({
            id: goldSaints.length,
            dataNascimento: $("#slDataNascimento").datepicker('getDate'),
            nome: $('#txtNomeCavaleiro').val(),
            imagens: [
                $("[name^='urlImagem']").map(function(index){ return { url:$("#txtUrlImagem"+ (index+1)).val(), isThumb: $('#ckThumb'+ (index+1)).is(":checked") }})[0]
            ],
            golpes: golpesCavaleiro,
            tipoSanguineo: $('#slTipoSanguineo').val(),
            signo: $('#slSigno').val(),
            pesoLb: parseFloat($('#txtPeso').val()),
            alturaCm : parseFloat($('#txtAltura').val()),
            localTreinamento: $('#txtLocalTreinamento').val(),
            localNascimento: $('#txtLocalNascimento').val()
        });

        atualizarCavaleiros();
    }

    function atualizarCavaleiros() {
        localStorage['cavaleiros'] = JSON.stringify(goldSaints);
    }

    function limparForm() {
        $("[name^='golpes']").each(function(i){
            if (i !== 0) {
                $(this).prev().remove();
                $(this).remove();
            }
        });

        $("[name^='urlImagem']").each(function(i){
            if (i !== 0) {
                $(this).prev().remove();
                $(this).next().remove();
                $(this).remove();
            }
        });

        $(this).trigger("reset");
    }

    $('body').on('mouseover', '.cavaleiros > div', function(){
        $(this).find('div').show();
    });

    $('body').on('mouseout', '.cavaleiros > div', function(){
        $(this).find('div').hide();
    });

    $('body').on('click', '.delete', function(){
        var idCavaleiro = $(this).parent('div:first').attr('data-id-cavaleiro');

        $(this).parent('div:first').remove();

        var indexCavaleiro = Object.keys(goldSaints).filter(function(i){
            return goldSaints[i].id == idCavaleiro;
        }, 0)[0];

        goldSaints.splice(indexCavaleiro,1);

        atualizarCavaleiros();
    });

    $('#frmNovoCavaleiro').submit(function(e) {
        adicionarCavaleiro();
        adicionarCavaleiroHtml(goldSaints.length - 1);
        limparForm();
        return e.preventDefault();
    });

    $("#adicionarGolpe").click(function(){
        var qtdInputs = $('.golpes').length;

        var $label = $('#lbGolpe'+qtdInputs).clone();
        var $input = $('#golpe'+qtdInputs).clone();

        $(this).before($label.attr('id', 'lbGolpe'+(qtdInputs+1)).text('Golpe ' + (qtdInputs+1)));
        $(this).before($input.attr('id', 'golpe'+(qtdInputs+1)).val(''));
    });

    $("#adicionarImagem").click(function(){
        var qtdInputs = $('.imagens').length;

        var $label = $('#lbImagem'+qtdInputs).clone();
        var $input = $('#txtUrlImagem'+qtdInputs).clone();
        var $checkox = $('#ckThumb'+qtdInputs).clone();

        $(this).before($label.attr('id', 'lbImagem'+(qtdInputs+1)).text('Imagem ' + (qtdInputs+1)));
        $(this).before($input.attr('id', 'txtUrlImagem'+(qtdInputs+1)).val(''));
        $(this).before($checkox.attr('id', 'ckThumb'+(qtdInputs+1)).val(''));
    });

    $("#slDataNascimento").datepicker({
        changeYear: true,
        yearRange: "1900:2016"
    });
});
