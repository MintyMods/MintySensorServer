<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let itemStyleShadowBlur;

  $: if (itemStyleShadowBlur) {
    dispatch("itemStyleShadowBlur", itemStyleShadowBlur);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider
      bind:value={itemStyleShadowBlur}
      min={0}
      max={25}
      step={1}
      discrete
      displayMarkers />
    <span
      slot="label"
      title="current value: {itemStyleShadowBlur}"
      style="padding-right: 12px; width: max-content; display: block;">
      Wave shadow blur size
    </span>
  </FormField>
</div>
