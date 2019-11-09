<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let backgroundStyleItemStyleOpacity;

  $: if (backgroundStyleItemStyleOpacity) {
    dispatch(
      "backgroundStyleItemStyleOpacity",
      backgroundStyleItemStyleOpacity
    );
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={backgroundStyleItemStyleOpacity} min={-1} max={1} />
    <span
      slot="label"
      title="current value: {backgroundStyleItemStyleOpacity}"
      style="padding-right: 12px; width: max-content; display: block;">
      Background opacity
    </span>
  </FormField>
</div>
