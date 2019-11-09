<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let backgroundStyleBorderWidth;

  $: if (backgroundStyleBorderWidth) {
    dispatch("backgroundStyleBorderWidth", backgroundStyleBorderWidth);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider
      bind:value={backgroundStyleBorderWidth}
      min={-1}
      max={100}
      step={1}
      discrete
      displayMarkers />
    <span
      slot="label"
      title="current value: {backgroundStyleBorderWidth}"
      style="padding-right: 12px; width: max-content; display: block;">
      Background border width
    </span>
  </FormField>
</div>
