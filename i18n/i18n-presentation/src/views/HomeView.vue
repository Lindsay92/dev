<script setup>
</script>

<template>
  <header>
    <h1> I18n Worshop</h1>

    <div class="locale-changer"> <!--Permet de sélectionner la langue qu'on souhaite-->
      <select v-model="$i18n.locale" class="rounded">
        <option v-for="locale in $i18n.availableLocales" :key="`locale-${locale}`" :value="locale">
          {{ locale }}
        </option>
      </select>
    </div>

  </header>
  <main class="container">

    <div class="l10n-examples">
      <div class="labels">
        <h3>Labels</h3>
        {{ $t('greetings')}}
      </div>

      <div class="dates">
        <h3>Dates</h3>
        {{ $d(Date.now(), 'long') }}
      </div>

      <div class="currency">
        <h3>Currencies</h3>
        {{ $n(100, 'currency') }}
      </div>
    </div>
  </main>
</template>
<style>
header {
  padding: 1rem 2rem;
  color: white;
  background-color: maroon;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

h3 {
  font-size: 1.5rem;
}

.labels,
.dates,
.currency {
  margin-bottom: 2rem;
}
</style>