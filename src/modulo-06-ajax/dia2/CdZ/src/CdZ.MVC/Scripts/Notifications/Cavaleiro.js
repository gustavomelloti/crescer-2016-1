var notificarCavaleiros = function (mensagem) {
    Notification.requestPermission().then(function (result) {
        console.log(result);
        if (result === 'granted') {
            var options = {
                body: mensagem,
                icon: 'http://i68.servimg.com/u/f68/13/28/07/38/icon10.png'
            }
            new Notification('', options);
        }
    });
};