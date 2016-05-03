'use strict';

//1
function daisyGame(numeroPetalas) {
    return (numeroPetalas % 2 === 0 ? 'Love me not'  : 'Love me');
}

//2
function maiorTexto(palavras) {
    var maiorPalavra = '';

    if (palavras.constructor === Array) {
        palavras.forEach(function(e){
            if (e.length > maiorPalavra.length)
                maiorPalavra = e;
        });
    }

    return maiorPalavra;
}

//3
function imprime(instrutores, fn) {
    typeof (fn === 'function')
        fn(instrutores);
}

function imprimeInstrutor(instrutores) {
    for (var i in instrutores)
        console.log('olá querido instrutor:', instrutores[i]);
}

//4
function adicionar(parcela1) {
    return function(parcela2) {
        return parcela1 + parcela2;
    }
};

//5
function fibo(n) {
    return n < 2 ? n : fibo(n-1) + fibo(n-2);
}

function fiboSum(n) {
    return n < 0 ? 0 : fibo(n) + fiboSum(n-1);
}

//6
function queroCafe(mascada, precos) {
    for (var i = 0; i < precos.length; i++) {
        if (precos[i] > mascada) {
            precos.splice(i, 1);
            i--;
        }
    }
    return precos.sort().toString();
}

//7
function contarPorTipo (objeto, tipo) {

  // inspirado em http://stackoverflow.com/a/13467007/5194966
  function getType(v) {
    return v === null ? 'null' : typeof v !== 'undefined' && v.constructor === Array ? 'array' : typeof v;
  }

  var count = 0;
  for (var campo in objeto) {
    if (getType(objeto[campo]) === tipo) count++;
  }

  return count;
}

//8
var gohan = 'gohan', goku = 'Goku';
function revelarSaiyaman() {
  console.log(gohan);
  goku = 'Son Goku';
  var gohan = 'Son ' + gohan;
  return gohan;
}
console.log(revelarSaiyaman());
console.log(goku);

/*
    Saídas:
        Son undefined
        Son Goku

    Son undefined é exibido pois é definido dentro da função revelarSaiyaman uma variável local, com mesmo nome de uma varíavel global.
    Quando é realizada a concatenação o valor da varíavel gohan passa a ser undefined.

    Son Goku é exibido porque dentro da função revelarSaiyaman o valor da variável global está sendo alterada para 'Son Goku'.
 */
