import request from '@/utils/request'

export function postfields(data) {
  return request({
    url: '/wfwactivity/apply',
    method: 'post',
    data
  })
}
/**
 * 更新
 * @param {} data
 */
export function updateMessage(data) {
  return request({
    url: 'message',
    method: 'put',
    data
  })
}

/**
 * 获取一个server
 * @param {} id
 */
export function getMessage(id) {
  return request({
    url: `message/${id}`,
    method: 'get'
  })
}

/**
 * list
 * @param {int}} page
 * @param {int} pageSize
 */
export function startprocess(id) {
  return request({
    url: `/wfwactivity/startProcess/${id}`,
    method: 'get',
  })
}


/**
 * list
 * @param {} id
 */
 export function listprocess(id) {
  return request({
    url: `/wfwactivity/getProcessByFlowId/${id}`,
    method: 'get',
   })
}


/**
 * 删除
 * @param {*} id
 */
export function deleteMessage(id) {
  return request({
    url: `message/${id}`,
    method: 'DELETE'
  })
}
