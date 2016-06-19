'use strict';

function cidadeModel() {
    this.urlGet = '/cidade/listar';
    this.urlDelete = '/cidade/deletar';
};

cidadeModel.prototype.getPagined = function(pagina) {
    return $.ajax({
        url: this.urlGet,
        data: {pagina: pagina},
        type: "GET"
    });
};

cidadeModel.prototype.delete = function(id) {
    return $.ajax({
        url: this.urlDelete,
        data: {id:id},
        type: "POST"
    });
};