<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let outlineBorderDistance;

  $: if (outlineBorderDistance) {
    dispatch("outlineBorderDistance", outlineBorderDistance);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider
      bind:value={outlineBorderDistance}
      min={-1}
      max={100}
      step={1}
      discrete
      displayMarkers />
    <span
      slot="label"
      title="current value: {outlineBorderDistance}"
      style="padding-right: 12px; width: max-content; display: block;">
      Outline border distance
    </span>
  </FormField>
</div>
