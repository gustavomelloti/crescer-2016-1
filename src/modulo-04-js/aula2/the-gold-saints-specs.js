'use strict';

describe('Ex 1. Doadores de Sangue', function() {
  it('quando informa o json disponibilizado \'3\'', function() {
    expect(obterDoadores(goldSaints).length).toEqual(3);
  });
});

describe('Ex 2. Cavaleiros com maior número de golpes', function(){
    it ('quando informa o json disponibilizado, deve retornar o cavaleiro de id  \'6\'', function(){
        expect(obterCavaleiroComMaisGolpes(goldSaints).id).toEqual(6);
    });
});
