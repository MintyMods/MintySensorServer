<!-- Taken from the following issue until the author relases a Svelte 3 version -->
<!-- https://github.com/elcobvg/svelte-autocomplete/issues/9 -->
<script>

		const regExpEscape = (s) => {
			return s.replace(/[-\\^$*+?.()|[\]{}]/g, "\\$&")
		}

			export let name= '';
			export let value= '';
			export let placeholder = '';
			export let required= false;
			export let disabled= false;

			// autocomplete props
			export let items= [];
			export let isOpen= false;
			export let results= [];
			export let search= '';
			export let isLoading= false;
			export let arrowCounter= 0;
	

      let className= '';
      let isAsync= false;
      let minChar= 2;
      let maxItems= 10;
      let fromStart= true; // Default type ahead
			let list;
			let input;
	
			async function onChange (event) {
				// Is the data given by an outside ajax request?
				if (isAsync) {
					isLoading = true;
				} else if (search.length >= Number(minChar)) {
					filterResults()
					isOpen = true;
				}
			}
			function filterResults () {
				results = items.filter(item => {
					if (typeof item !== 'string') {
						item = item.key || '' // Silent fail
					}
					return fromStart ? item.toUpperCase().startsWith(search.toUpperCase())
													 : item.toUpperCase().includes(search.toUpperCase())
				})
				.map(item => {
					const text = typeof item !== 'string' ? item.key : item
					return {
						key: text,
						value: item.value || item,
						label: search.trim() === '' ? text : text.replace(RegExp(regExpEscape(search.trim()), 'i'), "<span>$&</span>")
					}
				});

				const height = results.length > maxItems ? maxItems : results.length
				list.style.height = `${height * 2.25}rem`
			}
    function onKeyDown (event) {
      if (event.keyCode === 40 && arrowCounter < results.length) {
        // ArrowDown
        arrowCounter =  arrowCounter + 1 
      } else if (event.keyCode === 38 && arrowCounter > 0) {
        // ArrowUp
        arrowCounter =  arrowCounter - 1;
      } else if (event.keyCode === 13) {
        // Enter
        event.preventDefault()
        if (arrowCounter === -1) {
          arrowCounter = 0 // Default select first item of list
        }
        close(arrowCounter)
      } else if (event.keyCode === 27) {
        // Escape
        event.preventDefault()
        close()
      }
    }
    function close (index = -1) {
      isOpen = false; 
			arrowCounter = -1;
     	input.blur();
      if (index > -1) {
      	value = results[index].value;
				key = results[index].key;
      } else if (!value) {
        search = ''
      }
    }
  function onupdate ({ changed, current }) {
    if (isAsync && changed.items && current.items.length) {
       items = current.items;
       isLoading = false;
       isOpen = true;
       filterResults();
    }
	}
</script>

<style>
  * {
    box-sizing: border-box;
  }

  input {
    height: 2rem;
    font-size: 1rem;
    padding: 0.25rem 0.5rem;
  }

  .autocomplete {
    position: relative;
  }

  .hide-results {
    display: none;
  }

  .autocomplete-results {
    padding: 0;
    margin: 0;
    border: 1px solid #dbdbdb;
    height: 6rem;
    overflow: auto;
    width: 100%;

    background-color: white;
    box-shadow: 2px 2px 24px rgba(0, 0, 0, 0.1);
    position: absolute;
    z-index: 100;
  }

  .autocomplete-result {
    color: #7a7a7a;
    list-style: none;
    text-align: left;
    height: 2rem;
    padding: 0.25rem 0.5rem;
    cursor: pointer;
  }

  .autocomplete-result > :global(span) {
    background-color: none;
    color: #242424;
    font-weight: bold;
  }

  .autocomplete-result.is-active,
  .autocomplete-result:hover {
    background-color: #dbdbdb;
  }
</style>
<svelte:window on:click="{()=>close()}" />
<div on:click="{(event)=>event.stopPropagation()}" class="autocomplete">
  <input
    type="text"
    class="{className}"
    {name}
    {placeholder}
    {required}
    {disabled}
    value="{value || ''}"
    autocomplete="{name}"
    bind:value="{search}"
    on:input="{(event)=>onChange(event)}"
    on:focus
    on:blur
    on:keydown="{(event)=>onKeyDown(event)}"
    bind:this={input}
  >
  <ul class="autocomplete-results{!isOpen ? ' hide-results' : ''}" bind:this={list}>
		{#each results as result, i}
				<li on:click="{()=>close(i)}" class="autocomplete-result{ i === arrowCounter ? ' is-active' : '' }">
				{@html result.label}
				</li>
		{/each}
  </ul>
{#if isLoading}
  <slot>
    <p class="fallback">Loading data...</p>
  </slot>
{/if}
</div>