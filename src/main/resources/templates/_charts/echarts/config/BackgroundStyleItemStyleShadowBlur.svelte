<script>
  import { backgroundStyleItemStyleShadowBlur } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";

  onMount(async () => {
    await tick();
    backgroundStyleItemStyleShadowBlurValue = $backgroundStyleItemStyleShadowBlur;
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    const slider = new MDCSlider(document.querySelector(".mdc-slider"));
    dialog.listen("MDCDialog:opened", () => {
      slider.layout();
    });
  });

  let backgroundStyleItemStyleShadowBlurValue = "";

  function update() {
    $backgroundStyleItemStyleShadowBlur = backgroundStyleItemStyleShadowBlurValue;
  }
</script>

<div class="slider">

  <FormField align="end" style="display: flex;">

    <Slider
      bind:value={backgroundStyleItemStyleShadowBlurValue}
      min={0}
      max={25}
      step={1}
      discrete
      displayMarkers />
    <span
      slot="label"
      style="padding-right: 12px; width: max-content; display: block;">
      Background Shadow Blur Size
    </span>
  </FormField>

</div>
