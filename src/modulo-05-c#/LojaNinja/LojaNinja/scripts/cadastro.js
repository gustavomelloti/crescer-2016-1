$(document).ready(function () {
    $('#Estado').mask('aa');
    $('#DataDesejoEntrega').datepicker({ minDate: '0', dateFormat: 'dd/mm/yy' });
    $('#ValorVenda').maskMoney({showSymbol:true, symbol:"R$", decimal:",", thousands:"."});
});