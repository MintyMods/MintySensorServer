<script>
  import { createEventDispatcher } from "svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let itemStyleOpacity;

  $: if (itemStyleOpacity) {
    dispatch("itemStyleOpacity", itemStyleOpacity);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={itemStyleOpacity} min={0} max={1} />
    <span
      slot="label"
      title="current value: {itemStyleOpacity}"
      style="padding-right: 12px; width: max-content; display: block;">
      Wave opacity
    </span>
  </FormField>
</div>
