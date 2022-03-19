<template>
  <Massage-content-detail :is-edit="true" />
</template>

<script>

import MassageContentDetail from './components/MassageContentDetail.vue'

export default {
  name: 'CreateMassageDetail',
  components: { MassageContentDetail }
}
</script>

