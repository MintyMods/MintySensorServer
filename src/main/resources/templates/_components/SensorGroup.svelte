<script>
  import "./_scss/_sensorGroup.scss";
  import {
    storeReadings,
    storeSensors,
    storeTypes
  } from "../_stores/main-state.js";
  import Select, { Option } from "@smui/select";
  import Textfield, { Input } from "@smui/textfield";
  import FloatingLabel from "@smui/floating-label";
  import LineRipple from "@smui/line-ripple";
  import Switch from "@smui/switch";
  import FormField from "@smui/form-field";
  import Dialog, { Actions, InitialFocus } from "@smui/dialog";
  import Button from "@smui/button";
  import Chip, { Set, Icon, Text } from "@smui/chips";
    import MenuSurface, {Anchor} from '@smui/menu-surface';
  import List, {
    Item,
    Graphic,
    Meta,
    Label,
    Separator,
    PrimaryText,
    SecondaryText
  } from "@smui/list";

  let filterTypes = new Array(9).fill(false);
  let data = [];
  let selected = [];

  $: showDropZone = true;
  $: data = $storeReadings.filter(reading => isSelected(reading));
  $: filterText = "";
  $: sensorId = "";

  function matches(chip) {
    let sensor = $storeSensors[chip.index];
    if (sensorId !== "") {
      if (getSensorId(sensor) !== sensorId) {
        return false;
      }
    }
    if (filterText !== "") {
      let dump = chip.label.value + " " + chip.label.desc + " " + chip.unit;
      if (dump.toLowerCase().indexOf(filterText.toLowerCase()) === -1) {
        return false;
      }
    }
    if (filterTypes && filterTypes.some(enabled => enabled === true)) {
      return filterTypes[chip.type];
    }
    return true;
  }

  function getReadingId(reading) {
    let sensor = $storeSensors[reading.index];
    return reading.id + "_" + sensor.id + "_" + sensor.instance;
  }
  function getSensorId(sensor) {
    return sensor.id + "_" + sensor.instance;
  }

  $: getReadings = () => {
    return $storeReadings.filter(reading => matches(reading));
  };

  function removeReading(reading) {
    selected = selected.filter(item => {
      return !(reading.id === item.id && reading.index === item.index);
    });
  }

  function isSelected(reading) {
    for (let i = 0; i < selected.length; i++) {
      let item = selected[i];
      if (reading.id === item.id && reading.index === item.index) {
        return true;
      }
    }
    return false;
  }

  function dragStart(event, reading) {
    event.dataTransfer.effectAllowed = "link";
    event.dataTransfer.dropEffect = "link";
    event.dataTransfer.setData("application/json", JSON.stringify(reading));
    showDropZone = true;
  }

  function dragDrop(event) {
    if (event.stopPropagation) event.stopPropagation();
    showDropZone = false;
    let payload = JSON.parse(event.dataTransfer.getData("application/json"));
    selected.push(payload);
  }
  function showSelectedTypes() {
    let icons = "";
    let select = document.getElementById("filterTypeSelect");
    if (select) {
      let desc = select.querySelector(".mdc-select__selected-text");
      for (let i = 0; i < filterTypes.length; i++) {
        if (filterTypes[i]) {
          icons += "<i class='" + $storeTypes[i].icon + "' />";
        }
      }
      desc.innerHTML = "<div class='selected-type-container'>" + icons + "</div>";
    }
  }

  $: if (filterTypes) {
    showSelectedTypes();
  }
</script>

<style>
:global(.selected-type-container) {
    letter-spacing: 10px !important;
}
</style>

<div class="wrapper" >

  {#if showDropZone}
    <div
      class="drop-zone"
      on:drop={event => dragDrop(event)}
      on:dragenter={event => event.target.classList.add('drop-active')}
      on:dragleave={event => event.target.classList.remove('drop-active')}
      on:dragover={event => event.preventDefault()} />
  {/if}

  <div class="data">
    <List dense threeLine singleSelection class="data-list">
      {#each data as reading (getReadingId(reading))}
        <Item selected="isSelected(reading)">
          <Graphic>
            <i class="{$storeTypes[reading.type].icon} fa-2x" />
          </Graphic>
          <Text>
            <PrimaryText>{reading.label.desc}</PrimaryText>
            <SecondaryText>
              {$storeSensors[reading.index].label.desc}
            </SecondaryText>
            <SecondaryText>{reading.value} {reading.unit}</SecondaryText>
          </Text>
          <Meta>
            <i
              class="fal fa-trash-alt filter-group-delete"
              on:click={() => removeReading(reading)} />
          </Meta>
        </Item>
        <Separator />
      {/each}
      {#if selected.length === 0}
        <Item disabled>
          <Text class="center">
            <SecondaryText />
            <PrimaryText style="text-align:center">
              No Active Readings
            </PrimaryText>
            <SecondaryText>drag-&-drop a sensor reading here</SecondaryText>
          </Text>
        </Item>
      {/if}
    </List>
  </div>

  <div class="readings-container">
    <Set chips={getReadings()} let:chip key={reading => getReadingId(reading)}>
      <Chip
        selected={isSelected(chip)}
        shouldRemoveOnTrailingIconClick="false"
        class="chip"
        draggable="true"
        on:dragstart={event => dragStart(event, chip)}>
        <Text>{chip.label.desc}</Text>
        <div class="chip-wrapper">
          <span class="chip-reading-value">{chip.value}</span>
          <span class="chip-reading-unit">{chip.unit}</span>
        </div>
        <Icon class={$storeTypes[chip.type].icon} trailing tabindex="0" />
      </Chip>
    </Set>
  </div>

  <div class="icon-align-wrapper">
    <Icon
      on:click={() => (filterText = '')}
      class="fal fa-trash-alt filter-text-delete" />
    <Textfield
      fullwidth
      withTrailingIcon="true"
      bind:value={filterText}
      label="Search" />
  </div>

  <Select
    enhanced
    id="filterTypeSelect"
    label="Filter by type">
    <MenuSurface static>
      {#each $storeTypes as type, index (type.type + '_' + index)}
          <Item style="width:100%">
            <FormField class="type-toggle-wrapper">
              <Switch bind:checked={filterTypes[index]}  />
              <span class="type-toggle" slot="label">{type.desc}</span>
            </FormField>
            <Icon class="{type.icon} fa-1x type-toggle-icon" />
          </Item>
      {/each}
    <Actions>
      <Button
        action="none"
        on:click={() => (filterTypes = filterTypes.fill(false))}>
        <Label>Select None</Label>
      </Button>
      <Button
        action="all"
        on:click={() => (filterTypes = filterTypes.fill(true))}>
        <Label>Select All</Label>
      </Button>
    </Actions>
    </MenuSurface>
  </Select>

  <Select enhanced bind:value={sensorId} label="Filter by device">
    <Option value="" />
    {#each $storeSensors as sensor}
      <Option
        value={getSensorId(sensor)}
        selected={getSensorId(sensor) === sensorId}>
        {sensor.label.desc}
      </Option>
    {/each}
  </Select>

</div>
