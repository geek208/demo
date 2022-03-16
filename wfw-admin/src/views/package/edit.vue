<template>
  <Package-detail :is-edit="true" />
</template>

<script>
import PackageDetail from './components/PackageDetail'

export default {
  name: 'CreatePackageDetail',
  components: { PackageDetail }
}
</script>