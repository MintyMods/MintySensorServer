<script>
  import "./_scss/_navigation.scss";
  import Logo from "./Logo.svelte";
    import { storeIsNavigationOpen } from "../_stores/main-state.js";

  import Drawer, {
    AppContent,
    Content,
    Header,
    Title,
    Subtitle,
    Scrim
  } from "@smui/drawer";
  import List, { Item, Text, Graphic, Separator, Subheader } from "@smui/list";

  let active = "home";
  export let segment;
  let closeHover;
  let menuHover;

  function setActive(value) {
    active = value;
    $storeIsNavigationOpen = false;
  }
</script>

<Header>
  <Logo />
</Header>
<Content>
  <List>
    <Item
      href="#/"
      on:click={() => setActive('home')}
      activated={active === 'home'}>
      <Graphic class="fa-fw fad fa-home fa-2x" />
      <Text>Home</Text>
    </Item>
    <Item
      href="#/about"
      on:click={() => setActive('about')}
      activated={active === 'about'}>
      <Graphic class="fa-fw fad fa-question fa-2x" />
      <Text>About</Text>
    </Item>
    <Item
      href="#/views"
      on:click={() => setActive('views')}
      activated={active === 'views'}>
      <Graphic class="fa-fw fad fa-eye fa-2x" />
      <Text>Views</Text>
    </Item>
    <Item
      href="#/sensors"
      on:click={() => setActive('sensors')}
      activated={active === 'sensors'}>
      <Graphic class="fa-fw fad fa-compress-arrows-alt fa-2x" />
      <Text>Sensors</Text>
    </Item>
    <Item
      href="#/readings"
      on:click={() => setActive('readings')}
      activated={active === 'readings'}>
      <Graphic class="fa-fw fad fa-tachometer-alt-average fa-2x" />
      <Text>Readings</Text>
    </Item>
    <Item
      href="#/devices"
      on:click={() => setActive('devices')}
      activated={active === 'devices'}>
      <Graphic class="fa-fw fad fa-digital-tachograph fa-2x" />
      <Text>Devices</Text>
    </Item>
    <Item
      href="#/hosts"
      on:click={() => setActive('hosts')}
      activated={active === 'hosts'}>
      <Graphic class="fa-fw fad fa-network-wired fa-2x" />
      <Text>Hosts</Text>
    </Item>
    <Item
      href="#/providers"
      on:click={() => setActive('providers')}
      activated={active === 'providers'}>
      <Graphic class="fa-fw fad fa-podcast fa-2x" />
      <Text>Providers</Text>
    </Item>
    <Item
      href="#/settings"
      on:click={() => setActive('settings')}
      activated={active === 'settings'}>
      <Graphic class="fa-fw fad fa-user-cog fa-2x" />
      <Text>Settings</Text>
    </Item>
    <Item
      href="#/notifications"
      on:click={() => setActive('notifications')}
      activated={active === 'notifications'}>
      <Graphic class="fa-fw fad fa-bell fa-2x" />
      <Text>Notifications</Text>
    </Item>
    <Item
      href="#/testing"
      on:click={() => setActive('testing')}
      activated={active === 'testing'}>
      <Graphic class="fa-fw fad fa-vial fa-2x" />
      <Text>Testing</Text>
    </Item>
    <Item
      href="#/chat"
      on:click={() => setActive('testing')}
      activated={active === 'client'}>
      <Graphic class="fad fa-comments-alt fa-2x" />
      <Text>Chat</Text>
    </Item>
  </List>
</Content>
