import request from '@/utils/request'

export function getRoutes() {
  return request({
    url: '/routes',
    method: 'get'
  })
}

export function notify() {
  return request({
    url: '/notify',
    method: 'get'
  })
}

export function pay(data) {
  return request({
    url: '/pay',
    method: 'post',
    data
  })
}


export function getPayStatus(data) {
    return request({
      url: '/getPayStatus',
      method: 'get',
      data
    })
  }
/**
 * admin 获取user列表
 * @param {} pageable
 */
export function orderList(pageable) {
  return request({
    url: '/orderList',
    method: 'get',
    params: pageable
  })
}

export function updateOrder(id, data) {
  return request({
    url: `/Order/${id}`,
    method: 'put',
    data
  })
}

export function deleteOrder(id) {
  return request({
    url: `/Order/${id}`,
    method: 'delete'
  })
}
