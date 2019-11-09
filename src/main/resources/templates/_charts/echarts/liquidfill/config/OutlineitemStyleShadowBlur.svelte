<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let outlineitemStyleShadowBlur;

  $: if (outlineitemStyleShadowBlur) {
    dispatch("outlineitemStyleShadowBlur", outlineitemStyleShadowBlur);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider
      bind:value={outlineitemStyleShadowBlur}
      min={-1}
      max={200}
      step={1}
      discrete
      displayMarkers />
    <span
      slot="label"
      title="current value: {outlineitemStyleShadowBlur}"
      style="padding-right: 12px; width: max-content; display: block;">
      Outline shadow blur size
    </span>
  </FormField>
</div>
