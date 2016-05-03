'use strict';

//1
function daisyGame(numeroPetalas) {
    if (!isNaN(numeroPetalas))
        console.log ((numeroPetalas % 2 === 0 ? 'Love me not'  : 'Love me'));
}

//2
function maiorTexto(palavras) {
    if (palavras.constructor === Array) {
        var qtdCaracteresMaior = 0, posicaoMaiorPalavra = 0;

        palavras.forEach(function(e, index){
            if (e.length > qtdCaracteresMaior) {
                qtdCaracteresMaior  = e.length;
                posicaoMaiorPalavra = index;
            }
        });

        console.log(palavras[posicaoMaiorPalavra]);
    }
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
var somaAux = 0;
 
function somar(n) {
    console.log(n+somaAux);
    somaAux = 0;
}

function adicionar(n) {
    if (somaAux === 0)
        somaAux = n;
    else
        somar(n); 
}

//5
function fibo(n) {
    return n < 2 ? n : fibo(n-1) + fibo(n-2);
}

function fiboSum(n) {
    return n < 0 ? 0 : fibo(n) + fiboSum(n-1);
}

//6
function queroCafe(mascada, precos) {
    var tamanhoArray = precos.length;

    for (var i = 0; i < tamanhoArray; i++) {
        if (precos[i] > mascada) {
            precos.splice(i, 1);
            i--;
        }
    }

    return (precos.sort()).toString();
}

//7
function contarPorTipo(obj, tipo, fn) {
    var ocorrencias = 0;

    for (var i in obj) 
        ocorrencias+= fn(obj[i], tipo);

    console.log(ocorrencias);
}

function compararTipos(valor, tipo) {
    if (tipo === 'array')
        return compararTipoArray(valor);

    if (['function', 'string', 'number', 'boolean', 'undefined'].indexOf(tipo) !== -1)
        return compararTipoPrimitivo(valor, tipo);

    if (tipo === 'null')
        return compararTipoNull(valor);

    if (tipo === 'object')
        return compararTipoObject(valor);

    return 0;
}

function compararTipoArray(array) {
    return array.constructor === Array;
}

function compararTipoPrimitivo(valor, tipo) {
    return typeof valor === tipo;
}

function compararTipoNull(valor) {
    return valor === null;
}

function compararTipoObject(obj) {
    obj instanceof Object;
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