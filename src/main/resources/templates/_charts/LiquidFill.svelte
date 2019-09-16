<svg id={id} width="97%" height="250"></svg>
<style>
    svg {
        opacity: 0.5;
    }

</style>
<script language="JavaScript">
    import {
        beforeUpdate
    } from 'svelte';

    export let data;
    $: data;

    export let id = "liquid-fill-" + Math.random().toString(36).replace(/[^a-z]+/g, '').substr(2, 10);
    let gauge;

    beforeUpdate(() => {
        if (data) {
            if (!gauge) {
                gauge = loadLiquidFillGauge(id, data, getConfig());
            }
            gauge.update(data);
        }
    });

    function getConfig() {
        //https://gist.github.com/brattonc/5e5ce9beee483220e2f6
        let config = liquidFillGaugeDefaultSettings();
        config.circleColor = "#6bb9f0";
        config.textColor = "#3498db";
        config.waveTextColor = "#3498db";
        config.waveColor = "#89c4f4";
        config.circleThickness = 0.1;
        config.textVertPosition = 0.2;
        config.waveAnimateTime = 1000;
        config.waveAnimate = true;
        config.waveRise = true;
        config.waveRiseTime = 2000;
        config.displayPercent = false;
        config.waveCount = 3;
        config.textVertPosition = 0.52;
        config.valueCountUp = true;
        config.waveHeightScaling = true;
        config.textSize = 2;
        return config;
    }

</script>
