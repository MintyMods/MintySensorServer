<script>
    import LiquidFill from '../_charts/LiquidFill.svelte'

    import {
        beforeUpdate
    } from 'svelte';
    import {
        storeReadings
    } from '../_stores/stores.js';

    export let data;
    $: data;
    beforeUpdate(() => {
        if ($storeReadings.length > 1) {
            $storeReadings.forEach(function(reading, i) {
                if (reading.label.value === "System1") {
                    data = reading.value;
                }
                data = data;
            });
        }
    });

</script>

<LiquidFill {data} />
