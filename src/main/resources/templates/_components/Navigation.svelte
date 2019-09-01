<style>
    .logo,
    .logo-hover {
        transition: all 0.8s cubic-bezier(0.175, 0.885, 0.32, 1.275);
        -webkit-transition: -webkit-transform all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
    }

    .logo {
        width: 100%;
        height: 100px;
        text-align: justify;
        transform: scale3d(1, 1, 1);
    }

    .logo-hover {
        transform: scale3d(0.7, 0.7, 0.7);
        filter: alpha(opacity=0.5);
        opacity: 0.5;
        z-index: -1;
    }

    .logo-wrapper {
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
        cursor: pointer;
    }

    .fad.fa-fw:before,
    .fad.fa-stack-1x:before,
    .fad.fa-stack-2x:before {
        left: inherit;
        -webkit-transform: translateX(0);
        transform: translateX(0);
    }

    .fa-times-circle {
        font-size: 2em;
    }

    .logo:after {
        content: "";
        display: inline-block;
        width: 100%;
    }

    #navigation-close {
        position: absolute;
        right: 5px;
        top: 70px;
        color: rgba(38, 166, 154, .5);
        transform: scale3d(1, 1, 1);
        transition: all 0.5s ease;
        -webkit-transition: -webkit-transform all 0.5s ease;
    }

    #navigation-close.closeHover {
        position: absolute;
        right: 40px;
        top: 40px;
        filter: alpha(opacity=1) !important;
        opacity: 1 !important;
        transform: scale3d(3.5, 3.5, 3.5);
        transition: all 0.5s ease;
        -webkit-transition: -webkit-transform all 0.5s ease;
        z-index: 1;
    }

    .sidenav a>i {
        font-size: 2em;
        color: inherit;
        transition: all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
        -webkit-transition: -webkit-transform all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
        margin-right: 20px;
        vertical-align: middle;
        padding-right: 10px;
    }

    .collection-item.active>i {
        transform: translate3d(0px, 0px, 1px) rotateY(20deg) scale3d(1.7, 1.7, 2);
        color: inherit;
        transition: all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
        -webkit-transition: -webkit-transform all 0.6s cubic-bezier(0.175, 0.885, 0.32, 1.275);
    }

    .collection {
        width: 100%;
        margin: 0px !important;
        /*        max-width: none !important;*/
        perspective: 300px;
        -webkit-perspective: 300px;
    }

</style>

<script>
    import {
        onMount
    } from 'svelte';
    import {
        navigationIsOpen
    } from './_stores.js';
    import Logo from './Logo.svelte';

    export let segment;
    let navIsOpenStoreValue;
    let instance;
    let closeHover;
    let menuHover;

    const unsubscribe = navigationIsOpen.subscribe(value => {
        navIsOpenStoreValue = value;
    });
    onMount(() => {
//        var options = {
//            onOpenStart: function() {
//                navigationIsOpen.set(true);
//            },
//            onCloseStart: function() {
//                navigationIsOpen.set(false);
//            },
//            preventScrolling: false
//        };
//        instance = M.Sidenav.init(document.getElementById('slide-out'), options);
    });

</script>

<ul id="slide-out" class="slide-out sidenav z-depth-4">
    <ul class="logo-wrapper sidenav-close" on:mouseover="{()=>closeHover=true}" on:mouseout="{()=>closeHover=false}">
        <li>
            <div class:logo-hover={closeHover} class="logo">
                <Logo />
            </div>
        </li>
        <li>
            <span id="navigation-close" class:closeHover class="fad fa-times-circle close waves-effect"></span>
        </li>
    </ul>
    <div class="collection">
        <a href="/demo" class="collection-item waves-effect {(segment === 'demo' || segment === undefined ) ? 'active' : ''}"><i class="fa-fw fad fa-home"></i>Home</a>
        <a href="/about" class="collection-item waves-effect {segment === 'about' ? 'active' : ''}"><i class="fa-fw fad fa-question"></i>About</a>
        <a href="/views" class="collection-item waves-effect {segment === 'views' ? 'active' : ''}"><i class="fa-fw fad fa-eye"></i>Views</a>
        <a href="/sensors" class="collection-item waves-effect {segment === 'sensors' ? 'active' : ''}"><i class="fa-fw fad fa-compress-arrows-alt"></i>Sensors</a>
        <a href="/readings" class="collection-item waves-effect {segment === 'readings' ? 'active' : ''}"><i class="fa-fw fad fa-tachometer-alt-average"></i>Readings</a>
        <a href="/devices" class="collection-item waves-effect {segment === 'devices' ? 'active' : ''}"><i class="fa-fw fad fa-digital-tachograph"></i>Devices</a>
        <a href="/hosts" class="collection-item waves-effect {segment === 'hosts' ? 'active' : ''}"><i class="fa-fw fad fa-network-wired"></i>Hosts</a>
        <a href="/providers" class="collection-item waves-effect {segment === 'providers' ? 'active' : ''}"><i class="fa-fw fad fa-podcast"></i>Providers</a>
        <a href="/settings" class="collection-item waves-effect {segment === 'settings' ? 'active' : ''}"><i class="fa-fw fad fa-user-cog"></i>Settings</a>
        <a href="/testing" class="collection-item waves-effect {segment === 'testing' ? 'active' : ''}"><i class="fa-fw fad fa-vial"></i>Testing</a>
    </div>
</ul>
