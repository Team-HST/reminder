import router from '@/modules/router'

const state = {
  authorized: true
}

const getters = {
  authorized() {
    return state.authorized;
  }
}

const mutations = {  
  processAuthorize(state) {
    state.authorized = true
  },
  processDeAuthorize(state) {
    state.authorized = false
  }
}

const actions = {
  deAuthorize(context) {
    context.commit('processDeAuthorize');
    router.push('/login')
  }
}

export default {
  // 네임스페이스로 분할화된 모듈 처리
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}