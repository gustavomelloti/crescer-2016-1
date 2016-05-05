'use strict';

/* Cavaleiros */
var goldSaints = JSON.parse('[{"id":1,"nome":"Mu","dataNascimento":"1967-03-27T03:00:00.000Z","alturaCm":182,"pesoLb":165.35,"signo":"\u00c1ries","tipoSanguineo":"A","localNascimento":"Tibete","localTreinamento":"Jamiel","golpes":["Parede de Cristal","Extin\u00e7\u00e3o Estelar","Revolu\u00e7\u00e3o Estelar"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900361\/93eed452-0d66-11e6-8ba2-e083b8297b2b.png","isThumb":true}]},{"id":2,"nome":"Aldebaran","dataNascimento":"1967-05-08T03:00:00.000Z","alturaCm":210,"pesoLb":286.600941,"signo":"Touro","tipoSanguineo":"B","localNascimento":"Brasil","localTreinamento":"Brasil","golpes":["Grande Chifre"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900419\/dca83616-0d66-11e6-9757-8d07311e6999.png","isThumb":true}]},{"id":3,"nome":"Saga","dataNascimento":"1959-05-30T03:00:00.000Z","alturaCm":188,"pesoLb":191.81,"signo":"G\u00eameos","tipoSanguineo":"AB","localNascimento":"Gr\u00e9cia","localTreinamento":"Santu\u00e1rio, Gr\u00e9cia","golpes":["Sat\u00e3 Imperial","Outra Dimens\u00e3o","Explos\u00e3o Gal\u00e1ctica"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900456\/00e25b7e-0d67-11e6-9fb3-4b35577080d2.png","isThumb":true}]},{"id":4,"nome":"M\u00e1scara da Morte","dataNascimento":"1964-06-24T03:00:00.000Z","alturaCm":184,"pesoLb":180.77900,"signo":"C\u00e2ncer","tipoSanguineo":"A","localNascimento":"It\u00e1lia","localTreinamento":"Sic\u00edlia, It\u00e1lia","golpes":["Ondas do Inferno"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900489\/2cc0fd40-0d67-11e6-9bc0-600c5381c650.png","isThumb":true}]},{"id":5,"nome":"Aiolia","dataNascimento":"1967-08-16T03:00:00.000Z","alturaCm":185,"pesoLb":187.392923,"signo":"Le\u00e3o","tipoSanguineo":"O","localNascimento":"Gr\u00e9cia","localTreinamento":"Santu\u00e1rio, Gr\u00e9cia","golpes":["C\u00e1psula do Poder","Pata do Le\u00e3o","Rel\u00e2mpago de Plasma"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900613\/c4ba42f0-0d67-11e6-9c0e-e79c2278ab0b.png","isThumb":true}]},{"id":6,"nome":"Shaka","dataNascimento":"1967-09-19T03:00:00.000Z","alturaCm":182,"pesoLb":149.914338,"signo":"Virgem","tipoSanguineo":"AB","localNascimento":"\u00cdndia","localTreinamento":"Ganges, \u00cdndia","golpes":["Rendi\u00e7\u00e3o Divina","Ciclo das 6 Exist\u00eancias","Tesouro do C\u00e9u","Invoca\u00e7\u00e3o dos Esp\u00edritos","Ohm!","Kahn!"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900695\/4a5675dc-0d68-11e6-8396-2a775a2b0c39.png","isThumb":true}]},{"id":7,"nome":"Dohko","dataNascimento":"1726-10-20T03:00:00.000Z","alturaCm":170,"signo":"Libra","tipoSanguineo":"A","localNascimento":"China","localTreinamento":"5 Picos Antigos de Rozan, China","golpes":["C\u00f3lera do Drag\u00e3o","C\u00f3lera dos 100 Drag\u00f5es"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900848\/ea27d2e0-0d68-11e6-9d73-78add86a1811.png","isThumb":true}]},{"id":8,"nome":"Milo","dataNascimento":"1967-11-08T03:00:00.000Z","alturaCm":185,"pesoLb":185.1883,"signo":"Escorpi\u00e3o","tipoSanguineo":"B","localNascimento":"Gr\u00e9cia","localTreinamento":"Ilha de Milos, Gr\u00e9cia","golpes":["Restri\u00e7\u00e3o","Agulha Escarlate","Antares"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900894\/36445900-0d69-11e6-81c9-77cb17448b9d.png","isThumb":true}]},{"id":9,"nome":"Aiolos","dataNascimento":"1960-11-30T03:00:00.000Z","alturaCm":187,"pesoLb":187.392923,"signo":"Sagit\u00e1rio","tipoSanguineo":"O","localNascimento":"Gr\u00e9cia","localTreinamento":"Santu\u00e1rio, Gr\u00e9cia","golpes":["Trov\u00e3o At\u00f4mico","Flecha da Justi\u00e7a"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14901061\/e5fe3b90-0d69-11e6-9a78-2449055be1fa.png","isThumb":true}]},{"id":10,"nome":"Shura","dataNascimento":"1964-01-12T03:00:00.000Z","alturaCm":186,"pesoLb":182.983678,"signo":"Capric\u00f3rnio","tipoSanguineo":"B","localNascimento":"Espanha","localTreinamento":"Montes Pirineus, Espanha","golpes":["Excalibur"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14901144\/5af186c8-0d6a-11e6-934a-35db18b16752.png","isThumb":true}]},{"id":11,"nome":"Camus","dataNascimento":"1967-02-07T03:00:00.000Z","alturaCm":184,"pesoLb":167.551319,"signo":"Aqu\u00e1rio","tipoSanguineo":"A","localNascimento":"Fran\u00e7a","localTreinamento":"Sib\u00e9ria Oriental","golpes":["P\u00f3 de Diamante","Trov\u00e3o Aurora","Execu\u00e7\u00e3o Aurora"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14901196\/9f128f78-0d6a-11e6-86b3-1a68234e9bfc.png","isThumb":true}]},{"id":12,"nome":"Afrodite","dataNascimento":"1965-03-10T03:00:00.000Z","alturaCm":183,"pesoLb":158.732829,"signo":"Peixes","tipoSanguineo":"O","localNascimento":"Su\u00e9cia","localTreinamento":"Groel\u00e2ndia","golpes":["Rosas Diab\u00f3licas Reais","Rosas Piranhas","Rosa Branca"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14901259\/f4a0b3ca-0d6a-11e6-89b1-59855cabc43d.png","isThumb":true}]}]');

Number.prototype.formatarNumero = function() {
    return Math.round(this * 100) / 100;
}

Number.prototype.converterParaMetros = function() {
    return this / 100;
};

function calcularIMC(altura, peso) {
    return peso / Math.pow(altura, 2);
}

Number.prototype.lbParaKilos = function() {
    return this / 2.20462262;
};

var apenasComPesoDefinido = function(e) {
  return typeof e.pesoLb !== 'undefined';
};

/* Exercício 1 */
function obterDoadores() {
    return goldSaints.filter(function(e){
        return e.tipoSanguineo === 'O';
    });
}

/* Exercício 2 */
function obterCavaleiroComMaisGolpes() {
    return goldSaints.concat().sort(function(a, b) {
        return b.golpes.length - a.golpes.length;
    })[0];
}

/* Exercício 3 */
function obterMesesComMaisAniversarios() {
    var meses = [
        {'mes' : 'Janeiro',    'quantidadeAniversarios' : 0},
        {'mes' : 'Fevereiro',  'quantidadeAniversarios' : 0},
        {'mes' : 'Março',      'quantidadeAniversarios' : 0},
        {'mes' : 'Abril',      'quantidadeAniversarios' : 0},
        {'mes' : 'Maio',       'quantidadeAniversarios' : 0},
        {'mes' : 'Junho',      'quantidadeAniversarios' : 0},
        {'mes' : 'Julho',      'quantidadeAniversarios' : 0},
        {'mes' : 'Agosto',     'quantidadeAniversarios' : 0},
        {'mes' : 'Setembro',   'quantidadeAniversarios' : 0},
        {'mes' : 'Outubro',    'quantidadeAniversarios' : 0},
        {'mes' : 'Novembro',   'quantidadeAniversarios' : 0},
        {'mes' : 'Dezembro',   'quantidadeAniversarios' : 0}
    ];

    goldSaints.forEach(function(e){
        meses[new Date(e.dataNascimento).getMonth()].quantidadeAniversarios+= 1;
    });

    var mesesOrdenados = meses.sort(function(a, b) {
        return b.quantidadeAniversarios - a.quantidadeAniversarios;
    });

    var i = 0, nomeMeses = [];

    while(mesesOrdenados[0].quantidadeAniversarios == mesesOrdenados[i].quantidadeAniversarios) {
        nomeMeses.push(mesesOrdenados[i].mes);
        i++;
    }

    return nomeMeses;
}

/* Exercício 4 */
function obterAlturaMedia() {
    return (Object.keys(goldSaints).reduce(function(previous, key) {
        return previous + goldSaints[key].alturaCm;
    }, 0) / goldSaints.length).converterParaMetros().formatarNumero();
}

/* Exercício 5 */
function obterAlturaMediana() {
    var alturas = goldSaints.map(function(e){
        return e.alturaCm;
    }).filter(Number).sort();

    var posicao = Math.round(alturas.length/2);

    return (
        alturas.length % 2 === 0 ? (alturas[posicao] + alturas[posicao]) / 2  : alturas[posicao]
    ).converterParaMetros().formatarNumero();

}

/* Exercício 6 - A */
function obterPesoMedio() {
    return obterPesoMedioCavaleiros(goldSaints);
}

/* Exercício 6 - B */
function obterPesoMedioDoadores() {
    return obterPesoMedioCavaleiros(obterDoadores());
}

function obterPesoMedioCavaleiros(cavaleiros) {
    var pesos = cavaleiros.map(function(e){
        return e.pesoLb;
    }).filter(Number).sort();

    var posicao =  Math.round(pesos.length/2);

    return (
        pesos.length % 2 === 0 ? (pesos[posicao] + pesos[posicao]) / 2  : pesos[posicao]
    ).lbParaKilos().formatarNumero();
}

/* Exercício 7 */
function obterIMC() {
    return goldSaints.filter(apenasComPesoDefinido).map(function(e){
        return calcularIMC(e.alturaCm.converterParaMetros(), e.pesoLb.lbParaKilos()).formatarNumero();
    }).filter(Number);
}

/* Exercício 8 */
function obterSobrepeso() {
    var imcs = obterIMC();
    return goldSaints.filter(function(e, indice) {
        var imc = imcs[indice];
        return 25 <= imc && imc < 30;
    });
}
