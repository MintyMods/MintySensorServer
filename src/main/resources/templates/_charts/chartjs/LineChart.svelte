<script>
  import { onMount, beforeUpdate, afterUpdate } from "svelte";

  export let data = [];
  export let labels = [];
  export let caption = "";

  export let id =
    "chart-" +
    Math.random()
      .toString(36)
      .replace(/[^a-z]+/g, "")
      .substr(2, 10);
  let ctx;
  let chart;
  $: data;
  let all = [];

  onMount(() => {
    createChart();
  });

  export function showConfig() {
    PNotify.info("Line CHart Config");
  }

  beforeUpdate(() => {
    if (data.length > 0 && document.getElementById(id) !== null) {
      createChart();
      chart.data.datasets = getDataset(data);
      chart.update();
    }
  });

  function getDataset(data) {
    if (data.length > 0 && document.getElementById(id) !== null) {
      data.forEach((reading, i) => {
        let current = all[i];
        if (current == undefined) {
          current = {};
          current.fill = false;
          setColors(current);
          current.data = [];
          all[i] = current;
        }
        current.label = reading.label.desc;
        current.data.push(reading.value);
      });
    }
    return all;
  }

  function setColors(config) {
    let r = Math.round(Math.random() * 127) + 127;
    let g = Math.round(Math.random() * 127) + 127;
    let b = Math.round(Math.random() * 127) + 127;
    config.backgroundColor = `rgba(${r},${g},${b}, 0.5)`;
    config.borderColor = `rgba(${r},${g},${b}, 1)`;
  }

  function createChart() {
    if (chart === undefined) {
      ctx = document.getElementById(id).getContext("2d");

      chart = new Chart(ctx, {
        type: "line",
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
          maintainAspectRatio: false,
          fill: false
        }
      });
    }
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
