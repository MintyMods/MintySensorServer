<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let backgroundStyleItemStyleShadowBlur;

  $: if (backgroundStyleItemStyleShadowBlur) {
    dispatch(
      "backgroundStyleItemStyleShadowBlur",
      backgroundStyleItemStyleShadowBlur
    );
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider
      bind:value={backgroundStyleItemStyleShadowBlur}
      min={-1}
      max={250}
      step={1}
      discrete
      displayMarkers />
    <span
      slot="label"
      title="current value: {backgroundStyleItemStyleShadowBlur}"
      style="padding-right: 12px; width: max-content; display: block;">
      Background shadow blur size
    </span>
  </FormField>
</div>
