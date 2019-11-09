<script>
  import { createEventDispatcher } from "svelte";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  const FONT_WEIGHT = ["normal", "bold", "bolder", "lighter"];
  export let labelFontWeight;

  $: if (labelFontWeight) {
    dispatch("labelFontWeight", labelFontWeight);
  }
</script>

<Select enhanced bind:value={labelFontWeight} label="Label font weight">
  {#each FONT_WEIGHT as weight}
    <Option value={weight} selected={weight === labelFontWeight}>
      {weight}
    </Option>
  {/each}
</Select>
<HelperText />
