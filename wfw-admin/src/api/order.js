import request from '@/utils/request'

export function getRoutes() {
  return request({
    url: '/routes',
    method: 'get'
  })
}

export function getOrder(id) {
  return request({
    url: `order/${id}`,
    method: 'get'
  })
}

export function getOrders() {
  return request({
    url: '/Orders',
    method: 'get'
  })
}

export function addOrder(data) {
  return request({
    url: '/addorder',
    method: 'post',
    data
  })
}

export function pay(data) {
  return request({
    url: '/pay',
    method: 'post',
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

export function getPayStatus(data) {
  return request({
    url: '/shop/getPayStatus',
    method: 'get',
    params: data,
    _timeout:100,
           onTimeout: (request) => {
                    alert("请求超时");
           }
  })
}

export function successNotice(data) {
  return request({
    url: '/successNotice',
    method: 'get',
    params: data
  })
}

export function deleteOrder(id) {
  return request({
    url: `/Order/${id}`,
    method: 'delete'
  })
}
