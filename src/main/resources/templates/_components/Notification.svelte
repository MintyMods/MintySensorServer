<script>
    import './_notification.scss';
    import {
        onMount
    } from 'svelte';
    let className = '';
    export {
        className as class
    };
    export let type = 'error';
    export let text = '';
    export let title = '';
    export let desktop = false;
    export let icon;
    export let shadow = true;
    export let hide = true;
    export let history;

    var wrapper;
    var core = {
        text: text,
        title: title,
        type: type,
        titleTrusted: true,
        textTrusted: true,
        icon: icon,
        addClass: 'nonblock translucent minty-notification ' + className,
        shadow: shadow,
        delay: 8000,
        hide: hide
    };

    var buttons = {
        'modules': {
            'Buttons': {
                'closerHover': true,
                'stickerHover': true
            }
        }
    };

    if (desktop === true) {
        if (Notification.permission !== "granted") {
            Notification.requestPermission();
            //            PNotify.modules.Desktop.permission();
        }
        var modules = {
            'modules': {
                'Desktop': {
                    'desktop': desktop
                }
            }
        };
    }

    onMount(() => {

        PNotify.defaults.icons = 'fontawesome5';
        PNotify.defaults.styling = 'material';
        PNotify.defaults.width = '400px';
        //        PNotify.modules.History.defaults.maxInStack = 50;
        //        PNotify.defaultStack = {
        //            dir1: 'down',
        //            dir2: 'left',
        //            firstpos1: 25,
        //            firstpos2: 25,
        //            spacing1: 36,
        //            spacing2: 36,
        //            push: 'bottom',
        //            context: document.body
        //        }

        if (history) {
            PNotify.modules.History.showAll();
        }


        wrapper = Object.assign({}, core, modules, buttons);

        if (desktop === true) {
            wrapper.icon = icon || 'fad fa-exclamation-triangle fa-2x';
        }

        switch (type) {
            case 'info':
                wrapper.icon = icon || 'fas fa-info-circle fa-2x';
                PNotify.info(wrapper);
                break;
            case 'success':
                wrapper.icon = icon || 'fas fa-question-circle fa-2x';
                PNotify.success(wrapper);
                break;
            case 'warning':
                wrapper.icon = icon || 'far fa-exclamation-circle fa-2x';
                PNotify.notice(wrapper);
                break;
            case 'error':
                wrapper.icon = icon || 'fad fa-engine-warning fa-2x';
                PNotify.error(wrapper);
                break;
            case 'notice':
            default:
                wrapper.addClass += ' minty-notice';
                wrapper.icon = icon || 'fas fa-question-circle fa-2x';
                PNotify.notice(wrapper);
        }

    });

</script>
