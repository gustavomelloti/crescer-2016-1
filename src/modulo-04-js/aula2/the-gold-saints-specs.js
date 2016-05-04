'use strict';

describe('Ex 1. Doadores de Sangue', function() {
  it('quando informa o json disponibilizado 3', function() {
    expect(obterDoadores(goldSaints).length).toEqual(3);
  });
});

describe('Ex 2. Cavaleiros com maior número de golpes', function(){
    it ('quando informa o json disponibilizado, deve retornar o cavaleiro de id 6', function(){
        expect(obterCavaleiroComMaisGolpes(goldSaints).id).toEqual(6);
    });
});

describe('Ex 3. Meses do ano com maior número de aniversariantes', function(){
    it ('quando informa o json disponibilizado, deve retornar os meses de Março, Maio e Novembro', function(){
        var meses = obterMesesComMaisAniversarios();
        expect(meses.indexOf('Março') !== -1 && meses.indexOf('Maio') !== -1  && meses.indexOf('Novembro') !== -1 ).toBe(true);
    });
});

describe('Ex 4. Média de altura entre os cavaleiros', function(){
    it ('quando informa o json disponibilizado, deve retornar 1.85', function(){
        expect(obterAlturaMedia()).toEqual(1.85);
    });
});

describe('Ex 5. Altura mediana entre os cavaleiros', function(){
    it ('quando informa o json disponibilizado, deve retornar a mediana 1.85', function(){
        expect(obterAlturaMediana()).toEqual(1.85);
    });
});

describe('Ex 6a. Obter peso peso médio entre os cavaleros', function(){
    it ('quando informa o json disponibilizado, deve retornar o peso médio 1.85', function(){
        expect(obterPesoMedio()).toEqual(84.00);
    });
});

describe('Ex 6b. Obter peso médio entre os cavaleros doadores', function(){
    it ('quando informa o json disponibilizado, deve retornar o peso médio 1.85', function(){
        expect(obterPesoMedioDoadores()).toEqual(85.00);
    });
});

describe('Ex 7. Obter IMC de todos os cavaleiros', function(){
    it ('quando informa o json disponibilizado, deve retornar os IMCS:["22.64", "29.48", "24.62", "24.22", "24.84", "20.53", "24.54", "24.31", "23.99", "22.45", "21.50"] ', function(){
        expect(obterIMC()).toEqual(["22.64", "29.48", "24.62", "24.22", "24.84", "20.53", "24.54", "24.31", "23.99", "22.45", "21.50"]);
    });
});

describe('Ex 8. Obter cavaleiros com sobre peso', function(){
    it ('quando informa o json disponibilizado, deve retornar o cavaleiro com id 2', function(){
        expect(obterSobrepeso()[0].id).toEqual(2);
    });
});
