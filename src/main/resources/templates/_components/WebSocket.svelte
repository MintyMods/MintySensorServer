<!-- <script>
    import {
        formatDistance
    } from 'date-fns'
    import {
        onMount,
        createEventDispatcher
    } from 'svelte';
    import {
        storeLastNetworkPing,
        storeLastNetworkPong,
        time
    } from '../_stores/main-state.js';
    import Notification from '../_components/Notification.svelte';
    export let command;
    export let parameters;
    export let headers = {};
    export let channel = "/api/" + Math.random().toString(36).replace(/[^a-z]+/g, '').substr(2, 10);
    let stompClient = null;
    let lastPing;
    let lastPong;
    const debugging = true;

    const dispatch = createEventDispatcher();

    //$: console.log('Last Active :' + lastAlive);

    onMount((event) => {
        storeLastNetworkPing.set(new Date());
        let socket = new SockJS('https://localhost:8080/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
        stompClient.debug = () => {}; //if (debugging)
        //event.preventDefault();
    });

    const unsubscribePing = storeLastNetworkPing.subscribe(ping => {
        lastPing = ping;
    });
    const unsubscribePong = storeLastNetworkPong.subscribe(pong => {
        lastPong = pong;
    });

    function onConnected() {
        if (command == 'EVENTS') { //@todo remove
            stompClient.subscribe(channel, onMessageReceived);
        }

        let payload = JSON.stringify({
            command,
            channel,
            parameters
        });
        if (command == 'EVENTS') {
            stompClient.send("/app/api.events", headers, payload);
        } else {
            stompClient.send("/app/api.command", headers, payload);
        }
    }

    function onMessageReceived(payload) {
        let message = JSON.parse(payload.body);
        let content = JSON.parse(message.json);
        dispatch('event', {
            content
        });
    }

    function getLastChecked() {
        let now = new Date();
        let pinged = formatDistance(lastPing, now);
        let ponged = formatDistance(lastPong, lastPing);
        let ping = `\nLast PING : ` + formatter.format(lastPing) + `, ${pinged} ago.`;
        let pong = `\nLast PONG : ` + formatter.format(lastPong) + `, ${ponged} ago.`;
        return ping + pong;
    }

    function onError(error) {
        if (window.permanotice) {
            window.permanotice.open();
        } else {
            window.permanotice = PNotify.notice({
                title: 'Network Error',
                text: getLastChecked(),
                hide: false,
                icon: 'fad fa-wifi-slash fa-2x',
                width: '600px',
                textTrusted: true,
                modules: {
                    Buttons: {
                        closer: false,
                        sticker: false,
                        classes: {
                            closer: 'fas fa-bomb',
                            pinUp: 'fas fa-anchor',
                            pinDown: 'fas fa-hourglass'
                        }
                    },
                    Mobile: {
                        swipeDismiss: false
                    }
                }
            });


        }
    }

    function showStackBarBottom(type) {
        if (typeof window.stackBarBottom === 'undefined') {
            window.stackBarBottom = {
                'dir1': 'up',
                'firstpos1': 0,
                'spacing1': 0
            };
        }
        var opts = {
            title: 'Over Here',
            text: "Check me out. I'm in a different stack.",
            addClass: 'stack-bar-bottom',
            cornerClass: 'ui-pnotify-sharp',
            shadow: false,
            width: '100%',
            stack: window.stackBarBottom
        };
        switch (type) {
            case 'error':
                opts.title = 'Oh No';
                opts.text = 'Watch out for that water tower!';
                opts.type = 'error';
                break;
            case 'info':
                opts.title = 'Breaking News';
                opts.text = 'Have you met Ted?';
                opts.type = 'info';
                break;
            case 'success':
                opts.title = 'Good News Everyone';
                opts.text = "I've invented a device that bites shiny metal asses.";
                opts.type = 'success';
                break;
        }
        PNotify.alert(opts);
    }
    const formatter = new Intl.DateTimeFormat('en', {
        hour12: true,
        hour: 'numeric',
        minute: '2-digit',
        second: '2-digit'
    });

</script> -->
