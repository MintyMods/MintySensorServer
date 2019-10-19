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
  let typeRestrict = "";
  let data = [];
  let selected = [];
  $: showDropZone = false;
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
</script>

<div class="wrapper" on:dragend={event => (showDropZone = false)}>

  {#if showDropZone}
    <div
      class="drop-zone"
      on:drop={event => dragDrop(event)}
      on:dragenter={event => event.target.classList.add('drop-active')}
      on:dragleave={event => event.target.classList.remove('drop-active')}
      on:dragover={event => event.preventDefault()}>
    </div>
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
    <Set chips={getReadings()}  let:chip key={reading => getReadingId(reading)}>
      <Chip 
        selected={isSelected(chip)}
        shouldRemoveOnTrailingIconClick=false
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
    bind:value={typeRestrict}
    label="Filter by type {typeRestrict}">
    {#each $storeTypes as type, index (type.type + '_' + index)}
      <Option value={type.type + '_' + index} selected={false}>
        <Item style="width:100%">
          <FormField class="type-toggle-wrapper">
            <Switch bind:checked={filterTypes[index]} class="type-toggle" />
            <span slot="label">{type.desc}</span>
          </FormField>
          <Icon class="{type.icon} fa-1x type-toggle-icon" />
        </Item>
      </Option>
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
  </Select>

  <Select enhanced bind:value={sensorId} label="Filter by device">
    <Option value=""/>
    {#each $storeSensors as sensor}
      <Option
        value={getSensorId(sensor)}
        selected={getSensorId(sensor) === sensorId}>
        {sensor.label.desc}
      </Option>
    {/each}
  </Select>

</div>
