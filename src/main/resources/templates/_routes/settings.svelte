<svelte:head>
    <title>Settings Page</title>
</svelte:head>
<h1>Settings</h1>
<script>
  import Notification from "../_components/Notification.svelte";
    import {
        time
    } from '../_stores/main-state.js';
    const formatter = new Intl.DateTimeFormat('en', {
        hour12: true,
        hour: 'numeric',
        minute: '2-digit',
        second: '2-digit'
    });

</script>

<h1>The time is {formatter.format($time)}</h1>
