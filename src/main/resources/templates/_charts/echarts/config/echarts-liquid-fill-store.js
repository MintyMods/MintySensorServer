import { writable, readable } from 'svelte/store';

export const color = writable( '#294D99' );
export const center = writable([ '50%', '50%' ]);
export const radius = writable('50%');
export const amplitude = writable('8%');
export const waveLength = writable('80%');
export const period = writable('auto');
export const direction = writable('right');
export const shape = writable('roundRect');
export const waveAnimation = writable(true);
export const animationEasing = writable('linear');
export const animationEasingUpdate = writable('linear');
export const animationDuration = writable(2000);
export const animationDurationUpdate = writable(1000);
export const outlineShow = writable(true);
export const outlineBorderDistance = writable(10);
export const outlineitemStyleColor = writable('red');
export const outlineitemStyleBorderColor = writable('rgba(21,137,200,0.5)');
export const outlineitemStyleBorderWidth = writable(6);
export const outlineitemStyleShadowBlur = writable(0);
export const outlineitemStyleShadowColor = writable('rgba(0, 0, 0, 0.25)');
export const backgroundStyleColor = writable('#E3F7FF');
export const backgroundStyleBorderWidth = writable(1);
export const backgroundStyleBorderColor = writable('#990');
export const backgroundStyleItemStyleShadowBlur = writable(0.5);
export const backgroundStyleItemStyleShadowColor = writable('#090');
export const backgroundStyleItemStyleOpacity = writable(0.5);
export const itemStyleOpacity = writable(0.7);
export const itemStyleShadowBlur = writable(0);
export const itemStyleShadowColor = writable('#000');
export const emphasisItemStyleOpacity = writable(0.8);
export const labelShow = writable(true);
export const labelColor = writable('#000');
export const labelInsideColor = writable('#0f0');
export const labelFontSize = writable(12);
export const labelFontWeight = writable('bold');
export const labelAlign = writable('center');
export const labelBaseline = writable('middle');
export const labelPosition = writable('inside');
