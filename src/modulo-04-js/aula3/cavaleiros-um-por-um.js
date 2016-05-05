$(function() {
  // Carregando imagens sequencialmente na ordem, de forma recursiva.
  // No carregamento já registramos o evento de click na imagem para exibir os detalhes do cavaleiro.

  (function carregaImg(indice) {
    var $detalhesCavaleiro = $('#detalhes-cavaleiro');
    var cavaleiro = goldSaints[indice];
    var imgCavaleiro = new Image();
    imgCavaleiro.src = cavaleiro.imagens[0].url;
    imgCavaleiro.alt = cavaleiro.nome;
    imgCavaleiro.id = cavaleiro.id;
    imgCavaleiro.onload = function() {
      var $img = $(imgCavaleiro);
      $img.appendTo($('<li>').appendTo($('#cavaleiros'))).fadeIn();
      $img.click(function() {
        var self = $(this);
        var nome = self.attr('alt');
        var altura = goldSaints.filter(function(elem) {
          return elem.id === parseInt(self.attr('id'));
        })[0].alturaCm;
        $detalhesCavaleiro.children().detach();
        $detalhesCavaleiro.append($('<h3>').text( nome ));
        $detalhesCavaleiro.append($('<h3>').text( altura / 100 ));
      });
      if (indice < goldSaints.length - 1) carregaImg(indice + 1);
    };
  })(0);

  });
