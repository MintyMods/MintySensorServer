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

  $: if ($storeIsNavigationOpen) {
    let content = document.getElementById("main-content");
    if (content !== null) {
      content.classList.add("main-container-open");
      content.classList.remove("main-container-closed");
    }
  } else {
    let content = document.getElementById("main-content");
    if (content !== null) {
      content.classList.remove("main-container-open");
      content.classList.add("main-container-closed");
    }
  }
</script>

<Header>
  <Logo />
</Header>
<Content>
  <List id="navigation">
    <Item
      href="#/"
      class="list-item"
      on:click={() => setActive('about')}
      activated={active === 'about'}>
      <Graphic class="fa-fw fad fa-question fa-2x" />
      <Text>About</Text>
    </Item>

    <Item
      href="#/views"
      class="list-item"
      on:click={() => setActive('views')}
      activated={active === 'views'}>
      <Graphic class="fa-fw fad fa-eye fa-2x" />
      <Text>Views</Text>
    </Item>
    <Item
      href="#/sensors"
      class="list-item"
      on:click={() => setActive('sensors')}
      activated={active === 'sensors'}>
      <Graphic class="fa-fw fad fa-compress-arrows-alt fa-2x" />
      <Text>Sensors</Text>
    </Item>
    <Item
      href="#/readings"
      class="list-item"
      on:click={() => setActive('readings')}
      activated={active === 'readings'}>
      <Graphic class="fa-fw fad fa-tachometer-alt-average fa-2x" />
      <Text>Readings</Text>
    </Item>
    <Item
      href="#/devices"
      class="list-item"
      on:click={() => setActive('devices')}
      activated={active === 'devices'}>
      <Graphic class="fa-fw fad fa-digital-tachograph fa-2x" />
      <Text>Devices</Text>
    </Item>
    <Item
      href="#/hosts"
      class="list-item"
      on:click={() => setActive('hosts')}
      activated={active === 'hosts'}>
      <Graphic class="fa-fw fad fa-network-wired fa-2x" />
      <Text>Hosts</Text>
    </Item>
    <Item
      href="#/providers"
      class="list-item"
      on:click={() => setActive('providers')}
      activated={active === 'providers'}>
      <Graphic class="fa-fw fad fa-podcast fa-2x" />
      <Text>Providers</Text>
    </Item>
    <Item
      href="#/settings"
      class="list-item"
      on:click={() => setActive('settings')}
      activated={active === 'settings'}>
      <Graphic class="fa-fw fad fa-user-cog fa-2x" />
      <Text>Settings</Text>
    </Item>
    <Item
      href="#/notifications"
      class="list-item"
      on:click={() => setActive('notifications')}
      activated={active === 'notifications'}>
      <Graphic class="fa-fw fad fa-bell fa-2x" />
      <Text>Notifications</Text>
    </Item>
  </List>
</Content>
