<svelte:head>
    <title>Notifications</title>
</svelte:head>

<script>
    import Notification from '../_components/Notification.svelte';
    import WebSocket from '../_components/WebSocket.svelte';
    import IconButton, {
        Icon
    } from '@smui/icon-button';
    let callBack = function(content) {
        debugger
        readings = event.detail.content;
        sendSocket = false;
    }

    function getNotification() {
        debugger
        sendSocket = true;
    }
    let sendSocket = false;

</script>


{#if sendSocket }
    <WebSocket on:event={callBack} command="NOTIFICATION" />
{/if}

<ul>
    <li id='minty-notice' class='btn-floating green fas fa-question-circle'></li>
    <li id='minty-info' class='btn-floating blue fas fa-info-circle'></li>
    <li id='minty-warn' class='btn-floating yellow darken-1 far fa-exclamation-circle'></li>
    <li id='minty-critical' class='btn-floating red fad fa-engine-warning'></li>
    <li id='minty-fatal' class='btn-floating red darken-1 fad fa-exclamation-triangle'></li>
</ul>
  <div style="display: flex; align-items: center;">
    <IconButton class="material-icons" on:click={() => getNotification()}>Notify</IconButton>
  </div>
