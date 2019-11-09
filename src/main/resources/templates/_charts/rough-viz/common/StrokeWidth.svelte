<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  export let strokeWidth;
  const dispatch = createEventDispatcher();

  $: if (strokeWidth) {
    dispatch("strokeWidth", strokeWidth);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={strokeWidth} min={1} max={50} />
    <span
      slot="label"
      title="current value: {strokeWidth}"
      style="padding-right: 12px; width: max-content; display: block;">
      Size of lines
    </span>
  </FormField>
</div>
