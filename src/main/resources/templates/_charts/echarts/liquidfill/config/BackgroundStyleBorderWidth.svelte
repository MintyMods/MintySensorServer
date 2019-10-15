<script>
  import { createEventDispatcher } from "svelte";
  import { onMount, tick } from "svelte";
  import { MDCSlider } from "@material/slider";
  import { MDCDialog } from "@material/dialog";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let backgroundStyleBorderWidth;

  onMount(async () => {
    await tick();
    const dialog = new MDCDialog(document.querySelector(".mdc-dialog"));
    const slider = new MDCSlider(document.querySelector(".mdc-slider"));
    dialog.listen("MDCDialog:opened", () => {
      slider.layout();
    });
  });

  $: if (backgroundStyleBorderWidth) {
    dispatch("backgroundStyleBorderWidth", backgroundStyleBorderWidth);
  }
</script>

<div class="slider">
  <FormField align="end" style="display: flex;">
    <Slider
      bind:value={backgroundStyleBorderWidth}
      min={-1}
      max={100}
      step={1}
      discrete
      displayMarkers />
    <span
      slot="label"
      title="current value: {backgroundStyleBorderWidth}"
      style="padding-right: 12px; width: max-content; display: block;">
      Background border width
    </span>
  </FormField>
</div>
