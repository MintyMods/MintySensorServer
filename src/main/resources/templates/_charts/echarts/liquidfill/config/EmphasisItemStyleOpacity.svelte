<script>
  import { emphasisItemStyleOpacity } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    emphasisItemStyleOpacityValue = $emphasisItemStyleOpacity;
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    const slider = new MDCSlider(document.querySelector(".mdc-slider"));
    dialog.listen("MDCDialog:opened", () => {
      slider.layout();
    });
  });

  let emphasisItemStyleOpacityValue = "";
  $: if (emphasisItemStyleOpacityValue) {
    $emphasisItemStyleOpacity = emphasisItemStyleOpacityValue;
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={emphasisItemStyleOpacityValue} min={0} max={1} />
    <span
      slot="label"
      title="current value: {emphasisItemStyleOpacityValue}"
      style="padding-right: 12px; width: max-content; display: block;">
      Wave hover opacity
    </span>
  </FormField>
</div>
