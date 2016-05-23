Number.prototype.converterParaMetros = function () {
    return this / 100;
};

Number.prototype.lbParaKilos = function () {
    return this / 2.20462262;
};

Number.prototype.formatarNumero = function () {
    return Math.round(this * 100) / 100;
}