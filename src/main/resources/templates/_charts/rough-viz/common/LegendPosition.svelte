<script>
  import { createEventDispatcher } from "svelte";
  import { POSITION } from "./constants.js";
  import Select, { Option } from "@smui/select";

  export let legendPosition;
  const dispatch = createEventDispatcher();

  $: if (legendPosition) {
    dispatch("legendPosition", legendPosition);
  }
</script>

<Select enhanced bind:value={legendPosition} label="Legend position">
  {#each POSITION as position (position.type)}
    <Option value={position.type} selected={position.type === legendPosition}>
      {position.desc}
    </Option>
  {/each}
</Select>
