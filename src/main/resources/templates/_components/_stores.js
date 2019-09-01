import {
    writable
} from 'svelte/store';
import {
    readable
} from 'svelte/store';

export const navigationIsOpen = writable(false);
export const selectedThemeColor = writable('#ff0000');
