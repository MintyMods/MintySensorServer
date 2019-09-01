<!--<section>-->
<h1>Views - Masonry, with rounded shapes:</h1>
<div>
    <ImageList class="my-image-list-masonry" masonry>
        {#each Array(35) as _unused, i}
        <Item>
          <Image src="https://via.placeholder.com/190x{getUnevenImageSize(i, 107, 200, Math.abs)}.png?text=190x{getUnevenImageSize(i, 107, 200, Math.abs)}" alt="Image {i + 1}" />
          <Supporting>
            <Label>Image {i + 1}</Label>
          </Supporting>
        </Item>
      {/each}
    </ImageList>
  </div>
<!--</section>-->
<script>
  import ImageList, {Item, ImageAspectContainer, Image, Supporting, Label} from '@smui/image-list';
  import Div from '@smui/common/Div.svelte';
  import './_views.scss';

  function getUnevenImageSize(counter, base, variance, preAdd = num => num) {
    const mid = (counter % 2 ? Math.cos : Math.sin)(counter) * variance;
    return base + Math.floor(preAdd(mid));
  }
</script>
