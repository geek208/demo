<template>
  <Massage-content-detail :is-edit="false" />
</template>

<script>

import MassageContentDetail from './components/MassageContentDetail.vue'

export default {
  name: 'CreateMassageDetail',
  components: { MassageContentDetail }
}
</script>
