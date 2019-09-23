<script>
  // Just Gage Release 1.3.1
  // https://github.com/toorshia/justgage

  export let data;
  export let max = 100;
  let chart;
  let readings;

  let defaults = {
    parentNode: null, //	The HTML container element object. Used if id is not present
    defaults: false, //	Defaults parameters to use globally for gauge objects
    width: null, //	The Gauge width in pixels (Integer)
    height: null, //	The Gauge height in pixels
    valueFontColor: "rgba(199,201,203,0.88)", //	Color of label showing current value
    valueFontFamily:
      "-apple-system, BlinkMacSystemFont, Roboto, Oxygen-Sans, Ubuntu, Cantarell, Helvetica Neue, sans-serif", //	Font of label showing current value
    symbol: "", //	Special symbol to show next to value
    min: 0, //	Min value
    minTxt: false, //	Min value text, overrides min if specified
    //max: 100, //	Max value
    maxTxt: false, //	Max value text, overrides max if specified
    reverse: false, //	Reverse min and max
    humanFriendlyDecimal: 0, //	Number of decimal places for our human friendly number to contain
    textRenderer: null, //	Function applied before redering text (value) => value
    onAnimationEnd: null, //	Function applied after animation is done
    gaugeWidthScale: 1.0, //	Width of the gauge element
    gaugeColor: "#edebeb", //	Background color of gauge element
    labelFontColor: "#b3b3b3", //	Color of label showing label under value
    shadowOpacity: 0.2, //	Shadow opacity 0 ~ 1
    shadowSize: 5, //	Inner shadow size
    shadowVerticalOffset: 3, //	How much shadow is offset from top
    levelColors: ["#a9d70b", "#f9c802", "#ff0000"], //	Colors of indicator, from lower to upper, in RGB format
    startAnimationTime: 700, //	Length of initial animation in milliseconds
    startAnimationType: ">", //Type of initial animation (linear, >, <, <>, bounce)
    refreshAnimationTime: 500, //	Length of refresh animation in milliseconds
    refreshAnimationType: ">", //	Type of refresh animation (linear, >, <, <>, bounce)
    donutStartAngle: 90, //	Angle to start from when in donut mode
    valueMinFontSize: 16, //	Absolute minimum font size for the value label
    labelMinFontSize: 10, //	Absolute minimum font size for the label
    minLabelMinFontSize: 10, //	Absolute minimum font size for the min label
    maxLabelMinFontSize: 10, //	Absolute minimum font size for the man label
    hideValue: false, //Hide value text
    hideMinMax: false, //	Hide min/max text
    showInnerShadow: false, //	Show inner shadow
    humanFriendly: false, //	convert large numbers for min, max, value to human friendly (e.g. 1234567 -> 1.23M)
    noGradient: false, //	Whether to use gradual color change for value, or sector-based
    donut: false, //	Show donut gauge
    relativeGaugeSize: true, //	Whether gauge size should follow changes in container element size
    counter: true, //	Animate text value number change
    decimals: 0, //Number of digits after floating point
    customSectors: {}, //Custom sectors colors. Expects an object
    formatNumber: false, //Formats numbers with commas where appropriate
    pointer: false, //Show value pointer
    pointerOptions: {}, //	Pointer options. Expects an object
    displayRemaining: false //	Replace display number with the value remaining to reach max value
  };

  $: if (data && document.getElementById(data.id + "_" + data.index) !== null) {
    if (chart === undefined) {
      let id = data.id + "_" + data.index;
      let ele = document.getElementById(id);
      if (ele && chart === undefined) {
        chart = new JustGage({
          id,
          defaults,
          value: data.value,
          title: data.label.desc,
          label: data.unit,
          max:max
        });
      }
    }

    if (chart !== undefined) {
      chart.refresh(data.value, null, null, data.label.desc);
      chart.config.label = data.unit;
    }
  }
</script>

<style>
  .gauge {
    width: 100%;
    height: 100%;
  }
</style>

{#if data}
  <div id={data.id + '_' + data.index} class="gauge" />
{/if}
