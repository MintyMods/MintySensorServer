<script>
    import {
        onMount
    } from 'svelte';
    import Notification from '../_components/Notification.svelte';

    export let callback;
    export let command;
    export let parameters;
    export let headers = {};
    export let channel = "/api/" + Math.random().toString(36).replace(/[^a-z]+/g, '').substr(2, 10);
    let stompClient = null;
    let unsubscribe;
    let content;
    $: content = content;
    let errorMsg = '';
    $: errorMsg = errorMsg;

    onMount(() => {
        let socket = new SockJS('https://localhost:8080/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
    });

    function onConnected() {
        unsubscribe = stompClient.subscribe(channel, onMessageReceived);
        let payload = JSON.stringify({
            command,
            channel,
            parameters
        });
        stompClient.send("/app/api.command", headers, payload)
        //        event.preventDefault();
    }

    function onError(error) {
        errorMsg = 'Could not connect to WebSocket server. Please refresh this page to try again!\n\n' + error;
    }

    function onMessageReceived(payload) {
        let message = JSON.parse(payload.body);
        content = JSON.parse(message.json);
        if (callback) callback(content);

    }

</script>

{#if errorMsg !=''}
    <Notification type="error" text="{errorMsg}" hide={false} title="Error Getting Sensors" />
{/if}
