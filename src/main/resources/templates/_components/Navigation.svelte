<script>
  // import "./_scss/_navigation.scss";
  import Logo from "./Logo.svelte";
  import {
    storeIsNavigationOpen,
    storeActivePageHash
  } from "../_stores/main-state.js";
  import { onMount, afterUpdate, tick } from "svelte";
  import Drawer, {
    AppContent,
    Content,
    Header,
    Title,
    Subtitle,
    Scrim
  } from "@smui/drawer";
  import List, { Item, Text, Graphic, Separator, Subheader } from "@smui/list";
  import { location } from "svelte-spa-router";

  const ABOUT = "#/about";
  const VIEWS = "#/views";
  const SENSORS = "#/sensors";
  const READINGS = "#/readings";
  const DEVICES = "#/devices";
  const HOSTS = "#/hosts";
  const PROVIDERS = "#/providers";
  const SETTINGS = "#/settings";
  const NOTIFICATIONS = "#/notifications";

  export let segment;
  let closeHover;
  let menuHover;
  let active;
  //$: active = location;

  $: if (location !== undefined) {
    setActiveNavigationSection(location.hash);
  }

  afterUpdate(async () => {
    await tick();
    active = location.hash;
    setActiveNavigationSection(active);
  });

  function setActive(hash) {
    active = hash;
    $storeIsNavigationOpen = false;
    setActiveNavigationSection(hash);
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

  function setActiveNavigationSection() {
    let nav = document.getElementById("navigation");
    if (nav !== null) {
      let sections = nav.querySelectorAll("a");
      let page = '#' + $location;
      if (page === '#/') page = '#/about';
      sections.forEach(section => {
        if (section.hash === page) {
          // section.classList.add("activated");
          section.classList.add("mdc-list-item--activated");
        } else {
          // section.classList.remove("activated");
          section.classList.remove("mdc-list-item--activated");
        }
      });
    }
  }
</script>

<Header>
  <Logo />
</Header>
<Content>
  <List id="navigation">
    <Item
      href={ABOUT}
      class="list-item"
      on:click={() => setActive(ABOUT)}
      activated={active === ABOUT}>
      <Graphic class="fa-fw fad fa-question fa-2x" />
      <Text>About</Text>
    </Item>
    <Item
      href={VIEWS}
      class="list-item"
      on:click={() => setActive(VIEWS)}
      activated={active === VIEWS}>
      <Graphic class="fa-fw fad fa-eye fa-2x" />
      <Text>Views</Text>
    </Item>
    <Item
      href={SENSORS}
      class="list-item"
      on:click={() => setActive(SENSORS)}
      activated={active === SENSORS}>
      <Graphic class="fa-fw fad fa-compress-arrows-alt fa-2x" />
      <Text>Sensors</Text>
    </Item>
    <Item
      href={READINGS}
      class="list-item"
      on:click={() => setActive(READINGS)}
      activated={active === READINGS}>
      <Graphic class="fa-fw fad fa-tachometer-alt-average fa-2x" />
      <Text>Readings</Text>
    </Item>
    <Item
      href={DEVICES}
      class="list-item"
      on:click={() => setActive(DEVICES)}
      activated={active === DEVICES}>
      <Graphic class="fa-fw fad fa-digital-tachograph fa-2x" />
      <Text>Devices</Text>
    </Item>
    <Item
      href={HOSTS}
      class="list-item"
      on:click={() => setActive(HOSTS)}
      activated={active === HOSTS}>
      <Graphic class="fa-fw fad fa-network-wired fa-2x" />
      <Text>Hosts</Text>
    </Item>
    <Item
      href={PROVIDERS}
      class="list-item"
      on:click={() => setActive(PROVIDERS)}
      activated={active === PROVIDERS}>
      <Graphic class="fa-fw fad fa-podcast fa-2x" />
      <Text>Providers</Text>
    </Item>
    <Item
      href={SETTINGS}
      class="list-item"
      on:click={() => setActive(SETTINGS)}
      activated={active === SETTINGS}>
      <Graphic class="fa-fw fad fa-user-cog fa-2x" />
      <Text>Settings</Text>
    </Item>
    <Item
      href={NOTIFICATIONS}
      class="list-item"
      on:click={() => setActive(NOTIFICATIONS)}
      activated={active === NOTIFICATIONS}>
      <Graphic class="fa-fw fad fa-bell fa-2x" />
      <Text>Notifications</Text>
    </Item>
  </List>
</Content>
