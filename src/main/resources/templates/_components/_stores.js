import {
    writable
} from 'svelte/store';
import {
    readable
} from 'svelte/store';

export const storeIsNavigationOpen = writable(false);
export const storeSelectedThemeColor = writable('#ff0000');
export const storeLastNetworkPing = writable(new Date());
export const storeLastNetworkPong = writable(new Date());
