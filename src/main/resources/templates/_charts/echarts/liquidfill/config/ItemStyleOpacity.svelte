<script>
  import { itemStyleOpacity } from "./echarts-liquid-fill-store.js";
  import { onMount, tick } from "svelte";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  onMount(async () => {
    await tick();
    itemStyleOpacityValue = $itemStyleOpacity;
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    const slider = new MDCSlider(document.querySelector(".mdc-slider"));
    dialog.listen("MDCDialog:opened", () => {
      slider.layout();
    });
  });

  let itemStyleOpacityValue = "";
  $: if (itemStyleOpacityValue) {
    $itemStyleOpacity = itemStyleOpacityValue;
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={itemStyleOpacityValue} min={0} max={1} />
    <span
      slot="label"
      title="current value: {itemStyleOpacityValue}"
      style="padding-right: 12px; width: max-content; display: block;">
      Wave opacity
    </span>
  </FormField>
</div>
