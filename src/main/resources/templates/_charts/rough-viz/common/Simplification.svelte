<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  export let simplification;
  const dispatch = createEventDispatcher();

  $: if (simplification) {
    dispatch("simplification", simplification);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={simplification} min={0} max={1} />
    <span
      slot="label"
      title="current value: {simplification}"
      style="padding-right: 12px; width: max-content; display: block;">
      Simplification
    </span>
  </FormField>
</div>
