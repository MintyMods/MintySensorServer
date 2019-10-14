<script>
  import { backgroundStyleItemStyleOpacity } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    backgroundStyleItemStyleOpacityValue = $backgroundStyleItemStyleOpacity;
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    const slider = new MDCSlider(document.querySelector(".mdc-slider"));
    dialog.listen("MDCDialog:opened", () => {
      slider.layout();
    });
  });

  let backgroundStyleItemStyleOpacityValue = "";
  $: if (backgroundStyleItemStyleOpacityValue) {
    $backgroundStyleItemStyleOpacity = backgroundStyleItemStyleOpacityValue;
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={backgroundStyleItemStyleOpacityValue} min={-1} max={1} />
    <span
      slot="label"
      title="current value: {backgroundStyleItemStyleOpacityValue}"
      style="padding-right: 12px; width: max-content; display: block;">
      Background opacity
    </span>
  </FormField>
</div>
