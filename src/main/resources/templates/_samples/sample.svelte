Could anyone help me with passing a click event into a <svelte:component>. 
I basically need to be able to trigger something within the components that
are being dynamically added via an array when an icon within the parent 
component is clicked. e.g. I need to hook the **parts** together

```
<script>
 let charts = [
    ChartA,
    ChartB,
    ChartC
  ];
</script>
{#each charts as chart, i}
    <div class="wrapper">
        <div class="icon" on:click={**HowToPassClickEventToComponent**}></div>
        <div class="content">
        <svelte:component this={charts[i]} {**clickedEvent**}/>
        </div>
    </div>
{/each}
```
I was able to get something working by unsing an array of props but each
component is notified when the array changes so not very clean.

