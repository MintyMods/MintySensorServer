<script>
  import "./minty-client-app.scss";
  import Hamburger from "./_components/Hamburger.svelte";
  import Navigation from "./_components/Navigation.svelte";
  import Drawer, {
    AppContent,
    Content,
    Header,
    Title,
    Subtitle,
    Scrim
  } from "@smui/drawer";
  import {
    storeIsNavigationOpen,
    storeReadings,
    storeSensors,
    storeTypes,
    storeDemoCurrentJsonFile
  } from "./_stores/main-state.js";
  import { onMount, onDestroy, beforeUpdate } from "svelte";
  import Router, { link, location } from "svelte-spa-router";

  import Views from "./_routes/Views.svelte";
  import Testing from "./_routes/Testing.svelte";
  import Test from "./_routes/Test.svelte";
  import Settings from "./_routes/Settings.svelte";
  import Sensors from "./_routes/Sensors.svelte";
  import Readings from "./_routes/Readings.svelte";
  import Providers from "./_routes/Providers.svelte";
  import Notifications from "./_routes/Notifications.svelte";
  import Home from "./_routes/Index.svelte";
  import Hosts from "./_routes/Hosts.svelte";
  import Devices from "./_routes/Devices.svelte";
  import About from "./_routes/About.svelte";
  import Chat from "./_routes/Client.svelte";
  import ViewBuilder from "./_samples/ViewBuilder.svelte";
  import NotFound from "./_routes/_error.svelte";

  const routes = {
    "/test": Test,
    "/testing": Testing,
    "/settings": Settings,
    "/sensors": Sensors,
    "/readings": Readings,
    "/providers": Providers,
    "/notifications": Notifications,
    "/views": Views,
    "/hosts": Hosts,
    "/devices": Devices,
    "/about": About,
    "/index": Home,
    "/chat": Chat,
    "/builder": ViewBuilder,
    "/": Home,
    "*": NotFound
  };

  let sideNavOpen;
  let sideNav;
  let active = "index";
  let mainContent;
  let stompClient = null;
  let readings = [];
  let sensors = [];
  let types = [];
  let demoModeActive = true; // @todo TURN OFF demo mode
  let demoTickCount = 0;
  $: demoTickCount = $storeDemoCurrentJsonFile;

  onMount(() => {
    subscribeToStores();
    subscribeToServerEvents();
  });

  onDestroy(() => {
    unsubscribeNavigation();
    unsubscribeReadings();
    unsubscribeSensors();
    unsubscribeTypes();
  });

  function subscribeToStores() {
    const unsubscribeNavigation = storeIsNavigationOpen.subscribe(value => {
      sideNavOpen = value;
    });
    const unsubscribeReadings = storeReadings.subscribe(value => {
      readings = value;
    });
    const unsubscribeSensors = storeSensors.subscribe(value => {
      sensors = value;
    });
    const unsubscribeTypes = storeTypes.subscribe(value => {
      types = value;
    });
  }

  function subscribeToServerEvents() {
    const socket = new SockJS("https://localhost:8080/ws");
    stompClient = Stomp.over(socket);
    stompClient.debug = () => {};
    stompClient.connect({}, onConnected, onError);
  }

  function setActive(value) {
    active = value;
    storeIsNavigationOpen.set(!sideNavOpen);
  }

  function onConnected() {
    stompClient.subscribe("/events/event", onEventReceived);
    stompClient.send("/app/api.events", {}, {});
  }

  function onEventReceived(payload) {
    demoModeActive = false;
    let message = JSON.parse(payload.body);
    let content = JSON.parse(message.json);
    storeReadings.set(content.readings);
    storeSensors.set(content.sensors);
    storeTypes.set(getTypes());
  }

  let nocache = new Headers();
  nocache.append("pragma", "no-cache");
  nocache.append("cache-control", "no-cache");

  let init = {
    method: "GET",
    headers: nocache
  };

  beforeUpdate(() => {
    if (demoModeActive === true) {
      let request = new Request(
        `json/msm_sample_data_${(demoTickCount + "").padStart(5, "0")}.json`
      );
      fetch(request, init)
        .then(function(response) {
          return response.json();
        })
        .then(function(content) {
          storeReadings.set(content.readings);
          storeSensors.set(content.sensors);
          storeTypes.set(getTypes());
        });
    }
  });

  function getTypes() {
    return [
      {
        name: "NONE",
        type: 0,
        desc: "None",
        icon: "fal fa-times-circle fa-fw"
      },
      {
        name: "TEMP",
        type: 1,
        desc: "Temperatures",
        icon: "fal fa-thermometer-half fa-fw"
      },
      {
        name: "VOLT",
        type: 2,
        desc: "Voltages",
        icon: "fal fa-bolt fa-fw"
      },
      {
        name: "FAN",
        type: 3,
        desc: "Fans",
        icon: "fal fa-fan fa-fw"
      },
      {
        name: "CURRENT",
        type: 4,
        desc: "Currents",
        icon: "fal fa-wave-square fa-fw"
      },
      {
        name: "POWER",
        type: 5,
        desc: "Power",
        icon: "fal fa-car-battery fa-fw"
      },
      {
        name: "CLOCK",
        type: 6,
        desc: "Clocks",
        icon: "far fa-clock fa-fw"
      },
      {
        name: "USAGE",
        type: 7,
        desc: "Usages",
        icon: "fal fa-chart-pie fa-fw"
      },
      {
        name: "OTHER",
        type: 8,
        desc: "Other",
        icon: "fal fa-share-alt fa-fw"
      }
    ];
  }

  function onError(error) {
    if (typeof window.stackBarBottom === "undefined") {
      window.stackBarBottom = {
        dir1: "up",
        firstpos1: 0,
        spacing1: 0
      };
    }

    if (window.permanotice) {
      window.permanotice.open();
    } else {
      demoModeActive = true;
      window.permanotice = PNotify.error({
        title: "Demo Mode",
        text: "Server Offline",
        hide: false,
        width: 200,
        icon: "fad fa-wifi-slash fa-2x fa-fw",
        textTrusted: true,
        addClass: "stack-bar-bottom",
        cornerClass: "ui-pnotify-sharp",
        shadow: false,
        width: "100%",
        stack: window.stackBarBottom,
        modules: {
          Buttons: {
            closer: false,
            sticker: false,
            classes: {
              closer: "fas fa-bomb fa-fw",
              pinUp: "fas fa- fa-fw",
              pinDown: "fas fa-hourglass fa-fw"
            }
          },
          Mobile: {
            swipeDismiss: false
          }
        }
      });
    }
  }

  function closeNavigation() {
    $storeIsNavigationOpen = false;
  }
</script>

<div id="minty-sensor-server" />

<Hamburger />

<aside>
  <div class="drawer-container">
    <Drawer variant="modal" bind:this={sideNav} bind:open={sideNavOpen}>
      <Navigation />
    </Drawer>
    <Scrim on:click={() => closeNavigation()} />
    <AppContent class="app-content">
      <main
        class="main-content"
        bind:this={mainContent}
        class:open={sideNavOpen}
        class:close={!sideNavOpen}>
        <Router {routes} />
      </main>
    </AppContent>
  </div>
</aside>
