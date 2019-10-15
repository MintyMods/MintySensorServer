<script>
  import { createEventDispatcher } from "svelte";
  import Select, { Option } from "@smui/select";
  import HelperText from "@smui/textfield/helper-text/index";
  import { EASING } from "./constants.js";

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
    <Option value={easing} selected={animationEasingUpdate === easing}>
      {easing}
    </Option>
  {/each}
</Select>
<HelperText>chart value & position changes</HelperText>
