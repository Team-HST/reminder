import router from '@/router'
import axios from 'axios'

const state = {
  authenticationToken: null,
  authorized: false,
  profile: null
}

const getters = {
  authorized() {
    return state.authorized
  },
  getAuthorizeToken() {
    return state.authenticationToken
  }
}

const mutations = {
  processAuthorize(state) {
    state.authorized = true
  },
  processDeAuthorize(state) {
    state.authorized = false
  },
  setAuthorizeToken(state, token) {
    state.authenticationToken = token
  },
  setProfile(state, memberProfile) {
    state.profile = memberProfile
  }
}

const actions = {
  deAuthorize(context) {
    context.commit('processDeAuthorize')
    router.push('/login')
  },
  authorize({ commit }, params) {
    commit('setAuthorizeToken', params.token) 

    axios.get(`/api/members/${params.memberId}`)
      .then((response) => { 
        commit('setProfile', response.data)
        commit('processAuthorize', params)
        router.push('/').catch(()=>{})
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