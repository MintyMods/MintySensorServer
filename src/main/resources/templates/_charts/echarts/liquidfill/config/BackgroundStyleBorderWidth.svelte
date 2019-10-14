<script>
  import { backgroundStyleBorderWidth } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    backgroundStyleBorderWidthValue = $backgroundStyleBorderWidth;
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    const slider = new MDCSlider(document.querySelector(".mdc-slider"));
    dialog.listen("MDCDialog:opened", () => {
      slider.layout();
    });
  });

  let backgroundStyleBorderWidthValue = "";
  $: if (backgroundStyleBorderWidthValue) {
    $backgroundStyleBorderWidth = backgroundStyleBorderWidthValue;
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider
      bind:value={backgroundStyleBorderWidthValue}
      min={-1}
      max={100}
      step={1}
      discrete
      displayMarkers />
    <span
      slot="label"
      title="current value: {backgroundStyleBorderWidthValue}"
      style="padding-right: 12px; width: max-content; display: block;">
      Background border width
    </span>
  </FormField>
</div>
