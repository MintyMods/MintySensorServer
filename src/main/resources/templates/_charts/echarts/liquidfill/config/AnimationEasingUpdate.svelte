<script>
  import { createEventDispatcher } from "svelte";
  import { EASING } from "./constants.js";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";

  const dispatch = createEventDispatcher();
  export let animationEasingUpdate;

  $: if (animationEasingUpdate) {
    dispatch("animationEasingUpdate", animationEasingUpdate);
  }
</script>

<Select
  enhanced
  bind:value={animationEasingUpdate}
  label="Animation Easing Update (value & position changes)">
  {#each EASING as easing}
    <Option
      value={easing.type}
      selected={easing.type === animationEasingUpdate}>
      {easing.desc}
    </Option>
  {/each}
</Select>
<HelperText>chart value & position changes</HelperText>
