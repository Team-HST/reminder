const state = {
  authorized: false
}

const getters = {
  authorized() {
    return state.authorized;
  }
}

const mutations = {  
}

const actions = {}

export default {
  // 네임스페이스로 분할화된 모듈 처리
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}