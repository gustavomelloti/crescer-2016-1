var notificarNovosCavaleiros = function(quantidade) {
    Notification.requestPermission().then(function (result) {
        console.log(result);
        if (result === 'granted') {
            var options = {
                body: quantidade + ' novo(s) cavaleiro(s) foram adicionado(s)!',
                icon: 'http://i68.servimg.com/u/f68/13/28/07/38/icon10.png'
            }
            new Notification('', options);
        }
    });
};