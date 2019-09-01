import {
    writable
} from 'svelte/store';
import {
    readable
} from 'svelte/store';

export const storeIsNavigationOpen = writable(false);
export const selectedThemeColor = writable('#ff0000');
