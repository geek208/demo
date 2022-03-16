<template>
  <User-detail :is-edit="true" />
</template>

<script>

import UserDetail from './components/UserDetail.vue'

export default {
  name: 'CreateUserDetail',
  components: { UserDetail }
}
</script>

