<script>
  import { itemStyleShadowBlur } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";

  onMount(async () => {
    await tick();
    itemStyleShadowBlurValue = $itemStyleShadowBlur;
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    const slider = new MDCSlider(document.querySelector(".mdc-slider"));
    dialog.listen("MDCDialog:opened", () => {
      slider.layout();
    });
  });

  let itemStyleShadowBlurValue = "";

  function update() {
    $itemStyleShadowBlur = itemStyleShadowBlurValue;
  }
</script>

<div class="slider">

  <FormField align="end" style="display: flex;">

    <Slider
      bind:value={itemStyleShadowBlurValue}
      min={0}
      max={25}
      step={1}
      discrete
      displayMarkers />
    <span
      slot="label"
      style="padding-right: 12px; width: max-content; display: block;">
      Wave Shadow Blur Size
    </span>
  </FormField>

</div>
