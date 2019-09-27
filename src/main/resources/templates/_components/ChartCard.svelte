<script>
  import "./_scss/_chart_card.scss";
  import Card, {
    Content,
    PrimaryAction,
    Media,
    MediaContent,
    Actions,
    ActionButtons,
    ActionIcons
  } from "@smui/card";
  import Button, { Label } from "@smui/button";
  import IconButton, { Icon } from "@smui/icon-button";
  import List, { Item, Text } from "@smui/image-list";
  import Div from "@smui/common/Div.svelte";
  import WaterTempLiquidFill from "../_samples/WaterTempLiquidFill";
  export let aspectRatio = "square";
  export let ripple = false;
  let hover = false;

</script>


<div class="grid-item">
  <Card
    style="width: 360px; position:relative;"
    on:mouseenter={() => (hover = true)}
    on:mouseleave={() => (hover = false)}>
    <div class="wrapper">
      <div id="toolbar" class:hover class="toolbar">
        <Actions>
          <ActionIcons>
            <IconButton
              {ripple}
              class="material-icons"
              on:click={() => process('CONFIG')}
              title="Edit">
              <i class="fal fa-cogs fa-fw" />
            </IconButton>
            <IconButton
              {ripple}
              on:click={() => process('NOTIFICATIONS')}
              class="material-icons"
              title="Alerts">
              <i class="fal fa-bell fa-fw" />
            </IconButton>
            <IconButton
              {ripple}
              class="material-icons"
              on:click={() => process('DELETE')}
              title="Delete">
              <i class="fal fa-trash-alt fa-fw" />
            </IconButton>
          </ActionIcons>
        </Actions>
      </div>
    </div>
    <Media class="card-media-16x9" {aspectRatio}>
      <MediaContent>
        <slot >Chart will be rendered here...</slot>
      </MediaContent>
    </Media>
  </Card>
</div>
