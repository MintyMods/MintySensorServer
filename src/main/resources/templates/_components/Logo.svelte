<style>
    .logo {
        text-shadow: 0 0 5px rgba(0, 0, 0, 1);
        font-weight: 600;
        position: relative;
        font-size: 2.5em;
        text-align: center;
        color: rgba(38, 166, 154, 1);
    }

    .logo::before {
        position: absolute;
        font-family: 'Font Awesome 5 Pro';
        content: "\f126";
        transform: rotate(130deg);
        font-weight: 400;
        font-size: 3.5em;
        text-shadow: 0 0 5px rgba(0, 0, 0, 1);
        z-index: -1;
        left: -10px;
        top: 50px;
    }

    .logo-text {
        position: absolute;
        color: rgba(0, 0, 0, 1);
    }

    .logo-alt {
        position: absolute;
        color: rgba(255, 255, 255, 1);
    }

</style>

<div class="logo">
    <div class="logo-text">Minty's Sensor Server</div>
    <div class="logo-alt">Minty's Sensor Server</div>
</div>
