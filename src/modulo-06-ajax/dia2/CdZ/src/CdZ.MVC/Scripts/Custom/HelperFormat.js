Number.prototype.converterParaMetros = function () {
    return this / 100;
};

Number.prototype.lbParaKilos = function () {
    return this / 2.20462262;
};

Number.prototype.formatarNumero = function () {
    return Math.round(this * 100) / 100;
}

Date.prototype.formatarDataPadraoBr = function() {
    //http://pt.stackoverflow.com/questions/6526/como-formatar-data-no-javascript
    var data = this;

    var dia = data.getDate();

    if (dia.toString().length == 1)
        dia = "0" + dia;
    var mes = data.getMonth() + 1;

    if (mes.toString().length == 1)
        mes = "0" + mes;
    var ano = data.getFullYear();

    return dia + "/" + mes + "/" + ano;
}