<script>
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
</script>

<style>
  .card-container {
    display: inline-flex;
    justify-content: center;
    align-items: center;
    min-width: 480px;
  }
  :global(.mdc-card__action--icon:not(:disabled)) {
    color: var(--theme-on-surface) !important;
    font-family: "Font Awesome 5 Pro";
  }
  :global(mdc-card-container:first-child) {
    border: 2px red !important;
  }
</style>

<div class="mdc-card-container">
  <Card>
    <PrimaryAction
      on:click={() => window.open('https://github.com/ecomfe/echarts-liquidfill')}>
      <Content class="mdc-typography--body2">
        <h2 class="mdc-typography--headline6" style="margin: 0;">
          ECharts Liquid Fill Chart
        </h2>
        <h3
          class="mdc-typography--subtitle2"
          style="margin: 0 0 10px; color: #888;">
          Baidu EFE team
        </h3>
        This component has been built using:-
        <li>Apache ECharts</li>
        <li>ecomfe/echarts-liquidfill</li>
      </Content>
    </PrimaryAction>
    <Actions>
      <ActionButtons>
        <Button
          on:click={() => window.open('https://github.com/ecomfe/echarts-liquidfill#api')}>
          <Label>Docs / API</Label>
        </Button>
        <Button
          on:click={() => window.open('https://github.com/ecomfe/echarts-liquidfill#examples')}>
          <Label>Examples</Label>
        </Button>
      </ActionButtons>
      <ActionIcons>
        <IconButton
          title="Apache ECharts GitHub page"
          on:click={() => window.open('https://github.com/apache/incubator-echarts')}>
          <i class="fab fa-github-square" />
        </IconButton>
        <IconButton
          title="ECharts Liquid Fill GitHub page"
          on:click={() => window.open('https://github.com/ecomfe/echarts-liquidfill')}>
          <i class="fab fa-github" />
        </IconButton>
      </ActionIcons>
    </Actions>
  </Card>
</div>
