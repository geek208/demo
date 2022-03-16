<template>
  <Package-Detail :is-edit="false" />
</template>

<script>
import PackageDetail from './components/PackageDetail'

export default {
  name: 'CreatePackageDetail',
  components: { PackageDetail }
}
</script>