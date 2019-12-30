import router from '@/modules/router'

const state = {
  authenticationToken: null,
  authorized: false
}

const getters = {
  authorized() {
    return state.authorized;
  }
}

const mutations = {  
  processAuthorize(state, authenticationToken) {
    state.authenticationToken = authenticationToken;
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
  },
  authorize({commit}, authenticationToken) {
    commit('processAuthorize', authenticationToken)
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