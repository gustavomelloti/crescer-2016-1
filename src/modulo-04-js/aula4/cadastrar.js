var goldSaints = JSON.parse(localStorage.getItem('cavaleiros')) || goldSaints;

$(document).ready(function(){
    for (var i in goldSaints) {
        $div = $('<div>').attr('data-id-cavaleiro', goldSaints[i].id);
		$div = $div.append($('<img>').attr('src', goldSaints[i].imagens[0].url));

		$divDetalhes = $('<div>').addClass('detalhes').css('display', 'none');
			$divDetalhes.append( $('<div>').append($('<span>Nome:</span> <span>'+goldSaints[i].nome+'</span>')));
            //$divDetalhes.append( $('<div>').append($('<span>Data nascimento:</span> <span>'+new
            // Date(goldSaints[i].dataNascimento).formatarData()+'</span>')));
             $divDetalhes.append( $('<div>').append($('<span>Altura(M):</span> <span>'+goldSaints[i].alturaCm.converterParaMetros().formatarNumero()+'</span>')));
			 $divDetalhes.append( $('<div>').append($('<span>Peso(KG):</span> <span>'+ (goldSaints[i].pesoLb === undefined ? 'não informado' : goldSaints[i].pesoLb.lbParaKilos().formatarNumero()) +'</span>')));
			// $divDetalhes.append( $('<div>').append($('<span>Golpes:</span> <span>'+goldSaints[i].golpes.toString()+'</span>'))) ;
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

    var $frmNovoCavaleiro = $('#frmNovoCavaleiro');

    $frmNovoCavaleiro.submit(function(e) {
      // FormData: https://developer.mozilla.orgslTipoSanguineo'/en/docs/Web/API/FormData
      var formData = new FormData($(this)[0]);
      var cavaleiro = {};
      for (var entry of formData.entries()) {
        cavaleiro[entry[0]] = entry[1];
      }
      console.log($frmNovoCavaleiro.serialize());
      var urlImagem = formData.get('urlImagem');
      $('.cavaleiros')
        .append(
          $('<li>').append(
            $('<img>').attr('src', urlImagem).fadeIn()
          )
        );

      goldSaints.push({
        nome: formData.get('nome'),
        imagens: [
          { url: urlImagem, isThumb: true }
        ],
        tipoSanguineo: formData.get('slTipoSanguineo'),
        signo: formData.get('slSigno'),
        pesoLb: parseFloat(formData.get('txtPeso')),
        alturaCm : parseFloat(formData.get('txtAltura')),
        localTreinamento: formData.get('txtLocalTreinamento'),
        localNascimento: formData.get('txtLocalNascimento')
      });

      localStorage['cavaleiros'] = JSON.stringify(goldSaints);

      return e.preventDefault();
    });
});
