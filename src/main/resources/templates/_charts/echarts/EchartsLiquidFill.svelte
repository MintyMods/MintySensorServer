<script>
  // Echarts Liquid Fill release 2.0.5
  // https://github.com/ecomfe/echarts-liquidfill
  import { onMount } from "svelte";

  export let data;
  let chart;
  let container;
  let readings;
  let option;
  $: data;
  $: container;
  
  export function showConfig() {
    alert("EChart Config");
  }


  onMount(() => {
    container = document.getElementById("guage");
    if (option === undefined) {
      option = {
        series: [
          {
            type: "liquidFill",
            data: [0.6, 0.5, 0.4, 0.3],
            amplitude: 0,
            waveAnimation: 0,
            silent: true,
            color: ["#294D99", "#156ACF", "#1598ED", "#45BDFF"], //Wave colors.
            center: ["50%", "50%"],
            radius: "50%",
            amplitude: "8%",
            waveLength: "80%",
            phase: "auto",
            period: "auto",
            direction: "right",
            shape: "roundRect",
            waveAnimation: true,
            animationEasing: "linear",
            animationEasingUpdate: "linear",
            animationDuration: 2000,
            animationDurationUpdate: 1000,
            outline: {
              show: true,
              borderDistance: 4,
              itemStyle: {
                color: "none",
                borderColor: "rgba(21,137,200,0.5)",
                borderWidth: 6,
                shadowBlur: 0,
                shadowColor: "rgba(0, 0, 0, 0.25)"
              }
            },
            backgroundStyle: {
              color: "#E3F7FF"
            },
            itemStyle: {
              opacity: 0.2,
              shadowBlur: 0,
              shadowColor: "rgba(0, 0, 0, 0.1)"
            },
            label: {
              show: true,
              color: "#294D99",
              insideColor: "#fff",
              fontSize: 25,
              fontWeight: "bold",
              align: "center",
              baseline: "middle",
              position: "inside"
            },
            emphasis: {
              itemStyle: {
                opacity: 0.8
              }
            }
          }
        ]
      };
    }

    if (chart === undefined) {
      chart = echarts.init(container);
    }
    chart.setOption(option);
  });
</script>

<style>
.guage {
  display:inline-block;
  width:100%;
  height:100%;

}
</style>

<div id="guage" class="guage" />
