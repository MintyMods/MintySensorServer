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

export const ROUTES = [
    { path: "settings", component: Settings, icon: "fa-fw fad fa-user-cog fa-2x", desc: "Settings" },
    { path: "sensors", component: Sensors, icon: "fa-fw fad fa-compress-arrows-alt fa-2x", desc: "Sensors" },
    { path: "readings", component: Readings, icon: "fa-fw fad fa-tachometer-alt-average fa-2x", desc: "Readings" },
    { path: "providers", component: Providers, icon: "fa-fw fad fa-podcast fa-2x", desc: "Providers" },
    { path: "notifications", component: Notifications, icon: "fa-fw fad fa-bell fa-2x", desc: "Notifications" },
    { path: "views", component: Views, icon: "fa-fw fad fa-eye fa-2x", desc: "Views" },
    { path: "hosts", component: Hosts, icon: "fa-fw fad fa-network-wired fa-2x", desc: "Hosts" },
    { path: "devices", component: Devices, icon: "fa-fw fad fa-digital-tachograph fa-2x", desc: "Devices" },
    { path: "index", component: About, icon: "fa-fw fad fa-question fa-2x", desc: "About" },
    { path: "404", component: NotFound, icon: "fa-fw fad fa-info fa-2x", desc: "404" },
    { path: "/", component: About }
];

