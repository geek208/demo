import request from '@/utils/request'

export function addMessage(data) {
  return request({
    url: '/wfwactivity/postFormFields',
    method: 'post',
    data
  })
}
/**
 * 更新
 * @param {} data
 */
export function updateActivity(data) {
  return request({
    url: '/wfwactivity/updateActivity',
    method: 'post',
    data
  })
}

/**
 * 获取一个server
 * @param {} id
 */
export function getActivity(id) {
  return request({
    url: `/wfwactivity/getActivity/${id}`,
    method: 'get'
  })
}

export function getUsers(id) {
  return request({
    url: `/wfwuser/getUserList/${id}`,
    method: 'get'
  })
}

export function getRoles(id) {
  return request({
    url: `/wfwuser/getRoleList/${id}`,
    method: 'get'
  })
}
export function getOrgs(id) {
  return request({
    url: `/wfwuser/getOrgList/${id}`,
    method: 'get'
  })
}

/**
 * list
 * @param {} id
 */
export function listActivity(id) {
  return request({
    url: `/wfwactivity/getActivityList/${id}`,
    method: 'get',
 
  })
}


/**
 * list
 * @param {int}} page
 * @param {int} pageSize
 */
 export function listDoneTask(page) {
  return request({
    url: `/wfwactivity/getMyTaskDoneList`,
    method: 'get',
    params: page
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

/**
 * list
 * @param {} id
 */
 export function getfieldList(id) {
  return request({
    url: `/wfwactivity/getFormFields/${id}`,
    method: 'get',
   })
}