<svelte:head>
    <title>Home</title>
</svelte:head>
<style>
    .chart {
        height: 768px;
        position: relative;
        display: inline-block;
        width: 1024px;
    }

</style>

<script>
    import Chart from '../_charts/chartjs/BarChart.svelte';
    import HalfDial from '../_charts/chartjs/HalfDial.svelte';
    import Notification from '../_components/Notification.svelte';
    let data = [1, 2, 3, 4, 5, 6];

</script>

<div class="chart">
    <Chart {data} />
    <HalfDial />
</div>



<Notification type="notice" text="notice message" title="Notice Message" />
<Notification type="info" text="info message" title="Info Message" />
<Notification type="warning" text="warning message" title="Warning Message" />
<Notification type="error" text="error message" title="Error Message" />
<Notification type="success" text="success message" title="Success Message" />





<div class="row ">
    <div class="col s2 m2">
        <div class="card blue-grey darken-1 z-depth-4">
            <div class="card-content white-text">
                <span class="card-title">Card Title</span>
                <p>I am a very simple card. I am good at containing small bits of information.
                    I am convenient because I require little markup to use effectively.</p>
            </div>
        </div>
    </div>
</div>
<h1>Great success!</h1>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris aliquet malesuada feugiat. Curabitur fermentum bibendum nulla, non dictum ipsum tincidunt non. Quisque convallis pharetra tempor. Donec id pretium leo. Pellentesque luctus massa non elit viverra pellentesque. Cras vitae neque molestie, rhoncus ipsum sit amet, lobortis dui. Fusce in urna sem. Vivamus vehicula dignissim augue et scelerisque. Etiam quam nisi, molestie ac dolor in, tincidunt tincidunt arcu. Praesent sed justo finibus,
    fringilla velit quis, porta erat. Donec blandit metus ut arcu iaculis iaculis. Cras nec dolor fringilla justo ullamcorper auctor. Aliquam eget pretium velit. Morbi urna justo, pulvinar id lobortis in, aliquet placerat orci.</p>
<div class="row ">
    <div class="col s2 m2">
        <div class="card blue-grey darken-1 z-depth-4">
            <div class="card-content white-text">
                <span class="card-title">Card Title</span>
                <p>Nulla sollicitudin malesuada ipsum sit amet elementum. Aenean viverra erat a enim consequat dignissim. Aliquam aliquet fringilla nibh, sit amet consectetur turpis convallis vel. Etiam sit amet dignissim nibh, a consectetur tortor. Nunc faucibus aliquet nisi, eget elementum nisi imperdiet rutrum. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi elementum euismod massa, vitae scelerisque arcu malesuada eget. Vivamus varius finibus purus sed posuere.</p>
            </div>
        </div>
    </div>
</div>
<p>Etiam maximus dolor sit amet elit dictum, ut lacinia nibh facilisis. Praesent porta dui et lacus feugiat, et consectetur urna tincidunt. Ut sit amet lobortis lectus. Ut ornare, lorem sit amet ornare condimentum, libero sem efficitur turpis, in convallis elit mi vel enim. Cras convallis massa ex, nec bibendum arcu tempor vel. Sed non ligula laoreet, venenatis ex vitae, lobortis mi. Etiam ante felis, condimentum in erat vitae, maximus gravida nisl. Aenean sed efficitur lacus. Fusce lacinia lacus
    hendrerit, congue dui nec, viverra risus. Nam et lacinia odio, ac finibus risus. Donec facilisis libero elit, id eleifend dui laoreet eget. Donec mattis magna nec nisl accumsan, in luctus ex accumsan. Duis sed dictum ante, luctus posuere lectus. Aenean lacus diam, tempor eget porta sit amet, ornare ut diam. Aenean eget nisl imperdiet, auctor nibh eu, bibendum nulla. Integer scelerisque, orci in gravida lacinia, ante nulla accumsan purus, in ornare lectus orci sit amet leo.</p>

<div class="row ">
    <div class="col s2 m2">
        <div class="card blue-grey darken-1 z-depth-4">
            <div class="card-content white-text">
                <span class="card-title">Card Title</span>
                <p>Nulla vestibulum turpis vel urna rhoncus, eu molestie sem pellentesque. In non egestas augue. Etiam finibus sem magna, quis euismod arcu cursus at. In dignissim purus eu mollis placerat. Sed convallis ornare sagittis. Integer sed metus faucibus, bibendum leo et, fermentum dolor. Donec leo sapien, lacinia cursus fringilla in, gravida id eros. Donec finibus ut purus id convallis. Vestibulum maximus lacus felis, non tempus odio volutpat a. Cras semper rutrum lectus id gravida. Aliquam aliquam
                    faucibus purus, vel commodo enim pretium ut. Vivamus nec urna mi.</p>
            </div>
        </div>
    </div>
</div>
