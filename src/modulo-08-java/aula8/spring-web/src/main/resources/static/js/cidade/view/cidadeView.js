'use strict';

function cidadeView() {
    this.pagina = 1;
    this.cModel = new cidadeModel();
    this.win = $(window);
}

cidadeView.prototype.init = function() {
    self = (this);
    
    this.carregarDados();
    
    $('tbody').on('click', 'tr td:last-child a', function(){
        var tr = $(this).parents('tr:first'),
            id = $(this).attr('data-id');
            
        self.cModel.delete(id).done(function() {
            tr.remove();
        });
    });
    
    this.win.scroll(function() {
        if ($(document).height() - self.win.height() === self.win.scrollTop())
            self.carregarDados();
    });
};

cidadeView.prototype.carregarDados = function() {
    self = (this);
    
    this.cModel.getPagined(this.pagina).done(function(data) {
        $('tbody').append(data);
        self.pagina+=1;
    });
};

   