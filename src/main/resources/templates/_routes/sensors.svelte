<svelte:head>
    <title>Sensors</title>
</svelte:head>
<h1>Sensors</h1>

<script>
    import Sensors from '../_components/SensorList.svelte';
    import Notification from '../_components/Notification.svelte';
    let data = [1, 2, 3, 4, 5, 6];

</script>
<Sensors />
