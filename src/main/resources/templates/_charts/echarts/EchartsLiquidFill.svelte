<script>
  // Echarts Liquid Fill release 2.0.5
  // https://github.com/ecomfe/echarts-liquidfill
  import { onDestroy, onMount, } from "svelte";
  import { watchResize } from "svelte-watch-resize";
  import EchartsLiquidFillConfig from "./EchartsLiquidFillConfig.svelte";
  import { shape, direction } from "../../_stores/echarts-liquid-fill-store.js";

  export let data;
  export let options;
  const id =
    "mss_" +
    Math.random()
      .toString(36)
      .substr(2, 9);
  let chart;
  let config;

  $: refreshChart(data);

  onMount(() => {
    chart = echarts.init(document.getElementById(id));
  });

  onDestroy(() => {
    chart.dispose();
  });

  function refreshChart(data) {
    if (data !== undefined) {
      if (chart !== undefined) {
        chart.setOption(getOptions());
      }
    }
  }

  function resizeChart(node) {
    const canvas = getCanvas();
    if (canvas !== null) {
      canvas.width = node.clientWidth;
      canvas.height = node.clientheight;
      chart.resize();
    }
  }

  function getCanvas() {
    return document
      .getElementById(id)
      .querySelectorAll("canvas")
      .item(0);
  }

  export const showConfig = () => {
    config.openDialog(options, data);
  };

  export const hideConfig = () => {
    dialog.closeDialog();
  };

  function getOptions() {
    return {
      series: [
        {
          type: "liquidFill",
          data: [data.value],
          options: {
            responsive: false
          },
          silent: true,
          phase: "auto",
          shape:"roundRect",
          // -----------------

          // amplitude: 0,
          // waveAnimation: 0,
          // color: ["#294D99"], //Wave colors., "#156ACF", "#1598ED", "#45BDFF"
          // center: ["50%", "50%"],
          // radius: "50%",
          // amplitude: "8%",
          // waveLength: "80%",
          // period: "auto",
          // direction: "right",
          // shape: shape,
          // waveAnimation: true,
          // animationEasing: "linear",
          // animationEasingUpdate: "linear",
          // animationDuration: 2000,
          // animationDurationUpdate: 1000,
          // outline: {
          //   show: true,
          //   borderDistance: 1,
          //   itemStyle: {
          //     color: "none",
          //     borderColor: "rgba(21,137,200,0.5)",
          //     borderWidth: 6,
          //     shadowBlur: 0,
          //     shadowColor: "rgba(0, 0, 0, 0.25)"
          //   }
          // },
          // backgroundStyle: {
          //   color: "#E3F7FF"
          // },
          // itemStyle: {
          //   opacity: 0.2,
          //   shadowBlur: 0,
          //   shadowColor: "rgba(0, 0, 0, 0.1)"
          // },
          // label: {
          //   show: true,
          //   color: "#294D99",
          //   insideColor: "#fff",
          //   fontSize: 15,
          //   fontWeight: "bold",
          //   align: "center",
          //   baseline: "middle",
          //   position: "inside"
          // },
          // emphasis: {
          //   itemStyle: {
          //     opacity: 0.8
          //   }
          // }
        }
      ]
    };
  }
</script>

<style>
  .guage {
    display: block;
    width: 100%;
    height: 100%;
    transform: scale(1.7);
  }
</style>

<div {id} class="guage" use:watchResize={resizeChart} />

<EchartsLiquidFillConfig bind:this={config} {data} />
