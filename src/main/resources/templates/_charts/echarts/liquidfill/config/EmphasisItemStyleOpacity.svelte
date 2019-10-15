<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let emphasisItemStyleOpacity;

  onMount(async () => {
    await tick();
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    const slider = new MDCSlider(document.querySelector(".mdc-slider"));
    dialog.listen("MDCDialog:opened", () => {
      slider.layout();
    });
  });

  $: if (emphasisItemStyleOpacity) {
    dispatch("emphasisItemStyleOpacity", emphasisItemStyleOpacity);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider bind:value={emphasisItemStyleOpacity} min={0} max={1} />
    <span
      slot="label"
      title="current value: {emphasisItemStyleOpacity}"
      style="padding-right: 12px; width: max-content; display: block;">
      Wave hover opacity
    </span>
  </FormField>
</div>
