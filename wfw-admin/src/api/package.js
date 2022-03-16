import request from '@/utils/request'

export function getRoutes() {
  return request({
    url: '/routes',
    method: 'get'
  })
}

/**
 * admin 获取user列表
 * @param {} pageable
 */
export function packageList(pageable) {
  return request({
    url: '/packageList',
    method: 'get',
    params: pageable
  })
}

export function packageListAll(pageable) {
  return request({
    url: '/packageListAll',
    method: 'get',
    params: pageable
  })
}

export function getPackage(id) {
  return request({
    url: `plan/${id}`,
    method: 'get'
  })
}

// /**
//  * 获取一个server
//  * @param {} id
//  */
// export function getServerConfig(id) {
//   return request({
//     url: `serverConfig/${id}`,
//     method: 'get'
//   })
// }

export function addPackage(data) {
  return request({
    url: '/addpackage',
    method: 'post',
    data
  })
}

// export function addServerConfig(data) {
//   return request({
//     url: 'serverConfig',
//     method: 'post',
//     data
//   })
// }

// export function updatePackage(id, data) {
//   return request({
//     url: `/Package/${id}`,
//     method: 'put',
//     data
//   })
// }

/**
 * 更新
 * @param {} data
 */
export function updatePackage(data) {
  return request({
    url: 'plan',
    method: 'put',
    data
  })
}

//updatePackageStatus
export function updatePackageStatus(id, data) {
  return request({
    url: `/plan/${id}`,
    method: 'put',
    data
  })
}


export function deletePackage(id) {
  return request({
    url: `/plan/${id}`,
    method: 'delete'
  })
}
