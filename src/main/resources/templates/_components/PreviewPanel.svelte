<script>
  import { onMount, onDestroy, afterUpdate, tick } from "svelte";
import EchartsLiquidFill from "../_charts/echarts/liquidfill/EchartsLiquidFill.svelte";
  export let owner;

  onMount(async () => {
    await tick();
    createPreview();
  });

  onDestroy(() => {
    // let chart = document.getElementById(owner);
    // originalNode.append(...chart.childNodes);
    // debugger
  });

  let originalNode;

  function createPreview() {
    // let chart = document.getElementById(owner);
    // originalNode = chart.parentNode;
    // var container = document.getElementById("place-holder");
    // container.append(...chart.childNodes);
    debugger
  }
</script>

<style>
  .preview-panel {
    border: 1px dashed red;
    height: 200px;
    position: relative;
    display: flex;
  }
</style>

<div class="preview-panel">
  <span id="place-holder">This is a place holder {owner}</span>
  <EchartsLiquidFill/>
</div>
