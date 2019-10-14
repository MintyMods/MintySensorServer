<script>
  import { outlineBorderDistance } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    outlineBorderDistanceValue = $outlineBorderDistance;
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    const slider = new MDCSlider(document.querySelector(".mdc-slider"));
    dialog.listen("MDCDialog:opened", () => {
      slider.layout();
    });
  });

  let outlineBorderDistanceValue = "";
  $: if (outlineBorderDistanceValue) {
    $outlineBorderDistance = outlineBorderDistanceValue;
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider
      bind:value={outlineBorderDistanceValue}
      min={-1}
      max={100}
      step={1}
      discrete
      displayMarkers />
    <span
      slot="label"
      title="current value: {outlineBorderDistanceValue}"
      style="padding-right: 12px; width: max-content; display: block;">
      Outline border distance
    </span>
  </FormField>
</div>
