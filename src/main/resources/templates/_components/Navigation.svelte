<script>
  import "./_scss/_navigation.scss";
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

  import { Router, Link, Route, navigate } from "svelte-routing";
  import { ROUTES } from "./sitemap.js";
  import About from "../_routes/Index.svelte";
  import Views from "../_routes/Views.svelte";
  import Settings from "../_routes/Settings.svelte";
  import Sensors from "../_routes/Sensors.svelte";
  import Readings from "../_routes/Readings.svelte";
  import Providers from "../_routes/Providers.svelte";
  import Notifications from "../_routes/Notifications.svelte";
  import Hosts from "../_routes/Hosts.svelte";
  import Devices from "../_routes/Devices.svelte";
  import NotFound from "../_errors/NotFound.svelte";
  import Error from "../_routes/_error.svelte";

  let closeHover;
  let menuHover;
  let active;
  //$: active = location;

  afterUpdate(async () => {
    await tick();
    //active = location.hash;
    //setActiveNavigationSection(active);
  });

  function setActive(route) {
    active = route;
    navigate(route.path, { replace: true });
    $storeIsNavigationOpen = false;
    setActiveNavigationSection();
  }

  function isActive(route) {
    return true;
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
      let page = "#"; //@todo
      sections.forEach(section => {
        if (section === page) {
          section.classList.add("mdc-list-item--activated");
        } else {
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
    {#each ROUTES as route}
      <Item
        href={route.path}
        class="list-item"
        on:click={() => setActive(route)}
        activated={() => isActive(route)}>
        <Graphic class={route.icon} />
        <Text>{route.desc}</Text>
      </Item>
    {/each}
  </List>
</Content>
