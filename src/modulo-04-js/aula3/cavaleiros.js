$(document).ready(function(){
    for (var i in goldSaints) {
        $div = $('<div>').attr('data-id-cavaleiro', goldSaints[i].id);
		$div = $div.append($('<img>').attr('src', goldSaints[i].imagens[0].url));

		$divDetalhes = $('<div>').addClass('detalhes').css('display', 'none');
			$divDetalhes.append( $('<div>').append($('<span>Nome:</span> <span>'+goldSaints[i].nome+'</span>')));
            $divDetalhes.append( $('<div>').append($('<span>Data nascimento:</span> <span>'+new Date(goldSaints[i].dataNascimento).formatarData()+'</span>')));
            $divDetalhes.append( $('<div>').append($('<span>Altura(M):</span> <span>'+goldSaints[i].alturaCm.converterParaMetros().formatarNumero()+'</span>')));
			$divDetalhes.append( $('<div>').append($('<span>Peso(KG):</span> <span>'+ (goldSaints[i].pesoLb === undefined ? 'não informado' : goldSaints[i].pesoLb.lbParaKilos().formatarNumero()) +'</span>')));
			$divDetalhes.append( $('<div>').append($('<span>Golpes:</span> <span>'+goldSaints[i].golpes.toString()+'</span>'))) ;
			$divDetalhes.append( $('<div>').append($('<span>local Treinamento:</span> <span>'+goldSaints[i].localTreinamento+'</span>'))) ;
			$divDetalhes.append( $('<div>').append($('<span>Local Nascimento:</span> <span>'+goldSaints[i].localNascimento+'</span>'))) ;
			$divDetalhes.append( $('<div>').append($('<span>Signo:</span> <span>'+goldSaints[i].signo+'</span>'))) ;
			$divDetalhes.append( $('<div>').append($('<span>Tipo Sanguíneo:</span> <span>'+goldSaints[i].tipoSanguineo+'</span>'))) ;

        $(".cavaleiros").append($div.append($divDetalhes));
    }

    $(".cavaleiros > div").mouseover(function(){
    	$(this).find('div').show();
    });

     $(".cavaleiros > div").mouseout(function(){
    	$(this).find('div').hide();
    });
});
