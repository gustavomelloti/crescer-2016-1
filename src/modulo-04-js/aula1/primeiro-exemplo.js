'use strict';

var hello = 'hello world';
console.log(hello);

function somar(a,b) {
    return a + b;
};

var sub = function(a,b) {
    return a - b;
};

var funcoes = [somar(1,1), sub];

funcoes[1](3,2);

/*
var imprimeFilho = function(e) {console.log(e)};
goku.filhos.ForEach(imprimeFilho);
*/
/*
    comparar tipos primitivos -> typeof
    comprar tipos completos -> instanceof
*/
