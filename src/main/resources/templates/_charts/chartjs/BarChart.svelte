<script>
  import { onMount, beforeUpdate, afterUpdate } from "svelte";

  export let data = [];
  export let labels = [];
  export let caption = "";
  let width = 1;
  let height = 2;
  let backgroundColor = [];
  let borderColor;

  const id = () =>
    "_" +
    Math.random()
      .toString(36)
      .substr(2, 9);
  let ctx;
  let chart;
  $: data;
  $: labels;

  onMount(() => {
    init();
  });

  export function showConfig() {
    PNotify.info("Bar Chart Config");
  }

  beforeUpdate(() => {
    if (data.length > 0 && document.getElementById(id) !== null) {
      init();
      chart.data.labels = labels;
      chart.data.datasets[0].data = data;
      chart.data.datasets[0].backgroundColor = backgroundColor;
      chart.data.datasets[0].borderColor = borderColor;
      chart.update();
    }
  });

  function init() {
    if (chart === undefined) createChart();
    if (backgroundColor.length === 0) setColors();
  }

  function setColors() {
    backgroundColor = [];
    borderColor = [];
    for (let i = 0; i < data.length; i++) {
      let r = Math.round(Math.random() * 127) + 127;
      let g = Math.round(Math.random() * 127) + 127;
      let b = Math.round(Math.random() * 127) + 127;
      backgroundColor.push(`rgba(${r},${g},${b}, 0.5)`);
      borderColor.push(`rgba(${r},${g},${b}, 1)`);
    }
  }

  function createChart() {
    ctx = document.getElementById(id).getContext("2d");
    chart = new Chart(ctx, {
      type: "bar",
      data: {
        labels,
        datasets: [
          {
            label: caption,
            data,
            borderWidth: 1
          }
        ]
      },
      options: {
        responsiveAnimationDuration: 10,
        responsive: true,
        maintainAspectRatio: false
      }
    });
  }
</script>

<style>
  .canvas-wrapper {
    position: relative;
    /* pointer-events: none; */
    width: 100%;
    height: 100%;
  }
</style>

<div class="canvas-wrapper">
  <canvas width="1" height="1" {id} />
</div>
