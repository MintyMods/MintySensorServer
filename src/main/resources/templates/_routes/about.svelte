<svelte:head>
    <title>About</title>
</svelte:head>

<h1>About this site</h1>

<p>This is the 'about' page. There's not much here.</p>
<div class="card-panel hoverable"> Hoverable Card Panel</div>


<div class="card">
    <div class="card-content">
        <div class="card-title">Stacked Bar Chart</div>
        <div class="chart-wrapper">
            <div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                <div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                    <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                </div>
                <div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                    <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                </div>
            </div>
            <canvas id="stacked-bar-chart" width="486" height="486" class="chartjs-render-monitor" style="display: block; width: 486px; height: 486px;"></canvas>
        </div>
    </div>
</div>

<div class="card">
    <div class="card-stacked">
        <div class="card-metrics card-metrics-static">
            <div class="card-metric">
                <div class="card-metric-title">Revenue</div>
                <div class="card-metric-value">$12,476.00</div>
                <div class="card-metric-change increase">
                    <i class="material-icons left">keyboard_arrow_up</i>
                    12%
                </div>
            </div>
        </div>
    </div>
    <div class="card-chart">
        <div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
            <div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
            </div>
            <div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
            </div>
        </div>
        <canvas id="flush-area-chart-blue" height="100" width="257" class="chartjs-render-monitor" style="display: block; width: 257px; height: 100px;"></canvas>
    </div>
</div>
