var trigger = $('#hamburger');
trigger.click(function () {
    burgerTime();
});

function burgerTime() {
    trigger.toggleClass('is-open');
    trigger.toggleClass('is-closed');
}

function initSensorServer() {
    navigation = new mlPushMenu(document.getElementById('mp-menu'), document.getElementById('hamburger'));
    initPNotify();
}

function initPNotify() {
    try {
        PNotify.defaults.icons = 'fontawesome5';
        PNotify.defaults.styling = 'bootstrap4'; // Bootstrap version 4
        PNotify.defaults.styling = 'material';
        PNotify.modules.History.defaults.maxInStack = 50;
        PNotify.defaults.width = '400px';
        PNotify.defaults = {
            titleTrusted: true,
            textTrusted: true,
            autoDisplay: true,
            shadow: true,
            delay: 8000
        }
        PNotify.defaultStack = {
            dir1: 'down',
            dir2: 'left',
            firstpos1: 25,
            firstpos2: 25,
            spacing1: 36,
            spacing2: 36,
            push: 'bottom',
            context: document.body
        }

    } catch (e) {
        console.log(e);
    }

}
