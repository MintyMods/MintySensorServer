<svelte:head>
    <title>Notifications</title>
</svelte:head>

<script>
    import Notification from '../_components/Notification.svelte';
    import WebSocket from '../_components/WebSocket.svelte';

    let callBack = function(content) {
        debugger
        console.log(content);
    }

</script>

<WebSocket bind:callback={callBack} command="SENSORS" />

<ul>
    <li id='minty-notice' class='btn-floating green fas fa-question-circle'></li>
    <li id='minty-info' class='btn-floating blue fas fa-info-circle'></li>
    <li id='minty-warn' class='btn-floating yellow darken-1 far fa-exclamation-circle'></li>
    <li id='minty-critical' class='btn-floating red fad fa-engine-warning'></li>
    <li id='minty-fatal' class='btn-floating red darken-1 fad fa-exclamation-triangle'></li>
</ul>
