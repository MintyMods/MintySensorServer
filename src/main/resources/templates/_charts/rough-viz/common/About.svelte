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
  :global(.mdc-card__action--icon:not(:disabled)) {
    color: var(--theme-on-surface) !important;
    font-family: "Font Awesome 5 Pro";
  }
</style>

  <Card>
    <PrimaryAction
      on:click={() => window.open('#/about')}>
      <Content class="mdc-typography--body2">
        <h2 class="mdc-typography--headline6" style="margin: 0;">
          RoughViz Charts
        </h2>
        <h3
          class="mdc-typography--subtitle2"
          style="margin: 0 0 10px; color: #888;">
          JWilber
        </h3>
        This component has been built using:-
        <li>D3 Charts</li>
        <li>jwilber/roughViz</li>
      </Content>
    </PrimaryAction>
    <Actions>
      <ActionButtons>
        <Button
          on:click={() => window.open('https://github.com/jwilber/roughViz#api')}>
          <Label>Docs / API</Label>
        </Button>
        <Button
          on:click={() => window.open('https://github.com/jwilber/roughViz#features')}>
          <Label>Examples</Label>
        </Button>
      </ActionButtons>
      <ActionIcons>
        <IconButton
          title="D3 Charts GitHub page"
          on:click={() => window.open('https://d3js.org/')}>
          <i class="fab fa-github-square" />
        </IconButton>
        <IconButton
          title="RoughViz GitHub page"
          on:click={() => window.open('https://github.com/jwilber/roughViz')}>
          <i class="fab fa-github" />
        </IconButton>
      </ActionIcons>
    </Actions>
  </Card>
