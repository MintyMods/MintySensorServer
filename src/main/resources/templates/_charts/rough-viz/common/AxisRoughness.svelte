<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  export let axisRoughness;
  const dispatch = createEventDispatcher();

  $: if (axisRoughness) {
    dispatch("axisRoughness", axisRoughness);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={axisRoughness} min={0} max={20} />
    <span
      slot="label"
      title="current value: {axisRoughness}"
      style="padding-right: 12px; width: max-content; display: block;">
      Roughness for X & Y axes
    </span>
  </FormField>
</div>
