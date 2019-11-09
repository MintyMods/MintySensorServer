<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  export let axisStrokeWidth;
  const dispatch = createEventDispatcher();

  $: if (axisStrokeWidth) {
    dispatch("axisStrokeWidth", axisStrokeWidth);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={axisStrokeWidth} min={0} max={50} />
    <span
      slot="label"
      title="current value: {axisStrokeWidth}"
      style="padding-right: 12px; width: max-content; display: block;">
      Stroke-width for X & Y axes
    </span>
  </FormField>
</div>
