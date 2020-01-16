import router from '@/modules/router'
import axios from 'axios'

const state = {
  authenticationToken: null,
  authorized: false,
  profile: null
}

const getters = {
  authorized() {
    return state.authorized;
  }
}

const mutations = {
  processAuthorize(state, params) {
    state.authenticationToken = params.token
    state.authorized = true
  },
  processDeAuthorize(state) {
    state.authorized = false
  },
  setProfile(state, memberProfile) {
    state.profile = memberProfile
  }
}

const actions = {
  deAuthorize(context) {
    context.commit('processDeAuthorize');
    router.push('/login')
  },
  authorize({ commit }, params) {
    commit('processAuthorize', params)

    let headers = { Authorization: `Bearer ${params.token}`};

    axios.get(`/api/member/${params.memberId}`, { headers })
      .then((response) => { 
        commit('setProfile', response.data)
        router.push('/'); 
      }).catch((e) => console.error(e))
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