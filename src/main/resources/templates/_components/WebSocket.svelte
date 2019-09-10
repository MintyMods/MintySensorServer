<script>
    import {
        onMount
    } from 'svelte';
    import {
        storeLastNetworkPing,
        storeLastNetworkPong
    } from './_stores.js';
    import {
        createEventDispatcher
    } from 'svelte';
    import Notification from '../_components/Notification.svelte';
    export let command;
    export let parameters;
    export let headers = {};
    export let channel = "/api/" + Math.random().toString(36).replace(/[^a-z]+/g, '').substr(2, 10);
    let stompClient = null;
    let lastPing;
    $: lastPing = lastPing;
    $: lastPong = lastPong;


    let lastPong;
    const dispatch = createEventDispatcher();

    //$: console.log('Last Active :' + lastAlive);

    onMount(() => {
        storeLastNetworkPing.set(new Date());
        let socket = new SockJS('https://localhost:8080/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
        stompClient.debug = () => {};
    });

    const unsubscribePing = storeLastNetworkPing.subscribe(ping => {
        lastPing = ping;
    });
    const unsubscribePong = storeLastNetworkPong.subscribe(pong => {
        lastPong = pong;
    });

    function onConnected() {
        storeLastNetworkPong.set(new Date());
        stompClient.subscribe(channel, onMessageReceived);

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
        storeLastNetworkPong.set(new Date());
        let message = JSON.parse(payload.body);
        let content = JSON.parse(message.json);
        dispatch('event', {
            content
        });
    }

    function getLastChecked() {
        //        let out = "\nPING : " + moment(lastPing, 'MMMM Do YYYY, h:mm:ss a').fromNow();
        //        out = out + "\nPONG : " + moment(lastPong, 'MMMM Do YYYY, h:mm:ss a').fromNow();
        let out = "\nPING : " + moment(lastPing, 'MMMM Do YYYY, h:mm:ss a').format('h:mm:ss');
        out = out + "\nPONG : " + moment(lastPong, 'MMMM Do YYYY, h:mm:ss a').format('h:mm:ss');
        return out;
    }

    function onError(error) {
        if (window.permanotice) {
            storeLastNetworkPong.set(new Date());
            window.permanotice.open();
        } else {
            window.permanotice = PNotify.notice({
                title: 'Network Error',
                text: '\n' + error + getLastChecked(),
                hide: false,
                icon: 'fad fa-wifi-slash fa-3x',
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

</script>
