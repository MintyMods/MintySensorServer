<script>
  import { createEventDispatcher } from "svelte";
  import { FONT_FAMILY } from "./constants.js";
  import Select, { Option } from "@smui/select";

  export let font;
  const dispatch = createEventDispatcher();

  $: if (font) {
    dispatch("font", font);
  }
</script>

<Select enhanced bind:value={font} label="Font family">
  {#each FONT_FAMILY as family}
    <Option value={family.type} selected={family.type === font}>
      {family.desc}
    </Option>
  {/each}
</Select>
